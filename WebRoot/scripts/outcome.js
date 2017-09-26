//加载收入列表
function loadoutcome(){
$(document).ready(function(){
	  	$.ajax({
			  url:"http://localhost:8080/myffms/outcome/loadoutcome.do",
			  type:"post",
			  dataType:"json",
			  success:function(result){
			  	if(result.status==0){
			  		var outcomes = result.data;
			  		$("#outcome_list").empty();
			  		for(var i=0;i<outcomes.length;i++){
			  		    console.log(outcomes[i]);
			  			var oid = outcomes[i].oid;
			  			var name = outcomes[i].name;
			  			var otype = outcomes[i].otype;
			  			var oname = outcomes[i].oname;
			  			var money = outcomes[i].money;
			  			var oway = outcomes[i].oway;
			  			var time = outcomes[i].time;
			  			
						//var td =	"<tr><td>"+iid+"</td><input class='personid' type='hidden' value='" + iid + "'>";
						var td=   "<tr><td>"+name+"</td>";    
                             td+=	"<td>"+otype+"</td>";         
                             td+=	"<td>"+oname+"</td>";         
                             td+=	"<td>"+money+"</td>";        
                             td+=	"<td>"+oway+"</td>";         
                             td+=	"<td>"+time+"</td>";  
                             //td+=	"<td><input class='btn_update' type='button' value=''><input class='btn_delete' type='button' name='btn_delete' value='修改'></td></tr>";
                             td+= 	"<td><div class='button-group'> <a class='button update' href='javascript:void(0)' onclick='sureUpdate(" + oid+ ")'><span class='icon-edit'></span> 修改</a> <a class='button delete' href='javascript:void(0)' onclick='sureDelete(" + oid+ ")'><span class='icon-trash-o'></span> 删除</a> </div></td></tr>";
                             var $td = $(td);
                             $("#outcome_list").append($td);         
			 		}
			 	}
		 	},
			 	error:function(){
				  alert("加载失败");
			} 			
	  	});
	  	
	  });
};

//绑定删除
function sureDelete(oid){
	// 提示确认框
	var ok = confirm("确定删除该支出?");
	if (!ok) {
		return false;// 阻止事件冒泡
	}
	// 获取成员ID
//	var pid = $(this).find(".personid").val();
	// 发送ajax请求
	$.ajax({
		url : "http://localhost:8080/myffms/outcome/deleteoutcome.do",
		type : "post",
		data : {
			"oid" : oid
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				$("#outcome_list tr.checked").parent().remove();// 删除成员
				alert(result.msg);// 提示成功
				return;
			}
		},
		error : function() {
			alert("删除失败");
		}
	});
	window.location.reload();
	return false;// 阻止冒泡
};

//绑定添加按钮
function sureadd(){
	$("#alert").load("./alert/addoutcome.html");
}

//绑定修改按钮
function sureUpdate(oid){
	//alert(oid);
	var ok = confirm("确定修改该收入?");
	if (!ok) {
		return false;
	}
	window.location.href="./updateoutcome.html?oid="+oid;
}

//合计金额
function sum(){
	// 发送ajax请求
	$.ajax({
		url : "http://localhost:8080/myffms/outcome/outcomesum.do",
		type : "post",
		data : {},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				var s = result.data;
				//alert(s);
				$("#total").val(s);
				return;
			}
		},
		error : function() {
			alert("合计错误");
		}
	});
	return false;// 阻止冒泡
};

//绑定成员名查询按钮
function findbyname(){
	$("#alert").load("./outcomefindbyname.html");
}

//加载收入列表
function byname(){
		var name =document.getElementById("name").value;
	  	$.ajax({
			  url:"http://localhost:8080/myffms/outcome/outcomefindbyname.do",
			  type:"post",
			  dataType:"json",
			  contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			  data:{"name":name},
			  success:function(result){
			  	if(result.status==0){
			  		var outcomes = result.data;
			  		$("#outcomefind_list").empty();
			  		for(var i=0;i<outcomes.length;i++){
			  		    console.log(outcomes[i]);
			  			var oid = outcomes[i].oid;
			  			var name = outcomes[i].name;
			  			var otype = outcomes[i].otype;
			  			var oname = outcomes[i].oname;
			  			var money = outcomes[i].money;
			  			var oway = outcomes[i].oway;
			  			var time = outcomes[i].time;
			  			
						//var td =	"<tr><td>"+iid+"</td><input class='personid' type='hidden' value='" + iid + "'>";
						var td=   "<tr><td>"+name+"</td>";    
                             td+=	"<td>"+otype+"</td>";         
                             td+=	"<td>"+oname+"</td>";         
                             td+=	"<td>"+money+"</td>";        
                             td+=	"<td>"+oway+"</td>";         
                             td+=	"<td>"+time+"</td>";  
                             //td+=	"<td><input class='btn_update' type='button' value=''><input class='btn_delete' type='button' name='btn_delete' value='修改'></td></tr>";
                             td+= 	"<td><div class='button-group'> <a class='button update' href='javascript:void(0)' onclick='sureUpdate(" + oid+ ")'><span class='icon-edit'></span> 修改</a> <a class='button delete' href='javascript:void(0)' onclick='sureDelete(" + oid+ ")'><span class='icon-trash-o'></span> 删除</a> </div></td></tr>";
                             var $td = $(td);
                             $("#outcomefind_list").append($td);         
			 		}
			 	}else{
			 		alert("不存在该成员或该成员没有支出录入");
			 	}
		 	},
			 	error:function(){
				  alert("加载失败");
			} 			
	  	});
};

//按成员名合计
function sumbyname(){
	// 发送ajax请求
	var name =document.getElementById("name").value;
	$.ajax({
		url : "http://localhost:8080/myffms/outcome/outcomesumbyname.do",
		type : "post",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data : {"name":name},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				var s = result.data;
				//alert(s);
				$("#totalname").val(s);
				return;
			}
		},
		error : function() {
			alert("合计错误");
		}
	});
	return false;// 阻止冒泡
};

//绑定时间查询按钮
function findbytime(){
	$("#alert").load("./outcomefindbytime.html");
}

//加载收入列表
function bytime(){
		var starttime =document.getElementById("starttime").value;
		var endtime =document.getElementById("endtime").value;
	  	$.ajax({
			  url:"http://localhost:8080/myffms/outcome/outcomefindbytime.do",
			  type:"post",
			  dataType:"json",
			  contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			  data:{"starttime":starttime,
				  	"endtime":endtime
			  },
			  success:function(result){
			  	if(result.status==0){
			  		var outcomes = result.data;
			  		$("#outcomefind_list").empty();
			  		for(var i=0;i<outcomes.length;i++){
			  		    console.log(outcomes[i]);
			  			var oid = outcomes[i].oid;
			  			var name = outcomes[i].name;
			  			var otype = outcomes[i].otype;
			  			var oname = outcomes[i].oname;
			  			var money = outcomes[i].money;
			  			var oway = outcomes[i].oway;
			  			var time = outcomes[i].time;
			  			
						//var td =	"<tr><td>"+iid+"</td><input class='personid' type='hidden' value='" + iid + "'>";
						var td=   "<tr><td>"+name+"</td>";    
                             td+=	"<td>"+otype+"</td>";         
                             td+=	"<td>"+oname+"</td>";         
                             td+=	"<td>"+money+"</td>";        
                             td+=	"<td>"+oway+"</td>";         
                             td+=	"<td>"+time+"</td>";  
                             //td+=	"<td><input class='btn_update' type='button' value=''><input class='btn_delete' type='button' name='btn_delete' value='修改'></td></tr>";
                             td+= 	"<td><div class='button-group'> <a class='button update' href='javascript:void(0)' onclick='sureUpdate(" + oid+ ")'><span class='icon-edit'></span> 修改</a> <a class='button delete' href='javascript:void(0)' onclick='sureDelete(" + oid+ ")'><span class='icon-trash-o'></span> 删除</a> </div></td></tr>";
                             var $td = $(td);
                             $("#outcomefind_list").append($td);         
			 		}
			 	}else{
			 		alert("该时间段内没有收入");
			 	}
		 	},
			 	error:function(){
				  alert("加载失败");
			} 			
	  	});
};

//按时间合计
function sumbytime(){
	// 发送ajax请求
	var starttime =document.getElementById("starttime").value;
	var endtime =document.getElementById("endtime").value;
	$.ajax({
		url : "http://localhost:8080/myffms/outcome/outcomesumbytime.do",
		type : "post",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data : {"starttime":starttime,
				"endtime":endtime},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				var s = result.data;
				//alert(s);
				$("#totaltime").val(s);
				return;
			}
		},
		error : function() {
			alert("合计错误");
		}
	});
	return false;// 阻止冒泡
};

//绑定类型查询按钮
function findbytype(){
	$("#alert").load("./outcomefindbytype.html");
}

//加载收入列表
function bytype(){
		var type =document.getElementById("select").value;
	  	$.ajax({
			  url:"http://localhost:8080/myffms/outcome/outcomefindbytype.do",
			  type:"post",
			  dataType:"json",
			  contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			  data:{"otype":type},
			  success:function(result){
			  	if(result.status==0){
			  		var outcomes = result.data;
			  		$("#outcomefind_list").empty();
			  		for(var i=0;i<outcomes.length;i++){
			  		    console.log(outcomes[i]);
			  			var oid = outcomes[i].oid;
			  			var name = outcomes[i].name;
			  			var otype = outcomes[i].otype;
			  			var oname = outcomes[i].oname;
			  			var money = outcomes[i].money;
			  			var oway = outcomes[i].oway;
			  			var time = outcomes[i].time;
			  			
						//var td =	"<tr><td>"+iid+"</td><input class='personid' type='hidden' value='" + iid + "'>";
						var td=   "<tr><td>"+name+"</td>";    
                             td+=	"<td>"+otype+"</td>";         
                             td+=	"<td>"+oname+"</td>";         
                             td+=	"<td>"+money+"</td>";        
                             td+=	"<td>"+oway+"</td>";         
                             td+=	"<td>"+time+"</td>";  
                             //td+=	"<td><input class='btn_update' type='button' value=''><input class='btn_delete' type='button' name='btn_delete' value='修改'></td></tr>";
                             td+= 	"<td><div class='button-group'> <a class='button update' href='javascript:void(0)' onclick='sureUpdate(" + oid+ ")'><span class='icon-edit'></span> 修改</a> <a class='button delete' href='javascript:void(0)' onclick='sureDelete(" + oid+ ")'><span class='icon-trash-o'></span> 删除</a> </div></td></tr>";
                             var $td = $(td);
                             $("#outcomefind_list").append($td);         
			 		}
			 	}else{
			 		alert("不存在类型支出录入");
			 	}
		 	},
			 	error:function(){
				  alert("加载失败");
			} 			
	  	});
};

//按成员名合计
function sumbytype(){
	// 发送ajax请求
	var type =document.getElementById("select").value;
	$.ajax({
		url : "http://localhost:8080/myffms/outcome/outcomesumbytype.do",
		type : "post",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data : {"otype":type},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				var s = result.data;
				//alert(s);
				$("#totaltype").val(s);
				return;
			}
		},
		error : function() {
			alert("合计错误");
		}
	});
	return false;// 阻止冒泡
};
