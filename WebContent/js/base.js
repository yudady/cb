;$(function() {
	//$.log('base js');
	
	
	
    if($(".counter").height() < 350){
        $(".counter").height(350);
    }
    
    /**
     *調整位置for chrome 
     */
    $(".NewEmailSubBtn").position({
        my: "left top",
        at: "right top",
        of: $(".subscribeemails")
    });
    
});





