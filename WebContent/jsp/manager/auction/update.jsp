<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header_manager.txt" %>
<%@ include file="/jsp/include/menu_manager.txt" %>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base_manager.css"/>'/>
<script type="text/javascript">
$(function(){
	$("input[type='file']").on('change',function(){
		$("#auctionLogoPathAction").val('upDate');
		$("#auctionLogoPathPic").attr('src','');
	});
});
</script>
<div id="content">
<form method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${auction.id}" /><br/>
	主題<input type="text" name="title" value="${auction.title}"  /><br/>
	描述<input type="text" name="brief" value="${auction.brief}"  /><br/>
	網址<input type="text" name="webSite" value="${auction.webSite}"  /><br/>
	logo
	<input type="hidden" id="auctionLogoPath" name="auctionLogoPath" value="${auction.auctionLogoPath}" />
	<input type="hidden" id="auctionLogoPathAction" name="auctionLogoPathAction" />
	<img id="auctionLogoPathPic" src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
	<input type="file" name="file" /><br/>
	開始日期<input class="datepicker" type="text" name="startDate" value="${auction.startDate}" /><br/>
	結束日期<input class="datepicker" type="text" name="closeDate" value="${auction.closeDate}" /><br/>
	<input type="reset" name="reset"/><br/>
	<input type="submit" name="submit"/><br/>
</form>
</div>
<%@ include file="/jsp/include/footer_manager.txt" %>





