var picCount = 0;

function addPic(index, priority, crud, picId, src) {
    picId = picId || '';
    var html = "";
    html = html + '<li class="picture">';
    html = html + '<div>';
    html = html + '<span>Picture ' + index + ' : </span>';
    html = html + '<input type="hidden" name="picIds[' + index + ']" value="' + picId + '" />';
    html = html + '<input type="button" class="deleteBtn" value="delete" />';
    html = html + '<input type="hidden" name="cruds[' + index + ']" value="' + crud + '" />';
    html = html + '<input type="text" class="indexPriorities" name="priorities[' + index + ']" value="' + priority + '" />';
    html = html + '<input type="file" name="files[' + index + ']" />';
    if (src) {
        html = html + '<img src=' + src + ' />';
    }
    html = html + '<div>';
    html = html + '</li>';
    $("#content ul").append(html);
    picCount = picCount + 1;
}



;$(function() {
		
		$(".indexPriorities").on('change',function(){
			var crudInput = $(this).prev();
			if(crudInput.val() == 'r'){
				crudInput.val('u');
			}
		});
		$(".picture input[type='file']").on('change',function(){
			$(this).next().remove();
			var crudInput = $(this).prev().prev();
			if(crudInput.val() == 'r'){
				crudInput.val('u');
			}
		});
		$("#addPicBtn").on('click',function(){
			addPic(picCount,picCount,'c');
		});
		
		$("#content ul").on('click','.deleteBtn',function(){
			$(this).parent().parent().hide();
			var crudInput = $(this).next();
			if(crudInput.val() == 'r'){
				crudInput.val('d');
			}else if(crudInput.val() == 'u'){
				crudInput.val('d');
			}else if(crudInput.val() == 'c'){
				$(this).parent().parent().remove();
			}
		});
		
});





