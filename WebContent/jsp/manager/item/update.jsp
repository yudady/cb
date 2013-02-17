<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header_manager.txt" %>
<%@ include file="/jsp/include/menu_manager.txt" %>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base_manager.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/jquery/CLEditor1_3_0/jquery.cleditor.min.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/js/jquery/CLEditor1_3_0/jquery.cleditor.css"/>'/>
<style type="text/css">
#content dl {
	color: green;
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

<script type="text/javascript">
	$(document).ready(function() {
		$('.cleditor').cleditor({
			width:        700, // width not including margins, borders or padding
	        height:       150 // height not including margins, borders or padding});
		});
	});
</script>
<div id="content">
<form method="post">
	<input type="hidden" name="itemIdForm" value="${item.id}"/>
	第二級目錄
	<dl>
		<c:forEach	items="${subCategories}" var="subCategory" >
			<dd><span><label for="subCategoryIds-${subCategory.id}">${subCategory.name}</label><input type="checkbox" id="subCategoryIds-${subCategory.id}" name="subCategoryIds" value="${subCategory.id}" ${subCategory.itemCheckedMark }/></span></dd>
		</c:forEach>
	</dl>
	<p></p>
	<ul>
		<li>商品訊息<input type="text" name="title" value="${item.title}"/></li>
		<li>當前標價<input type="text" name="currentBid" value="${item.currentBid}"/></li>
		<li>商品 開始日期<input class="datepicker" type="text" name="startDate" value="${item.startDate}"/></li>
		<li>商品結束日期<input class="datepicker" type="text" name="closeDate" value="${item.closeDate}"/></li>
		<li>估計價值<input type="text" name="estimatedValue" value="${item.estimatedValue}"/></li>
		<li>下次最小標價<input type="text" name="incrementPrice" value="${item.incrementPrice}"/></li>
		<li>0.結標 1.拍賣中<input type="text" name="status" value="${item.status}"/></li>
		<li>LOTDETAILS訊息
			<textarea class="cleditor" name="lotDetails" id="lotDetails">${item.lotDetails}</textarea>
		</li>
		<li>LOTDETAILS訊息
			<textarea class="cleditor" name="legalTerms" id="legalTerms">${item.legalTerms}</textarea>
		</li>
		<li>SHIPPING訊息
			<textarea class="cleditor" name="shipping" id="shipping">${item.shipping}</textarea>
		</li>
		<li>當前贏家id<input type="text" name="winningBidderId" value="${item.winningBidderId}"/></li>
		<li></li>
		<li></li>
	</ul>
	<input type="reset" name="reset" "/>
	<input type="submit" name="submit" "/>
</form>
</div>
<%@ include file="/jsp/include/footer_manager.txt" %>





