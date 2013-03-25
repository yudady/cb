<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	<div class="counterRight"><!-- counterRight start-->
		<div class="counterRight-left"><!-- counterRight-left start-->
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
		</div><!-- counterRight-left end-->
		
		
		
		<div class="counterRight-right"><!-- counterRight-right start-->
			<div class="bidding">
				<div class="counterRight-right-empty"></div>
				<div class="biddingIitem"><!-- biddingIitem start-->
					<h2>${item.title}</h2>
					<div>
						<c:choose>
							<c:when test="${!empty auctionId}">
								<a href='<c:url value="/" />'><i class="icon-home"></i></a>
								<b> » </b>
								<a href='<c:url value="/auctions/${auctionId}/index.do" />'>${auctionTitle}</a>
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
						<div>&nbsp;</div>
						<div>
							Current Bid: 
							<span class="fontWeight">
								<fmt:formatNumber value="${item.currentBid}" type="currency" pattern="$#,##0"/>
							</span>&nbsp;&nbsp;
							 <span> 
							 	( <a href='<c:url value="/item/${item.id}/bidlog.do" />'>${item.bidTimes} bids</a> )
							</span>
						</div>
						<div>&nbsp;</div>
						<div id="placedBy">
							<c:if test="${!empty winner}">
								placed by: <b class="fontWeight">${winner.lastName}</b>
							</c:if>
						</div>
						<div>&nbsp;</div>
						<div>
							Estimated Value: <b class="fontWeight"><fmt:formatNumber value="${item.estimatedValue}" type="currency" pattern="$#,##0"/></b>
						</div>
						<div>&nbsp;</div>
						<div>
							<span class="defaultCountdown displayNone">${item.closeDate.time}</span>
							<span id="biddingItemCountdown"></span>
							<i class="icon-question-sign" id="biddingItemWhat">&nbsp;</i>
						</div>
						<div>&nbsp;</div>
					</div>
					<div><!-- Bid Now start-->
						<form id="biddingBidForm" action='<c:url value="/bid/${item.id}/index.do" />'>
							<span  class="bidNowSpan ui-corner-all">
								<a id="link-currency" href="#">$<i class="icon-sort-down"></i></a>
								<input id="biddingBidUrl" name="biddingBidUrl" type="hidden" />
								<input id="biddingBidNowPrice" class="inputBorderHide" name="biddingBidNowPrice" type="text" />
								&nbsp;&nbsp;&nbsp;&nbsp;
							</span>
							<input id="biddingBidNowBtn" name="biddingBidNowBtn" type="button" class="cssButton" value="Bid Now" />
						</form>
					</div><!-- Bid Now end-->
					<div>
						<span>
							you must bid at least 
							<fmt:formatNumber value="${item.incrementPrice}" type="currency" pattern="$#,##0"/>
							<input id="incrementPrice" type="hidden" value="${item.incrementPrice}"/>
							<i class="icon-question-sign" id="biddingIncrementPriceBtn">&nbsp;</i>
						</span>
					</div>
				</div><!-- biddingIitem end-->
				
				<div class="biddingProceedsBenefit"><!-- 連結到拍賣會網站 -->
					<i class="icon-heart"></i>Proceeds Benefit:
					<a target="_blank" href="${auction.webSite}">
						${auction.title}
					</a>
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
					<h3>Share this item:</h3>
					<div>
						<%-- fix it start --%>
						<div class="shareItem">
							<iframe class="twitter-share-button twitter-count-vertical" scrolling="no" frameborder="0" allowtransparency="true" src="http://platform.twitter.com/widgets/tweet_button.1363148939.html#_=1364176683481&count=vertical&id=twitter-widget-0&lang=en&original_referer=http%3A%2F%2Fwww.charitybuzz.com%2Fauctions%2Fonedrop%2Fcatalog_items%2F339936%3Fref%3Darea&size=m&text=6-Night%20Stay%20at%20a%20Private%20Compound%20on%20Kona%2C%20Hawaii%20for%20Up%20to%2030%20Guests&url=http%3A%2F%2Fwww.charitybuzz.com%2Fauctions%2Fonedrop%2Fcatalog_items%2F339936%3Fref%3Darea" style="width: 55px; height: 62px;" title="Twitter Tweet Button" data-twttr-rendered="true"></iframe>
						</div>
						<div class="shareItem">
							<span>Facebook</span>
						</a>
						</div>
						<div class="shareItem">
							<iframe id="I0_1364176683706" width="100%" scrolling="no" frameborder="0" hspace="0" marginheight="0" marginwidth="0" style="position: static; top: 0px; width: 50px; margin: 0px; border-style: none; left: 0px; visibility: visible; height: 60px;" tabindex="0" vspace="0" name="I0_1364176683706" src="https://plusone.google.com/_/+1/fastbutton?bsv&size=tall&hl=en-US&origin=http%3A%2F%2Fwww.charitybuzz.com&url=http%3A%2F%2Fwww.charitybuzz.com%2Fauctions%2Fonedrop%2Fcatalog_items%2F339936%3Fref%3Darea&ic=1&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.zh_TW.BJ49Ir2ODhE.O%2Fm%3D__features__%2Fam%3DQQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAItRSTO_QqGUOsZIIfUtfDIIj2wAdQwK8Q#_methods=onPlusOne%2C_ready%2C_close%2C_open%2C_resizeMe%2C_renderstart%2Concircled&id=I0_1364176683706&parent=http%3A%2F%2Fwww.charitybuzz.com&rpctoken=7963905" allowtransparency="true" data-gapiattached="true" title="+1"/>
							</iframe>
						</div>
						<div class="clearBoth"></div>
						<input type="button" value="email">
						<input type="button" value="reddit this">
						<input type="button" value="pinit">
						<%-- fix it end --%>
					</div>
				</div>
			</div>
			<div class="clearBoth"></div>
		</div><!-- counterRight-right end-->
	</div><!-- counterRight end-->
	<div class="clearBoth">&nbsp;</div>
</div><!-- counter end-->
<%@ include file="/jsp/include/footer.txt" %>
</body>
</html>