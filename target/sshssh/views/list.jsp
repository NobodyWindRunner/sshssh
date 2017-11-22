<%@ page language="java" import="com.zjr.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>NEWSSHDEMO首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h1>列表</h1>
    <form action="list" method="post">
	第一页:<input type="text" name="page"/><br/>		
	<input type="submit" value="提交"/>
	</form>
	<table>
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>密码</td>
	</tr>
	<c:forEach var="item" items="${data.list}">
     <tr>
          <td>${item.id}</td>
          <td>${item.loginName}</td>
          <td>${item.password}</td>
     </tr>
	</c:forEach>
	</table>
	
  </body>
</html>
