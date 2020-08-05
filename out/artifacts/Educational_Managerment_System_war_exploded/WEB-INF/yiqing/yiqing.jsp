<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/1
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/echarts.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">

        <div class="layui-col-sm12 layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header">国内疫情分析</div>
                <div class="layui-card-body" style="min-height: 280px;">
                    <div id="main1" class="layui-col-sm12" style="height: 300px;"></div>

                </div>
            </div>
        </div>
        <div class="layui-col-sm12 layui-col-md6">
            <div class="layui-card">

                <div class="layui-card-header ">
                   <label>各省死亡人数前五</label>&nbsp;
                    <select  name="city"  id="deadCountQianWu" onchange="deadCountQianWu()">
<%--                        <option value="湖北" selected="selected">湖北</option>--%>
<%--                        <option value="四川">四川</option>--%>
<%--                        <option value="湖南">湖南</option>--%>
<%--                        <option value="河南">河南</option>--%>
                    </select>
                </div>
                <div class="layui-card-body" style="min-height: 280px;">
                    <div id="main2" class="layui-col-sm12" style="height: 300px;"></div>

                </div>
            </div>
        </div>
        <div class="layui-col-sm12 layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header">
                    <label>各省疫情分析</label> &nbsp;
                    <select  name="city"  id="provinceyiqingfenxi" onchange="provinceyiqingfenxi()">

                    </select>
                </div>
                <div class="layui-card-body" style="min-height: 280px;">
                    <div id="main3" class="layui-col-sm12" style="height: 300px;"></div>

                </div>
            </div>
        </div>
        <div class="layui-col-sm12 layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header">
                    <label> 各省治愈人数前五</label>&nbsp;
                    <select  name="city"  id="curedqianwuCity" onchange="curedqianwuCity()">

                    </select>

                </div>
                <div class="layui-card-body" style="min-height: 280px;">
                    <div id="main4" class="layui-col-sm12" style="height: 300px;"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>

<script src="${pageContext.request.contextPath}/static/myjs/yiqingfenxi.js"></script>
<script src="${pageContext.request.contextPath}/static/myjs/provinceYingqingfenxi.js"></script>
<script src="${pageContext.request.contextPath}/static/myjs/curedCountQingWu.js"></script>
<script src="${pageContext.request.contextPath}/static/myjs/deadCountQingWu.js"></script>
<script src="${pageContext.request.contextPath}/static/myjs/Province.js"></script>




</html>
