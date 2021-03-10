$(function () {

    var configure_json = $.ajax({url: "world.json",async: false}).responseText;
    var json_data=[{"name": "Italy", "confirm": 27980, "confirmAdd": 3233, "dead": 2158, "heal": 2749}, 
    {"name": "Iran", "confirm": 16169, "confirmAdd": 2231, "dead": 988, "heal": 5389}, 
    {"name": "Spain", "confirm": 11178, "confirmAdd": 3425, "dead": 491, "heal": 571}, 
    {"name": "Dem. Rep. Korea", "confirm": 8320, "confirmAdd": 84, "dead": 83, "heal": 1401},
     {"name": "Germany", "confirm": 7272, "confirmAdd": 1174, "dead": 17, "heal": 135}, 
     {"name": "France", "confirm": 6650, "confirmAdd": 1250, "dead": 148, "heal": 28}, 
     {"name": "United States", "confirm": 4687, "confirmAdd": 913, "dead": 93, "heal": 74}, {"name": "Switzerland", "confirm": 2269, "confirmAdd": 49, "dead": 19, "heal": 4}, {"name": "英国", "confirm": 1950, "confirmAdd": 407, "dead": 56, "heal": 52}, {"name": "Netherlands", "confirm": 1705, "confirmAdd": 292, "dead": 43, "heal": 0}, {"name": "Norway", "confirm": 1331, "confirmAdd": 75, "dead": 3, "heal": 1}, {"name": "Belgium", "confirm": 1243, "confirmAdd": 158, "dead": 10, "heal": 1}, {"name": "Sweden", "confirm": 1119, "confirmAdd": 96, "dead": 7, "heal": 1}, {"name": "Austria", "confirm": 1016, "confirmAdd": 156, "dead": 3, "heal": 6}, {"name": "Denmark", "confirm": 960, "confirmAdd": 62, "dead": 4, "heal": 1}, {"name": "日本本土", "confirm": 880, "confirmAdd": 45, "dead": 29, "heal": 135}, {"name": "钻石号邮轮", "confirm": 712, "confirmAdd": 0, "dead": 7, "heal": 525}, {"name": "Malaysia", "confirm": 673, "confirmAdd": 120, "dead": 2, "heal": 49}, {"name": "Australia", "confirm": 449, "confirmAdd": 81, "dead": 6, "heal": 27}, {"name": "Portugal", "confirm": 448, "confirmAdd": 117, "dead": 1, "heal": 3}, {"name": "Qatar", "confirm": 439, "confirmAdd": 0, "dead": 0, "heal": 4}, {"name": "Canada", "confirm": 436, "confirmAdd": 123, "dead": 4, "heal": 11}, {"name": "Greece", "confirm": 352, "confirmAdd": 21, "dead": 4, "heal": 0}, {"name": "Israel", "confirm": 344, "confirmAdd": 0, "dead": 0, "heal": 28}, {"name": "捷克", "confirm": 344, "confirmAdd": 51, "dead": 0, "heal": 3}, {"name": "Finland", "confirm": 272, "confirmAdd": 28, "dead": 0, "heal": 1}, {"name": "新加坡", "confirm": 266, "confirmAdd": 23, "dead": 0, "heal": 105}, {"name": "Slovenia", "confirm": 253, "confirmAdd": 34, "dead": 1, "heal": 0}, {"name": "巴林", "confirm": 237, "confirmAdd": 16, "dead": 1, "heal": 81}, {"name": "Brazil", "confirm": 234, "confirmAdd": 34, "dead": 1, "heal": 0}, {"name": "Ireland", "confirm": 223, "confirmAdd": 54, "dead": 2, "heal": 0}, {"name": "Pakistan", "confirm": 212, "confirmAdd": 75, "dead": 1, "heal": 2}, {"name": "Estonia", "confirm": 205, "confirmAdd": 34, "dead": 0, "heal": 0}, {"name": "Poland", "confirm": 205, "confirmAdd": 80, "dead": 5, "heal": 13}, {"name": "Philippines", "confirm": 187, "confirmAdd": 45, "dead": 14, "heal": 4}, {"name": "Iceland", "confirm": 180, "confirmAdd": 9, "dead": 0, "heal": 2}, {"name": "Thailand", "confirm": 177, "confirmAdd": 30, "dead": 1, "heal": 41}, {"name": "Indonesia", "confirm": 172, "confirmAdd": 38, "dead": 5, "heal": 8}, {"name": "Egypt", "confirm": 166, "confirmAdd": 40, "dead": 2, "heal": 26}, {"name": "Romania", "confirm": 158, "confirmAdd": 35, "dead": 0, "heal": 7}, {"name": "Chile", "confirm": 156, "confirmAdd": 81, "dead": 0, "heal": 0}, {"name": "Iraq", "confirm": 154, "confirmAdd": 27, "dead": 11, "heal": 41}, {"name": "India", "confirm": 137, "confirmAdd": 20, "dead": 3, "heal": 13}, {"name": "Saudi Arabia", "confirm": 133, "confirmAdd": 15, "dead": 0, "heal": 6}, {"name": "Kuwait", "confirm": 130, "confirmAdd": 7, "dead": 0, "heal": 9}, {"name": "Lebanon", "confirm": 120, "confirmAdd": 11, "dead": 3, "heal": 1}, {"name": "Russia", "confirm": 114, "confirmAdd": 21, "dead": 0, "heal": 8}, {"name": "圣马力诺", "confirm": 98, "confirmAdd": 0, "dead": 7, "heal": 2}, {"name": "阿联酋", "confirm": 98, "confirmAdd": 0, "dead": 0, "heal": 26}, {"name": "Mexico", "confirm": 82, "confirmAdd": 29, "dead": 0, "heal": 4}, {"name": "Luxembourg", "confirm": 81, "confirmAdd": 0, "dead": 1, "heal": 0}, {"name": "Slovakia", "confirm": 72, "confirmAdd": 11, "dead": 0, "heal": 0}, {"name": "Peru", "confirm": 71, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Panama", "confirm": 69, "confirmAdd": 14, "dead": 1, "heal": 0}, {"name": "Vietnam", "confirm": 66, "confirmAdd": 6, "dead": 0, "heal": 16}, {"name": "Serbia", "confirm": 65, "confirmAdd": 10, "dead": 0, "heal": 0}, {"name": "Argentina", "confirm": 65, "confirmAdd": 9, "dead": 2, "heal": 1}, {"name": "Armenia", "confirm": 64, "confirmAdd": 36, "dead": 0, "heal": 1}, {"name": "South Africa", "confirm": 62, "confirmAdd": 0, "dead": 0, "heal": 1}, {"name": "Algeria", "confirm": 60, "confirmAdd": 6, "dead": 4, "heal": 12}, {"name": "Ecuador", "confirm": 58, "confirmAdd": 21, "dead": 2, "heal": 0}, {"name": "Colombia", "confirm": 57, "confirmAdd": 12, "dead": 0, "heal": 0}, {"name": "Croatia", "confirm": 57, "confirmAdd": 11, "dead": 0, "heal": 4}, {"name": "Brunei", "confirm": 56, "confirmAdd": 2, "dead": 0, "heal": 0}, {"name": "Bulgaria", "confirm": 51, "confirmAdd": 0, "dead": 2, "heal": 0}, {"name": "列支敦士登公国", "confirm": 50, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Hungary", "confirm": 50, "confirmAdd": 18, "dead": 1, "heal": 2}, {"name": "Turkey", "confirm": 47, "confirmAdd": 29, "dead": 0, "heal": 0}, {"name": "Albania", "confirm": 42, "confirmAdd": 0, "dead": 1, "heal": 0}, {"name": "Costa Rica", "confirm": 41, "confirmAdd": 6, "dead": 0, "heal": 0}, {"name": "Morocco", "confirm": 38, "confirmAdd": 10, "dead": 2, "heal": 1}, {"name": "巴勒斯坦", "confirm": 38, "confirmAdd": 3, "dead": 0, "heal": 0}, {"name": "Belarus", "confirm": 36, "confirmAdd": 0, "dead": 0, "heal": 3}, {"name": "Latvia", "confirm": 34, "confirmAdd": 0, "dead": 0, "heal": 1}, {"name": "约旦", "confirm": 34, "confirmAdd": 21, "dead": 0, "heal": 1}, {"name": "Venezuela", "confirm": 33, "confirmAdd": 16, "dead": 0, "heal": 0}, {"name": "格鲁吉亚", "confirm": 33, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Cyprus", "confirm": 33, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Kazakhstan", "confirm": 32, "confirmAdd": 24, "dead": 0, "heal": 0}, {"name": "Sri Lanka", "confirm": 29, "confirmAdd": 6, "dead": 0, "heal": 1}, {"name": "Azerbaijan", "confirm": 28, "confirmAdd": 3, "dead": 1, "heal": 7}, {"name": "Senegal", "confirm": 27, "confirmAdd": 3, "dead": 0, "heal": 2}, {"name": "波黑", "confirm": 24, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Oman", "confirm": 24, "confirmAdd": 2, "dead": 0, "heal": 12}, {"name": "Moldova", "confirm": 23, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Afghanistan", "confirm": 22, "confirmAdd": 1, "dead": 0, "heal": 0}, {"name": "多米尼加", "confirm": 21, "confirmAdd": 16, "dead": 1, "heal": 0}, {"name": "Tunisia", "confirm": 20, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "北马其顿", "confirm": 18, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "马耳他", "confirm": 18, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Lithuania", "confirm": 17, "confirmAdd": 5, "dead": 0, "heal": 0}, {"name": "安道尔", "confirm": 15, "confirmAdd": 13, "dead": 0, "heal": 1}, {"name": "Burkina Faso", "confirm": 15, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "马尔代夫", "confirm": 13, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Cambodia", "confirm": 12, "confirmAdd": 0, "dead": 0, "heal": 1}, {"name": "New Zealand", "confirm": 11, "confirmAdd": 3, "dead": 0, "heal": 0}, {"name": "Cameroon", "confirm": 10, "confirmAdd": 5, "dead": 0, "heal": 2}, {"name": "摩纳哥", "confirm": 9, "confirmAdd": 2, "dead": 0, "heal": 0}, {"name": "Uzbekistan", "confirm": 8, "confirmAdd": 2, "dead": 0, "heal": 0}, {"name": "孟加拉", "confirm": 8, "confirmAdd": 0, "dead": 0, "heal": 2}, {"name": "Ukraine", "confirm": 7, "confirmAdd": 2, "dead": 2, "heal": 0}, {"name": "Rwanda", "confirm": 7, "confirmAdd": 2, "dead": 0, "heal": 0}, {"name": "Paraguay", "confirm": 6, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Uruguay", "confirm": 6, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Ghana", "confirm": 6, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Côte d'Ivoire", "confirm": 6, "confirmAdd": 2, "dead": 0, "heal": 1}, {"name": "Ethiopia", "confirm": 5, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Puerto Rico", "confirm": 5, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "刚果（金）", "confirm": 4, "confirmAdd": 1, "dead": 0, "heal": 0}, {"name": "Guyana", "confirm": 4, "confirmAdd": 0, "dead": 1, "heal": 0}, {"name": "塞舌尔", "confirm": 4, "confirmAdd": 2, "dead": 0, "heal": 0}, {"name": "Mongolia", "confirm": 4, "confirmAdd": 3, "dead": 0, "heal": 0}, {"name": "Kenya", "confirm": 4, "confirmAdd": 1, "dead": 0, "heal": 0}, {"name": "Nigeria", "confirm": 3, "confirmAdd": 1, "dead": 0, "heal": 0}, {"name": "Guatemala", "confirm": 2, "confirmAdd": 0, "dead": 1, "heal": 0}, {"name": "Liberia", "confirm": 2, "confirmAdd": 1, "dead": 0, "heal": 0}, {"name": "Kosovo", "confirm": 2, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Honduras", "confirm": 2, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Namibia", "confirm": 2, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Gabon", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Benin", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Central African Rep.", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "刚果（布）", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Tanzania", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "梵蒂冈", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "安提瓜和巴布达", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Eq. Guinea", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Guinea", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Bhutan", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Nepal", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 1}, {"name": "Somalia", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Togo", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, {"name": "Sudan", "confirm": 1, "confirmAdd": 0, "dead": 1, "heal": 0}, {"name": "Mauritania", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}, 
     {"name": "Swaziland", "confirm": 1, "confirmAdd": 0, "dead": 0, "heal": 0}];
    console.log(json_data['Italy'])
     echart_map();

    // echart_map
    function echart_map() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_map'));
        console.log(configure_json)
        var name_title = "投票统计"
        var subname = ''
        var nameColor = " rgb(55, 75, 113)"
        var name_fontFamily = '楷体'
        var name_fontSize = 52
        var mapName = 'world'
        var data = []
        var geoCoordMap = {};
        var toolTipData = [];

        /*获取地图数据*/
        myChart.showLoading();
        var mapFeatures = echarts.getMap(mapName).geoJson.features;
        myChart.hideLoading();
        mapFeatures.forEach(function(v) {
            // 地区名称
            var name = v.properties.name;
            
            // 地区经纬度
            geoCoordMap[name] = v.properties.cp;
            data.push({
                name: name,
                value: json_data[name]
            })
            toolTipData.push({
                name: name,
                value: [{
                    name: "客运车",
                    value: json_data[name]
                }
                ]
            })
        });

        var max = 480,
            min = 9; // todo
        var maxSize4Pin = 100,
            minSize4Pin = 20;

        var convertData = function(data) {
            var res = [];
            for (var i = 0; i < data.length; i++) {
                var geoCoord = geoCoordMap[data[i].name];
                if (geoCoord) {
                    res.push({
                        name: data[i].name,
                        value: geoCoord.concat(data[i].value),
                    });
                }
            }
            return res;
        };
        option = {
            title: {
                show:false,
                text: name_title,
                subtext: subname,
                x: 'center',
                textStyle: {
                    color: nameColor,
                    fontFamily: name_fontFamily,
                    fontSize: name_fontSize
                }
            },
            tooltip: {
                trigger: 'item',
                formatter: function(params) {
                    if (typeof(params.value)[2] == "undefined") {
                        var toolTiphtml = ''
                        for(var i = 0;i<toolTipData.length;i++){
                            if(params.name==toolTipData[i].name){
                                toolTiphtml += toolTipData[i].name+':<br>'
                                for(var j = 0;j<toolTipData[i].value.length;j++){
                                    toolTiphtml+=toolTipData[i].value[j].name+':'+toolTipData[i].value[j].value+"<br>"
                                }
                            }
                        }
                        return toolTiphtml;
                    } else {
                        var toolTiphtml = ''
                        for(var i = 0;i<toolTipData.length;i++){
                            if(params.name==toolTipData[i].name){
                                toolTiphtml += toolTipData[i].name+':<br>'
                                for(var j = 0;j<toolTipData[i].value.length;j++){
                                    toolTiphtml+=toolTipData[i].value[j].name+':'+toolTipData[i].value[j].value+"<br>"
                                }
                            }
                        }
                        return toolTiphtml;
                    }
                }
            },
            legend: {
                orient: 'vertical',
                y: 'bottom',
                x: 'right',
                data: ['credit_pm2.5'],
                textStyle: {
                    color: '#fff'
                }
            },
            visualMap: {
                show: false,
                min: 0,
                max: 500,
                left: 'left',
                top: 'bottom',
                text: ['高', '低'], // 文本，默认为数值文本
                calculable: true,
                seriesIndex: [1],
                inRange: {
                    // color: ['#3B5077', '#031525'] // 蓝黑
                    // color: ['#ffc0cb', '#800080'] // 红紫
                    // color: ['#3C3B3F', '#605C3C'] // 黑绿
                    color: ['#0f0c29', '#302b63', '#24243e'] // 黑紫黑
                    // color: ['#23074d', '#cc5333'] // 紫红
                    // color: ['#00467F', '#A5CC82'] // 蓝绿
                    // color: ['#1488CC', '#2B32B2'] // 浅蓝
                    // color: ['#00467F', '#A5CC82'] // 蓝绿
                    // color: ['#00467F', '#A5CC82'] // 蓝绿
                    // color: ['#00467F', '#A5CC82'] // 蓝绿
                    // color: ['#00467F', '#A5CC82'] // 蓝绿

                }
            },
            /*工具按钮组*/
            toolbox: {
                show: false,
                orient: 'vertical',
                left: 'right',
                top: 'center',
                feature: {
                    dataView: {
                        readOnly: false
                    },
                    restore: {},
                    saveAsImage: {}
                }
            },
            geo: {
                show: true,
                map: mapName,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false,
                    }
                },
                roam: true,
                itemStyle: {
                    normal: {
                        areaColor: '#031525',
                        borderColor: '#3B5077',
                    },
                    emphasis: {
                        areaColor: '#2B91B7',
                    }
                }
            },
            series: [{
                name: '散点',
                type: 'scatter',
                coordinateSystem: 'geo',
                data: convertData(data),
                symbolSize: function(val) {
                    return val[2] / 10;
                },
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#05C3F9'
                    }
                }
            },
                {
                    type: 'map',
                    map: mapName,
                    geoIndex: 0,
                    aspectScale: 0.75, //长宽比
                    showLegendSymbol: false, // 存在legend时显示
                    label: {
                        normal: {
                            show: true
                        },
                        emphasis: {
                            show: false,
                            textStyle: {
                                color: '#fff'
                            }
                        }
                    },
                    roam: true,
                    itemStyle: {
                        normal: {
                            areaColor: '#031525',
                            borderColor: '#0227ad',
                        },
                        emphasis: {
                            areaColor: '#2B91B7'
                        }
                    },
                    animation: false,
                    data: data
                },
                {
                    name: '点',
                    type: 'scatter',
                    coordinateSystem: 'geo',
                    symbol: 'pin', //气泡
                    symbolSize: function(val) {
                        var a = (maxSize4Pin - minSize4Pin) / (max - min);
                        var b = minSize4Pin - a * min;
                        b = maxSize4Pin - a * max;
                        return a * val[2] + b;
                    },
                    label: {
                        //气泡上的文字
                        normal: {
                            show: false,
                            textStyle: {
                                color: '#fff',
                                fontSize: 9,
                            }
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: '#F62157', //标志颜色
                        }
                    },
                    zlevel: 6,
                    data: convertData(data),
                },
                {
                    name: 'Top 5',
                    type: 'effectScatter',
                    coordinateSystem: 'geo',
                    data: convertData(data.sort(function(a, b) {
                        return b.value - a.value;
                    }).slice(0, 5)),
                    symbolSize: function(val) {
                        return val[2] / 10;
                    },
                    showEffectOn: 'render',
                    rippleEffect: {
                        brushType: 'stroke'
                    },
                    hoverAnimation: true,
                    label: {
                        normal: {
                            formatter: '{b}',
                            position: 'right',
                            show: true
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: '#05C3F9',
                            shadowBlur: 10,
                            shadowColor: '#05C3F9'
                        }
                    },
                    zlevel: 1
                },

            ]
        };
        myChart.setOption(option);

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });

    }





})
