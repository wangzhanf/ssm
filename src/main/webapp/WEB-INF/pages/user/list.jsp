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
    <title>用户管理页面</title>
    <meta charset="UTF-8"/>
    <base target="_self"/>
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
<a href="${app}/">返回管理后台</a>
<h6>此页面展示的功能是多页中实现增删改查功能</h6>
<hr/>
<a class="btn btn-primary" href="${app}/user/ins">添加新用户</a>
<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr class="bg-primary text-white">
        <th>序号</th>
        <th>uid</th>
        <th>username</th>
        <th>password</th>
        <th>addTime</th>
        <th>opt</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list}" var="user" varStatus="status">
        <tr>
            <td>${status.index}</td>
            <td>${user.uid}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <fmt:formatDate value="${user.addTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
            </td>
            <td>
                <a class="btn btn-primary btn-sm" href="${app}/user/upt?uid=${user.uid}"><i class="fa fa-pencil"></i> 修改</a>
                <a class="btn btn-danger btn-sm" href="${app}/user/delete?uid=${user.uid}"><i class="fa fa-trash"></i>
                    删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="row">
    <div class="col-12 col-md-8">
        <ul class="pagination">
            <li class='page-item <c:if test="${pageInfo.isFirstPage}">disabled</c:if>'><a class="page-link"
                                                                                          href="${app}/user/list?pageNum=1">首页</a>
            </li>
            <li class='page-item <c:if test="${not pageInfo.hasPreviousPage}">disabled</c:if>'><a class="page-link"
                                                                                                  href="${app}/user/list?pageNum=${pageInfo.pageNum-1}">上一页</a>
            </li>
            <c:forEach begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}" var="i">
                <li class='page-item <c:if test="${pageInfo.pageNum == i}">active</c:if>'><a class="page-link"
                                                                                             href="${app}/user/list?pageNum=${i}">${i}</a>
                </li>
            </c:forEach>
            <li class='page-item <c:if test="${not pageInfo.hasNextPage}">disabled</c:if>'><a class="page-link"
                                                                                              href="${app}/user/list?pageNum=${pageInfo.pageNum+1}">下一页</a>
            </li>
            <li class='page-item <c:if test="${pageInfo.isLastPage}">disabled</c:if>'><a class="page-link"
                                                                                         href="${app}/user/list?pageNum=${pageInfo.pages}">尾页</a>
            </li>
        </ul>
    </div>
    <div class="col-12 col-md-4">
        共${pageInfo.total}条记录,${pageInfo.pages}页,每页${pageInfo.pageSize}条
    </div>
</div>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="${app}/static/js/jquery-3.3.1.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="${app}/static/js/bootstrap.js"></script>
<script src="${app}/static/js/vue.js"></script>
<script src="${app}/static/js/vue-resources.js"></script>
<script src="${app}/static/js/vue-router.js"></script>
<script src="${app}/static/js/axios.js"></script>
<script src="${app}/static/js/custom.js"></script>
</body>
</html>
