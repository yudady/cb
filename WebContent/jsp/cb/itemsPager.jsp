<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header.txt" %>
<title>itemsPager</title>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/cb/itemsPager.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/cb/itemsPager.js"/>'></script>
</head>
<body>
<%@ include file="/jsp/include/bodyTop.txt" %>
<div class="counter"><!-- counter start-->
	<div class="counterLeft"><%@ include file="/jsp/include/menu.txt" %></div>
	<div class="counterRight">
		<div class="auction">
			<c:choose>
				<c:when test="${!empty auctionId}"><%-- 拍賣會 --%>
					<div>
						<div id="crumbs">
							<a href='<c:url value="/" />'><i class="icon-home"></i></a><b> » </b>${auc.title}
						</div>
						<div class="auctionPic">
							<img src='<c:url value="/pic/upload/auction/${auc.auctionLogoPath}" />'>
						</div>
						<div class="auctionDetail">
							<div>${auc.brief}</div>
							<div>&nbsp;</div>
							<div>${auc.webSite}</div>
						</div>
					</div>
				</c:when>
				<c:when test="${!empty subcategoryId}"><%-- 二級目錄 --%>
					<div>
						<div id="crumbs">
							<a href='<c:url value="/" />'><i class="icon-home"></i></a>
							<b> » </b>
							<a href='<c:url value="/categories/${categoryId}/${categoryName}/index.do" />'>${categoryName}</a>
							<b> » </b>
							${subCategoryName}
						</div>
					</div>
				</c:when>
				<c:when test="${!empty categoryId}"><%-- 一級目錄 --%>
					<div>
						<div id="crumbs">
							<a href='<c:url value="/" />'><i class="icon-home"></i></a>
							<b> » </b>
							${categoryName}
						</div>
					</div>
				</c:when>
				<c:otherwise><%-- view all --%>
					<div>
						<div id="crumbs">
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="itemList">
			<jsp:include page="/jsp/include/pager.jsp">
				<jsp:param value="${pager.totalRecord}" name="totalRecord" />
				<jsp:param value="${pager.pageSize}" name="pageSize" />
				<jsp:param value="" name="url" />
			</jsp:include>
		</div>
		
		
		<div class="items">
			<c:forEach items="${pager.datas}" var="item">
			<div class="clearBoth">&nbsp;</div>
			<div class="item">
				<div class="pic">
					<div class="lotClosed">This item is now closed</div>
					<c:choose>
						<c:when test="${!empty auctionId}">
							<%-- 拍賣會 --%>
							<a href='<c:url value="/auctions/${auctionId}/${auc.title}/item/${item.id}/index.do" />'>
								<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
							</a>
						</c:when>
						<c:when test="${!empty subcategoryId}">
							<%-- 二級目錄 --%>
							<a href='<c:url value="/categories/${categoryId}/${categoryName}/subcategories/${subcategoryId}/${subCategoryName}/item/${item.id}/index.do" />'>
								<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
							</a>
						</c:when>
						<c:when test="${!empty categoryId}">
							<%-- 一級目錄 --%>
							<a href='<c:url value="/categories/${categoryId}/${categoryName}/item/${item.id}/index.do" />'>
								<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
							</a>
						</c:when>
						<c:otherwise>
							<%-- view all --%>
							<a href='<c:url value="/item/${item.id}/index.do" />'>
								<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
							</a>
						</c:otherwise>
					</c:choose>
				</div> 
				<div class="detail"> 
					<a href='<c:url value="/item/${item.id}/index.do" />'>${item.title}</a>
					<table>
						<tr>
							<th>Current Bid:</th>
							<td>${item.currentBid}</td>
						</tr>
						<tr>
							<th>Number of Bids:</th>
							<td>${item.bidTimes}</td>
						</tr>
						<tr>
							<th>Minimum Next Bid:</th>
							<td>${item.incrementPrice}</td>
						</tr>
						<tr>
							<th>Estimated Value:</th>
							<td>${item.estimatedValue}</td>
						</tr>
						<tr>
							<th>Lot Number:</th>
							<td>${item.id}</td>
						</tr>
						<tr>
							<th>Lot Closes:</th>
							<td>${item.closeDate}</td>
						</tr>
					</table>
					<c:choose>
						<c:when test="${!empty auctionId}">
							<%-- 拍賣會 --%>
							<a class="cssButton bidNow" href="<c:url value="/auctions/${auctionId}/item/${item.id}/index.do" />">Bid NOW</a>
						</c:when>
						<c:when test="${!empty subcategoryId}">
							<%-- 二級目錄 --%>
							<a class="cssButton bidNow" href="<c:url value="/categories/${categoryId}/${categoryName}/subcategories/${subcategoryId}/${subCategoryName}/item/${item.id}/index.do" />">Bid NOW</a>
						</c:when>
						<c:when test="${!empty categoryId}">
							<%-- 一級目錄 --%>
							<a class="cssButton bidNow" href="<c:url value="/categories/${categoryId}/${categoryName}/item/${item.id}/index.do" />">Bid NOW</a>
						</c:when>
						<c:otherwise>
							<%-- view all --%>
							<a class="cssButton bidNow" href="<c:url value="/item/${item.id}/index.do" />">Bid NOW</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			</c:forEach>
			<div class="clearBoth">&nbsp;</div>
		</div>
	
		<div class="itemList">
			<form id="displayClosed"  action="">
				Showing <strong>1</strong> item
				<input id="ftr-displayClosed" type="checkbox" name="closed" /> 
				<label for="ftr-displayClosed">Display closed items only</label>
			</form>
		</div>
	
	</div>
	<div class="clearBoth"></div>
</div><!-- counter end-->
<%@ include file="/jsp/include/footer.txt" %>
</body>
</html>