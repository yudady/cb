<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href='<c:url value="/js/jquery/timer_gallery_plugin/css/style.css"/>'/>
<link type="text/css" rel="stylesheet" href='<c:url value="/js/jquery/timer_gallery_plugin/css/colorbox.css"/>'/>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-1.8.3.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-ui-1.10.0/jquery-ui-1.10.0.custom.min.js"/>'></script>
<script type="text/javascript" src="<c:url value="/js/jquery/timer_gallery_plugin/js/jquery.vec.timerGallery_ts.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/timer_gallery_plugin/js/jquery.colorbox-min.js"/>"></script>
<script type="text/javascript">
$(document).ready (function(){
	$('#slide1').timerGallery({idPre: 'img' , interval : '4000' });	
	$('#slide2').timerGallery({idPre: 'img_' , interval : '5000'});	
	$("a[class='cboxElement']").colorbox();
});

</script>

<title>Jquery Photo Gallery Plugin</title>
</head>
<body>
<div id="wrapper">
<h1>Jquery Timer Photogallery Plugin v1 BETA</h1>
<p class="photo_credits">All photos by: <span>Chloe Rice</span> ,<a href="http://ohchloe.com/section/17235.html">OhChloe.com</a></p>
<!--start plugin-->
<div id="slide1" class="slideshow">
	<div class="img_cont">
  <ul id="desc1" class="descriptions">
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula.  </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula.  </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula.  </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula.  </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
    <li>
      <p class="slider_add">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
      <p>Suspendisse malesuada dolor vel lorem pulvinar vitae consequat purus iaculis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nullam et egestas ligula. </p>
    </li>
  </ul>
  <ul class="main_images">
  	<li><a href="images/girl1.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe.jpg"/>' alt="girl" /></a></li>
    <li><a href="images/baby.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe.jpg"/>' alt="baby" /></a></li>
    <li><a href="images/balloon.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/balloon_chloe.jpg"/>' alt="balloon" /></a></li>
  	<li><a href="images/girl1.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe.jpg"/>' alt="girl" /></a></li>
    <li><a href="images/baby.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe.jpg"/>' alt="baby" /></a></li>
    <li><a href="images/balloon.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/balloon_chloe.jpg"/>' alt="balloon" /></a></li>
  	<li><a href="images/girl1.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe.jpg"/>' alt="girl" /></a></li>
    <li><a href="images/baby.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe.jpg"/>' alt="baby" /></a></li>
    <li><a href="images/balloon.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/balloon_chloe.jpg"/>' alt="balloon" /></a></li>
  	<li><a href="images/girl1.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe.jpg"/>' alt="girl" /></a></li>
    <li><a href="images/baby.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe.jpg"/>' alt="baby" /></a></li>
    <li><a href="images/balloon.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/balloon_chloe.jpg"/>' alt="balloon" /></a></li>
  	<li><a href="images/girl1.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe.jpg"/>' alt="girl" /></a></li>
    <li><a href="images/baby.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe.jpg"/>' alt="baby" /></a></li>
    <li><a href="images/balloon.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/balloon_chloe.jpg"/>' alt="balloon" /></a></li>
  	<li><a href="images/girl1.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe.jpg"/>' alt="girl" /></a></li>
    <li><a href="images/baby.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe.jpg"/>' alt="baby" /></a></li>
    <li><a href="images/balloon.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/balloon_chloe.jpg"/>' alt="balloon" /></a></li>
  	<li><a href="images/girl1.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe.jpg"/>' alt="girl" /></a></li>
    <li><a href="images/baby.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe.jpg"/>' alt="baby" /></a></li>
    <li><a href="images/balloon.jpg" class="cboxElement"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/balloon_chloe.jpg"/>' alt="balloon" /></a></li>
  </ul>
  </div>
    
   <div class="prev_btn"><a href="#" class="prev"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/previous.png"/>' alt="previous"/></a></div>
  <div class="thumb_holder">
    <ul class="thumbs">
      <li class="section">
        <ul class="sub_section">
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe_thumb.jpg"/>' alt="gril" /></a></li>
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe_thumb.jpg"/>' alt="baby" /></a></li>
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe_thumb.jpg"/>' alt="gril" /></a></li>
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe_thumb.jpg"/>' alt="baby" /></a></li>
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe_thumb.jpg"/>' alt="gril" /></a></li>
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/baby_chloe_thumb.jpg"/>' alt="baby" /></a></li>
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/girl1_chloe_thumb.jpg"/>' alt="gril" /></a></li>
        </ul>
      </li>
      
      <li class="section">
        <ul class="sub_section">
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/boots_chloe_thumb.jpg"/>' alt="boots" /></a></li>
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/bullets_chloe_thumb.jpg"/>' alt="bullets" /></a></li>
        </ul>
      </li>
      <li class="section">
        <ul class="sub_section">
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/icecream_chloe_thumb.jpg"/>' alt="icecream" /></a></li>
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/justin_chloe_thumb.jpg"/>' alt="Justin" /></a></li>
        </ul>
      </li>
      <li class="section">
        <ul class="sub_section">
          <li><a href="javascript:void(0);"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/track_chloe_thumb.jpg"/>' alt="track" /></a></li>
      </ul>
      </li>
    </ul>
  </div>
      <div class="next_btn"><a href="#" class="next"><img src='<c:url value="/js/jquery/timer_gallery_plugin/images/next.png"/>' alt="next"/></a></div>
</div>
<!--end plugin-->

</div><!--end wrapper-->
</body>
</html>
