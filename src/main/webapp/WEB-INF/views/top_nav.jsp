<%--
  Created by IntelliJ IDEA.
  User: shefenfei
  Date: 2017/8/21
  Time: 下午3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                       aria-expanded="false">
                        <img src="<%=contextPath%>/statics/images/adminDefault.jpg" alt="">Shefenfei
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="javascript:;">个人信息</a></li>
                        <li>
                            <a href="javascript:;">
                                <span>系统设置</span>
                            </a>
                        </li>
                        <li><a href="javascript:;">帮助</a></li>
                        <li><a href="<%=contextPath%>/system/signOut"><i class="fa fa-sign-out pull-right"></i>登出</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>