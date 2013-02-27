<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header_login.txt" %>
<%@ include file="/jsp/include/menu.txt" %>
<style type="text/css">
#content {
	width: 750px;
	float: right;
	background-color: gray;
	margin-bottom: 20px;
}
.top {
	height: 300px;
	background-color: pink;
}
.down {
	height: 500px;
}
.downLeft {
	width: 350px;
	height: 300px;
	background-color: red;
	float: left;
}
.downRight {
	width: 300px;
	height: 400px;
	background-color: yellow;
	float: left;
}

</style>
<div id="content">
	<div class="top">
	<c:forEach items="${auctions}" var="auction">
		<div>
		${auction}
		</div>
	</c:forEach>
	</div>
	<div class="down">
		<div class="downLeft">
		Top Items By Category 
		</div>
		<div class="downRight">
		tabs
		</div>
	</div>
</div>
<%@ include file="/jsp/include/footer.txt" %>
	





