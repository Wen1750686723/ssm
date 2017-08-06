 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
 <%@ include file="../frame/head.jsp" %> 
 <!-- Bootstrap core CSS -->
    <link href="/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/bootstrap/signin.css" rel="stylesheet">
    <%-- <ul>
    <li>${user.id}</li>
    <li>${user.name}</li>
    <li>${user.password}</li>
    <li>${user.age}</li>
    </ul> --%>
     <div class="container">

      <form class="form-signin" id="loginUser" action="/admin/loginCheck" method="post">
        <h2 class="form-signin-heading">请登陆<span style="font-size:12px;">${errs}</span></h2>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="name" id="name" name="name" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住密码
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      </form>

    </div>
<!--     <form id="loginUser" action="/user/loginCheck" method="post">     
        userName: <input id="name" name="name" /><br/>     
        password: <input id="password" name="password" /><br/>    
        <input type="submit" value="登陆"/>     
    </form>   -->   
<%@ include file="../frame/foot.jsp" %> 