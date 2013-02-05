;$(function() {
	
	
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






