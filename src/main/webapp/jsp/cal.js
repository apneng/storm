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
	        			if(leng==0){
	        				$('#cal-window').window('open');	
	        			}else if(leng == 1){
	        				$("#startDate").val(data.start_date);
	        				$("#endDate").val(data.end_date);
	        				$("#title").val(data.title);
	        				$("#calDesc").val(data.cal_desc);
	        				$('#cal-window').window('open');
	        			}else{
	        			$('#showCal').empty();
	        			$.each($.parseJSON(data), function(i, item) {
	        				$('#showCal').append('<li value='+item.calid+'>'+item.title+'</li>');
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
	  $("ul li").unbind("click");
      $("ul li") .bind('click', function(){
    	  alert("aaa")    	  
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
})
