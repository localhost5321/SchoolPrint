var changeAddrId; // 用户当前正在修改的地址条目ID

$(function() {
	// 将打印页面的导航高亮改变
	$("#navBarIndex").attr("class", "");
	$("#navBarIndex").children("a").attr("href", "index.jsp");
	$("#navBarPrint").attr("class", "active");
	$("#navBarPrint").children("a").attr("href", "print.jsp");

	var json = sessionStorage.getItem("orderList");
	console.log(json);
	var obj = JSON.parse(json);
	
	// 请求地址并保存
	$.post("getAllAddress.action", function(json_data) {
		var obj = JSON.parse(json_data);
		if(obj.status == "1"){
			$.each(obj.data, function(key, value) {
				console.log(value);
				addLi(value);
			});
		}else{
			$("#addr_ul").append("<li id='addr_tip'>您还没有任何地址，请先添加地址！</li>");
		}
	});
	
	// 取出所有文件
	for ( var i = 0; i < obj.data.length; i++) {
		var fileName = obj.data[i].fileName;
		var pageCounts = obj.data[i].pageCounts;
		var setting = obj.data[i].setting;
		var printCounts = obj.data[i].printCounts;
		var price = obj.data[i].price;
		var itemPrice = obj.data[i].itemPrice;
		$("#orderTable").append(
				"<tr><td>" + fileName + "</td><td>" + pageCounts + "</td><td>"
						+ setting + "</td><td>" + printCounts + "</td><td>"
						+ price + "</td><td>" + itemPrice + "</td></tr>");
	}

	$(".orderInfo").text("总价：" + obj.total + "元");

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
								+ " <a  href='' class='changeAddr'>修改本地址</a></li>");
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
								+ " <a  href='' class='changeAddr'>修改本地址</a></li>");

	}
}
/**
 * 响应用户改变地址事件
 */
function changeSelect(li_this) {
	// 将所有的条目设为未选状态
	$("#addr_ul>li").removeClass();
	$("#addr_ul>li").addClass("basic");
	// $(".setDefault").html("<a href='javascript:void(0)'>设为默认地址</a>");
	$(".setDefault").attr("onclick", "setDefaultAddr(this)");
	$(".send_icon").addClass("icon_hidden");
	$(".sendto").addClass("icon_hidden");
	$(".changAddress").addClass("icon_hidden");

	// 将当前条目设为高亮状态
	$(li_this).addClass("basic addrSelect");
	$(li_this).children(".setDefault").removeAttr("onclick");
	// $(li_this).children(".setDefault").html("默认地址");
	$(li_this).children("input").attr("checked", "checked");
	$(li_this).children("img").removeClass("icon_hidden");
	$(li_this).children(".sendto").removeClass("icon_hidden");
	$(li_this).children(".changAddress").removeClass("icon_hidden");

	// 记录当前id以便用户修改地址的时候将此id传到后台
	changeAddrId = $(li_this).attr("id");

}

/**
 * 设置默认地址
 */
function setDefaultAddr(span_this, e) {

	/**
	 * 停止冒泡
	 */
	stopBubble(e);
	/** 请求服务器，更改默认地址 * */

	// 当前默认地址的id
	var preDefaultId = $(".isDefault").closest("li").attr("id");
	// 当前选择地址的ID
	var currentId = $(span_this).closest("li").attr("id");
	console.log(preDefaultId);
	if(preDefaultId == undefined){
		preDefaultId == "null";
	}

	$.post("setDefault.action?oldId=" + preDefaultId + "&newId=" + currentId,

	function(data) {
		console.log("更改默认地址：" + data);
		var obj = JSON.parse(data);
		if (obj.status == 1) {
			$(".setDefault").html("<a href='javascript:void(0)'>设为默认地址</a>");
			$(".setDefault").attr("onclick", "setDefaultAddr(this)");
			$(span_this).removeAttr("onclick");
			$(span_this).html("默认地址");
		} else {
			// 更改失败
			console.log("更改默认地址失败！！！");
		}
	});

}

/**
 * 停止冒泡
 */
function stopBubble(e) {
	// 如果提供了事件对象，则这是一个非IE浏览器
	if (e && e.stopPropagation) {
		e.stopPropagation();
	} else {
		window.event.cancelBubble = true;
	}
	return false;
}

/**
 * 用户增加地址
 */
function addAddrInfo() {
	$("#addr_tip").hide();
	var contactor = $("#newUserName").val();
	var sendAddress = $("#newAddrInfo").val();
	var callPhone = $("#newPhone").val();
	var secPhone = $("#newSecPhone").val();

	$
			.post(
					"addOrUpdateAddressinfo?contactor=" + contactor
							+ "&sendAddress=" + sendAddress + "&callPhone="
							+ callPhone + "&secPhone=" + secPhone
							+ "&addressId=" + "none",

					function(data) {
						console.log(data);
						var obj = JSON.parse(data);
						if (obj.status == 1) {
							// 添加成功，局部更新界面
							var user_name = obj.data["contactor"];
							var user_addr = obj.data["sendAddress"];
							var user_phone = obj.data["callPhone"];
							var user_phone_sec = obj.data["secPhone"];
							var addressId = obj.data["addressId"];

							$("#addr_ul")
									.append(
											"<li class='basic' onclick='changeSelect(this)' id="
													+ addressId
													+ " >"
													+ "<span class='sendto icon_hidden'>送至</span>"
													+ "<img src='./images/send_icon.png' class='send_icon icon_hidden'></img>"
													+ "<span class='user_addr'>"
													+ user_addr
													+ "</span>"
													+ "("
													+ "<span class='user_name'>"
													+ user_name
													+ "</span>"
													+ "&nbsp收）"
													+ "<span class='user_phone'>"
													+ user_phone
													+ "</span>"
													+ "&nbsp备用电话："
													+ "<span class='user_phone_sec'>"
													+ user_phone_sec
													+ "</span>"
													+ " <span style='margin-left: 10px' class='setDefault' onclick='setDefaultAddr(this,event)'><a href='javascript:void(0)'>设为默认地址</a></span>"
													+ " <a class='changAddress icon_hidden changeAddr' href='javascript:void(0)'  data-toggle='modal'"
													+ "data-target='#changeAddr'>修改本地址</a></li>");
							$("#addAddr").modal("hide");
						} else {
							// 添加失败
							$("#addAddrInfo").text(obj.message);
						}
					});

}

/**
 * 用户修改地址
 */
function changeAddressInfo() {
	alert("修改地址");
	var contactor = $("#changeUserName").val();
	var sendAddress = $("#changeAddrInfo").val();
	var callPhone = $("#changePhone").val();
	var secPhone = $("#changeSecPhone").val();

	$.post("addOrUpdateAddressinfo?contactor=" + contactor + "&sendAddress="
			+ sendAddress + "&callPhone=" + callPhone + "&secPhone=" + secPhone
			+ "&addressId=" + changeAddrId,

	function(data) {
		console.log(data);
		var obj = JSON.parse(data);
		if (obj.status == 1) {
			// 修改成功，局部更新界面
			$('#' + changeAddrId).children(".user_name").html(contactor);
			$('#' + changeAddrId).children(".user_addr").html(sendAddress);
			$('#' + changeAddrId).children(".user_phone").html(callPhone);
			$('#' + changeAddrId).children(".user_phone_sec").html(secPhone);
			$("#changeAddr").modal("hide");
		} else {
			// 添加失败
			$("#changeAddrInfo").text(obj.message);
		}
	});

}

/**
 * 添加一条地址信息
 */
function addLi(value) {
	var user_phone = value["callPhone"];
	var user_name = value["contactor"];
	var user_addr = value["sendAddress"];
	var is_default = value["isDefault"];
	var user_phone_sec = value["secPhone"];
	var addressId = value["addressId"];

	if (is_default == 0) {
		$("#addr_ul")
				.append(
						"<li class='basic' onclick='changeSelect(this)' id="
								+ addressId
								+ " >"
								+ "<span class='sendto icon_hidden'>送至</span>"
								+ "<img src='./images/send_icon.png' class='send_icon icon_hidden'></img>"
								+ "<span class='user_addr'>"
								+ user_addr
								+ "</span>"
								+ "("
								+ "<span class='user_name'>"
								+ user_name
								+ "</span>"
								+ "&nbsp收）"
								+ "<span class='user_phone'>"
								+ user_phone
								+ "</span>"
								+ "&nbsp备用电话："
								+ "<span class='user_phone_sec'>"
								+ user_phone_sec
								+ "</span>"
								+ " <span style='margin-left: 10px' class='setDefault' onclick='setDefaultAddr(this,event)'><a href='javascript:void(0)'>设为默认地址</a></span>"
								+ " <a class='changAddress icon_hidden changeAddr' href='javascript:void(0)'  data-toggle='modal'"
								+ "data-target='#changeAddr'>修改本地址</a></li>");
	} else if (is_default == 1) {
		$("#addr_ul")
				.append(
						"<li class='basic addrSelect' onclick='changeSelect(this)' id="
								+ addressId
								+ ">"
								+ "<span class='sendto'>送至</span>"
								+ "<img src='./images/send_icon.png' class='send_icon'></img>"
								+ "<span class='user_addr'>"
								+ user_addr
								+ "</span>"
								+ "("
								+ "<span class='user_name'>"
								+ user_name
								+ "</span>"
								+ "&nbsp收）"
								+ "<span class='user_phone'>"
								+ user_phone
								+ "</span>"
								+ "&nbsp备用电话："
								+ "<span class='user_phone_sec'>"
								+ user_phone_sec
								+ "</span>"
								+ " <span style='margin-left: 10px' class='setDefault isDefault'>默认地址</span>"
								+ "  <a  class='changAddress changeAddr' href='javascript:void(0)' data-toggle='modal'"
								+ "data-target='#changeAddr'>修改本地址</a></li>");
	}

}
