;$(function() {
	$.log('base js');
	
	$("#loginFormBtn").click(function(){
		$("#url").val(window.location.href);
		$("#loginForm").submit();
	});
	$("#loginOutFormBtn").click(function(){
		$("#url").val(window.location.href);
		$("#loginOutForm").submit();
	});
});





