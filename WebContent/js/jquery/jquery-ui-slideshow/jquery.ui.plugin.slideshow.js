(function($) {
    "use strict";
    //常量
    var active = "move-activity";
    var moveLength = 0;
    

    $.widget("ui.slideshow", {
        //1、options
        options : {
            className : "slideshow",
            opacity : 0.4,
            timer : 10000,
            showPicsNumber : 8
        },
        _create : function() {
            // this.element -- a jQuery object of the element the widget was invoked on.
            // this.options --  the merged options hash
            var op = this.options;
            var ele = this.element.addClass( "ui-widget-" + op.className );
            // Cache references to collections the widget needs to access regularly
            /**
             *2個div 
             */
            var partsDiv = this.element.children();
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
            var bigImgMsg = bigImg.prev().addClass("ui-widget-" + op.className +"-picMsg");
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
            var bidNow = bigImgMsg.find('input').addClass("ui-widget-" + op.className +"-bidNow");;
            /**
             * 大圖片上方文字
             */
            var altMsg = bigImgMsg.find('span').addClass("ui-widget-" + op.className +"-altMsg");;
            
            /**
             *小圖片 
             */
            var imgs = downDiv.find('img').addClass("ui-widget-" + op.className +"-smallPics");
            // Cache references end
            /**
             * 初始化第一次可移動的圖片
             */
            var showPicsNumber = (op.showPicsNumber <= imgs.size()) ? op.showPicsNumber : imgs.size();
            this._addMoveActivity(imgs,0, showPicsNumber);


            /**
             *小圖片 
             */
            imgs.each(function(index,value){
                $(this).data('index',index);
            });
            /**
             *第一小圖片to大圖片
             */
            bigImg.attr("src", imgs.first().attr("src"));
            bigImg.attr("alt", imgs.first().attr("alt"));
            imgs.first().addClass("ui-widget-" + op.className +"-click");
            //$.log(this);
            /**
             * Opacity
             */
            bigImgMsg.css({
                "opacity" : op.opacity
            });
            bigImgDirection.css({
                "opacity" : op.opacity
            });
            /**
             *小圖片點擊事件 
             *當小圖形click大圖形change
             */
            imgs.on('click',this.element,function(){
                imgs.removeClass("ui-widget-" + op.className +"-click");
                $(this).addClass("ui-widget-" + op.className +"-click");
                bigImg.attr("src", $(this).attr("src"));
                bigImg.attr("alt", $(this).attr("alt"));
            })
            
            /**
             * timer 下一張圖片
             */
            var myTimer = this._setIntervalWithContext(function() {
                //下一張圖片active
                this.activeNextPic(op);
            }, op.timer, this);
            /**
             *暫停 
             */
            bigImgDirection.on("mouseenter", function() {
                $.log('mouseenter');
                clearInterval(myTimer);
            }).on("mouseleave", function() {
                $.log('mouseleave');
                myTimer = this._setIntervalWithContext(function() {
                    //下一張圖片active
                    this.activeNextPic(op);
                }, op.timer, this);
            });

            /**
             * 
             */
            $("#left").on("click",this.activePrePic);
            $("#right").on("click",this.activeNextPic);
            

        },
        _setIntervalWithContext: function (code, delay, context) {
            return setInterval(function () {
                code.call(context);
            }, delay);
        },
        activePrePic: function(op) {
            var cl = "ui-widget-" + op.className +"-click";
            var p = $("." + cl).removeClass(cl);
            var q = p.parent().prev().find("."+active);
            if (q.size() > 0) {
                q.addClass(cl);
            } else {
                $("."+active).removeClass(cl);
                $("."+active).last().addClass(cl);
            }
            // 觸發小圖形click
            $("."+cl).trigger('click');
        },
        activeNextPic: function(op) {
            var cl = "ui-widget-" + op.className +"-click";
            var p = $("." + cl).removeClass(cl);
            var q = p.parent().next().find("."+active);
            if (q.size() > 0) {
                q.addClass(cl);
            } else {
                $("."+active).removeClass(cl);
                $("."+active).first().addClass(cl);
            }
            // 觸發小圖形click
            $("."+cl).trigger('click');
        },
        _addMoveActivity: function(imgs,start, end) {
            $("."+active).removeClass(active);
            imgs.each(function(i, value) {
                if (i < end && i >= start) {
                    $(this).addClass(active);
                }
            });
        },
        _destroy : function() {
        }
    });
})(jQuery); 