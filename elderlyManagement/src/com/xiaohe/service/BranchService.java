package com.xiaohe.service;

import java.util.List;

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

	/**
	 * 查询所有分店
	 * @return
	 */
	public List<BranchCustom> queryAll();
}
