<%@page import="itat.zttc.msg.model.SystemContext"%>
<%@page import="itat.zttc.msg.model.Pager"%>
<%@page import="itat.zttc.msg.model.User"%>
<%@page import="java.util.List"%>
<%@page import="itat.zttc.msg.dao.DAOFactory"%>
<%@page import="itat.zttc.msg.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String con = request.getParameter("con");
    if(con==null) con = "";
	IUserDao userDao = DAOFactory.getUserDao();
	Pager<User> pages = userDao.list(con);
	int pageIndex = pages.getPageIndex();
	List<User> users = pages.getDatas();
	User lu = (User)session.getAttribute("loginUser");
%>
</head>
<body>
<jsp:include page="inc.jsp">
	<jsp:param value="列表" name="op"/>
</jsp:include>

<table align="center" border="1" width="1000">
	<tr>
		<td colspan="7">
			<form action="list.jsp">
			輸入用戶名或者昵稱：<input type="text" name="con" value="<%=con%>"/><input type="submit" value="查詢"/>
			</form>
		</td>	
	</tr>
	<tr>
	<td>用戶標識</td><td>用戶名</td><td>用戶密碼</td><td>用戶昵稱</td>
	<td>用戶類型</td><td>用戶狀態</td>
	<td>操作</td>
	</tr>
	<%
	for(User u:users){
	%>
	<tr>
	<td><%=u.getId() %></td>
	<td><%=u.getUsername() %></td>
	<td><%=u.getPassword() %></td>
	<td><%=u.getNickname() %></td>
	<td>
	<%
		if(u.getType()==0) {
	%>
		普通用戶
		<%
		if(lu.getType()==1) {
		%>
		<a href="setType.jsp?id=<%=u.getId()%>">設置管理員</a>
		<%	
		}
		%>
	<%
		} else {
	%>
		管理員
		<%
		if(lu.getType()==1) {
		%>
		<a href="setType.jsp?id=<%=u.getId()%>">取消管理員</a>
		<%	
		}
		%>
	<%
		}
	%>
	</td>
	<td>
	<%
		if(u.getStatus()==0) {
	%>
		啟用
		<%
		if(lu.getType()==1) {
		%>
		<a href="setStatus.jsp?id=<%=u.getId()%>">停用</a>
		<%	
		}
		%>
	<%
		} else {
	%>
		<span style='color:red'>停用</span>
		<%
		if(lu.getType()==1) {
		%>
		<a href="setStatus.jsp?id=<%=u.getId()%>">啟用</a>
		<%	
		}
		%>
	<%		
		}
	%>
	</td>
	<td>
	<%
	if(lu.getType()==1) {
	%>
	<a href="delete.jsp?id=<%=u.getId()%>">刪除</a>&nbsp;<a href="updateInput.jsp?id=<%=u.getId()%>">更新</a>&nbsp;</td>
	<%	
	}
	%>
	</tr>
	<%	
	}
	%>
	<tr>
	<td colspan="7">
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="<%=pages.getTotalRecord() %>" name="items"/>
			<jsp:param value="con" name="params"/>
		</jsp:include>		
	</td>
	</tr>
</table>
</body>
</html>