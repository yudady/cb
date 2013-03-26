<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>manager|index</title>
<style type="text/css">
.index-right-tabs4-top-pic{
}
.index-right-tabs4-top-pic img{
	height: 100px;
	float: right;
}
</style>
<script type="text/javascript">
$(function(){
	$("input[type='file']").on('change',function(){
		$(this).prev().attr('src','');
	});
});
</script>
</head>
<body>
<%@ include file="/jsp/include/logo_manager.txt" %>
<c:choose>
	<c:when test="${empty operator}">
		<link type="text/css" rel="stylesheet" href='<c:url value="/css/manager.css"/>'/>
	</c:when>
	<c:otherwise>
		<%@ include file="/jsp/include/menu_manager.txt" %>
		<link type="text/css" rel="stylesheet" href='<c:url value="/css/base_manager.css"/>'/>
	</c:otherwise>
</c:choose>
<div id="content">
<c:choose>
	<c:when test="${empty operator}">
		<form method='post'>
			<table>
				<tr>
					<td>name:</td>
					<td><input type='text' name='name'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='passWord' name='passWord' /></td>
				</tr>
				<tr>
					<td><input name="reset" type="reset" value="reset"/></td>
					<td><input name="submit" type="submit" value="login" /></td>
				</tr>
			</table>
		</form>
	</c:when>
	<c:otherwise>
		<div id="crumbs">
			<a href='<c:url value="/manager/index.do" />'><i class="icon-home"></i></a>
		</div>
		<div>&nbsp;</div>
		<div class="index-right-tabs4-top-pic">
			<form action='<c:url value="/manager/indexPic.do" />' method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>index right tabs top pic</legend>
					<img src='<c:url value="/pic/upload/indexright/sharethelove_banner.jpg"/>' />
					<input type="file" name="file" /><br/>
					<input type="reset" name="reset" value="reset" />
					<input type="submit" name="submit" value="submit" />
				</fieldset>
			</form>
		</div>
		<div class="clearBoth"></div>
	</c:otherwise>
</c:choose>

</div>
<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>




