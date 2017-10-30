package com.xiaohe.service;


import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.EmployeeVo;

@Transactional
public interface EmployeeService {
	
	/**
	 * 查询所有员工
	 * @param condition
	 * @return
	 */
	public EmployeeVo queryAllEmployeeByCondition(EmployeeCustom condition);
	
	/**
	 * 查询用户信息所有信息
	 * @param id
	 * @return
	 */
	public EmployeeCustom queryEmployeeInfoById(Integer id);

}
