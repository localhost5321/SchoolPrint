var SCREEN_WIDTH;
var SCREEN_HEIGHT;
var FILE_UPLOAD_WIDTH = 500;
var SHOW_FILE_WIDTH = 700;
var GAP;
var userFiles = new Array();

$(document).ready(function() {
	$("#selectPrint").click(function() {
		var targetOffset = $("#printShopContent").offset().top - 50;
		$('html,body').animate({
			scrollTop : targetOffset
		}, 1000);
	});

	SCREEN_WIDTH = document.body.offsetWidth;
	SCREEN_HEIGHT = document.body.offsetHeight;
	GAP = (SCREEN_WIDTH - FILE_UPLOAD_WIDTH - SHOW_FILE_WIDTH) / 3;
	//将文件上传区域放置正中
	document.getElementById("fileUploadContent").style.width = FILE_UPLOAD_WIDTH + "px";
	document.getElementById("showFilesContent").style.width = SHOW_FILE_WIDTH + "px";
	document.getElementById("fileUploadContent").style.left = SCREEN_WIDTH / 2 - FILE_UPLOAD_WIDTH / 2 + "px";
	initDrag();

});

function initDrag() {
	var holder = document.getElementById('holder'), uploadBtn = document.getElementById('uploadBtn');

	if ( typeof window.FileReader === 'undefined') {
		uploadBtn.innerHTML = '对不起，服务异常，请稍后再试';
	} else {
		uploadBtn.innerHTML = '上传文件';
	}

	holder.ondragover = function() {
		this.className = 'hover';
		return false;
	};
	holder.ondragend = function() {
		this.className = '';
		return false;
	};
	//松开鼠标
	holder.ondrop = function(event) {
		this.className = '';
		// 获取拖拽的文件列表
		var files = event.dataTransfer.files;
		event.stopPropagation();
		/**什么意思？*/
		event.preventDefault();
		// 添加一项文件到表格
		alert(files.length);
		for (var i = 0; i < files.length; i++) {
			//文件判重
			if(judgeRepeat(files[i], userFiles)){
				alert("请勿上传相同文件");
				return;
			}
			userFiles[userFiles.length] = files[i];
			handleFile(files[i]);
		}

		return false;
	};
}

//上传文件
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
		//文件判重
		if(judgeRepeat(file, userFiles)){
			alert("请勿上传相同文件");
			return;
		}
		userFiles[userFiles.length] = file;
		handleFile(file);
	}
}

//更新进度条
function updateProgressBar(progressBar, pro) {
	progressBar.style.width = pro + "%";
	progressBar.innerHTML = pro + "%";
}

//往表格添加一项文件
function addFileToTable(file, progressBar) {

	//给表格添加项
	var table = document.getElementById("fileListTable");
	table.style.display = "table";
	//创建行
	var tr = document.createElement("tr");
	//创建文件名列
	var tdName = document.createElement("td");
	if(file.name.length >= 6){
		tdName.innerHTML = file.name.substring(0, 6) + "...";
	}else{
		tdName.innerHTML = file.name;
	}
	//创建进度条列
	var tdProgressBar = document.createElement("td");
	progressBar = document.createElement("div");
	progressBar.className = "progress-bar progress-bar-striped active";
	progressBar.role = "progressbar";
	progressBar.style.width = "0%";
	tdProgressBar.appendChild(progressBar);
	//创建页数列
	var tdPageCounts = document.createElement("td");
	tdPageCounts.innerHTML = "**页";
	//创建打印设置列
	var tdSetting = document.createElement("td");
	var settingBtn = document.createElement("a");
	var settingInfo = document.createElement("span");
	settingInfo.innerHTML = "黑白、单面、全部";
	settingBtn.href="#";
	settingBtn.innerHTML = "设置";
	settingBtn.style.marginLeft = "5px";
	settingBtn.setAttribute("data-toggle", "modal");
	settingBtn.setAttribute("data-target", "#printSettingModal");
	//打印设置
	settingBtn.onclick = function(){
		printSetting(settingInfo);
	};
	tdSetting.appendChild(settingInfo);
	tdSetting.appendChild(settingBtn);
	//创建份数列
	var tdPrintCounts = document.createElement("td");
	var inputCounts = document.createElement("input");
	inputCounts.type = "text";
	inputCounts.innerHTML = "1";
	inputCounts.style.width = "100%";
	inputCounts.style.height = "100%";
	tdPrintCounts.appendChild(inputCounts);
	//创建操作列
	var tdControl = document.createElement("td");
	var control = document.createElement("a");
	control.onclick = function() {
		removeRow(this);
	};
	control.className = "glyphicon glyphicon-remove";
	tdControl.appendChild(control);

	//添加
	tr.appendChild(tdName);
	tr.appendChild(tdProgressBar)
	tr.appendChild(tdPageCounts)
	tr.appendChild(tdSetting)
	tr.appendChild(tdPrintCounts);
	tr.appendChild(tdControl);
	table.tBodies[0].appendChild(tr);

	return progressBar;
}

//移除一行
function removeRow(obj) {
	var row = obj.parentNode.parentNode;
	//删除对应的文件
	userFiles.splice(row.rowIndex - 1, 1);
	//删除对应的行
	row.parentNode.removeChild(row);
	//当表格没有文件时，隐藏表格区域
	if (document.getElementById("fileListTable").rows.length == 1) {
		//移动两个div
		var fileUploadContent = document.getElementById("fileUploadContent");
		var move_dist = SCREEN_WIDTH / 2 - FILE_UPLOAD_WIDTH / 2;
		$("#fileUploadContent").animate({
			left : move_dist + "px"
		}, 500);
		var showFilesContent = document.getElementById("showFilesContent");
		$("#showFilesContent").fadeOut();
	}
}

//打印设置
function printSetting(obj){
	var printSubmit = document.getElementById("settingSubmit");
	printSubmit.onclick = function(){
		var colorType = $("#colorType option:selected").text();
		var sideType = $("#sideType option:selected").text();
		var sizeType = $("#sizeType option:selected").text();
		obj.innerHTML = colorType + "、" + sideType + "、" + sizeType;
	}
}

//文件判重
function judgeRepeat(file, files){
	for(var i = 0; i < files.length; i++){
		if(file == files[i]){
			return true;
		}
	}
	return false;
}

//处理用户上传的文件
function handleFile(file) {
	var reader = new FileReader();
	var progressBar;

	//移动两个div
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
		//添加一项文件到表格
		progressBar = addFileToTable(file, progressBar);
	}

	reader.onprogress = function(p) {
		// 这个事件在读取进行中定时触发
		console.log("onprogress");
		var pro = Math.round(p.loaded / file.size * 100);
		//更新进度条
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
			"upload.jsp?fileName=" + file.name
			/*, async, default to true */
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