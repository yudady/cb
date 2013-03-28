<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>manager|category</title>
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
			<a href='<c:url value="/manager/category/list.do" />'>category list</a>
			<b> » </b>
			add
		</div>
		<div>
			<a href='<c:url value="/manager/category/list.do"/>'>
				<input type="button" value="category list" />
			</a>
		</div>
		<form id="form1" method="post">
			<div>
				<label id="fname">name<input class="required" type="text" id="fname" name="name" /></label>
			</div>
			<input type="reset" name="reset" value="reset" />
			<input type="submit" name="submit" value="submit" /><br/>
		</form>
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>