<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>雇员修改页面</title>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.5.3/demo.css">
<script type="text/javascript"
	src="jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jsp/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="jsp/update.js"></script>

</head>
<body >

		<form action="done" method="post">
			<p>
				雇员编号：<input type="text" name="empid" 
					readonly="readonly" />
			</p>
			<p>
				姓名:<input type="text" name="ename"  />
			</p>
			<p>
				性别:<input type="radio" name="egender" value="1" checked /> 男 <input
					type="radio" name="egender" value="0" />女
			</p>
			<p>
				年龄:<input type="text" name="eage"  />
			</p>
			<p>
				电话:<input type="text" name="ephone"  />
			</p>
			<p>
				部门:<select name="deptid">
					<option ></option>
				</select>
			</p>
			<p>
				<input type="submit" value="修改" />
				<input type="button" value="取消" onclick="history.go(-1)"/>
		</form>

	
</body>
</html>