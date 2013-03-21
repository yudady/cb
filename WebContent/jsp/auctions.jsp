<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header.txt" %>
<title>auction</title>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/cb/auctions.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/cb/auction.js"/>'></script>
</head>
<body>
<%@ include file="/jsp/include/bodyTop.txt" %>
<div class="counter"><!-- counter start-->
	<div class="counterLeft">
		<%@ include file="/jsp/include/menu.txt" %>
	</div>
	<div class="counterRight">
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
							<a href='<c:url value="/auctions/${auction.id}/${auction.title}/index.do"/>'> 
								<img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
							</a>
							<div class="auctionDetails">
								<h4>${auction.title}</h4>
								<h6>
									<strong> Time Left:</strong>${auction.startDate}
								</h6>
								<a href='<c:url value="/auctions/${auction.id}/${auction.title}/index.do"/>'> 
									<span>view items</span>
								</a>
							</div>
		        		</div>
					</c:forEach>
		        	</div>
		        
		        	<div class="fragment-1-left">
					<c:forEach items="${auctions}" var="auction" begin="0" step="2">
		        		<div class="auction">
							<a href='<c:url value="/auctions/${auction.id}/${auction.title}/index.do"/>'> 
								<img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
							</a>
							<div  class="auctionDetails">
								<h4>${auction.title}</h4>
								<h6>
									<strong> Time Left:</strong>${auction.startDate}
								</h6>
								<a href='<c:url value="/auctions/${auction.id}/${auction.title}/index.do"/>'> 
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
							<a href='<c:url value="/auctions/${auction.id}/${auction.title}/index.do"/>'> 
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
							<a href='<c:url value="/auctions/${auction.id}/${auction.title}/index.do"/>'> 
								<img src='<c:url value="/pic/upload/auction/${auction.auctionLogoPath}"/>' />
							</a>
							<div  class="auctionDetails">
								<h4>${auction.title}</h4>
								<h6>
									<strong> Time Left:</strong>${auction.startDate}
								</h6>
								<a href='<c:url value="/auctions/${auction.id}/${auction.title}/index.do"/>'> 
									<span>view items</span>
								</a>
							</div>
		        		</div>
					</c:forEach>
		        	</div>
		        </div>
			</div>
		</div>
		<div class="clearBoth"></div>
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
	<div class="clearBoth"></div>
</div><!-- counter end-->
<%@ include file="/jsp/include/footer.txt" %>
</body>
</html>