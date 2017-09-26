//加载收入列表
function loadincome(){
$(document).ready(function(){
	  	$.ajax({
			  url:"http://localhost:8080/myffms/income/loadincome.do",
			  type:"post",
			  dataType:"json",
			  success:function(result){
			  	if(result.status==0){
			  		var incomes = result.data;
			  		$("#income_list").empty();
			  		for(var i=0;i<incomes.length;i++){
			  		    console.log(incomes[i]);
			  			var iid = incomes[i].iid;
			  			var name = incomes[i].name;
			  			var itype = incomes[i].itype;
			  			var iname = incomes[i].iname;
			  			var money = incomes[i].money;
			  			var iway = incomes[i].iway;
			  			var time = incomes[i].time;
			  			
						//var td =	"<tr><td>"+iid+"</td><input class='personid' type='hidden' value='" + iid + "'>";
						var td=   "<tr><td>"+name+"</td>";    
                             td+=	"<td>"+itype+"</td>";         
                             td+=	"<td>"+iname+"</td>";         
                             td+=	"<td>"+money+"</td>";        
                             td+=	"<td>"+iway+"</td>";         
                             td+=	"<td>"+time+"</td>";  
                             //td+=	"<td><input class='btn_update' type='button' value=''><input class='btn_delete' type='button' name='btn_delete' value='修改'></td></tr>";
                             td+= 	"<td><div class='button-group'> <a class='button update' href='javascript:void(0)' onclick='sureUpdate(" + iid+ ")'><span class='icon-edit'></span> 修改</a> <a class='button delete' href='javascript:void(0)' onclick='sureDelete(" + iid+ ")'><span class='icon-trash-o'></span> 删除</a> </div></td></tr>";
                             var $td = $(td);
                             $("#income_list").append($td);         
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
function sureDelete(iid){
	// 提示确认框
	var ok = confirm("确定删除该收入?");
	if (!ok) {
		return false;// 阻止事件冒泡
	}
	// 获取成员ID
//	var pid = $(this).find(".personid").val();
	// 发送ajax请求
	$.ajax({
		url : "http://localhost:8080/myffms/income/deleteincome.do",
		type : "post",
		data : {
			"iid" : iid
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				$("#income_list tr.checked").parent().remove();// 删除成员
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
	$("#alert").load("./alert/addincome.html");
}

//绑定修改按钮
function sureUpdate(iid){
	//alert(iid);
	var ok = confirm("确定修改该收入?");
	if (!ok) {
		return false;
	}
	window.location.href="./updateincome.html?iid="+iid;
}


//合计金额
function sum(){
	// 发送ajax请求
	$.ajax({
		url : "http://localhost:8080/myffms/income/incomesum.do",
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
	$("#alert").load("./incomefindbyname.html");
}

//加载收入列表
function byname(){
		var name =document.getElementById("name").value;
	  	$.ajax({
			  url:"http://localhost:8080/myffms/income/incomefindbyname.do",
			  type:"post",
			  dataType:"json",
			  contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			  data:{"name":name},
			  success:function(result){
			  	if(result.status==0){
			  		var incomes = result.data;
			  		$("#incomefind_list").empty();
			  		for(var i=0;i<incomes.length;i++){
			  		    console.log(incomes[i]);
			  			var iid = incomes[i].iid;
			  			var name = incomes[i].name;
			  			var itype = incomes[i].itype;
			  			var iname = incomes[i].iname;
			  			var money = incomes[i].money;
			  			var iway = incomes[i].iway;
			  			var time = incomes[i].time;
			  			
						//var td =	"<tr><td>"+iid+"</td><input class='personid' type='hidden' value='" + iid + "'>";
						var td=   "<tr><td>"+name+"</td>";    
                             td+=	"<td>"+itype+"</td>";         
                             td+=	"<td>"+iname+"</td>";         
                             td+=	"<td>"+money+"</td>";        
                             td+=	"<td>"+iway+"</td>";         
                             td+=	"<td>"+time+"</td>";  
                             //td+=	"<td><input class='btn_update' type='button' value=''><input class='btn_delete' type='button' name='btn_delete' value='修改'></td></tr>";
                             td+= 	"<td><div class='button-group'> <a class='button update' href='javascript:void(0)' onclick='sureUpdate(" + iid+ ")'><span class='icon-edit'></span> 修改</a> <a class='button delete' href='javascript:void(0)' onclick='sureDelete(" + iid+ ")'><span class='icon-trash-o'></span> 删除</a> </div></td></tr>";
                             var $td = $(td);
                             $("#incomefind_list").append($td);         
			 		}
			 	}else{
			 		alert("不存在该成员或该成员没有收入录入");
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
		url : "http://localhost:8080/myffms/income/incomesumbyname.do",
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
	$("#alert").load("./incomefindbytime.html");
}

//加载收入列表
function bytime(){
		var starttime =document.getElementById("starttime").value;
		var endtime =document.getElementById("endtime").value;
	  	$.ajax({
			  url:"http://localhost:8080/myffms/income/incomefindbytime.do",
			  type:"post",
			  dataType:"json",
			  contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			  data:{"starttime":starttime,
				  	"endtime":endtime
			  },
			  success:function(result){
			  	if(result.status==0){
			  		var incomes = result.data;
			  		$("#incomefind_list").empty();
			  		for(var i=0;i<incomes.length;i++){
			  		    console.log(incomes[i]);
			  			var iid = incomes[i].iid;
			  			var name = incomes[i].name;
			  			var itype = incomes[i].itype;
			  			var iname = incomes[i].iname;
			  			var money = incomes[i].money;
			  			var iway = incomes[i].iway;
			  			var time = incomes[i].time;
			  			
						//var td =	"<tr><td>"+iid+"</td><input class='personid' type='hidden' value='" + iid + "'>";
						var td=   "<tr><td>"+name+"</td>";    
                             td+=	"<td>"+itype+"</td>";         
                             td+=	"<td>"+iname+"</td>";         
                             td+=	"<td>"+money+"</td>";        
                             td+=	"<td>"+iway+"</td>";         
                             td+=	"<td>"+time+"</td>";  
                             //td+=	"<td><input class='btn_update' type='button' value=''><input class='btn_delete' type='button' name='btn_delete' value='修改'></td></tr>";
                             td+= 	"<td><div class='button-group'> <a class='button update' href='javascript:void(0)' onclick='sureUpdate(" + iid+ ")'><span class='icon-edit'></span> 修改</a> <a class='button delete' href='javascript:void(0)' onclick='sureDelete(" + iid+ ")'><span class='icon-trash-o'></span> 删除</a> </div></td></tr>";
                             var $td = $(td);
                             $("#incomefind_list").append($td);         
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
		url : "http://localhost:8080/myffms/income/incomesumbytime.do",
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
	$("#alert").load("./incomefindbytype.html");
}

//按类型加载收入列表
function bytype(){
		var type =document.getElementById("select").value;
	  	$.ajax({
			  url:"http://localhost:8080/myffms/income/incomefindbytype.do",
			  type:"post",
			  dataType:"json",
			  contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			  data:{"itype":type},
			  success:function(result){
			  	if(result.status==0){
			  		var incomes = result.data;
			  		$("#incomefind_list").empty();
			  		for(var i=0;i<incomes.length;i++){
			  		    console.log(incomes[i]);
			  			var iid = incomes[i].iid;
			  			var name = incomes[i].name;
			  			var itype = incomes[i].itype;
			  			var iname = incomes[i].iname;
			  			var money = incomes[i].money;
			  			var iway = incomes[i].iway;
			  			var time = incomes[i].time;
			  			
						//var td =	"<tr><td>"+iid+"</td><input class='personid' type='hidden' value='" + iid + "'>";
						var td=   "<tr><td>"+name+"</td>";    
                             td+=	"<td>"+itype+"</td>";         
                             td+=	"<td>"+iname+"</td>";         
                             td+=	"<td>"+money+"</td>";        
                             td+=	"<td>"+iway+"</td>";         
                             td+=	"<td>"+time+"</td>"; 
                             td+= 	"<td><div class='button-group'> <a class='button update' href='javascript:void(0)' onclick='sureUpdate(" + iid+ ")'><span class='icon-edit'></span> 修改</a> <a class='button delete' href='javascript:void(0)' onclick='sureDelete(" + iid+ ")'><span class='icon-trash-o'></span> 删除</a> </div></td></tr>";
                             var $td = $(td);
                             $("#incomefind_list").append($td);         
			 		}
			 	}else{
			 		alert("不存在该成员或该成员没有收入录入");
			 	}
		 	},
			 	error:function(){
				  alert("加载失败");
			} 			
	  	});
};


//按类型合计
function sumbytype(){
	// 发送ajax请求
	var type =document.getElementById("select").value;
	$.ajax({
		url : "http://localhost:8080/myffms/income/incomesumbytype.do",
		type : "post",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data : {"itype":type},
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