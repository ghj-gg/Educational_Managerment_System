<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/5
  Time: 9:10
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="layui-fluid">
    <div class="layui-form layui-form-pane">
            <div class="layui-form-item layui-form-text">
                <label for="desc" >
                    知识技能：语言规范、准确、丰富、简洁、生动；教态亲切、自然；理论新，知识面广、视野开阔，信息处理综合能力强；
                    驾驭教学过程的能力强，善于调动学生的学习积极性，善于引导、善于应变。<br/>
                    <span class="x-red">*</span>10分
                </label>
                <div class="layui-input-block">
                    <%--<input type="text" id="a" name="a" required="" lay-verify="required"--%>
                    <%--       autocomplete="off" class="layui-input">--%>
                        <input type="radio" name="a" value="3" lay-skin="primary" title="3分">
                        <input type="radio" name="a" value="5" lay-skin="primary" title="5分">
                        <input type="radio" name="a" value="7" lay-skin="primary" title="7分">
                        <input type="radio" name="a" value="10" lay-skin="primary" title="10分">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label for="desc" >
                    教材处理：能突出课文特色和课型特点；根据教材特点和课型特点设计教学过程，符合教学内容要求；能对教材有创造性的
                    理解、处理和使用；能设计针对性的、创新式的课程任务。<br/>
                    <span class="x-red">*</span>10分
                </label>
                <div class="layui-input-block">
                    <input type="radio" name="b" value="3" lay-skin="primary" title="3分">
                    <input type="radio" name="b" value="5" lay-skin="primary" title="5分">
                    <input type="radio" name="b" value="7" lay-skin="primary" title="7分">
                    <input type="radio" name="b" value="10" lay-skin="primary" title="10分">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label for="desc">
                    设计思想：能立足培养学生学习兴趣，培养学生基本学习课程能力，提高综合素养；新颖有趣，能设置发散性、探索性问题，
                    使学生产生想象和联想。<br/>
                    <span class="x-red">*</span>10分
                </label>
                <div class="layui-input-block">
                        <input type="radio" name="c" value="3" lay-skin="primary" title="3分">
                        <input type="radio" name="c" value="5" lay-skin="primary" title="5分">
                        <input type="radio" name="c" value="7" lay-skin="primary" title="7分">
                        <input type="radio" name="c" value="10" lay-skin="primary" title="10分">
                    </div>

            </div>
            <div class="layui-form-item layui-form-text">
                <label for="desc">
                    教学组织：能体现课程学科特性，课程教学具有特色，能突破课堂，体现综合性、开放式课程教育；以学生为主，能用最新的
                    教育观念指导自己的教学，并自觉贯彻到教学中。<br/>
                    <span class="x-red">*</span>10分
                </label>
                <div class="layui-input-block">
                        <input type="radio" name="d" value="3" lay-skin="primary" title="3分">
                        <input type="radio" name="d" value="5" lay-skin="primary" title="5分">
                        <input type="radio" name="d" value="7" lay-skin="primary" title="7分">
                        <input type="radio" name="d" value="10" lay-skin="primary" title="10分">

                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label for="desc" class="layui-form-label">
                    评语
                </label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" id="desc" name="desc" class="layui-textarea"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="add" onclick="submit()">提交</button>
            </div>
    </div>
</div>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;
    });
    //提交
    function submit() {
        var a = $("input[name='a']:checked").val();
        var b = $("input[name='b']:checked").val();
        var c = $("input[name='c']:checked").val();
        var d = $("input[name='d']:checked").val();
        var desc = $("#desc").val();
        alert("a="+a);
        alert("b="+b);
        alert("c="+c);
        alert("d="+d);
        alert("desc="+desc);
        //构建js对象
        params = {
            "sonsultTotalA":a,
            "sonsultTotalB":b,
            "sonsultTotalC":c,
            "sonsultTotalD":d,
            "sonsultTotalMessage":desc
        };
        //发送ajax请求
        $.ajax({
            url:"${pageContext.request.contextPath}/sonsultController/sonsultPage.ajax",
            type:"get",
            data:params,
            dataType:"json",
            success:function (data) {
                if (data.info){
                    // 发异步，把数据提交给php
                            layer.alert("提交成功", {icon: 6},function () {
                                // 获得frame索引
                                var index = parent.layer.getFrameIndex(window.name);
                                //关闭当前frame
                               xadmin.close();
                               //父窗口刷新
                                xadmin.father_reload();
                            });

                }else {
                    alert("提交失败")
                }

            }

        })


    }
</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>
