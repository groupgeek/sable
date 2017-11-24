package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.BranchVo;

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
	
	/**
	 * 查询所有分店的信息（盈利，地区，等 分页）
	 * @param condition
	 * @return
	 */
	public BranchVo queryAllBranchByCondition(BranchCustom condition);
	
	/**
	 * 查询分店详细信息
	 * @param id
	 * @return
	 */
	public BranchCustom queryBranchInfoById(Integer id);
	
	/**
	 * 进入分店修改页面
	 * @return
	 */
	public BranchVo updateBranchView(Integer id);
	
	/**
	 * 修改分店信息
	 * @param branch
	 * @return
	 */
	public boolean updateBranch(BranchCustom branch);
	
	/**
	 * 分店添加页面 加载数据
	 * @return
	 */
	public BranchVo addBranchView();
	
	/**
	 * 分店添加
	 * @return
	 */
	public boolean addBranch(BranchCustom branchInfo);
}
