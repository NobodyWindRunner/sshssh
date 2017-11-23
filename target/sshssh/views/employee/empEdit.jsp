<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${obj.id==null?"添加员工信息":"修改员工信息" }</title>
    <script type="text/javascript" src="../../js/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../../js/jquery/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
	<script type="text/javascript" charset="utf-8" src="../../js/edit/kindeditor-min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../../js/edit/lang/zh_CN.js"></script>
    <script type="text/javascript" src="../../js/layout.js"></script>
    <link href="../../skin/default/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
        ${msg}
    </script>
</head>
<body class="mainbody">
    <form name="employee" method="get" action="../employee/${obj.id==null?"add":"update"}">
        <!--导航栏-->
        <div class="location">
            <a href="../employee/list?page=${page}" class="back"><i></i><span>返回列表页</span></a>
            <a href="/views/center.jsp" class="home"><i></i><span>首页</span></a>
            <i class="arrow"></i>
            <a href="../employee/list"><span>员工管理</span></a>
            <i class="arrow"></i>
            <span>${obj.id==null?"添加员工信息":"修改员工信息"}</span>
        </div>
        <div class="line10"></div>
        <!--/导航栏-->
        <!--内容-->
        <div class="content-tab-wrap">
            <div id="floatHead" class="content-tab">
                <div class="content-tab-ul-wrap">
                    <ul>
                        <li><a href="javascript:;" onclick="tabs(this);" class="selected">${obj.id==null?"添加员工信息":"修改员工信息"}</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="tab-content">
            <input type="hidden" name="id" value="${obj.id}"/>
            <input type="hidden" name="page" value="${page}"/>
            <dl>
                <dt>员工名称</dt>
                <dd>
                    <input name="name" type="text" value="${obj.name}" id="txtName" class="input normal" datatype="*2-100" sucmsg=" " />
                    <span id="ajaxmsg">*</span>
                </dd>
            </dl>
            <dl>
                <dt>性别</dt>
                <dd>
                    <div class="rule-multi-radio">
                        <span id="rblStatus">
                             <input id="rblStatus_0" type="radio" name="sex" checked="checked" value="男" ${obj.sex=="男"?"checked":"" }/>
                             <label for="rblStatus_0">男</label>
                             <input id="rblStatus_1" type="radio" name="sex" value="女" ${obj.sex=="女"?"checked":"" }/>
                             <label for="rblStatus_1">女</label>
                        </span>
                    </div>
                </dd>
            </dl>
            <dl>
                <dt>职位</dt>
                <dd>
                    <input name="job" type="text" value="${obj.job}" id="txtJob" class="input normal" sucmsg=" " />
                </dd>
            </dl>
            <dl>
                <dt>部门</dt>
                <dd>
                    <select name="dept" datatype="*" class="input normal" sucmsg=" ">
                        <option value="">请选择</option>
                        <c:forEach items="${depList}" var="data">
                            <c:choose>
                                <c:when test="${obj.deptId.id==data.id}">
                                    <option selected="selected" value="${data.id}">
                                            ${data.name}
                                    </option>
                                </c:when>
                                <c:otherwise>
                                    <option  value="${data.id}">
                                            ${data.name}
                                    </option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </dd>
            </dl>
        </div>
		<div>${message}</div>
        <!--工具栏-->
        <div class="page-footer">
            <div class="btn-list">
                <input type="submit" name="btnSubmit" value="${obj.id==null?"添加员工信息":"修改员工信息" }" id="btnSubmit" class="btn" />
                <input name="btnReturn" type="button" value="返回上一页" class="btn yellow" onclick="javascript:history.back(-1);" />
            </div>
            <div class="clear"></div>
        </div>
        <!--/工具栏-->
    </form>
</body>
</html>