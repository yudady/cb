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
<style type="text/css">
#content dl {
	color: green;
	height: 30px;
	line-height: 30px;
	text-align: left;
}

#content dl dd {
	display: inline;
	overflow: auto;
}

#content dl dd span {
	display: block;
	float: left;
	width: 200px;
}
#content p {
clear: both;
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
<div id="content">
<form method="post">
	<input type="hidden" name="subCaId" value="${subCategory.id}"/>
	第一級目錄
	<dl>
		<c:forEach	items="${categories}" var="category" >
			<c:choose>
				<c:when test="${category.id == subCategory.categoryId}">
					<dd><span>${category.name}<input type="radio" name="categoryId" value="${category.id}" checked="checked" /></span></dd>
				</c:when>
				<c:otherwise>
					<dd><span>${category.name}<input type="radio" name="categoryId" value="${category.id}" /></span></dd>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</dl>
	<p></p>
	第二級目錄<input type="text" name="name" value="${subCategory.name}" /><br/>
	description<input type="text" name="descript" value="${subCategory.descript}" /><br/>
	<input type="reset" name="reset" "/>
	<input type="submit" name="submit" "/>
</form>
</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>