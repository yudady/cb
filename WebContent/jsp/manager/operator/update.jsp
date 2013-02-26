<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header_manager.txt" %>
<%@ include file="/jsp/include/menu_manager.txt" %>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base_manager.css"/>'/>
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





