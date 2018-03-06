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
					field : 'empid',
					width : '120',
					align : "center",
					formatter : function(){
						var e = '<a empid="'
							+ value
							+ '" href="javascript:void(0)" oper="edit">编辑</a> ';
						var d = '<a empid="'
							+ value
							+ '" href="javascript:void(0)" oper="delete">删除</a> ';
						
						   if($('#mod').length == 0){
							   e = '';
						    }
						    
						    if($('#del').length == 0){
								   d = '';
							}
						    
						return e + d ;
					}
					
				}]],
			
	})

	
}); 