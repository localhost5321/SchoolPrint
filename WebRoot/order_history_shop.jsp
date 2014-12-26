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
    

  </head>
  
  <body>
  <%@include file="header_shop.jsp" %>
  <div id="container">
      <div id="index_shop_body">
           <div id="order_total" >
               <table>
                   <tr>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                   </tr>
               </table>
               <!-- <div id="total">
                    <h1>今天订单数：100</h1>
                     <ul>
                     
                        <li>今日订单数：</li>
                        <li>100</li>
                     </ul>
                </div>左边div显示显示订单总数
                
                <div id="turnover">
                    <h1>
                    今日营业额：1000元
                    </h1>
                </div>右边div显示当天营业额
            -->
           
           </div><!-- 显示商家当天订单总数和金额div -->
       
            <div id="order_div" align="center">
                 <table class="order_table" align="center">
                      <tr>
                         <td  width="250" align="center">时间</td>
                         <td  width="250" align="center">订单信息</td>
                         <td  width="250" align="center">操作</td>
                     </tr>
               <tr>
                  <td align="center">2014.12.25 17:05:30</td>
                  
                  <td align="center"><a href="javascript:void(0)" id="order_details">订单详情</a></td>
                  
                  <td align="center">
                      <ul>
                          <a href="">订单已处理</a>
                          <a href="" style="margin-left: 30px">下载文档</a>
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
		<script type="text/javascript" src="js/order_history.js"></script>
		
  </body>
</html>
