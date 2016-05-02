/**
 * 商家端历史端历史订单页面js文件
 */

$(function() {
	
	$("#order_details").click(
			
		    function() {
		    	var value = $(this).text();
		    	if(value == "订单详情"){
		    		$("#details_ul").show();
		    		//$("#details_ul").css("display","block");
			    	$(this).text("收起>>");
		    	}else{
		    		$("#details_ul").hide();
		    		//$("#details_ul").css("display","none");
		    		$(this).text("订单详情");
		    	}
			}
		);
	
});