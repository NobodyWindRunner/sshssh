$(function () {
    imgLayout();
    $(window).resize(function () {
        imgLayout();
    });
    //图片延迟加载
    $(".pic img").lazyload({ load: AutoResizeImage, effect: "fadeIn" });
    //点击图片链接
    $(".pic img").click(function () {
        //$.dialog({ lock: true, title: "查看大图", content: "<img src=\"" + $(this).attr("src") + "\" />", padding: 0 });
        var linkUrl = $(this).parent().parent().find(".foot a").attr("href");
        if (linkUrl != "") {
            location.href = linkUrl; //跳转到修改页面
        }
    });
    initPage();
});
//是否隐藏分页空间
function initPage(){
	if($("#tableContent")){
		var cnt=$("#tableContent").find("tr").size();
		if(cnt==1){
			$("ul[class='page']").css("display","none");
			var tdNum=$("#tableContent").find("tr").eq(0).find("th").size();
			$("#tableContent").append("<tr><td colspan='"+tdNum+"'><div style='color:998;text-align:center;font-size:15px;'>很抱歉, 没有找到相关数据!</div></td></tr>");
		}
	}
}
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
//是否有选中
function checkSelectNum(){
	var cnt = $("input[name='ids']:checked").size();
	return cnt>0;
}
//提交表单
function doSearch(){
	$("#form1").submit();
}