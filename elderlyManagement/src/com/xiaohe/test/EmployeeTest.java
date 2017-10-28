package com.xiaohe.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class EmployeeTest {
	
	@Autowired
	private EmployeeService employeeService;

		@org.junit.Test
		public void allEmployee(){
			
			EmployeeCustom condition = new EmployeeCustom();
			condition.setSearch("三");
			condition.setPageNum(2);
			condition.setCurrentPage(1);
			System.out.println(employeeService.queryAllEmployeeByCondition(condition).getEmployeeList().get(0).getAge());
		}
		
		@org.junit.Test
		public void employeeInfo(){
			
			System.out.println(employeeService.queryEmployeeInfoById(1));
		}
}
