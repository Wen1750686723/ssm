 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
 <%@ include file="../frame/head.jsp" %> 
 <link href="/bootstrap/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
 <link href="/bootstrap/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
 <link href="/bootstrap/assets/css/main-min.css" rel="stylesheet" type="text/css" />
 <div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${name}</span><a href="/admin/logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">管理系统</div></li>	
           <!--  <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li> -->

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="/bootstrap/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/bootstrap/assets/js/bui-min.js"></script>
<script type="text/javascript" src="/bootstrap/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="/bootstrap/assets/js/config-min.js"></script>
<script>
	
    BUI.use('common/main',function(){
    	$.ajax({
    		type:"post",
    		url :"/admin/getmenu",
    		data:{
    		},
    		dataType:"json",
    		success:function(data){
    			console.log(data);
    			var config = data;
    	        new PageUtil.MainPage({
    	            modulesConfig : config
    	        });
    		}
    	});
        
    });
</script>
<div style="text-align:center;">
<p><a href="http://www.liuwenbohhh.net/" target="_blank">liuwenbohhh版权所有</a></p>
</div>
 <%@ include file="../frame/foot.jsp" %> 