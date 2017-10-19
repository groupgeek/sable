package com.xiaohe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.mapper.BranchMapper;
import com.xiaohe.service.BranchService;

@Repository("branchService")
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	@Qualifier("branchMapper")
	private BranchMapper branchMapper;

	public Branch queryBranchById(Integer id) {
		
		//return branchMapper.selectByPrimaryKey(id);
		return branchMapper.selectByPrimaryKey(id);
	}

}
