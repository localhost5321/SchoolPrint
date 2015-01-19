$(function() {
	// 将打印页面的导航高亮改变
	$("#navBarIndex").attr("class", "");
	$("#navBarIndex").children("a").attr("href", "index.jsp");
	$("#navBarPrint").attr("class", "active");
	$("#navBarPrint").children("a").attr("href", "print.jsp");

	var json = sessionStorage.getItem("order");
	console.log(json);
	var obj = JSON.parse(json);
	// 如果用户没有选择文件，隐藏表格
	if (obj.data.docId.length == 0) {
		$(".orderDiv").hide();
	}
	// 取出所有文件
	for ( var i = 0; i < obj.data.docId.length; i++) {
		var fileName = obj.data.fileName[i];
		var pageCounts = obj.data.pageCount[i];
		var setting = obj.data.printRequire[i];
		var printCounts = obj.data.fileCount[i];
		var price = obj.data.price[i];
		var itemPrice = obj.data.itemPrice[i];
		$("#orderTable").append(
				"<tr><td>" + fileName + "</td><td>" + pageCounts + "</td><td>"
						+ setting + "</td><td>" + printCounts + "</td><td>"
						+ price + "</td><td>" + itemPrice + "</td></tr>");
	}

	$(".orderInfo").text("总价：" + obj.data.total + "元");
});

function make_sure_order() {
	// 保存当前最新的文件列表

	// 请求地址并保存
	$.post("getAllAddress.action", function(json_data) {
		console.log(json_data);
		var json = JSON.parse(json_data);
		sessionStorage.setItem("addrList", json_data);
	});
	// 保存店铺名
	location.href = "make_sure.jsp";
}