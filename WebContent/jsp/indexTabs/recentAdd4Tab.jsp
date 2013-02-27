<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-1.8.3.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-ui-1.10.0/jquery-ui-1.10.0.custom.min.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/js/jquery/jquery-ui-1.10.0/smoothness/jquery-ui-1.10.0.custom.min.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery.lazyload.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery.log.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/base.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base.css"/>'/>
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
					<strong>Bid:</strong>${item.currentBid}
				</p>
				<p>
					<strong>Time Left:</strong>${item.closeDate}
				</p>
			</div>
			<hr />
		</div>
	</c:forEach>
	<div>
	<span id="linkAll"><a class="tabUrl" class="cssButton" href='<c:url value="/items/4/index.do"/>'>view all</a></span>
	<span id="rss">Subscribe to the Feed</span>
	</div>
</body>
</html>
