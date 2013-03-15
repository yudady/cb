(function($) {
    "use strict";
    $.widget("ui.slideshow", {
        //1、options
        options : {
            className : "slideshow",
            opacity : 0.4,
            moveLength : 90,
            timer : 10000,
            showPicsNumber : 8
        },
        _create : function() {
            // this.element -- a jQuery object of the element the widget was invoked on.
            // this.options --  the merged options hash
            var op = this.options;
            var ele = this.element.addClass( "ui-widget-" + op.className );
            var _this = this;
            // Cache references to collections the widget needs to access regularly
            /**
             *2個div 
             */
            var partsDiv = ele.children();
            /**
             *top div 
             */
            var topDiv = partsDiv.first().addClass("ui-widget-" + op.className +"-topDiv");
            /**
             *down div 
             */
            var downDiv = partsDiv.last().addClass("ui-widget-" + op.className +"-downDiv");
            /**
             *大圖片 
             */
            var bigImg = topDiv.find('img').addClass("ui-widget-" + op.className +"-bigPic").css("cursor", "pointer");
            /**
             *大圖片msgDiv
             */
            var bigImgOpacity = bigImg.prev().addClass("ui-widget-" + op.className +"-picMsg");
            /**
             *大圖片方向div
             */
            var bigImgDirection = bigImg.next().addClass("ui-widget-" + op.className +"-direction");
            /**
             *左邊<<
             */
            var leftDirection = bigImgDirection.children().first().addClass("ui-widget-" + op.className +"-leftDirection");
            /**
             *右邊>>
             */
            var rightDirection = bigImgDirection.children().last().addClass("ui-widget-" + op.className +"-rightDirection");
            /**
             *bid now 
             */
            var bidNow = topDiv.find('input').addClass("ui-widget-" + op.className +"-bidNow");
            
            var msgDiv = bidNow.prev().addClass("ui-widget-" + op.className +"-msgDiv");;
            
            /**
             * 大圖片上方文字
            var altMsg = bigImgOpacity.find('span').addClass("ui-widget-" + op.className +"-altMsg");
             */
            
            /**
             *小圖片 
             */
            var imgs = downDiv.find('img').addClass("ui-widget-" + op.className +"-smallPics");
            // Cache references end
            /**
             * 初始化第一次可移動的圖片
             */
            ele.data('index',0);
            ele.data('lastIndex',(imgs.size() - 1 ));



            /**
             *bidNow 
             */
            bidNow.mouseenter(function(){
                $(this).css("color","black");
            }).mouseleave(function() {
                $(this).css("color","white");
            }).on('click',function(){
                var link = $(this).prev().find('a').first();
                window.location.href = link.attr('href');
            });
            /**
             *小圖片 
             */
            imgs.each(function(index,value){
                $(this).data('index',index);
                $(this).data('positionRelative', parseInt(index/op.showPicsNumber));
            });
            imgs.on('click',function(){
                var index = $(this).data('index') ;
                ele.data('index',index);
                _this.move(op.moveLength, $(this).data('positionRelative') * op.showPicsNumber );
            });
            /**
             *小圖片to大圖片
             */
            ele.on('click',function(event){
                //var hightLight = 'ui-widget-slideshow-click';
                var hightLight = '';
                var index = ele.data('index');
                var clickImg = imgs.removeClass(hightLight).get(index);
                var img = $(clickImg).addClass(hightLight);
                bigImg.attr("src", img.attr("src"));
                bigImg.attr("alt", img.attr("alt"));
                msgDiv.empty().append(img.next().clone().css('display','block').addClass('ui-widget-slideshow-divMsg'));
            });
            /**
             *第一張圖片 
             */
            imgs.first().trigger('click');
            
            
            /**
             * Opacity
             */
            bigImgOpacity.css({
                "opacity" : op.opacity
            });
            bigImgDirection.css({
                "opacity" : op.opacity
            });
            /**
             *左右方向 
             */
            rightDirection.position({
                my: "left top",
                at: "right top",
                of: leftDirection
            });
            /**
             * timer 下一張圖片
             */
            var myTimer = _this._setIntervalWithContext(function() {
                //下一張圖片active
                _this.activeNextPic();
            }, op.timer, _this);
            bigImgDirection.on("mouseenter", function() {
                clearInterval(myTimer);
            }).on("mouseleave", function() {
                myTimer = _this._setIntervalWithContext(function() {
                                //下一張圖片active
                                _this.activeNextPic();
                            }, op.timer, _this);
            });




            leftDirection.on('click', function() {
                _this.activePrePic();
            });
            rightDirection.on('click', function() {
                _this.activeNextPic();
            });
        },
        activePrePic: function() {
            var index = this.element.data('index');
            var lastIndex = this.element.data('lastIndex');
            var showPicsNumber = this.options.showPicsNumber;
            var preIndex = ((index - 1) < 0 )? lastIndex : (index - 1);
            var preImg = this.element.find("li img").get(preIndex);
            $(preImg).trigger('click');
            
        },
        activeNextPic: function() {
            var index = this.element.data('index');
            var lastIndex = this.element.data('lastIndex');
            var showPicsNumber = this.options.showPicsNumber;
            var nextIndex = ((index + 1) > lastIndex )? 0 : (index + 1);
            var nextImg = this.element.find("li img").get(nextIndex);
            $(nextImg).trigger('click');
        },
        move: function(moveLength,positionRelative) {
            var imgs = this.element.find('li img');
            positionRelative = (imgs.size() - this.options.showPicsNumber ) < positionRelative ? (imgs.size() - this.options.showPicsNumber ) : positionRelative ; 
            imgs.css({
                "position" : "relative"
            }).animate({
                left : -(moveLength * positionRelative ) + "px"
            }, 500);
        },
        _setIntervalWithContext: function (code, delay, context) {
            return setInterval(function () {
                code.call(context);
            }, delay);
        },
        _destroy : function() {
            //TODO
        }
    });
})(jQuery); 