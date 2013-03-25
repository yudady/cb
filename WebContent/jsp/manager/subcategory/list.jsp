<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>subcategory</title>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content">
		<div>
			<a href='<c:url value="/manager/subcategory/add.do"/>'>
				<input type="button" id="add" value="add">
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
				<c:forEach items="${subCategories}" var="subCategory">
				<tr>
					<td>${subCategory.id}</td>
					<td>${subCategory.name}</td>
					<td><a href='<c:url value="/manager/subcategory/${subCategory.id}/update.do"/>'>update</a></td>
					<td>
						<c:if test="${fn:length(subCategory.items) == 0}">
							<a href='<c:url value="/manager/subcategory/${subCategory.id}/delete.do"/>'>delete</a>
						</c:if>				
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>