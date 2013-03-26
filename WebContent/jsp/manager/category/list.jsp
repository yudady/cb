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
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content">
		<div id="crumbs">
			<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
			<b> » </b>
			category
		</div>
		<div>
			<a href='<c:url value="/manager/category/add.do"/>'>
				<input type="button" id="add" value="add" />
			</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>update</th>
					<th>delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categories.datas}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>
						<a href='<c:url value="/manager/category/${category.id}/update.do"/>'>update</a>
					</td>
					<td>
						<c:if test="${fn:length(category.subCategories) == 0}">
							<a href='<c:url value="/manager/category/${category.id}/delete.do"/>'>delete</a>
						</c:if>				
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="/jsp/include/pager.jsp">
			<jsp:param value="${categories.totalRecord}" name="totalRecord" />
			<jsp:param value="${categories.pageSize}" name="pageSize" />
			<jsp:param value="" name="url" />
		</jsp:include>
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>