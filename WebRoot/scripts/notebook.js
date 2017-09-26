//加载笔记本列表
function loadbooks(){
	$.ajax({
		  url:"http://localhost:8080/note/notebook/loadbooks.do",
		  type:"post",
		  data:{"userId":userId},
		  dataType:"json",
		  success:function(result){
		  	if(result.status==0){
		  		var books = result.data;//笔记本的json对象数组
		  		//循环books，生成列表li
		  		for(var i=0;i<books.length;i++){
		  			var bookName = books[i].cn_notebook_name;
		  			var bookId = books[i].cn_notebook_id;
		  			//生成li
		  			var s_li = '<li class="online">';
						s_li += '<a>'
						s_li += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
						s_li += '</i>'+bookName+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete" title="删除"><i class="fa fa-times"></i></button></a>';
						s_li += '</li>';
						
					var $li = $(s_li);//将字符串转成jquery对象
		  			$li.data("bookId",bookId);
		  			//添加到book_list的ul区域
		  			$("#book_list").append($li);
		  		}
		  		//将第一个笔记本选中
		  		$("#book_list li:first").click();
		  	}
		  },
		  error:function(){
			  alert("加载笔记本失败");
		  }
		});
};
//弹出添加笔记本对话框
function showAddBookWindow(){
   	 //加载添加笔记本对话框内容
   	 $("#can").load("./alert/alert_notebook.html");
   	 //显示背景色,将原页面遮住
   	 $(".opacity_bg").show();
}

//弹出更新笔记对话框
function showUpdateBookWindow(){
 //显示修改笔记本对话框
 //$("#can").load("./alert/alert_rename.html");
 //采用同步方式加载html对话框页面
 $.ajax({
   url:"./alert/alert_rename.html",
   type:"get",
   async:false,
   dataType:"html",
   success:function(result){
     //将返回的HTML信息填充到div中
     $("#can").html(result);
   }
 });
 
 $(".opacity_bg").show();
 //获取双击笔记本的名字,写到对话框
 var bookName = $("#book_list a.checked").text();
 $("#input_notebook_rename").val(bookName);
  };
	
//关闭对话框
function closeAlertWindow(){
	$(".opacity_bg").hide();//隐藏背景
	$("#can").empty();//清空内容
}

//确认创建笔记本
function sureAddBook(){
 //获取笔记本名称和用户ID
 var bookName = $("#input_notebook").val().trim();
 //格式检查
 if(bookName == ""){
    $("#input_notebook_msg").html("<font color='red'>笔记本名称为空</font>");
    return;
 }
 //发送ajax请求
 $.ajax({
 	url:"http://localhost:8080/note/notebook/add.do",
 	type:"post",
 	data:{"userId":userId,"bookName":bookName},
 	dataType:"json",
 	success:function(result){
 		if(result.status==0){//成功
 		  //关闭对话框
 		  closeAlertWindow();
 		  //追加一个笔记本li
 		  var bookId = result.data;//获取返回的笔记本ID
 		  //生成li
  			var s_li = '<li class="online">';
				s_li += '<a>'
				s_li += '<i class="fa fa-book" title="online" rel="tooltip-bottom">';
				s_li += '</i>'+bookName+'<button type="button" class="btn btn-default btn-xs btn_position btn_delete" title="删除"><i class="fa fa-times"></i></button></a>';
				s_li += '</li>';
				
			var $li = $(s_li);//将字符串转成jquery对象
  			$li.data("bookId",bookId);
  			//添加到book_list的ul区域
  			$("#book_list").prepend($li);
  			//将第一个li选中
  			$("#book_list li a").removeClass("checked");
  			$("#book_list li:first a").addClass("checked");
  			//将笔记列表清空
  			$("#note_list").empty();
  			//清空编辑区
  			$("#input_note_title").val("");
  			um.setContent("");//设置为空
 		}else if(result.status==1){//笔记本名错误
 		   $("#input_notebook_msg").html("<font color='red'>"+result.msg+"</font>");
 		}
   	 }
   });
   	 
};

 //确认更新笔记本操作
function sureUpdateBook(){
 //获取笔记本名称,笔记本ID,用户ID
 var bookId = $("#book_list a.checked").parent().data("bookId");
 var bookName = $("#input_notebook_rename").val().trim();
 //TODO格式检查
 var li_bookName = $("#book_list a.checked").text().trim();
 if(li_bookName==bookName){
   //名称相同
   closeAlertWindow();
   return;//退出
 }
 //发送ajax请求
 $.ajax({
   url:"http://localhost:8080/note/notebook/update.do",
   type:"post",
   data:{"userId":userId,
      "bookId":bookId,
      "bookName":bookName},
   dataType:"json",
   success:function(result){
      if(result.status==0){//成功
         //关闭对话框
         closeAlertWindow();
         //更新列表中li的笔记本名
         var str = '<i class="fa fa-book" title="online" rel="tooltip-bottom"></i>';
         str+= bookName;
         str+='<button type="button" class="btn btn-default btn-xs btn_position btn_delete" title="删除"><i class="fa fa-times"></i></button>';
         $("#book_list a.checked").html(str);
         //提示成功
         alert(result.msg);
      }else if(result.status==1){//重名
         $("#notebook_rename_msg").html(result.msg);
      }
   },
   error:function(){
     alert("更新笔记本失败");
   }
 });
     
};
   
//删除笔记本操作
function sureDeleteBook(){
 //获取笔记本ID
 var bookId = $(this).parents("li").data("bookId");
 //发送Ajax请求
 $.ajax({
   url:"http://localhost:8080/note/notebook/delete.do",
   type:"post",
   data:{"bookId":bookId},
   dataType:"json",
   success:function(result){
       if(result.status==0){
          //删除笔记本li
          $("#book_list a.checked").parent().remove();
          //默认第一个li选中
          $("#book_list li:first").click();
       }
       alert(result.msg);
   },
   error:function(){
      alert("删除笔记本失败");
   }
 });
};
   
   
