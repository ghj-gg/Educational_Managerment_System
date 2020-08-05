<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/3
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body onload="loadSonsult(1)">

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table class="layui-table layui-form">
                        <thead>
                            <th>ID</th>
                            <th>课程</th>
                            <th>教师</th>
                            <th>操作</th>
                        </thead>
                        <tbody id="tbody">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    var pPage;
    var nPage;
    //上一页
    function prePage() {
        loadSonsult(pPage)
    }
    //下一页
    function nextPage() {
        loadSonsult(nPage)
    }
    function loadSonsult(p) {
        $.ajax({
            url:"${pageContext.request.contextPath}/sonsultController/sonsult.ajax",
            typt:"post",
            data:{"page":p},
            dataType:"json",
            success:function (data) {
                pPage=data.prePage;
                nPage=data.nextPage;
                var html = "";
                for (var i=0;i<data.list.length;i++){
                    html+="<tr>"+
                        "<td name='sonsultId'>"+data.list[i].sonsultId+"</td>"+
                        "<td name='sonsultCourse'>"+data.list[i].sonsultCourse+"</td>"+
                        "<td name='sonsultTeacher'>"+data.list[i].sonsultTeacher+"</td>"
                    if(data.list[i].sonsultState == 0){
                        html += "<td><button class='layui-btn' onclick='sonsultPage(this)'>评教</button></td>"+"<tr>"
                    }else {
                        html += "<td>已评教</td>"+"<tr>"
                    }
                }
                $("tbody").html(html)
            }
        })
    }

    //打开评教
    function sonsultPage(obj) {
        var sonsultId = $(obj).parent().parent().find("td").eq(0).text();
        var sonsultCourse = $(obj).parent().parent().find("td").eq(1).text();
        var sonsultTeacher = $(obj).parent().parent().find("td").eq(2).text();
        var url = "${pageContext.request.contextPath}/sonsultController/addSonsult.do";
        //构架js对象
        params = {
            "sonsultId":sonsultId,
            "sonsultCourse":sonsultCourse,
            "sonsultTeacher":sonsultTeacher
        };
        xadmin.open("评教",url,600,400);
        //发送ajax请求
        $.ajax({
            url:url,
            type:"post",
            data:params,
            dataType:"json",
        })
    }
</script>
</html>
