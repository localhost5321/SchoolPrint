<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 顶部导航 -->
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation"
	id="menu-nav">
	<div class="container">
		<!--导航头-->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">校园云打印</a>
		</div>
		<!--导航体-->
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li id="navBarIndex" class="active"><a href="">首页</a></li>
				<li id="navBarPrint"><a href="print.jsp">打印</a></li>
				<li id="navBarDocCenter"><a
					href="javascript:alert('程序猿正在加班工作中...')">文档中心</a></li>
				<li id="navBarAbout"><a href="" data-toggle="modal"
					data-target="#aboutUs">关于</a>
				<li id="navBarNote"><a href="">留言</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right" id="navbarUserInfo">
				<c:choose>
					<c:when test="${sessionScope.user == null}">
						<li><a href="javascript:void(0)" data-toggle="modal"
							data-target="#loginModal">登陆</a></li>
						<li><a href="javascript:void(0)" data-toggle="modal"
							data-target="#registerModal">注册</a></li>
					</c:when>
					<c:when test="${sessionScope.user != null}">
						<li><a href="javascript:void(0)" class="dropdown-toggle"
							data-toggle="dropdown">欢迎你：${sessionScope.user.userName}<span
								class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0)"
									onclick="exit();">退出</a></li>
							</ul></li>
					</c:when>
				</c:choose>
			</ul>
		</div>
	</div>
</div>
<!--导航结束-->

<!-- 登陆窗口 -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">用户登陆</h4>
			</div>
			<!--登陆窗口内容-->
			<!--登陆表单-->
			<form class="form-horizontal" role="form" action="userLogin.action"
				method="post" id="loginForm">
				<div class="modal-body">
					<!--输入用户名-->
					<div class="form-group">
						<label for="loginUsername" class="col-sm-2 control-label">用户名：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="loginUsername"
								name="user.userName" placeholder="输入用户名">
						</div>
					</div>
					<!--输入密码-->
					<div class="form-group">
						<label for="loginPassword" class="col-sm-2 control-label">密码：</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="loginPassword"
								name="user.userPwd" placeholder="输入密码"> 
						</div>
					</div>
					<!--登陆信息-->
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<span id="loginInfo"  style="color:red"></span>
						</div>
					</div>
				</div>
				<!--登陆窗口底部-->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
					<button type="button" class="btn btn-primary" onclick="login();">登陆</button>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- 注册窗口 -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
	aria-labelledby="registerModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="registerModalLabel">用户注册</h4>
			</div>
			<!--注册窗口内容-->
			<!--注册表单-->
			<form class="form-horizontal" role="form" action="userRegist.action"
				method="post" id="registForm">
				<div class="modal-body">
					<!--输入用户名-->
					<div class="form-group" id="registUsernameDiv">
						<label for="registUsername" class="col-sm-3 control-label">用户名：</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="registUsername"
								name="user.userName" placeholder="输入用户名"> <span class=""
								id="registUsernameIcon"></span>
						</div>
						<span class="help-block col-sm-3" id="registUsernameInfo"
							style="padding:0px;"></span>
					</div>
					<!--输入密码-->
					<div class="form-group" id="registPasswordDiv">
						<label for="registPassword" class="col-sm-3 control-label">密码：</label>
						<div class="col-sm-6">
							<input type="password" class="form-control " id="registPassword"
								placeholder="输入密码"> <span class=""
								id="registPasswordIcon"></span>
						</div>
						<span class="help-block col-sm-3" id="registPasswordInfo"
							style="padding:0px;"></span>
					</div>
					<!--确认密码-->
					<div class="form-group" id="registPasswordAgainDiv">
						<label for="registPasswordAgain" class="col-sm-3 control-label">确认密码：</label>
						<div class="col-sm-6">
							<input type="password" class="form-control"
								id="registPasswordAgain" name="user.userPwd"
								placeholder="再次输入密码"> <span class=""
								id="registPasswordAgainIcon"></span>
						</div>
						<span class="help-block col-sm-3" id="registPasswordAgainInfo"
							style="padding:0px;"></span>
					</div>
					<!--邮箱-->
					<div class="form-group" id="registEmailDiv">
						<label for="loginEmail" class="col-sm-3 control-label">注册邮箱：</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="registEmail"
								name="user.email" placeholder="输入邮箱"> <span class=""
								id="registEmailIcon"></span>
						</div>
						<span class="help-block col-sm-3" id="registEmailInfo"
							style="padding:0px;"></span>
					</div>
					<!--电话号码-->
					<div class="form-group" id="registPhoneDiv">
						<label for="registPhone" class="col-sm-3 control-label">手机号：</label>
						<div class="col-sm-6">
							<input type="tel" class="form-control" id="registPhone"
								name="user.userPhone" placeholder="输入手机号码"> <span class=""
								id="registPhoneIcon"></span>
						</div>
						<span class="help-block col-sm-3" id="registPhoneInfo"
							style="padding:0px;"></span>
					</div>
				</div>
				<!--注册窗口底部-->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
					<button type="button" class="btn btn-primary" onclick="regist()">注册</button>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- 关于窗口 -->
<div class="modal fade" id="aboutUs" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">关于我们</h4>
			</div>
			<!--窗口内容-->
			<div class="modal-body">
				<p>专注校园云打印</p>
			</div>
			<!--窗口尾部-->
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">
					知道了</button>
			</div>
		</div>
	</div>
</div>

<script src="js/header.js"></script>
