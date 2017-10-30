package com.xiaohe.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.EmployeeVo;
import com.xiaohe.mapper.EmployeeMapper;
import com.xiaohe.service.EmployeeService;
import com.xiaohe.util.GetAge;

@Repository("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	@Qualifier("employeeMapper")
	private EmployeeMapper employeeMapper;

	public EmployeeVo queryAllEmployeeByCondition(EmployeeCustom condition) {
		
		EmployeeVo employeeVo = new EmployeeVo();
		List<EmployeeCustom> allEmployee = new ArrayList<EmployeeCustom>();
		Integer pageSum = 0;
		Integer sum = 0;
		
		
		if(condition != null){
			condition.setEmployeename(condition.getSearch());
			if(condition.getCurrentPage() >= 1){
				Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
				condition.setBegin(tempBegin);
			}else{
				condition.setBegin(0);
			}
			
		}
		
		allEmployee = employeeMapper.selectAllEmployeeByCondition(condition);
		
		//计算年龄,入职多少年
		for(EmployeeCustom temp : allEmployee){
			temp.setAge(GetAge.getAgeByBirth(temp.getBirthday()));
			temp.setEntryYears(GetAge.getAgeByBirth(temp.getEntrytime()));
		}
		
		
		sum = employeeMapper.selectAllEmployeeSumByCondition(condition);
		pageSum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		
		employeeVo.setEmployeeList(allEmployee);
		employeeVo.setPageSum(pageSum);
		employeeVo.setEmployeeSum(sum);
		
		
		
		
		return employeeVo;
	}

	public EmployeeCustom queryEmployeeInfoById(Integer id) {
		if(id == null || id < 0){
			return null;
		}
		
		EmployeeCustom employee = employeeMapper.selectEmployeeInfoById(id);
		//计算年龄,入职多少年
		employee.setAge(GetAge.getAgeByBirth(employee.getBirthday()));
		employee.setEntryYears(GetAge.getAgeByBirth(employee.getEntrytime()));
		
		return employee;
	}

}
