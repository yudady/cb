<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>  
<%@ include file="/jsp/include/header_manager.txt" %>
<%@ include file="/jsp/include/menu_manager.txt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.charitybuzz.dto.*" %>

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
		var picCount = 0;
		function addPic(index,priority,crud,picId,src) {
			picId = picId || '';
			var html = "";
				html = html + '<li class="picture">';
				html = html + '<div>';
				html = html + '<span>Picture ' + index + ' : </span>';
				html = html + '<input type="hidden" name="picIds['+index+']" value="'+picId+'" />';
				html = html + '<input type="button" class="deleteBtn" value="delete" />';
				html = html + '<input type="hidden" name="cruds['+index+']" value="'+crud+'" />';
				html = html + '<input type="text" name="priorities['+index+']" value="'+priority+'" />';
				html = html + '<input type="file" name="files['+index+']" />';
				if(src){
					html = html + '<img src='+src+' />';
				}
				html = html + '<div>';
				html = html + '</li>';
			$("#content ul").append(html);
			picCount = picCount + 1 ;
		}
		
		
		
		
		$('.cleditor').cleditor({
			width:        700, // width not including margins, borders or padding
	        height:       150 // height not including margins, borders or padding});
		});
	

	
		<%
			Item item = (Item)request.getAttribute("item");
			List<Picture> pictures = item.getPictures();
			for(int i = 0 ;i < pictures.size() ; i ++){
		%>
				picCount = <%= i %> ;
				addPic(picCount , <%= pictures.get(i).getPriority() %> ,'r',<%= pictures.get(i).getId() %> ,'<c:url value="/pic/upload/item/"/><%=pictures.get(i).getPhotoPath()%>');
		<%
			}	
					
		%>
		
		
		
		$(".picture input[type='file']").on('change',function(){
			$(this).next().remove();
			var crudInput = $(this).prev().prev();
			if(crudInput.val() == 'r'){
				crudInput.val('u');
			}
		});
		$("#addPicBtn").on('click',function(){
			addPic(picCount,picCount,'c');
		});
		$(".deleteBtn").live('click',function(){
			$(this).parent().parent().hide();
			var crudInput = $(this).next();
			if(crudInput.val() == 'r'){
				crudInput.val('d');
			}else if(crudInput.val() == 'u'){
				crudInput.val('d');
			}else if(crudInput.val() == 'c'){
				$(this).parent().parent().remove();
			}
		});
	});
	
	


</script>
<div id="content">
<form method="post" enctype="multipart/form-data">
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
		<li><input type="button" id="addPicBtn" value="add pic"/></li>
	</ul>
	<hr/>
	
	<input type="reset" name="reset" />
	<input type="submit" name="submit" value="update"/>
</form>
<p />
</div>
<%@ include file="/jsp/include/footer_manager.txt" %>





