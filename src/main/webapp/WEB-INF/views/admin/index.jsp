<%--
Created by IntelliJ IDEA.
User: shefenfei
Date: 2017/8/21
Time: 上午11:08
Desc: 后台管理系统首页
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
    <title>xxx管理系统</title>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <%--左边菜单栏--%>
        <%@include file="../leftMenu.jsp"%>

        <!-- 顶部导航条(top navigation) -->
        <%@include file="../top_nav.jsp"%>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>欢迎登录xxx后台管理系统</h3>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2 class="bg-red">今日好诗-狂夫</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                           aria-expanded="false"><i class="fa fa-wrench"></i></a>
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
                                万里桥西一草堂，百花潭水即沧浪。<br>
                                风含翠篠娟娟净，雨裛红蕖冉冉香。(篠 通：筱)<br>
                                厚禄故人书断绝，恒饥稚子色凄凉。<br>
                                欲填沟壑唯疏放，自笑狂夫老更狂。<br>

                                <p class="pager">
                                    译文
                                    万里桥西边就是我的破草房，
                                    没几个人来访，百花潭与我相伴，随遇而安，这就是沧浪。和风轻轻拥着翠绿的竹子，秀美光洁，飘雨慢慢洗着粉红的荷花，阵阵清香。当了大官的朋友人一阔就变脸，早与我断的来往，长久饥饿的小儿子，小脸凄凉，让我愧疚而感伤。我这老骨头快要扔进沟里了，无官无钱只剩个狂放，自己大笑啊，当年的狂夫老了却更狂！我就这么狂！
                                <div class="title_left">注释</div>
                                <ul>
                                    <li>⑴万里桥：在成都南门外，是当年诸葛亮送费祎出使东吴的地方。杜甫的草堂就在万里桥的西面。</li>
                                    <li>⑵百花潭：即浣花溪，杜甫草堂在其北。沧浪：指汉水支流沧浪江，古代以水清澈闻名。《孟子·离娄上》：“沧浪之水清兮，可以濯我缨。”有随遇而安之意。</li>
                                    <li>⑶筱（xiǎo）：细小的竹子。娟娟净：秀美光洁之态。</li>
                                    <li>⑷裛（yì）：滋润。红蕖：粉红色的荷花。冉冉香：阵阵清香。</li>
                                    <li>⑸厚禄故人：指做大官在朋友。书断绝：断了书信来往。</li>
                                    <li>⑹恒饥：长时间挨饿。</li>
                                    <li>⑺填沟壑（hè）：把尸体扔到山沟里去。这里指穷困潦倒而死。疏放：疏远仕途，狂放不羁。</li>
                                </ul>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <%@include file="../footer.jsp"%>
        <!-- /footer content -->
    </div>
</div>

<%-- js文件一定要在这个位置，不然不能正常渲染页面--%>
<script type="text/javascript" src="<%=contextPath%>/statics/bootstrap/core/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/statics/bootstrap/core/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/statics/bootstrap/core/js/custom.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/statics/bootstrap/core/js/nprogress.js"></script>
</body>
</html>
