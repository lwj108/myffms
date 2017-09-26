package com.ffms.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.ffms.dao.UserDao;
import com.ffms.entity.FfmsResult;
import com.ffms.entity.User;
import com.ffms.service.UserService;
import com.ffms.util.NoteException;
import com.ffms.util.NoteUtil;


@Service("userService")
@Transactional(isolation=Isolation.SERIALIZABLE)
public class UserServiceImpl implements UserService{


	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public FfmsResult checkLogin(
			String name, String password) {
		FfmsResult result = new FfmsResult();

		User user = userDao.findByName(name);
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		
		String md5_pwd = NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5_pwd)){
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}
		
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		//传出userId和用户token令牌
		String token = NoteUtil.createToken();
		Map<String,Object> data = 
			new HashMap<String, Object>();
		data.put("userToken", token);
		data.put("userId", user.getCn_user_id());
		result.setData(data);
		//将令牌号更新到数据表cn_user
		userDao.updateToken(data);
	
		return result;
	}
	@Transactional
	public FfmsResult checkLogin(String author) {
		try{
			
			String base64_msg = author.split(" ")[1];
			System.out.println("密文:"+base64_msg);
	
			byte[] output = 
				Base64.decodeBase64(base64_msg);
			String msg = new String(output,"UTF-8");
			System.out.println("明文"+msg);
	
			String name = msg.split(":")[0];
			String password = msg.split(":")[1];
			System.out.println("用户名:"+name);
			System.out.println("密码:"+password);
			FfmsResult result = checkLogin(
					name, password);
			return result;
		}catch(Exception ex){
			throw new NoteException("登陆异常");
		}
	}

	public FfmsResult registUser(User user) {
		FfmsResult result = new FfmsResult();
		//传递进来用户名,昵称,密码
		//检测用户名是否重复
		User usr = userDao.findByName(
			user.getCn_user_name());
		if(usr != null){
			result.setStatus(1);
			result.setMsg("用户名已占用");
			return result;
		}
		//设置ID
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);
		//密码加密
		String md5_pwd = NoteUtil.md5(
			user.getCn_user_password());
		user.setCn_user_password(md5_pwd);
		//调用userDao
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");
		//String s = null;//模拟发生异常,有事务会撤销前面save操作
		//s.length();
		return result;
	}

}
