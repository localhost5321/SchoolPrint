var SCREEN_WIDTH;
var SCREEN_HEIGHT;
var FILE_UPLOAD_WIDTH = 500;
var SHOW_FILE_WIDTH = 700;
var GAP;
var userFiles = new Array();

$(document)
		.ready(
				function() {
					$("#selectPrint").click(
							function() {
								var targetOffset = $("#printShopContent")
										.offset().top - 50;
								$('html,body').animate({
									scrollTop : targetOffset
								}, 1000);
							});
					// 将打印页面的导航高亮改变
					$("#navBarIndex").attr("class", "");
					$("#navBarIndex").children("a").attr("href", "index.jsp");
					$("#navBarPrint").attr("class", "active");
					$("#navBarPrint").children("a").attr("href", "");

					// 给店铺的订单详情按钮添加对应监听
					$("#shopDetail_1").click(function(){
						showOrder(this);
					});

					// 将浏览按钮的事件清除
					var fileInput = $("#fileInput");// 文件输入框
					var browseBtn = document.getElementById("browseBtn");// 浏览按钮
					browseBtn.addEventListener("click", function(e) {
						if (fileInput) {
							fileInput.click();
						}
						e.preventDefault(); // prevent navigation to "#"
					}, false);
					SCREEN_WIDTH = document.body.offsetWidth;
					SCREEN_HEIGHT = document.body.offsetHeight;
					GAP = (SCREEN_WIDTH - FILE_UPLOAD_WIDTH - SHOW_FILE_WIDTH) / 3;

					// 将文件上传区域放置正中
					document.getElementById("fileUploadContent").style.width = FILE_UPLOAD_WIDTH
							+ "px";
					document.getElementById("showFilesContent").style.width = SHOW_FILE_WIDTH
							+ "px";
					document.getElementById("fileUploadContent").style.left = SCREEN_WIDTH
							/ 2 - FILE_UPLOAD_WIDTH / 2 + "px";
					initDrag();

				});

function initDrag() {
	var holder = document.getElementById('holder'), uploadBtn = document
			.getElementById('uploadBtn');

	if (typeof window.FileReader === 'undefined') {
		uploadBtn.innerHTML = '对不起，服务异常，请稍后再试';
	} else {
		uploadBtn.innerHTML = '上传文件';
	}

	holder.ondragover = function() {
		this.className = 'hover';
		return false;
	};
	holder.ondragend = function() {
		this.className = "";
		return false;
	};
	// 松开鼠标
	holder.ondrop = function(event) {
		this.className = '';
		// 获取拖拽的文件列表
		var files = event.dataTransfer.files;
		event.stopPropagation();
		event.preventDefault();
		// 添加一项文件到表格
		for (var i = 0; i < files.length; i++) {
			// 文件判重
			var isRepeat = judgeRepeat(files[i], userFiles);
			if (isRepeat != -1) {
				// 更新文件信息
				updateFileInfo();
				return;
			}
			userFiles[userFiles.length] = files[i];
			handleFile(files[i]);
		}
		// 更新文件信息
		updateFileInfo();
		return false;
	};
}

/**
 * 上传文件
 */
function uploadFile() {
	var form = document.forms["uploadFileForm"];
	var fileCount = form["fileInput"].files.length;
	if (fileCount == 0) {
		alert("请选择文件");
		return;
	}
	for (var i = 0; i < fileCount; i++) {
		// 寻找表单域中的 <input type="file" ... /> 标签
		var file = form["fileInput"].files[i];
		// 文件判重
		var isRepeat = judgeRepeat(file, userFiles);
		if (isRepeat != -1) {
			// 更新文件信息
			updateFileInfo();
			return;
		}
		userFiles[userFiles.length] = file;
		handleFile(file);
	}
	// 更新文件信息
	updateFileInfo();
}

/**
 * 更新进度条
 * 
 * @param progressBar
 * @param pro
 */
function updateProgressBar(progressBar, pro) {
	progressBar.style.width = pro + "%";
	progressBar.innerHTML = pro + "%";
}

/**
 * 更新文件信息
 */
function updateFileInfo() {
	var num = userFiles.length;
	var printCount = $("#fileListTable").find(".printCounts");//份数
	var pageCount = $("#fileListTable").find(".pageCounts");//页数
	var count = 0;
	var allPage = 0;
	for (var i = 0; i < printCount.length; i++) {
		count += Number(printCount.get(i).value);
		allPage += (Number(printCount.get(i).value) * Number(pageCount.get(i).innerHTML));
	}
	$(".fileInfo").text("共" + num + "个文件, 总份数:" + count + ", 总页数:" + allPage);
}

/**
 * 往表格添加一行
 * 
 * @param 文件
 * @param 进度条
 * @returns {___anonymous3123_3133}
 */
function addFileToTable(file, progressBar) {

	// 给表格添加项
	var table = document.getElementById("fileListTable");
	table.style.display = "table";
	// 创建行
	var tr = document.createElement("tr");
	// 创建文件名列
	var tdName = document.createElement("td");
	tdName.style.verticalAlign = "middle";
	tdName.title = file.name;
	tdName.className = "fileName";
	if (file.name.length >= 6) {
		tdName.innerHTML = file.name.substring(0, 6) + "...";
	} else {
		tdName.innerHTML = file.name;
	}
	// 创建进度条列
	var tdProgressBar = document.createElement("td");
	tdProgressBar.style.verticalAlign = "middle";
	progressBar = document.createElement("div");
	progressBar.className = "progress-bar progress-bar-striped active";
	progressBar.role = "progressbar";
	progressBar.style.width = "0%";
	tdProgressBar.appendChild(progressBar);
	// 创建页数列
	var tdPageCounts = document.createElement("td");
	tdPageCounts.className = "pageCounts";
	tdPageCounts.style.verticalAlign = "middle";
	tdPageCounts.innerHTML = "5";
	// 创建打印设置列
	var tdSetting = document.createElement("td");
	var settingBtn = document.createElement("a");
	var settingInfo = document.createElement("span");
	tdSetting.style.verticalAlign = "middle";
	settingInfo.className = "setting";
	settingInfo.innerHTML = "黑白、单面、A4、全部";
	settingBtn.href = "javascript:void(0)";
	settingBtn.innerHTML = "设置";
	settingBtn.style.marginLeft = "5px";
	settingBtn.setAttribute("data-toggle", "modal");
	settingBtn.setAttribute("data-target", "#printSettingModal");
	// 打印设置
	settingBtn.onclick = function() {
		printSetting(settingInfo);
	};
	tdSetting.appendChild(settingInfo);
	tdSetting.appendChild(settingBtn);
	// 创建份数列
	var tdPrintCounts = document.createElement("td");
	var inputCounts = document.createElement("input");
	inputCounts.className = "printCounts";
	inputCounts.type = "number";
	inputCounts.value = "1";
	inputCounts.min = "1";
	inputCounts.style.width = "50px";
	inputCounts.style.height = "";
	inputCounts.onchange = function() {
		// 更新文件信息
		updateFileInfo();
	};
	tdPrintCounts.appendChild(inputCounts);
	// 创建操作列
	var tdControl = document.createElement("td");
	tdControl.style.verticalAlign = "middle";
	var control = document.createElement("a");
	control.href = "javascript:void(0)";
	control.onclick = function() {
		removeRow(this);
	};
	control.className = "glyphicon glyphicon-remove";
	tdControl.appendChild(control);

	// 添加
	tr.appendChild(tdName);
	tr.appendChild(tdProgressBar);
	tr.appendChild(tdPageCounts);
	tr.appendChild(tdSetting);
	tr.appendChild(tdPrintCounts);
	tr.appendChild(tdControl);
	table.tBodies[0].appendChild(tr);

	return progressBar;
}

/**
 * 移除指定元素所在的一行
 * 
 * @param obj
 */
function removeRow(obj) {
	var row = obj.parentNode.parentNode;
	// 删除对应的文件
	userFiles.splice(row.rowIndex - 1, 1);
	// 删除对应的行
	row.parentNode.removeChild(row);
	// 当表格没有文件时，隐藏表格区域
	if (document.getElementById("fileListTable").rows.length == 1) {
		// 移动两个div
		var move_dist = SCREEN_WIDTH / 2 - FILE_UPLOAD_WIDTH / 2;
		$("#fileUploadContent").animate({
			left : move_dist + "px"
		}, 500);
		$("#showFilesContent").fadeOut();
	}
}

/**
 * 打印设置
 * 
 * @param obj
 */
function printSetting(obj) {
	var printSubmit = document.getElementById("settingSubmit");
	printSubmit.onclick = function() {
		var colorType = $("#colorType option:selected").text();
		var sideType = $("#sideType option:selected").text();
		var sizeType = $("#sizeType option:selected").text();
		obj.innerHTML = colorType + "、" + sideType + "、" + sizeType;
	};
}

/**
 * 文件判重 在文件数组中判断指定文件是否存在
 * 
 * @param 需要判重的文件
 * @param 文件数组
 * @returns 如果不存在返回-1, 否则返回重复的索引
 */
function judgeRepeat(file, files) {
	for (var i = 0; i < files.length; i++) {
		if (file.name == files[i].name && file.size == files[i].size) {
			var printCount = $("#fileListTable").find(".printCounts").get(i).value;
			$("#fileListTable").find(".printCounts").get(i).value = Number(printCount) + 1;
			return i;
		}
	}
	return -1;
}

/**
 * 显示用户上传文件总览
 */
function showUserFile() {
	var json = {
			data : []
	};
	var pageCounts = $("#fileListTable").find(".pageCounts");
	var setting = $("#fileListTable").find(".setting");
	var printCounts = $("#fileListTable").find(".printCounts");
	for (var i = 0; i < userFiles.length; i++) {
		var file = {};
		file.fileName = userFiles[i].name;
		file.pageCounts = $(pageCounts[i]).html();
		file.setting = $(setting[i]).html();
		file.printCounts = $(printCounts[i]).val();
		json.data.push(file);
	}
	return json
}

/**
 * 显示订单详情
 */
function showOrder(obj){
	var json = showUserFile();
	var table = document.getElementById("orderTable");
	//清空表格
	table.tBodies[0].innerHTML = "";
	if(json.data.length == 0){
		alert("请先选择文件");
		return;
	}
	for(var i = 0; i < json.data.length; i++){
		var tr = document.createElement("tr");
		tr.style.textAlign = "center";
		//创建文件名列
		var tdFileName = document.createElement("td");
		tdFileName.innerHTML = json.data[i].fileName;
		tr.appendChild(tdFileName);
		//创建页数列
		var tdPrintCount = document.createElement("td");
		tdPrintCount.innerHTML = json.data[i].pageCounts;
		tr.appendChild(tdPrintCount);
		//创建打印设置列
		var tdSetting = document.createElement("td");
		tdSetting.innerHTML = json.data[i].setting;
		tr.appendChild(tdSetting);
		//创建份数列
		var tdPrintCounts = document.createElement("td");
		tdPrintCounts.innerHTML = json.data[i].printCounts;
		tr.appendChild(tdPrintCounts);
		//创建单价列
		var tdPrice = document.createElement("td");
		tdPrice.innerHTML = 0.1;
		tr.appendChild(tdPrice);
		//创建总价列
		var sumPrice = document.createElement("td");
		sumPrice.className="sumPrice"
		sumPrice.innerHTML = Number(tdPrintCount.innerHTML) * Number(tdPrintCounts.innerHTML) * Number(tdPrice.innerHTML);
		tr.appendChild(sumPrice);
		
		//添加此行
		table.tBodies[0].appendChild(tr);
	}
	
	var sumPrice = 0;
	var tdSumPrice = $("#orderTable").find(".sumPrice");
	for (var i = 0; i < tdSumPrice.length; i++) {
		sumPrice += Number($(tdSumPrice.get(i)).text());
	}
	$(".orderInfo").text("总价：" + sumPrice + "元 ");
	
	//弹窗
	$("#orderModal").modal();
}

/**
 * 处理用户上传的文件
 * 
 * @param file
 */
function handleFile(file) {
	var reader = new FileReader();
	var progressBar;

	// 移动两个div
	$("#fileUploadContent").animate({
		left : GAP + "px"
	}, 500);
	var fileUploadContent = document.getElementById("fileUploadContent");
	var showFilesContent = document.getElementById("showFilesContent");
	$("#showFilesContent").fadeIn(1000);
	showFilesContent.style.left = 2 * GAP + FILE_UPLOAD_WIDTH + "px";

	reader.onloadstart = function() {
		// 这个事件在读取开始时触发
		console.log("onloadstart");
		// 添加一项文件到表格
		progressBar = addFileToTable(file, progressBar);
	}

	reader.onprogress = function(p) {
		// 这个事件在读取进行中定时触发
		console.log("onprogress");
		var pro = Math.round(p.loaded / file.size * 100);
		// 更新进度条
		updateProgressBar(progressBar, pro);
	}

	reader.onload = function() {
		// 这个事件在读取成功结束后触发
		console.log("load complete");
	}

	reader.onloadend = function() {
		// 这个事件在读取结束后，无论成功或者失败都会触发
		if (reader.error) {
			console.log(reader.error);
			progressBar.className = "progress-bar progress-bar-danger progress-bar-striped";
		} else {
			progressBar.style.width = "100%";
			progressBar.innerHTML = "100%";
			// 构造 XMLHttpRequest 对象，发送文件 Binary 数据
			var xhr = new XMLHttpRequest();
			xhr.open(
			/* method */"POST",
			/* target url */
			"fileUpLoad.action?fileName=" + file.name
			/* , async, default to true */
			);
			xhr.overrideMimeType("application/octet-stream");
			xhr.sendAsBinary(reader.result);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						console.log("upload complete");
						console.log("response: " + xhr.responseText);
					}
				}
			}
		}
	}

	reader.readAsBinaryString(file);
}