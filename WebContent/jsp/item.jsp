<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/jsp/include/header.txt" %>
<%@ include file="/jsp/include/menu.txt" %>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/item.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/item.js"/>'></script>
<div id="item">
	<div class="itemLargePic">
		<div>${item.difDay} day</div>
		<!-- time-tag -->
		<a href="#"> <img
			src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
		</a>
	</div>
	<div class="itemSmallPic">
		<c:if test="${fn:length(item.pictures) gt 1}">
			<c:forEach items="${item.pictures}" var="picture">
				<img src='<c:url value="/pic/upload/item/${picture.photoPath}" />' />
			</c:forEach>
		</c:if>
	</div>
	<div id="itemTabs">
		<ul>
			<li><a href="#lotDetails">Lot Details </a></li>
			<li><a href="#legalTerms">Legal Terms</a></li>
			<li><a href="#shipping">Shipping</a></li>
		</ul>
		<div id="lotDetails">${item.lotDetails}</div>
		<div id="legalTerms">${item.legalTerms}</div>
		<div id="shipping">${item.shipping}</div>
	</div>
</div>
<div id="bidding">
	<div id="biddingIitem">
		biddingIitem
	</div>
	<div id="biddingProceedsBenefit">
		biddingProceedsBenefit
	</div>
	<div id="biddingWatchQuestion">
		biddingWatchQuestion
	</div>
	<div id="biddingMoreDetails">
		biddingMoreDetails
	</div>
</div>
<%@ include file="/jsp/include/footer.txt" %>