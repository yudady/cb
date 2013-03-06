<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/jsp/include/header.txt" %>
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
</div><!-- counter -->
<%@ include file="/jsp/include/footer.txt" %>