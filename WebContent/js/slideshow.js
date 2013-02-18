;$(function() {
	
	$(function() {
		$("div").addClass('ui-corner-all');
		var si = 8;
 		var moviePic = 8;
 		var positionRelative = 0;
 		var moveLength = 94 ;//(70 + 10 + 10 + 2 + 2).slideshow-button img
 		
 		var imgs = $(".slideshow-button img");
 		
 		si = ( si <= imgs.size()) ? si : imgs.size();
 		
 		/**
 		 *第一章圖片 
 		 */
 		$(".slideshow-top img").attr("src",imgs.first().attr("src"));
 		$(".slideshow-top img").attr("alt",imgs.first().attr("alt"));
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
		$(".slideshow-top .direction").css({"opacity":"0.4"});
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
			
			var pic = $(".slideshow-button-click")[0];
			topPicChange(pic);
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
});





