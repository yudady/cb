<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>index</title>
</head>
<body>
<%@ include file="/jsp/include/logo_manager.txt" %>
<c:choose>
	<c:when test="${empty operator}">
		<link type="text/css" rel="stylesheet" href='<c:url value="/css/manager.css"/>'/>
	</c:when>
	<c:otherwise>
		<%@ include file="/jsp/include/menu_manager.txt" %>
		<link type="text/css" rel="stylesheet" href='<c:url value="/css/base_manager.css"/>'/>
	</c:otherwise>
</c:choose>
<div id="content">
<c:choose>
	<c:when test="${empty operator}">
		<form method='post'>
			<table>
				<tr>
					<td>name:</td>
					<td><input type='text' name='name'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='passWord' name='passWord' /></td>
				</tr>
				<tr>
					<td><input name="reset" type="reset" value="reset"/></td>
					<td><input name="submit" type="submit" value="login" /></td>
				</tr>
			</table>
		</form>
	</c:when>
	<c:otherwise>
login ok 
	</c:otherwise>
</c:choose>

</div>
<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>




