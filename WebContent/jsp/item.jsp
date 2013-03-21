<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header.txt" %>
<title>item</title>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/cb/item.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/cb/item.js"/>'></script>
</head>
<body>
<%@ include file="/jsp/include/bodyTop.txt" %>
<div class="counter"><!-- counter start-->
	<div class="clearBoth"></div>
	<div class="counterLeft"><!-- counterLeft start-->
		<%@ include file="/jsp/include/menu.txt" %>
		<div class="clearBoth"></div>
	</div><!-- counterLeft end-->
	<div class="counterMiddle"><!-- counterMiddle start-->
		<div id="itemDetail">
			<div class="itemLargePic">
				<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
			</div>
	
			<div class="itemSmallPic">
				<c:if test="${fn:length(item.pictures) gt 1}">
					<c:forEach items="${item.pictures}" var="picture">
						<img src='<c:url value="/pic/upload/item/${picture.photoPath}" />' />
					</c:forEach>
				</c:if>
			</div>
			<c:if test="${fn:length(item.pictures) gt 1}">
				<a href="#" class="previousImage"><i class="icon-circle-arrow-left">&nbsp;</i>previous image</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" class="nextImage">next image<i class="icon-circle-arrow-right">&nbsp;</i></a>
			</c:if>
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
		<div class="clearBoth"></div>
	</div><!-- counterMiddle end-->
	<div class="counterRight"><!-- counterRight start-->
		<div class="biddingStart">&nbsp;</div>
		<div class="bidding">
			<div class="biddingIitem">
				<h2>${item.title}</h2>
				<div>
					<c:choose>
						<c:when test="${!empty auctionId}">
							<a href='<c:url value="/" />'><i class="icon-home"></i></a>
							<b> » </b>
							<a href='<c:url value="/auctions/${auctionId}/${auctionTitle}/index.do" />'>${auctionTitle}</a>
						</c:when>
						<c:when test="${!empty subcategoryId}">
							<a href='<c:url value="/" />'><i class="icon-home"></i></a>
							<b> » </b>
							<a href='<c:url value="/categories/${categoryId}/${categoryName}/index.do" />'>category</a>
							<b> » </b>
							<a href='<c:url value="/categories/${categoryId}/${categoryName}/subcategories/${subcategoryId}/${subCategoryName}/index.do" />'>${subCategoryName}</a>
						</c:when>
						<c:when test="${!empty categoryId}">
							<a href='<c:url value="/" />'><i class="icon-home"></i></a>
							<b> » </b>
							<a href='<c:url value="/categories/${categoryId}/${categoryName}/index.do" />'>${categoryName}</a>
						</c:when>
					</c:choose>
				</div>
		
				<div>
					<div>
						Current Bid: <span id="currentPrice">${item.currentBid}</span> <span>
							( <a href='<c:url value="/item/${item.id}/bidlog.do" />'>${item.bidTimes}</a>
							)
						</span>
					</div>
					<div id="placedBy">
						placed by: <b>jaimervelasco</b>
					</div>
					<div>
						Estimated Value: <b> ${item.estimatedValue} </b>
					</div>
				</div>
				<div>
					<span>??? days left to bid</span>
				</div>
				<div>
					<span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.closeDate}" /><i class="icon-question-sign" id="biddingIitemWhat">&nbsp;</i>
				</div>
				
				
				
				<div><!-- Bid Now -->
					<form id="biddingBidForm" action='<c:url value="/bid/${item.id}/index.do" />'>
						<span  class="bidNowSpan ui-corner-all">
							<a id="link-currency" href="#">$<small>▾</small></a>
							<input id="biddingBidUrl" name="biddingBidUrl" type="hidden" />
							<input class="inputBorderHide" id="biddingBidNowPrice" name="biddingBidNowPrice" type="text" />
							&nbsp;&nbsp;&nbsp;&nbsp;
						</span>
						<input id="biddingBidNowBtn" name="biddingBidNowBtn" type="button" class="cssButton" value="Bid Now" />
					</form>
				</div>
				<div>
					<span>you must bid at least ${item.incrementPrice}
						<input id="incrementPrice" type="hidden" value="${item.incrementPrice}"/>
						<i class="icon-question-sign" id="biddingIncrementPriceBtn">&nbsp;</i>
					</span>
				</div>
		
		
			</div>
			<div class="biddingProceedsBenefit">
		 Proceeds Benefit: Steven J. Ross Scholarship Fund at Ross School
		 這裡是一個超連結，連到其他商品網站
			</div>
			<div class="biddingWatchQuestion">
				<div id="biddingWatchThisItem">
					<c:choose>
						<c:when test="${item.watch}">
							<span class="displayNone"><i class="icon-eye-open">&nbsp;</i></span>
							<span><i class="icon-check">&nbsp;</i></span>
							<a href="#" class="biddingWatchThisItemLink">Watching</a>
						</c:when>
						<c:otherwise>
							<span><i class="icon-eye-open">&nbsp;</i></span>
							<span class="displayNone"><i class="icon-check">&nbsp;</i></span>
							<a href="#" class="biddingWatchThisItemLink">Watch This Item</a>
						</c:otherwise>
					</c:choose>
				</div>
				<div id="biddingAskQuestion">
					<i class="icon-comments-alt">&nbsp;</i>
					<a href='<c:url value="/contact_us/item/${item.id}/index.do" />'>Ask a Question </a>
				</div>
			</div>
			<div class="biddingMoreDetails">
				<a href="#">
					<span><i class="icon-angle-right">&nbsp;</i></span>
					<span class="displayNone"><i class="icon-angle-down">&nbsp;</i></span>
					More Details
				</a>
				<table>
					<tr>
						<th>Lot Number:</th><td>${item.id}</td>
					</tr>
					<tr>
						<th>Estimated Value:</th><td>${item.estimatedValue}</td>
					</tr>
					<tr>
						<th>Open Date</th><td>${item.startDate}</td>
					</tr>
					<tr>
						<th>Close Date:</th><td>${item.closeDate}</td>
					</tr>
				</table>
			</div>
			<div class="shareItem">
				<h3>Share this item:</h3>
				<div>
					 tweet
					 fasebook
				</div>
			</div>
		</div>
		<div class="clearBoth"></div>
	</div><!-- counterRight end-->
	<div class="clearBoth">&nbsp;</div>
</div><!-- counter end-->
<%@ include file="/jsp/include/footer.txt" %>
</body>
</html>