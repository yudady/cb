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
	background-color: #FFFFFF;
	padding: 2px;
}

/**
 * 	下左
 */

#liveAuctions {
	width: 600px;
	margin-bottom: 20px;
}

#liveAuctions hr {
	/*
	clear: both;*/
}

#liveAuctions .item {
	height: 120px;
	padding: 20px;
}

#liveAuctions .item img {
	width: 159px;
	height: 116px;
	margin-right: 20px;
}

#liveAuctions .item dl a {
	margin-top: 20px;
	margin-left: 20px;
}





/**
 * 	下右邊
 */
#itemsClosing {
	/*
	position:absolute;
	left:760px;*/
	float:right;
	width: 370px;
	background-color: gray;
}

#itemsClosing img {
	margin: 10px;
}


</style>
<script type="text/javascript">
;$(function() {
	$('#tabs4').tabs({
	    load: function(event, ui) {
	        $(ui.panel).on('click', 'a', function(event) {
	            $(ui.panel).load(this.href);
	            event.preventDefault();
	        });
	    }
	});
});
</script>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/slideshow.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/slideshow.js"/>'></script>

<div class="indexTop">
<%@ include file="/jsp/include/menu.txt" %>
<div class="content">
	<div class="slideshow">
		<div class="slideshow-top">
			<div class="picMsg">
					<span>&nbsp;</span>
					<br/>
					<input class="cssButton" type="button" value="Bid NOW" /><br/>
			</div>
        	<img src="" alt="" />
			<div class="direction">
                <i class="icon-double-angle-left" id="left" >&nbsp;</i>&nbsp;&nbsp;&nbsp;&nbsp;
                <i class="icon-double-angle-right" id="right" >&nbsp;</i>
			</div>
		</div>
		<div class="slideshow-button">
			<ul>
				<c:forEach items="${topPics}" var="pic">
					<li><a href="#"><img src='<c:url value="/pic/upload/item/${pic.photoPath}"/>' alt="Flowing Rock" /></a></li>
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
<div id="liveAuctions">
	<h1>Current Auctions</h1>
	
	<c:forEach items="${auctions.datas}" var="auction">
		<div class="item">
			<a href='<c:url value="/auctions/${auction.id}/index.do"/>'><img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' /></a>
			<dl>
				<dt>${auction.title}</dt>
				<dd>${auction.startDate}</dd>
				<dd>${auction.closeDate}</dd>
				<dd><a class="cssButton" href='<c:url value="/auctions/${auction.id}/index.do"/>'>view items</a></dd>
			</dl>
		</div>
	</c:forEach>
	<jsp:include page="/jsp/include/pager.jsp">
		<jsp:param value="${auctions.totalRecord}" name="totalRecord" />
		<jsp:param value="${auctions.pageSize}" name="pageSize" />
		<jsp:param value="" name="url" />
	</jsp:include>
</div>

</div>
<%@ include file="/jsp/include/footer.txt" %>
