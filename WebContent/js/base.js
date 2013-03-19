;$(function() {
	//$.log('base js');
	
	//TODO
	//$(".mainBody").corner();
	
    $(".mainBody").corner("30px");
    //$("#NewEmailSubBtn").corner('tr');
    
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
    /**
     *ie 
     */
    $(".content").position({
        my: "left+20 top+0",
        at: "right top",
        of: $("#menu")
    });
    
});





