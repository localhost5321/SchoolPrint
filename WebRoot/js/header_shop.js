/**
 *
 */

/**
 * 登陆
 */
function login() {
	var json = $("#loginForm").serialize();
	$.post("shopLogin.action", json, function(data) {
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