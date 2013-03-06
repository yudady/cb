<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header.txt" %>
<style type="text/css">
.counter {
	padding: 10px;
	
}
.itemList {
	width: 680px;
	padding: 30px; 
	margin-left: 220px;
	margin-bottom : 20px;
	background-color: white;
}
.auction {
	width: 680px;
	padding: 30px; 
	padding-bottom:0px;
	margin-left: 220px;
	background-color: white;
}
.auctionPic {
	float:left;
	width: 250px;
}
.auctionPic img{
	width: 250px;
	height: 200px;
}
.auctionDetail{
	width: 350px;
	height: 230px;
	margin-left:300px;
}

.item {
	width: 680px;
	height: 200px;
	padding: 30px; 
	margin-left: 220px;
	margin-bottom : 20px;
	background-color: white;
}
.pic {
	float:left;
	width: 250px;
	height: 200px;
}
.pic img{
	width: 250px;
	height: 200px;
}
.detail {
	float:right;
	width: 360px;
	height: 160px;
	padding:20px;
}
.detail a {
	font-size: 18px;
	color:red;
}
#crumbs {
	font-size:18px;
}
#pager {
	clear:right;
	text-align: center;
}
</style>
<script type="text/javascript">
$(function(){
	var loc = window.location.href ;
	//$.log(loc);
	//$.log(loc.search("displayClosed"));
	
	
	
	if(loc.search("displayClosed") > 0){
		$("#ftr-displayClosed").prop("checked",true);
	}else{
		$("#ftr-displayClosed").prop("checked",false);
	}
	
	 //action="displayClosed.do"
	$("#ftr-displayClosed").on('click',function(event){
		var src = window.location.href  ;
		src = src.substr(0,src.lastIndexOf("/"));
		var _this = $(this);
		if(_this.prop("checked")){
			window.location.href = src + "/index.do?displayClosed=true";
		}else{
			window.location.href = src + "/index.do";
		}
		event.preventDefault();
		event.stopPropagation();
	});
});
</script>
<div class="counter"><!-- counter -->
<%@ include file="/jsp/include/menu.txt" %>
<div class="auction">
<c:choose>
	<c:when test="${!empty auction}">
		<div>
			<div id="crumbs">
				<a href='<c:url value="/" />'><i class="icon-home"></i></a><b> » </b>${auction.title}
			</div>
			<div class="auctionPic"><img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}" />'></div>
			<div class="auctionDetail">
				<div>${auction.brief}</div>
				<div>&nbsp;</div>
				<div>${auction.webSite}</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div id="crumbs">
			<a href='<c:url value="/" />'><i class="icon-home"></i></a>
			<script type="text/javascript">
			$(function(){
				
				var loc = window.location.href;
				//$.log(loc);
				var path = loc.split("/");
				//$.log(path);
				$.each(path,function(i,v){
					if(path[i] == 'categories'){
						var a = $('<a>'+path[i]+'</a>').attr('href',cb.getSafeUrl('categories/'+path[i+1]+'/index.do')) ;
						$("#crumbs").append('<b> » </b>').append(a);
					}
					if(path[i] == 'subcategories'){
						var pa = decodeURIComponent(path[i+2]);
						var len = pa.search('.do');
						pa = pa.substr(0,len);
						$("#crumbs").append('<b> » </b>').append(pa);
					}
					if(path[i] == 'items'){
						$("#crumbs").append('<b> » </b>').append('Active Lots');
					}
				});
			});
			</script>
		</div>
	</c:otherwise>
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
			<a href='<c:url value="/item/${item.id}/index.do" />'>
				<img src='<c:url value="/pic/upload/item/${item.mainPicturePath}" />' />
			</a>
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
			</table> <a href="#"><span>Bid now</span></a>
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
</div><!-- counter -->
<%@ include file="/jsp/include/footer.txt" %>