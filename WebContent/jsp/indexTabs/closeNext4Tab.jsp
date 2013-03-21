<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/jsp/include/header.txt" %>
<title>closeNext4Tab</title>
<script type="text/javascript" src='<c:url value="/js/indexTabs/closeNext4Tab.js"/>'></script>
</head>
<body>
	<c:forEach	items="${items}" var="item">
		<div class="item">
			<a href='<c:url value="/item/${item.id}/index.do"/>'>
				<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}"/>' />
			</a>
			<div>
				<h3><a href='<c:url value="/item/${item.id}/index.do"/>'>${item.title}</a></h3>
				<p>
					<strong>Bid:</strong>
        			<fmt:formatNumber value="${item.currentBid}" type="currency" pattern="$#,##0"/>
				</p>
				<p>
					<span class="timeLeftTab1">${item.closeDate.time}</span>
				</p>
			</div>
			<hr class="clearBoth"/>
		</div>
	</c:forEach>
	<div>
		<span id="linkAll"><a class="tabUrl" class="cssButton" href='<c:url value="/tabs/1/list.do"/>'>view all</a></span>
		<span id="rss">Subscribe to the Feed</span>
	</div>
</body>
</html>
