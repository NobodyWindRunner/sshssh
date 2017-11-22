<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${obj.id==null?"添加用户信息":"修改用户信息" }</title>
    <script type="text/javascript" src="../../js/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../../js/jquery/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
	<script type="text/javascript" charset="utf-8" src="../../js/edit/kindeditor-min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../../js/edit/lang/zh_CN.js"></script>
    <script type="text/javascript" src="../../js/layout.js"></script>
    <link href="../../skin/default/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
        ${msg}
        $(document).ready(function(){
        	$("#txtLoginName").change(function(){
        		if($(this).val()=="")
        			return;
        		$("#ajaxmsg").html("<img src='image/ajax-loader.gif'/>正在检测...");
        		$.get("/kc/userinfo/user/check.do",{"loginName":$(this).val()},function(data){
        			if(data=="success"){
        				$("#ajaxmsg").html("可以使用！").css("color","green");
        			}else{
        				$("#ajaxmsg").html("这个登录名已存在！").css("color","red");
        			}
        		});
        	});
        });
    </script>
</head>
<body class="mainbody">
    <form name="userInfo" method="get" action="../userinfo/${obj.id==null?"add":"update"}">
        <!--导航栏-->
        <div class="location">
            <a href="../userinfo/list?page=${page}" class="back"><i></i><span>返回列表页</span></a>
            <a href="/views/center.jsp" class="home"><i></i><span>首页</span></a>
            <i class="arrow"></i>
            <a href="../userinfo/list"><span>用户管理</span></a>
            <i class="arrow"></i>
            <span>${obj.id==null?"添加用户信息":"修改用户信息"}</span>
        </div>
        <div class="line10"></div>
        <!--/导航栏-->
        <!--内容-->
        <div class="content-tab-wrap">
            <div id="floatHead" class="content-tab">
                <div class="content-tab-ul-wrap">
                    <ul>
                        <li><a href="javascript:;" onclick="tabs(this);" class="selected">${obj.id==null?"添加用户信息":"修改用户信息"}</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="tab-content">
            <input type="hidden" name="id" value="${obj.id}"/>
            <input type="hidden" name="page" value="${page}"/>
            <dl>
                <dt>登录名称</dt>
                <dd>
                    <input name="loginName" type="text" value="${obj.loginName}" id="txtLoginName" class="input normal" datatype="*2-100" sucmsg=" " />
                    <span id="ajaxmsg">*</span>
                </dd>
            </dl>
            <dl class="upwd">
                <dt>密码</dt>
                <dd>
                    <input name="password" type="text" value="${obj.password}" id="txtPwd" class="input normal" datatype="*2-100" sucmsg=" " />
                </dd>
            </dl>
			<dl>
                <dt>当前状态</dt>
                <dd>
                    <div class="rule-multi-radio">
                        <span id="rblStatus">
                             <input id="rblStatus_0" type="radio" name="statusVal" checked="checked" value="1" ${obj.statusVal==1?"checked":"" }/>
                             <label for="rblStatus_0">可用</label>
                             <input id="rblStatus_1" type="radio" name="statusVal" value="0" ${obj.statusVal==0?"checked":"" }/>
                             <label for="rblStatus_1">不可用</label>
                        </span>
                    </div>
                </dd>
            </dl>
        </div>
		<div>${message}</div>
        <!--工具栏-->
        <div class="page-footer">
            <div class="btn-list">
                <input type="submit" name="btnSubmit" value="${obj.id==null?"添加用户信息":"修改用户信息" }" id="btnSubmit" class="btn" />
                <input name="btnReturn" type="button" value="返回上一页" class="btn yellow" onclick="javascript:history.back(-1);" />
            </div>
            <div class="clear"></div>
        </div>
        <!--/工具栏-->
    </form>
</body>
</html>