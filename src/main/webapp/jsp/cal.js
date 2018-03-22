$(document).ready(function() {
	
	$.ajax({
		type : "POST",
		url : "calCtrl/getCals.do",
		traditional : true,
		data : {
			empid : id
			
		},
		success : function(html) {
			$.messager.alert('网页信息','删除成功!','info');
//			myGrid.reload();
			  $("#grid").datagrid("reload");
		},
		fail : function(html) {
			$.messager.alert('网页信息','删除失败。。','warning');
			$("#grid").datagrid("reload");
		},
		error : function(
				XMLHttpRequest,
				textStatus,
				errorThrown) {
			$.messager.alert('网页信息','删除数据出错!','error');
			$("#grid").datagrid("reload");
		}
	});
	
//	$('#cal').calendar({
//		height:280,
//		width:280,
//		specialDates:'2018-03-21',
//		onSelect: function(date){
//			
//			$('#cal-window').window('open');
////			alert(date.getFullYear()+":"+(date.getMonth()+1)+":"+date.getDate());
//		}
//	});
	var a=["2018-03-20","2018-03-17"];
	
	WdatePicker({
		eCont:'cal',
		height:280,
		width:280,
		specialDates:a
	});
	
//	取消按键
	 $("#cel").click(function(){
    	 $('#cal-window').window('close');
    });
//重置按键
	 $("#reset").click(function(){
		 $("#startDate").val("");
		 $("#endDate").val("");
		 $("#title").val("");
		 $("#desc").val("");
    	 
    });
})
