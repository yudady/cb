<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>operator</title>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
<div id="content">
	<div>
		<a href='<c:url value="/manager/operator/add.do"/>'><input
			type="button" id="add" value="add"></a>
	</div>
	<table>
		<tr>
			<th>id</th>
			<th>公司名稱</th>
			<th>密碼</th>
			<th>update</th>
			<th>delete</th>
		</tr>
		<c:forEach items="${operators}" var="operator">
			<tr>
				<td>${operator.id}</td>
				<td>${operator.name}</td>
				<td>${operator.passWord}</td>
				<td><a
					href='<c:url value="/manager/operator/${operator.id}/update.do"/>'>update</a></td>
				<td>
				<td><a href='<c:url value="/manager/operator/${operator.id}/delete.do"/>'>delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>