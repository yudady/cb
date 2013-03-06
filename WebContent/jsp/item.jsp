<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/jsp/include/header.txt" %>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/watch.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/time-tag.css"/>'/>
<style type="text/css">

.counter {
	padding: 10px;
	background-color: white;

}


/**
 *	中間
 */
#itemDetail {
	margin-left:5px;
	width: 400px;
	padding: 5px;
	background-color:#CCC;
	float: left;
	position: relative;
}
#itemDetail img{
	cursor: pointer;
}
#itemDetail a {
	text-decoration:none;
	color:#B5121B;
}
#itemDetail a:hover {
	color:red;
}

/**
 *  大圖
 */
#itemDetail .itemLargePic img {
	width: 400px;
}
/**
 *  小圖
 */
#itemDetail .itemSmallPic img {
	width: 75px;
	height: 50px;
	padding: 2px;
}
#itemTabs a {
	color:black;
}

/**
 *右邊
 */
.bidding {
	margin-left:620px;
	width: 330px;
	padding: 5px;
	background-color: #CCC;
	position: relative;
}

.biddingIitem {
	background-color: white;
}


.biddingProceedsBenefit {
	margin-bottom: 10px;
	background-color: purple;
}

.biddingWatchQuestion {
	text-align:center;
	height:50px;
	line-height: 50px;
	font-size: 14px;
	margin-bottom: 10px;
}
.biddingWatchQuestion div{
	width:164px;
	height:50px;
	line-height: 50px;
	background-color: white;
	cursor: pointer;
}
#biddingWatchThisItem {
	float:left;
}
#biddingAskQuestion {
	float:right;
}




/**
 * detail
 */
.biddingMoreDetails {
	background-color: white;
}
.biddingMoreDetails a {
	font-size: 18px;
}
.biddingMoreDetails table {
	display: none;
}
.shareItem {
	background-color: olive;
}



.imgHighLight {
    background-color: red;
}

.bidNowSpan {
	font-size: 20px;
	margin-left:10px;
	width:130px;
	border-color:red;
	border:1px solid red;
}
.bidNowSpan input{
	text-align: right;
}
#biddingBidNowBtn {
	position: absolute;
	left: 200px;
	top: 85px;
}


</style>
<script type="text/javascript">
$(function() {
	
	
	$(".itemLargePic img").on('click',function(){
		var clo = $(this).clone();
		clo.css({ 
			width: "500px",
			height: "400px"
		});
		$("#itemLargePicDialog").append(clo).dialog({
			title: "",
			width: 530,
			height:450,
			modal: true,
			close: function( event, ui ) {
				$("#itemLargePicDialog").empty().dialog( "destroy" );
			}
		});
	});

	
	//第一張小圖加上color
	$(".itemSmallPic img").first().addClass("imgHighLight");
	
	//中間=============================
	//點擊圖片
	$(".itemSmallPic img").on('click',function(event){
		$(".itemLargePic img").attr("src",$(this).attr("src"));
		event.preventDefault();
		event.stopPropagation();
	});
	//上一張圖片
	$(".previousImage").on('click',function(event){
		var currentPicSrc = $(".itemLargePic img").attr("src");
		var smallImgs = $(".itemSmallPic img");
		var cur = smallImgs.filter("[src='"+currentPicSrc+"']").prev();
		if(cur.size() == 0){
			cur = smallImgs.last();
		}
		$(".itemLargePic img").attr("src",cur.attr("src"));
		smallImgs.removeClass("imgHighLight");
		cur.addClass("imgHighLight");
		event.preventDefault();
		event.stopPropagation();
	});
	//下一張圖片
	$(".nextImage").on('click',function(event){
		var currentPicSrc = $(".itemLargePic img").attr("src");
		var smallImgs = $(".itemSmallPic img");
		var cur = smallImgs.filter("[src='"+currentPicSrc+"']").next();
		if(cur.size() == 0){
			cur = smallImgs.first();
		}
		$(".itemLargePic img").attr("src",cur.attr("src"));
		smallImgs.removeClass("imgHighLight");
		cur.addClass("imgHighLight");
		event.preventDefault();
		event.stopPropagation();
	});
	
	

	//右邊=============================
	/**
	 * bid now btn
	 * 競標
	 */
	$("#biddingBidNowBtn").on('click',function(){
		if(!(cb.isBidderLogin())){
			//沒登入
			window.location.href = cb.getSafeUrl("login.do");
			return;
		}
		
		var biddingBidNowPrice = $.trim($("#biddingBidNowPrice").val()) || "0";
		var incrementPrice = $("#incrementPrice").val() || "0";
		var hasError = false;
		
		if(parseFloat(biddingBidNowPrice) < parseFloat(incrementPrice)){
			hasError = true;
		}

		if(hasError){
			$("#biddingBidForm").effect('shake', 300);
			return;
		}
		
		//$("#biddingBidUrl").val(window.location.href);
		//$("#biddingBidForm").submit();
		alert('todo ajax ');
	});
	
	
	
	
	/**
	 * 關注
	 */
	$("#biddingWatchThisItem").click(function(event){
		event.preventDefault();
		event.stopPropagation();
		//判斷是否login
		if(!(cb.isBidderLogin())){
			window.location.href = cb.getSafeUrl("login.do");
			return;
		}
		var itemId = $("#loginOutFormItemId").val();
		// 0 沒關注 , 1 關注
		var watchStatus = "";
		if ($(".icon-eye-open:visible")[0]){
			watchStatus = "1";
			$(".biddingWatchThisItemLink").html('Watching');
		}else{
			watchStatus = "0";
			$(".biddingWatchThisItemLink").html('Watch This Item');
		}
		$(".icon-eye-open,.icon-check").parent().toggleClass("displayNone");
		/**
		 * call dwr
		 */
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
	$("#link-currency").on('click',function(event){
		cb.openAlertDialog(" money ");
		event.preventDefault();
		event.stopPropagation();
	});
	$("#biddingIitemWhat").on('click',function(event){
		cb.openAlertDialog("This is the time the auction will end, but \"Popcorn Bidding\" could add 10 minutes to the closing time. If a bid is placed within 10 minutes of the closing time, the auction will extend by 10 minutes. This allows competing bidders a chance to stay in the race.");
		event.preventDefault();
		event.stopPropagation();

	});
	$("#biddingIncrementPriceBtn").on('click',function(event){
		cb.openAlertDialog("Max Bid This item supports Max Bidding! The bid you enter will automatically be a Max Bid. If your Max Bid is higher than the next Bid Increment, the bid will only be raised to the next Bid Increment. If someone else bids on this item for an amount less than your Max Bid, then you will automatically beat them and your bid will be increased to the Bid Increment necessary to beat them (or increased to your Max Bid itself, if that's lower).Bid Increment	To keep bidding competitive and interesting, you are required to increase the bid by an amount comparable to the current bid itself. Here's the guide:	Current Bid Amount 	Bid Increment	250 or less 	25	250 - 500 	50");
		event.preventDefault();
		event.stopPropagation();
	});
	$(".biddingMoreDetails a").on('click',function(event){
		$(".biddingMoreDetails table").toggle('slow');
		$(this).find("span").toggle();
		event.preventDefault();
		event.stopPropagation();
	});
	
});


</script>
<div class="counter"><!-- counter -->
	<%@ include file="/jsp/include/menu.txt" %>
	<div id="itemDetail">
		<div class="itemLargePic">
			<!-- time-tag -->
			<div class="time-tag">
				<!-- rotate-clock -->
				<div class="rotate-clock">8 days</div>
			</div>
			<a href="#">
				<div>
					<i>&nbsp;</i>
				</div>
				<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
				<div id="itemLargePicDialog"></div>
			</a>
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
<div class="bidding">
	<div class="biddingIitem">
		<h2>${item.title}</h2>
		<div>
			<a href='<c:url value="/" />'><i><span>Home</span></i></a> » <a
				href='#" />'>麵包屑</a>
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
			<span>${item.closeDate}<i class="icon-question-sign" id="biddingIitemWhat">&nbsp;</i>
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


</div><!-- counter -->
<%@ include file="/jsp/include/footer.txt" %>