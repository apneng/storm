<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>雇员修改页面</title>
<link rel="stylesheet" type="text/css"
	href="${ctx }/jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx }/jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${ctx }/jquery-easyui-1.5.3/demo.css">
<script type="text/javascript"
	src="${ctx }/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx }/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
</head>
<body>
	<div id="w" class="easyui-window" title="修改雇员信息"
		data-options="iconCls:'icon-save'"
		style="width: 400px; height: 300px; padding: 10px;">

		<form action="done" method="post">
			<p>
				雇员编号：<input type="text" name="empid" value="${e.empid}"
					readonly=”readonly />
			</p>
			<p>
				姓名:<input type="text" name="ename" value="${e.ename}" />
			</p>
			<p>
				性别:<input type="radio" name="egender" value="1" checked /> 男 <input
					type="radio" name="egender" value="0" />女
			</p>
			<p>
				年龄:<input type="text" name="eage" value="${e.eage}" />
			</p>
			<p>
				电话:<input type="text" name="ephone" value="${e.ephone}" />
			</p>
			<p>
				部门:<select name="deptid">
					<option value="${e.deptid }">${e.dept.dname}</option>
					<c:forEach items="${deptList }" var="deptList">
						<option value="${deptList.deptid }">${deptList.dname }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<input type="submit" value="修改" />
				<input type="button" value="取消" onclick="history.go(-1)"/>
		</form>

	</div>
</body>
</html>