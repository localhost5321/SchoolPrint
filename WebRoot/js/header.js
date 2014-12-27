function login(){
	var json = {};
	json.username = $("#loginUsername").val();
	json.password = $("#loginPassword").val();
	$.post("ajaxTest.action",  json, function(data){
		alert(data);
	});
}