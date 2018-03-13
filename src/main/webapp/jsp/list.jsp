<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>雇员管理页面</title>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.5.3/demo/demo.css">
<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>

<%-- <script type="text/javascript"
	src="jsp/js/jquery-1.8.1.min.js"></script> --%>
<script type="text/javascript" src="jsp/list.js"></script>

</head>
<body>
	<h2>雇员管理页</h2>


	<div style="margin-bottom: 20px">
		<form action="search" method="post">
			<input type="text" name="search" id="search" /> <input type="submit"
				value="查找">
		</form>
	</div>
	<div>
		<a class="easyui-linkbutton" href="empCtrl/showEmps.do">所有雇员</a>
	</div>
	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="$('#w').window('open')">添加雇员</a>
	</div>

	<div style="margin: 0 0;"></div>

	<h4>欢迎你，${loginUser.username}</h4>
	<table id="grid">

	</table>
	<!-- 编辑窗口 -->
<div id="mod-window"  class="easyui-window" title="这是编辑窗口" style="width:600px;height:450px"
    data-options="iconCls:'icon-save',modal:true,closed:true" >
    <div style="align:center">
        <form action="empCtrl/updateEmp.do" method="post" id = "updateForm">
			<p>
				雇员编号：<input type="text" name="empid" id = "empid"
					readonly="readonly" />
			</p>
			<p>
				姓名:<input type="text" name="ename" id = "ename" />
			</p>
			<p>
				性别:<input type="radio" name="egender" id = "egender" value="1" /> 男 <input
					type="radio" name="egender" id = "egender" value="0" />女
			</p>
			<p>
				年龄:<input type="text" name="eage" id = "eage"  />
			</p>
			<p>
				电话:<input type="text" name="ephone" id = "ephone" />
			</p>
			<p>
				部门:
				<input id="dept" class="easyui-combobox" style="width:100px" />
			</p>
			<p>
				<input type="button" id = "btn_set" value="修改" />
				<input type="button" value="取消" onclick="history.go(-1)"/>
		</form>
    </div>
</div>
<!--编辑窗口结束  -->
	<shiro:hasPermission name="USER:MOD">
		<div id="mod"></div>
	</shiro:hasPermission>

	<shiro:hasPermission name="USER:DEL">
		<div id="del"></div>
	</shiro:hasPermission>


</body>
</html>
