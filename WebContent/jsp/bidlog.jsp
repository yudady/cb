<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header.txt" %>
<style type="text/css">

.counter {
	padding: 10px;
	background-color: white;
}
.mainRightTop {
	margin-left:210px;
	padding:20px;
	margin-bottom:10px;
	background-color: red;
}
.mainRightDown {
	margin-left:210px;
	background-color: green;
}
#returnToItem {
	float: right;
	cursor: pointer;
}
</style>
<script type="text/javascript">
$(function(){
	$("#returnToItem").on('click',function(){
		var loc = window.location.href ;
		loc = loc.replace("/bidlog.do","/index.do");
		window.location.href = loc;
	});
	
});
</script>
<div class="counter"><!-- counter -->
<%@ include file="/jsp/include/menu.txt" %>
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
<div class="clearBoth"></div>
</div><!-- counter -->
<%@ include file="/jsp/include/footer.txt" %>