<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header_login.txt" %>
<%@ include file="/jsp/include/menu.txt" %>
<style type="text/css">
#content {
	width: 750px;
	float: right;
	background-color: gray;
	margin-bottom: 20px;
}

.down {
	height: 500px;
}

.downLeft {
	width: 350px;
	height: 300px;
	float: left;
}

.downRight {
	width: 300px;
	height: 400px;
	float: left;
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
	background-color: white;
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
</style>
<script type="text/javascript">
$(function(){
	$("#auctionLists").tabs();
});
</script>
<div id="content">
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
		Top Items By Category 
		</div>
		<div class="downRight">
		tabs
		</div>
	</div>
</div>
<%@ include file="/jsp/include/footer.txt" %>
	





