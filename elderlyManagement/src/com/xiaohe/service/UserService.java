package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;

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
	
	/**
	 * 改变用户的在线情况
	 * @param userCustom
	 * @return
	 */
	public boolean changeUserOnline(UserCustom userCustom);
	
	/**
	 * 查询所有用户信息
	 * @param condition 条件
	 * @return 用户集合
	 */
	public UserVo queryAllUserByCondition(UserCustom condition);
	
	/**
	 * 查询用户信息所有信息
	 * @param id
	 * @return
	 */
	public UserCustom queryUserInfoById(Integer id);
	
	/**
	 * 更新用户详细信息
	 * @param userInfo
	 * @return
	 */
	public boolean UpdateUserInfoByUser(UserCustom userInfo,MultipartFile pictureUpload);
}
