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
    
    
    //以下是頁面資訊=============================================
    $("#itemTabs").tabs();
    var a = $(".counterLeft").height();
    var b = $(".counterRight").height();
    var hei = (a > b)? a : b ;
    $('.counterLeft,.counterRight').height(hei);
    
    
    $(".mainBody").corner('top 30px');
    $(".counterLeft").corner('tl 20px');
    $(".counterRight,.auction").corner('tr 20px');
});