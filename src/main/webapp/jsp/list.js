$(document).ready(function() {
	  $('#grid').datagrid({
		 title: '用户列表',
         width: 900,
         height: 300,
        fitColumns: false,
		url : 'empCtrl/showEmps.do',
		dom : '#grid',
		columns : [[
				{
					title : '用户ID',
					field : 'empid',
					align : "center",
					width : '100', 
					hidden : false
				
				},
				{
					title : '姓名',
					field : 'ename',
					align : "center",
					width : '100', 
					sortable : false

				},
				{
					title : '性别',
					field : 'egender',
					formatter:function(value,row,index){
						 if(value == 1){
							 return '男';
						 }else if(value == 0){
							 return '女';
						 }else{
							 return '未知';
						 }
						 return value;
					 },
					align : "center",
					width : '70', 
					sortable : false
				},
				{
					title : '年龄',
					field : 'eage',
					width : '70', 
					align : "center",
					sortable : false

				},
				{
					title : '电话号码',
					field : 'ephone',
					width : '150', 
					align : "left",
					sortable : false

				},
				{
					title : '所在部门',
					field : 'dname',
					width : '100', 
					align : "center",
					sortable : false

				},
				{
					title : '操作选项',
					field : 'operate',
					width : '160',
					align : "center",
					formatter : function(value, row, index){
						var e = '<a href="javascript:void(0)" id = "'+row.empid+'" name="mod" class="easyui-linkbutton" ></a>'
						var d =	'<a href="javascript:void(0)" id = "'+row.empid+'" name="del" class="easyui-linkbutton" ></a>'; 
						
//						if($('#mod').length == 0){
//							   e = '';
//						    }
//						    
//						    if($('#del').length == 0){
//								   d = '';
//							}
						
						return  e + d; 
						},
				
					
				}]],
				//操作
				onLoadSuccess:function(data){    
			        $("a[name='mod']").linkbutton({
			        	text:'编辑',
			        	plain:true,
			        	iconCls:'icon-edit'
			        });  
			        
			        
			        $("a[name='del']").linkbutton({
			        	text:'删除',
			        	href:'jsp/404.jsp',
			        	plain:true,
			        	iconCls:'icon-remove'
			        });    
			        
			        //动作
			        $("A[oper='mod']").unbind("click");
			        $("a[name='mod']") .bind('click', function(){
			        	var id = $(this).attr("id");
			        
			        	var $win = $('#mod-window').window({
			    		    title: '这是编辑窗口',
			    		    width: 600,
			    		    height: 450,
			    		    $.ajax({
			    				url : "userCtrl/checkLogin.do",
			    				type : 'post',
			    				 data :{
			    					empid : id
			    				},
			    				success : function(data){
			    					
			    				},
			    				error : function(XMLHttpRequest, textStatus, errorThrown) {
			    					$("#resultArea").html(textStatus);
			    				}
			    			});
//			    		    params : {
//								id : id,
//								callback : function(){
//									$("#grid").datagrid("reload");
//									$win.window('close');
//								}
//							}
			    		});
			        	$win.window('open');
			        });
			        //删除操作
			        $("A[oper='del']").unbind("click");
			        $("a[name='del']") .bind('click', function(){
			        	var id = $(this).attr("id");
			        	$.ajax({
							type : "POST",
							url : "empCtrl/deleteByPrimaryKey.do",
							traditional : true,
							data : {
								empid : id
								
							},
							success : function(html) {
								alert("删除成功")
//								myGrid.reload();
								  $("#grid").datagrid("reload");
							},
							fail : function(html) {
								alert("删除失败")
								$("#grid").datagrid("reload");
							},
							error : function(
									XMLHttpRequest,
									textStatus,
									errorThrown) {
								alert("删除失败，数据错误")
								$("#grid").datagrid("reload");
							}
						});
			        });
			},  
				
				
			
	})

}); 