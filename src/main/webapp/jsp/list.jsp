<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>雇员管理页面</title>
<link rel="stylesheet" type="text/css"
	href="${ctx }/jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctx }/jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${ctx }/jquery-easyui-1.5.3/demo/demo.css">
<script type="text/javascript"
	src="${ctx }/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx }/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	
<script type="text/javascript"
	src="${ctx }/jsp/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="${ctx }/jsp/list.js"></script>
	
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
		<a class="easyui-linkbutton" href="list">所有雇员</a>
	</div>
	<div style="margin: 20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="$('#w').window('open')">添加雇员</a>
	</div>

	<div style="margin: 0 0;"></div>

	<!-- <table class="easyui-datagrid" id="dg">
		
	</table> -->
	<table class="easyui-datagrid" style="width:700px;height:250px"  
        data-options="url:'showEmps.do',fitColumns:true,singleSelect:true">  
    <thead>  
        <tr>  
            <th data-options="field:'empid',width:100">ID</th>  
            <th data-options="field:'ename',width:100">姓名</th>  
            <th data-options="field:'egender',width:100">性别</th>  
            <th data-options="field:'eage',width:100">年龄</th>  
            <th data-options="field:'dname',width:100">所属部门</th>  
            <th data-options="field:'ephone',width:100,align:'right'">电话号码</th>  
        </tr>  
    </thead>  
</table>
	<!-- 添加雇员信息弹出窗口 开始 -->
	<div id="w" class="easyui-window" title="添加新雇员"
		data-options="iconCls:'icon-save',closed:true"
		style="width: 400px; height: 300px; padding: 10px;">

		<form action="add" method="post">
			<p>
				姓名:<input type="text" name="ename" />
			</p>
			<p>
				性别:<input type="radio" name="egender" value="1" checked /> 男 <input
					type="radio" name="egender" value="0" />女
			</p>
			<p>
				年龄:<input type="text" name="eage" />
			</p>
			<p>
				电话:<input type="text" name="ephone" />
			</p>
			<p>
				部门:<select name="deptid">
					<option>--请选择--</option>
					<c:forEach items="${deptList }" var="deptList">
						<option value="${deptList.deptid }">${deptList.dname }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<input type="submit" value="添加" /> <input type="reset" value="重置" />
		</form>

	</div>
	<!-- 添加雇员信息弹出窗口 结束-->

</body>
</html>
