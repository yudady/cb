<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%
	int items = Integer.parseInt(request.getParameter("items"));
	String params = request.getParameter("params");
	if(params==null) params="";
	String[] ps = params.split(",");
%>
<pg:pager maxPageItems="15" items="<%=items%>" export="curPage=pageNumber">
<%
	for(String p:ps) {
%>
	<pg:param name="<%=p %>"/>
<%		
	}
%>
<pg:last>
共<%=items %>記錄,共<%=pageNumber %>頁,
</pg:last>
當前第<%=curPage %>頁
<pg:first>
	<a href="<%=pageUrl%>">首頁</a>
</pg:first>
<pg:prev>
	<a href="<%=pageUrl%>">上一頁</a>
</pg:prev>
<pg:pages>
<%
	if(curPage==pageNumber) {
%>
	[<%=pageNumber%>]
<%		
	} else {
%>
	<a href="<%=pageUrl %>"><%=pageNumber %></a>		
<%		
	}
%>
</pg:pages>
<pg:next>
	<a href="<%=pageUrl %>">下一頁</a>
</pg:next>
<pg:last>
	<a href="<%=pageUrl%>">尾頁</a>
</pg:last>
</pg:pager>