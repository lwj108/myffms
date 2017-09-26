//加载成员列表
function loadperson(){
$(document).ready(function(){
	  	$.ajax({
			  url:"http://localhost:8080/myffms/person/loadpersons.do",
			  type:"post",
			  dataType:"json",
			  success:function(result){
			  	if(result.status==0){
			  		var persons = result.data;//json对象数组
			  		//循环person，生成列表
			  		for(var i=0;i<persons.length;i++){
			  		    console.log(persons[i]);
			  			var pid = persons[i].pid;
			  			var name = persons[i].name;
			  			var sex = persons[i].sex;
			  			var age = persons[i].age;
			  			var identity = persons[i].identity;
			  			var birthday = persons[i].birthday;
			  			var telephone = persons[i].telephone;
			  			var state = persons[i].state;
			  			console.log(pid,name,sex,age,identity,birthday,telephone,state);
						//var td =	"<tr><td>"+pid+"</td><input class='personid' type='hidden' value='" + pid + "'>";
                        var td =   "<tr><td>"+name+"</td>";    
                             td+=	"<td>"+sex+"</td>";         
                             td+=	"<td>"+age+"</td>";         
                             td+=	"<td>"+identity+"</td>";        
                             td+=	"<td>"+birthday+"</td>";         
                             td+=	"<td>"+telephone+"</td>";         
                             td+=	"<td>"+state+"</td>";
                             //td+=	"<td><input class='btn_update' type='button' value='修改'><input class='btn_delete' type='button' name='btn_delete' value='删除'></td></tr>";
                             td+= 	"<td><div class='button-group'> <a class='button update' href='javascript:void(0)' onclick='sureUpdate(" + pid+ ")'><span class='icon-edit'></span> 修改</a> <a class='button delete' href='javascript:void(0)' onclick='sureDelete(" + pid+ ")'><span class='icon-trash-o'></span> 删除</a> </div></td></tr>";
                             var $td = $(td);
                             $("#person_list").append($td);         
			 		}
			 	}
		 	},
			 	error:function(){
				  alert("加载成员失败");
			} 			
	  	});
	  	
	  });
};
//
// 绑定删除按钮
function sureDelete(pid){
	// 提示确认框
	var ok = confirm("确定删除该成员?");
	if (!ok) {
		return false;// 阻止事件冒泡
	}
	// 获取成员ID
//	var pid = $(this).find(".personid").val();
	console.log("发多少方式的" + pid);
	// 发送ajax请求
	$.ajax({
		url : "http://localhost:8080/myffms/person/deleteperson.do",
		type : "post",
		data : {
			"pid" : pid
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				$("#person_list tr.checked").parent().remove();// 删除成员
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

//弹出添加笔记对话框
function sureadd(){
 //加载添加笔记对话框内容
 $("#alert").load("./alert/addPerson.html");
}

function sureUpdate(pid){
	//alert(pid);
	var ok = confirm("确定修改该成员?");
	if (!ok) {
		return false;
	}
	window.location.href="./updatePerson.html?pid="+pid;
	//$("#alert").load("./updatePerson.html?pid="+pid);
	
}