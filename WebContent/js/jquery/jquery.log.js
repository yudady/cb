;
// $.log( 'string' );
// $(select).log();
(function($) {
    $.log = function() {
        if (window.console && window.console.log && window.console.log.apply) {
            console.log.apply(window.console, arguments);
        }
    };
    $.fn.log = function() {
        return this.each(function(index, value) {
            $.log(value);
        });
    };
})(jQuery); 