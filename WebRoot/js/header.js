function login(){
	var json = $("#loginForm").serialize();
	$.post("userLogin.action",  json, function(data){
		var obj = eval(data);
		alert(obj.status);
	});
}

function regist(){
	var json = $("#registForm").serialize();
	$.post("userRegist.action",  json, function(data){
		alert(data);
	});
}

function exit(){
	$.post("userExit.action");
}
