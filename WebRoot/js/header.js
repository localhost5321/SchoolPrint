window.onload = function() {
	$("#registUsername").blur(preLogin);
	$("#registPassword").blur(preCheckPassword);
	$("#registPasswordAgain").blur(preCheckPasswordSame);
}

/**
 * 登陆
 */
function login() {
	var json = $("#loginForm").serialize();
	$.post("userLogin.action", json, function(data) {
		var obj = JSON.parse(data)
		if(obj.status == 1){
			//登陆成功
			location.reload();   
		}
	});
}

/**
 * 注册
 */
function regist() {
	var json = $("#registForm").serialize();
	$.post("userRegist.action", json, function(data) {
		if(obj.status == 1){
			//注册成功
			location.reload(); 
		}
	});
}

/**
 * 退出登陆
 */
function exit() {
	$.post("userExit.action",function(data) {
			location.reload();   
	});
}

/**
 * 验证用户名
 * @returns {Boolean}
 */
function preLogin() {
	// 用户名验证
	$("#registUsernameIcon").removeClass();
	$("#registUsernameDiv").removeClass();
	$("#registUsernameIcon").hide();
	$("#registUsernameInfo").hide();

	// 用户名长度过小
	if ($(this).val().length < 6) {
		$("#registUsernameDiv").addClass("form-group has-error has-feedback");
		$("#registUsernameInfo").show();
		$("#registUsernameInfo").text("用户名不能少于6位");
		$("#registUsernameIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registUsernameIcon").show();
		return false;
	}

	// 用户名长度过长
	if ($(this).val().length > 12) {
		$("#registUsernameDiv").addClass("form-group has-error has-feedback");
		$("#registUsernameInfo").show();
		$("#registUsernameInfo").text("用户名不能超过12位");
		$("#registUsernameIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registUsernameIcon").show();
		return false;
	}

	$.post("verifyUserName.action", $(this).val(), function(data) {
		var obj = JSON.parse(data);
		alert(obj.status);
		if(obj.status == 1){
			//注册成功
			location.reload(); 
		}else{
			$("#registUsernameDiv").addClass("form-group has-error has-feedback");
			$("#registUsernameInfo").show();
			$("#registUsernameInfo").text(obj.message);
			$("#registUsernameIcon").addClass(
					"glyphicon glyphicon-remove form-control-feedback");
			$("#registUsernameIcon").show();
		}
	});
	
	// 符合正确格式
	$("#registUsernameDiv").addClass("form-group has-success has-feedback");
	$("#registUsernameIcon").addClass(
			"glyphicon glyphicon-ok form-control-feedback");
	$("#registUsernameIcon").show();
	$("#registUsernameInfo").hide();
}

/**
 * 验证密码
 * @returns {Boolean}
 */
function preCheckPassword() {
	// 密码验证
	$("#registPasswordIcon").removeClass();
	$("#registPasswordDiv").removeClass();
	$("#registPasswordIcon").hide();
	$("#registPasswordInfo").hide();

	// 密码长度过小
	if ($(this).val().length < 6) {
		$("#registPasswordDiv").addClass("form-group has-error has-feedback");
		$("#registPasswordInfo").show();
		$("#registPasswordInfo").text("密码不能少于6位");
		$("#registPasswordIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registPasswordIcon").show();
		return false;
	}

	// 密码长度过长
	if ($(this).val().length > 18) {
		$("#registPasswordDiv").addClass("form-group has-error has-feedback");
		$("#registPasswordInfo").show();
		$("#registPasswordInfo").text("密码不能超过18位");
		$("#registPasswordIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registPasswordIcon").show();
		return false;
	}

	// 符合正确格式
	$("#registPasswordDiv").addClass("form-group has-success has-feedback");
	$("#registPasswordIcon").addClass(
			"glyphicon glyphicon-ok form-control-feedback");
	$("#registPasswordIcon").show();
	$("#registPasswordInfo").hide();
}

/**
 * 验证两次输入密码是否相同
 * @returns {Boolean}
 */
function preCheckPasswordSame() {
	// 确认密码验证
	$("#registPasswordAgainIcon").removeClass();
	$("#registPasswordAgainDiv").removeClass();
	$("#registPasswordAgainIcon").hide();
	$("#registPasswordAgainInfo").hide();

	// 两次输入密码不一致
	if ($(this).val() != $("#registPassword").val()) {
		$("#registPasswordAgainDiv").addClass(
				"form-group has-error has-feedback");
		$("#registPasswordAgainInfo").show();
		$("#registPasswordAgainInfo").text("两次输入密码不一致");
		$("#registPasswordAgainIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registPasswordAgainIcon").show();
		return false;
	}

	// 符合正确格式
	$("#registPasswordAgainDiv")
			.addClass("form-group has-success has-feedback");
	$("#registPasswordAgainIcon").addClass(
			"glyphicon glyphicon-ok form-control-feedback");
	$("#registPasswordAgainIcon").show();
	$("#registPasswordAgainInfo").hide();
}