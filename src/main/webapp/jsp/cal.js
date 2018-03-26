$(document).ready(function() {
	
	$.ajax({
		type : "POST",
		url : "calCtrl/getCals.do",
		traditional : true,
		success : function(data) {
			var a = JSON.parse(data);//json转成数组
			var b = new Array(a.length);
			for (var int = 0; int < a.length; int++) {
				b[int] = transferTime(a[int]);//转为yyyy-MM-dd格式
			}

			if(b.length==0){
				b=[,];
			}
			WdatePicker({
			eCont:'cal',
			specialDates:b,
			onpicked:function(dp){
				var dd =  dp.cal.getDateStr();
				$.ajax({
	        		url :"calCtrl/getCalByDate.do",
	        		type : 'post',
	        		dateType:'json',
	        		data :{
	        			startDate:dd
	        		},
	        		success : function(data){
	        			var jd = JSON.parse(data);//json转成数组
	        			var leng = jd.length;
//	        			alert(data)
	        			if(leng==0){//没有记录则新建
	        				$('#cal-window').window('open');	
	        			}else if(leng == 1){//单条记录则指向该条记录
	        				$("#startDate").val(transferTime1(jd[0].start_date));
	        				$("#endDate").val(transferTime1(jd[0].end_date));
	        				$("#title").val(jd[0].title);
	        				$("#calid").val(jd[0].calid);
//	        				$("#entWho").val(jd[0].entWho);
	        				$("#calDesc").textbox("setValue",jd[0].cal_desc);
	        				$('#cal-window').window('open');
	        			}else{//多条记录提供选择
	        			$('#showCal').empty();
	        			$.each($.parseJSON(data), function(i, item) {
	        				$('#showCal').append('<li value='+item.calid+'>'+transferTime1(item.start_date)+'   '+item.title+'</li>');
	        				var obj_lis = document.getElementById("showCal").getElementsByTagName("li");
	        			    for(i=0;i<obj_lis.length;i++){
	        			        obj_lis[i].onclick = function(){
	        			        	getCalById($(this).attr("value"));
//	        			        	$(this).attr("value");
//	        			        	alert($(this).attr("value"));
//	        			            debugger;
	        			        }
	        			    }
	        			});
	        			$('#info-window').window('open');	
	        			}
	        		},
	        		error : function(XMLHttpRequest, textStatus, errorThrown){
	        			
	        		}
	        	});
				
			}
		});
		
			
		},
		fail : function(data) {
			
		},
		error : function(
				XMLHttpRequest,
				textStatus,
				errorThrown) {
			
		}
	});
	//绑定事件li
	
//	$("#info").on("click","#showCal",function(){
//		  alert("aaaaaa");
//		});
	
	

//	取消按键
	 $("#cel").click(function(){
    	 $('#cal-window').window('close');
    });
//		删除按键
	 $("#delete").click(function(){
		 $.ajax({
     		url :"calCtrl/delCalByCalid.do",
     		type : 'post',
     		data :{
     			calid : $("#calid").val()
     		},
     		success : function(data){
     			$.messager.alert('网页信息','删除成功!','info');
     			$('#cal-window').window('close');
     			setTimeout("location.reload();",1000);
     		},
     		error : function(XMLHttpRequest, textStatus, errorThrown){
     			
     		}
     	});
    });
//重置按键
	 $("#reset").click(function(){
		 $("#startDate").val("");
		 $("#endDate").val("");
		 $("#title").val("");
		 $("#calDesc").textbox("setValue","");
    	 
    });
	 //添加新日程
	 $("#addNew").click(function(){
		 alert("ddddddd");
		 $("#startDate").val("");
		 $("#endDate").val("");
		 $("#title").val("");
		 $("#calid").val("");
		 $("#calDesc").textbox("setValue","");
		 
		
    	 
    });
	    $("#updateForm").form({
	    	 success:function(data){ 
//	    		 alert(data);
	    		 $.messager.alert('网页信息','创建日程成功!','info');
	    		 $('#cal-window').window('close');
	    		 location.reload();
	    	 },
	    	 fail : function(data){
	    		 $.messager.alert('网页信息','修改日程失败!','warning');
	    		 $('#cal-window').window('close');
	    		 location.reload();
	    	 },
	    	 error : function(XMLHttpRequest,
						textStatus,
						errorThrown){
	    		 $.messager.alert('网页信息','删除数据出错!','error');
	    		 $('#cal-window').window('close');
	    		 location.reload();
	    	 }
	    	
	    	
	    });  
	//时间经json处理后变成int，转换回时间格式
	    function transferTime(cTime) {
	    	if(cTime==null){
	    		return null;
	    	}else{
	        //将json串的一串数字进行解析
	        var jsonDate = new Date(parseInt(cTime));
//	        alert(jsonDate);
	        //为Date对象添加一个新属性，主要是将解析到的时间数据转换为我们熟悉的“yyyy-MM-dd”样式
	        Date.prototype.format = function(format) {
	        var o = {
	        //获得解析出来数据的相应信息，可参考js官方文档里面Date对象所具备的方法
	        "y+" : this.getFullYear(),//得到对应的年信息
	        "M+" : this.getMonth() + 1, //得到对应的月信息，得到的数字范围是0~11，所以要加一
	        "d+" : this.getDate(), //得到对应的日信息
//	        "h+" : this.getHours(), //得到对应的小时信息 
//	        "m+" : this.getMinutes(), //得到对应的分钟信息
//	        "s+" : this.getSeconds(), //得到对应的秒信息
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
	    
	  //时间经json处理后变成int，转换回时间格式
	    function transferTime1(cTime) {
	    	if(cTime==null){
	    		return null;
	    	}else{
	        //将json串的一串数字进行解析
	        var jsonDate = new Date(parseInt(cTime));
//	        alert(jsonDate);
	        //为Date对象添加一个新属性，主要是将解析到的时间数据转换为我们熟悉的“yyyy-MM-dd”样式
	        Date.prototype.format = function(format) {
	        var o = {
	        //获得解析出来数据的相应信息，可参考js官方文档里面Date对象所具备的方法
	        "y+" : this.getFullYear(),//得到对应的年信息
	        "M+" : this.getMonth() + 1, //得到对应的月信息，得到的数字范围是0~11，所以要加一
	        "d+" : this.getDate(), //得到对应的日信息
	        "h+" : this.getHours(), //得到对应的小时信息 
	        "m+" : this.getMinutes(), //得到对应的分钟信息
	        "s+" : this.getSeconds(), //得到对应的秒信息
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
	 var newDate = jsonDate.format("yyyy-MM-dd hh:mm:ss");
	 return newDate;
	 }       }
	    //根据id找日程
	    function getCalById(cid){
	    	$.ajax({
        		url :"calCtrl/getCalByCalid.do",
        		type : 'post',
        		data :{
        			calid : cid
        		},
        		success : function(data){
        			$("#startDate").val(data.startDate);
    				$("#endDate").val(data.endDate);
    				$("#title").val(data.title);
    				$("#calid").val(data.calid);
//    				$("#entWho").val(jd[0].entWho);
    				$("#calDesc").textbox("setValue",data.calDesc);
    				$('#info-window').window('close');
    				$('#cal-window').window('open');
        		},
        		error : function(XMLHttpRequest, textStatus, errorThrown){
        			
        		}
        	});
	    }

})
