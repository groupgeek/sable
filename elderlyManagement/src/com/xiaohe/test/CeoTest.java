package com.xiaohe.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.service.CeoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class CeoTest {

	@Autowired
	@Qualifier("ceoService")
	private CeoService ceoService;
	
	@Test
	public void findUserCustoms(){
		
		System.out.println(ceoService.findUserCustoms().get(0).getStringuser());
	}
	
	@Test
	public void findSumTotalreportMoney(){
		System.out.println(ceoService.findSumTotalreportMoney());
	}
	
	@Test
	public void findSumTotalreportMoneyByTime(){
		System.out.println(ceoService.findSumTotalreportMoneyByTime().get(0));
	}
	
	@Test
	public void findBranchTotalreport(){
		System.out.println(ceoService.findBranchTotalreport(1));
	}
	
	@Test
	public void findTotalreportAndBranch(){
		System.out.println(ceoService.findTotalreportAndBranch().get(0).getStringbigdecimal());
	}
	
	@Test
	public void findfourUserByTime(){
		System.out.println(ceoService.findfourUserByTime().get(0).getStringregistrationdate());
	}
	
	@Test
	public void findUserById(){
		System.out.println(ceoService.findUserById(33).getStringregistrationdate());
	}
	@Test
	public void findAllUserMessageCustoms(){
		System.out.println(ceoService.findAllUserMessageCustoms().get(0).getStringDate());
	}
	@Test
	public void findMessage(){
		System.out.println(ceoService.findMessage(1).getStringDate());
	}
	
	@Test
	public void findSumProductMoney(){
		System.out.println(ceoService.findSumProductMoney());
	}
}
