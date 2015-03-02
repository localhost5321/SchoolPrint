<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="container-fluid footer">
	<div class="foot-box">
		<ul class="list-inline">
			<li><a data-toggle="modal" href="#">联系我们</a></li>
			<li><a href="#">意见反馈</a></li>
			<li><a href="#">关于我们</a></li>
			<li><a href="#">一起合作</a></li>
		</ul>
	</div>
</div>

<!-- 意见反馈窗口 -->
	<div class="modal fade" id="adviceModal" tabindex="-1" role="dialog"
		aria-labelledby="adviceModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="adviceModalLabel">意见反馈</h4>
				</div>
				<!--内容-->
				<!--表单-->
				<form class="form-horizontal" role="form"
					action="http://www.baidu.com">
					<div class="modal-body">
						<!--输入用户名-->
						<div class="form-group">
							<label for="loginUsername" class="col-sm-3 control-label">用户名：</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="loginUsername"
									placeholder="输入用户名">
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
									placeholder="再次输入密码">
							</div>
						</div>
					</div>
					<!--注册窗口底部-->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							取消</button>
						<button type="submit" class="btn btn-primary">注册</button>
					</div>
				</form>
			</div>
		</div>
	</div><!-- 意见反馈窗口结束 -->