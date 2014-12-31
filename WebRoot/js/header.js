var USERNAME="";
window.onload = function() {
	$("#registUsername").blur(preLogin);
	$("#registPassword").blur(preCheckPassword);
	$("#registPasswordAgain").blur(preCheckPasswordSame);
	$("#registPhone").blur(preCheckPhone);
	$("#registEmail").blur(preCheckEmail);
}

/**
 * 登陆
 */
function login() {
	var json = $("#loginForm").serialize();
	$.post("userLogin.action", json, function(data) {
		var obj = JSON.parse(data);
		if (obj.status == 1) {
			// 登陆成功
			USERNAME = $("#loginUsername");
			$("#navbarUserInfo").html(obj.message);
			$("#loginModal").modal("hide");
		} else {
			// 登陆失败
			$("#loginInfo").text(obj.message);
		}
	});
}

/**
 * 注册
 */
function regist() {
	if (!(preLogin() && preCheckPassword() && preCheckPasswordSame()
			&& preCheckPhone() && preCheckEmail())) {
		return;
	}
	var json = $("#registForm").serialize();
	$.post("userRegist.action", json, function(data) {
		var obj = JSON.parse(data);
		if (obj.status == 1) {
			// 注册成功
			USERNAME = $("#loginUsername");
			$("#navbarUserInfo").html(obj.message);
			$("#registerModal").modal("hide");
		}
	});
}

/**
 * 退出登陆
 */
function exit() {
	$.post("userExit.action", function(data) {
		location.reload();
	});
}

/**
 * 验证用户名
 * 
 * @returns {Boolean}
 */
function preLogin() {
	var flag = true;
	var username = $("#registUsername").val();
	// 用户名验证
	$("#registUsernameIcon").removeClass();
	$("#registUsernameDiv").removeClass();
	$("#registUsernameIcon").hide();
	$("#registUsernameInfo").hide();

	// 用户名长度过小
	if (username.length < 6) {
		$("#registUsernameDiv").addClass("form-group has-error has-feedback");
		$("#registUsernameInfo").show();
		$("#registUsernameInfo").text("用户名不能少于6位");
		$("#registUsernameIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registUsernameIcon").show();
		return false;
	}

	// 用户名长度过长
	if (username.length > 12) {
		$("#registUsernameDiv").addClass("form-group has-error has-feedback");
		$("#registUsernameInfo").show();
		$("#registUsernameInfo").text("用户名不能超过12位");
		$("#registUsernameIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registUsernameIcon").show();
		return false;
	}
	
	// 符合正确格式
	$("#registUsernameDiv").addClass("form-group has-success has-feedback");
	$("#registUsernameIcon").addClass(
			"glyphicon glyphicon-ok form-control-feedback");
	$("#registUsernameIcon").show();
	$("#registUsernameInfo").hide();

	// 判断用户名是否存在
	$.ajax({
		type : "post",
		url : "verifyUserName.action",
		data : "userName=" + username,
		async : true,
		success : function(data) {
			var obj = JSON.parse(data);
			if (obj.status != 1) {
				// 用户名已存在
				$("#registUsernameDiv").addClass(
						"form-group has-error has-feedback");
				$("#registUsernameInfo").show();
				$("#registUsernameInfo").text(obj.message);
				$("#registUsernameIcon").addClass(
						"glyphicon glyphicon-remove form-control-feedback");
				$("#registUsernameIcon").show();
				flag = false;
			}
		}
	});
	
	return flag;
}

/**
 * 验证密码
 * 
 * @returns {Boolean}
 */
function preCheckPassword() {
	var password = $("#registPassword").val();
	// 密码验证
	$("#registPasswordIcon").removeClass();
	$("#registPasswordDiv").removeClass();
	$("#registPasswordIcon").hide();
	$("#registPasswordInfo").hide();

	// 密码长度过小
	if (password.length < 6) {
		$("#registPasswordDiv").addClass("form-group has-error has-feedback");
		$("#registPasswordInfo").show();
		$("#registPasswordInfo").text("密码不能少于6位");
		$("#registPasswordIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registPasswordIcon").show();
		return false;
	}

	// 密码长度过长
	if (password.length > 18) {
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
	return true;
}

/**
 * 验证两次输入密码是否相同
 * 
 * @returns {Boolean}
 */
function preCheckPasswordSame() {
	var passwordAgain = $("#registPasswordAgain").val();
	$("#registPasswordAgainIcon").removeClass();
	$("#registPasswordAgainDiv").removeClass();
	$("#registPasswordAgainIcon").hide();
	$("#registPasswordAgainInfo").hide();

	// 密码长度过小
	if (passwordAgain.length < 6) {
		$("#registPasswordAgainDiv").addClass("form-group has-error has-feedback");
		$("#registPasswordAgainInfo").show();
		$("#registPasswordAgainInfo").text("密码不能少于6位");
		$("#registPasswordAgainIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registPasswordAgainIcon").show();
		return false;
	}
	
	// 两次输入密码不一致
	if (passwordAgain != $("#registPassword").val()) {
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
	return true;
}

/**
 * 验证手机号码格式
 */
function preCheckPhone() {
	var phone = $("#registPhone").val();
	$("#registPhoneIcon").removeClass();
	$("#registPhoneDiv").removeClass();
	$("#registPhoneIcon").hide();
	$("#registPhoneInfo").hide();
	var patrn = /^1[0-9]{10}$/;
	if (!patrn.exec(phone)) {
		$("#registPhoneDiv").addClass("form-group has-error has-feedback");
		$("#registPhoneInfo").show();
		$("#registPhoneInfo").text("请输入正确手机号");
		$("#registPhoneIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registPhoneIcon").show();
		return false;
	}

	// 符合正确格式
	$("#registPhoneDiv").addClass("form-group has-success has-feedback");
	$("#registPhoneIcon").addClass(
			"glyphicon glyphicon-ok form-control-feedback");
	$("#registPhoneIcon").show();
	$("#registPhoneInfo").hide();
	return true;
}

/**
 * 验证邮箱格式
 */
function preCheckEmail() {
	var flag = true;
	var email = $("#registEmail").val();
	$("#registEmailIcon").removeClass();
	$("#registEmailDiv").removeClass();
	$("#registEmailIcon").hide();
	$("#registEmailInfo").hide();
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!filter.test(email)) {
		$("#registEmailDiv").addClass("form-group has-error has-feedback");
		$("#registEmailInfo").show();
		$("#registEmailInfo").text("邮箱格式有误");
		$("#registEmailIcon").addClass(
				"glyphicon glyphicon-remove form-control-feedback");
		$("#registEmailIcon").show();
		return false;
	}
	
	// 符合正确格式
	$("#registEmailDiv").addClass("form-group has-success has-feedback");
	$("#registEmailIcon").addClass(
			"glyphicon glyphicon-ok form-control-feedback");
	$("#registEmailIcon").show();
	$("#registEmailInfo").hide();
	
	// 判断邮箱是否被注册
	$.ajax({
		type : "post",
		url : "verifyEmail.action",
		data : "email=" + email,
		async : true,
		success : function(data) {
			var obj = JSON.parse(data);
			if (obj.status != 1) {
				// 邮箱已被注册
				$("#registEmailDiv").addClass(
						"form-group has-error has-feedback");
				$("#registEmailInfo").show();
				$("#registEmailInfo").text(obj.message);
				$("#registEmailIcon").addClass(
						"glyphicon glyphicon-remove form-control-feedback");
				$("#registEmailIcon").show();
				flag = false;
			}
		}
	});
	
	return flag;
}