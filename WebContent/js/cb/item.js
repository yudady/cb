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
        watch.item( itemId , watchStatus , {
            callback : function(data){
                $.log(data);
            },
            errorHandler : function(){
                ch.openAlertDialog("We can't add those values!");
            }
        });
         */
        $.ajax({
            type: "POST",
            url: '<c:url value="/watch/index.do" />',
            dataType: "json",
            data: {
                "itemId":itemId,
                "watchStatus":watchStatus
            },
            success: function(msg){
                $.log(data);
            }
        });
    });
    

    
    //以下是頁面資訊=============================================
    $("#itemTabs").tabs();
    /*    
    var a = $(".counterLeft").height();
    var b = $(".counterRight").height();
    var hei = (a > b)? a : b ;
    $('.counterLeft,.counterRight').height(hei);

    */
    
    
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
        cb.openAlertDialog("Max Bid This item supports Max Bidding! The bid you enter will automatically be a Max Bid. If your Max Bid is higher than the next Bid Increment, the bid will only be raised to the next Bid Increment. If someone else bids on this item for an amount less than your Max Bid, then you will automatically beat them and your bid will be increased to the Bid Increment necessary to beat them (or increased to your Max Bid itself, if that's lower).Bid Increment  To keep bidding competitive and interesting, you are required to increase the bid by an amount comparable to the current bid itself. Here's the guide:  Current Bid Amount  Bid Increment   250 or less     25  250 - 500   50");
        event.preventDefault();
        event.stopPropagation();
    });
    $(".biddingMoreDetails a").on('click',function(event){
        $(".biddingMoreDetails table").toggle('slow');
        $(this).find("span").toggle();
        event.preventDefault();
        event.stopPropagation();
    });
    //$(".indexTop").corner('top 30px');
    $(".mainBody").corner('top 30px');
    $(".counterLeft").corner('tl 20px');
    $(".counterRight,.counterRight-right,.counterRight-right-empty").corner('tr 20px');
    
    //$("#sidebar").corner('top');
    //$("#menu").corner();
});