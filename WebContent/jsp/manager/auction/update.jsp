<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header_manager.txt" %>
<%@ include file="/jsp/include/menu_manager.txt" %>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base_manager.css"/>'/>
<div id="content">
update
<form method="post">
	<input type="hidden" name="id" value="${auction.id}" /><br/>
	主題<input type="text" name="title" value="${auction.title}"  /><br/>
	描述<input type="text" name="brief" value="${auction.brief}"  /><br/>
	網址<input type="text" name="webSite" value="${auction.webSite}"  /><br/>
	logo<input type="text" name="auctionLogoPath" value="${auction.auctionLogoPath}"  /><br/>
	開始日期<input class="datepicker" type="text" name="startDate" value="${auction.startDate}"  /><br/>
	結束日期<input class="datepicker" type="text" name="closeDate" value="${auction.closeDate}"  /><br/>
	<input type="reset" name="reset" "/><br/>
	<input type="submit" name="submit" "/><br/>
</form>

</div>
<%@ include file="/jsp/include/footer_manager.txt" %>





