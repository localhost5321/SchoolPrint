$(function() {
	// 将打印页面的导航高亮改变
	$("#navBarIndex").attr("class", "");
	$("#navBarIndex").children("a").attr("href", "index.jsp");
	$("#navBarPrint").attr("class", "active");
	$("#navBarPrint").children("a").attr("href", "print.jsp");

	var json = sessionStorage.getItem("order");
	console.log(json);
	var obj = JSON.parse(json);

	var addrList = sessionStorage.getItem("addrList");
	console.log(addrList);
	var addr = JSON.parse(addrList).data;
	$.each(addr, function(key, value) {
		addLi(value);
	});
	// 取出所有文件
	for (var i = 0; i < obj.data.docId.length; i++) {
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

function addLi(value) {
	var user_phone = value["callPhone"];
	var user_name = value["contactor"];
	var user_addr = value["sendAddress"];
	var is_default = value["isDefault"];
	if (is_default == 0) {
		$("#addr_ul")
				.append(
						"<li class='basic' >"
								+ "<span class='sendto'>送至</span>"
								+ " <label class='block'>"
								+ "<input type='radio' name='radgroup' value='A' class='addrInfo' style='margin-right: 10px;'>"
								+ user_addr
								+ "("
								+ user_name
								+ "收）"
								+ user_phone
								+ "</label>"
								+ " <span style='margin-left: 10px' id='setDefault'></span>"
								+ " <a  href='' style='float: right;'>修改本地址</a></li>");
	} else if (is_default == 1) {
		$("#addr_ul")
				.append(
						"<li class='basic addrSelect'>"
								+ "<span class='sendto'>送至</span>"
								+ " <label class='block'>"
								+ "<input type='radio' name='radgroup' value='A' class='addrInfo' style='margin-right: 10px;'>"
								+ user_addr
								+ "("
								+ user_name
								+ "收）"
								+ user_phone
								+ "</label>"
								+ " <span style='margin-left: 10px' id='setDefault'>默认地址</span>"
								+ " <a  href='' style='float: right;'>修改本地址</a></li>");
	}

}