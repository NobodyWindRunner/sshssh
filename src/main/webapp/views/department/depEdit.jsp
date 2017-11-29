<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${obj.id==null?"添加部门信息":"修改部门信息" }</title>
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
        	$("#txtName").change(function(){
        		if($(this).val()=="")
        			return;
        		$("#ajaxmsg").html("<img src='../../image/ajax-loader.gif'/>正在检测...");
        		$.get("../department/check",{"name":$(this).val()},function(data){
        			if(data=="success"){
        				$("#ajaxmsg").html("可以使用！").css("color","green");
        			}else{
        				$("#ajaxmsg").html("这个部门名已存在！").css("color","red");
        			}
        		});
        	});
        });
    </script>
</head>
<body class="mainbody">
    <form name="department" method="get" action="../department/${obj.id==null?"add":"update"}">
        <!--导航栏-->
        <div class="location">
            <a href="../department/list?page=${page}" class="back"><i></i><span>返回列表页</span></a>
            <a href="/views/center.jsp" class="home"><i></i><span>首页</span></a>
            <i class="arrow"></i>
            <a href="../department/list"><span>部门管理</span></a>
            <i class="arrow"></i>
            <span>${obj.id==null?"添加部门信息":"修改部门信息"}</span>
        </div>
        <div class="line10"></div>
        <!--/导航栏-->
        <!--内容-->
        <div class="content-tab-wrap">
            <div id="floatHead" class="content-tab">
                <div class="content-tab-ul-wrap">
                    <ul>
                        <li><a href="javascript:;" onclick="tabs(this);" class="selected">${obj.id==null?"添加部门信息":"修改部门信息"}</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="tab-content">
            <input type="hidden" name="id" value="${obj.id}"/>
            <input type="hidden" name="page" value="${page}"/>
            <dl>
                <dt>部门名称</dt>
                <dd>
                    <input name="name" type="text" value="${obj.name}" id="txtName" class="input normal" datatype="*2-100" sucmsg=" " />
                    <span id="ajaxmsg">*</span>
                </dd>
            </dl>
        </div>
		<div>${message}</div>
        <!--工具栏-->
        <div class="page-footer">
            <div class="btn-list">
                <input type="submit" name="btnSubmit" value="${obj.id==null?"添加部门信息":"修改部门信息" }" id="btnSubmit" class="btn" />
                <input name="btnReturn" type="button" value="返回上一页" class="btn yellow" onclick="javascript:history.back(-1);" />
            </div>
            <div class="clear"></div>
        </div>
        <!--/工具栏-->
    </form>
</body>
</html>