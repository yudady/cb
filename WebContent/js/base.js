;$(function() {
	$.log('base js');
	$("img.lazy").lazyload( { effect : "slideDown" } );
	$("div").addClass('ui-corner-all');
	
	
	
	$("#loginFormBtn").click(function(){
		$("#url").val(window.location.href);
		$("#loginForm").submit();
	});
	$("#loginOutFormBtn").click(function(){
		$("#url").val(window.location.href);
		$("#loginOutForm").submit();
	});
});





