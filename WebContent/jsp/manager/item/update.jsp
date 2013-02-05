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
	<input type="hidden" name="itemIdForm" value="${item.id}"/>
	第二級目錄
	<dl>
		<c:forEach	items="${subCategories}" var="subCategory" >
			<dd><span>${subCategory.name}<input type="checkbox" name="subCategoryIds" value="${subCategory.id}" ${subCategory.itemCheckedMark }/></span></dd>
		</c:forEach>
	</dl>
	<p></p>
	<input type="text" name="title" value="${item.title}"/>
	<input type="reset" name="reset" "/>
	<input type="submit" name="submit" "/>
</form>


</div>
<%@ include file="/jsp/include/footer_manager.txt" %>





