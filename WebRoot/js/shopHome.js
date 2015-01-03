$(function() {
	// 将打印页面的导航高亮改变
	$("#navBarIndex").attr("class", "");
	$("#navBarIndex").children("a").attr("href", "index.jsp");
	$("#navBarPrint").attr("class", "active");
	$("#navBarPrint").children("a").attr("href", "print.jsp");

	var data = sessionStorage.getItem("order");
	var obj = JSON.parse(data);
	for (var i = 0; i < obj.data.length; i++) {
		var fileName = obj.data[i].fileName;
		var pageCounts = obj.data[i].pageCounts;
		var setting = obj.data[i].setting;
		var printCounts = obj.data[i].printCounts;
		$("#orderTable").append(
				"<tr><td>" + fileName + "</td><td>" + pageCounts + "</td><td>"
						+ setting + "</td><td>" + printCounts
						+ "</td><td></td><td></td></tr>");
	}
});