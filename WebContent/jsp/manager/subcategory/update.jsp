<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header_manager.txt" %>
<%@ include file="/jsp/include/menu_manager.txt" %>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base_manager.css"/>'/>
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
	第二級目錄名稱<input type="text" name="name" value="${subCategory.name}" /><br/>
	description<input type="text" name="descript" value="${subCategory.descript}" /><br/>
	<input type="reset" name="reset" "/>
	<input type="submit" name="submit" "/>
</form>
</div>
<%@ include file="/jsp/include/footer_manager.txt" %>





