function deleteperson(){
	
			//��ʾȷ�Ͽ�
			alert(3);
			var ok = confirm("ȷ�����ó�Աɾ��?");
			if(!ok){
				return false;//��ֹ�¼�ð��
			}
			//��ȡ��Աid
			var pid = $(this).parents("td").data("pid");
			//����ajax����
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
					alert("ɾ��ʧ��");
				}
			
			});
			return false;
		
}