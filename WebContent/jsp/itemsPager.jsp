<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header.txt" %>
<%@ include file="/jsp/include/menu.txt" %>
<style type="text/css">

.item {
	width: 680px;
	height: 200px;
	float: right;
	padding: 30px; 
	margin-bottom : 20px;
	background-color: #CCC;
}
.pic {
	float:left;
	width: 250px;
	height: 200px;
}
.pic img{
	width: 250px;
	height: 200px;
}
.detail {
	float:right;
	width: 360px;
	height: 160px;
	padding:20px;
}
.detail a {
	font-size: 18px;
	color:red;
}
</style>
<div class="item">
	<jsp:include page="/jsp/include/pager.jsp">
		<jsp:param value="${pager.totalRecord}" name="totalRecord" />
		<jsp:param value="${pager.pageSize}" name="pageSize" />
		<jsp:param value="" name="url" />
	</jsp:include>
</div>
<c:forEach items="${pager.datas}" var="item">
	<div class="item">
		<span class="pic"> 
			<a href='<c:url value="/item/${item.id}/index.do" />'>
				<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
			</a>
		</span> 
		<span class="detail"> 
			<a href='<c:url value="/item/${item.id}/index.do" />'>${item.title}</a>
			<table>
				<tr>
					<th>Current Bid:</th>
					<td>${item.currentBid}</td>
				</tr>
				<tr>
					<th>Number of Bids:</th>
					<td>${item.bidTimes}</td>
				</tr>
				<tr>
					<th>Minimum Next Bid:</th>
					<td>${item.incrementPrice}</td>
				</tr>
				<tr>
					<th>Estimated Value:</th>
					<td>${item.estimatedValue}</td>
				</tr>
				<tr>
					<th>Lot Number:</th>
					<td>${item.id}</td>
				</tr>
				<tr>
					<th>Lot Closes:</th>
					<td>${item.closeDate}</td>
				</tr>
			</table> <a href="#"><span>Bid now</span></a>
		</span>
	</div>
</c:forEach>
<%@ include file="/jsp/include/footer.txt" %>