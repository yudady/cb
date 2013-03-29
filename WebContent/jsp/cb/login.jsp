<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>cb</title>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-1.8.3.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-ui-1.10.0/jquery-ui-1.10.0.custom.min.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/js/jquery/jquery-ui-1.10.0/smoothness/jquery-ui-1.10.0.custom.min.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery.log.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/assets/css/prettify.css"/>'/>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/assets/css/font-awesome.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/base.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/css/base.css"/>'/>
<style type="text/css">

.counter {
	padding: 10px;
	background-color: white;

}
.mainCounter {
	padding:20px;
	margin-left:210px;
	background-color: white;
}

</style>
</head>
<body>
<div id="header"><!-- header start -->
<div class="logo">
	<a href='<c:url value="/"/>'>
		<img src='<c:url value="/pic/site/logo-high-res-retina.png"/>' />
	</a>
</div>
</div><!-- header end -->
<div class="mainBody"><!-- mainBody start -->
<div class="top-menu">
	<div id="nav">
		<ul>
			<li><a href='<c:url value="/"/>'>Home</a> |</li>
			<li><a href='<c:url value="/auctions/index.do"/>'>Auctions</a> |</li>
			<li><a href='<c:url value="/blog/index.do"/>'>Blog</a> |</li>
			<li><a href='<c:url value="/testimonials/index.do"/>'>Testimonials</a> |</li>
			<li><a href='<c:url value="/contact_us/index.do"/>'>Contact Us</a> |</li>
			<li><a href='<c:url value="/dogooddreambig/index.do"/>'>Dream Big <sup>NEW</sup></a></li>
		</ul>
	</div>
	<div class="social">
		<ul class="sprite-social">
			<li>
				<a class="fb" target="_blank" href="#">
					<span>Facebook</span>
				</a>
			</li>
			<li>
				<a class="tw" target="_blank" href="#">
					<span>twitter</span>
				</a>
			</li>
			<li>
				<a class="yt" target="_blank" href="#">
					<span>youtube</span>
				</a>
			</li>
			<li>
				<a class="tm" target="_blank" href="#"> 
					<span>tumblr</span>
				</a>
			</li>
			<li>
				<form id="emailsubscribe" method="post">
					<input type="hidden" value="buzz" name="source"> 
					<input class="subscribeemails" type="text" name="email_address" value="Join mailing list"> 
					<input class="NewEmailSubBtn" type="button" value="+">
				</form>
			</li>
		</ul>
	</div>
</div>

<div class="counter"><!-- counter -->
<%@ include file="/jsp/include/menu.txt" %>
<div class="mainCounter">
	<h1>${errorMsg}<h1>
	<br/>
	<form id="loginPage" action="<c:url value='/login/form.do' />"
		method='post'>
		<table>
			<tr>
				<td>email:</td>
				<td><input type='text' name='email'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>
					<input type='passWord' name='passWord' /> 
				</td>
			</tr>
			<tr>
				<td><input type="reset" name="reset" value="reset" /></td>
				<td><input type="submit" name="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</div>
<div class="clearBoth"></div>
</div><!-- counter -->
<%@ include file="/jsp/include/footer.txt" %>
</body>
</html>