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

    <meta http-equiv="Content-Type"; content="multipart/form-data; charset=utf-8"/>
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
                <form method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
                    <%--input type="hidden" name="_method" value="POST" /--%>
                    <div class="form-group">
                        <label>cname:</label><input type="text" class="form-control"  name="cname"/>
                    </div>
                        <div class="form-group">
                            <label>cphone:</label><input type="text" class="form-control"  name="cphone"/>
                        </div>
                        <div class="form-group">
                            <label>cemail:</label><input type="email" class="form-control"  name="cemail"/>
                        </div>
                        <div class="form-group">
                            <label>cpass:</label><input type="text" class="form-control"  name="cpass"/>
                        </div>
                    <div class="form-group">
                        <label>caddress:</label><textarea class="form-control" name="caddress"></textarea>
                    </div>
                        <div class="form-group">
                            <label>cbirth:</label><input type="date" class="form-control"  name="cbirth"/>
                        </div>
                    <div class="form-group">
                        <label>cavatar:</label>
                        <img data-my="disAvatar" src="" style="width: 100px;height: 100px;" />
                        <input style="display: none;" type="file" class="form-control" data-my="inpucavatar" name="file" placeholder="avatar">
                    </div>
                        <div class="form-group">
                            <label>cgender:</label>
                            <label><input type="radio" class="form-control" value="true"  name="cgender"/>男</label>
                            <label><input type="radio" class="form-control" value="false"  name="cgender"/>女</label>
                        </div>
                        <div class="form-group">
                            <label>cstatus:</label>
                            <input type="checkbox" class="form-control" value="true"  name="cstatus"/>是否禁用</label>
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
                <form method="post"  enctype="multipart/form-data" class="form-horizontal" role="form">
                    <div class="form-group">
                        <label>cname:</label><input type="text" class="form-control"  name="cname"/>
                    </div>
                    <div class="form-group">
                        <label>cphone:</label><input type="text" class="form-control"  name="cphone"/>
                    </div>
                    <div class="form-group">
                        <label>cemail:</label><input type="email" class="form-control"  name="cemail"/>
                    </div>
                    <div class="form-group">
                        <label>cpass:</label><input type="text" class="form-control"  name="cpass"/>
                    </div>
                    <div class="form-group">
                        <label>caddress:</label><textarea class="form-control" name="caddress"></textarea>
                    </div>
                    <div class="form-group">
                        <label>cbirth:</label><input type="date" class="form-control"  name="cbirth"/>
                    </div>
                    <div class="form-group">
                        <label>cavatar:</label>
                        <img data-my="disAvatar" src="" style="width: 100px;height: 100px;" />
                        <input style="display: none;" type="file" class="form-control" data-my="inpucavatar" name="file" placeholder="avatar">
                    </div>
                    <div class="form-group">
                        <label>cgender:</label>
                        <label><input type="radio" class="form-control" value="true"  name="cgender"/>男</label>
                        <label><input type="radio" class="form-control" value="false"  name="cgender"/>女</label>
                    </div>
                    <div class="form-group">
                        <label>cstatus:</label>
                        <input type="checkbox" class="form-control" value="true"  name="cstatus"/>是否禁用</label>
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
    <input class="btn btn-primary" type="button" id="searchBtn" value="查询"/>
</form>
<div>
    <!-- 按钮：用于打开模态框 -->
    <button id="openAddModalBtn" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">新增
    </button>
    <input class="btn btn-danger" type="button" id="deletesBtn" value="删除所选"/>
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
    var currentPage=1;//当前页码
    var maxPages=1;//最大页码

    $(document).ready(function () {
        //页面加载时向远端获取所有数据,页面定位在第1页
        gotoPage();
        //页面加载时给全选和反选按钮绑定事件
        mulCheck();
        //给查询按钮绑定事件
        $("#searchBtn").click(search);
        //给删除多条记录的按钮绑定事件
        $("#deletesBtn").click(deleteMuliRecord);
        //给添加按钮绑定事件
        $("#openAddModalBtn").click(addForm);
        //点击添加按钮将新增数据存放到数据库
        $("#addObjBtn").click(addObj);
        //给每条记录的修改按钮添加事件
        $(document).on("click", ".upBtn", updateForm);
        //给修改用户信息的按钮添加事件
        $("#updateObjBtn").click(updateObj);
        //给每条记录的删除按钮添加事件
        $(document).on("click", ".delBtn", deleteSingleRecord);
        //给需要点击之后上传图片的区域添加点击事件,确保能够调用文件域的点击事件
        $('[data-my="disAvatar"]').click(function (eve) {$(eve.target).next('[type="file"]').click();});
        $('[data-my="inpucavatar"]').change(choiceAvatar);
    });

    //点击图片能够调用 文件域的点击事件

    //文件域的值发生改变,将图片改变
    function choiceAvatar(e){
        var eve = e;//传递过来的元素因为会被在传递的链条中更改,所以暂存一下
        var reader = new FileReader();
        reader.onload = (function () {
            return function (e) {
                //修改显示图片,因为采用了相邻选择器,所以一定要注意HTML元素中对应的位置
                $(eve.target).prev('img').attr('src',this.result);
            }
        })(e.target.files[0]);
        reader.readAsDataURL(e.target.files[0]);
    };


    //获取外键对应主键表中的相关字段并填写到下拉列表中
    function getAndFill(url,comp,valueName,disName,choice){
        //清空原有列表
        comp.empty();

        $.ajax({
            url:url,
            type:"GET",
            success:function(res){
                $.each(res.dataZone.lists,function(index,item){
                    if(choice==valueName){
                        //如果传递了默认的被选中项,则使用selected属性使之默认选中,此代码适用于datalist和select组件
                        comp.append('<option selected="selected" value="'+item[valueName]+'">'+item[disName]+'</option>');
                    }else{
                        comp.append('<option value="'+item[valueName]+'">'+item[disName]+'</option>');
                    }

                });
            }
        });
    }


    //搜索功能的实现
    function search() {
        //修改数据之前先进行数据校验
        //校验通过向服务器发送请求
        // alert("search被调用了");
        $.ajax({
            url: "${app}/customerrest/list",
            type: "GET",
            data: $("#searchForm").serialize(),
            success: function (result) {
                gotoPage();//回到第一页
            },
            error: function (result) {
                alertTips(result.message,"alert-danger");
                return false;
            }
        });
    }

    //修改信息时从远端获取数据并填入表单
    function updateForm(ele) {
        //打开模态框
        $("#updateModal").modal({backdrop: "static"});
        //将表单中原有数据清空,包括数据区内容
        $("#updateModal form").get(0).reset();
        //从服务器获取信息填入修改表单中
        $.ajax({
            url: ele.target.href,
            type: "GET",
            success: function (result) {
                //回填数据
                $('#updateModal [name="cid"]').val(result.dataZone.obj.cid);
                $('#updateModal [name="cname"]').val(result.dataZone.obj.cname);
                $('#updateModal [name="cphone"]').val(result.dataZone.obj.cphone);
                $('#updateModal [name="cemail"]').val(result.dataZone.obj.cemail);
                $('#updateModal [name="cpass"]').val(result.dataZone.obj.cpass);
                $('#updateModal [name="caddress"]').val(result.dataZone.obj.caddress);
                $('#updateModal [name="cbirth"]').val(result.dataZone.obj.cbirth);
                $('#updateModal [data-my="disAvatar"]').attr('src',result.dataZone.obj.cavatar);
                $('#updateModal [name="cgender"]').val(result.dataZone.obj.cgender);
                $('#updateModal [name="cstatus"]').val(result.dataZone.obj.cstatus);
                $('#updateModal [name="addTime"]').val(new Date(result.dataZone.obj.addTime).Format("yyyy-MM-dd"));

            },
            error: function () {
            }
        });

        return false;//取消超链接的默认跳转
    }

    //提交用户修改的信息
    function updateObj() {
        //修改数据之前先进行数据校验
        //校验通过向服务器发送请求
        var formData = new FormData($("#updateModal form").get(0));

        $.ajax({
            url: "${app}/customerrest/opt",
            type: "PUT",  //已经更改为可以通过post或者put方式更新图片,保留了通过post的方式更新图片的方法
            data: formData,
            dataType:"json",
            contentType:false,//此处对应head处的文档声明
            processData:false,//取消默认的预处理行为
            enctype: "multipart/form-data",//指定封装的类型
            success: function (result) {
                $("#updateModal").modal("hide");//关闭模态框
                gotoPage(currentPage);//回到当前页面
                alertTips(result.message,"alert-success");
            },
            error: function (result) {
                alertTips(result.message,"alert-danger");
                return false;
            }
        });
    }

    //打开添加的模态框并清空原有数据
    function addForm() {
        //打开模态框
        $("#addModal").modal({backdrop: "static"});

        //将表单中原有数据清空,包括默认的图片缓存内容
        $('#addModal [data-my="disAvatar"]').attr('src','/upload/null.png');
        $("#addModal form").get(0).reset();
    }
    //添加指定对象的操作
    function addObj() {
        //添加数据之前先进行数据校验
        //校验通过向服务器发送请求
        //如果使用ajax上传文件,需要将数据提前处理一下
        var formData = new FormData($("#addModal form").get(0));

        $.ajax({
            url: "${app}/customerrest/opt",
            type: "POST",
            data: formData,
            dataType:"json",
            contentType:false,//此处对应head处的文档声明
            processData:false,//取消默认的预处理行为
            success: function (result) {
                $("#addModal").modal("hide");//关闭模态框
                gotoPage(maxPages+1);//到最后一页,想想为什么要加1
                alertTips(result.message,"alert-success");
            },
            error: function (result) {
                alertTips(result.message,"alert-danger");
                return false;
            }
        });
    }

    //删除单条记录
    function deleteSingleRecord(ele) {
        //询问是否删除
        if (!confirm("真的删除"))
            return false;
        $.ajax({
            url: ele.target.href,
            type: "DELETE",
            success: function (result) {
                alertTips(result.message,"alert-success");
                gotoPage(currentPage);
            },
            error: function (result) {
                alertTips(result.message,"alert-danger");
            }
        });
        return false;
    }

    //删除多条记录
    function deleteMuliRecord() {
        //点击删除所选按钮时删除多条记录

        var ids = "";//需要传递给服务器的uid列表
        var names = "";//需要显式给操作者看的提示信息列表
        $("[name=choiceList]:checkbox").each(function () {
            if (this.checked) {
                ids += $(this).parents("tr").find("td:eq(0)").text() + ",";//通过 - 连接
                names += $(this).parents("tr").find("td:eq(1)").text() + ",";//通过 , 连接
            }
        });
        ids = ids.substr(0, ids.length - 1);//去掉最后的一个 -
        names = names.substr(0, names.length - 1);//去掉最后的一个 ,
        //询问用户操作
        if (confirm("是否删除" + names + "的记录")) {
            //向服务器发送请求,我们已经使用过get和post方法,这次使用最底层的ajax方法
            $.ajax({
                type: "DELETE",
                url: "${app}/customerrest/opt/" + ids,
                success: function (result) {
                    gotoPage(currentPage);
                    alertTips(result.message,"alert-success");
                },
                error: function () {
                }
            });
        }
    }

    //跳转到指定页码
    function gotoPage(pageNum, pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        $.ajax({
            type: "GET",
            url: "${app}/customerrest/list?pageNum=" + pageNum + "&pageSize=" + pageSize,
            dataType: "json",
            data: $("#searchForm").serialize(),
            success: function (result) {
                // 解析返回的json数据并显示到界面中,封装为函数吧,太多东西了
                currentPage = result.dataZone.pageInfo.pageNum;
                maxPages = result.dataZone.pageInfo.pages;
                parseDataAndShow(result);
                //解析渲染分页条
                parsePageAndShow(result);
            },
            error: function () {
                alert("数据出错,请调试程序");
            }
        });
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
            var td2 = $('<td></td>').text(item.cname);
            var td3 = $('<td></td>').text(item.cphone);
            var td4 = $('<td></td>').text(item.cemail);
            var td5 = $('<td></td>').text(item.cpass);
            var td6 = $('<td></td>').text(item.caddress);
            var td7 = $('<td></td>').text(item.cbirth);
            var td8 = $('<td></td>').text(item.cgender);
            var td9 = $('<td></td>').text(item.cstatus);
            var addTimeTd = $('<td></td>').text(new Date(item.addTime).Format("yyyy-MM-dd HH:mm:ss"));
            var upBtnTd = $('<td></td>').html('<a class="upBtn btn btn-info btn-sm" href="${app}/customerrest/opt/' + item.cid + '">修改</a>');
            var delBtnTd = $('<td></td>').html('<a class="delBtn btn btn-danger btn-sm" href="${app}/customerrest/opt/' + item.cid + '">删除</a>');
            //将单元格追加到行中
            uTr.append(checkboxTh).append(countTh)
                .append(td1).append(td2).append(td3).append(td4).append(td5)
                .append(td6).append(td7).append(td8).append(td9)
                .append(addTimeTd)
                .append(upBtnTd).append(delBtnTd);
            // 将行追加到表体中
            $("#objTable tbody").append(uTr);
        });
    }
    //解析页码并渲染
    function parsePageAndShow(result) {
        //因为是不跨页面的刷新操作,所以操作前先清空当前节点内容
        $("#pageTips").empty();
        $("#pageList").empty();

        var pageInfo = result.dataZone.pageInfo;
        //

        //构建分页信息
        $("#pageTips").html("共" + pageInfo.total + "条记录," + pageInfo.pages + "页,每页" + pageInfo.pageSize + "条");
        //构建分页列表
        var oUl = $("<ul></ul>").addClass("pagination");
        var firstLi = $("<li></li>").addClass("page-item").append($("<a></a>").text("首页").addClass("page-link").attr("href", "#"));
        var preLi = $("<li></li>").addClass("page-item").append($("<a></a>").text("上一页").addClass("page-link").attr("href", "#"));
        if (pageInfo.isFirstPage) {
            firstLi.addClass("disabled");
            preLi.addClass("disabled");
        }
        oUl.append(firstLi).append(preLi);

        $.each(pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").addClass("page-item").append($("<a></a>").text(item).addClass("page-link").attr("href", "#"));
            if (pageInfo.pageNum == item)
                numLi.addClass("active");
            //给页码绑定点击事件,能够跳转页面
            numLi.click(function () {
                gotoPage(item);//跳转到指定页面
            });

            numLi.appendTo(oUl);
        });

        var lastLi = $("<li></li>").addClass("page-item").append($("<a></a>").text("尾页").addClass("page-link").attr("href", "#"));
        var nextLi = $("<li></li>").addClass("page-item").append($("<a></a>").text("下一页").addClass("page-link").attr("href", "#"));
        if (pageInfo.isLastPage) {
            nextLi.addClass("disabled");
            lastLi.addClass("disabled");
        }
        //给其他页码标签绑定事件
        firstLi.click(function () {
            gotoPage(1)
        });
        preLi.click(function () {
            gotoPage(pageInfo.pageNum - 1)
        });
        nextLi.click(function () {
            gotoPage(pageInfo.pageNum + 1)
        });
        lastLi.click(function () {
            gotoPage(pageInfo.pages + 1)
        });//因为设置了分页插件的合理化配置,所以给一个很大的值就会到最后一页
        oUl.append(nextLi).append(lastLi);

        $("#pageList").append(oUl);

        //解除不能点击按钮的事件
        //分页代码中的部分属性点击失去链接属性,因为这是dom刷新后添加的事件,所以取消默认行为已经不好用了
        $(".pagination .disabled,.pagination .active").off("click");

    }
    //多选按钮组的操作
    function mulCheck() {
        //全选和反选的操作
        $("#choiceToggle").click(function () {
            $("[name=choiceList]:checkbox").prop("checked", this.checked);
        });

        //选中所有子项全选被选中
        //因为通过ajax动态生成该复选框组件,所以以前写的绑定代码不能使用
        //通过dom加载的元素绑定事件使用on方法,不了解看第2天的视频
        //通过事件委托的方式实现绑定(首先需要理解事件冒泡的概念)
        $(document).on("click", function () {
            var flag = true;
            $("[name=choiceList]:checkbox").each(function () {
                if (!this.checked) {
                    flag = false;
                }
            });
            $("#choiceToggle").prop("checked", flag);
        });

        //反选操作
        $("#reverseBtn").click(function () {
            $("[name=choiceList]:checkbox").each(function () {
                this.checked = !this.checked;
            });
        });
    }

    //完成后弹出消息框
    function alertTips(message,alert_type){
        $('.alert').html(message).removeAttr("class").addClass(alert_type).show().delay(1000).fadeOut();
    }


    //日期转换,基于原型的设计方式,可以确保按照自己定义的类型方式进行展示
    Date.prototype.Format = function (fmt) { // author: meizz
        var o = {
            "M+": this.getMonth() + 1, // 月份
            "d+": this.getDate(), // 日
            "H+": this.getHours(), // 小时
            "m+": this.getMinutes(), // 分
            "s+": this.getSeconds(), // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
            "S": this.getMilliseconds()
            // 毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
                .substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
                    : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };
    //解析不同格式日期的模式
    function parseISO8601(dateStringInRange) {
        var isoExp = /^\s*(\d{4})-(\d\d)-(\d\d)\s(\d\d):(\d\d)\s*$/, date = new Date(
            NaN), month, hour, min, parts = isoExp.exec(dateStringInRange);

        if (parts) {
            month = +parts[2];
            hour = +parts[4];
            min = +parts[5];
            date.setFullYear(parts[1], month - 1, parts[3]);
            date.setHours(hour, min, 0, 0);
            if (month != date.getMonth() + 1) {
                date.setTime(NaN);
            }
        }
        return date;
    }
    //基于日期类型的判断
    function isValidDate(d) {
        if (Object.prototype.toString.call(d) !== "[object Date]")
            return false;
        return !isNaN(d.getTime());
    }
</script>
</body>
</html>
