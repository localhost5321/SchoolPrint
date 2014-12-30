<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>校园云打印</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/indexStyle.css" rel="stylesheet">
<link href="css/printStyle.css" rel="stylesheet">
<link href="css/shopListStyle.css" rel="stylesheet">
<link href="css/footerStyle.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.js"></script>
		<![endif]-->

</head>

<body>
	<%@ include file="header.jsp"%>

	<!-- 设置窗口 -->
	<div class="modal fade" id="printSettingModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">打印设置</h4>
				</div>
				<!--设置窗口内容-->
				<form class="form-horizontal" role="form" action="">
					<div class="modal-body">
						<!--打印类型-->
						<div class="form-group">
							<label for="colorType" class="col-sm-4 control-label">打印类型：</label>
							<div class="col-sm-8">
								<select class="form-control" id="colorType">
									<option value="normal">黑白</option>
									<option value="colorful">彩色</option>
								</select>
							</div>
						</div>
						<!--单双面-->
						<div class="form-group">
							<label for="sideType" class="col-sm-4 control-label">单双面：</label>
							<div class="col-sm-8">
								<select class="form-control" id="sideType">
									<option value="single">单面</option>
									<option value="double">双面</option>
								</select>
							</div>
						</div>
						<!--纸张大小-->
						<div class="form-group">
							<label for="sizeType" class="col-sm-4 control-label">纸张大小：</label>
							<div class="col-sm-8">
								<select class="form-control" id="sizeType">
									<option value="a4">A4</option>
									<option value="a3">A3</option>
								</select>
							</div>
						</div>
					</div>
					<!--设置窗口底部-->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							取消</button>
						<button type="button" class="btn btn-primary" id="settingSubmit"
							data-dismiss="modal">确定</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 拖拽文件区域 -->
	<div class="container-fluid" id="print-content">
		<div class="container" id="fileUploadContent" align="center">
			<!--拖拽文件区域-->
			<div>
				<div id="holder"></div>
				<form id="uploadFileForm" action="javascript:uploadFile()"
					method="post" enctype="multipart/form-data" role="form">
					<!--通过浏览上传文件-->
					<div class="file-box form-group">
						<input type="text" id="textfield" disabled/> <a
							class="btn btn-info" id="browseBtn" >浏览</a> 
							<input type="file" id="fileInput" size="28" name="upFile"
							onchange="document.getElementById('textfield').value=this.value"
							accept=".pdf,.doc,.xls,.docx" multiple /> <input type="submit"
							id="uploadBtn" class="btn btn-primary" value="上传" />
						<p>点击“浏览”上传文件 或 将文件直接拖拽到上方虚线框中</p>
						<span>* 暂只支持<font color="red">.pdf,.doc,.docx,.xls</font>格式
						</span>
					</div>
				</form>
			</div>
		</div>
		<!-- 拖拽文件区域结束 -->

		<!-- 选择完文件后显示的文件信息 -->
		<div class="container" id="showFilesContent" align="center">
			<div class="showFiles">
				<table class="table table-striped table-bordered table-hover"
					id="fileListTable" style="text-align:center;">
					<thead>
						<tr>
							<th width="20%">文件名</th>
							<th width="20%">上传进度</th>
							<th width="10%">页数</th>
							<th width="30%">打印设置</th>
							<th width="10%">份数</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
			<!-- 文件总信息 -->
			<div class="fileInfo"><span>共**个文件,总份数:**,总页数**</span></div>
			<div>
				<a class="btn btn-info" id="selectPrint" href="#printShopContent">选择打印店</a>
			</div>
		</div>
	</div>
	<!-- 选择完文件后显示的文件信息结束 -->

	<div class="container-fluid" id="printShopContent" align="center">
	</div>

	<!-- 店铺列表区域 -->
	<div class="container shopContainer">

		<div class="shopInfo">
			<img src="images/s1.png" class="img-circle" />
			<h3 class="shopName">弘辰打印店</h3>
			<p class="shopAddr">地址：弘辰桥洞小巷内10米左拐</p>
			<p class="shopTel">联系电话：0728-8259807</p>
			<button id="shopDetail_1" class="btn btn-info shopDetail" >查看订单</button>
			<button id="enterShop_1" class="btn btn-primary enterShop">进入店铺</button>
		</div>

		<div class="shopInfo">
			<img src="images/s2.png" class="img-circle" />
			<h3 class="shopName">弘辰食堂打印店</h3>
			<p class="shopAddr">地址：弘辰食堂2楼</p>
			<p class="shopTel">联系电话：0728-8259807/13027342004</p>
			<button class="btn btn-info shopDetail" data-toggle="modal" data-target="#orderModal">查看订单</button>
			<button class="btn btn-primary enterShop">进入店铺</button>
		</div>

		<div class="shopInfo">
			<img src="images/s3.png" class="img-circle" />
			<h3 class="shopName">南校打印店</h3>
			<p class="shopAddr">地址：南校申通快递对面</p>
			<p class="shopTel">联系电话：0728-8259807/18373425473</p>
			<button class="btn btn-info shopDetail" data-toggle="modal" data-target="#orderModal">查看订单</button>
			<button class="btn btn-primary enterShop">进入店铺</button>
		</div>

		<div class="shopInfo">
			<img src="images/s4.png" class="img-circle" />
			<h3 class="shopName">北校坑里打印店</h3>
			<p class="shopAddr">地址：北校坑里</p>
			<p class="shopTel">联系电话：0728-8259807/18373425473</p>
			<button class="btn btn-info shopDetail" data-toggle="modal" data-target="#orderModal">查看订单</button>
			<button class="btn btn-primary enterShop">进入店铺</button>
		</div>
	</div>
	<!-- 店铺列表区域结束 -->

	<!-- 订单详情窗口 -->
	<div class="modal fade" id="orderModal" tabindex="-1" role="dialog"
		aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="orderModalLabel">订单详情</h4>
				</div>
				<!--内容-->
				<!--表单-->
				<div class="modal-body">
					<div class="orderDiv">
						<table class="table table-striped table-bordered table-hover"
							id="orderTable">
							<thead>
								<tr>
									<th width="30%">文件名</th>
									<th width="10%">页数</th>
									<th width="30%">打印设置</th>
									<th width="10%">份数</th>
									<th width="10%">单价</th>
									<th width="10%">总价</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
					<!-- 订单总信息 -->
				<div class="orderInfo"><span>总价：</span></div>
				<!-- 备注信息 -->
				<br>
				<div>
					备注：<br><textarea class="form-control" rows="2"></textarea>
				</div>
				</div>
				<!--窗口底部-->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						返回</button>
					<button type="button" class="btn btn-primary">确认订单</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 订单详情窗口结束 -->

	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<%@ include file="footer.jsp"%>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/print.js"></script>
</body>
</html>
