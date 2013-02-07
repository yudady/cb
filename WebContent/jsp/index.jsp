<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/jsp/include/header.txt" %>
<%@ include file="/jsp/include/menu.txt" %>
<style type="text/css">
#content {
	width: 750px;
	height: 500px;
	float: right;
	background-color: gray;
	margin-bottom: 20px;
}

#liveAuctions {
	width: 600px;
	height: 500px;
	float: left;
	background-color: pink;
	margin-bottom: 20px;
}

#itemsClosing {
	width: 370px;
	height: 500px;
	float: right;
	background-color: yellow;
}
</style>
<script type="text/javascript">

</script>
<div id="content">counter</div>
<div id="liveAuctions">liveAuctions</div>
<div id="itemsClosing">
<img alt="" src='<c:url value="/pic/upload/indexright/sharethelove_banner.jpg"/>'>
itemsClosing



</div>
<%@ include file="/jsp/include/footer.txt" %>
	





