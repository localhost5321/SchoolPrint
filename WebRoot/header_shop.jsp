<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
      <!-- 顶部导航 -->
		<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="menu-nav">
			<div class="container">
				<!--导航头-->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">切换导航</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index_shop.jsp">校园云打印(商家版)</a>
				</div>
				<!--导航体-->
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li id="navBarIndex_shop">
							<a href="index_shop.jsp">首页</a>
						</li>
						<li id="navControl_shop">
							<a href="control_shop.jsp">控制中心</a>
						</li>
						<li id="navBarOrderHistory_shop">
							<a href="order_history_shop.jsp">历史订单</a>
						</li>
						<li id="navBarComments_shop">
							<a href="#" data-toggle="modal" data-target="#aboutUs">查看评论</a>
						</li>
						<li id="navBarrefund_shop">
						    <a href="#" data-toggle="modal" data-target="">退款管理</a>
						
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#" data-toggle="modal" data-target="#loginModal">登陆</a>
						</li>
						<li>
							<a href="#" data-toggle="modal" data-target="#registerModal">注册</a>
						</li>
					</ul>
				</div>
			</div>
		</div><!--导航结束-->
		
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
					<form class="form-horizontal" role="form" action="http://www.baidu.com">
						<div class="modal-body">
							<!--输入用户名-->
							<div class="form-group">
								<label for="loginUsername" class="col-sm-2 control-label">用户名：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="loginUsername" placeholder="输入用户名">
								</div>
							</div>
							<!--输入密码-->
							<div class="form-group">
								<label for="loginPassword" class="col-sm-2 control-label">密码：</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="loginPassword" placeholder="输入密码">
								</div>
							</div>
							<!--记住密码选项-->
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<div class="checkbox">
										<label>
											<input type="checkbox">
											记住密码 </label>
									</div>
								</div>
							</div>
						</div>
						<!--登陆窗口底部-->
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">
								取消
							</button>
							<button type="submit" class="btn btn-primary">
								登陆
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- 注册窗口 -->
		<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
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
					<form class="form-horizontal" role="form" action="http://www.baidu.com">
						<div class="modal-body">
							<!--输入用户名-->
							<div class="form-group">
								<label for="loginUsername" class="col-sm-3 control-label">用户名：</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" id="loginUsername" placeholder="输入用户名">
								</div>
							</div>
							<!--输入密码-->
							<div class="form-group">
								<label for="loginPassword" class="col-sm-3 control-label">密码：</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" id="loginPassword" placeholder="输入密码">
								</div>
							</div>
							<!--确认密码-->
							<div class="form-group">
								<label for="loginPassword" class="col-sm-3 control-label">确认密码：</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" id="loginPassword" placeholder="再次输入密码">
								</div>
							</div>
						</div>
						<!--注册窗口底部-->
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">
								取消
							</button>
							<button type="submit" class="btn btn-primary">
								注册
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
       
