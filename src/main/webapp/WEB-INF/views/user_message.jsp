<%--
  Created by IntelliJ IDEA.
  User: shefenfei
  Date: 2017/7/31
  Time: 下午5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="welcome.springmvc"/></title>
    <link href="<s:theme code='css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>

Language: <a href="?language=en">English</a>|<a href="?language=zh">中文</a>
<h2>
    welcome.springmvc : <s:message code="welcome.springmvc" text="default text"/>
</h2>


Theme : <a href="?theme=theme_red">红色的主题</a> | <a href="?theme=theme_blue">蓝色的主题</a>

Locale: ${pageContext.response.locale }

    <h1>Please upload a file</h1>
    <form method="post" action="/ssh/user/upload" enctype="multipart/form-data">
        <input type="text" name="name"/>
        <input type="file" name="file"/>
        <input type="submit"/>
    </form>


</body>
</html>