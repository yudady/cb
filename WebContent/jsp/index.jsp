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
<link type="text/css" rel="stylesheet" href='<c:url value="/css/slideshow.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/slideshow.js"/>'></script>
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
		<img class="lazy" src='<c:url value="/pic/upload/item/3331_feature.jpg"/>' src='<c:url value="/pic/site/grey.gif"/>' />
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

	





