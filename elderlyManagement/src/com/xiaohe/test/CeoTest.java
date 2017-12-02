package com.xiaohe.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.CeoProducttransactionreport;
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
	public void findTotalreportAndBranch(){
		System.out.println(ceoService.findTotalreportAndBranch().get(0).getSumBigDecimal());
	}
	
	@Test
	public void findfourUserByTime(){
		System.out.println(ceoService.findfourUserByTime().get(0).getStringregistrationdate());
	}
	
	@Test
	public void findUserById(){
		System.out.println(ceoService.findUserById(33).getStringregistrationdate());
	}
	/*@Test
	public void findAllUserMessageCustoms(){
		System.out.println(ceoService.findAllUserMessageCustoms().get(0).getStringDate());
	}*/
	@Test
	public void findMessage(){
		System.out.println(ceoService.findMessage(1).getStringDate());
	}
	
	@Test
	public void findSumProductMoney(){
		System.out.println(ceoService.findSumProductMoney());
	}
	
	@Test
	public void findProducttransactionreportTest(){
		System.out.println(ceoService.findProducttransactionreportTest(1).get(0).getStringTime());
	}
	
	@Test
	public void findBigDecimal(){
		
		System.out.println(ceoService.findBigDecimal().getListPCustoms());
	}
	@Test
	public void arr(){
		System.out.println(ceoService.arr(1));
	}
	@Test
	public void intlList(){
		System.out.println(ceoService.intlList(1));
	}
	
	@Test
	public void listchart(){
		System.out.println(ceoService.listchart(1).getListHealIncome());
	}
	@Test
	public void branchHotProduct(){
		System.out.println(ceoService.branchHotProduct(1));
	}
	@Test
	public void ceoActivityreportschart(){
		System.out.println(ceoService.ceoActivityreportschart().get(0).getStringDate());
	}
	@Test
	public void findBranchCustoms(){
		System.out.println(ceoService.findBranchCustoms());
	}
	@Test
	public void findCeoActivityreportById(){
		System.out.println(ceoService.findCeoActivityreportById(1).getOnlyget());
	}
	
	@Test
	public void productallchart(){
		CeoProducttransactionreport condition = new CeoProducttransactionreport();
		condition.setSearch("");
		condition.setSort("price");
		condition.setCurrentPage(1);
		condition.setPageNum(10);
		condition.setBranchname("贵阳分店");
		System.out.println(ceoService.productallchart(condition).getLisproductchart().get(0).getProductname());
	}
}
