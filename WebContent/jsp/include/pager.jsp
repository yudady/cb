<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<style type="text/css">
#pager {
	text-align: center;
	width: 500px;
	height: 60px;
	line-height: 60px;
}
</style>
<div id="pager">
	<pg:pager url="${param.url}" maxPageItems="${param.pageSize}" items="${param.totalRecord}" export="curPage=pageNumber">
		<pg:last>
		共${items}記錄,共${pageNumber}頁,
		</pg:last>
		當前第${curPage}頁
		<pg:first>
			<a href="${pageUrl}">首頁 </a>
		</pg:first>
		<pg:prev>
			<a href="${pageUrl}">上一頁$</a>
		</pg:prev>
		<pg:pages>
			<c:choose>
				<c:when test="${curPage==pageNumber}">
					[${pageNumber}]
				</c:when>
				<c:otherwise>
					<a href="${pageUrl}">${pageNumber}</a>
				</c:otherwise>
			</c:choose>
		</pg:pages>
		<pg:next>
			<a href="${pageUrl}">下一頁</a>
		</pg:next>
		<pg:last>
			<a href="${pageUrl}">尾頁</a>
		</pg:last>
	</pg:pager>
</div>