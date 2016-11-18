<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 模态框（Modal） -->
<script>
	$('.form_date').datetimepicker({
		language : 'ee',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});
</script>
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel" align="center">
				<b>修改消息</b>
			</h4>
		</div>
		<div class="modal-body">

			<div class="col-md-6 col-center-block">
				<form class="bs-example bs-example-form" role="form"
					action="message?method=add" method="post">
					<div class="form-group" style="margin: 0">
						<input type="hidden" name="adminMessage.id"
							value="${adminMessage.id }" />
					</div>
					<div class="form-group" style="margin: 0">
						<label for="name">发布人</label> 
						<input class="form-control" type="text" readonly
							name="adminMessage.publisher" value="${adminMessage.publisher }" />
					</div>
					<br>
					<div class="form-group" style="margin: 0">
						<label for="dtp_input2" class="control-label">生效日期</label>
						<div class="input-group date form_date" data-date=""
							data-date-format="dd MM yyyy" data-link-field="dtp_input2"
							data-link-format="yyyy-mm-dd">
							<input name="validDay" class="form-control" size="16" type="text"
								value="${adminMessage.get('validDay') }" readonly> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-remove"></span></span> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-calendar"></span></span>
						</div>
						<input type="hidden" id="dtp_input2" value="" /><br />
					</div>
					<div class="form-group" style="margin: 0">
						<label for="dtp_input2" class="control-label">失效日期</label>
						<div class="input-group date form_date" data-date=""
							data-date-format="dd MM yyyy" data-link-field="dtp_input2"
							data-link-format="yyyy-mm-dd">
							<input name="invalidDay" class="form-control" size="16"
								type="text" value="${adminMessage.get('invalidDay')}" readonly>
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-remove"></span></span> <span
								class="input-group-addon"><span
								class="glyphicon glyphicon-calendar"></span></span>
						</div>
						<input type="hidden" id="dtp_input2" value="" /><br />
					</div>
					<div class="form-group" style="margin: 0">
						<label for="name">消息内容</label>
						<textarea name="adminMessage.content" class="form-control"
							rows="4">${adminMessage.content}</textarea>
					</div>
					<br>

					<center>
						<div>
							<button type="button" class="btn btn-primary btn-danger"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-success">提交</button>
						</div>
					</center>

					<!-- <div class="modal-footer">
					 <h6 align="left">新建消息</h6>
					 </div> -->
				</form>
			</div>
		</div>
	</div>
</div>
