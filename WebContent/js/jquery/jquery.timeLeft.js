;
(function($) {
    $.fn.timeLeft = function() {
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
            if(diffDate > 0){
                textValue = textValue + diffDate + "days, ";
            }
            if(parseInt(diffHr) > 0){
                textValue = textValue + parseInt(diffHr) + "hrs, ";
            }
            if(parseInt(diffMin) > 0){
                textValue = textValue + parseInt(diffMin) + " min";
            }
            $this.text(textValue);
        });
    };
})(jQuery); 