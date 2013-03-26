$(function() {
    //輪播
    $("#contentSlideshow").slideshow();
    $('#tabs4').tabs({
        beforeActivate: function( event, ui ) {
            $('#tabs4').block({
                theme: true, 
                css: { border: '3px solid #a00' }  
            }); 
        },
        load: function(event, ui) {
            $(ui.panel).on('click', 'a', function(event) {
                $(ui.panel).load(this.href);
                event.preventDefault();
            });
            $('#tabs4').unblock(); 
        }
    });
    
         /**
     *全局 unblock
    $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
     */
    
    
    
    
    $(".timeLeft").timeLeft({split:", ",style:"detail"});
    
    //======Auctions 分頁start
    function currentAuctions(){
        var num = $("#auctionsPager").data("num") ;
        
        if(num == 1){
            $('#prevPager').css({visibility:"hidden"});
        }else{
            $('#prevPager').css({visibility:"visible"});
        }
        
        if(num == $('.auctionsNum').size()){
            $('#nextPager').css({visibility:"hidden"});
        }else{
            $('#nextPager').css({visibility:"visible"});
        }
        
        
        var currentA = $('.auctionsNum').removeClass('auctionsActive').get(parseInt(num) -1);
        $(currentA).addClass('auctionsActive');
        
        var cou = $("#auctionsPageSize").val();
        var start = (parseInt(num) - 1) * cou;
        var end = start + cou ;
        $('.auction').hide().each(function(index,value){
            if(index >= start && index < end){
                $(this).show();
            }
        });
    }
    
    $('.auctionsNum').on('click',function(event){
        var num = $(this).text();
        $("#auctionsPager").data("num",num);
        currentAuctions();
        event.preventDefault();
    });
    
    $('#prevPager').on('click',function(event){
        var num = $("#auctionsPager").data("num");
        $("#auctionsPager").data("num",parseInt(num) -1);
        currentAuctions();
        event.preventDefault();
    });
    $('#nextPager').on('click',function(event){
        var num = $("#auctionsPager").data("num") || 1;
        $("#auctionsPager").data("num",parseInt(num) + 1);
        currentAuctions();
        event.preventDefault();
    });
    $('.auctionsNum').first().triggerHandler('click');
    //======Auctions 分頁end

    $(".mainBody").corner('top 30px');
    $(".indexTop").corner('top 20px');
    $("#sidebar").corner('top');
    $("#menu").corner();
    
});