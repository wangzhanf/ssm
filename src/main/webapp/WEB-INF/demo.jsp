<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/19 0019
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--引入jstl的标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--引入jstl的格式化标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--引入spring的表单标签库--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
    <meta charset="UTF-8"/>
    <base target="_self" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- 引入 Bootstrap -->
    <link href="${app}/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="${app}/static/css/animate.css" rel="stylesheet"/>
    <link href="${app}/static/css/font-awesome.css" rel="stylesheet"/>
    <link href="${app}/static/css/custom.css" rel="stylesheet"/>

    <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js" rel="external nofollow"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js" rel="external nofollow"></script>
    <![endif]-->
</head>
<body>
<%--spring的工作就是自动封装和扫描bean--%>
    <div class="container">
        <form method="post" enctype="multipart/form-data" action="${appContext}/userinfo/update" class="form-horizontal" role="form">
            <div class="form-group">
                <label class="col-sm-2 control-label">基本信息</label>
                <div class="col-sm-10">
                    <p class="form-control-static">UIID:${userinfo.uiid}</p>
                    <p class="form-control-static">FUID:${userinfo.fuid}</p>

                    <input type="hidden" name="uiid" value="${userinfo.uiid}" />
                    <input type="hidden" name="fuid" value="${userinfo.fuid}" />
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">电话号码</label>
                <div class="col-sm-10">
                    <input type="text" value="${userinfo.phone}"  class="form-control" id="phone" name="phone" placeholder="phone">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPhoto" class="col-sm-2 control-label">photo</label>
                <div class="col-sm-10">
                    <img id="userPhoto" src="${appContext}/${userinfo.email}" style="width: 100px;height: 100px;" />
                    <input style="display: none;" type="file" value="${userinfo.email}"  class="form-control" id="inputPhoto" name="file" placeholder="photo">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">gender</label>
                <div class="col-sm-10">
                    <input
                            <c:if test="${userinfo.gender=='M'}">checked="checked"</c:if>
                            type="radio" name="gender" value="M" />M
                    <input
                            <c:if test="${userinfo.gender=='F'}">checked="checked"</c:if>
                            type="radio" name="gender" value="F" />F
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-block btn-primary">修改</button>
                </div>
            </div>

        </form>
    </div>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="${app}/static/js/jquery-3.3.1.js" ></script>
<!-- 包括所有已编译的插件 -->
<script src="${app}/static/js/bootstrap.js"></script>
<script src="${app}/static/js/vue.js"></script>
<script src="${app}/static/js/vue-resources.js"></script>
<script src="${app}/static/js/vue-router.js"></script>
<script src="${app}/static/js/axios.js"></script>
<script src="${app}/static/js/custom.js"></script>
<script>
    $(function(){
        //点击图片能够调用 文件域的点击事件
        $("#userPhoto").click(function () {
            $("#inputPhoto").click();
        });
        //文件域的值发生改变,将图片改变
        $("#inputPhoto").change(function (e) {
            var reader = new FileReader();
            reader.onload = (function () {
                return function (e) {
                    $("#userPhoto").attr('src',this.result);
                }
            })(e.target.files[0]);
            reader.readAsDataURL(e.target.files[0]);
        });
    });
</script>
</body>
</html>
