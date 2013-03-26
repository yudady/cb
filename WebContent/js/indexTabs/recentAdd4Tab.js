$(function(){
    $("a.tabUrl").on('click',function(event){
        window.parent.document.location = this.href;
        event.preventDefault();
        return false;
    });

    $(".item a").on('click', function(event) {
        window.parent.location.href = this.href;
        event.preventDefault();
    }); 
    $(".timeLeftTab4").timeLeft();
});