<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>登陆页</title>
 <script type="text/javascript"
	src="jsp/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="jsp/login.js"></script>
</head>
<body>
<div style="width: 700px;height: 400px;align:center;">
	<div align="center">
		<p>用户名：<input id = "userName" type = "text" name = "userName" /></p>
		<p>密码：<input id = "password" type = "password" name = "password"  /></p>
		<p><input type = "checkbox" id = "rememberMe" name = "rememberMe" checked = "checked"/>记住我</p>
		<p><input type = "button" id = "btn_submit" value = "登陆" />&nbsp;&nbsp;&nbsp;<input type = "button" id ="btn_reset" value = "重置"/></p>
	</div>
	<hr/>
	<form action = "userCtrl/ddd.do" method ="post">
	<input name = "yonghu" id = "yonghu" />
		<input type = "submit" id = "btn_anjian"value = "按键" />
	</form>
	<hr/>
	<div align="center">
	<h3>结果展示</h3>
	<p align="left" id = "resultArea"></p>

	
	</div>

</div>
</body>
</html>