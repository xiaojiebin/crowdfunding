var str = "";
var j = 0;
var pageNum;
var total;
var project_path = "/myProject/user";
var user_id ;

//数据展示+分页
function page(pageNum_P) {
    document.getElementById("check").checked=false;
    pageNum = pageNum_P;
    $.ajax({
        url: project_path + "/user.do",
        type: "POST",
        data: {
            pageNum: pageNum
        },
        beforeSend: function () {
            return true;
        },
        success: function (data) {
            j = 0;
            str = "";
            $('tbody').empty();
            var i = pageNum;
            total = data.result[0].totalPage;
            j = i == 1 ? 1 : (i - 1) * 10 + 1;
            $.each(data.result, function (i, obj) {
                // console.log(i + ":" + obj.id);
                str += " <tr>\n" +
                    "                                <td>" + (j++) + "</td>\n" +
                    "                                <td><input type=\"checkbox\" name='user' value=" + obj.id + "></td>\n" +
                    "                                <td>" + obj.loginacct + "</td>\n" +
                    "                                <td>" + obj.username + "</td>\n" +
                    "                                <td>" + obj.email + "</td>\n" +
                    "                                <td>\n" +
                    "                                    <button type=\"button\" class=\"btn btn-success btn-xs\"><i\n" +
                    "                                            class=\" glyphicon glyphicon-check\"></i></button>\n" +
                    "                                    <button type=\"button\" class=\"btn btn-primary btn-xs\"><i\n" +
                    "                                            class=\" glyphicon glyphicon-pencil\"></i></button>\n" +
                    "                                    <button onclick='deleteUser(" + obj.id + ")' type=\"button\" class=\"btn btn-danger btn-xs\"><i\n" +
                    "                                            class=\" glyphicon glyphicon-remove\"></i></button>\n" +
                    "                                </td>\n" +
                    "                            </tr>"
                pagination();
            })
            $('tbody').append(str);
        },
        error: function () {
            layer.msg('获取数据失败', {icon: 5, time: 2000, shift: 6});
        }
    });
}

$(function () {

    page(1);

});

$("tbody .btn-success").click(function () {
    window.location.href = "assignRole.html";
});
$("tbody .btn-primary").click(function () {
    window.location.href = "edit.html";
});

function pagination() {
    $("#pagination1").pagination({
        currentPage: pageNum,
        totalPage: total,
        callback: function (current) {
            page(current);
        }
    });
}

function pagination_find() {
    $("#pagination1").pagination({
        currentPage: pageNum,
        totalPage: total,
        callback: function (current) {
            findUser(current);
        }
    });
}

//查询+分页
function findUser(page_num) {
    var findData = $("#findData");
    pageNum = page_num;
    $.ajax({
        url: project_path + "/findUser.do",
        type: "POST",
        beforeSend: function () {
            return true;
        },
        data: {
            username: findData.val(),
            pageNum: pageNum
        },
        success: function (data) {
            j = 0;
            str = "";
            $('tbody').empty();
            total = data.result[0].totalPage;
            var i = pageNum;
            j = i == 1 ? 1 : (i - 1) * 10 + 1;
            $.each(data.result, function (i, obj) {

                str += " <tr>\n" +
                    "                                <td>" + (j++) + "</td>\n" +
                    "                                <td style='display: none;'>" + obj.id + "</td>\n" +
                    "                                <td><input id=" + obj.id + " type=\"checkbox\" name='user'></td>\n" +
                    "                                <td>" + obj.loginacct + "</td>\n" +
                    "                                <td>" + obj.username + "</td>\n" +
                    "                                <td>" + obj.email + "</td>\n" +
                    "                                <td>\n" +
                    "                                    <button type=\"button\" class=\"btn btn-success btn-xs\"><i\n" +
                    "                                            class=\" glyphicon glyphicon-check\"></i></button>\n" +
                    "                                    <button type=\"button\" class=\"btn btn-primary btn-xs\"><i\n" +
                    "                                            class=\" glyphicon glyphicon-pencil\"></i></button>\n" +
                    "                                    <button onclick='deleteUser(obj.id)' type=\"button\" class=\"btn btn-danger btn-xs\"><i\n" +
                    "                                            class=\" glyphicon glyphicon-remove\"></i></button>\n" +
                    "                                </td>\n" +
                    "                            </tr>"
                pagination_find();
            });
            $('tbody').append(str);
        },
        error: function () {
            layer.msg('获取数据失败', {icon: 5, time: 2000, shift: 6});
        }
    })
}

function deleteUser(id) {
    $.ajax({
        url: project_path + "/deleteUser.do",
        type: "POST",
        data: {
            id: id
        },
        beforeSend: function () {
            return true;
        },
        success: function (data) {
            console.log(data.message);
            layer.msg(data.message, {icon: 5, time: 20000});
            window.location.reload();
        },
        error: function () {
            layer.alert("删除失败", {icon: 6});
        }
    })
}

/**
 * 全选和全不选
 */
$(document).ready(function () {
    $("#check").click(function () {
        var checked = document.getElementById("check").checked;
        var checkson = document.getElementsByName("user");
        if (checked) {
            for (var i = 0; i < checkson.length; i++) {
                checkson[i].checked = true;
            }
        } else {
            for (var i = 0; i < checkson.length; i++) {
                checkson[i].checked = false;
            }

        }
    });

    /**
     * 删除选中的数据
     */
    $("#delete").click(function () {
        user_id=new Array();
        var checkson = document.getElementsByName("user");
        $.each(checkson, function () {
            if (this.checked) {
                user_id.push($(this).val())
            }
        });

        debugger
        console.log(user_id)
        $.ajax({
            url: project_path + "/deleteUserByIds.do",
            type: "POST",
            data: {
                ids: user_id.toString()
            },
            success: function (data) {

            },
            error: function () {

            }
        })
    })
});


