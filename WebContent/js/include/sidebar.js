$(function() {
    $("#sidebar").toggleClass("menuToggle").menu();
    //

    var availableTags = ["ActionScript", "AppleScript", "Asp", "BASIC", "C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang", "Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp", "Perl", "PHP", "Python", "Ruby", "Scala", "Scheme"];
    $("#rerun").button();

    $("#select").button({
        text : false,
        icons : {
            primary : "ui-icon-triangle-1-s"
        }
    }).position({
        my: "left top",
        at: "right top",
        of: $("#rerun")
    });
    $("#select").toggle(function() {
        $("#catcompleteDiv").show();
        $("#catcomplete").focus();
        $(this).button({
            icons : {
                primary : "ui-icon-triangle-1-n"
            }
        });
    }, function() {
        $("#catcompleteDiv").hide();
        $(this).button({
            icons : {
                primary : "ui-icon-triangle-1-s"
            }
        });
    });

    $("#catcomplete").on('blur', function() {
        $("#select").trigger('click');
        //TODO href
        $.log('do search data');

    });

    $("#catcomplete").autocomplete({
        delay : 0,
        source : availableTags
    });

});
