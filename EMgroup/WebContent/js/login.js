$(document).ready(function() {
	$.toaster({
		settings : {
			'toaster' : {
				'id' : 'toaster',
				'container' : 'body',
				'template' : '<div></div>',
				'class' : 'toaster',
				'css' : {
					'position' : 'fixed',
					'top' : '0px',
					'right' : '575px',
					'width' : '250px',
					'zIndex' : 50000
				}
			},
			
		}
	});
});

function validate_required(field, alerttxt) {
	with (field) {
		if (value == null || value == "") {
			$.toaster({
				priority : 'warning',
				title : '输入错误',
				message : alerttxt
			});
			return false;
		} else {
			return true;
		}
	}
}

function validate_form(thisform) {
	with (thisform) {
		if (validate_required(username, "用户名不能为空") == false) {
			username.focus();
			return false;
		} else if (validate_required(password, "请输入密码") == false) {
			password.focus();
			return false;
		}
	}
}