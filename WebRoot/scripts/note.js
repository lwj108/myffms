//点击笔记本加载笔记信息列表
function loadnotes(){
 //将点击的笔记本li设置成选中状态
 $("#book_list li a").removeClass("checked");
 $(this).find("a").addClass("checked");
 //获取bookId
 var bookId = $(this).data("bookId");
 //发送ajax请求
 $.ajax({
 	url:"http://localhost:8080/note/note/loadnotes.do",
 	type:"post",
 	data:{"bookId":bookId},
 	dataType:"json",
 	success:function(result){
 		if(result.status==0){
 			//取出笔记信息,循环生成笔记列表
 			var notes = result.data;
 			//清除原有笔记li
 			//$("#note_list").empty();
 			$("#note_list li").remove();
 			//循环
 			for(var i=0;i<notes.length;i++){
 				var noteId = notes[i].cn_note_id;
 				var noteTitle = notes[i].cn_note_title;
 				//拼成笔记li
 				var s_li = '<li class="online">';
					s_li+= '<a>';
					s_li+= '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					s_li+= '</a>';
					s_li+= '<div class="note_menu" tabindex="-1">';
					s_li+= '	<dl>';
					s_li+= '		<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
					s_li+= '		<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
					s_li+= '		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
					s_li+= '	</dl>';
					s_li+= '</div>';
					s_li+= '</li>';
				//将s_li字符串转成jQuery对象
				var $li = $(s_li);
				$li.data("noteId",noteId);
				//将li添加到笔记的ul区域
				$("#note_list").append($li);
 			}
 			//切换显示区
 	        $("#pc_part_6").hide();//搜索笔记区隐藏
            $("#pc_part_2").show();//全部笔记区显示
 		}
 	},
 	error:function(){
 		alert("加载笔记失败");
 	}
 });
};

//弹出添加笔记对话框
function showAddNoteWindow(){
 //加载添加笔记对话框内容
 $("#can").load("./alert/alert_note.html");
 //显示背景色,将原页面遮住
 $(".opacity_bg").show();
}

//创建笔记按钮操作
function sureAddNote(){
 //获取笔记本ID,笔记名,用户ID
 var bookId = $("#book_list a.checked").parent().data("bookId");
 var noteTitle = $("#input_note").val().trim();
 //TODO检查笔记名是否为空
 //发送ajax请求
 $.ajax({
   url:"http://localhost:8080/note/note/add.do",
   type:"post",
   data:{"bookId":bookId,
   	"noteTitle":noteTitle,
   	"userId":userId},
   dataType:"json",
   success:function(result){
     if(result.status==0){//成功
        //关闭对话框
        closeAlertWindow();
        //生成笔记li添加到笔记列表区
        var noteId = result.data;
        //拼成笔记li
		var s_li = '<li class="online">';
			s_li+= '<a>';
			s_li+= '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
			s_li+= '</a>';
			s_li+= '<div class="note_menu" tabindex="-1">';
			s_li+= '	<dl>';
			s_li+= '		<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
			s_li+= '		<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
			s_li+= '		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
			s_li+= '	</dl>';
			s_li+= '</div>';
			s_li+= '</li>';
		//将s_li字符串转成jQuery对象
		var $li = $(s_li);
		$li.data("noteId",noteId);
		//将li添加到笔记的ul区域
		$("#note_list").prepend($li);
		//将当前追加的笔记设置为选中状态
		$("#note_list a").removeClass("checked");
		$("#note_list li a:first").addClass("checked");
		//将笔记标题添加到编辑区标题输入框中
		$("#input_note_title").val(noteTitle);
		//将笔记内容编辑区清空
		um.setContent("");
     }
   },
   error:function(){
     alert("创建笔记失败");
   }
 });
};

//根据笔记ID加载笔记信息
function loadNote(){
 //将当前点中的笔记设置选中状态
 $("#note_list a.checked").removeClass("checked");
 $(this).find("a").addClass("checked");
 //获取笔记ID
 var noteId = $(this).data("noteId");
 //发送Ajax请求
 $.ajax({
   url:"http://localhost:8080/note/note/load.do",
   type:"post",
   data:{"noteId":noteId},
   dataType:"json",
   success:function(result){
      if(result.status==0){
        var note = result.data;
        //将返回的笔记信息填充到编辑区
        $("#input_note_title").val(note.cn_note_title);
		um.setContent(note.cn_note_body);
      }
   },
   error:function(){
   	alert("加载笔记失败");
   }
 });
};

//更新笔记信息
function updateNote(){
 //获取笔记ID,笔记标题,笔记内容
 var noteId = $("#note_list a.checked").parent().data("noteId");
  var noteTitle = $("#input_note_title").val().trim();
  var noteBody = um.getContent();
  //格式检查
  if(noteId==undefined){
    alert("请选择要更新的笔记");
    return;
  }
  //发送ajax请求
  $.ajax({
    url:"http://localhost:8080/note/note/update.do",
    type:"post",
    data:{"noteId":noteId,
    	"noteTitle":noteTitle,
    	"noteBody":noteBody},
    dataType:"json",
    success:function(result){
       if(result.status==0){//成功
         //如果标题发生改变,修改笔记列表中li的标题
         var li_noteTitle = $("#note_list a.checked").text().trim();
         if(li_noteTitle != noteTitle){
           //修改
           var str = '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+noteTitle+'<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
           $("#note_list a.checked").html(str);
         }
         alert("保存笔记成功");
       }
    },
    error:function(){
    	alert("保存笔记失败");
  	    }
  	  });
  };

//控制笔记下拉菜单显示或隐藏
function showNoteMenu(){
     var $menu = $(this).parent().next();
     //is函数判断元素是否满足选择器
     if($menu.is(":hidden")){
       $menu.slideDown(1000);//显示点中笔记的菜单
     }else{
       $menu.slideUp(1000);//隐藏点中笔记的菜单
     }
     //将其他li的div菜单隐藏
     $menu.parent().siblings().find(".note_menu").hide();
     //将当前li设置选中
     $("#note_list a").removeClass("checked");
     $menu.prev().addClass("checked");
     //阻止事件冒泡
     return false;
};

//删除笔记操作
function sureDeleteNote(){
 //提示确认框
 var ok = confirm("确定将该笔记放入回收站?");
 if(!ok){
   return false;//阻止事件冒泡
 }
 //获取笔记ID
 var noteId = $(this).parents("li").data("noteId");
 //发送ajax请求
 $.ajax({
   url:"http://localhost:8080/note/note/delete.do",
   type:"post",
   data:{"noteId":noteId},
   dataType:"json",
   success:function(result){
     if(result.status==0){
       $("#note_list a.checked").parent().remove();//删除笔记li
       alert(result.msg);//提示成功
       return;
     }
   },
   error:function(){
     alert("删除笔记失败");
   }
 });
 return false;//阻止冒泡
};

//分享笔记操作
function sureShareNote(){
 //获取笔记ID
 var noteId = $(this).parents("li").data("noteId");
 //发送Ajax请求
 $.ajax({
   url:"http://localhost:8080/note/note/share.do",
   type:"post",
   data:{"noteId":noteId},
   dataType:"json",
   success:function(result){
      if(result.status==0
        ||result.status==1){
        //隐藏菜单
        $("#note_list a.checked").next().hide();
        //弹出提示框
        alert(result.msg);
      }
   },
   error:function(){
     alert("笔记分享失败");
   }
 });
};

//查询分享笔记
function searchShareNotes(event){
 var keyCode = event.keyCode;
 if(keyCode==13){
   //获取查询关键字
   var keyword = $("#search_note").val().trim();
   //发送ajax请求
   $.ajax({
     url:"http://localhost:8080/note/note/search.do",
     type:"post",
     data:{"keyword":keyword},
     dataType:"json",
     success:function(result){
        if(result.status==0){
          var share_notes = result.data;//查询的分享笔记结果
          //循环查询结果,生成li添加到搜索结果列表
          $("#search_list").empty();
          for(var i=0;i<share_notes.length;i++){
            var shareTitle = share_notes[i].cn_share_title;
            //拼成笔记li
			 var s_li = '<li class="online">';
				s_li+= '<a>';
				s_li+= '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+shareTitle;
				s_li+= '</a>';
				s_li+= '</li>';
			 $("#search_list").append(s_li);
          }
          //切换笔记显示区
          $("#pc_part_6").show();//搜索笔记区显示
          $("#pc_part_2").hide();//全部笔记区隐藏
        }
     },
     error:function(){
       alert("查询笔记失败");
         }
       });
     }
  };






