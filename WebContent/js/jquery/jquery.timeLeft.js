;
(function($) {
    $.fn.timeLeft = function(options) {
        var opt = {
            split:"",
            style:"simple"
        }
        $.extend(opt,options||{});
        
        return this.each(function(index, value) {
            var $this = $(this);
            var longValue = parseInt($this.text());
            var now = new Date();
            var diffTime = (longValue - now.getTime()) / (1000 * 24 * 60 * 60);
            var diffDate = parseInt(diffTime);
            var diffHr = ( diffTime - diffDate ) * 24 ;
            var diffMin = (diffHr - parseInt(diffHr)) * 60;
            /**
             * Time Left : 12days, 13hrs, 59 min 
             */
            var textValue = "Time Left : ";
            if(opt.style == "detail"){
                if(diffDate > 0){
                    textValue = textValue + diffDate + "days" + opt.split ;
                }
                if(parseInt(diffHr) > 0){
                    textValue = textValue + parseInt(diffHr) + "hrs" + opt.split ;
                }
                if(parseInt(diffMin) > 0){
                    textValue = textValue + parseInt(diffMin) + " min";
                }
            }else if (opt.style == "simple"){
                if(diffDate > 0){
                    if(diffDate == 1){
                        textValue = textValue + "a day from now";
                    }else {
                        textValue = textValue + diffDate + " days from now";
                    }
                }else if(parseInt(diffHr) > 0){
                    textValue = textValue + "about " + parseInt(diffHr) + " hours from now";
                }
            }

            $this.text(textValue);
        });
    };
})(jQuery); 