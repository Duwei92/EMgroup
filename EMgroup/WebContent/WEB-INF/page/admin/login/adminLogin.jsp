<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<link rel="stylesheet" type="text/css" href="/EMgroup/css/login.css">
<script type="text/javascript" src="/EMgroup/js/login.js"></script>
</head>
<body>
	<div id="header">EMgroup后台管理系统</div>
	<br />
	<p class=title></p>
	<br />

	<div align="center" id="center">
		<s:form action="adminlogin" method="post"
			onsubmit="return validate_form(this)">
			<s:label>后台管理系统</s:label>
			<s:textfield  label="用户名" id="username" type="text" name="adminForm.name" value="">
			</s:textfield>
			<s:textfield label="密        码" id="password" type="password" name="adminForm.password" value=""></s:textfield>  <br /> <br />
			<s:submit value="登    陆 " align="center"></s:submit>
		</s:form>
	</div>

	<br />
	<p class=title></p>
	<footer id="footer"> Copyright@DSL </footer>
</body>
</html>