<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header.txt" %>
<%@ include file="/jsp/include/menu.txt" %>
<style type="text/css">
#content {
	width: 750px;
	float: right;
	margin-bottom: 20px;
}

#liveAuctions {
	width: 600px;
	float: left;
	background-color: pink;
	margin-bottom: 20px;
}

#liveAuctions hr {
	clear: both;
}

#liveAuctions .item {
	height: 120px;
	padding: 20px;
}

#liveAuctions .item img {
	float: left;
	width: 159px;
	height: 116px;
	margin-right: 20px;
}

#liveAuctions .item dl a {
	margin-top: 20px;
	margin-left: 20px;
}

#itemsClosing {
	width: 370px;
	float: right;
	background-color: gray;
}

#itemsClosing img {
	margin: 10px;
}

#itemsClosing #tabs4 span {
	font-size: 8px;
	text-align: center;
}
</style>
<script type="text/javascript">
;$(function() {
	$.log('index');
	$('#tabs4').tabs({
	    load: function(event, ui) {
	        $(ui.panel).delegate('a', 'click', function(event) {
	            $(ui.panel).load(this.href);
	            event.preventDefault();
	        });
	    }
	});
});
</script>
<style type="text/css">
.slideshow {
	width: 750px;
	height: 500px;
	background-color: #CCC;
}

.slideshow img {
	cursor: pointer;
}

.slideshow-top {
	height: 400px;
	margin-bottom: 10px;
}
.slideshow-top .picMsg {
	width:750px;
	height:100px;
	font-size:24px;
	position: absolute;
	background-color: gray;
}
.slideshow-top img {
	width: 750px;
	height: 400px;
}

.slideshow-top .direction{
	width:100px;
	height:30px;
	font-size:18px;
	background-color: black;
	position: absolute;
	margin-left:630px;
	margin-bottom:10px;
	color:white;
	top:530px;
}
.slideshow-top .direction input{
	width:30px;
	cursor: pointer;
}
.slideshow-button {
	width: 750px; 
	position: relative;
	overflow: hidden;
}

.slideshow-button ul {
	width: 9999px;
}

.slideshow-button ul li {
	height: 100%;
	float: left;
}

.slideshow-button img {
	margin:2px;
	padding:10px;
	width: 70px;
	height: 60px;
}
.slideshow-button-click {
	background-color: red;
}

</style>
<script type="text/javascript">
	
	$(function() {
		$("div").addClass('ui-corner-all');
		var si = 8;
 		var moviePic = 8;
 		var positionRelative = 0;
 		var moveLength = 94 ;//(70 + 10 + 10 + 2 + 2).slideshow-button img
 		
 		var imgs = $(".slideshow-button img");
 		
 		si = ( si <= imgs.size()) ? si : imgs.size();
 		
 		
 		$(".slideshow-top img").attr("src",imgs.first().attr("src"));
 		imgs.first().addClass("slideshow-button-click");
 		addMoveActivity(0,si);
		function addMoveActivity(start,end){
			$(".move-activity").removeClass("move-activity");
			imgs.each(function(i,value){
				if(i < end && i >= start){
					$(this).addClass("move-activity");
				}
			});
		}
		
		
		$('.move-activity').live('click', function() {
			$(".slideshow-button-click").removeClass("slideshow-button-click");
			$(this).addClass("slideshow-button-click");
			topPicChange(this);
			
		});
		
		
		
		
		$(".slideshow-top .picMsg").css({"opacity":"0.4"});
		$(".slideshow-top .direction").css({"opacity":"0.4"});
		$(".slideshow-top .picMsg input[type='button']").click(function(){
			alert('1');
		});
		
		
		$("#left").click(function(){
			if(positionRelative >= imgs.size()-si){
				return;
			}
			
			positionRelative = positionRelative + moviePic ;
			
			if(positionRelative + moviePic >= imgs.size()){
				positionRelative = imgs.size() - moviePic;
			}
			
			
			
			addMoveActivity(positionRelative,si+positionRelative);
			move();
		}); 
		$("#right").click(function(){
			if(positionRelative <= 0){
				return;
			}
			
			positionRelative = positionRelative - moviePic;
			
			if(positionRelative <= 0){
				positionRelative = 0;
			}
			
			
			
			$.log(positionRelative);
			
			
			addMoveActivity(positionRelative,si+positionRelative);
			move();
		});
		function move(){
			imgs.css({"position":"relative"}).animate({
 				left : -(moveLength * positionRelative )+ "px"
 			}, 500);
		}
		
		
		function findNextPic(){
			var p = $(".slideshow-button-click").removeClass("slideshow-button-click");
			var q = p.parent().parent().next().find(".move-activity");
			if(q.size() > 0){
				q.addClass("slideshow-button-click");
			}else{
				$(".move-activity").removeClass("slideshow-button-click");
				$(".move-activity").first().addClass("slideshow-button-click");
			}
			
			var pic = $(".slideshow-button-click")[0];
			topPicChange(pic);
		};
		
		
		function topPicChange(pic){
			$(".slideshow-top img").attr("src" ,pic.src);
			$(".picMsg span").html(pic.alt);
		};
		
		var myTimer = window.setInterval(findNextPic, 1000);
		$(".slideshow").on("mouseenter",function(){
			window.clearInterval(myTimer);
		});
		$(".slideshow").on("mouseleave",function(){
			myTimer = window.setInterval(findNextPic, 1000);
		});
		
	});
</script>


<div id="content">
	<div class="slideshow">
		<div class="slideshow-top">
			<div class="picMsg">
					<span></span>
					<br/>
					<input type="button" value="click" /><br/>
			</div>
        	<img src="" alt="" />
			<div class="direction">
				<input type="button" id="left" value="<<"/>
				<input type="button" id="right" value=">>"/>
			</div>
		</div>
		<div class="slideshow-button">
			<ul>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/3331_feature.jpg"/>' alt="Flowing Rock" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/grass-blades.jpg"/>' alt="Grass Blades" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/stones.jpg"/>' alt="Stones" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/sea-mist.jpg"/>' alt="Sea Mist" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/pier.jpg"/>' alt="Pier" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/lotus.jpg"/>' alt="Lotus" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/mojave.jpg"/>' alt="Mojave" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/lightning.jpg"/>' alt="Lightning" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/ladybug.jpg"/>' alt="Ladybug" /></a></li>
				
				<li><a href="#"><img src='<c:url value="/pic/upload/item/3331_feature.jpg"/>' alt="Flowing Rock" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/grass-blades.jpg"/>' alt="Grass Blades" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/stones.jpg"/>' alt="Stones" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/sea-mist.jpg"/>' alt="Sea Mist" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/pier.jpg"/>' alt="Pier" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/lotus.jpg"/>' alt="Lotus" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/mojave.jpg"/>' alt="Mojave" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/lightning.jpg"/>' alt="Lightning" /></a></li>
				<li><a href="#"><img src='<c:url value="/pic/upload/item/ladybug.jpg"/>' alt="Ladybug" /></a></li>
				
			</ul>
		</div>
	</div>
</div>
<div id="liveAuctions">
	<h1>Current Auctions</h1>
	<hr />
	<div class="item">
		<img class="lazy" src='<c:url value="/pic/upload/item/3331_feature.jpg"/>' />
		<dl>
			<dt>Boot Campaign Online Auction</dt>
			<dd>Feb 4 to Feb 26</dd>
			<dd>Time Left: 19 days, 17 hrs, 6 mins </dd>
			<dd><a class="cssButton">view items</a></dd>
		</dl>
	</div>
	
	<hr />
	<div class="item">
		<img class="lazy" data-original='<c:url value="/pic/upload/item/3331_feature.jpg"/>' src='<c:url value="/pic/site/grey.gif"/>' />
		<dl>
			<dt>Boot Campaign Online Auction</dt>
			<dd>Feb 4 to Feb 26</dd>
			<dd>Time Left: 19 days, 17 hrs, 6 mins </dd>
			<dd><a class="cssButton">view items</a></dd>
		</dl>
	</div>
	

	<hr />
	<jsp:include page="/jsp/include/pager.jsp">
		<jsp:param value="${pager.totalRecord}" name="totalRecord" />
		<jsp:param value="${pager.pageSize}" name="pageSize" />
		<jsp:param value="" name="url" />
	</jsp:include>
</div>
<div id="itemsClosing">
	<img src='<c:url value="/pic/upload/indexright/sharethelove_banner.jpg"/>'>
	<div id="tabs4">
	     <ul>
	         <li><a href='<c:url value="/items/closingNext.do"/>'><span>Closing Next</span></a></li>
	         <li><a href='<c:url value="/items/hotDeals.do"/>'><span>Deals</span></a></li>
	         <li><a href='<c:url value="/items/popular.do"/>'><span>Most Popular</span></a></li>
	         <li><a href='<c:url value="/items/recentAdd.do"/>'><span>Recently Added</span></a></li>
	     </ul>
	</div>
</div>
<%@ include file="/jsp/include/footer.txt" %>

	





