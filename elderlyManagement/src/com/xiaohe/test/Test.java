package com.xiaohe.test;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class Test {
	@org.junit.Test
	public void demo1(){
		System.out.println(1);
	}
}
