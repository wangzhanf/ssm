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
    <title>后台管理</title>
    <meta charset="UTF-8"/>
    <base target="_self"/>

    <meta http-equiv="Content-Type" ; content="multipart/form-data; charset=utf-8"/>
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

<!--提示消息框-->
<div class="alert"></div>
<!-- 模态框 -->
<div class="modal fade" id="addModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">添加新用户</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <form action="${app}/customerrest/opt" enctype="multipart/form-data" class="form-horizontal"
                      role="form">
                    <%--input type="hidden" name="_method" value="POST" /--%>
                    <div class="form-group">
                        <label>cname:</label><input type="text" class="form-control" name="cname"/>
                    </div>
                    <div class="form-group">
                        <label>cphone:</label><input type="text" class="form-control" name="cphone"/>
                    </div>
                    <div class="form-group">
                        <label>cemail:</label><input type="email" class="form-control" name="cemail"/>
                    </div>
                    <div class="form-group">
                        <label>cpass:</label><input type="text" class="form-control" name="cpass"/>
                    </div>
                    <div class="form-group">
                        <label>caddress:</label><textarea class="form-control" name="caddress"></textarea>
                    </div>
                    <div class="form-group">
                        <label>cbirth:</label><input type="date" class="form-control" name="cbirth"/>
                    </div>
                    <div class="form-group">
                        <label>cavatar:</label>
                        <img data-my="disAvatar" src="" style="width: 100px;height: 100px;"/>
                        <input style="display: none;" type="file" class="form-control" data-my="inputAvatar"
                               name="file"/>
                    </div>
                    <div class="form-group">
                        <label>cgender: </label>
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" type="radio" value="1" name="cgender"/> 男
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" checked="checked" type="radio" value="0"
                                       name="cgender"/> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>cstatus: </label>
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" class="form-control" value="1"
                                       name="cstatus"/>是否禁用该用户
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <button id="addObjBtn" type="button" class="btn btn-block btn-primary">添加</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="updateModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">修改信息</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <form action="${app}/customerrest/opt" enctype="multipart/form-data" class="form-horizontal"
                      role="form">
                    <div class="form-group">
                        <label>cid:</label><input readonly="readonly" type="text" class="form-control" name="cid"/>
                    </div>
                    <div class="form-group">
                        <label>cname:</label><input type="text" class="form-control" name="cname"/>
                    </div>
                    <div class="form-group">
                        <label>cphone:</label><input type="text" class="form-control" name="cphone"/>
                    </div>
                    <div class="form-group">
                        <label>cemail:</label><input type="email" class="form-control" name="cemail"/>
                    </div>
                    <div class="form-group">
                        <label>cpass:</label><input type="text" class="form-control" name="cpass"/>
                    </div>
                    <div class="form-group">
                        <label>caddress:</label><textarea class="form-control" name="caddress"></textarea>
                    </div>
                    <div class="form-group">
                        <label>cbirth:</label><input type="date" class="form-control" name="cbirth"/>
                    </div>
                    <div class="form-group">
                        <label>cavatar:</label>
                        <img data-my="disAvatar" src="" style="width: 100px;height: 100px;"/>
                        <input style="display: none;" type="file" class="form-control" data-my="inputAvatar"
                               name="file"/>
                    </div>
                    <div class="form-group">
                        <label>cgender: </label>
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" type="radio" value="1" name="cgender"/> 男
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" checked="checked" type="radio" value="0"
                                       name="cgender"/> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>cstatus: </label>
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" class="form-control" value="1"
                                       name="cstatus"/>是否禁用该用户
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <button id="updateObjBtn" type="button" class="btn btn-block btn-primary">修改</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>

        </div>
    </div>
</div>


<form id="searchForm" method="get" action="${app}/customerrest/list">
    <input type="text" placeholder="cname" name="cname" value=""/>
    <input type="date" name="startDate" value="2020-10-01"/>
    <input type="date" name="endDate" value="2020-11-12"/>
    <input class="btn btn-secondary" type="button" id="searchCleanBtn" value="清除条件"/>
    <input class="btn btn-primary" type="button" id="searchBtn" value="查询"/>
</form>
<div>
    <!-- 按钮：用于打开模态框 -->
    <button id="openAddModalBtn" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">新增
    </button>
    <input class="btn btn-danger" type="button" action="${app}/customerrest/opt" id="deletesBtn" value="删除所选"/>
</div>
<table id="objTable" class="table table-striped table-bordered table-hover">
    <thead>
    <tr class="bg-primary text-white">
        <th>
            <input type="checkbox" id="choiceToggle"/>
            <input class="btn btn-sm btn-warning" type="button" id="reverseBtn" value="反选"/>
        </th>
        <th>序号#</th>
        <th>客户id</th>
        <th>姓名</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>密码</th>
        <th>地址</th>
        <th>生日</th>
        <th>头像</th>
        <th>性别</th>
        <th>状态</th>
        <th>创建时间(addTime)</th>
        <th>操作(修改)</th>
        <th>操作(删除)</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
<div class="row">
    <div id="pageList" class="col-12 col-md-8">

    </div>
    <div id="pageTips" class="col-12 col-md-4">

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
<script>
    //为了跳转页面方便,设置全局变量保存当前页和最大页码数
    var currentPage = 1;//当前页码
    var maxPages = 1;//最大页码

    $(document).ready(function () {
        //页面加载时向远端获取所有数据,页面定位在第1页
        gotoPage();
        //页面加载时给全选和反选按钮绑定事件
        mulCheck();
        //给查询按钮绑定事件
        $("#searchBtn").click(search);
        //给清除查询条件按钮绑定事件
        $("#searchCleanBtn").click(searchClean);
        //给删除多条记录的按钮绑定事件
        $("#deletesBtn").click(deleteMuliRecord);
        //给添加按钮绑定事件
        $("#openAddModalBtn").click(addForm);
        //点击添加按钮将新增数据存放到数据库
        $("#addObjBtn").click(addObj);
        //给每条记录的修改按钮添加事件
        $(document).on("click", ".upBtn", updateForm);
        //给每条记录的修改按钮添加事件
        $("#updateObjBtn").click(updateObj);
        //给每条记录的删除按钮添加事件
        $(document).on("click", ".delBtn", deleteSingleRecord);
        //给需要点击之后上传图片的区域添加点击事件,确保能够调用文件域的点击事件
        $('[data-my="disAvatar"]').click(function (eve) {
            $(eve.target).next('[type="file"]').click();
        });
        $('[data-my="inputAvatar"]').change(choiceAvatar);
    });

    //修改信息时从远端获取数据并填入表单
    function updateForm(eve) {
        //打开模态框
        $("#updateModal").modal({backdrop: "static"});
        //将表单中原有数据清空,包括数据区内容
        $("#updateModal form").get(0).reset();
        //从服务器获取信息填入修改表单中
        $.ajax({
            url: eve.target.href,
            type: "GET",
            success: function (result) {
                //回填数据
                $('#updateModal [name="cid"]').val(result.dataZone.obj.cid);
                $('#updateModal [name="cname"]').val(result.dataZone.obj.cname);
                $('#updateModal [name="cphone"]').val(result.dataZone.obj.cphone);
                $('#updateModal [name="cemail"]').val(result.dataZone.obj.cemail);
                $('#updateModal [name="cpass"]').val(result.dataZone.obj.cpass);
                $('#updateModal [name="caddress"]').val(result.dataZone.obj.caddress);
                $('#updateModal [name="cbirth"]').val(new Date(result.dataZone.obj.cbirth).Format("yyyy-MM-dd"));
                $('#updateModal [data-my="disAvatar"]').attr('src', result.dataZone.obj.cavatar == '' ? '/upload/null.png' : result.dataZone.obj.cavatar);
                //单选框的处理方式,注释留下供同学们参考
                // console.log("单选框的个数"+$('#updateModal [name="cgender"]').length);//2
                // console.log("服务器返回被选中的单选是"+result.dataZone.obj.cgender);//true或false
                //遍历整个单选列表
                $('#updateModal [name="cgender"]').each(function () {
                    // console.log("当前单选框的值"+$(this).val());//1或者0
                    if ($(this).val() == result.dataZone.obj.cgender) {
                        $(this).prop('checked', 'true');//和服务器匹配的选项默认设置为选中
                    }
                });
                // 复选框的处理方式
                $('#updateModal [name="cstatus"]').prop('checked', result.dataZone.obj.cstatus);
                $('#updateModal [name="addTime"]').val(new Date(result.dataZone.obj.addTime).Format("yyyy-MM-dd HH:mm:ss"));

            },
            error: function () {
            }
        });

        return false;//取消超链接的默认跳转
    }

    //解析数据并渲染
    function parseDataAndShow(result) {
        $("#objTable tbody").empty();
        // 获取数据集合
        let lists = result.dataZone.pageInfo.list;
        $.each(lists, function (index, item) {
            //构建行
            var uTr = $("<tr></tr>");
            //构建多个单元格
            var checkboxTh = $('<th><input type="checkbox" name="choiceList" value="${item.cid}"/></th>');
            var countTh = $('<th></th>').text(index + 1);
            var td1 = $('<td></td>').text(item.cid);
            var td2 = $('<td></td>').text(`
                <a href="${app}/ordersrest/cusorders/${item.cid}">${item.cname}</a>
            `);
            var td3 = $('<td></td>').text(item.cphone);
            var td4 = $('<td></td>').text(item.cemail);
            var td5 = $('<td></td>').text(item.cpass);
            var td6 = $('<td></td>').text(item.caddress);
            var td7 = $('<td></td>').text(new Date(item.cbirth).Format("yyyy-MM-dd"));
            var td8 = $('<td></td>').text(item.cavatar);
            //如果显示布尔值,建议使用三元表达式快速处理
            var td9 = $('<td></td>').text(item.cgender == true ? '男' : '女');
            var td10 = $('<td></td>').text(item.cstatus == true ? '禁用' : '启用');
            var addTimeTd = $('<td></td>').text(new Date(item.addTime).Format("yyyy-MM-dd HH:mm:ss"));
            var upBtnTd = $('<td></td>').html('<a class="upBtn btn btn-info btn-sm" href="${app}/customerrest/opt/' + item.cid + '">修改</a>');
            var delBtnTd = $('<td></td>').html('<a class="delBtn btn btn-danger btn-sm" href="${app}/customerrest/opt/' + item.cid + '">删除</a>');
            //将单元格追加到行中
            uTr.append(checkboxTh).append(countTh)
                .append(td1).append(td2).append(td3).append(td4).append(td5)
                .append(td6).append(td7).append(td8).append(td9).append(td10)
                .append(addTimeTd)
                .append(upBtnTd).append(delBtnTd);
            // 将行追加到表体中
            $("#objTable tbody").append(uTr);
        });
    }
</script>
</body>
</html>
