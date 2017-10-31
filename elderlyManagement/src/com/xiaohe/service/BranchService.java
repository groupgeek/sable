package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;

@Transactional
public interface BranchService {
	
	/**
	 * 根据id查询branch
	 * @param id
	 * @return
	 */
	public Branch queryBranchById(Integer id);

}
