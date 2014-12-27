/**
 * 店家控制中心，js脚本
 */

$(document).ready(function(){
	
	$("#btnSave").addClass("btnSaveHidden");
	
	$("#editInfo").click(function (e) {
		$("input[disabled]").removeAttr("disabled");
		$("#btnSave").addClass("btnSaveVisible");
	});
	
	$("#btnSave").click(function(e){
		//用户点击了保存
		
		alert("************");
	});
	
			
});