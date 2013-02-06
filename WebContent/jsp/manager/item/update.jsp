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
	<ul>
		<li>商品訊息<input type="text" name="title" value="${item.title}"/></li>
		<li>當前標價<input type="text" name="currentBid" value="${item.currentBid}"/></li>
		<li>商品 開始日期<input type="text" name="startDate" value="${item.startDate}"/></li>
		<li>商品結束日期<input type="text" name="closeDate" value="${item.closeDate}"/></li>
		<li>估計價值<input type="text" name="estimatedValue" value="${item.estimatedValue}"/></li>
		<li>下次最小標價<input type="text" name="incrementPrice" value="${item.incrementPrice}"/></li>
		<li>0.結標 1.拍賣中<input type="text" name="status" value="${item.incrementPrice}"/></li>
		<li>LOTDETAILS訊息<input type="text" name="lotDetails" value="${item.lotDetails}"/></li>
		<li>LOTDETAILS訊息<input type="text" name="legalTerms" value="${item.legalTerms}"/></li>
		<li>SHIPPING訊息<input type="text" name="shipping" value="${item.shipping}"/></li>
		<li>當前贏家id<input type="text" name="winningBidderId" value="${item.winningBidderId}"/></li>
		<li></li>
		<li></li>
	</ul>
	
	<input type="reset" name="reset" "/>
	<input type="submit" name="submit" "/>
	
<hr/>	
<script type="text/javascript" src='<c:url value="/js//jquery/jwysiwyg/jquery.wysiwyg.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/js/jquery/jwysiwyg/jquery.wysiwyg.css"/>'/>

    <script type="text/javascript">
      $(document).ready(function() {
    	  $('#wysiwyg').wysiwyg();
      });
    </script>
    <textarea name="wysiwyg" id="wysiwyg" rows="5" cols="47"></textarea>
	
	
	
	
	
</form>
</div>
<%@ include file="/jsp/include/footer_manager.txt" %>





