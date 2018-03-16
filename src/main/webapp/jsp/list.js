$(document).ready(function() {
//	部门
//	$('#deptid').combobox({
//	    url:'deptCtrl/showDept.do',
//	    valueField:'deptid',
//	    textField:'dname'
//	    
//	});
	
	  $('#grid').datagrid({
		 title: '用户列表',
//         width: 900,
//         height: 700,
         
         rownumbers:true,
         singleSelect:true,
         autoRowHeight:false,
         pagination:true,
         pageSize:10,
//         pageNumber:1,
         showPageList:false,

		url : 'empCtrl/showEmps.do',
		dom : '#grid',
		columns : [[
				{
					title : '用户ID',
					field : 'empid',
					align : "center",
					width : '100', 
					hidden : true
				
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
					title : '出生日期',
					field : 'ebirthday',
					width : '150', 
					align : "left",
					sortable : false,
					formatter : function(value, row, index){
						return transferTime(value);
					}

				},
				{
					title : '年龄',
					field : 'eage',
					width : '70', 
					align : "center",
					sortable : false,
					formatter : function(value, row, index){
						var yMd =transferTime(row.ebirthday);
						return jsGetAge(yMd);
					}

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
			        	plain:true,
			        	iconCls:'icon-remove'
			        });    
			        
			        //动作
			        $("A[oper='mod']").unbind("click");
			        $("a[name='mod']") .bind('click', function(){
			        	var id = $(this).attr("id");
			        	$.ajax({
			        		url :"empCtrl/getEmpByEmpid.do",
			        		type : 'post',
			        		data :{
			        			empid : id
			        		},
			        		success : function(data){
			        			$("#empid").val(data.empid);
			        			$("#ename").val(data.ename);
//			        			根据出生日期计算年龄，年龄字段为只读，适用于新增数据时
//			        			$("#eage").val(jsGetAge(transferTime(data.ebirthday)));
//			        			直接使用数据库传来的年龄，
			        			$("#eage").val(data.eage);
			        			
			        			$("input[name='egender']").each(function(){
//			        				alert($(this).val());
			        				if($(this).val()==data.egender){
			        					$(this).attr("checked","checked");
			        				}
			        				
			        			});
			        			$("#ephone").val(data.ephone);
			        			$("#deptid").val(data.deptid);
			        			$("#ebirthday").val(transferTime(data.ebirthday));
			        			
			        			
			        			//部门下拉框选项
			        			$('#deptid').combobox({
			        			    url:'deptCtrl/showDept.do',
			        			    valueField:'deptid', //真实值
			        			    textField:'dname', //显示
			        			    value :data.deptid //默认选中当前值
			        			    
			        			});
			        			$('#mod-window').window('open');
			        		},
			        		error : function(XMLHttpRequest, textStatus, errorThrown){
			        			$.messager.alert('网页信息','操作数据出错!','error');
//			        			alert(textStatus);
			        		}
			        	});
			        });
			        //删除操作
			        $("A[oper='del']").unbind("click");
			        $("a[name='del']") .bind('click', function(){
			        	var id = $(this).attr("id");
			        	$.messager.confirm('确认删除', '确定要删除这条记录吗?', function(r){
			        		if (r){
			        			$.ajax({
									type : "POST",
									url : "empCtrl/deleteByPrimaryKey.do",
									traditional : true,
									data : {
										empid : id
										
									},
									success : function(html) {
										$.messager.alert('网页信息','删除成功!','info');
//										myGrid.reload();
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
			        		}
			        	});
			        	
			        });
			},  
				
				
			
	});
//	  修改结果校验
		    $("#updateForm").form({
		    	 success:function(data){ 
//		    		 alert(data);
		    		 $.messager.alert('网页信息','修改成功!','info');
		    		 $('#mod-window').window('close');
		    		 $("#grid").datagrid("reload");
		    	 },
		    	 fail : function(data){
		    		 $.messager.alert('网页信息','修改失败!','warning');
		    		 $('#mod-window').window('close');
		    		 $("#grid").datagrid("reload");
		    	 },
		    	 error : function(XMLHttpRequest,
							textStatus,
							errorThrown){
		    		 $.messager.alert('网页信息','删除数据出错!','error');
		    		 $('#mod-window').window('close');
						$("#grid").datagrid("reload");
		    	 }
		    	
		    	
		    });      
//取消按键
		    $("#cel").click(function(){
		    	 $('#mod-window').window('close');
//	    		 $("#grid").datagrid("reload");
		    });
		    
		    
//时间经json处理后变成int，转换回时间格式
		    function transferTime(cTime) {
		    	if(cTime==null){
		    		return null;
		    	}else{
		        //将json串的一串数字进行解析
		        var jsonDate = new Date(parseInt(cTime));
//		        alert(jsonDate);
		        //为Date对象添加一个新属性，主要是将解析到的时间数据转换为我们熟悉的“yyyy-MM-dd”样式
		        Date.prototype.format = function(format) {
		        var o = {
		        //获得解析出来数据的相应信息，可参考js官方文档里面Date对象所具备的方法
		        "y+" : this.getFullYear(),//得到对应的年信息
		        "M+" : this.getMonth() + 1, //得到对应的月信息，得到的数字范围是0~11，所以要加一
		        "d+" : this.getDate(), //得到对应的日信息
//		        "h+" : this.getHours(), //得到对应的小时信息 
//		        "m+" : this.getMinutes(), //得到对应的分钟信息
//		        "s+" : this.getSeconds(), //得到对应的秒信息
		    }
		      //将年转换为完整的年形式
		     if (/(y+)/.test(format)) {
		    	 format = format.replace(RegExp.$1,(this.getFullYear() + "").substr(4 - RegExp.$1.length));
		    }

		    //连接得到的年月日 时分秒信息
		    for ( var k in o) {
		    	if (new RegExp("(" + k + ")").test(format)) {
		    		format = format.replace(RegExp.$1,RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		    	}
		    }
		    return format;
		  }
		 var newDate = jsonDate.format("yyyy-MM-dd");
		 return newDate;
		 }       }
		    //出生日期时间转化结束
		    //计算年龄
		    function jsGetAge(strBirthday){
		    	if(strBirthday==null){
		    		return null;
		    	}else{
		        var returnAge;  
		        var strBirthdayArr=strBirthday.split("-");  
		        var birthYear = strBirthdayArr[0];  
		        var birthMonth = strBirthdayArr[1];  
		        var birthDay = strBirthdayArr[2];  
		        var d = new Date();   
		        var nowYear = d.getFullYear();  
		        var nowMonth = d.getMonth() + 1;  
		        var nowDay = d.getDate();  
		        if(nowYear == birthYear) {  
		        	returnAge = 0;//同年 则为0岁  
		        }else{  
		        	var ageDiff = nowYear - birthYear ; //年之差  
		        	if(ageDiff > 0){  
		        		if(nowMonth == birthMonth){  
		        			var dayDiff = nowDay - birthDay;//日之差  
		        			if(dayDiff < 0){  
		        				returnAge = ageDiff - 1;  
		        			}else{  
		        				returnAge = ageDiff ;  
		        			}  
		        		}else{  
		        			var monthDiff = nowMonth - birthMonth;//月之差  
		        			if(monthDiff < 0){  
		        				returnAge = ageDiff - 1;  
		        			}else{  
		        				returnAge = ageDiff ;  
		        			}  
		        		}  
		        	}else{  
		        		returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天  
		        	}  
		        }  
		        return returnAge;//返回周岁年龄 
		    	} 
		    }
		    //计算年龄结束
		    //导出数据
//		    $("#btn_outport").click(function(){
//		    	
//		    });
		    //导出数据结束
		    
})