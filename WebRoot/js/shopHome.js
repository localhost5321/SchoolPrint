$(function() {
	// 将打印页面的导航高亮改变
	$("#navBarIndex").attr("class", "");
	$("#navBarIndex").children("a").attr("href", "index.jsp");
	$("#navBarPrint").attr("class", "active");
	$("#navBarPrint").children("a").attr("href", "print.jsp");

	var json = sessionStorage.getItem("order");
	var obj = JSON.parse(json);
	for (var i = 0; i < obj.data.docId.length; i++) {
		var fileName = obj.data.fileName[i];
		var pageCounts = obj.data.pageCount[i];
		var setting = obj.data.printRequire[i];
		var printCounts = obj.data.fileCount[i];
		var price= obj.data.price[i];
		var itemPrice = obj.data.itemPrice[i];
		$("#orderTable").append(
				"<tr><td>" + fileName + "</td><td>" + pageCounts + "</td><td>"
						+ setting + "</td><td>" + printCounts
						+ "</td><td>"+price+"</td><td>"+itemPrice+"</td></tr>");
	}
	
	$(".orderInfo").text("总价：" + obj.data.total + "元");
});