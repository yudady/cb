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
	margin-bottom: 20px;
	background-color: #FFFFFF;
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
	$('#tabs4').tabs({
	    load: function(event, ui) {
	        $(ui.panel).on('click', 'a', function(event) {
	            $(ui.panel).load(this.href);
	            event.preventDefault();
	        });
	    }
	});
	$("#contentSlideshow").slideshow();
});
</script>

<div class="indexTop">
<%@ include file="/jsp/include/menu.txt" %>
<div class="content">
	<div id="contentSlideshow">
		<div>
			<input class="cssButton" type="button" value="Bid NOW" /><br/>
			<div><span>&nbsp;</span></div>
        	<img src="" alt="" />
			<div>
                <i class="icon-double-angle-left" >&nbsp;</i>&nbsp;&nbsp;&nbsp;&nbsp;
                <i class="icon-double-angle-right">&nbsp;</i>
			</div>
		</div>
		<div>
			<ul>
				<c:forEach items="${topItems}" var="it">
					<li><img src='<c:url value="/pic/upload/item/${it.mainPicturePath}"/>' alt="${it.title}" /></li>
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
	
	TODO使用假分頁
	<jsp:include page="/jsp/include/pager.jsp">
		<jsp:param value="${auctions.totalRecord}" name="totalRecord" />
		<jsp:param value="${auctions.pageSize}" name="pageSize" />
		<jsp:param value="" name="url" />
	</jsp:include>
</div><!-- liveAuctions -->

</div>
<%@ include file="/jsp/include/footer.txt" %>
