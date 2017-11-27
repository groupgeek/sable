package com.xiaohe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.AreaCustom;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.BranchVo;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.mapper.AreaMapper;
import com.xiaohe.mapper.BranchMapper;
import com.xiaohe.mapper.EmployeeMapper;
import com.xiaohe.service.BranchService;

@Repository("branchService")
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	@Qualifier("branchMapper")
	private BranchMapper branchMapper;
	
	@Autowired
	@Qualifier("employeeMapper")
	private EmployeeMapper employeeMapper;
	
	@Autowired
	@Qualifier("areaMapper")
	private AreaMapper areaMapper;

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

	public BranchVo updateBranchView(Integer id) {
		BranchVo branchVo = new BranchVo();
		List<EmployeeCustom> employeeList = new ArrayList<EmployeeCustom>();
		BranchCustom branch = new BranchCustom();
		
		branch = branchMapper.selectBranchInfoById(id);
		EmployeeCustom custom = new EmployeeCustom();
		custom.setPositionid(1);
		employeeList = employeeMapper.selectAllEmployeeByPosition(custom);
		
		branchVo.setEmployeeList(employeeList);
		branchVo.setBranch(branch);
		return branchVo;
	}

	public boolean updateBranch(BranchCustom branch) {
		if(branch == null) return false;
		if(branch.getBranchid() == null || branch.getEmployeeid() == null) return false;
		
		if(branchMapper.updateByPrimaryKeySelective(branch) < 0) return false;
		//设置原来的员工职位为空
		//if(employeeMapper.updateEmployeePositionalNull(branch.getOldemployeeid()) < 0) return false;
		//修改新员工的地区
		Employee record = new Employee();
		record.setEmployeeid(branch.getEmployeeid());
		record.setAreaid(branch.getAreaid());
		if(employeeMapper.updateByPrimaryKeySelective(record) < 0) return false;
		
		return true;
	}

	public BranchVo addBranchView() {
		
		BranchVo branchVo = new BranchVo();
		List<EmployeeCustom> employeeList = new ArrayList<EmployeeCustom>();
		List<AreaCustom> allArea = new ArrayList<AreaCustom>();
		employeeList = employeeMapper.selectAllEmployeeByPosition(null);
		allArea  = areaMapper.selectAreasByCondition(null);
		branchVo.setAllArea(allArea);
		branchVo.setEmployeeList(employeeList);
		
		return branchVo;
	}

	public boolean addBranch(BranchCustom branchInfo) {
		if(branchInfo == null) return false;
		if(branchInfo.getAreaid() == null) return false;
		if(branchInfo.getEmployeeid() == -1){
			branchInfo.setEmployeeid(null);
		}
		if(branchMapper.insertSelective(branchInfo) < 0) return false;
		
		return true;
	}

	public BranchVo queryBranchByCustom(BranchCustom custom){
		BranchVo branchVo = new BranchVo();
		List<BranchCustom> allbranchs = new ArrayList<BranchCustom>();
		Integer pageSum = 0;
		Integer sum = 0;
		if(custom != null){			
			if(custom.getCurrentPage() >= 1){
				Integer tempBegin = (custom.getCurrentPage()-1) * custom.getPageNum();
				custom.setBegin(tempBegin);
			}else{
				custom.setBegin(0);
			}
		}
		allbranchs = branchMapper.selectAllBranchByCustom(custom);
		sum = branchMapper.selectAllBranchSumByCustom(custom);
		pageSum = sum / custom.getPageNum();
		if(sum % custom.getPageNum() != 0){
			pageSum += 1;
		}
		branchVo.setBranchList(allbranchs);
		branchVo.setBranchSum(sum);
		branchVo.setPageSum(pageSum);
			
		return branchVo;
	}
}
