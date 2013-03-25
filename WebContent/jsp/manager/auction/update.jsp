<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>auction</title>
<script type="text/javascript">
$(function(){
	$("input[type='file']").on('change',function(){
		$("#auctionLogoPathAction").val('upDate');
		$("#auctionLogoPathPic").attr('src','');
	});
});
</script>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content">
		<div>
			<a href='<c:url value="/manager/auction/list.do"/>'>
				<input type="button" value="auction list">
			</a>
		</div>
		<form method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${auction.id}" /><br/>
			主題<input type="text" name="title" size="100" value="${auction.title}"  /><br/>
			描述<textarea rows="10" cols="80" name="brief" >${auction.brief}</textarea><br/>
			網址<input type="text" name="webSite" size="100" value="${auction.webSite}"  /><br/>
			logo
			<input type="hidden" id="auctionLogoPath" name="auctionLogoPath" value="${auction.auctionLogoPath}" />
			<input type="hidden" id="auctionLogoPathAction" name="auctionLogoPathAction" />
			<img id="auctionLogoPathPic" src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
			<input type="file" name="file" /><br/>
			開始日期<input class="datepicker" type="text" name="startDate" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${auction.startDate}" />' /><br/>
			結束日期<input class="datepicker" type="text" name="closeDate" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${auction.closeDate}" />' /><br/>
			<input type="reset" name="reset"/><br/>
			<input type="submit" name="submit"/><br/>
		</form>
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>