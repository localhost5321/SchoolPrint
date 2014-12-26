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
    <link href="css/shopControlStyle.css" rel="stylesheet">

  </head>
  
  <body>
  	<%@ include file="header_shop.jsp" %>
  	<div id="index_shop_head">
    <div id="index_shop_body" class="shopInfoDiv" >
    
   <!-- 黎荣恒，在这里添加你的店家首页代码*************************************** -->
   
    </div> <!-- 首页主体  body -->
    
       
    </div><!-- 最外层容器div  container -->
    
    <script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/control_shop.js"></script>
	
	<%@include file="footer.jsp" %>
  </body>
</html>
