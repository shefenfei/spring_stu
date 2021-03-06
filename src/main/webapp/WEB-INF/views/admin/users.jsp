<%--
Created by IntelliJ IDEA.
User: shefenfei
Date: 2017/8/21
Time: 上午11:08
Desc: 后台管理系统-用户列表页
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
    <title>用户列表</title>
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
                        <h3>用户管理</h3>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>用户管理
                                    <small>用户数据</small>
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
                                <div id="toolbar">
                                    <shiro:hasPermission name="super_admin:add">
                                        <button class="btn btn-success">
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
                                            <div class="modal-body card-view">
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
            url: '<%=contextPath%>/user/getAllUser',
            cache: false,
            striped: true,
            toolbar: '#toolbar',
            columns: [
                {
                    field: 'id',
                    title: '用户id',
                    width: '5%',
                    align : 'center',
                    valign : 'middle'
                },
                {
                    field: 'username',
                    title: '用户名',
                    width: '15%',
                    align : 'center',
                    valign : 'middle'
                },
                {
                    field: 'password',
                    title: '密码',
                    width: '10%',
                    align : 'center',
                    valign : 'middle'
                },
                {
                    field: 'sex',
                    title: '性别',
                    width: '5%',
                    align : 'center',
                    valign : 'middle'
                },
                {
                    field: 'phone',
                    title: '联系电话',
                    width: '15%',
                    align : 'center',
                    valign : 'middle'
                },
                {
                    field: 'major',
                    title: '职业',
                    width: '10%',
                    align : 'center',
                    valign : 'middle'
                },
                {
                    field: 'option',
                    title: '操作',
                    width: '40%',
                    align : 'center',
                    valign : 'middle',
                    formatter: function (value, row, index) {
                        var opt1 = '<shiro:hasRole name="super_admin"><button id="del-user" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除用户</button></shiro:hasRole>';
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
                        }
                    }
                }
            ]
        });
    }

    $(document).ready(function () {
        initUserTable();


    });
</script>

</body>
</html>
