/**
 * 商家端主页js文件
 */
$(function() {
	
	/*$("#navBarIndex").attr("class", "");
	$("#navBarIndex").children("a").attr("href", "index.jsp");
	$("#navBarPrint").attr("class", "active");
	$("#navBarPrint").children("a").attr("href", "");*/

	
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

