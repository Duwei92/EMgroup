function validate_required(field, alerttxt) {
	with(field) {
		if(value == null || value == "") {
			alert(alerttxt);
			return false;
		} else {
			return true;
		}
	}
}

function validate_form(thisform) {
	with(thisform) {
		if(validate_required(username, "用户名不能为空") == false) {
			username.focus();
			return false;
		} else if(validate_required(password, "请输入密码") == false) {
			password.focus();
			return false;
		}
	}
}