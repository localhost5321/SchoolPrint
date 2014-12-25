<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.js"></script>
		<![endif]-->

</head>

<body>
	<%@ include file="header.jsp" %>

	<!-- 广告轮播 -->
	<div id="ad-carousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
			<li data-target="#ad-carousel" data-slide-to="1"></li>
			<li data-target="#ad-carousel" data-slide-to="2"></li>
			<li data-target="#ad-carousel" data-slide-to="3"></li>
			<li data-target="#ad-carousel" data-slide-to="4"></li>
		</ol>
		<div class="carousel-inner">

			<div class="item active">
				<img src="images/1.jpg" alt="1 slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>校园云打印</h1>
						<p>校园云打印，你的不二选择。</p>
					</div>
				</div>
			</div>

			<div class="item">
				<img src="images/2.jpg" alt="2 slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>校园云打印上线拉</h1>
						<p>妈妈再也不用担心我的U盘了！</p>
					</div>
				</div>
			</div>

			<div class="item">
				<img src="images/3.jpg" alt="3 slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>南华大学出版</h1>
						<p>一切只为更好的你。</p>
					</div>
				</div>
			</div>

			<div class="item">
				<img src="images/4.jpg" alt="4 slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>新版亮点</h1>
						<p>全新改版，一键打印更方便！</p>
					</div>
				</div>
			</div>

			<div class="item">
				<img src="images/5.jpg" alt="5 slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>在路上</h1>
						<p>更多内容，敬请期待！</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#ad-carousel" data-slide="prev"><span
			class="glyphicon glyphicon-chevron-left"></span></a> <a
			class="right carousel-control" href="#ad-carousel" data-slide="next"><span
			class="glyphicon glyphicon-chevron-right"></span></a>
	</div>

	<div class="btnDiv">
		<button class="btn btn-primary startPrint" onclick="window.location.href='print.jsp'">立即打印！</button>
	</div>

	<%@ include file="footer.jsp" %>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
