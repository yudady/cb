;$(function() {
	$("a.tabUrl").click(function(){
		window.parent.document.location = this.href;
		return false;
	});
});