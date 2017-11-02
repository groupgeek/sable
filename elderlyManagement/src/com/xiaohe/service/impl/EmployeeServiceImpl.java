package com.xiaohe.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.EmployeeVo;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.EmployeeMapper;
import com.xiaohe.service.EmployeeService;
import com.xiaohe.util.FileUpload;
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

	public boolean UpdateUserInfoByUser(EmployeeCustom employeeInfo,MultipartFile pictureUpload) {
		if(employeeInfo == null) return false;
		if(employeeInfo.getEmployeeid() == null) return false;
		
		if(!pictureUpload.isEmpty()){
			try {
				employeeInfo.setAvatar(FileUpload.oneFileUpload(pictureUpload,employeeInfo.getAvatar(), "picture"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(employeeMapper.updateByPrimaryKeySelective(employeeInfo) < 0) return false;
		
		
		return true;
	}

	public String addEmployee(EmployeeCustom employee) {
		
		/**
		 * 判断参数是否合格
		 */
		if(employee == null) return null;
		if(employee.getEmployeename() == null || " ".equals(employee.getEmployeename())) return null;
		if(employee.getPhone() == null || employee.getPhone().length() != 11) return null;
		if(employee.getPassword() == null || " ".equals(employee.getPassword())) return null;
		if(employee.getBankcardno() == null || employee.getBankcardno().length() != 19) return null;
		if(employee.getPositionid() == null || " ".equals(employee.getPositionid())) return null;
		
		Integer sum = employeeMapper.selectAllEmployeeSumByCondition(null);
		String accountNumber = "xiaohe"+employee.getPositionid();
		if(sum < 10){
			accountNumber += "00000"+(sum+1);
		}else if(sum >= 10 && sum < 100){
			accountNumber += "0000"+(sum+1);
		}else if(sum >= 100 && sum < 1000){
			accountNumber += "000"+(sum+1);
		}else if(sum >= 1000 && sum < 10000){
			accountNumber += "00"+(sum+1);
		}else if(sum >= 10000 && sum < 100000){
			accountNumber += "0"+(sum+1);
		}else{
			accountNumber += sum+1;
		}
		
		employee.setAccountnumber(accountNumber);
		if(employeeMapper.insertSelective(employee) <= 0) return null;
		
		return accountNumber;
	}

}
