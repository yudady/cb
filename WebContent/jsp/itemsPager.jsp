<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header.txt" %>
<style type="text/css">
.counter {
	
}

.counterLeft {
	width: 220px;
	float: left;
	background-color: red;
}

.counterRight {
	margin-left:10px;
	width: 730px;
	float: left;
	background-color: blue;
}

.itemList {
	padding: 30px;
	margin-bottom: 20px;
	background-color: white;
}

.auction {
	padding: 30px;
	padding-bottom: 0px;
	background-color: white;
}

.auctionPic {
	float: left;
	width: 250px;
}

.auctionPic img {
	width: 250px;
	height: 200px;
}

.auctionDetail {
	width: 350px;
	height: 230px;
	margin-left: 300px;
}

.item {
	height: 200px;
	padding: 30px;
	margin-bottom: 20px;
	background-color: white;
}

.pic {
	float: left;
	width: 250px;
	height: 200px;
}

.pic img {
	width: 250px;
	height: 200px;
}

.detail {
	float: right;
	width: 360px;
	height: 160px;
	padding: 20px;
}

.detail a {
	font-size: 18px;
	color: red;
}
/**
* bid now
*/
.detail a.cssButton {
	float: right;
	font-size: 24px;
	color: white;
}

#crumbs {
	font-size: 18px;
}

#pager {
	clear: right;
	text-align: center;
}

.lotClosed {
	background-color: #C52200;
	color: #FFFFFF;
	font-size: 1.2em;
	font-weight: bold;
	line-height: 1.3em;
	padding: 0.4em 0.5em;
}
</style>
<script type="text/javascript">
$(function(){
	var loc = window.location.href ;
	
	if(loc.search("displayClosed") > 0){
		$("#ftr-displayClosed").prop("checked",true);
		$('.bidNow').hide();
	}else{
		$('.lotClosed').hide();
		$("#ftr-displayClosed").prop("checked",false);
	}
	
	 //action="displayClosed.do"
	$("#ftr-displayClosed").on('click',function(event){
		var src = window.location.href  ;
		src = src.replace("?displayClosed=true","");
		var _this = $(this);
		if(_this.prop("checked")){
			window.location.href = src + "?displayClosed=true";
		}else{
			window.location.href = src + "";
		}
		event.preventDefault();
		event.stopPropagation();
	});
});
</script>
<div class="counter"><!-- counter start-->
<div class="counterLeft"><%@ include file="/jsp/include/menu.txt" %></div>
<div class="counterRight">
<div class="auction">
<c:choose>
	<c:when test="${!empty auctionId}">
		<a href='<c:url value="/auctionId/${auctionId}/item/${item.id}/index.do" />'>
			<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
		</a>
	</c:when>
	<c:when test="${!empty subcategoryId}">
		<a href='<c:url value="/" />'><i class="icon-home"></i></a>
		<b> » </b>
		<a href='<c:url value="/categories/${categoryId}/${categoryName}/index.do" />'>${categoryName}</a>
		<b> » </b>
		${subCategoryName}
	</c:when>
	<c:when test="${!empty categoryId}">
		<a href='<c:url value="/" />'><i class="icon-home"></i></a>
		<b> » </b>
		${categoryName}
	</c:when>
</c:choose>
</div>
<div class="itemList">
	<jsp:include page="/jsp/include/pager.jsp">
		<jsp:param value="${pager.totalRecord}" name="totalRecord" />
		<jsp:param value="${pager.pageSize}" name="pageSize" />
		<jsp:param value="" name="url" />
	</jsp:include>
</div>

<c:forEach items="${pager.datas}" var="item">
	<div class="item">
		<span class="pic">
			<div class="lotClosed">This item is now closed</div>
			<c:choose>
				<c:when test="${!empty auctionId}">
					<a href='<c:url value="/auctionId/${auctionId}/item/${item.id}/index.do" />'>
						<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
					</a>
				</c:when>
				<c:when test="${!empty subcategoryId}">
					<a href='<c:url value="/categories/${categoryId}/${categoryName}/subcategories/${subcategoryId}/${subCategoryName}/item/${item.id}/index.do" />'>
						<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
					</a>
				</c:when>
				<c:when test="${!empty categoryId}">
					<a href='<c:url value="/categories/${categoryId}/${categoryName}/item/${item.id}/index.do" />'>
						<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
					</a>
				</c:when>
			</c:choose>
		</span> 
		<span class="detail"> 
			<a href='<c:url value="/item/${item.id}/index.do" />'>${item.title}</a>
			<table>
				<tr>
					<th>Current Bid:</th>
					<td>${item.currentBid}</td>
				</tr>
				<tr>
					<th>Number of Bids:</th>
					<td>${item.bidTimes}</td>
				</tr>
				<tr>
					<th>Minimum Next Bid:</th>
					<td>${item.incrementPrice}</td>
				</tr>
				<tr>
					<th>Estimated Value:</th>
					<td>${item.estimatedValue}</td>
				</tr>
				<tr>
					<th>Lot Number:</th>
					<td>${item.id}</td>
				</tr>
				<tr>
					<th>Lot Closes:</th>
					<td>${item.closeDate}</td>
				</tr>
			</table>
			<a class="cssButton bidNow" href="<c:url value="/item/${item.id}/index.do" />">Bid NOW</a>
		</span>
	</div>
</c:forEach>


	<div class="itemList">
		<form id="displayClosed"  action="">
			Showing <strong>1</strong> item
			<input id="ftr-displayClosed" type="checkbox" name="closed" /> 
			<label for="ftr-displayClosed">Display closed items only</label>
		</form>
	</div>

</div>
<div class="clearBoth"></div>
</div><!-- counter end-->
<%@ include file="/jsp/include/footer.txt" %>