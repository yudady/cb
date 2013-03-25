<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header_manager.txt" %>
<title>operator</title>
</head>
<body>
	<%@ include file="/jsp/include/logo_manager.txt" %>
	<%@ include file="/jsp/include/menu_manager.txt"%>
	<div id="content">
		update
		<form method="post">
			<input type="hidden" name="id" value="${operatorObj.id}" /><br/>
			name<input type="text" name="name" value="${operatorObj.name}" /><br/>
			passWord<input type="text" name="passWord" value="${operatorObj.passWord}" /><br/>
			<input type="reset" name="reset" "/><br/>
			<input type="submit" name="submit" value="update"/><br/>
		</form>
	</div>
	<%@ include file="/jsp/include/footer_manager.txt" %>
</body>
</html>