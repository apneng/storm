$(document).ready(function() {
	alert("aaaaaaaaaaa");
//	var id = $params.id;
//	alert(id);
	var id = 2;
	$.ajax({
		url : "empCtrl/getEmpByEmpid.do",
		type : 'post',
		 data :{
			empid : id
		},
		success : function(data){
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
		}
	});
})