<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Bootstrap 实例 - 边框表格</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
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
</head>
<body>
	<div style="padding: 10px 0px 5px 0px;">
		<form role="form" class="form-inline">
			<div class="input-group">
				<span class="input-group-addon">名称</span> <input type="text"
					class="form-control" id="name" placeholder="请输入名称">
			</div>
			<div class="input-group">
				<span class="input-group-addon">名称</span> <input type="text"
					class="form-control" id="name" placeholder="请输入名称">
			</div>
			<button type="submit" class="btn btn-default" style="float: right">提交</button>
			&nbsp;&nbsp;
		</form>
	</div>
	<nav class="navbar navbar-default" role="navigation" style="margin: 0;">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">操作</a>
		</div>
		<ul class="nav navbar-nav navbar-left"> 
            <li><a href="javascript:void(0)"><span data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span> 新消息</span></a></li>
            <li><a href="javascript:void(0)"><span data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-remove"></span> 删除</span></a></li>
        </ul> 
	</div>
	</nav>

	<div style="margin: 0;">
		<table class="table table-bordered table-hover" style="margin: 0;">
			<thead>
				<tr>
					<th>序号<a href="#">(全选)</a></th>
					<th>名称</th>
					<th>城市</th>
					<th>密码</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">1
							</label>
						</div>
					</td>
					<td>Tanmay</td>
					<td>Bangalore</td>
					<td>560001</td>
				</tr>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">1
							</label>
						</div>
					</td>
					<td>Tanmay</td>
					<td>Bangalore</td>
					<td>560001</td>
				</tr>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">1
							</label>
						</div>
					</td>
					<td>Tanmay</td>
					<td>Bangalore</td>
					<td>560001</td>
				</tr>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">1
							</label>
						</div>
					</td>
					<td>Tanmay</td>
					<td>Bangalore</td>
					<td>560001</td>
				</tr>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">1
							</label>
						</div>
					</td>
					<td>Tanmay</td>
					<td>Bangalore</td>
					<td>560001</td>
				</tr>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">1
							</label>
						</div>
					</td>
					<td>Tanmay</td>
					<td>Bangalore</td>
					<td>560001</td>
				</tr>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">1
							</label>
						</div>
					</td>
					<td>Tanmay</td>
					<td>Bangalore</td>
					<td>560001</td>
				</tr>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">1
							</label>
						</div>
					</td>
					<td>Tanmay</td>
					<td>Bangalore</td>
					<td>560001</td>
				</tr>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">2
							</label>
						</div>
					</td>
					<td>Sachin</td>
					<td>Mumbai</td>
					<td>400003</td>
				</tr>
				<tr>
					<td>
						<div class="checkbox">
							<label> <input type="checkbox">3
							</label>
						</div>
					</td>
					<td>Uma22222</td>
					<td>Pune</td>
					<td>411027</td>
				</tr>
			</tbody>
		</table>
		<div class="row-fluid">
			<h6 style="float: left; display: inline;">&nbsp;&nbsp;共15条记录/2页
				&nbsp;&nbsp;</h6>
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<div class="modal-body">
				在这里添加一些文本
			</div>
			<div class="modal-footer">
				<a   class="btn" data-dismiss="modal">关闭</a>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>