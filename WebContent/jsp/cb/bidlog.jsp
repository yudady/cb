<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header.txt" %>
<title>bidlog</title>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/cb/bidlog.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/cb/bidlog.js"/>'></script>
</script>
</head>
<body>
<%@ include file="/jsp/include/bodyTop.txt" %>
<div class="counter"><!-- counter -->
	<div class="clearBoth"></div>
	<div class="counterLeft"><!-- counterLeft start-->
		<%@ include file="/jsp/include/menu.txt" %>
		<div class="clearBoth"></div>
	</div><!-- counterLeft end-->
	<div class="counterRight"><!-- counterRight start-->
		
		<div class="mainRightTop">
			<h1>Bidding History</h1>
			<span>Lot #: ${item.id}</span>&nbsp;&nbsp;&nbsp;
			<span id="returnToItem">
				<a href='<c:url value="/item/${item.id}/index.do" />'>return to item</a>
			</span>
			<p>
				<a href='<c:url value="/item/${item.id}/index.do" />'><h3>${item.title}</h3></a>
			<p>
			In support of <a href='<c:url value="/auctions/${auc.id}/index.do" />'>${auc.title}</a>
	
		</div>
		<div class="mainRightDown">
			<table>
				<thead>
					<tr>
						<th>High Bidder</th>
						<th>Amount</th>
						<th>Time</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${winner.screenName} <i class="icon-star"></i>WINNING</td>
						<c:forEach items="${bidlogs}" var="bidlog" begin="0" end="1">
							<td>${bidlog.price}</td>
							<td>${bidlog.bidTime}</td>
						</c:forEach>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<th>Bidder</th>
						<th>Amount</th>
						<th>Time</th>
					</tr>
				</tbody>
				<tbody>
					<c:forEach items="${bidlogs}" var="bidlog">
						<tr>
							<td>${bidlog.bidderId}</td>
							<td>${bidlog.price}</td>
							<td>${bidlog.bidTime}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div><!-- counterRight end-->
	<div class="clearBoth"></div>
</div><!-- counter -->
<%@ include file="/jsp/include/footer.txt" %>
</body>
</html>