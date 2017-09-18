<%--
  Created by IntelliJ IDEA.
  User: shefenfei
  Date: 2017/8/14
  Time: 上午8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

<div class="easyui-panel" title="New Topic" style="width:400px;">
    <form action="<%=contextPath%>/system/doLogin" method="post">
        用户名：<input class="easyui-textbox" name="username" type="text"/><br>
        密码：<input class="easyui-textbox" name="password" type="password"/>
        <input type="submit" class="easyui-button" value="登录"/>
    </form>
</div>

</body>
</html>
