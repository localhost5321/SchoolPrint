var USER_ID;

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

function changeSelect(li_this) {
	// 将所有的条目设为未选状态+设为默认地址
	$("#addr_ul>li").removeClass();
	$("#addr_ul>li").addClass("basic");
	$(".setDefault").html("设为默认地址");
	$(".setDefault").attr("onclick", "setDefaultAddr(this)");

	// 将当前条目设为高亮状态+默认地址提示
	$(li_this).addClass("basic addrSelect");
	$(li_this).children(".setDefault").removeAttr("onclick");
	$(li_this).children(".setDefault").html("默认地址");
}

function setDefaultAddr(span_this) {
	// 请求服务器，更改默认地址
	$(".setDefault").html("设为默认地址");
	$(".setDefault").attr("onclick", "setDefaultAddr(this)");
	$(span_this).removeAttr("onclick");
	$(span_this).html("默认地址");

}

function addAddrInfo() {

	var contactor = $("#newUserName").val();
	var sendAddress = $("#newAddrInfo").val();
	var callPhone = $("#newPhone").val();
	var secPhone = $("#newSecPhone").val();
	if(USER_ID)
	
	$
			.post(
					"addOrUpdateAddressinfo?=contactor" + contactor
							+ "&sendAddress=" + sendAddress + "&callPhone="
							+ callPhone + "&secPhone=" + secPhone,

					function(data) {
						console.log(data);
						var obj = JSON.parse(data);
						if (obj.status == 1) {
							// 添加成功，局部更新界面
							var fileName = obj.data["fileName"];
							var fileId = obj.data["fileId"];
							$("#plusFile")
									.before(
											"<div class='col-xs-6 col-lg-4 teatile'><h2 id="
													+ fileId
													+ ">"
													+ fileName
													+ "</h2><p>"
													+ chapter_des
													+ "</p><p><a href='javascript:void(0)' class='btn btn-default viewdetail' role='button' onclick='viewDetail(this)'>查看详情&raquo;</a>"
													+ "&nbsp<a href='javascript:void(0)' class='btn btn-default btn-danger deleteTile' role='button' onclick='deleteTile(this)'>删除 &raquo;</a>"
													+ "</p></div>");
							$("#addFile").modal("hide");
						} else {
							// 添加失败
							$("#addFileInfo").text(obj.message);
						}
					});

}

function addLi(value) {
	var user_phone = value["callPhone"];
	var user_name = value["contactor"];
	var user_addr = value["sendAddress"];
	var is_default = value["isDefault"];
	var user_phone_sec = value["secPhone"];
	USER_ID = value["userId"];
	
	
	if (is_default == 0) {
		$("#addr_ul")
				.append(
						"<li class='basic' onclick='changeSelect(this)' >"
								+ "<span class='sendto'>送至</span>"
								+ " <label class='block'>"
								+ "<input type='radio' name='radgroup' value='A' class='addrInfo' style='margin-right: 10px;'>"
								+ user_addr
								+ "("
								+ user_name
								+ "收）"
								+ user_phone
								+ "&nbsp备用："
								+ user_phone_sec
								+ "</label>"
								+ " <span style='margin-left: 10px' class='setDefault' onclick='setDefaultAddr(this)'>设为默认地址</span>"
								+ " <a  href='' style='float: right;'>修改本地址</a></li>");
	} else if (is_default == 1) {
		$("#addr_ul")
				.append(
						"<li class='basic addrSelect' onclick='changeSelect(this)'>"
								+ "<span class='sendto'>送至</span>"
								+ " <label class='block'>"
								+ "<input type='radio' name='radgroup' value='A' class='addrInfo' style='margin-right: 10px;'>"
								+ user_addr
								+ "("
								+ user_name
								+ "收）"
								+ user_phone
								+ "&nbsp备用："
								+ user_phone_sec
								+ "</label>"
								+ " <span style='margin-left: 10px' class='setDefault'>默认地址</span>"
								+ " <a  href='' style='float: right;'>修改本地址</a></li>");
	}

}