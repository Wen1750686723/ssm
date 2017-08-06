 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
 <%@ include file="../frame/head.jsp" %> 
    <link rel="stylesheet" type="text/css" href="/bootstrap/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="/bootstrap/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="/bootstrap/Css/style.css" />
    <script type="text/javascript" src="/bootstrap/Js/jquery.js"></script>
    <script type="text/javascript" src="/bootstrap/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="/bootstrap/Js/bootstrap.js"></script>
    <script type="text/javascript" src="/bootstrap/Js/ckform.js"></script>
    <script type="text/javascript" src="/bootstrap/Js/common.js"></script>
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <form class="form-inline definewidth m20" action="index.html" method="get">
    菜单名称：
    <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增菜单</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>菜单标题</th>
        <th>GROUP</th>
        <th>MODEL</th>
        <th>ACTION</th>
        <th>状态</th>
        <th>管理操作</th>
    </tr>
    </thead>
	     <tr>
            <td colspan="5">系统管理</td>
            <td><a href="edit.html">编辑</a></td>
        </tr>
        <tr>
                <td>机构管理</td>
                <td>Admin</td>
                <td>Merchant</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>权限管理</td>
                <td>Admin</td>
                <td>Node</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>角色管理</td>
                <td>Admin</td>
                <td>Role</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>用户管理</td>
                <td>Admin</td>
                <td>User</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>菜单管理</td>
                <td>Admin</td>
                <td>Menu</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
            <td colspan="5">明信片管理</td>
            <td><a href="edit.html">编辑</a></td>
        </tr>
        <tr>
                <td>批次管理</td>
                <td>Admin</td>
                <td>LabelSet</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>明信片查询</td>
                <td>Admin</td>
                <td>Label</td>
                <td>index</td>
                <td>0</td>
                <td><a href="edit.html">编辑</a></td>
            </tr><tr>
                <td>明信片生成</td>
                <td>Admin</td>
                <td>Label</td>
                <td>apply</td>
                <td>1</td>
                <td><a href="edit.html">编辑</a></td>
            </tr></table>
		<script>
		    $(function () {
		        
		
				$('#addnew').click(function(){
		
						window.location.href="add.html";
				 });
		
		
		    });
			
		</script>
 
 <%@ include file="../frame/foot.jsp" %> 