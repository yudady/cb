(function($) {
    /**
     * 計算長度
     * @param {Object} str
     * @param {Object} options
     */
    function fixedTopicWidth(str, options) {
        var setting = $.extend({
            length : 25,
            fill : '.',
            fillLength : 3
        }, options || {})
        //(abcddddddddddddddddd,12,".")-->(abcdddddd...)
        var pos = setting.length - str.length;
        if (pos > 0) {
            return str;
        } else {
            if (setting.fill) {
                var fs = "";
                for (var i = 0; i < setting.fillLength; i++) {
                    fs = fs + setting.fill;
                }
                return (str.substr(0, setting.length - 3) + fs);
            } else {
                return str.substr(0, setting.length);
            }
        }
    };
    /**
     * 把文本縮短
     * @param {Object} options
     */
    $.fn.formatShortHtml = function(options) {
        this.each(function() {
            $(this).html(fixedTopicWidth($(this).html(), options));
        });
    }
})(jQuery)
