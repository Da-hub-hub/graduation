import pymysql

class DbUtils:
    __conn=''
    __cursor=''
#初始化数据库连接参数
    def __init__(self,host="localhost",port=3306,user="root",password="Qcy123456",database="graduation"):
        self.host=host
        self.port=port
        self.user=user
        self.password=password
        self.database=database

#设置连接，获取游标
    def __enter__(self):
#与数据库建立连接
        DbUtils.__conn=pymysql.connect(host=self.host,port=self.port,user=self.user,password=self.password,database=self.database)
#获取游标
        DbUtils.__cursor=self.__conn.cursor()
        return DbUtils.__cursor

#关闭数据库连接和游标
    def close_conn(self):
        DbUtils.__conn.close()
        DbUtils.__cursor.close()