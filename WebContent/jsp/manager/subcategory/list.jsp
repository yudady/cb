<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/jsp/include/header_manager.txt"%>
<%@ include file="/jsp/include/menu_manager.txt"%>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/base_manager.css"/>' />
<script type="text/javascript">
	$(function() {

	});
</script>
<div id="content">
	<div>
		<a href='<c:url value="/manager/subcategory/add.do"/>'><input
			type="button" id="add" value="add"></a>
	</div>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		<c:forEach items="${subCategories}" var="subCategory">
			<tr>
				<td>${subCategory.id}</td>
				<td>${subCategory.name}</td>
				<td><a href='<c:url value="/manager/subcategory/${subCategory.id}/update.do"/>'>update</a></td>
				<td>
				<td>
					<c:if test="${fn:length(subCategory.items) == 0}">
						<a href='<c:url value="/manager/subcategory/${subCategory.id}/delete.do"/>'>delete</a>
					</c:if>				
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="/jsp/include/footer_manager.txt"%>





