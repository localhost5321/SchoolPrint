function login(){
	var json = $("#loginForm").serialize()
	$.post("userLogin.action",  json, function(data){
		alert(data);
	});
}

function regist(){
	var json = $("#registForm").serialize()
	$.post("userRegist.action",  json, function(data){
		alert(data);
	});
}