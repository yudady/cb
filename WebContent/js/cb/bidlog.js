$(function() {
    $("#returnToItem").on('click', function() {
        var loc=window.location.href;
        loc=loc.replace("/bidlog.do","/index.do");
        window.location.href=loc;
    });
});