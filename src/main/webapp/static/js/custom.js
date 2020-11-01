;
;
;
//点击图片能够调用 文件域的点击事件

//文件域的值发生改变,将图片改变
function choiceAvatar(eve) {
    let that = eve;//传递过来的元素因为会被在传递的链条中更改,所以暂存一下
    let reader = new FileReader();
    reader.onload = (function () {
        return function (eve) {
            //修改显示图片,因为采用了相邻选择器,所以一定要注意HTML元素中对应的位置
            $(that.target).prev('img').attr('src', this.result);
        }
    })(eve.target.files[0]);
    reader.readAsDataURL(eve.target.files[0]);
}

//获取外键对应主键表中的相关字段并填写到下拉列表中
function getAndFill(url, comp, valueName, disName, choice) {
    //清空原有列表
    comp.empty();
    $.ajax({
        url: url,
        type: "GET",
        success: function (res) {
            $.each(res.dataZone.lists, function (index, item) {
                if (choice == valueName) {
                    //如果传递了默认的被选中项,则使用selected属性使之默认选中,此代码适用于datalist和select组件
                    comp.append('<option selected="selected" value="' + item[valueName] + '">' + item[disName] + '</option>');
                } else {
                    comp.append('<option value="' + item[valueName] + '">' + item[disName] + '</option>');
                }
            });
        }
    });
}

//清除查询条件
function searchClean(eve) {
    $(eve.target).parent("form").get(0).reset();
}

//搜索功能的实现
function search(eve) {
    //修改数据之前先进行数据校验
    //校验通过向服务器发送请求
    // alert("search被调用了");
    //20201029更新,搜索框使用传值的方式处理
    //let url = $(eve.target).parent("form").attr("action");
    let url = $("#searchForm").attr("action");
    $.ajax({
        url: url,
        type: "GET",
        data: $("#searchForm").serialize(),
        success: function (result) {
            gotoPage();//回到第一页
        },
        error: function (result) {
            alertTips(result.message, "alert-danger");
            return false;
        }
    });
}

//提交用户修改的信息
function updateObj() {
    //修改数据之前先进行数据校验
    //校验通过向服务器发送请求
    let formData = new FormData($("#updateModal form").get(0));
    let url = $("#updateModal form").attr("action");
    $.ajax({
        url: url,
        type: "PUT",  //已经更改为可以通过post或者put方式更新图片,保留了通过post的方式更新图片的方法
        data: formData,
        dataType: "json",
        contentType: false,//此处对应head处的文档声明
        processData: false,//取消默认的预处理行为
        enctype: "multipart/form-data",//指定封装的类型
        success: function (result) {
            $("#updateModal").modal("hide");//关闭模态框
            gotoPage(currentPage);//回到当前页面
            alertTips(result.message, "alert-success");
        },
        error: function (result) {
            alertTips(result.message, "alert-danger");
            return false;
        }
    });
}
//打开显示信息模态框
function displayInfo(eve) {
    //打开模态框
    $("#displayInfo").modal({backdrop: "static"});
    $("#displayInfo .modal-body").empty();
    let url = eve.target.href;
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            for (let i = 0; i < result.dataZone.lists.length; i++) {
                $("#displayInfo .modal-body").append(JSON.stringify(result.dataZone.lists[i]));
            }
        },
        error: function (result) {
            alertTips(result.message, "alert-danger");
            return false;
        }
    });

    return false;
}

//改变状态的操作
function changeStatus(eve){
    let url = eve.target.href;
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            alertTips(result.message, "alert-success");
            gotoPage(currentPage);
        }
    });
    return false;
}

//打开添加的模态框并清空原有数据
function addForm() {
    //打开模态框
    $("#addModal").modal({backdrop: "static"});

    //将表单中原有数据清空,包括默认的图片缓存内容
    $('#addModal [data-my="disAvatar"]').attr('src', '/upload/null.png');
    $("#addModal form").get(0).reset();
}

//添加指定对象的操作
function addObj() {
    //添加数据之前先进行数据校验
    //校验通过向服务器发送请求
    //如果使用ajax上传文件,需要将数据提前处理一下
    let formData = new FormData($("#addModal form").get(0));
    let url = $("#addModal form").attr("action");
    $.ajax({
        url: url,
        type: "POST",
        data: formData,
        dataType: "json",
        contentType: false,//此处对应head处的文档声明
        processData: false,//取消默认的预处理行为
        success: function (result) {
            $("#addModal").modal("hide");//关闭模态框
            gotoPage(maxPages + 1);//到最后一页,想想为什么要加1
            alertTips(result.message, "alert-success");
        },
        error: function (result) {
            alertTips(result.message, "alert-danger");
            return false;
        }
    });
}

//删除单条记录
function deleteSingleRecord(eve) {
    //询问是否删除
    if (!confirm("真的删除"))
        return false;
    $.ajax({
        url: eve.target.href,
        type: "DELETE",
        success: function (result) {
            alertTips(result.message, "alert-success");
            gotoPage(currentPage);
        },
        error: function (result) {
            alertTips(result.message, "alert-danger");
        }
    });
    return false;
}

//删除多条记录
function deleteMuliRecord(eve) {
    //点击删除所选按钮时删除多条记录
    let url = $(eve.target).attr("action");
    let ids = "";//需要传递给服务器的uid列表
    let names = "";//需要显式给操作者看的提示信息列表
    $("[name=choiceList]:checkbox").each(function () {
        if (this.checked) {
            ids += $(this).parents("tr").find("td:eq(0)").text() + ",";//通过 - 连接
            names += $(this).parents("tr").find("td:eq(1)").text() + ",";//通过 , 连接
        }
    });
    ids = ids.substr(0, ids.length - 1);//去掉最后的一个 -
    names = names.substr(0, names.length - 1);//去掉最后的一个 ,
    //首先判断是否选择了数据
    if(ids.length==0){//如果没有任何选择,则不做任何操作
        alertTips('你没有选择任何信息', "alert-danger");
        return ;
    }
    //询问用户操作
    if (confirm("是否删除" + names + "的记录")) {
        //向服务器发送请求,我们已经使用过get和post方法,这次使用最底层的ajax方法
        $.ajax({
            type: "DELETE",
            url: url + "/" + ids,
            success: function (result) {
                gotoPage(currentPage);
                alertTips(result.message, "alert-success");
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
    let url = $("#searchForm").attr("action");
    $.ajax({
        type: "GET",
        url: url + "?pageNum=" + pageNum + "&pageSize=" + pageSize,
        dataType: "json",
        data: $("#searchForm").serialize(),//翻页的时候要带着检索信息
        success: function (result) {
            currentPage = result.dataZone.pageInfo.pageNum;
            maxPages = result.dataZone.pageInfo.pages;
            // 解析返回的json数据并显示到界面中,封装为函数吧,太多东西了
            parseDataAndShow(result);
            //解析渲染分页条
            parsePageAndShow(result);
        },
        error: function () {
            alert("数据出错,请调试程序");
        }
    });
}

//解析页码并渲染
function parsePageAndShow(result) {
    //因为是不跨页面的刷新操作,所以操作前先清空当前节点内容
    $("#pageTips").empty();
    $("#pageList").empty();

    let pageInfo = result.dataZone.pageInfo;
    //

    //构建分页信息
    $("#pageTips").html("共" + pageInfo.total + "条记录," + pageInfo.pages + "页,每页" + pageInfo.pageSize + "条");
    //构建分页列表
    let oUl = $("<ul></ul>").addClass("pagination");
    let firstLi = $("<li></li>").addClass("page-item").append($("<a></a>").text("首页").addClass("page-link").attr("href", "#"));
    let preLi = $("<li></li>").addClass("page-item").append($("<a></a>").text("上一页").addClass("page-link").attr("href", "#"));
    if (pageInfo.isFirstPage) {
        firstLi.addClass("disabled");
        preLi.addClass("disabled");
    }
    oUl.append(firstLi).append(preLi);

    $.each(pageInfo.navigatepageNums, function (index, item) {
        let numLi = $("<li></li>").addClass("page-item").append($("<a></a>").text(item).addClass("page-link").attr("href", "#"));
        if (pageInfo.pageNum == item)
            numLi.addClass("active");
        //给页码绑定点击事件,能够跳转页面
        numLi.click(function () {
            gotoPage(item);//跳转到指定页面
        });

        numLi.appendTo(oUl);
    });

    let lastLi = $("<li></li>").addClass("page-item").append($("<a></a>").text("尾页").addClass("page-link").attr("href", "#"));
    let nextLi = $("<li></li>").addClass("page-item").append($("<a></a>").text("下一页").addClass("page-link").attr("href", "#"));
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
        let flag = true;
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
function alertTips(message, alert_type) {
    $('.alert').html(message).removeAttr("class").addClass('alert').addClass(alert_type).show().delay(2000).fadeOut();
}




//日期转换,基于原型的设计方式,可以确保按照自己定义的类型方式进行展示
Date.prototype.Format = function (fmt) { // author: meizz
    let o = {
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
    for (let k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
                : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

//解析不同格式日期的模式
function parseISO8601(dateStringInRange) {
    let isoExp = /^\s*(\d{4})-(\d\d)-(\d\d)\s(\d\d):(\d\d)\s*$/, date = new Date(
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