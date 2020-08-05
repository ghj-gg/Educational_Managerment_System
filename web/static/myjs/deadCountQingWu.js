$(function () {

    eachart1("湖北")

})



function deadCountQianWu() {
      var cityName = $("#deadCountQianWu").val();
      eachart1(cityName)
}

function eachart1(cityName) {
        $.post("http://localhost:8080/Educational_Managerment_System/yiqingController/deadCountQianWu.ajax",{"cityName":cityName},function (data) {


            var myChart = echarts.init(document.getElementById('main2'));

            // 指定图表的配置项和数据
            option = {
                title: {
                    text: '各省死亡人数',
                    subtext: '数据来自网络'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },

                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'value',
                    boundaryGap: [0, 0.01]
                },
                yAxis: {
                    type: 'category',
                    data: data[0]
                },
                series: [
                    {
                        name: '2011年',
                        type: 'bar',
                        data:data[1]
                    },

                ]
            };



            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        })
}