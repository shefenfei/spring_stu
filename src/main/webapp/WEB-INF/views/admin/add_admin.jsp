<%--
  Created by IntelliJ IDEA.
  User: shefenfei
  Date: 2017/8/23
  Time: 上午9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=contextPath%>/system/addNewAdmin" method="post" id="add-newAdmin-form">
        <div class="form-group has-feedback">
            <label for="admin_name" class="label label-info">管理员名</label>
            <input type="text" class="form-control" id="admin_name" placeholder="Username" name="adminName"/>
        </div>
        <div class="form-group">
            <label for="admin_pass" class="label label-info">密码</label>
            <input type="password" class="form-control" id="admin_pass" placeholder="Password" name="adminPass"/>
        </div>
        <div class="form-group">
            <label class="label label-warning small">角色</label>
            <div class="form-group btn-group">
                <button type="button" class="btn btn-warning dropdown-toggle btn-sm" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    请选择角色 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="role-drop-menu">
                </ul>
            </div>
        </div>

        <div class="form-group">
            <label class="label label-warning" for="chosedRole">已选角色</label>
            <input type="text" class="form-control" id="chosedRole" readonly/>
        </div>

        <div class="form-group hide">
            <input type="text" class="form-control" name="rId" id="chosedRoleIds"/>
        </div>

        <div class="form-group">
            <label class="label label-danger">权限</label>
            <div class="form-group btn-group">
                <button type="button" class="btn btn-danger dropdown-toggle btn-sm" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    请选择权限 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="perms-drop-menu">
                </ul>
            </div>
        </div>

        <div class="from-group">
            <label class="label label-danger" for="chosedPerms">已选权限</label>
            <input type="text" class="form-control" id="chosedPerms" readonly/>
        </div>


        <div class="form-group has-success has-feedback">
            <label class="control-label" for="inputSuccess2">Input with success</label>
            <input type="text" class="form-control" id="inputSuccess2" aria-describedby="inputSuccess2Status">
            <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
            <span id="inputSuccess2Status1" class="sr-only">(success)</span>
        </div>

        <button type="submit" class="btn btn-primary">添加新管理员</button>
    </form>
</body>
</html>
