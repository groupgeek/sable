package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.UserCustom;

@Transactional
public interface UserService {
	
	/**
	 * 用户注册
	 * @param userCustom 用户信息
	 */
	public Boolean registerUser(UserCustom userCustom);

	/**
	 * 用户登录
	 * @param userCustom 登录信息
	 * @return
	 */
	public UserCustom loginUser(UserCustom userCustom);
}
