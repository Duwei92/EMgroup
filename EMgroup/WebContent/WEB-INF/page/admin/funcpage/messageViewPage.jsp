<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel" align="center">
				<b>查看消息</b>
			</h4>
		</div>
		<div class="modal-body">

			<div class="col-md-6 col-center-block">

				<div class="input-group">
					<span class="input-group-addon">发布人</span> <input type="text"
						class="form-control" readonly value="${adminMessage.publisher }">
				</div>
				<br />
				<div class="input-group">
					<span class="input-group-addon">生效日</span> <input type="text"
						class="form-control" readonly
						value="${adminMessage.get('validDay') }">
				</div>
				<br />
				<div class="input-group">
					<span class="input-group-addon">失效日</span> <input type="text"
						class="form-control" readonly
						value="${adminMessage.get('invalidDay') }">
				</div>
				<br />
				<div>
					<center>
						<label>消息内容</label>
					</center>
					<textarea readonly class="form-control" rows="4"> ${adminMessage.content }</textarea>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<center>
				<button type="button" class="btn btn-success" data-dismiss="modal">关闭</button>
			</center>
		</div>

	</div>
</div>

