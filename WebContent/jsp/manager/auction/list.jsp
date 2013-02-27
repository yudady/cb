<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/jsp/include/header_manager.txt"%>
<%@ include file="/jsp/include/menu_manager.txt"%>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base_manager.css"/>' />
<style>
table {
    border-top: 1px solid black;
    border-left: 1px solid black;
}
th, td {
    border-right: 1px solid black;
    border-bottom: 1px solid black;
}
</style>
<script type="text/javascript">
	$(function() {

	});
</script>
<div id="content">
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
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${auctions}" var="auction">
			<tr>
				<td>${auction.id}</td>
				<td>${auction.title}</td>
				<td>${auction.brief}</td>
				<td>${auction.webSite}</td>
				<td>${auction.auctionLogoPath}</td>
				<td>${auction.startDate}</td>
				<td>${auction.closeDate}</td>
				<td><a href='<c:url value="/manager/auction/${auction.id}/update.do"/>'>update</a></td>
				<td><a href='<c:url value="/manager/auction/${auction.id}/delete.do"/>'>delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="/jsp/include/footer_manager.txt"%>
