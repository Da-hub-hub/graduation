<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>疫情信息</title>
    <link href="${pageContext.request.contextPath}/css/epidemic.css" rel="stylesheet">
    <style type="text/css">
        #body1 {
            background-color: #10AEB5;
        }
    </style>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/bootstrap/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/respond.js"></script>
    <![endif]-->
</head>
<body id="body1">
<noscript>
    <strong>We're sorry but infection-statistic doesn't work properly without JavaScript enabled. Please enable it to continue.</strong>
</noscript>
<div id="app"><h1>疫情分析系统</h1><div id="wrapper"><div class="table"><div style="text-align: left; color: rgb(136, 136, 136);">数据已更新</div><div class="row"><a href="../../global/index.html">全球疫情数据</a></div><div class="el-row" style="margin-left: -12px; margin-right: -12px;"><div class="row"><a href="http://localhost:8080/user/logout"></a></div><div class="el-col el-col-8" style="padding-left: 12px; padding-right: 12px;"><div class="el-card is-always-shadow"><!----><div class="el-card__body"><span class="content-title">昨日确诊</span> <br><div style="margin-top: 5px;"></div><span id="now_affirmed" class="content-number" style="color: rgb(255, 102, 51);">0</span> <br><span class="content-yesterday">前日 <span id="lastday_affirmed" style="color: rgb(255, 102, 51);"><span>+</span>0</span></span></div></div></div><div class="el-col el-col-8" style="padding-left: 12px; padding-right: 12px;"><div class="el-card is-always-shadow"><!----><div class="el-card__body"><span class="content-title">昨日疑似</span> <br><div style="margin-top: 5px;"></div><span id="now_suspected" class="content-number" style="color: rgb(255, 204, 0);">0</span> <br><span class="content-yesterday">前日 <span id="lastday_suspected" style="color: rgb(255, 204, 0);"><span>+</span>0</span></span></div></div></div><div class="el-col el-col-8" style="padding-left: 12px; padding-right: 12px;"><div class="el-card is-always-shadow"><!----><div class="el-card__body"><span class="content-title">昨日死亡</span> <br><div style="margin-top: 5px;"></div><span id="now_dead" class="content-number" style="color: rgb(0, 102, 153);">0</span> <br><span class="content-yesterday">前日 <span id="lastday_dead" style="color: rgb(0, 102, 153);"><span>+</span>0</span></span></div></div></div></div><div class="el-row" style="margin-left: -12px; margin-right: -12px; margin-top: 5px;"><div class="el-col el-col-8" style="padding-left: 12px; padding-right: 12px;"><div class="el-card is-always-shadow"><!----><div class="el-card__body"><span class="content-title">累计确诊</span> <br><div style="margin-top: 5px;"></div><span id="acc_affirmed" class="content-number" style="color: rgb(255, 0, 0);">0</span> <br></div></div></div><div class="el-col el-col-8" style="padding-left: 12px; padding-right: 12px;"><div class="el-card is-always-shadow"><!----><div class="el-card__body"><span class="content-title">累计治愈</span> <br><div style="margin-top: 5px;"></div><span id="acc_cured" class="content-number" style="color: rgb(103, 194, 58);">0</span> <br></div></div></div><div class="el-col el-col-8" style="padding-left: 12px; padding-right: 12px;"><div class="el-card is-always-shadow"><!----><div class="el-card__body"><span class="content-title">累计死亡</span> <br><div style="margin-top: 5px;"></div><span id="acc_dead" class="content-number" style="color: rgb(0, 0, 0);">0</span> <br></div></div></div></div></div></div></div>




<div class="container">
    <div class="row">
        <div class="col-md-12" style="background-color:#fff;margin-bottom: 5px;">
            <div id="myMap" style="height: 600px;"></div>
        </div>
    </div>
    <div class="row" style="height: 400px; overflow: auto;">
        <div class="col-md-16" style="background-color:#fff;">
            <table class="table table-hover table-bordered table-striped">
                <thead>
                <tr>
                    <th>省份</th>
                    <th>确诊人数</th>
                    <th>疑似人数</th>
                    <th>治愈人数</th>
                    <th>死亡人数</th>
                </tr>
                </thead>
                <tbody id="tbody1">

                <thead>
                <tr>
                    <th>前日确诊</th>
                    <th>前日疑似</th>
                    <th>前日死亡</th>
                    <th>前日死亡</th>
                    <th>前日输入</th>
                </tr>
                </thead>
                <tbody id="tbody3">

                <thead>
                <tr>
                    <th>昨日确诊</th>
                    <th>昨日疑似</th>
                    <th>昨日治愈</th>
                    <th>昨日死亡</th>
                    <th>昨日输入</th>
                </tr>
                </thead>
                <tbody id="tbody2">

                <thead>
                <tr>
                    <th>预测今日确诊</th>
                    <th>预测今日疑似</th>
                    <th>预测今日治愈</th>
                    <th>预测今日死亡</th>
                    <th>预测今日输入</th>
                </tr>
                </thead>
                <tbody id="tbody4">


                </tbody>
            </table>
        </div>
    </div>




    <div class="row" style="margin-top: 5px;">
        <div class="col-md-12">
            <div id="mycharts" style="height: 500px;border: 1px solid gray;background-color:#fff;"></div>
        </div>
    </div>

    <div class="row" style="margin-top: 5px;">
        <div class="col-md-12">
            <div id="mycharts2" style="height: 500px;border: 1px solid gray;background-color:#fff;"></div>
        </div>
    </div>

    <div class="row">
        <a href="../../global_epidemic.jsp">全球疫情数据</a>
    </div>
</div>

<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.11.2.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/echarts/echarts.js"></script>
<script type="text/javascript">
    $(function () {
        //获取当前日期
        var myDate = new Date();
        var y = myDate.getFullYear();
        var m = myDate.getMonth()+1;
        var d = myDate.getDate();
        var nowDate = y+"-"+m+"-"+d;
        //定义个用来给表格中装载数据的函数
        var fillToTable = function (epidemics) {
            var acc_affirmed=0;
            var acc_cured=0;
            var acc_dead=0;
            var tbody1 = $("#tbody1");
            tbody1.empty();
            $.each(epidemics, function (index, epidemic) {
                var tr = $("<tr>");
                var td = $("<td>");
                td.text(epidemic.province);
                tr.append(td);
                td = $("<td>");
                td.html("" + epidemic.total_confirm);
                acc_affirmed+=epidemic.total_confirm;
                tr.append(td);

                td = $("<td>");
                td.html("" + epidemic.total_suspect);
                tr.append(td);


                /*td = $("<td>");
                td.html("" + epidemic.isolatedTotal);
                tr.append(td);*/

                td = $("<td>");
                td.html("" + epidemic.total_heal);
                acc_cured+=epidemic.total_heal;
                tr.append(td);

                td = $("<td>");
                td.html("" + epidemic.total_dead);
                acc_dead+=epidemic.total_dead;
                tr.append(td);

                tbody1.append(tr);
            });
            // alert(total);
            document.getElementById("acc_affirmed").innerHTML=acc_affirmed;
            document.getElementById("acc_cured").innerHTML=acc_cured;
            document.getElementById("acc_dead").innerHTML=acc_dead;
        };


        //定义个用来查询今日疫情数据的函数
        var findTodayDate = function (epidemics) {
            var now_affirmed=0;
            var now_suspected=0;
            var now_dead=0;
            var now_heal=0;
            var now_input=0;
            var tbody1 = $("#tbody2");
            tbody1.empty();
            now_affirmed+=epidemics.today_confirm;
            now_suspected+=epidemics.today_suspect;
            now_dead+=epidemics.today_dead;
            now_heal+=epidemics.today_heal;
            now_input+=epidemics.today_input;
            var tr = $("<tr>");
            var td = $("<td>");
            td.html(now_affirmed);
            tr.append(td);

            td = $("<td>");
            td.html(now_suspected);
            tr.append(td);

            td = $("<td>");
            td.html(now_dead);
            tr.append(td);

            td = $("<td>");
            td.html(now_heal);
            tr.append(td);

            td = $("<td>");
            td.html(now_input);
            tr.append(td);

            tbody1.append(tr);

            //填充顶部表格
            if(now_affirmed>0){
                document.getElementById("now_affirmed").innerHTML="+"+now_affirmed;
            }else{
                document.getElementById("now_affirmed").innerHTML="+"+0;
            }


            if(now_suspected>0){
                document.getElementById("now_suspected").innerHTML="+"+now_suspected;
            }else{
                document.getElementById("now_suspected").innerHTML="+"+0;
            }

            if(now_dead>0){
                document.getElementById("now_dead").innerHTML="+"+now_dead;
            }else{
                document.getElementById("now_dead").innerHTML="+"+0;
            }

            if(now_heal>0){
                document.getElementById("now_heal").innerHTML="+"+now_heal;
            }else{
                document.getElementById("now_heal").innerHTML="+"+0;
            }

            if(now_input>0){
                document.getElementById("now_input").innerHTML="+"+now_input;
            }else{
                document.getElementById("now_input").innerHTML="+"+0;
            }
        };




        //定义个用来查询前日疫情数据的函数
        var findYesterdayDate = function (epidemics) {
            var lastday_affirmed=0;
            var lastday_suspected=0;
            var lastday_dead=0;
            var lastday_heal=0;
            var lastday_input=0;
            var tbody1 = $("#tbody3");
            tbody1.empty();
            lastday_affirmed+=epidemics.today_confirm;
            lastday_suspected+=epidemics.today_suspect;
            lastday_dead+=epidemics.today_dead;
            lastday_heal=epidemics.today_heal;
            lastday_input=epidemics.today_input;
            var tr = $("<tr>");
            var td = $("<td>");
            td.html(lastday_affirmed);
            tr.append(td);

            td = $("<td>");
            td.html(lastday_suspected);
            tr.append(td);

            td = $("<td>");
            td.html(lastday_dead);
            tr.append(td);

            td = $("<td>");
            td.html(lastday_heal);
            tr.append(td);

            td = $("<td>");
            td.html(lastday_input);
            tr.append(td);

            tbody1.append(tr);

            //填充顶部表格
            if(lastday_affirmed>0){
                document.getElementById("lastday_affirmed").innerHTML="+"+lastday_affirmed;
            }else{
                document.getElementById("lastday_affirmed").innerHTML="+"+0;
            }


            if(lastday_suspected>0){
                document.getElementById("lastday_suspected").innerHTML="+"+lastday_suspected;
            }else{
                document.getElementById("lastday_suspected").innerHTML="+"+0;
            }

            if(lastday_dead>0){
                document.getElementById("lastday_dead").innerHTML="+"+lastday_dead;
            }else{
                document.getElementById("lastday_dead").innerHTML="+"+0;
            }

            if(lastday_heal>0){
                document.getElementById("lastday_heal").innerHTML="+"+lastday_heal;
            }else{
                document.getElementById("lastday_heal").innerHTML="+"+0;
            }

            if(lastday_input>0){
                document.getElementById("lastday_input").innerHTML="+"+lastday_input;
            }else{
                document.getElementById("lastday_input").innerHTML="+"+0;
            }
        };



        //定义个用来查询今日疫情预测数据的函数
        var findTodayPredicted = function (epidemics) {
            var predictd_affirmed=0;
            var predictd_suspected=0;
            var predictd_dead=0;
            var predicted_heal=0;
            var predicted_input=0;
            var tbody1 = $("#tbody4");
            tbody1.empty();
            predictd_affirmed+=epidemics.today_confirm;
            predictd_suspected+=epidemics.today_suspect;
            predictd_dead+=epidemics.today_dead;
            predicted_heal+=epidemics.today_heal;
            predicted_input+=epidemics.today_input;
            var tr = $("<tr>");
            var td = $("<td>");
            td.html(predictd_affirmed);
            tr.append(td);

            td = $("<td>");
            td.html(predictd_suspected);
            tr.append(td);

            td = $("<td>");
            td.html(predictd_dead);
            tr.append(td);

            td = $("<td>");
            td.html(predicted_heal);
            tr.append(td);

            td = $("<td>");
            td.html(predicted_input);
            tr.append(td);

            tbody1.append(tr);

            //填充顶部表格
            if(predictd_affirmed>0){
                document.getElementById("predictd_affirmed").innerHTML="+"+predictd_affirmed;
            }else{
                document.getElementById("predictd_affirmed").innerHTML="+"+0;
            }


            if(predictd_suspected>0){
                document.getElementById("predictd_suspected").innerHTML="+"+predictd_suspected;
            }else{
                document.getElementById("predictd_suspected").innerHTML="+"+0;
            }

            if(predictd_dead>0){
                document.getElementById("predictd_dead").innerHTML="+"+predictd_dead;
            }else{
                document.getElementById("predictd_dead").innerHTML="+"+0;
            }

            if(predicted_heal>0){
                document.getElementById("predicted_heal").innerHTML="+"+predicted_heal;
            }else{
                document.getElementById("predicted_heal").innerHTML="+"+0;
            }

            if(predicted_input>0){
                document.getElementById("predicted_input").innerHTML="+"+predicted_input;
            }else{
                document.getElementById("predicted_input").innerHTML="+"+0;
            }
        };
        //初始化图表
        var myCharts = echarts.init($("#mycharts").get(0));
        var option = {
            title: {
                text: "当日全国疫情折线图",
            },
            legend: {
                data: [nowDate]
            }
            ,
            xAxis: {
                type: 'category',
                data: []
            }
            ,
            yAxis: {
                type: 'value'
            }
            ,
            series: [{
                type: 'line',
                name: nowDate,
                data: []
            }]
        };
        myCharts.setOption(option);
        //将服务器端返回的数据设置到图表上

        //初始化图表
        var myCharts2 = echarts.init($("#mycharts2").get(0));
        var option = {
            title: {
                text: "当日全国疫情柱状图",
                subtext: nowDate
            },
            grid: {
                show: true
            },
            legend: {
                data: []
            }
            ,
            tooltip: {
                trigger: 'axis'
            }
            ,
            xAxis: {
                type: 'category',
                data: []
            }
            ,
            yAxis: {
                type: 'value'
            }
            ,
            series: [{
                type: 'bar',
                name: nowDate,
                data: []
            }]
        };
        myCharts2.setOption(option);
        //将服务器端返回的数据设置到图表上

        var fillToChart = function (epidemics) {
            var province = [];
            var total_confirm = [];
            $.each(epidemics, function (index, epidemic) {
                province.push(epidemic.province);
                total_confirm.push(epidemic.total_confirm);
            });
            myCharts.setOption({
                xAxis: {
                    data: province
                },
                series: [{
                    data: total_confirm
                }]
            });

            myCharts2.setOption({
                xAxis: {
                    data: province
                },
                series: [{
                    data: total_confirm
                }]
            });

        };
        var myMap = echarts.init($("#myMap").get(0));
        //获取地图json数据，显示中国地图
        $.getJSON("${pageContext.request.contextPath}/echarts/china.json", {}, function (chinaJson) {
            echarts.registerMap("china", chinaJson);
            var option = {
                title: {
                    text: nowDate+" 全国疫情分布图"
                },
                legend: {
                    data: ["累计确诊人数"]
                },
                tooltip: {},
                visualMap: {
                    type: 'piecewise',
                    min: 0,
                    max: 100000,
                    splitList:
                        [{
                            start: 10000,
                            end: 100000
                        },
                            {
                            start: 1000,
                            end: 10000
                        }, {
                            start: 500,
                            end: 1000
                        }, {
                            start: 100,
                            end: 500
                        }, {
                            start: 0,
                            end: 100
                        }],
                    textStyle:
                        {
                            color: 'orange'
                        }
                },
                series: [
                    {
                        name: '累计确诊人数',
                        type: 'map',
                        mapType: 'china',
                        data: []
                    }
                ]
            };
            myMap.setOption(option);
        }, "json");
        //将数据填充到地图中
        var fillToMap = function (epidemics) {
            var data = [];
            $.each(epidemics, function (index, epidemic) {
                var obj = {};
                obj.name = epidemic.province;
                obj.value = epidemic.total_confirm;
                data.push(obj);
            });
            myMap.setOption({
                series: [
                    {
                        name: '累计确诊人数',
                        type: 'map',
                        mapType: 'china',
                        data: data
                    }
                ]
            });
        };
        //发送请求获取最新疫情数据
        $.get("${pageContext.request.contextPath}/province/all", {}, function (resp) {
            if (resp.code < 0) {
                alert(resp.msg);
            } else {
                fillToTable(resp.data);
                fillToChart(resp.data);
                fillToMap(resp.data);
            }
        }, "json");

        //发送请求获取前日疫情数据
        $.get("${pageContext.request.contextPath}/chinaDaily/before", {}, function (resp) {
            if (resp.code < 0) {
                alert(resp.msg);
            } else {
                findYesterdayDate(resp.data);
            }
        }, "json");

        //发送请求获取昨日疫情数据
        $.get("${pageContext.request.contextPath}/chinaDaily/yesterday", {}, function (resp) {
            if (resp.code < 0) {
                alert(resp.msg);
            } else {
                findTodayDate(resp.data);
            }
        }, "json");

        //发送请求获取今日中国疫情预测数据
        $.post("${pageContext.request.contextPath}/predicted/chinaDailyPredictedOut?a1=0.2&Sn=2&n=7", {}, function (resp) {
            if (resp.code < 0) {
                alert(resp.msg);
            } else {
                findTodayPredicted(resp.data);
            }
        }, "json");

    });
</script>
</body>
</html>
