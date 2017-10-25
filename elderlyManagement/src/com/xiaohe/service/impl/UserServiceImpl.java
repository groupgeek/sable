 package com.xiaohe.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.commons.digester.SetTopRule;
import com.xiaohe.bean.Transaction;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.TransactionMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.UserService;


@Repository("userService")//注册服务
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	@Autowired
	@Qualifier("transactionMapper")
	private TransactionMapper transactionMapper;

	public Boolean registerUser(UserCustom userCustom) {
		//如果手机号没有被注册 那么就注册该手机号
		if(userMapper.selectUserByPhone(userCustom.getPhone())==null){
			userCustom.setAccountnumber(userCustom.getPhone());
			userCustom.setLevelid(1);
			userCustom.setAuthorityid(1);
			
			if(userMapper.insertSelective(userCustom)>0){
				UserCustom user = new UserCustom();
				user = userMapper.selectUserByPhone(userCustom.getPhone());
				//创建用户交易表
				BigDecimal totalprice = new BigDecimal(0);
				Transaction transaction = new Transaction();
				transaction.setUserid(user.getUserid());
				transaction.setTotalprice(totalprice);
				transaction.setCycle((float) 0);
				transaction.setCountbuy(0);
				transaction.setFrequency((float) 0);
				transactionMapper.insertSelective(transaction);
				
				return true;
			}
			return false;
			
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
