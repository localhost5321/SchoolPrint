/**
 * 商家端历史订单js文件
 */

$(function() {
	
	// 将打印页面的导航高亮改变
	$("#navBarIndex_shop").attr("class", "");
	$("#navBarIndex_shop").children("a").attr("href", "index.jsp");
	$("#navBarOrderHistory_shop").attr("class", "active");
	$("#navBarOrderHistory_shop").children("a").attr("href", "");
	
});