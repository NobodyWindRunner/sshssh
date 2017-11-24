<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="/WEB-INF/MyPage.tld" prefix="pt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>项目信息历史列表</title>
    <script type="text/javascript" src="../../js/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../../js/jquery/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="../../js/jquery/jquery.lazyload.min.js"></script>
    <script type="text/javascript" src="../../js/artDialog/artDialog.js"></script>
    <script type="text/javascript" src="../../js/artDialog/plugins/iframeTools.js"></script>
    <script type="text/javascript" src="../../js/layout.js"></script>
    <link href="../../js/artDialog/skins/simple.css" rel="stylesheet" />
    <link href="../../skin/default/style.css" rel="stylesheet" type="text/css" />
    <link href="../../css/pagination.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="../../css/page.css"/>
    <script type="text/javascript">
        //表格是否有数据
        $(function () {
            var v=$(".ltable");
            var vcount=$(".ltable tr td").filter("td").size();
            if(vcount==0){
                var tr = '<tr><td colspan="9" align="center">'+"很抱歉,没有找到相关数据"+'</td></tr>';
                $(".ltable").append(tr);
                $(".pagelist").css("display", "none");
            }
        });
        $(function () {
            imgLayout();
            $(window).resize(function () {
                imgLayout();
            });
            //图片延迟加载
            $(".pic img").lazyload({ load: AutoResizeImage, effect: "fadeIn" });
            //点击图片链接
            $(".pic img").click(function () {
                //$.dialog({ lock: true, title: "查看大图", content: "<img src=\"" + $(this).attr("src") + "\" />",padding: 0 });
                var linkUrl = $(this).parent().parent().find(".foot a").attr("href");
                if (linkUrl != "") {
                    location.href = linkUrl; //跳转到修改页面
                }
            });
            //全选按钮单击事件
            $(".all").click(function(){
            	if(this.prop("checked",true)){
            		$("td input[type=checkbox]").prop("checked",true);
            	}else{
            		$("td input[type=checkbox]").prop("checked",false);
            	}
            });
          //显示条数文本框改变事件
    		$("#size").live('keyup',function(){
    			clearTimeout();
    			setTimeout('form1.submit()',500);
    		});
        });
        //排列图文列表
        function imgLayout() {
            var imgWidth = $(".imglist").width();
            var lineCount = Math.floor(imgWidth / 222);
            var lineNum = imgWidth % 222 / (lineCount - 1);
            $(".imglist ul").width(imgWidth + Math.ceil(lineNum));
            $(".imglist ul li").css("margin-right", parseFloat(lineNum));
        }
        //等比例缩放图片大小
        function AutoResizeImage(e, s) {
            var img = new Image();
            img.src = $(this).attr("src")
            var w = img.width;
            var h = img.height;
            var wRatio = w / h;
            if ((220 / wRatio) >= 165) {
                $(this).width(220); $(this).height(220 / wRatio);
            } else {
                $(this).width(165 * wRatio); $(this).height(165);
            }
        }
        ${msg}
    	art.dialog.close();
    	art.dialog.close();
    </script>
</head>

<body class="mainbody">
    <form name="form1" method="post" action="../project/list" id="form1">
        <!--导航栏-->
        <div class="location">
            <a href="javascript:history.back(-1);" class="back"><i></i><span>返回上一页</span></a>
            <a href="/views/center.jsp" class="home"><i></i><span>首页</span></a>
            <i class="arrow"></i>
            <span>历史项目列表</span>
        </div>
        <!--/导航栏-->
        <!--工具栏-->
        <div class="toolbar-wrap">
            <div id="floatHead" class="toolbar">
                <div class="l-list">
                    <ul class="icon-list">
                        <li><a class="add" href="../project/add"><i></i><span>新增</span></a></li>
                        <li><a class="all" href="javascript:;" onclick="checkAll(this);"><i></i><span>全选</span></a></li>
                        <li><a onclick="return ExePostBack('btnDelete');" id="btnDelete" class="del" href="javascript:__doPostBack('btnDelete','')"><i></i><span>删除</span></a></li>
                    </ul>
                    
                </div>
                <div class="r-list">
                    <input name="txtKeywords" type="text" id="txtKeywords" class="keyword" />
                    <a id="lbtnSearch" class="btn-search"  href="javascript:void(0);" onclick="form1.submit()">查询</a>
                </div>
            </div>
        </div>
        <!--/工具栏-->
        <!--文字列表-->

        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="ltable">
            <tr align="center">
                <th width="6%">选择</th>
                <th width="10%">项目编号</th>
                <th width="25%">项目名称</th>
                <th>项目描述</th>
                <th width="15%">项目状态</th>
                <th width="10%">操作</th>
            </tr>
               
            <c:forEach var="obj" items="${data.list}">
            <tr align="center">
                <td align="center"><span class="checkall" style="vertical-align:middle;"><input id="rptList1_ctl01_chkId" type="checkbox" name="checkbox" value="${obj.id }"/></span><input type="hidden" name="checkbox" id="rptList1_ctl01_hidId" value="62" /></td>
                <td>${obj.id }</td>
                <td>${obj.proName }</td>
                <td>${obj.detail }</td>
                <td>${obj.statusVal==2?"已完成":"已删除" }</td>
                <td>
                <a href="../project/del?id=${obj.id }&page=${data.page }" onclick="return confirm('是否确认要删除该数据?');">删除</a>
                <a href="../project/get?id=${obj.id }&page=${data.page }">修改</a></td>
            </tr>
            </c:forEach>
        </table>
        <!--/文字列表-->
        <!--内容底部-->
		
	    <div class="pagelist">
			<div class="l-btns">
	                <span>显示</span><input name="size" type="text" value="${size}"  onkeypress="if (WebForm_TextBoxKeyHandler(event) == false) return false;" id="size" class="pagenum" onkeydown="return checkNumber(event);" /><span>条/页</span>
	        </div>
			<pt:page count="${data.count }" pageIndex="${data.page }"	url="../project/list?size=${size}&" pageMax="${data.total}" />
		</div>
		<!--/内容底部-->
    </form>
</body>
</html>
