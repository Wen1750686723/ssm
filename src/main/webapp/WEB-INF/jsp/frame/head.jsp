  
<%    
String path = request.getContextPath();   
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>  
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">    
<html>    
  <head>    
    <base href="http://www.mavens.com">    
        
    <title>后台管理系统</title>    
        
    <meta http-equiv="pragma" content="no-cache">    
    <meta http-equiv="cache-control" content="no-cache">    
    <meta http-equiv="expires" content="0">        
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">    
    <meta http-equiv="description" content="This is my page">    
    <!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->  
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/easyui/css/demo.css">
	<script type="text/javascript" src="/easyui/js/jquery.min.js"></script>
	<script type="text/javascript" src="/easyui/js/jquery.easyui.min.js"></script>  
    
  </head>    
      
  <body>  