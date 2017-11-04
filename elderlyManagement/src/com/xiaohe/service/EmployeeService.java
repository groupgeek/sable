package com.xiaohe.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
	 * 查询员工信息所有信息
	 * @param id
	 * @return
	 */
	public EmployeeCustom queryEmployeeInfoById(Integer id);
	
	/**
	 * 更新员工详细信息
	 * @param employeeInfo
	 * @return
	 */
	public boolean UpdateUserInfoByUser(EmployeeCustom employeeInfo,MultipartFile pictureUpload);
	
	/**
	 * 添加员工
	 * @param employee
	 * @return 员工账号
	 */
	public String addEmployee(EmployeeCustom employee);
	
	/**
	 * 获取到某职位的所有员工
	 * @param positionid
	 * @return
	 */
	public List<EmployeeCustom> queryAllEmployeeByPosition(Integer positionid);

}
