<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-1.8.3.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-ui-1.10.0/jquery-ui-1.10.0.custom.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery.log.js"/>'></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

ul,li {
	padding: 0;
	margin: 0;
	list-style: none;
}

.slideshow {
	width: 600px;
	height: 400px;
}

.slideshow img {
	cursor: pointer;
}

.slideshow-top {
	height: 300px;
	margin-bottom: 10px;
}

.slideshow-top img {
	width: 600px;
	height: 300px;
}

.slideshow-button {
	width: 600px; /* 圖片的寬 */
	position: relative;
	overflow: hidden;
}

.slideshow-button ul {
	width: 9999px;
	height: 60px;
	background-color: red;
}

.slideshow-button ul li {
	height: 100%;
	float: left;
}

.slideshow-button img {
	padding: 5px;
	width: 50px;
	height: 50px;
}
</style>
<script type="text/javascript">
(function($){
	
	
})(jQuery);
</script>
<script type="text/javascript">
	
	$(function() {
 		var index = 0;
		$("#next").click(function(){
			index = index + 1 ;
			$.log("index = " + index);
			var imgs = $(".slideshow-button img");
			imgs.each(function(){
				var _this = $(this);
				_this.css({"position":"relative"}).animate({
	 				left : (-64 * index )+ "px"
	 			}, 1000);
			});
		}); 
		$("#pre").click(function(){
			index = 0;
			$(".slideshow-button img").css({"left":"0px"});
		});
		$(".slideshow-button img").click(function(){
			//$.log(this.src);
			$(".slideshow-top img").attr("src" ,this.src);
		});
	});
</script>
</head>
<body>
	<div class="slideshow">
		<div class="slideshow-top">
        	<img rel="img/flowing-rock.jpg" src="img/flowing-rock.jpg" alt="Flowing Rock" />
		</div>
		<input type="button" id="pre" value="pre"/>
		<input type="button" id="next" value="next"/>
		<div class="slideshow-button">
		<ul>
			<li><a href="#"><img rel="img/flowing-rock.jpg" src="img/flowing-rock.jpg" alt="Flowing Rock" /></a></li>
			<li><a href="#"><img rel="img/grass-blades.jpg" src="img/grass-blades.jpg" alt="Grass Blades" /></a></li>
			<li><a href="#"><img rel="img/stones.jpg" src="img/stones.jpg" alt="Stones" /></a></li>
			<li><a href="#"><img rel="img/sea-mist.jpg" src="img/sea-mist.jpg" alt="Sea Mist" /></a></li>
			<li><a href="#"><img rel="img/pier.jpg" src="img/pier.jpg" alt="Pier" /></a></li>
			<li><a href="#"><img rel="img/lotus.jpg" src="img/lotus.jpg" alt="Lotus" /></a></li>
			<li><a href="#"><img rel="img/mojave.jpg" src="img/mojave.jpg" alt="Mojave" /></a></li>
			<li><a href="#"><img rel="img/lightning.jpg" src="img/lightning.jpg" alt="Lightning" /></a></li>
			<li><a href="#"><img rel="img/ladybug.jpg" src="img/ladybug.jpg" alt="Ladybug" /></a></li>
			
			<li><a href="#"><img rel="img/flowing-rock.jpg" src="img/flowing-rock.jpg" alt="Flowing Rock" /></a></li>
			<li><a href="#"><img rel="img/grass-blades.jpg" src="img/grass-blades.jpg" alt="Grass Blades" /></a></li>
			<li><a href="#"><img rel="img/stones.jpg" src="img/stones.jpg" alt="Stones" /></a></li>
			<li><a href="#"><img rel="img/sea-mist.jpg" src="img/sea-mist.jpg" alt="Sea Mist" /></a></li>
			<li><a href="#"><img rel="img/pier.jpg" src="img/pier.jpg" alt="Pier" /></a></li>
			<li><a href="#"><img rel="img/lotus.jpg" src="img/lotus.jpg" alt="Lotus" /></a></li>
			<li><a href="#"><img rel="img/mojave.jpg" src="img/mojave.jpg" alt="Mojave" /></a></li>
			<li><a href="#"><img rel="img/lightning.jpg" src="img/lightning.jpg" alt="Lightning" /></a></li>
			<li><a href="#"><img rel="img/ladybug.jpg" src="img/ladybug.jpg" alt="Ladybug" /></a></li>
	        
			
			</ul>
		</div>
	</div>
</body>
</html>
