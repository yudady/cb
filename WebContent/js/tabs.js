;$(function() {
	$("a.tabUrl").on('click',function(){
		window.parent.document.location = this.href;
		return false;
	});

	$(".item a").on('click', function() {
		window.parent.location.href = this.href;
	}); 

});