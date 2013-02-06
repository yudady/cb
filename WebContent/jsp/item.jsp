<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/jsp/include/header.txt" %>
<%@ include file="/jsp/include/menu.txt" %>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/item.css"/>'/>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/watch.js"/>'></script>
<script type="text/javascript">
$(function() {
	
	
	/**
	 * bid now btn
	 * 競標
	 */
	$("#biddingBidNowBtn").click(function(){
		if(!(cb.isBidderLogin())){
			window.location.href = cb.getSafeUrl("login.do");
			return;
		}
		
		$("#biddingBidUrl").val(window.location.href);
		$("#biddingBidForm").submit();;
	});
	
	
	
	
	/**
	 * 關注
	 */
	$("#biddingWatchQuestion").click(function(){
		//判斷是否login
		
		if(!(cb.isBidderLogin())){
			window.location.href = cb.getSafeUrl("login.do");
			return;
		}
		var itemId = $("#loginOutFormItemId").val();
		var watchStatus = "";
		if ($("#watchingItem").prop("checked")){
			watchStatus = "0";
			$("#watchingItem").prop("checked", false);
		}else{
			$("#watchingItem").prop("checked", true);
			watchStatus = "1";
		}
		watch.item( itemId , watchStatus , {
			callback : function(data){
				$.log(data);
			},
			errorHandler : function(){
				ch.openAlertDialog("We can't add those values!");
			}
		});
	});
	
	
	
	//以下是頁面資訊=============================================
	$("#itemTabs").tabs();
	$("#biddingIitemWhat").click(function(){
		cb.openAlertDialog("This is the time the auction will end, but \"Popcorn Bidding\" could add 10 minutes to the closing time. If a bid is placed within 10 minutes of the closing time, the auction will extend by 10 minutes. This allows competing bidders a chance to stay in the race.");
	});
	$("#biddingIncrementPriceBtn").click(function(){
		cb.openAlertDialog("Max Bid This item supports Max Bidding! The bid you enter will automatically be a Max Bid. If your Max Bid is higher than the next Bid Increment, the bid will only be raised to the next Bid Increment. If someone else bids on this item for an amount less than your Max Bid, then you will automatically beat them and your bid will be increased to the Bid Increment necessary to beat them (or increased to your Max Bid itself, if that's lower).Bid Increment	To keep bidding competitive and interesting, you are required to increase the bid by an amount comparable to the current bid itself. Here's the guide:	Current Bid Amount 	Bid Increment	250 or less 	25	250 - 500 	50");
	});
	$("#biddingMoreDetails a").click(function(){
		$("#biddingMoreDetails dl").toggle('slow');
		return false;
	});
	
});


</script>
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
			<form id="biddingBidForm" action='<c:url value="/bid/${item.id}/index.do" />'>
				<input id="biddingBidUrl" name="biddingBidUrl" type="hidden" />
				<input id="biddingBidNowPrice" name="biddingBidNowPrice" type="text" />
				<input id="biddingBidNowBtn" name="biddingBidNowBtn" type="button" value="Bid Now" />
			</form>
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
			<input type="checkbox" id="watchingItem" name="watchingItem" ${item.watch} />
			 Watch This Item
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