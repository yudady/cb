$(function(){
    var loc = window.location.href ;
    
    if(loc.search("displayClosed") > 0){
        $("#ftr-displayClosed").prop("checked",true);
        $('.bidNow').hide();
    }else{
        $('.lotClosed').hide();
        $("#ftr-displayClosed").prop("checked",false);
    }
    
     //action="displayClosed.do"
    $("#ftr-displayClosed").on('click',function(event){
        var src = window.location.href  ;
        src = src.replace("?displayClosed=true","");
        var _this = $(this);
        if(_this.prop("checked")){
            window.location.href = src + "?displayClosed=true";
        }else{
            window.location.href = src + "";
        }
        event.preventDefault();
        event.stopPropagation();
    });
});