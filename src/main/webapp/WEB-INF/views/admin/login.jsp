<%--
  Created by IntelliJ IDEA.
  User: shefenfei
  Date: 2017/8/21
  Time: 上午11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="../common.jsp" %>
    <title>管理员登录</title>
</head>
<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form method="post" action="<%=contextPath%>/system/doLogin">
                    <h1>管理员登录</h1>
                    <div>
                        <input type="text" class="form-control" placeholder="Username" required="" name="username"/>
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="Password" required="" name="password"/>
                    </div>
                    <div>
                        <%--<a class="btn btn-default submit">登录</a>--%>
                        <button type="submit" class="btn btn-default">登录</button>
                        <a class="reset_pass" href="#">Lost your password?</a>
                    </div>

                    <div class="clearfix"></div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>
