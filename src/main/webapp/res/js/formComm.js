/**
 * 
 */

$(document).ready(function(){

	$.formValidator.initConfig({formID:"form1",theme:"Default",submitOnce:true,
		onError:function(msg){
			conTip(msg,icons.warning);
		},
		ajaxPrompt : '有数据正在异步验证，请稍等...'
	});
	
	var inp = $('input:text,input:password,input:radio,input:checkbox');//所有文本框
    inp.bind('keydown', function (e) {
        var key = e.which;
        if (key == 13) {
            e.preventDefault();
            var nxtIdx = inp.index(this) + 1;
            inp.eq(nxtIdx).focus();
        }
    });
});