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
<link href="css/footerStyle.css" rel="stylesheet">
<link href="css/shopHomeStyle.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.js"></script>
		<![endif]-->

</head>

<body>
	<%@ include file="header.jsp"%>

	<div class="carouselDiv">
		<!-- 店家大图轮播 -->
		<div id="ad-carousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#ad-carousel" data-slide-to="1"></li>
				<li data-target="#ad-carousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">

				<div class="item active">
					<img src="images/7.jpg" alt="1 slide">
				</div>

				<div class="item">
					<img src="images/8.jpg" alt="2 slide">
				</div>

				<div class="item">
					<img src="images/9.jpg" alt="3 slide">
				</div>

			</div>
			<a class="left carousel-control" href="#ad-carousel"
				data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
			<a class="right carousel-control" href="#ad-carousel"
				data-slide="next"><span
				class="glyphicon glyphicon-chevron-right"></span></a>
		</div>
		<div class="shopInfoDiv">
			<h1 class="shopNick"></h1>
			<p class=" shopAddr"></p>
			<p class=" shopDesc"></p>
			<hr>
		</div>

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
				<tbody>

				</tbody>
			</table>
			<!-- 订单总信息 -->
			<div class="orderInfo">
				<p>总价：</p>
			</div>
			<div class="btnDiv">
				<a class="btn btn-primary" href="make_sure.jsp">确认订单</a>
			</div>
		</div>
		<ul class="nav nav-tabs" role="tablist">
			<li class="active"><a href="#comment" role="tab"
				data-toggle="tab">评价</a></li>
			<li><a href="#history" role="tab" data-toggle="tab">历史订单</a></li>
		</ul>

		<div class="tab-content">
			<div class="tab-pane active" id="comment">
				<br> <br> <br> <br> <br>
			</div>
			<div class="tab-pane active" id="history">
				<br> <br> <br> <br> <br>
			</div>
		</div>
	</div>


	<%@ include file="footer.jsp"%>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/shopHome.js"></script>
</body>
</html>