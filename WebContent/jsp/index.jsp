<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header.txt" %>
<title>index</title>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/cb/index.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/cb/index.js"/>'></script>
</head>
<body>
<%@ include file="/jsp/include/bodyTop.txt" %>
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
	            <i id="icon-left" class="icon-double-angle-left"></i>
	            <i id="icon-right" class="icon-double-angle-right"></i>
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
			<input type="hidden" id="auctionsPageSize" value="${auctionsPageSize}" />
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
</body>
</html>