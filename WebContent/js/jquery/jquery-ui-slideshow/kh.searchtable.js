(function($){
	$.widget("kh.searchtable",{
		//1、options
		options:{
			className:"standard",
			baseCss:"ui-widget-searchtable",
			width:null,
			height:null,
			thead:[{title:"",content:""}]
		},
		getData:function(){
			ajaxData();
		},
		_create:function(){
			opt = this.options;
			ele = this.element;
			bc = opt.baseCss;
			dc = opt.className;
			ele.addClass(bc+"-"+dc);
			if(opt.width) {
				ele.width(opt.width);
			}
			if(opt.height) {
				ele.find("tr").height(opt.height);
			}
			ele.find("thead tr").addClass(bc+"-header-"+dc);
			ele.find("tbody tr:odd").addClass(bc+"-odd-"+dc);
			ele.find("tbody tr").on("mouseenter.st mouseleave.st",function(event){
				$(this).toggleClass(bc+"-hover-"+dc);
			});
			this._initSearchInput();
		},
		_initSearchInput:function(){
			ele.find("thead").prepend("<tr><td colspan='"+ele.find("thead tr td").length+"'>输入搜索字段:<input type='text' id='table-search'/></td></tr>")
			this._bindSearch();
			
		},
		_bindSearch:function() {
			var that = this;
			ele.find("#table-search").on("blur",function(event){
				if($(this).val()) {
					that.element.find("tbody td").removeClass().filter(":contains('"+$(this).val()+"')")
							.addClass(bc+"-find-"+dc);	
				}
				
			});
		},
		_searchText:function(event) {
			//此时this已经是事件对象了，就没有this.element
			ele.find();
		},
		_destroy:function(){
			ele.removeClass();
			ele.find("tr").removeClass();
			ele.find("td").removeClass();
			ele.find("thead tr:eq(0)").remove();
			ele.find("tbody tr").off(".st");
			ele.css("width","");
			ele.find("tr").css("height","");
		}
	});
})(jQuery);