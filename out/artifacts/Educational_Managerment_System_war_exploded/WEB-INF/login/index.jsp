<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>后台登录-X-admin2.2</title>
        <meta name="renderer" content="webkit|ie-comp|ie-stand">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
        <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
        <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script>
            // 是否开启刷新记忆tab功能
            // var is_remember = false;
        </script>
    </head>
    <body class="index">
        <!-- 顶部开始 -->
        <div class="container">
            <div class="logo">
                <a href="./index.html">X-admin v2.2</a></div>
            <div class="left_open">
                <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
            </div>

            <ul class="layui-nav left fast-add" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;">+新增</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd>
                            <a onclick="xadmin.open('最大化','http://www.baidu.com','','',true)">
                                <i class="iconfont">&#xe6a2;</i>弹出最大化</a></dd>
                        <dd>
                            <a onclick="xadmin.open('弹出自动宽高','http://www.baidu.com')">
                                <i class="iconfont">&#xe6a8;</i>弹出自动宽高</a></dd>
                        <dd>
                            <a onclick="xadmin.open('弹出指定宽高','http://www.baidu.com',500,300)">
                                <i class="iconfont">&#xe6a8;</i>弹出指定宽高</a></dd>
                        <dd>
                            <a onclick="xadmin.add_tab('在tab打开','member-list.html')">
                                <i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>
                        <dd>
                            <a onclick="xadmin.add_tab('在tab打开刷新','member-del.html',true)">
                                <i class="iconfont">&#xe6b8;</i>在tab打开刷新</a></dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;">admin</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd>
                            <a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a></dd>
                        <dd>
                            <a onclick="xadmin.open('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
                        <dd>
                            <a href="./login.html">退出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item to-index">
                    <a href="/">前台首页</a></li>
            </ul>
        </div>
        <!-- 顶部结束 -->
        <!-- 中部开始 -->
        <!-- 左侧菜单开始 -->
        <div class="left-nav">
            <div id="side-nav">
                <ul id="nav">


                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li"
                                    <c:if test="${role=='admin'}">lay-tips="教务处栏目"   </c:if>
                                    <c:if test="${role=='teacher'}">lay-tips="教师栏目"   </c:if>
                                    <c:if test="${role=='student'}">lay-tips="学生栏目"   </c:if>
                            >&#xe726;</i>
                            <c:if test="${role=='admin'}"> <cite>教务处栏目</cite>  </c:if>
                            <c:if test="${role=='teacher'}"> <cite>教师栏目</cite>  </c:if>
                            <c:if test="${role=='student'}"> <cite>学生栏目</cite> </c:if>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <shiro:hasRole name="admin">
                            <li>
                                <a onclick="xadmin.add_tab('信息录入','admin-list.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>信息录入</cite></a>
                            </li>
                            </shiro:hasRole>
                            <shiro:hasRole name="admin">
                            <li>
                                <a onclick="xadmin.add_tab('课程分配','admin-role.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>课程分配</cite></a>
                            </li>
                            </shiro:hasRole>
                            <shiro:hasRole name="admin">
                            <li>
                                <a onclick="xadmin.add_tab('开课课程','admin-cate.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>开课课程</cite></a>
                            </li>
                            </shiro:hasRole>
                            <shiro:hasRole name="teacher">
                            <li>
                                <a onclick="xadmin.add_tab('学生信息','admin-cate.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>学生信息</cite></a>
                            </li>
                            </shiro:hasRole>
                            <shiro:hasRole name="teacher">
                            <li>
                                <a onclick="xadmin.add_tab('课程表','admin-cate.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>课程表</cite></a>
                            </li>
                            </shiro:hasRole>
                            <shiro:hasRole name="teacher">
                            <li>
                                <a onclick="xadmin.add_tab('成绩录入','admin-cate.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>成绩录入</cite></a>
                            </li>
                            </shiro:hasRole>
                            <shiro:hasRole name="teacher">
                            <li>
                                <a onclick="xadmin.add_tab('综合评教','${pageContext.request.contextPath}/sonsultTotalController/sonsultTotalPage.do')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>综合评教</cite></a>
                            </li>
                            </shiro:hasRole>
                            <shiro:hasRole name="student">
                            <li>
                                <a onclick="xadmin.add_tab('个人信息','admin-cate.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>个人信息</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('培养方案','admin-cate.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>培养方案</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('学生评教','${pageContext.request.contextPath}/sonsultController/sonsultPage.do')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>学生评教</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('网上选课','admin-cate.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>网上选课</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('成绩查询','admin-cate.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>成绩查询</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('补考','admin-cate.html')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>补考</cite></a>
                            </li>
                            </shiro:hasRole>
                            <li>
                                <a onclick="xadmin.add_tab('资源下载','${pageContext.request.contextPath}/fileResourcesController/fileResourcesPage.do')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>资源下载</cite>
                                </a>
                            </li>
                        </ul>
                    </li>


                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="实时疫情">&#xe6b8;</i>
                            <cite>实时疫情</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('疫情统计','${pageContext.request.contextPath}/yiqingController/yiqing.do')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>疫情统计</cite></a>
                            </li>

                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- <div class="x-slide_left"></div> -->
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                        <i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
                <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                    <dl>
                        <dd data-type="this">关闭当前</dd>
                        <dd data-type="other">关闭其它</dd>
                        <dd data-type="all">关闭全部</dd></dl>
                </div>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='${pageContext.request.contextPath}/loginController/welcome.do' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>
        <div class="page-content-bg"></div>
        <style id="theme_style"></style>
        <!-- 右侧主体结束 -->
        <!-- 中部结束 -->

    </body>

</html>