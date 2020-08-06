<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/5
  Time: 18:26
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
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
</head>
<body onload="loadSonsultTotal(1)">
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table class="layui-table layui-form">
                        <thead>
                        <th>ID</th>
                        <th>班级</th>
                        <th>评教平均分</th>
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
        loadSonsultTotal(pPage)
    }
    //下一页
    function nextPage() {
        loadSonsultTotal(nPage)
    }
    function loadSonsultTotal(p) {
        $.ajax({
            url:"${pageContext.request.contextPath}/sonsultTotalController/sonsultTotal.ajax",
            typt:"post",
            data:{"page":p},
            dataType:"json",
            success:function (data) {
                pPage=data.prePage;
                nPage=data.nextPage;
                numPage=data.numPage;
                endPage=data.endPage;
                indexPage=data.indexPage;
                var html = "";
                for (var i=0;i<data.list.length;i++){
                    html+="<tr>"+
                        "<td name='claasId'>"+data.list[i].claasId+"</td>"+
                        "<td name='classC'>"+data.list[i].classC+"</td>"+
                        "<td><button class='layui-btn' onclick='count(this)'>查看分数</button></td>"+"<tr>"
                }
                $("tbody").html(html)
            }
        })
    }
    function count(obj) {
        var classId = $(obj).parent().parent().find("td").eq(0).text();
        var classC = $(obj).parent().parent().find("td").eq(1).text();
        //构建js对象
        params= {
            "classId":classId,
            "classC":classC
        };
        $.ajax({
            url:"${pageContext.request.contextPath}/sonsultTotalController/allCount.ajax",
            type:"get",
            data:params,
            dataType:"json",
            success:function (data){
                layer.alert("您的分数为："+data.info, {icon: 6});
            }
        })
    }
    function messagePage(obj) {
        //打开评语页面
        xadmin.open("评教","${pageContext.request.contextPath}/sonsultTotalController/messagePage.do",600,400);
    }
</script>
</html>
