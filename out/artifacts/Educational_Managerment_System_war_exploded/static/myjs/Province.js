$(function(){

    $.post("http://localhost:8080/Educational_Managerment_System/yiqingController/selectChinaInfo.ajax",function(data){
        console.log(data)
        var html="";
        for(var i=0;i<data.length;i++){
            html+="<option value='"+data[i].name+"'>"+data[i].name+"</option>";
        }
        $("#deadCountQianWu").html(html);
        $("#provinceyiqingfenxi").html(html);
        $("#curedqianwuCity").html(html);
    })

})