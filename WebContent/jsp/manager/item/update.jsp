<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  
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


#content li.picture {
	clear:both;
	height: 100px;
}
#content li.picture div{
	line-height:75px;
	height: 75px;
	margin-top: 5px;
	margin-bottom: 5px;
}
#content li.picture div span{
}
#content li.picture div input{
}
#content li.picture div img {
	width: 100px;
	height: 75px;
}

#content p {
clear: both;
}
</style>
<script type="text/javascript">
$(function() {

    function addHtml(obj){
        var uploadPicsSize = $(".uploadPics").size() ;
        var imgSrc = cb.getSafeUrl() + '/pic/upload/item/' + obj.photoPath;
        var picId = obj.id || "";
        var html = '<li class="uploadPics">' ;
        html = html + '<span>Picture ' + uploadPicsSize + ' : </span>';
        html = html + '<input class="deleteBtn" type="button" value="delete" />' ; 
        html = html + '<input type="hidden" value="'+picId+'" name="picIds[' + uploadPicsSize + ']">' ; 
        html = html + '<span>order<input class="indexPriorities" type="text" name="priorities[' + uploadPicsSize + ']" value="' + uploadPicsSize + '" size="3" /></span>' ; 
        if(obj.photoPath != ''){
        	html = html + '<input type="hidden" name="oldPhotoPath[' + uploadPicsSize + ']" value="'+obj.photoPath+'" />' ; 
        	html = html + '<img src="'+imgSrc+'" />' ; 
        	html = html + '<input class="crud" type="hidden" value="r" name="cruds[' + uploadPicsSize + ']" />' ; 
        }else {
        	html = html + '<input type="hidden" name="oldPhotoPath[' + uploadPicsSize + ']" value="" />' ; 
        	html = html + '<img src="" />' ; 
        	html = html + '<input class="crud" type="hidden" value="c" name="cruds[' + uploadPicsSize + ']" />' ; 
        }
        html = html + '<input class="uploadPicsFile" type="file" name="files['+uploadPicsSize+']" /> ' ; 
        html = html + '</li>'; 

        return html;
    }
	$.ajax({
		type : "POST",
		url : cb.getSafeUrl('manager/pictures.do'),
		data : {itemId:'${itemId}'}, 
		dataType: "json",
		success : function(data) {
			$.each(data,function(){
				$("#addPicBtn").parent().append(addHtml(this));
			});
		}
	});
	
	
$('#itemForm').on('click','.deleteBtn',function(){
	var li = $(this).parent();
	var crudInput = li.find('.crud') ;
	var val = crudInput.val();
	if(val == 'r' || val == 'u'){
		crudInput.val('d');
	}
	if(val == 'c'){
		crudInput.val('');
	}
	li.hide();
});
$('#itemForm').on('click','.uploadPicsFile',function(){
	var li = $(this).parent();
	var crudInput = li.find('.crud') ;
	var val = crudInput.val();
	if(val == 'r'){
		crudInput.val('u');
	}
	var img = li.find('img') ;
	img.attr('src','');
});
$("#addPicBtn").on('click',function(){
    var target = $(this).parent();
    target.append(addHtml({
    	photoPath : ''
    }));
    return false;
});



$('.cleditor').cleditor({
	width:        700, // width not including margins, borders or padding
	height:       150 // height not including margins, borders or padding});
});	

});
</script>
<div id="content">
<form id="itemForm" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${item.id}"/>
	<p>第二級目錄</p>
	<dl>
		<c:forEach	items="${subCategories}" var="subCategory" >
			<dd><span><label for="subCategoryIds-${subCategory.id}">${subCategory.name}</label><input type="checkbox" id="subCategoryIds-${subCategory.id}" name="subCategoryIds" value="${subCategory.id}" ${subCategory.itemCheckedMark }/></span></dd>
		</c:forEach>
	</dl>
	<p></p>
	<ul>
		<li>商品訊息<input type="text" name="title" value="${item.title}"/></li>
		<li>當前標價<input type="text" name="currentBid" value="${item.currentBid}"/></li>
		<li>商品 開始日期<input class="datepicker" type="text" name="startDate" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${auction.startDate}" />' /></li>
		<li>商品結束日期<input class="datepicker" type="text" name="closeDate" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${auction.closeDate}" />' /></li>
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
		<li><input type="button" id="addPicBtn" value="add pic"/></li>
	</ul>
	<hr/>
	
	<input type="reset" name="reset" />
	<input type="submit" name="submit" value="update"/>
</form>
<p />
</div>
<%@ include file="/jsp/include/footer_manager.txt" %>





