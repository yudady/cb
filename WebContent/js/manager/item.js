$(function() {

    /**
     *add html
     */
    function addHtml(obj) {
        var uploadPicsSize = $(".uploadPics").size();
        var imgSrc = cb.getSafeUrl() + '/pic/upload/item/' + obj.photoPath;
        var picId = obj.id || "";
        var html = '<li class="uploadPics">';
        html = html + '<span>Picture ' + uploadPicsSize + ' : </span>';
        html = html + '<input class="deleteBtn" type="button" value="delete" />';
        html = html + '<input type="hidden" value="' + picId + '" name="picIds[' + uploadPicsSize + ']">';
        html = html + '<span>order<input class="indexPriorities" type="text" name="priorities[' + uploadPicsSize + ']" value="' + uploadPicsSize + '" size="3" /></span>';
        if (obj.photoPath != '') {
            html = html + '<input type="hidden" name="oldPhotoPath[' + uploadPicsSize + ']" value="' + obj.photoPath + '" />';
            html = html + '<img src="' + imgSrc + '" />';
            html = html + '<input class="crud" type="hidden" value="r" name="cruds[' + uploadPicsSize + ']" />';
        } else {
            html = html + '<input type="hidden" name="oldPhotoPath[' + uploadPicsSize + ']" value="" />';
            html = html + '<img src="" />';
            html = html + '<input class="crud" type="hidden" value="c" name="cruds[' + uploadPicsSize + ']" />';
        }
        html = html + '<input class="uploadPicsFile" type="file" name="files[' + uploadPicsSize + ']" /> ';
        html = html + '</li>';

        return html;
    }

    var hrefSrc = window.location.href;
    if (hrefSrc.contains('update')) {
        $.ajax({
            type : "POST",
            url : cb.getSafeUrl('manager/pictures.do'),
            data : {
                itemId : $("#itemId").val()
            },
            dataType : "json",
            success : function(data) {
                $.each(data, function() {
                    $("#pics").append(addHtml(this));
                });
            }
        });
    }

    /**
     *刪除pic
     */
    $('#form1').on('click', '.deleteBtn', function() {
        var li = $(this).parent();
        var crudInput = li.find('.crud');
        var val = crudInput.val();
        if (val == 'r' || val == 'u') {
            crudInput.val('d');
        }
        if (val == 'c') {
            crudInput.val('');
        }
        li.hide();
    });

    /**
     *更新pic
     */
    $('#pics').on('click', '.uploadPicsFile', function() {
        var li = $(this).parent();
        var crudInput = li.find('.crud');
        var val = crudInput.val();
        if (val == 'r') {
            crudInput.val('u');
        }
        var img = li.find('img');
        img.attr('src', '');
    });
    /**
     *新增pic
     */
    $("#addPicBtn").on('click', function() {
        var target = $("#pics");
        target.append(addHtml({
            photoPath : ''
        }));
        return false;
    });

    $('.cleditor').cleditor();
});
