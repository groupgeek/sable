package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.AuthorityCustom;
import com.xiaohe.mapper.AuthorityMapper;
import com.xiaohe.service.AuthorityService;

@Repository("authorityService")
public class AuthorityServiceImpl implements AuthorityService {
	
	@Autowired
	@Qualifier("authorityMapper")
	private AuthorityMapper authorityMapper;

	public List<AuthorityCustom> queryAll() {
		
		return authorityMapper.selectAll();
	}

}
