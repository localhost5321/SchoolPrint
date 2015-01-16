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
<title>确认订单</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/indexStyle.css" rel="stylesheet">
<link href="css/footerStyle.css" rel="stylesheet">
<link href="css/shopHomeStyle.css" rel="stylesheet">
<link href="css/make_sure.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.js"></script>
		<![endif]-->

</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="content" id="container">
		<h1>确认订单</h1>
		<div class="orderDiv">



			<form>
				<h4>
					店铺名：<span>赵龙打印店</span>
				</h4>
				<h4>确定收货地址：</h4>
				<br>
				<ul>
					<li class="addrSelect"><span class="sendto">送至</span> <label
						class="block"><input type="radio" name="radgroup"
							value="A" class="addrInfo" style="margin-right: 10px;">南华大学弘辰公寓六栋301（蔡恒毅
							收）13016196174</label> <span style="margin-left: 10px">默认地址</span> <a
						href="" style="float: right;">修改本地址</a></li>
				</ul>

				<br>
			</form>
			<p>文件列表：</p>
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
				<tbody>

				</tbody>
			</table>
			<!-- 订单总信息 -->
			<div class="orderInfo">
				<span>总价：</span>
			</div>
			<!-- 备注信息 -->
			<br>
			<div>
				<p>备注：</p>
				<textarea class="form-control" rows="3"></textarea>
			</div>

			<div class="btnDiv">
				<button class="btn btn-primary">立即下单</button>
			</div>
		</div>
	</div>
	<br>
	<%@ include file="footer.jsp"%>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/make_sure.js"></script>
</body>
</html>