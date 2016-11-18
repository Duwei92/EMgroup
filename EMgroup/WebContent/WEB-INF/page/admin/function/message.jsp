<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Bootstrap 实例 - 边框表格</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<style>
.col-center-block {
	float: none;
	display: block;
	margin-left: auto;
	margin-right: auto;
}

th, td {
	text-align: center;
	height: 5px;
}

.checkbox {
	margin: 0px;
	height: 5px;
}
</style>
<script>
	function selectAll() {
		if ($("#selectAll").html() == "(全选)") {
			$(":checkbox").prop("checked", true);
			$("#selectAll").html("(反选)");
		} else {
			$(":checkbox").prop("checked", false);
			$("#selectAll").html("(全选)");
		}
	}

	$(document).ready(function() {
		$("span[data-target='#infoModal']").click(function() {
			var target = $(this).attr('data-target');
			$(target).empty();
			var url = $(this).attr('href');
			$(target).load(url);
		});
		$("span[data-target='#deleteModal']").click(function() {
			var msid = $(this).attr('href');
			$("#mid").val(msid);
		});
	});

	function formReset() {
		document.getElementById("myForm").reset();
	}

	$(function() {
		$("[data-toggle='tooltip']").tooltip();
	});
</script>
</head>
<body>
	<div style="padding: 10px 0px 5px 0px;">
		<form id="myForm" role="form" class="form-inline"
			action="message?method=query" method="post">
			<div class="input-group">
				<span class="input-group-addon">发布人</span> <input type="text"
					class="form-control" name="publisher" placeholder="请输入名字">
			</div>
			<div class="input-group">
				<span class="input-group-addon">生效日</span> <input type="text"
					class="form-control" name="validDay" placeholder="yyyy-mm-dd">
			</div>
			<div class="input-group">
				<span class="input-group-addon">失效日</span> <input type="text"
					class="form-control" name="invalidDay" placeholder="yyyy-mm-dd">
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<div class="btn-group" style="float: right">
				<button type="button" class="btn btn-danger btn-sm"
					onclick="formReset()">重置</button>
				<button type="submit" class="btn btn-success btn-sm">提交</button>
			</div>
			&nbsp;&nbsp;
		</form>
	</div>
	<nav class="navbar navbar-default" role="navigation" style="margin: 0;">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">操作</a>
		</div>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="javascript:void(0)"><span
					href="message?method=new" data-toggle="modal"
					data-target="#infoModal"><span
						class="glyphicon glyphicon-plus"></span> 新消息</span></a></li>
			<li><a href="javascript:void(0)"><span
					href="message?method=delete" data-toggle="modal"
					data-target="#infoModal"><span
						class="glyphicon glyphicon-remove"></span> 删除</span></a></li>
		</ul>
	</div>
	</nav>

	<div style="margin: 0;">
		<table class="table table-bordered table-hover" style="margin: 0;">
			<thead>
				<tr>
					<th>序号<a id="selectAll" href="javascript:selectAll()">(全选)</a></th>
					<th>发布人</th>
					<th>生效日</th>
					<th>失效日</th>
					<th>内容</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:if test="pageContent.size()==0">
				</s:if>
				<s:else>
					<s:iterator var="message" value="pageContent" status="st">
						<tr>
							<td class="col-sm-1">
								<div class="checkbox">
									<label> <input type="checkbox"> ${st.index+1}
									</label>
								</div>
							</td>
							<td class="col-sm-1">${ message.publisher}</td>
							<td class="col-sm-2">${ message.get("validDay")}</td>
							<td class="col-sm-2">${ message.get("invalidDay")}</td>
							<td class="col-sm-4">${ message.get("content")}</td>
							<td class="col-sm-2">
								<div class="btn-group" style="margin: 0">
									<button type="button" class="btn btn-default" style="margin: 0"
										data-toggle="tooltip" title="查看">
										<a><span href="message?method=view&mid=${message.id}"
											data-toggle="modal" data-target="#infoModal"><span
												class="glyphicon glyphicon-list-alt"></span></span></a>
									</button>
									<button type="button" class="btn btn-default" style="margin: 0"
										data-toggle="tooltip" title="修改">
										<a><span href="message?method=update&mid=${message.id}"
											data-toggle="modal" data-target="#infoModal"><span
												class="glyphicon glyphicon-pencil"></span></span> </a>
									</button>
									<button type="button" class="btn btn-default" style="margin: 0"
										data-toggle="tooltip" title="删除">
										<a><span href="${message.id}" data-toggle="modal"
											data-target="#deleteModal"><span
												class="glyphicon glyphicon-trash"></span></span> </a>
									</button>
								</div>

							</td>
						</tr>
					</s:iterator>
				</s:else>
			</tbody>
		</table>
		<div class="row-fluid">
			<!-- 这个从action中传过来  -->
			<h6 style="float: left; display: inline;">&nbsp;&nbsp;共
				${pageContent.size()} 条记录/${pageContent.size()}页 &nbsp;&nbsp;</h6>
			<div style="margin: 2px; float: right;">

				<ul class="pagination" style="display: inline;">
					<li><a href="#">&laquo;</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
				&nbsp;&nbsp;
			</div>
		</div>
	</div>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="infoModal"></div>
	<div class="modal fade" id="deleteModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel" align="center">
						<b>删除消息</b>
					</h4>
				</div>
				<div class="modal-body">
					<center>
						<h4>确认删除消息？</h4>
					</center>
					<form class="bs-example bs-example-form" role="form"
						action="message?method=delete" method="post">
						<input type="hidden" id="mid" name="adminMessage.id" value="" />
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
</body>
</html>