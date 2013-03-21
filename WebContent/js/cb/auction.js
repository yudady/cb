$(function(){
    $("#auctionLists").tabs();
    
    $('#tabs4').tabs({
        load: function(event, ui) {
            $(ui.panel).on('click', 'a', function(event) {
                $(ui.panel).load(this.href);
                event.preventDefault();
            });
        }
    });
    $(".mainBody").corner('top 30px');
    $(".counterLeft").corner('tl 20px');
    $("#sidebar").corner('top');
    $("#menu").corner();
});