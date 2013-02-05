<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/jsp/include/header_manager.txt"%>
<%@ include file="/jsp/include/menu_manager.txt"%>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base_manager.css"/>' />
<script type="text/javascript">
	$(function() {

	});
</script>
<div id="content">
	<div>
		<a href='<c:url value="/manager/item/add.do"/>'><input
			type="button" id="add" value="add"></a>
	</div>
	<table>
		<tr>
			<th>id</th>
			<th>title</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.title}</td>
				<td><a href='<c:url value="/manager/item/${item.id}/update.do"/>'>update</a></td>
				<td><a href='<c:url value="/manager/item/${item.id}/delete.do"/>'>delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="/jsp/include/footer_manager.txt"%>





