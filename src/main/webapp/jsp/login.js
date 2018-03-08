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
				type : 'post',
				 data :{
					userName : userName,
					password : password,
					rememberMe : rememberMe
				},
//				dataType : "json",
				success : function(data){
//					$("#resultArea").html(htmlobj.responseText);

					if (data && data.rtnCode == 0)
					{
						var url = "jsp/list.jsp";
//						if (data.data.userFlag == '3')
//						{
//							url = "jsp/indexForInd.jsp";
//						}
						window.location.href = url;
					}
					else
					{
						$$.ui.Alert(
						{
							title : $.tips.TITLE_TIP,
							html : data.rtnMsg
						});
						mask.unmask();
					}
				
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
		alert("[按键]被点击了一下");
	});
});