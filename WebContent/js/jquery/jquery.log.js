;
// $.log( xxxxxxxxxxxxxxxxxx );
(function(a) {
	a.log = function() {
		if (window.console && window.console.log && window.console.log.apply) {
			console.log.apply(window.console, arguments);
		}
	};
	a.fn.log = function() {
		a.log(this);
		return this;
	};
})(jQuery);