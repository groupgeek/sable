package com.xiaohe.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.CeoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class CeoTest {

	@Autowired
	@Qualifier("ceoService")
	private CeoService ceoService;
	
	@Test
	public void findUserCustoms(){
		List<UserCustom> list = ceoService.findUserCustoms();
		System.out.println(list);
	}
	
	@Test
	public void findSumTotalreportMoney(){
		System.out.println(ceoService.findSumTotalreportMoney());
	}
	
	@Test
	public void findSumTotalreportMoneyByTime(){
		System.out.println(ceoService.findSumTotalreportMoneyByTime());
	}
	
	@Test
	public void findBranchTotalreport(){
		System.out.println(ceoService.findBranchTotalreport(1));
	}
	
	@Test
	public void findTotalreportAndBranch(){
		System.out.println(ceoService.findTotalreportAndBranch().get(1).getStringbigdecimal());
	}
}
