<%--
  Created by IntelliJ IDEA.
  User: shefenfei
  Date: 2017/8/14
  Time: 上午11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <script>
        var remoteUrl = "http://localhost:8999";

        //为tabs添加新的tab
        function addTab(nodeName) {
            $('#tabs').tabs('add', {
                title: nodeName,
                content: '<div><table id="user_table" class="easyui-datagrid"></table></div>',
                closable: true
            });
        }


        /**
         * 加载菜单树
         */
        function loadTreeMenu() {
            $('#tree_menu').tree({
                url: remoteUrl + '/menu/listAllMenu',
                method: 'post',
                animate: true,
                onClick: function (node) {
                    console.log(node.text);
                    if (node.text === "用户管理") {
                        addTab(node.text);
                        renderUserGrid();
                    }
                }
            })
        }

        //加载用户表数据
        function renderUserGrid() {
            $('#user_table').datagrid({
                url: remoteUrl + '/user/getAllUser',
                method: 'get',
                singleSelect: true,
                rownumbers: true,
                loadMsg: '数据加载中...',
                columns: [[
                    {field: 'id', title: '用户id', width: 100, align: 'center'},
                    {field: 'username', title: '用户名', width: 100, align: 'center'},
                    {field: 'password', title: '密码', width: 100, align: 'center'},
                    {field: 'phone', title: '电话', width: 150},
                    {field: 'major', title: '职业', width: 100},
                    {field: 'sex', title: '性别', width: 50},
                    {
                        field: 'action', title: '操作', width: 200, align: 'center',
                        formatter: function (value, rowData, rowIndex) {
                            return '删除';
                        }
                    }
                ]],
                toolbar: '#toolbar',
                pagination: true
            });
        }


        function del() {
            alert('删除');
        }


        $(document).ready(function () {
            loadTreeMenu();
        });
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
    xxx管理系统
    <a href="?theme=theme_red">MD主题</a> | <a href="?theme=theme_blue">bootstrap主题</a>

    <shiro:hasRole name="role1">
        <a href="#">角色role1可见</a>
    </shiro:hasRole>

    <shiro:hasRole name="role2">
        <a href="#">角色role2可见</a>
    </shiro:hasRole>

</div>
<div data-options="region:'west',split:true,title:'菜单'" style="width:250px;padding:5px;">
    <ul id="tree_menu" class="easyui-tree"
        data-options="
        url: remoteUrl + '/menu/listAllMenu',
        method: 'post' ,
        animate: true ,
        onClick:function(node){
            alert('node');
            if (node.text === '用户管理') {
                addTab(node.text);
                renderUserGrid();
                }
            }
        ">
    </ul>

</div>
<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region
</div>
<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">Copyright © 2010-2099 fenfei.she</div>
<div data-options="region:'center',title:'Center'">
    <div id="tabs" class="easyui-tabs" data-options="border:false"></div>
    <div id="toolbar">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true"/a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true"/a>
    </div>
</div>
</body>
</html>
