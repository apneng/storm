$(document).ready(function() {
	fLoadTable();
	init();
	
	function init(){
		$.ajax({
			type : "POST",
			url : "empCtrl/showEmps.do",
			dataType:"json",
			success:function(data){
				$('#dg').datagrid('loadData',data);
			},
			error:function(xhr){
				alert(xhr.status);
			}
		});
	};
	
	function fLoadTable(){
		 $('#dg').datagrid({
             title: '雇员列表',
            width: 700,
            height: 300,
           fitColumns: true,

           columns : [ [ { 
                 field : 'empid', 
                 width : '100', 
                 title:'ID',
                checkbox:true 
             },{ 
               field : 'ename', 
               title : '姓名', 
               width : '100', 
               align : 'center' 
            }, { 
               field : 'egender', 
               title : '性别', 
               width : '100', 
              align : 'center', 
           },{ 
               field : 'eage', 
               title : '年龄', 
               width : '100', 
               align : 'center', 
          },{ 
              field : 'ephone', 
              title : '电话', 
              width : '100', 
              align : 'center', 
         },{ 
              field : 'dname', 
              title : '部门', 
              width : '100', 
              align : 'center', 
           }
        ] ],
     idField:'id', 
     loadMsg:'Processing, please wait …', 
     pagination:true 
});
		
	}
});