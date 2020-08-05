<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type"  content="multipart/form-data; charset=utf-8" />
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
</head>


<script type="text/javascript">
    $(function () {
        // 全选
        $("#parentInput").click(function(){
            $("input:checkbox:gt(0)").prop("checked",$("#parentInput").prop("checked"));
        })
        //判断全选框是否还选中
        var a=$("input:checkbox:gt(0)");
        $.each(a,function(i,m){
            a.click(function(){
                var count = 0;
                $.each(a,function(i,m){
                    if(m.checked==false){
                        count++;
                    }
                })
                if(count==1){
                    $("#parentInput")[0].checked = false;
                }
                if(count==0){
                    $("#parentInput")[0].checked = true;
                }
            })
        })

    })


    //批量下载
    function downloadAll (argument) {
        //循环每一个被选中的行
        $("#ck:checked").each(function () {
            var  fileId =$(this).val();
            //获取到选中行的各个td的文本值
            var  filename = $(this).parent().parent().find("td").eq(2).text();
            var  fileCount = parseInt($(this).parent().parent().find("td").eq(6).text());
            //调用文件下载方法
            downloadFile("${pageContext.request.contextPath}/fileResourcesController/fileDownLoad.do?fileName="+filename+"&fileCount="+(fileCount+1)+"&fileId="+fileId,filename);
            layer.msg('下载成功!',{icon:1,time:500});
            //取消选中
            $(this).prop("checked",false);
            //得到下载次数并且加一
            var textCount =  $(this).parent().parent().find("td").eq(6).text();
            $(this).parent().parent().find("td").eq(6).text(parseInt(textCount)+1);
            //取消全选
            $("#parentInput").prop("checked",false);
        })


    }
    //文件下载通过创建a标签，使用download属性，实现多文件下载
    function downloadFile (url,filename) {
        //创建a标签
        var eleLink = document.createElement('a');
        eleLink.style.display = 'none';
        //需要下载的资源的全路径
        eleLink.download="D:\\resources"+"\\"+filename;
        eleLink.href = url;
        // 受浏览器安全策略的因素，动态创建的元素必须添加到浏览器后才能实施点击
        document.body.appendChild(eleLink);
        // 触发点击
        eleLink.click();
        // 然后移除
        document.body.removeChild(eleLink);
    }

    //单个下载
    function downLoad(obj,filename,fileId){
        //获取td的文本框的值
        alert(filename,fileId)
        var fileCount = $(obj).parent().parent().find("td").eq(6).text();
        if(fileCount==""){
            fileCount = "0";
        }
        window.location.href="${pageContext.request.contextPath}/fileResourcesController/fileDownLoad.do?fileName="+filename+"&fileCount="+(parseInt(fileCount)+1)+"&fileId="+fileId;
        $("#"+fileId).text(parseInt(fileCount)+1);
        layer.msg('下载成功!',{icon:1,time:500});
    }

</script>-->



<body>
<div >
    <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
        <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
    </div>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <!--                       文件查询 -->
                    <div class="layui-card-body ">
                        <form class="layui-form layui-col-space5" action="${pageContext.request.contextPath}/fileResourcesController/fileResourcesPage.do">
                            <div class="layui-inline layui-show-xs-block">
                                <input class="layui-input" value="${fileResources.fileName}"  type="text" placeholder="文件名称" name="fileName" >
                            </div>
                            <div class="layui-inline layui-show-xs-block">
                                <input class="layui-input" value="${fileResources.fileProvider}"  type="text" placeholder="文件发布者" name="fileProvider" >
                            </div>
                            <div class="layui-inline layui-show-xs-block">
                                <button class="layui-btn" type="submit" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                <!--                                    <input class="layui-btn" type="submit" th:value=""><i class="layui-icon">&#xe615;</i></input>-->
                            </div>
                        </form>
                    </div>
                    <!--                        文件上传-->
                    <div class="layui-card-header">
                        <a class="layui-btn layui-btn-danger" onclick="downloadAll()"><i class="layui-icon">&#xe601;</i>批量下载</a>
                        <a type="button" class="layui-btn" id="uploadTest">
                            <i class="layui-icon">&#xe67c;</i>上传文件
                        </a>
                    </div>
                    <!--                       文件下载 -->
                    <div class="layui-card-body">
                        <table class="layui-table" >
                            <thead>
                            <tr>
                                <th >
                                    <input type="checkbox"  id="parentInput"  lay-skin="primary">
                                </th>
                                <th>文件编号</th>
                                <th>文件名称</th>
                                <th>文件大小</th>
                                <th>文件发布者</th>
                                <th>文件上传时间</th>
                                <th>文件下载次数</th>
                                <th>操作</th>
                            </thead>
                            <tbody >
                            <c:forEach items="${mapList.list}" var="list">
                            <tr>
                                <td>
                                    <input value="${list.fileId}" type="checkbox" id="ck"  lay-skin="primary">
                                </td>
                                <td>${list.fileId} </td>
                                <td>${list.fileName} </td>
                                <td>${list.fileSize}</td>
                                <td>${list.fileProvider}</td>
                                <td>${list.fileDate}</td>
                                <td id="${list.fileId}" >${list.fileCount}</td>
                                <td class="td-manage">
                                    <a title="下载" id="downLoadFile" onclick="downLoad(this,'${list.fileName}','${list.fileId}')">
                                        <i class="layui-icon">&#xe601;</i>
                                    </a>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="layui-card-body ">
                        <div class="page">
                            <div>
                                <a class="prev" href="${pageContext.request.contextPath}/fileResourcesController/fileResourcesPage.do?page=${mapList.firstPage}&fileName=${fileResources.fileName}">首页</a>
                                <a class="num" href="${pageContext.request.contextPath}/fileResourcesController/fileResourcesPage.do?page=${mapList.prePage}&fileName=${fileResources.fileName}">&lt;&lt;</a>
                                <span class="current"  href="${pageContext.request.contextPath}/fileResourcesController/fileResourcesPage.do?page=${mapList.currentPage}&fileName=${fileResources.fileName}">${mapList.currentPage}</span>
                                <a class="num" href="${pageContext.request.contextPath}/fileResourcesController/fileResourcesPage.do?page=${mapList.nextPage}&fileName=${fileResources.fileName}">&gt;&gt;</a>
                                <a class="next" href="${pageContext.request.contextPath}/fileResourcesController/fileResourcesPage.do?page=${mapList.lastPage}&fileName=${fileResources.fileName}">尾页</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    layui.use(['laydate','form','upload'], function(){
        var laydate = layui.laydate;
        var form = layui.form;
        var upload = layui.upload;
        //文件上传
        var uploadInst = upload.render(
            {
            //绑定元素
            elem: '#uploadTest',
            // 上传接口
            url: "${pageContext.request.contextPath}/fileResourcesController/fileTrans.do",
            accept:'file',
            type:"post",
            multiple:true,
            done: function(result){
                layer.msg('上传成功!',{icon:1,time:500});
                setTimeout(function(){
                    location.reload();
                },600);
            }
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

</script>

</html>
