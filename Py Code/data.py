import json
import requests
import datetime
import connection

class Data:
    __dbUtils=connection.DbUtils()

#设置url，header，请求获取result
    def get_qichaunyang_request(self):
        url = 'https://c.m.163.com/ug/api/wuhan/app/data/list-total'

        headers = {
            'accept': '*/*',
            'accept-encoding': 'gzip,deflate,br',
            'accept-language': 'en-US,en;q=0.9,zh-CN;q = 0.8,zh;q = 0.7',
            'origin': 'https://wp.m.163.com',
            'referer': 'https://wp.m.163.com/',
            'sec-fetch-dest': 'empty',
            'sec-fetch-mode': 'cors',
            'sec-fetch-site': 'same-ite',
            'user-agent': 'Mozilla/5.0(WindowsNT10.0;Win64;x64) AppleWebKit/37.36 (KHTML, likeGecko) Chrome/82.0.4056.0 Safari/537.36 Edg/82.0.432.3'
        }

        result = requests.get(url, headers=headers)
        return result


    def get_qichaunyang_request2(self):
        url = 'https://lab.isaaclin.cn/nCoV/api/area?latest=1'

        headers = {
            'accept': '*/*',
            'accept-encoding': 'gzip,deflate,br',
            'accept-language': 'en-US,en;q=0.9,zh-CN;q = 0.8,zh;q = 0.7',
            'origin': 'https://wp.m.163.com',
            'referer': 'https://wp.m.163.com/',
            'sec-fetch-dest': 'empty',
            'sec-fetch-mode': 'cors',
            'sec-fetch-site': 'same-ite',
            'user-agent': 'Mozilla/5.0(WindowsNT10.0;Win64;x64) AppleWebKit/37.36 (KHTML, likeGecko) Chrome/82.0.4056.0 Safari/537.36 Edg/82.0.432.3'
        }
        result = requests.get(url, headers=headers)
        return result



#清除所有爬取数据所在的表（重新爬取，插入最新的数据）
    def do_clean_table(self):
        test=Data.__dbUtils.__enter__() #获取操作数据库的游标
        sql1='delete  from province_data'
        sql2='delete  from china_daily_data'
        sql3='delete from china_total_data'
        sql4='delete from global_today_data'
        sql5='delete from global_total_data'
        sql6='delete from global_data'
        test.execute(sql1)
        test.execute(sql2)
        test.execute(sql3)
        test.execute(sql4)
        test.execute(sql5)
        test.execute(sql6)
        test.connection.commit()
        Data.__dbUtils.close_conn()
        print("疫情数据表已清空！")

    # 解析全球数据并插入数据库
    def get_global_data(self):
        test = Data.__dbUtils.__enter__()  # 获取游标
        result = Data().get_qichaunyang_request2()
        json_str = json.loads(result.text)['results']  # 转换为字典，并获取data的字典
        id=0
        for dict in json_str:
            sql='insert into global_data(id,countryName,provinceName,countryEnglishName,confirmedCount,currentConfirmedCount,curedCount,deadCount) values (%s,%s,%s,%s,%s,%s,%s,%s);'
            countryName=dict['countryName']
            provinceName=dict['provinceName']
            countryEnglishName=dict['countryEnglishName']
            confirmedCount=dict['confirmedCount']
            currentConfirmedCount=dict['currentConfirmedCount']
            curedCount=dict['curedCount']
            deadCount=dict['deadCount']
            id=id+1;
            test.execute(sql,[id,countryName,provinceName,countryEnglishName,confirmedCount,currentConfirmedCount,curedCount,deadCount])
            test.connection.commit()
        Data.__dbUtils.close_conn()
        print("全球疫情数据插入成功！")

#解析各省疫情数据，并执行插入数据库的操作
    def get_provence_data(self):
        test = Data.__dbUtils.__enter__()  # 获取游标
        result = Data().get_qichaunyang_request()
        json_str = json.loads(result.text)['data']  # 转换为字典，并获取data的字典
        # print(json_str)
        # print(json_str['lastUpdateTime'])
        province_list1 = json_str['areaTree']  # 全球数据
        province_list2 = province_list1[2]  # 中国数据
        province_list = province_list2['children']  # 中国数据中的各省数据
        # print(province_list)
        id = 0;
        for dict in province_list:
            sql = 'insert into province_data (id,province,total_confirm,total_suspect,total_heal,total_dead,today_confirm,today_suspect,today_heal,today_dead,today_lastUpdate) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s);'
            province = dict['name']
            total_confirm = dict['total']['confirm']
            total_suspect = dict['total']['suspect']
            total_heal = dict['total']['heal']
            total_dead = dict['total']['dead']
            today_confirm = dict['today']['confirm']
            if(dict['today']['suspect']==None):
                today_suspect=0
            else:
                today_suspect = dict['today']['suspect']
            today_heal = dict['today']['heal']
            today_dead = dict['today']['dead']
            today_lastUpdate = dict['lastUpdateTime']
            id = id + 1
            #sys.stdout.write(dict['name'] + '  ')
            # print(province,total_confirm, total_suspect,total_heal,total_dead,today_confirm,today_suspect,today_heal,today_dead,today_lastUpdate,id)
            test.execute(sql,
                         [id,province, total_confirm, total_suspect, total_heal, total_dead, today_confirm, today_suspect,
                          today_heal, today_dead, today_lastUpdate])
            test.connection.commit()
        Data.__dbUtils.close_conn()
        print("各省疫情数据插入成功！")

#解析中国每日数据，并执行插入数据库操作
    def get_china_daily_data(self):
        test = Data.__dbUtils.__enter__()  # 获取游标
        result = Data().get_qichaunyang_request()  # 指定接口获取数据
        json_str = json.loads(result.text)['data']
        lastUpdateTime = datetime.datetime.now()  # 获取当前时间
        daily_list = json_str['chinaDayList']  # 中国每天的总体数据
        sql = 'insert into china_daily_data(id,date,today_confirm,today_suspect,today_heal,today_dead,today_severe,today_storeConfirm,today_input,lastUpdateTime) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s); '
        j = 0  # id
        for dict in daily_list:
            j = j + 1
            today = dict['today']  # 所有今日数据
            id = j
            date = dict['date']
            today_confirm = today['confirm']
            today_suspect = today['suspect']
            today_heal = today['heal']
            today_dead = today['dead']
            if(today['severe']==None):
                today_severe=0
            else:
                today_severe = today['severe']
            today_storeConfirm = today['storeConfirm']
            today_input = today['input']
            lastUpdateTime = lastUpdateTime
            test.execute(sql, [id, date, today_confirm, today_suspect, today_heal, today_dead, today_severe, today_storeConfirm,
                               today_input, lastUpdateTime])
            test.connection.commit()
        Data.__dbUtils.close_conn()
        print("中国每日数据插入成功！")

        #        print(id,date,today_confirm,today_suspect,today_heal,today_dead,today_severe,today_storeConfirm,today_input,lastUpdateTime)

#解析中国每日总体数据，并执行插入数据库操作
    def get_china_total_data(self):
        test=Data.__dbUtils.__enter__() #获取数据库操作游标
        result=Data().get_qichaunyang_request() #获取数据
        json_str=json.loads(result.text)['data'] #json字符串转换为字典后，获取‘data’，并生成新的字典
        total_list=json_str['chinaDayList'] #获取chinaDayList list列表
        lastUpdateTime=datetime.datetime.now()
        sql = 'insert into china_total_data (id,date,total_confirm,total_suspect,total_heal,total_severe,total_input,total_storeConfirm,lastUpdateTime) values (%s,%s,%s,%s,%s,%s,%s,%s,%s);'
        j=0
        for dict in total_list:
            j=j+1
            id = j
            total=dict['total'] #获取total字典
            date = dict['date']  # 获取字典
            total_confirm=total['confirm']
            total_suspect=total['suspect']
            total_heal=total['heal']
            if(total['severe']==None):
                total_severe=0
            else:
                total_severe=total['severe']
            total_input=total['input']
            total_storeConfirm=total['storeConfirm']
            lastUpdateTime=lastUpdateTime
            test.execute(sql,[id,date,total_confirm,total_suspect,total_heal,total_severe,total_input,total_storeConfirm,lastUpdateTime])
            test.connection.commit()
            test.connection.commit()
        Data.__dbUtils.close_conn()
        print("中国每日总体数据插入成功！")

#解析全球每日数据
    def get_global_today_data(self):
        test=Data.__dbUtils.__enter__()
        result=Data().get_qichaunyang_request()
        json_str=json.loads(result.text)['data']
        global_list=json_str['areaTree']
        id=0
        for dict in global_list:
            today = dict['today']
            id=id+1
            name=dict['name']
            if(today['confirm']==None):
                today_confirm=0
            else:
                today_confirm=today['confirm']
            if(today['suspect']==None):
                today_suspect=0
            else:
                today_suspect=today['suspect']
            if(today['heal']==None):
                today_heal=0
            else:
                today_heal=today['heal']
            if(today['dead']==None):
                today_dead=0
            else:
                today_dead=today['dead']
            if(today['severe']==None):
                today_severe=0
            else:
                today_severe=today['severe']
            if(today['storeConfirm']==None):
                today_storeConfirm=0
            else:
                today_storeConfirm=today['storeConfirm']
            lastUpdateTime=dict['lastUpdateTime']
            sql='insert into global_today_data (id,name,today_confirm,today_suspect,today_heal,today_dead,today_severe,today_storeConfirm,lastUpdateTime) values (%s,%s,%s,%s,%s,%s,%s,%s,%s);'
            test.execute(sql,[id,name,today_confirm,today_suspect,today_heal,today_dead,today_severe,today_storeConfirm,lastUpdateTime])
            test.connection.commit()
        Data.__dbUtils.close_conn()
        print("全球每日数据插入成功！")

#解析全球每日总体数据
    def get_global_total_data(self):
        test=Data.__dbUtils.__enter__()#获取游标
        result=Data().get_qichaunyang_request()#获取爬虫数据
        json_str=json.loads(result.text)['data']#获取json中的data，并生成新的字典
        global_list=json_str['areaTree']
        id=0
        for dict in global_list:
            total = dict['total'] #获取total字典
            id=id+1
            name=dict['name']
            total_confirm=total['confirm']
            total_suspect=total['suspect']
            total_heal=total['heal']
            total_dead=total['dead']
            total_severe=total['severe']
            if 'input' in total:
                total_input = total['input']
            else:
                total_input=0
            lastUpdateTime = dict['lastUpdateTime']
            sql='insert into global_total_data (id,name,total_confirm,total_suspect,total_heal,total_dead,total_severe,total_input,lastUpdateTime) values (%s,%s,%s,%s,%s,%s,%s,%s,%s);'
            test.execute(sql,[id,name,total_confirm,total_suspect,total_heal,total_dead,total_severe,total_input,lastUpdateTime])
            test.connection.commit()
        Data.__dbUtils.close_conn()
        print("全球每日总体数据插入成功！")














