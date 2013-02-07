;$(function() {
	$.log('base js');
	$("img").lazyload( { effect : "slideDown" } );
	
	
	
	
	$("#loginFormBtn").click(function(){
		$("#url").val(window.location.href);
		$("#loginForm").submit();
	});
	$("#loginOutFormBtn").click(function(){
		$("#url").val(window.location.href);
		$("#loginOutForm").submit();
	});
});





