<%--
  Created by IntelliJ IDEA.
  User: shefenfei
  Date: 2017/8/22
  Time: 下午5:23
  To change this template use File | Settings | File Templates.
  管理员列表
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="../common.jsp" %>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/statics/bootstrap/data-table/bootstrap-table.min.css"/>
    <title>管理员</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <%--左边菜单栏--%>
        <%@include file="../leftMenu.jsp" %>

        <!-- 顶部导航条(top navigation) -->
        <%@include file="../top_nav.jsp" %>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>管理员</h3>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>管理员
                                    <small>管理员操作</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle"
                                           data-toggle="dropdown" role="button" aria-expanded="false"><i
                                                class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Settings 1</a>
                                            </li>
                                            <li><a href="#">Settings 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>

                            <div class="x_content">
                                <div id="toolbar" role="toolbar">
                                    <shiro:hasPermission name="super_admin:add">
                                        <button class="btn btn-success" id="add-new-admin" data-toggle="modal" data-target="#add-admin-modal">
                                            <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>新增用户
                                        </button>
                                    </shiro:hasPermission>
                                </div>
                                <table id="user-table" class="table bootstrap-table"></table>
                                <%--用户详情--%>
                                <div id="user-detail-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">用户详情</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form role="form">
                                                    <div class="form-group">
                                                        <label for="username">用户名</label>
                                                        <input type="text" class="form-control" id="username" placeholder="用户名">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="password">密码</label>
                                                        <input type="text" class="form-control" id="password" placeholder="密码">
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-primary">提交更改</button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>
                                <%--添加管理员--%>
                                <div id="add-admin-modal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="admin-add">添加管理员</h4>
                                            </div>
                                            <div class="modal-body">
                                                <%@include file="add_admin.jsp"%>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <%--删除管理员--%>
                                <div id="del-admin-modal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="admin-del">删除管理员</h4>
                                            </div>
                                            <div class="modal-body">
                                                确定要删除这个管理员 ？
                                                <button type="button" class="btn btn-danger" data-dismiss="modal">删除</button>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <%@include file="../footer.jsp" %>
        <!-- /footer content -->
    </div>
</div>

<%-- js文件一定要在这个位置，不然不能正常渲染页面--%>
<script type="text/javascript" src="<%=contextPath%>/statics/bootstrap/core/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/statics/bootstrap/core/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/statics/bootstrap/data-table/bootstrap-table.min.js"></script>
<script type="text/javascript"
        src="<%=contextPath%>/statics/bootstrap/data-table/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/statics/bootstrap/core/js/custom.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/statics/bootstrap/core/js/nprogress.js"></script>


<script>
    function initUserTable() {
        $('#user-table').bootstrapTable({
            url: '<%=contextPath%>/system/getAllAdmin',
            cache: false,
            striped: true,
            toolbar: '#toolbar',
            columns: [
                {
                    field: 'id',
                    title: '管理员ID',
                    width: '5%',
                    align : 'center',
                    valign : 'middle'
                },
                {
                    field: 'adminName',
                    title: '管理员名',
                    width: '15%',
                    align : 'center',
                    valign : 'middle'
                },
                {
                    field: 'adminPass',
                    title: '密码',
                    width: '10%',
                    align : 'center',
                    valign : 'middle'
                },
                {
                    field: 'roleName',
                    title: '角色',
                    width: '15%',
                    align : 'center',
                    valign : 'middle',
                    formatter: function (value, row, index) {
                        console.dir(value.toString() + '.....' + row + '...' + index);
                        return row.roleName;
                    }
                },
                {
                    field: 'roleDesc',
                    title: '角色描述',
                    width: '15%',
                    align : 'center',
                    valign : 'middle',
                    formatter: function (value, row, index) {
                        console.dir(value.toString() + '.....' + row + '...' + index);
                        return row.roleDesc;
                    }
                },
                {
                    field: 'option',
                    title: '操作',
                    width: '40%',
                    align : 'center',
                    valign : 'middle',
                    formatter: function (value, row, index) {
                        var opt1 = '<shiro:hasRole name="super_admin"><button id="del-user" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#del-admin-modal"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除用户</button></shiro:hasRole>';
                        var opt2 = '<shiro:hasAnyRoles name="super_admin , admin"><button id="edit-user" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>修改用户</button></shiro:hasAnyRoles>';
                        var opt3 = '<shiro:hasAnyRoles name="super_admin , admin , operator"><button id="show-user" class="btn btn-success btn-sm" data-toggle="modal" data-target="#user-detail-modal"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>查看用户</button></shiro:hasAnyRoles>';
                        var opt4 = '<shiro:hasRole name="super_admin"><button id="ban-user" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>禁用用户</button></shiro:hasRole>';
                        return opt1 + opt2 + opt3 + opt4;
                    },
                    events: {
                        //显示用户信息
                        'click #show-user': function (e, value , row , index) {
                            console.dir(row);
                            $('#user-detail-modal').on('show.bs.modal' , function () {
                                $('#username').val(row.username);
                                $('#password').val(row.password);
                                console.log(row);
                            });
                        },
                        'click #del-user': function (e, value, row, index) {
                            console.error(row.id);
                        }
                    }
                }
            ]
        });
    }

    //获取所有的管理员角色
    function getAllAdminRole() {
        var roles = "";
        $.getJSON('<%=contextPath%>/system/getAllRoles' , function (data) {
            $.each(data , function (i, item) {
                console.dir(i + '.....' + item.roleName);
                var li = '<li><a href="#" onclick="insertAdminRole(' + item.id + ',\''+ item.roleName +'\')">'+ item.roleName + '</a></li>';
                roles += li;
            })
            console.dir(roles);
            $('#role-drop-menu').html(roles);
        })
    }

    //获取所有的管理员权限
    function getAllRolePerms() {
        var perms = "";
        $.getJSON('<%=contextPath%>/system/getAllPerms' , function (data) {
            $.each(data , function (i, item) {
                console.dir(i + '.....' + item.permName);
                var li = '<li><a href="#" onclick="insertAdminPerms(' + item.id + ',\''+ item.permName +'\')">'+ item.permName + '</a></li>';
                perms += li;
            })
            console.dir(perms);
            $('#perms-drop-menu').html(perms);
        })
    }

    //角色
    function insertAdminRole(id, role) {
        console.dir(id + '...' + role);
        $('#chosedRole').val(role);
        $('#chosedRoleIds').val(id);
    }

    //权限
    function insertAdminPerms(id, perms) {
        var permsView = $('#chosedPerms');
        var permission = permsView.val();
        permission += perms;
        permsView.val(perms);
    }

    //提交添加新管理员
    function onAddNewAdmin() {
        $('#add-newAdmin-form').on('submit' , function (event) {

        });
    }

    $(document).ready(function () {
        initUserTable();
        $('#add-admin-modal').on('show.bs.modal' , function () {
            getAllAdminRole();
            getAllRolePerms();
        });

        onAddNewAdmin();
    });

</script>

</body>
</html>