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
.slideshow-top .picMsg {
	width:600px;
	height:100px;
	font-size:24px;
	position: absolute;
	background-color: gray;
	z-index:1;
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
.slideshow-button-click {
	background-color: yellow;
}

</style>
<script type="text/javascript">
(function($){
	
	
})(jQuery);
</script>
<script type="text/javascript">
	
	$(function() {
		var si = 10;
 		var moviePic = 10;
 		var positionRelative = 0;
 		var moveLength = 60 ;
 		
 		var imgs = $(".slideshow-button img");
 		
 		si = ( si <= imgs.size()) ? si : imgs.size();
 		
 		
 		imgs.first().addClass("slideshow-button-click");
 		addMoveActivity(0,si);
		function addMoveActivity(start,end){
			$(".move-activity").removeClass("move-activity");
			imgs.each(function(i,value){
				if(i < end && i >= start){
					$(this).addClass("move-activity");
				}
			});
		}
		
		
		$('.move-activity').live('click', function() {
			$(".slideshow-button-click").removeClass("slideshow-button-click");
			$(this).addClass("slideshow-button-click");
			topPicChange(this);
			
		});
		
		
		
		
		$(".slideshow-top .picMsg").css({"opacity":"0.4"});
		$(".slideshow-top .picMsg input[type='button']").click(function(){
			alert('1');
		});
		
		
		$("#left").click(function(){
			if(positionRelative >= imgs.size()-si){
				return;
			}
			
			positionRelative = positionRelative + moviePic ;
			
			if(positionRelative + moviePic >= imgs.size()){
				positionRelative = imgs.size() - moviePic;
			}
			
			
			
			addMoveActivity(positionRelative,si+positionRelative);
			move();
		}); 
		$("#right").click(function(){
			if(positionRelative <= 0){
				return;
			}
			
			positionRelative = positionRelative - moviePic;
			
			if(positionRelative <= 0){
				positionRelative = 0;
			}
			
			
			
			$.log(positionRelative);
			
			
			addMoveActivity(positionRelative,si+positionRelative);
			move();
		});
		function move(){
			imgs.css({"position":"relative"}).animate({
 				left : -(moveLength * positionRelative )+ "px"
 			}, 500);
		}
		
		
		function findNextPic(){
			var p = $(".slideshow-button-click").removeClass("slideshow-button-click");
			var q = p.parent().parent().next().find(".move-activity");
			if(q.size() > 0){
				q.addClass("slideshow-button-click");
			}else{
				$(".move-activity").removeClass("slideshow-button-click");
				$(".move-activity").first().addClass("slideshow-button-click");
			}
			
			var hh = $(".slideshow-button-click")[0];
			topPicChange(hh);
		};
		
		
		function topPicChange(pic){
			$(".slideshow-top img").attr("src" ,pic.src);
			$(".picMsg span").html(pic.alt);
		};
		
		var myTimer = window.setInterval(findNextPic, 1000);
		$(".slideshow").on("mouseenter",function(){
			window.clearInterval(myTimer);
		});
		$(".slideshow").on("mouseleave",function(){
			myTimer = window.setInterval(findNextPic, 1000);
		});
		
	});
</script>
</head>
<body>
	<div class="slideshow">
		<div class="slideshow-top">
			<div class="picMsg">
					<span></span>
					<br/>
					<input type="button" value="click" /><br/>
			</div>
        	<img rel="img/flowing-rock.jpg" src="img/flowing-rock.jpg" alt="Flowing Rock" />
		</div>
		<input type="button" id="left" value="<<"/>
		<input type="button" id="right" value=">>"/>
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
				<li><a href="#"><img rel="img/lightning.jpg" src="img/lightning.jpg" alt="Lightning" /></a></li>
				<li><a href="#"><img rel="img/ladybug.jpg" src="img/ladybug.jpg" alt="Ladybug" /></a></li>
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
				<li><a href="#"><img rel="img/lightning.jpg" src="img/lightning.jpg" alt="Lightning" /></a></li>
				<li><a href="#"><img rel="img/ladybug.jpg" src="img/ladybug.jpg" alt="Ladybug" /></a></li>
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
				<li><a href="#"><img rel="img/lightning.jpg" src="img/lightning.jpg" alt="Lightning" /></a></li>
				<li><a href="#"><img rel="img/ladybug.jpg" src="img/ladybug.jpg" alt="Ladybug" /></a></li>
				<li><a href="#"><img rel="img/ladybug.jpg" src="img/ladybug.jpg" alt="Ladybug" /></a></li>
			</ul>
		</div>
	</div>
</body>
</html>
