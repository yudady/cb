<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>manager|bidder</title>
<style type="text/css">
</style>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content">
		<div id="crumbs">
			<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
			<b> » </b>
			<a href='<c:url value="/manager/bidder/list.do" />'>bidder list</a>
			<b> » </b>
			add
		</div>
		<div>
			<a href='<c:url value="/manager/bidder/list.do"/>'>
				<input type="button" value="bidder list" />
			</a>
		</div>
		<form id="form1" method="post">
			<input type="hidden" name="id" value="${bidder.id}"/>
			<div>
				<label id="ffirstName">firstName<input class="required" type="text" id="ffirstName" name="firstName" value="${bidder.firstName}" /></label>
			</div>
			<div>
				<label id="flastName">lastName<input class="required" type="text" id="flastName" name="lastName" value="${bidder.lastName}" /></label>
			</div>
			<div>
				<label id="fscreenName">screenName<input class="required" type="text" id="fscreenName" name="screenName" value="${bidder.screenName}" /></label>
			</div>
			<div>
				<label id="fpassWord">passWord<input class="required" type="text" id="fpassWord" name="passWord" value="${bidder.passWord}" /></label>
			</div>
			<div>
				<label id="femail">email<input class="required" type="text" id="femail" name="email" value="${bidder.email}" /></label>
			</div>
			<input type="reset" name="reset" value="reset" />
			<input type="submit" name="submit" value="submit" /><br/>
		</form>
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>