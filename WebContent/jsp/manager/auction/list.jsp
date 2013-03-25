<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>category</title>
<style type="text/css">
table {
	width:100%;
    border-top: 1px solid black;
    border-left: 1px solid black;
}
th, td {
    border-right: 1px solid black;
    border-bottom: 1px solid black;
}
#content img {
	vertical-align:text-top;
    width: 50px;
    height: 50px;
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content"><!-- content -->
		<div>
			<a href='<c:url value="/manager/auction/add.do"/>'>
				<input type="button" id="add" value="add">
			</a>
		</div>
		<table>
			<tr>
				<th>id</th>
				<th>主題</th>
				<th>描述</th>
				<th>網址</th>
				<th>logo</th>
				<th>拍賣會 開始日期 startDate</th>
				<th>拍賣會 結束日期 closeDate</th>
				<th>商品</th>
				<th></th>
				<th></th>
			</tr>
			<c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set>
			<c:forEach items="${auctions}" var="auction">
				<tr>
					<td>${auction.id}</td>
					<td>${auction.title}</td>
					<td>${auction.brief}</td>
					<td>${auction.webSite}</td>
					<td><img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' /></td>
					<td><fmt:formatDate value="${auction.startDate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
					<td><fmt:formatDate value="${auction.closeDate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
					<c:choose>
						<c:when test="${auction.closeDate.time < nowDate}">
							<td><a href='<c:url value="/manager/auctionId/${auction.id}/item/list.do" />'>拍賣會結束Item List</a></td>
							<td>拍賣會結束</td>
							<td>拍賣會結束</td>
						</c:when>
						<c:when test="${auction.startDate.time > nowDate}">
							<td><a href='<c:url value="/manager/auctionId/${auction.id}/item/list.do" />'>拍賣會尚未開始Item List</a></td>
							<td><a href='<c:url value="/manager/auction/${auction.id}/update.do"/>'>拍賣會尚未開始update</a></td>
							<td><a href='<c:url value="/manager/auction/${auction.id}/delete.do"/>'>拍賣會尚未開始delete</a></td>
						</c:when>
						<c:otherwise>
							<td><a href='<c:url value="/manager/auctionId/${auction.id}/item/list.do" />'>拍賣中Item List</a></td>
							<td><a href='<c:url value="/manager/auction/${auction.id}/update.do"/>'>拍賣中update</a></td>
							<td>拍賣中</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div><!-- content -->
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>