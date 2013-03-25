<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<style type="text/css">
#pager {
	text-align: center;
}
</style>
<script type="text/javascript">
	$(function(){
		$("#lotsPerPage-select").on("change",function(){
			var ps = $(this).find(":selected").val();
			var href = window.location.href ;
			$.log(href);
			var aa = href.search('pageSize');
			if(aa == -1){
				window.location.href = href + "?pageSize=" + ps;
			}else{
				window.location.href = href.substr(0,aa) + "pageSize=" + ps;
			}
		});
	});
</script>
<div id="pager">
	<select id="lotsPerPage-select">
		<option value="10" 
		<%if("10".equals(request.getParameter("pageSize"))) {%>selected="selected"<%} %> 
		>10 per page</option>
		<option value="25"  
		<%if("25".equals(request.getParameter("pageSize"))) {%>selected="selected"<%} %> 
		>25 per page</option>
		<option value="50" 
		<%if("50".equals(request.getParameter("pageSize"))) {%>selected="selected"<%} %> 
		>50 per page</option>
	</select>
	<pg:pager url="${param.url}" maxPageItems="${param.pageSize}" items="${param.totalRecord}" export="curPage=pageNumber">
		<pg:last>
		共${param.totalRecord}記錄,共${pageNumber}頁,
		</pg:last>
		當前第${curPage}頁
		<pg:first>
			<a href="${pageUrl}&pageSize=${param.pageSize}">首頁 </a>
		</pg:first>
		<pg:prev>
			<a href="${pageUrl}&pageSize=${param.pageSize}">上一頁</a>
		</pg:prev>
		<pg:pages>
			<c:choose>
				<c:when test="${curPage==pageNumber}">
					[${pageNumber}]
				</c:when>
				<c:otherwise>
					<a href="${pageUrl}&pageSize=${param.pageSize}">${pageNumber}</a>
				</c:otherwise>
			</c:choose>
		</pg:pages>
		<pg:next>
			<a href="${pageUrl}&pageSize=${param.pageSize}">下一頁</a>
		</pg:next>
		<pg:last>
			<a href="${pageUrl}&pageSize=${param.pageSize}">尾頁</a>
		</pg:last>
	</pg:pager>
<%--
	<label for="sortBy-select">Sort by:</label> 
	<select id="sortBy-select">
		<option value="close">Close Date</option>
		<option value="date_added">Date Added</option>
		<option value="estimated_price">Estimated Price</option>
		<option value="bid">Lowest Bid</option>
		<option value="name">Lot Title</option>
		<option value="id">Lot Number</option>
		<option value="priority">Priority</option>
		<option value="bids">Number of Bids</option>
	</select>
 --%>

</div>