$(document).ready(function() {
	// alert("aaa");

	// 回车登陆
	$("body").keypress(function(event) {
		if (event.keyCode == 13) {
			$("#btn_submit").click();
		}
	});

	// 登陆
	$("#btn_submit").click(function() {
		var userName = $('#userName').val();
		var password = $('#password').val();
		var rememberMe = $('#rememberMe').is(':checked');
//		alert(userName);
//		alert(password);
//		alert(rememberMe);
		if (userName == "" || userName == null) {
			alert("用户名不能为空");
		} else if (password == "" || password == null) {
			alert("密码不能为空");

		} else {
			htmlobj = $.ajax({
				url : "userCtrl/checkLogin.do",
				 data :{
					userName : userName,
					password : password,
					rememberMe : rememberMe
				},
//				dataType : "json",
				success : function(data){
					$("#resultArea").html(data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$("#resultArea").html(textStatus);
				}
			});
//			$("#resultArea").html(htmlobj.responseText);
		}
	});
	// 重置
	$("#btn_reset").click(function() {
		$('#userName').val("");
		$('#password').val("");
	});
	//按键
	$("#btn_anjian").click(function() {
		alert("点击了一下");
	});
});