<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
    <!-- 日程表 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<meta charset="UTF-8">
<title>日程表</title>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.5.3/demo/demo.css">
<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	<script type="text/javascript"
	src="<%=basePath%>/My97DatePicker/WdatePicker.js"></script><!--绝对路径  -->
<script type="text/javascript" src="jsp/cal.js"></script>
<!-- <script type="text/javascript"
	src="jsp/js/jquery-1.8.1.min.js"></script> -->
</head>
<body>
<!-- 日历块 -->
<div id="cal" ></div>
<!-- 日程设置弹窗 开始 -->
<div id="cal-window"  class="easyui-window" title="这是编辑窗口" 
    data-options="iconCls:'icon-save',modal:true,closed:true" >
    <div style="align:center">
        <form action="calCtrl/insertOrUpdate.do" method="post" id = "updateForm">
			<p>
				开始时间：<input type="text" name="startDate" id = "startDate" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
			</p>
			<p>
				结束时间:<input type="text" name="endDate" id = "endDate" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
			</p>
		
			<p>
				事件标题:<input type="text" name="title" id = "title" />
			</p>
			<p>
				简要描述:<input type="text" name="calDesc" id = "calDesc" class="easyui-textbox" data-options="multiline:true"/>
			</p>
	
			<p>
				<input type="submit"  value="确定" />
				<input type="button"  value="重置" id ="reset" />
				<input type="button" value="取消" id = "cel"/>
				<input type="button" value="删除该日程" id = "delete"/>
				<input type = "hidden" id="entWho" name = "entWho" value=${loginUser.id}>
				<input type = "hidden" id="calid" name = "calid" >
		</form>
    </div>
</div>
<!-- 日程设置弹窗结束 -->
<div id="info-window"  class="easyui-window" title="查看日程" 
    data-options="iconCls:'icon-save',modal:true,closed:true,inline:false" >
    <div style="align:center">
       <div id = "info" style="width:280px;height:280px">
       	<ul id = "showCal"></ul>
       </div>
    </div>
</div>
</body>
</html>