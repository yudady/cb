<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>manager|auction</title>
<script type="text/javascript">
$(function(){
	$("input[type='file']").on('change',function(){
		$("#auctionLogoPathAction").val('upDate');
		$("#auctionLogoPathPic").attr('src','');
	});
	
	$('.cleditor').cleditor({
		width:        780, // width not including margins, borders or padding
		height:       350 // height not including margins, borders or padding});
	});	

});
</script>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content">
		<div id="crumbs">
			<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
			<b> » </b>
			<a href='<c:url value="/manager/auction/list.do" />'>auction list</a>
			<b> » </b>
			update
		</div>
		<div>
			<a href='<c:url value="/manager/auction/list.do"/>'>
				<input type="button" value="auction list" />
			</a>
		</div>
		<form method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${auction.id}" /><br/>
			主題<input type="text" name="title" size="100" value="${auction.title}"  /><br/>
			描述<textarea class="cleditor" rows="10" cols="80" name="brief" id="brief" >${auction.brief}</textarea><br/>
			網址<input type="text" name="webSite" size="100" value="${auction.webSite}"  /><br/>
			logo
			<input type="hidden" id="auctionLogoPath" name="auctionLogoPath" value="${auction.auctionLogoPath}" />
			<input type="hidden" id="auctionLogoPathAction" name="auctionLogoPathAction" />
			<img id="auctionLogoPathPic" src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
			<input type="file" name="file" /><br/>
			開始日期<input class="datepicker" type="text" name="startDate" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${auction.startDate}" />' /><br/>
			結束日期<input class="datepicker" type="text" name="closeDate" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${auction.closeDate}" />' /><br/>
			<hr/>
			<input type="reset" name="reset" /><input type="submit" name="submit" id="submit"/><br/>
		</form>
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>