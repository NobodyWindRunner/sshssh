<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path%>/skin/default/style.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/js/artDialog/skins/default.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/artDialog/artDialog.js"></script>
    <script type="text/javascript" src="<%=path%>/js/sys_dialog.js"></script>
<script type="text/javascript">
	function CheckIn(){	
		var userName=$("#txtUserName").val();
		var pwd=$("#txtPwd").val();
		if($.trim(userName)==""){
			conTip("请输入用户名",icons.warning);
			return false;
		}
		if(pwd.length<3){
			conTip("密码长度不小于三位",icons.warning);
			return false;
		}	
		return true;
	}	
	$(document).ready(function(){
		${message}
	});
	$(function () {
        //检测IE
        if ('undefined' == typeof (document.body.style.maxHeight)) {
            window.location.href = 'ie6update.html';
        }
    });
    </script>
  <body class="loginbody">
  <form action="index" id="form" name="form" method="post" onsubmit="return CheckIn();">
  	<div class="login-screen">
  		<div class="login-icon">LOGO</div>
  		<div class="login-form">
  			<div class="control-group">
  				<input type="text" name="id" id="txtUserName" class="login-field"  placeholder="用户名" title="用户名"/>
  			  	<label class="login-field-icon user" for="txtUserName"></label>
  			</div>
  			<div class="control-group">
  				<input type="password" name="password" id="txtPwd" class="login-field" placeholder="密码" title="密码"/>
          		<label class="login-field-icon pwd" for="txtPwd"></label>
          	</div>
  			<div>
  				<input type="submit" value="登 录" class="btn-login" id="btnLogin"/>
  			</div>
             <span class="login-tips"><b id="msgtip" style="color:red">${message}</b></span>
  		</div>		
  		<i class="arrow">箭头</i>
  	</div>
  </form>
  </body>
</html>
