package com.ffms.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	
	/**
	 * ����MD5ժҪ�㷨������Ϣ
	 * @param msg
	 * @return
	 */
	public static String md5(String msg){
		try{
			//��ȡMD5���ܹ��߶���
			MessageDigest md = 
				MessageDigest.getInstance("MD5");
			//��msg�ַ���ܴ���?
			byte[] input = msg.getBytes();
			byte[] output = md.digest(input);
			//�����ܺ��output���ת���ַ�?
			//����Base64�㷨���ֽ�����ת���ַ�
			String base64_msg = 
				Base64.encodeBase64String(output);
			return base64_msg;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public static String createId(){
		UUID uid  = UUID.randomUUID();
		return uid.toString().replaceAll("-", "");
	}
	
	public static String createToken(){
		return createId();
	}
	
	
	public static void main(String[] args){
//		System.out.println(md5("123456"));
//		System.out.println(md5("12346564634dsdfgsdf"));
		System.out.println(createId());
		System.out.println(createId());
	}
	
	
}
