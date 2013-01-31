<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-1.9.0.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-ui-1.10.0.custom.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery.log.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/base.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/include/sidebar.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base.css"/>'/>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/smoothness/jquery-ui-1.10.0.custom.min.css"/>'/>
</head>
<body>
<div id="header">
<div class="logo">
	<a href='<c:url value="/"/>'>
		<img src='<c:url value="/pic/site/logo-high-res-retina.png"/>' />
	</a>
</div>
<div id="login">
	<span>Login with email and Password</span>
	<form id="loginForm" action="<c:url value='/login' />"
		method='POST'>
		<table>
			<tr>
				<td>email:</td>
				<td><input type='text' name='email' ></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='passWord' name='passWord' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit"
					value="submit" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
		</table>
	</form>
</div>
</div>