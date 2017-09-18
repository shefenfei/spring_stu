<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<body>
<h2>Hello World!</h2>
<shiro:guest>
    Hi there! Please <a href="<%=request.getContextPath()%>/user/login">Login</a>
    or <a href="signup.jsp">Signup</a> today!
</shiro:guest>

<shiro:user>
    Welcome back John! Not John? Click <a href="<%=request.getServletPath()%>/user/login">Here</a> to login.
</shiro:user>

<shiro:authenticated>
    <a href="updateAccount.jsp">Update your contact information</a>.
</shiro:authenticated>

<shiro:notAuthenticated>
    Please <a href="login.jsp">login</a> in order to update your credit card information.
</shiro:notAuthenticated>

<shiro:hasRole name="administrator">
    <a href="admin.jsp">Administer the system</a>
</shiro:hasRole>
</body>
</html>
