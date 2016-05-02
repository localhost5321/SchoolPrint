/**
 * 店家控制中心，js脚本
 */

$(document).ready(function(){
	
	$("#btnSave").addClass("btnSaveHidden");
	$(".modal-body>div").addClass("form-group"); 
	$(".modal-body div div").addClass("col-sm-10"); 
	$(".modal-body div div input").addClass("form-control"); 
	$(".modal-body div div input").attr("disabled","disabled"); 
	$(".modal-body div label").addClass("col-sm-2 control-label"); 
	
	
	$("#editInfo").click(function (e) {
		$("input[disabled]").removeAttr("disabled");
		$("#btnSave").addClass("btnSaveVisible");
	});
	
	$("#btnSave").click(function(e){
		//用户点击了保存
		
		alert("************");
	});
	
			
});