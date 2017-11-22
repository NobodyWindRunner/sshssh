<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>管理首页</title>
    <link href="../skin/default/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../js/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../js/layout.js"></script>
</head>

<body class="mainbody">
    <form id="form1">
        <!--导航栏-->
        <div class="location">
            <a href="javascript:history.back(-1);" class="back"><i></i><span>返回上一页</span></a>
            <a class="home"><i></i><span>首页</span></a>
            <i class="arrow"></i>
            <span>管理中心</span>
        </div>
        <!--/导航栏-->
        <!--内容-->
        <div class="line10" style="padding-top:30px;"></div>
        <div class="nlist-1">
            <ul>
                <li>本次登录IP：<a>127.0.0.1</a></li>
                <li>上次登录IP：<a>127.0.0.1</a></li>
            </ul>
        </div>
        <div class="line10"></div>

        <div class="nlist-2">
            <h3><i></i>站点信息</h3>
            <ul>
                <li>站点名称：SSH XX管理系统</li>
                <li>公司名称：软件工作室</li>
                <li>网站域名：localhost:8080/</li>
                <li>安装目录：/NewSSHDemo/</li>
                <li>网站管理目录：admin</li>
                <li>服务器IP：127.0.0.1</li>
            </ul>
        </div>
        <div class="line20"></div>


        <!--/内容-->
    </form>
</body>
</html>
