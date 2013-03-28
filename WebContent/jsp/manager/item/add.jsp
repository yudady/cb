<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>manager|item</title>
<script type="text/javascript" src='<c:url value="/js/manager/item.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/manager/item.css"/>'/>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content">
		<div id="crumbs">
			<c:choose>
				<c:when test="${!empty auctionId}">
					<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
					<b> » </b>
					<a href='<c:url value="/manager/auction/list.do" />'>auction list</a>
					<b> » </b>
					<a href='<c:url value="/manager/auctionId/${auctionId}/item/list.do" />'>item list</a>
					<b> » </b>
				</c:when>
				<c:otherwise>
					<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
					<b> » </b>
					<a href='<c:url value="/manager/item/list.do" />'>item list</a>
					<b> » </b>
				</c:otherwise>
			</c:choose>
			add
		</div>
		<div>
			<a href='<c:url value="/manager/auctionId/${auctionId}/item/list.do" />'>
				<input type="button" value="item list" />
			</a>
		</div>
		<form id="form1" method="post" enctype="multipart/form-data">
			<input type="hidden" name="itemIdForm" value="${item.id}"/>
			<fieldset>
  				<legend>第二級目錄</legend>
				<dl>
					<c:forEach	items="${subCategories}" var="subCategory" >
						<dd><span><label for="subCategoryIds-${subCategory.id}">${subCategory.name}</label><input type="checkbox" id="subCategoryIds-${subCategory.id}" name="subCategoryIds" value="${subCategory.id}" ${subCategory.itemCheckedMark }/></span></dd>
					</c:forEach>
				</dl>
 			</fieldset>
 			<div><label id="ftitle">商品訊息<input type="text" class="required" id="ftitle" name="title" value="${item.title}" size="100" /></label></div>
 			<div><label id="fcurrentBid">當前標價<input type="text" class="required" id="fcurrentBid" name="currentBid" value="${item.currentBid}" /></label></div>
 			<div><label id="festimatedValue">估計價值<input type="text" class="required" id="festimatedValue" name="estimatedValue" value="${item.estimatedValue}" /></label></div>
 			<div><label id="fincrementPrice">下次最小標價<input type="text" class="required" id="fincrementPrice" name="incrementPrice" value="${item.incrementPrice}" /></label></div>
			<input type="hidden" name="status" value="1" />
			<fieldset>
				<legend>LOTDETAILS訊息</legend>
				<textarea class="cleditor required" name="lotDetails" id="lotDetails">${item.lotDetails}</textarea>
			</fieldset>
			
			<fieldset>
				<legend>LOTDETAILS訊息</legend>
				<textarea class="cleditor required" name="legalTerms" id="legalTerms">${item.legalTerms}</textarea>
			</fieldset>
			
			<fieldset>
				<legend>SHIPPING訊息</legend>
				<textarea class="cleditor required" name="shipping" id="shipping">${item.shipping}</textarea>
			</fieldset>
			<input type="button" id="addPicBtn" value="add pic"/>
			<ul id="pics"></ul>
			<input type="reset" name="reset" value="reset" />
			<input type="submit" name="submit" value="submit" /><br/>
		</form>
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>