<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/shopControlStyle.css" rel="stylesheet">
<link href="css/footerStyle.css" rel="stylesheet">

</head>

<body>
	<%@ include file="header_shop.jsp"%>
	<div id="container">
		<div id="shop_control_head">
			<div id="shop_control_body" class="shopInfoDiv">
				<br> <br>
				<form action="" role="form" class="form-horizontal">
					<div class="modal-body">
						<!--店名-->
						<div class="form-group">
							<label class="col-sm-2 control-label">您的店名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control">
							</div>
						</div>
					</div>



					<br> <a href="javascript:void(0)" id="editInfo">编辑信息</a>
					<button id="btnSave">保存</button>
				</form>
			</div>
			<!-- 店家控制中心body  body -->
		</div>





	</div>
	<!-- 最外层容器div  container -->


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<%@include file="footer.jsp"%>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/control_shop.js"></script>


</body>
</html>
