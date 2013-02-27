<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/jsp/include/header.txt" %>
<style type="text/css">
.content {
	width: 760px;
	margin-bottom: 20px;
	position:relative;
	left: 210px;
	margin-right:5px;
}
#contenta {
	width: 750px;
	float: right;
	margin-bottom: 20px;
}
#fragment-1 {
}

.fragment-1-right {
	float: right;
}

.fragment-1-left {
	
}

.auction {
	border:#0000FF 1px dotted; 
	position: relative; 
	padding-top : 20px;
	width: 340px;
	height: 170px;
	margin: 2px;
	padding-top: 20px;
}

.auction h4 {
	font-size: 16px;
	margin-bottom: 10px;
}

.auction h6 {
	font-size: 14px;
	margin-bottom: 10px;
}

.auctionDetails a span {
	color: #B5121B;
}

.auctionDetails a:hover span {
	color: #F00;
}

.auction img {
	width: 150px;
	height: 150px;
	padding-left: 20px;
}

.auctionDetails {
	width: 150px;
	position: absolute;
	top: 20px;
	left: 180px;
	white-space: normal;
	word-break: break-all;
}



.down {
	height: 500px;
}

.downLeft {
	width: 400px;
	float: left;
}

.downRight {
	float: left;
}
dl.topItem {
}

dl.topItem dd{
	color: red;
	
}


</style>
<script type="text/javascript">
$(function(){
	$("#auctionLists").tabs();
	
	$('#tabs4').tabs({
	    load: function(event, ui) {
	        $(ui.panel).on('click', 'a', function(event) {
	            $(ui.panel).load(this.href);
	            event.preventDefault();
	        });
	    }
	});
	
	
	
});
</script>
<div class="counter"><!-- counter -->
<%@ include file="/jsp/include/menu.txt" %>
<div id="contenta">
	<div class="top">
		<div id="auctionLists">
		     <ul>
		         <li><a href='#fragment-1'><span>Current Auctions</span></a></li>
		         <li><a href='#fragment-2'><span>Upcoming Auctions</span></a></li>
		     </ul>
	        <div id="fragment-1">
	        
	        	<div class="fragment-1-right">
				<c:forEach items="${auctions}" var="auction" begin="1" step="2" >
	        		<div class="auction">
						<a href="#"> 
							<img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
						</a>
						<div class="auctionDetails">
							<h4>${auction.title}</h4>
							<h6>
								<strong> Time Left:</strong>${auction.startDate}
							</h6>
							<a href='<c:url value="/auctions/${auction.id}/index.do"/>'> 
								<span>view items</span>
							</a>
						</div>
	        		</div>
				</c:forEach>
	        	</div>
	        
	        	<div class="fragment-1-left">
				<c:forEach items="${auctions}" var="auction" begin="0" step="2">
	        		<div class="auction">
						<a href="#"> 
							<img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
						</a>
						<div  class="auctionDetails">
							<h4>${auction.title}</h4>
							<h6>
								<strong> Time Left:</strong>${auction.startDate}
							</h6>
							<a href='<c:url value="/auctions/${auction.id}/index.do"/>'> 
								<span>view items</span>
							</a>
						</div>
	        		</div>
				</c:forEach>
	        	</div>
	        </div>
	        <div id="fragment-2">
	        	<div class="fragment-1-right">
				<c:forEach items="${willAuctions}" var="auction" begin="1" step="2" >
	        		<div class="auction">
						<a href="#"> 
							<img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
						</a>
						<div class="auctionDetails">
							<h4>${auction.title}</h4>
							<h6>
								<strong> Time Left:</strong>${auction.startDate}
							</h6>
							<a href='<c:url value="/auctions/${auction.id}/index.do"/>'> 
								<span>view items</span>
							</a>
						</div>
	        		</div>
				</c:forEach>
	        	</div>
	        
	        	<div class="fragment-1-left">
				<c:forEach items="${willAuctions}" var="auction" begin="0" step="2">
	        		<div class="auction">
						<a href="#"> 
							<img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
						</a>
						<div  class="auctionDetails">
							<h4>${auction.title}</h4>
							<h6>
								<strong> Time Left:</strong>${auction.startDate}
							</h6>
							<a href='<c:url value="/auctions/${auction.id}/index.do"/>'> 
								<span>view items</span>
							</a>
						</div>
	        		</div>
				</c:forEach>
	        	</div>
	        </div>
		</div>
	</div>
	<div class="down">
		<div class="downLeft">
			<c:forEach items="${topItemsCategories}" var="topItem">
	        	<dl class="topItem">
	        		${topItem.category.name}
					<c:forEach items="${topItem.items}" var="item" begin="0" end="2">
						<dd><i class="icon-circle">&nbsp;</i>${item.title}</dd>
					</c:forEach>
	        	</dl>
			</c:forEach>
		</div>
		<div class="downRight">
			<%@ include file="/jsp/include/tabs4.txt" %>
		</div>
	</div>
</div>	
</div><!-- counter -->
<%@ include file="/jsp/include/footer.txt" %>