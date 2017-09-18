<%--
  Created by IntelliJ IDEA.
  User: shefenfei
  Date: 2017/7/28
  Time: 下午5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fenfei.ssh.pojos.User" %>
<%@ page import="java.util.Enumeration" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <% User user;
        Enumeration<String> headerNames = request.getHeaderNames();
    %>
    用户名: ${user.username}  <br>
    密码 : ${user.password}
</body>
</html>
