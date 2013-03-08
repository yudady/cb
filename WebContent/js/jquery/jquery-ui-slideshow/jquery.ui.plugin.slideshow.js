(function($){
    $.widget("ui.slideshow",{
        //1、options
        options:{
            className:"standard"
        },
        _setOption: function( key, value ) {
            switch( key ) {
                case "className":
                    break;
            }
            // and call the parent function too!
            return this._superApply( arguments );
        },
        _create:function(){
            var si = 8;
            var moviePic = 8;
            var positionRelative = 0;
            var moveLength = 94;
            //(70 + 10 + 10 + 2 + 2).slideshow-button img
        
            var imgs = $(".slideshow-button img");
        
            si = (si <= imgs.size()) ? si : imgs.size();
        
            /**
             *第一章圖片
             */
            $(".slideshow-top img").attr("src", imgs.first().attr("src"));
            $(".slideshow-top img").attr("alt", imgs.first().attr("alt"));
            imgs.first().addClass("slideshow-button-click");
            addMoveActivity(0, si);
            function addMoveActivity(start, end) {
                $(".move-activity").removeClass("move-activity");
                imgs.each(function(i, value) {
                    if (i < end && i >= start) {
                        $(this).addClass("move-activity");
                    }
                });
            }
        
        
            $(".slideshow-button").on("click", ".move-activity", function(event) {
                $(".slideshow-button-click").removeClass("slideshow-button-click");
                $(this).addClass("slideshow-button-click");
                topPicChange(this);
                event.preventDefault();
            });
        
            $(".slideshow-top .picMsg").css({
                "opacity" : "0.4"
            });
            $(".slideshow-top .direction").css({
                "opacity" : "0.4"
            });
        },
        _destroy:function(){
        }
    });
})(jQuery);