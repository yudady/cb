<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-1.8.3.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery/jquery-ui-1.10.0/jquery-ui-1.10.0.custom.min.js"/>'></script>
<style type="text/css">
.slideshowlite {
	position: relative;
	border: 2px solid #111;
	overflow: hidden;
}

.slideshowlite a {
	position: absolute;
	z-index: 1;
	width: 100%;
	height: 100%;
	text-align: center;
}

.slideshowlite img {
	border: none;
}

/* pagination control */
.slideshowlite ul,.slideshowlite ol {
	list-style: none;
	position: absolute;
	margin: 0;
	padding: 0;
	bottom: 5px;
	right: 5px;
	z-index: 3;
}

.slideshowlite ul li,.slideshowlite ol li {
	float: left;
	margin: 0 3px;
	width: 16px;
}

.slideshowlite ul li a {
	position: relative;
	display: block;
	width: 100%;
	height: 14px;
	padding: 1px;
	text-decoration: none;
	color: #666;
	background: #eee;
	border: 1px solid #666;
	text-align: center;
	font-size: 11px;
}

.slideshowlite ul li a.current {
	color: #111;
	font-weight: bold;
	border: 1px solid #111;
	background: #FEFFAF;
}

.slideshowlite ul li a:hover {
	color: #fff;
	background: #333;
}

/* caption control */
.slideshowlite ol {
	top: 5px;
	position: relative;
	overflow: hidden;
	width: 100%;
	font-size: 14px;
	color: #fff;
	background: #000;
	padding: 3px 10px;
}

.slideshowlite ol li {
	width: 100%;
}
</style>
<script type="text/javascript">
/**
 * Slideshow Lite plugin for jQuery
 *
 * v0.7.1
 * 2011-03-31 Jerry新增圖片縮圖功能
 *
 * Copyright (c) 2009 Fred Wu
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 */

/**
 * Configuration options:
 *
 * pauseSeconds       float    number of seconds between each photo to be displayed
 * fadeSpeed          float    number of seconds for the fading transition, the value should not exceed 'pauseSeconds'
 * width              integer  width of the slideshow, in pixels
 * height             integer  height of the slideshow, in pixels
 * caption            boolean  display photo caption?
 * cssClass           string   name of the CSS class, defaults to 'slideshowlite'
 * anchorTarget       string   name for the target="_xxx" attribute, defaults to '_self'
 * miniature          boolean  是否要將下方導覽列換成縮圖，預設是 false
 * miniatureHeight    integer  導覽列縮圖高度，預設是 30px
 * miniatureWidth     integer  導覽列縮圖寬度，預設是 30px
 */

(function($){
  $.fn.slideshow = function(options){

    var defaults = {
      pauseSeconds: 2,
      fadeSpeed: 0.5,
      width: 468,
      height: 120,
      caption: true,
      cssClass: 'slideshowlite',
      anchorTarget: '_self',
      //========新增屬性===========
      miniature: false,
      miniatureHeight: 30,
      miniatureWidth: 30
      //===========================
    };

    var options = $.extend(defaults, options);

    // ----------------------------------------
    // slideshow instance
    // ----------------------------------------

    var runInstance = function(target) {
      var items  = $("a", target);
      var instance;

      // ----------------------------------------
      // some mandontory styling
      // ----------------------------------------

      if ( ! $(target).hasClass(options.cssClass)) $(target).addClass(options.cssClass);

      $(target).css({
        width: options.width + "px",
        height: options.height + "px"
      });

      // ----------------------------------------
      // create anchor links to make the structure simpler for manupilation
      // ----------------------------------------

      $("> img", target).wrap(document.createElement("a"));
      $("a", target).attr("target", options.anchorTarget);

      // ----------------------------------------
      // add item sequence markups
      // ----------------------------------------

      var i = 1;
      $("a", target).each(function(){
        $(this).attr("rel", i++);
      });

      // ----------------------------------------
      // create pagination and caption
      // ----------------------------------------

      $(target).append("<ul></ul>");
      $(target).append("<ol></ol>");
      var pagination = $("> ul", target);
      var caption = $("> ol", target);

      var i = 1;
      var j = 0;
      $("a", target).each(function(){
          if (options.miniature == true){
              var $img = $(this).children("img");
              pagination.append("<li style=\"width:" + options.miniatureWidth + "px;\"><a style=\"height:" + options.miniatureHeight + "px;\" href=\"#\" rel=\"" + i++ + "\"><img width=\"" + options.miniatureWidth + "\" heigth=\"" + options.miniatureHeight + "\" src=\"" + $img.attr("rel") + "\" /></a></li>");
          } else {
              pagination.append("<li><a href=\"#\" rel=\"" + i + "\">" + i++ + "</a></li>");
          }
        caption.append("<li>" + $("img:nth(" + j++ + ")", target).attr("alt") + "</li>");
      });
      pagination.fadeTo(0, 0.8);
      caption.fadeTo(0, 0.6);
      caption.hide();

      // ----------------------------------------
      // shortcuts
      // ----------------------------------------

      var firstItem   = $("> a:first", target);
      var lastItem    = $("> a:last", target);
      var currentItem = firstItem;

      // ----------------------------------------
      // pagination highlight
      // ----------------------------------------

      var paginationHighlight = function(sequence){
        $("> li > a", pagination).removeClass("current");
        $("> li > a:nth(" + sequence + ")", pagination).addClass("current");
      };

      // ----------------------------------------
      // caption
      // ----------------------------------------

      var showCaption = function(sequence){
        caption.show();
        $("> li", caption).hide();
        $("> li:nth(" + sequence + ")", caption).fadeIn();
      }

      // ----------------------------------------
      // slideshow logic
      // ----------------------------------------

      var makeSlideshow = function(){

        // pagination click
        $("> li > a", pagination).click(function(){
          if ( ! $(this).hasClass("current"))
          {
            // select the current item after the pagination click
            currentItem = $("a:nth(" + ($(this).attr('rel') - 1) + ")", target);

            currentItem.show();
            startSlideshow();
          }
          return false;
        });

        // pagination highlight
        paginationHighlight(currentItem.attr("rel")-1);

        // show caption
        if (options.caption == true)
        {
          showCaption(currentItem.attr("rel")-1);
        }

        currentItem.css("z-index", 2);

        // show the current slide
        currentItem.fadeIn(options.fadeSpeed*1000, function(){
          $("> a", target).hide();
          $(this).show().css("z-index", 1);
        });

        // prepare for the next slide
        // determines the next item (or we need to rewind to the first item?)
        if ($("img", currentItem).attr("src") == $("img", lastItem).attr("src"))
        {
          currentItem = firstItem;
        }
        else
        {
          currentItem = currentItem.next();
        }

        currentItem.css("z-index", 1);
      };

      var startSlideshow = function(){
        clearInterval(instance);
        makeSlideshow();
        instance = setInterval(makeSlideshow, options.pauseSeconds*1000);
      };

      // ----------------------------------------
      // start the slideshow!
      // ----------------------------------------

      startSlideshow();
    }

    // ----------------------------------------
    // run the slideshow instances!
    // ----------------------------------------

    if (this.length > 1) {
      this.each(function() {
        runInstance(this);
      });
    } else {
      runInstance(this);
    }

  };
})(jQuery);
</script>
<script type="text/javascript">
	$(function() {
		$("#slideshow").slideshow({ miniature: true, miniatureWidth: 39, miniatureHeight: 24 });
	});
</script>
</head>
<body>
	<div id="slideshow">
		<a href="http://www.beyondcoding.com/">
        <img rel="img/flowing-rock.jpg" src="img/flowing-rock.jpg" width="580" height="360" alt="Flowing Rock" /></a>
		<img rel="img/grass-blades.jpg" src="img/grass-blades.jpg" width="580" height="360" alt="Grass Blades" />
		<img rel="img/stones.jpg" src="img/stones.jpg" width="580" height="360" alt="Stones" />
		<img rel="img/sea-mist.jpg" src="img/sea-mist.jpg" width="580" height="360" alt="Sea Mist" />
		<img rel="img/pier.jpg" src="img/pier.jpg" width="580" height="360" alt="Pier" />
		<img rel="img/lotus.jpg" src="img/lotus.jpg" width="580" height="360" alt="Lotus" />
		<img rel="img/mojave.jpg" src="img/mojave.jpg" width="580" height="360" alt="Mojave" />
		<img rel="img/lightning.jpg" src="img/lightning.jpg" width="580" height="360" alt="Lightning" />
		<a href="http://www.beyondcoding.com/"><img rel="img/ladybug.jpg" src="img/ladybug.jpg" width="580" height="360" alt="Ladybug" /></a>
	</div>
</body>
</html>
