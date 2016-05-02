$(function() {
	$.extend({
		getUrlVars : function() {
			var vars = [], hash;
			var hashes = window.location.href.slice(
					window.location.href.indexOf('?') + 1).split('&');
			for (var i = 0; i < hashes.length; i++) {
				hash = hashes[i].split('=');
				vars.push(hash[0]);
				vars[hash[0]] = hash[1];
			}
			return vars;
		},
		getUrlVar : function(name) {
			return $.getUrlVars()[name];
		}
	});
	// 将打印页面的导航高亮改变
	$("#navBarIndex").attr("class", "");
	$("#navBarIndex").children("a").attr("href", "index.jsp");
	$("#navBarPrint").attr("class", "active");
	$("#navBarPrint").children("a").attr("href", "print.jsp");

	// 得到店铺shopName
	var shopName = $.getUrlVar("shopName");
	$.ajax({
		url : "shop/getShopDetail.action",
		data : "shopName=" + shopName,
		success : function(response) {
			// 获取店铺详细信息
			var obj = JSON.parse(response);
			// 店铺名
			shopNick = obj.data.shopNick;
			$("title, h1.shopNick").text(shopNick);
			$("#make_sure").attr("href","make_sure.jsp?shopNick=" + escape(shopNick));
			// 店铺地址
			var shopAddr = obj.data.shopAddress;
			$("p.shopAddr").text("商家地址：" + shopAddr);
			// 店铺描述
			var shopDesc = obj.data.shopDesc;
			$("p.shopDesc").text("商家介绍：" + shopDesc);
		},
		type : "post"
	});

	var orderList = sessionStorage.getItem("orderList");
	// 请求订单价格表
	$.ajax({
		url : "showOrder.action",
		data : "data=" + orderList,
		success : function(response) {
			var obj = JSON.parse(response);
			var orderListObj = JSON.parse(orderList);
			// 如果用户没有选择文件，隐藏表格
			if (obj.data.docId.length == 0) {
				$(".orderDiv").hide();
			}
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
				//向订单列表添加钱数
				orderListObj.data[i].price = price;
				orderListObj.data[i].itemPrice = itemPrice;
			}

			$(".orderInfo").text("总价：" + obj.data.total + "元");
			//将含单价和总价的数据存储
			orderListObj.total = obj.data.total;
			console.log("orderListObj：" + orderListObj);
			sessionStorage.setItem("orderList", JSON.stringify(orderListObj));
		},
		type : "post",
	});
	
});
