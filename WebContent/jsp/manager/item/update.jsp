<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>manager|item</title>
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

.itemInput {
	margin-left: 10px;
}
#pics img {
	width: 100px;
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
				$("#pics").append(addHtml(this));
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
	$('#pics').on('click','.uploadPicsFile',function(){
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
	    var target = $("#pics");
	    target.append(addHtml({
	    	photoPath : ''
	    }));
	    return false;
	});
	
	$('.cleditor').cleditor();	
});
</script>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content">
		<div id="crumbs">
			<c:choose>
				<c:when test="${!empty auctionId}">
					<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
					<b> » </b>
					<a href='<c:url value="/manager/auction/list.do" />'>auction list</a>
					<b> » </b>
					<a href='<c:url value="/manager/auctionId/${auctionId}/item/list.do" />'>item list</a>
					<b> » </b>
				</c:when>
				<c:otherwise>
					<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
					<b> » </b>
					<a href='<c:url value="/manager/item/list.do" />'>item list</a>
					<b> » </b>
				</c:otherwise>
			</c:choose>
			update
		</div>
		<div>
			<a href='<c:url value="/manager/auctionId/${auctionId}/item/list.do" />'>
				<input type="button" value="item list" />
			</a>
		</div>
		<form id="itemForm" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${item.id}"/><br/>
			<fieldset>
  				<legend>第二級目錄</legend>
				<dl>
					<c:forEach	items="${subCategories}" var="subCategory" >
						<dd><span><label for="subCategoryIds-${subCategory.id}">${subCategory.name}</label><input type="checkbox" id="subCategoryIds-${subCategory.id}" name="subCategoryIds" value="${subCategory.id}" ${subCategory.itemCheckedMark }/></span></dd>
					</c:forEach>
				</dl>
 			</fieldset>
 			<div class="itemInput"><span>商品訊息</span><input type="text" name="title" value="${item.title}" size="100" /></div>
 			<div class="itemInput"><span>當前標價</span><input type="text" name="currentBid" value="${item.currentBid}" /></div>
 			<div class="itemInput"><span>商品 開始日期</span><input class="datepicker" type="text" name="startDate" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.startDate}" />' /></div>
 			<div class="itemInput"><span>商品結束日期</span><input class="datepicker" type="text" name="closeDate" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.closeDate}" />' /></div>
 			<div class="itemInput"><span>估計價值</span><input type="text" name="estimatedValue" value="${item.estimatedValue}" /></div>
 			<div class="itemInput"><span>下次最小標價</span><input type="text" name="incrementPrice" value="${item.incrementPrice}" /></div>
			<c:choose>
				<c:when test="${item.status == 0}">
					<div class="itemInput">
						<span>結標</span><input type="radio" name="status" value="0" checked="checked" />
						<span>拍賣中</span><input type="radio" name="status" value="1" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="itemInput">
						<span>結標</span><input type="radio" name="status" value="0"/>
						<span>拍賣中</span><input type="radio" name="status" value="1" checked="checked "/>
					</div>
				</c:otherwise>
			</c:choose>
			<br/>
			<fieldset>
				<legend>LOTDETAILS訊息</legend>
				<textarea class="cleditor" name="lotDetails" id="lotDetails">${item.lotDetails}</textarea>
			</fieldset>
			
			<fieldset>
				<legend>LOTDETAILS訊息</legend>
				<textarea class="cleditor" name="legalTerms" id="legalTerms">${item.legalTerms}</textarea>
			</fieldset>
			
			<fieldset>
				<legend>SHIPPING訊息</legend>
				<textarea class="cleditor" name="shipping" id="shipping">${item.shipping}</textarea>
			</fieldset>
			<div class="itemInput"><span>當前贏家id</span><input type="text" name="winningBidderId" value="${item.winningBidderId}" /></div>
			<input type="button" id="addPicBtn" value="add pic"/><br/>
			<hr/>
			<ul id="pics"></ul>
			<input type="reset" name="reset" />
			<input type="submit" id="submit" value="update"/>
		</form>
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>