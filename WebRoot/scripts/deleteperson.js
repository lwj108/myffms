function deleteperson(){
	
			//提示确认框
			alert(3);
			var ok = confirm("确定将该成员删除?");
			if(!ok){
				return false;//阻止事件冒泡
			}
			//获取成员id
			var pid = $(this).parents("td").data("pid");
			//发送ajax请求
			$.ajax({
				url:"http://localhost:8080/myffms/person/deleteperson.do",
				type:"post",
				data:{"pid":pid},
				dataType:"json",
				success:function(result){
					if(result.status==0){
						$("person_list a.checked").parent().remove();
					}
					alert(result.msg);
				},
				error:function(){
					alert("删除失败");
				}
			
			});
			return false;
		
}