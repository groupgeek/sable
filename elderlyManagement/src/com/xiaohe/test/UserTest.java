package com.xiaohe.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class UserTest {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Test
	public void regTest(){
		UserCustom user = new UserCustom();
		user.setUsername("bbz");
		user.setPhone("18584781");
		user.setPassword("123456");
		System.out.println(userService.registerUser(user));
	}
	
	@Test
	public void logTest(){
		UserCustom user = new UserCustom();
		user.setUsername("bbz");
		user.setPhone("18584430401");
		user.setPassword("123456");
		System.out.println(userService.loginUser(user));
	}
	@Test
	public void allUser(){
		UserCustom user = new UserCustom();
		user.setCurrentPage(0);
		user.setPageNum(10);
		
		user.setSearch("");
		user.setSort("registrationdate");
		
		UserVo test = userService.queryAllUserByCondition(user);
		
		System.out.println(test.getUserList().get(0).getOnline());
		
	}
	@Test
	public void userInfo(){
		
		System.out.println(userService.queryUserInfoById(1).getMed().getBeforemedicalrecords());
	}

}
