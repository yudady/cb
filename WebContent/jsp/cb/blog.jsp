<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="/jsp/include/header.txt" %>
<title>itemsPager</title>
</head>
<body>
<%@ include file="/jsp/include/bodyTop.txt" %>
<style type="text/css">
.counter {
	padding: 10px;
	background-color: white;

}
.mainCounter {
	margin-left:210px;
	background-color: gray;
}
</style>
<div class="counter"><!-- counter -->
<%@ include file="/jsp/include/menu.txt" %>
<div class="mainCounter">
	blog<br/>
	blog<br/>
	blog<br/>
</div>
<div class="clearBoth"></div>
</div><!-- counter -->
<%@ include file="/jsp/include/footer.txt" %>
</body>
</html>