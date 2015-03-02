<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order_history_shop.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>校园云打印商家端</title>
    
    <link href="css/order_historyStyle.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/footerStyle.css" rel="stylesheet">
    

  </head>
  
  <body>
  <%@include file="header_shop.jsp" %>
  <div id="container">
      <div id="index_shop_body">
           <div id="order_total" >
               <table id="total_table">
                   <tr>
                      <td width="25%"><font size="4">今日订单数：</font></td>
                      <td width="25%"><font size="10" color="red">100</font></td>
                      <td width="25%"><font size="4">今日营业额：</font></td>
                      <td width="25%"><font size="10" color="red">998</font></td>
                   </tr>
               </table>
              
           </div><!-- 显示商家当天订单总数和金额div -->
       
            <div id="order_div" align="center">
                 <table class="table table-striped table-bordered table-hover" align="center">
                      <tr>
                         <td  width="15%" align="center">时间</td>
                         <td  width="60%" align="center">订单信息</td>
                         <td  width="15%" align="center">操作</td>
                     </tr>
               <tr>
                  <td align="center">2014.12.25 17:05:30</td>
                  
                  <td align="center"><a href="javascript:void(0)" id="order_details">订单详情</a>
                      <ul id="details_ul">
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
					</ul>
				  </td>
                  <td align="center">
                      <ul>
                          <a href="">订单已处理</a><br>
                          <a href="">下载文档</a>
                      </ul>
                  </td>
               </tr>
            </table>
            </div>
       </div> <!-- 首页主体  body -->
       
       
       <%@include file="footer.jsp" %>
         </div><!-- 最外层容器div  container -->
    
        <script src="js/jquery-2.1.1.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/order_history_shop.js"></script>
		
  </body>
</html>
