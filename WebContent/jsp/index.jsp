<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header.txt" %>
<style type="text/css">

.indexTop {
	background-color: #FFFFFF;
	padding: 2px;
}
.content {
	width: 760px;
	margin-bottom: 20px;
	position:relative;
	left: 210px;
	margin-right:5px;
}

.indexDown {
	margin-top:20px;
	padding: 2px;
}

/**
 * 	下左
 */

#liveAuctions {
	width: 600px;
	background-color: #FFFFFF;
}

#liveAuctions .auction {
	height: 120px;
	padding: 20px;
	margin-bottom: 10px;
}

#liveAuctions .auction img {
	width: 159px;
	height: 116px;
	margin-right: 20px;
	float: left;
}

#liveAuctions .auction dl {
	margin-top: 20px;
	margin-left: 20px;
}
#liveAuctions .auction dl a {
	margin-top: 20px;
	margin-left: 20px;
}
#auctionsPager {
	margin-left: 400px;
}
#auctionsPager .auctionsActive{
	color:white;
	background-color: #C52100;
}


/**
 * 	下右邊
 */
#itemsClosing {
	/*
	position:absolute;
	left:760px;*/
	float:right;
	width: 365px;
	background-color: gray;
}

#itemsClosing img {
	margin: 10px;
}


</style>
<link type="text/css" rel="stylesheet" href='<c:url value="/js/jquery/jquery-ui-slideshow/jquery.ui.plugin.slideshow.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-ui-slideshow/jquery.ui.plugin.slideshow.js"/>'></script>
<script type="text/javascript">
;$(function() {
	//輪播
	$("#contentSlideshow").slideshow();
	$('#tabs4').tabs({
	    load: function(event, ui) {
	        $(ui.panel).on('click', 'a', function(event) {
	            $(ui.panel).load(this.href);
	            event.preventDefault();
	        });
	    }
	});
	
	
	
	//======Auctions 分頁start
	function currentAuctions(){
		var num = $("#auctionsPager").data("num") ;
		
		if(num == 1){
			$('#prevPager').css({visibility:"hidden"});
		}else{
			$('#prevPager').css({visibility:"visible"});
		}
		
		if(num == $('.auctionsNum').size()){
			$('#nextPager').css({visibility:"hidden"});
		}else{
			$('#nextPager').css({visibility:"visible"});
		}
		
		
		var currentA = $('.auctionsNum').removeClass('auctionsActive').get(parseInt(num) -1);
		$(currentA).addClass('auctionsActive');
		
		var cou = ${auctionsPageSize} ;
		var start = (parseInt(num) - 1) * cou;
		var end = start + cou ;
		$('.auction').hide().each(function(index,value){
			if(index >= start && index < end){
				$(this).show();
			}
		});
	}
	
	$('.auctionsNum').on('click',function(event){
		var num = $(this).text();
		$("#auctionsPager").data("num",num);
		currentAuctions();
		event.preventDefault();
	});
	
	$('#prevPager').on('click',function(event){
		var num = $("#auctionsPager").data("num");
		$("#auctionsPager").data("num",parseInt(num) -1);
		currentAuctions();
		event.preventDefault();
	});
	$('#nextPager').on('click',function(event){
		var num = $("#auctionsPager").data("num") || 1;
		$("#auctionsPager").data("num",parseInt(num) + 1);
		currentAuctions();
		event.preventDefault();
	});
	$('.auctionsNum').first().triggerHandler('click');
	//======Auctions 分頁end
	
});
</script>

<div class="indexTop">
<%@ include file="/jsp/include/menu.txt" %>
<div class="content">
	<div id="contentSlideshow">
		<div>
			<input class="cssButton" type="button" value="Bid NOW" /><br/>
			<div></div>
        	<img src="" alt="" />
			<div>
                <i class="icon-double-angle-left" >&nbsp;</i>&nbsp;&nbsp;&nbsp;&nbsp;
                <i class="icon-double-angle-right">&nbsp;</i>
			</div>
		</div>
		<div>
			<ul>
				<c:forEach items="${topItems}" var="it">
					<li>
						<img src='<c:url value="/pic/upload/item/${it.mainPicturePath}"/>' alt="${it.title}" />
						<div style="display: none">
							<div>${it.title}</div>
							<div>${it.title}</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
</div>

<div class="indexDown">
<div id="itemsClosing">
	<img src='<c:url value="/pic/upload/indexright/sharethelove_banner.jpg"/>'>
	<%@ include file="/jsp/include/tabs4.txt" %>
</div>
<div id="liveAuctions"><!-- liveAuctions -->
	<h1>Current Auctions</h1>
	
	<c:forEach items="${auctions}" var="auction">
		<div class="auction">
			<a href='<c:url value="/auctions/${auction.id}/index.do"/>'><img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' /></a>
			<dl>
				<dt>${auction.title}</dt>
				<dd>${auction.startDate}</dd>
				<dd>${auction.closeDate}</dd>
				<dd><a class="cssButton" href='<c:url value="/auctions/${auction.id}/index.do"/>'>view items</a></dd>
			</dl>
		</div>
	</c:forEach>
		<div id="auctionsPager">
			<a id="prevPager" href="#" >« previous </a>
				<c:forEach items="${auctions}" begin="0" step="${auctionsPageSize}" varStatus="status" >
					<a class="auctionsNum" href="#">&nbsp;<c:out value="${status.count}"/>&nbsp;</a>
				</c:forEach>
			<a id="nextPager" href="#">next » </a>
		</div>
</div><!-- liveAuctions -->

</div>
<%@ include file="/jsp/include/footer.txt" %>
