package com.xiaohe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.UserService;


@Repository("userService")//注册服务
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	public Boolean registerUser(UserCustom userCustom) {
		//如果手机号没有被注册 那么就注册该手机号
		if(userMapper.selectUserByPhone(userCustom.getPhone())==null){
			userMapper.insertSelective(userCustom);
			
			
			return true;
		}else {
			return false;
		}
	}

	public UserCustom loginUser(UserCustom userCustom) {
		UserCustom custom = userMapper.selectUserByPhone(userCustom.getPhone());
		if(custom == null){
			
			return null;
			
		}else if(custom.getPassword().equals(userCustom.getPassword()) == false){
			
			return  null;
			
		}else{
			return custom;
		}
	}
	
	
}
