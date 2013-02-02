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
		<h2>${item.title}</h2>
		<div>
			<a href='<c:url value="/" />'><i><span>Home</span></i></a> » <a
				href='#" />'>麵包屑</a>
		</div>

		<div>
			<div>
				Current Bid: <span id="currentPrice">${item.currentBid}</span> <span>
					( <a href='<c:url value="/item/${item.id}/bidlog" />'>${item.bidTimes}</a>
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
			<span>${item.closeDate}<input id="biddingIitemWhat" type="button" value="?" /></span>
		</div>
		<div>
			<input id="biddingBidNowValue" type="text" />
			<input id="biddingBidNowBtn" type="button" value="Bid Now" />
		</div>
		<div>
			<span>you must bid at least ${item.incrementPrice}
				<input id="biddingIncrementPriceBtn" type="button" value="?" />
			</span>
		</div>


	</div>
	<div id="biddingProceedsBenefit">
 Proceeds Benefit: Steven J. Ross Scholarship Fund at Ross School
 這裡是一個超連結，連到其他商品網站
	</div>
	<div id="biddingWatchQuestion">
		<div id="biddingWatchThisItem">
			Ask a Question 
		</div>
		<div id="biddingAskQuestion">
			Ask a Question 
		</div>
	</div>
	<div id="biddingMoreDetails">
		<a href="#">More Details</a>
		<dl>
			<dt>Lot Number:</dt>
			<dd>${item.id}</dd>
			<dt>Estimated Value:</dt>
			<dd>${item.estimatedValue}</dd>
			<dt>Open Date</dt>
			<dd>${item.startDate}</dd>
			<dt>Close Date:</dt>
			<dd>${item.closeDate}</dd>
		</dl>
	</div>
	<div>
		Share this item:
	</div>
	<div>
		 tweet
		 fasebook
	</div>
</div>
<%@ include file="/jsp/include/footer.txt" %>