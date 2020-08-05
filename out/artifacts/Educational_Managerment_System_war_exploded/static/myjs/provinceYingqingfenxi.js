$(function () {

    eachart3("湖北")

})

function provinceyiqingfenxi() {
      var cityName = $("#provinceyiqingfenxi").val();
      console.log(cityName)
      eachart3(cityName)
}
function eachart3(cityName) {
     $.post("http://localhost:8080/Educational_Managerment_System/yiqingController/provinceyiqingfenxi.ajax",{"cityName":cityName},function (data) {
// 基于准备好的dom，初始化echarts实例
         var myChart = echarts.init(document.getElementById('main3'));

// 指定图表的配置项和数据
         var option = {
             tooltip : {
                 trigger: 'item',
                 formatter: "{a} <br/>{b} : {c} ({d}%)"
             },
             legend: {
                 orient: 'vertical',
                 left: 'left',
                 data: ['现有确诊','现有死亡','现有治愈']
             },
             series : [
                 {
                     name: '访问来源',
                     type: 'pie',
                     radius : '55%',
                     center: ['50%', '60%'],
                     data:data,
                     itemStyle: {
                         emphasis: {
                             shadowBlur: 10,
                             shadowOffsetX: 0,
                             shadowColor: 'rgba(0, 0, 0, 0.5)'
                         }
                     }
                 }
             ]
         };
// 使用刚指定的配置项和数据显示图表。
         myChart.setOption(option);
     })
}