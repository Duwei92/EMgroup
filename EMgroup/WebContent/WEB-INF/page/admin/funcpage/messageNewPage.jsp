<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 模态框（Modal） -->
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h5 class="modal-title" id="myModalLabel" align="center">新建消息</h5>
		</div>
		<div class="modal-body">

			<div class="col-md-6 col-center-block">
				<form class="bs-example bs-example-form" role="form" action="login"
					method="post" onsubmit="return validate_form(this)">
					<div class="input-group">
						<span class="input-group-addon">用户名</span> <input type="text"
							class="form-control" placeholder="" name="username">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">密&emsp;码</span> <input
							type="password" class="form-control" name="password">
					</div>
					<br>
					<center>
						<div>
							<button type="button" class="btn btn-primary btn-danger"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-success">提交</button>
						</div>
					</center>
				</form>
			</div>
		</div>
	</div>
</div>
