   $(function(){
      //登录按钮单击处理
      $("#login").click(function(){
        //清空提示信息
        $("#name_msg").html("");
        $("#password_msg").html("");
      	//获取请求要提交数据
      	var name = $("#name").val().trim();
      	var password = $("#password").val().trim();
      	//检测数据格式合法性
      	var flag = true;//通过检测
      	if(name==""){
      		$("#name_msg").html("用户名为空");
      		flag = false;//未通过检测
      	}
      	if(password==""){
      		$("#password_msg").html("密码为空");
      		flag = false;//未通过检测
      	}
      	//通过检测，发送Ajax请求
      	if(flag){
      		//采用HTTP Basic Authentication模式传输用户名和密码
      		var msg = name+":"+password;
      		var base64_msg = Base64.encode(msg);
      
      		$.ajax({
      		  url:"http://localhost:8080/myffms/user/login.do",
      		  type:"post",
      		  dataType:"json",
      		  beforeSend:function(xhr){
      		  	xhr.setRequestHeader(
      		  	  "Authorization","Basic "+base64_msg);
      		  },
      		  success:function(result){
      		  	//解析返回的JSON结果
      		  	if(result.status==0){//成功
      		  		//将用户身份信息放入cookie
      		  		var token = result.data.userToken;
      		  		var uid = result.data.userId;
      		  		addCookie("userId",uid,0.5);
      		  		addCookie("userToken",token,0.5);
      		  		window.location.href="main.html";
      		  	}else if(result.status==1){//用户错误
      		  		$("#name_msg").html(result.msg);
      		  	}else if(result.status==2){//密码错误
      		  		$("#password_msg").html(result.msg);
      		  	}
      		  },
      		  error:function(){
      		  	alert("登录异常");
      		  }
      		});
      	}
      });
    
    });