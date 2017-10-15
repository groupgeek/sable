package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.CommonsenseCustom;
import com.xiaohe.mapper.CommonsenseMapper;
import com.xiaohe.service.CommonsenseService;

@Repository("commonsenseService")
public class CommonsenseServiceImpl implements CommonsenseService {
	
	@Autowired
	@Qualifier("commonsenseMapper")
	private CommonsenseMapper commonsenseMapper;

	public List<CommonsenseCustom> queryCommonsenseByCondition(
			CommonsenseCustom commonsenseCustom) {
		return commonsenseMapper.selectCommonsenseByCondition(commonsenseCustom);
	}

}
