<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>校园云打印(商家版)</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="css/index_shopStyle.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/footerStyle.css" rel="stylesheet">

</head>

<body>
	<%@ include file="header_shop.jsp"%>

	<div id="container">
		<div id="index_shop_body" class="shopInfoDiv">

			<div id="shop_msg_detail">

				<h3 align="center">弘辰桥洞打印</h3>

				<table align="center">

					<tr>
						<td>单面打印：</td>
						<td>0.1元/页</td>
						<td>双面打印：</td>
						<td>0.15元/页</td>
					</tr>
					<tr>
						<td>单面彩印：</td>
						<td>1.0元/页</td>
						<td>双面彩印：</td>
						<td>1.5元/页</td>
					</tr>
					<tr>
						<td>最新优惠信息：</td>
						<td>本店开张大吉，凡打印满二十元免费送货上门</td>
					</tr>

				</table>
				<!-- 店铺当天商品单价信息和优惠信息 -->

			</div>
			<!-- 商店当天信息 -->
			<div id="order_div">

				<table class="table table-striped table-bordered table-hover"
					align="center" id="order_table">
					<tr>
						<td width="15%" align="center">时间</td>
						<td width="60%" align="center">订单信息</td>
						<td width="15%" align="center">操作</td>
					</tr>

					<tr id="order">
						<td align="center">2014.12.25 17:05:30</td>
						<td align="center">
						    <a href="javascript:void(0)" class="order_details">订单详情</a><br>
							<ul class="details_ul">
								<table width="90%" id="order_item_tb"
									class="table table-striped table-bordered table-hover">
									<tr>
										<td align="center">文件名</td>
										<td align="center">页数</td>
										<td align="center">打印要求</td>
										<td align="center">打印份数</td>
										<td align="center">备注</td>
									</tr>
									<tr>
										<td align="center">软件项目管理文档</td>
										<td align="center">30页</td>
										<td align="center">单面 A4纸</td>
										<td align="center">2份</td>
										<td align="center">我二十分钟后去取</td>
									</tr>
								</table>
								<span>电话：13027342004</span>
								<span>地址：弘辰6-406</span>
							</ul></td>
						<td align="left">
							<ul>
								<a >接收订单</a>
								<a>下载文档</a>
							</ul>
						</td>
					</tr>
				</table>
				
				<input id="add_button" type="button" value="增加一行"/>
			</div>
		</div><!-- 首页主体  body -->
	</div>
	<!-- 最外层容器div  container -->

	<%@include file="footer.jsp"%>

	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/index_shop.js"></script>
</body>
</html>
