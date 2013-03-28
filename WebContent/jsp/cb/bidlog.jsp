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
		<div class="clearBoth">&nbsp;</div>
		<div class="mainRightTop">
			<h1>Bidding History</h1>
			<span>Lot #: 3307149</span>&nbsp;&nbsp;&nbsp;<span id="returnToItem">return to item</span>
			<p>
			55th GRAMMY® Awards Bronze Ticket Experience for Two on February 10 in Los Angeles
			<p>
			In support of The Actors Fund
	
		</div>
		<div class="mainRightDown">
			<table>
				<thead>
					<tr>
						<th>High Bidder</th>
						<th></th>
						<th>Amount</th>
						<th>Time</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>courtney.manlove</td>
						<td>WINNING</td>
						<td>$4,750</td>
						<td>Mon, 21 Jan 2013 11:30:14 PM EST</td>
					</tr>
				</tbody>
			</table>
			<table border="1">
				<thead>
					<tr>
						<th>Bidder</th>
						<th></th>
						<th>Amount</th>
						<th>Time</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bidlogs}" var="bidlog">
						<tr>
							<td>${bidlog.bidderId}</td>
							<td></td>
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