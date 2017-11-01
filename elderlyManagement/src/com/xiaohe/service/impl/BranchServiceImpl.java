package com.xiaohe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.BranchVo;
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

	public List<BranchCustom> queryAll() {
		return branchMapper.selectAll();
	}

	public BranchVo queryAllBranchByCondition(BranchCustom condition) {
		BranchVo branchVo = new BranchVo();
		List<BranchCustom> allBranch = new ArrayList<BranchCustom>();
		Integer pageSum = 0;
		Integer branchSum = 0;
		
		if(condition != null){
			if(condition.getCurrentPage() >= 1){
				Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
				condition.setBegin(tempBegin);
			}else{
				condition.setBegin(0);
			}
		}
		
		allBranch = branchMapper.selectAllBranchByCondition(condition);
		branchSum = branchMapper.selectAllBranchSumByCondition(condition);
		pageSum = branchSum / condition.getPageNum();
		if(branchSum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		
		branchVo.setBranchList(allBranch);
		branchVo.setBranchSum(branchSum);
		branchVo.setPageSum(pageSum);
		
		return branchVo;
	}

	public BranchCustom queryBranchInfoById(Integer id) {
		if(id == null || id < 0){
			return null;
		}
		BranchCustom branchInfo = new BranchCustom();
		branchInfo = branchMapper.selectBranchInfoById(id);
		return branchInfo;
	}

}
