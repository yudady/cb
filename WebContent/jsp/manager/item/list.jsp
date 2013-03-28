<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>manager|item</title>
<script type="text/javascript">
	$(function() {
		$(".formatShortHtml").formatShortHtml();
	});
</script>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content">
		<div id="crumbs">
			<c:choose>
				<c:when test="${!empty auctionId}">
					<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
					<b> » </b>
					<a href='<c:url value="/manager/auction/list.do" />'>auction list</a>
					<b> » </b>
				</c:when>
				<c:otherwise>
					<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
					<b> » </b>
				</c:otherwise>
			</c:choose>
			item
		</div>
		<div>
			<c:choose>
				<c:when test="${!empty auctionId}">
					<a href='<c:url value="/manager/auctionId/${auctionId}/item/add.do" />'>
						<input type="button" value="add" />
					</a>
				</c:when>
				<c:otherwise>
					<div class="clearBoth">&nbsp;</div>
				</c:otherwise>
			</c:choose>

		</div>
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>title</th>
					<th>update</th>
					<th>delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items.datas}" var="item">
				<tr>
					<td>${item.id}</td>
					<td class="formatShortHtml" >${item.title}</td>
					<c:choose>
						<c:when test="${!empty auctionId}">
							<td><a href='<c:url value="/manager/auctionId/${auctionId}/item/${item.id}/update.do" />'>update</a></td>
							<td><a href='<c:url value="/manager/auctionId/${auctionId}/item/${item.id}/delete.do" />'>delete</a></td>
						</c:when>
						<c:otherwise>
							<td><a href='<c:url value="/manager/item/${item.id}/update.do" />'>update</a></td>
							<td><a href='<c:url value="/manager/item/${item.id}/delete.do" />'>delete</a></td>
						</c:otherwise>
					</c:choose>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<jsp:include page="/jsp/include/pager.jsp">
			<jsp:param value="${items.totalRecord}" name="totalRecord" />
			<jsp:param value="${items.pageSize}" name="pageSize" />
			<jsp:param value="" name="url" />
		</jsp:include>
		
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>