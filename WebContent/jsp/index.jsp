<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header.txt" %>
<style type="text/css">

.indexTop {
	width: 960px;
	height:550px;
	background-color: #FFFFFF;
	margin-left: 10px;
}
.content {
	width: 680px;
	position:relative;
	left: 260px;
	top: 10px;
	*left: 10px;/*IE7*/
}

.indexDown {
	margin-top:10px;
}

/**
 * 	下左
 */

#liveAuctions {
	margin-left:10px;
	width: 550px;
	height:1300px;
	background-color: #FFFFFF;
}
#liveAuctions h1{
	padding:20px;
	text-align: left;
	font-size: 36px;
}

#liveAuctions .auction {
	height: 100px;
	padding: 20px;
}
#liveAuctions .auctionTitle {
	font-size: 18px;
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
	margin-right:10px;
	height:1300px;
	float:right;
	width: 400px;
	background-color: white;
}

#itemsClosing>img {
	width: 380px;
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
	
    $(".timeLeft").timeLeft({split:", ",style:"detail"});
	
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
	
	$(".indexTop").corner('top 30px');
	$(".mainBody").corner('top 30px');
	$("#sidebar").corner('top');
	$("#menu").corner();
	
});
</script>

<div class="indexTop">
<%@ include file="/jsp/include/menu.txt" %>
<div class="content">
	<div id="contentSlideshow">
		<div>
			<div></div>
			<input class="cssButton" type="button" value="Bid NOW" /><br/>
			<div></div>
        	<img src="" alt="" />
			<div></div>
            <i id="icon-left">&lt;&lt;</i>
            <i id="icon-right">&gt;&gt;</i>
		</div>
		<div>
			<ul>
				<c:forEach items="${slideItems}" var="slideItem">
					<li>
						<img src='<c:url value="/pic/upload/item/${slideItem.mainPicturePath}"/>'  />
						<div style="display: none">
							<span><a href='<c:url value="/item/${slideItem.itemId}/index.do"/>'>${slideItem.auctionTitle}</a></span>
							<div><a href='<c:url value="/item/${slideItem.itemId}/index.do"/>'>${slideItem.itemTitle}</a></div>
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
			<div class="auctionSpilt"><hr /></div>
			<a href='<c:url value="/auctions/${auction.id}/index.do"/>'><img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' /></a>
			<dl>
				<dt class="auctionTitle">${auction.title}</dt>
				<dd><fmt:formatDate value="${auction.closeDate}" dateStyle="full" /></dd>
				<dd class="timeLeft">${auction.closeDate.time}</dd>
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
