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
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${sessionScope.user == null}">
						<li><a href="#" data-toggle="modal" data-target="#loginModal">登陆</a>
						</li>
						<li><a href="#" data-toggle="modal"
							data-target="#registerModal">注册</a></li>
					</c:when>
					<c:when test="${sessionScope.user != null}">
						<li><a href="#">欢迎你：${sessionScope.user.userName}</a>
						</li>
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
					<!--记住密码选项-->
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input type="checkbox"> 记住密码
								</label>
							</div>
						</div>
					</div>
				</div>
				<!--登陆窗口底部-->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						取消</button>
					<button type="button" class="btn btn-primary" onclick="login()">登陆</button>
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
					<div class="form-group">
						<label for="loginUsername" class="col-sm-3 control-label">用户名：</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" id="loginUsername"
								name="user.userName" placeholder="输入用户名">
						</div>
					</div>
					<!--输入密码-->
					<div class="form-group">
						<label for="loginPassword" class="col-sm-3 control-label">密码：</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" id="loginPassword"
								placeholder="输入密码">
						</div>
					</div>
					<!--确认密码-->
					<div class="form-group">
						<label for="loginPassword" class="col-sm-3 control-label">确认密码：</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" id="loginPassword"
								name="user.userPwd" placeholder="再次输入密码">
						</div>
					</div>
					<!--邮箱-->
					<div class="form-group">
						<label for="loginEmail" class="col-sm-3 control-label">注册邮箱：</label>
						<div class="col-sm-7">
							<input type="email" class="form-control" id="loginEmail"
								name="user.email" placeholder="输入邮箱">
						</div>
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