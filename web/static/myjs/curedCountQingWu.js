$(function () {

   eachart("湖北")

})


function curedqianwuCity(){
   var cityName = $("#curedqianwuCity").val();
   console.log("curedqianwuCity="+cityName)
       eachart(cityName)
}

function eachart(cityName) {
    $.post("http://localhost:8080/Educational_Managerment_System/yiqingController/provinceCuredQianWu.ajax",{"cityName":cityName},function (data) {

        var myChart = echarts.init(document.getElementById('main4'));

        // 指定图表的配置项和数据
        option = {
            color: ['#3398DB'],
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    data: data[0],
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '直接访问',
                    type: 'bar',
                    barWidth: '60%',
                    data: data[1]
                }
            ]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    })
}

