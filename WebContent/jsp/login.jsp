<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header_login.txt" %>
<%@ include file="/jsp/include/menu.txt" %>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/login.css"/>'/>
<script type="text/javascript">
$("#loginPageBtn").click(function(){
	$("#loginPage").submit();
});
</script>
<div id="content">
	<h1>${errorMsg}<h1>
	<br/>
	<form id="loginPage" action="<c:url value='/login/form.do' />"
		method='post'>
		<table>
			<tr>
				<td>email:</td>
				<td><input type='text' name='email'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>
					<input type='passWord' name='passWord' /> 
					<input type='hidden' name='url' id='url' value="${url}" />
				</td>
			</tr>
			<tr>
				<td><input id="loginPageBtn" type="button" value="login" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="/jsp/include/footer.txt" %>
	





