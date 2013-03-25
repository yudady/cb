<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>index</title>
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
	width: 200px;
	display: block;
	float: left;
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
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
<div id="content">
<form id="itemForm" method="post" enctype="multipart/form-data">
	<input type="hidden" name="itemIdForm" value="${item.id}"/>
	第二級目錄
	<dl>
		<c:forEach	items="${subCategories}" var="subCategory" >
			<dd><span><label for="subCategoryIds-${subCategory.id}">${subCategory.name}</label><input type="checkbox" id="subCategoryIds-${subCategory.id}" name="subCategoryIds" value="${subCategory.id}" /></span></dd>
		</c:forEach>
	</dl>
	<p></p>
	<ul>
		<li>商品訊息<input type="text" name="title" /></li>
		<li>當前標價<input type="text" name="currentBid" /></li>
		<li>估計價值<input type="text" name="estimatedValue" /></li>
		<li>下次最小標價<input type="text" name="incrementPrice" /></li>
		<li>LOTDETAILS訊息
			<textarea class="cleditor" name="lotDetails" id="lotDetails"></textarea>
		</li>
		<li>LOTDETAILS訊息
			<textarea class="cleditor" name="legalTerms" id="legalTerms"></textarea>
		</li>
		<li>SHIPPING訊息
			<textarea class="cleditor" name="shipping" id="shipping"></textarea>
		</li>
		<li><input type="button" id="addPicBtn" value="add pic"/></li>
	</ul>
	<input type="reset" name="reset" value="reset"/>
	<input type="submit" name="submit" value="add"/>
</form>
</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>