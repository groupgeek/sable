package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Authority;
import com.xiaohe.bean.AuthorityCustom;

@Transactional
public interface AuthorityService {
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<AuthorityCustom> queryAll();
	
	/**
	 * 根据权限id查询权限
	 * @param aid
	 * @return
	 */
	public Authority queryByAuthorityId(Integer aid);

}
