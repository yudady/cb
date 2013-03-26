;$(function() {
    
    
     /**
     *全局 unblock
     */
    //$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
    
    $("#loginBtn").click(function(){
        
        $("#loginForm").dialog({ 
            resizable: false,
            position: { of: $( "#loginBtn" ) , my: "center top", at: "left bottom"  },
            draggable: false,
            height: 300,
            width:400,
            title: "Account Login"
        
        });
    });
    
    $("#loginFormBtn").on('click',function(){
        $("#url").val(window.location.href);
        var form = $("#loginForm");
        var url = form.attr('action');
        $.ajax({
            type : "POST",
            url : url,
            data : form.serialize(), 
            success : function(data) {
                if(data.success){
                    window.location.reload(true);
                }else{
                    cb.openAlertDialog(data.msg);
                }
            }
        });
        return false;
    });

    $("#loginOutFormBtn").on('click', function() {
        $("#url").val(window.location.href);
        var form = $("#loginOutForm");
        var url = form.attr('action');
        $.ajax({
            type : "POST",
            url : url,
            data : form.serialize(), 
            success : function(data) {
                if(data.success){
                    window.location.reload(true);
                }else{
                    cb.openAlertDialog(data.msg);
                }
            }
        });
        return false;
    });

    $("#emailsubscribe input.subscribeemails").on('focusin', function() {
        $(this).val('');
    });
    $("#searchItem a").on('click', function(event) {
        $("#searchItem").submit();
        event.preventDefault();
    });
    /**
     *調整位置for chrome 
     */
    $(".NewEmailSubBtn").position({
        my: "left top",
        at: "right top",
        of: $(".subscribeemails")
    });

});





