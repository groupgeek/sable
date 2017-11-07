package com.xiaohe.test;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.core.config.Order;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.mapper.ProducttransactionreportMapper;
import com.xiaohe.mapper.TransactionMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class Test {
	
	@Autowired
	private TransactionMapper transactionMapper;
	
	@Autowired
	private ProducttransactionreportMapper producttransactionreportMapper;
	@org.junit.Test
	public void demo1(){
		System.out.println(1);
	}
	
	@org.junit.Test
	public void demo2(){
		List<ProducttransactionreportCustom> p = new ArrayList<ProducttransactionreportCustom>();
		/*ProducttransactionreportCustom pro = new ProducttransactionreportCustom();
		pro.setEmployeeid(2);*/
		ProducttransactionreportCustom producttransactionreportCustom = new ProducttransactionreportCustom();
		/*producttransactionreportCustom.setEmployeeid(2);*/
		producttransactionreportCustom.setProductid(1);
		producttransactionreportCustom.setEmployeeid(2);
		Date date1 = new Date();
		Date date2 = new Date();
		date1.setDate(1);
		date1.setHours(0);
		date1.setMinutes(0);
		date2.setHours(0);
		date2.setMinutes(0);
		date2.setDate(2);
		producttransactionreportCustom.setStartingTime(date1);
		producttransactionreportCustom.setEndTime(date2);
		
		p = producttransactionreportMapper.selectBranchByCondition(producttransactionreportCustom);
		
		System.out.println(p);
	}
	
	@org.junit.Test
	public void demo3(){
		List<ProducttransactionreportCustom> producttransactionreportCustoms = new ArrayList<ProducttransactionreportCustom>();
		ProducttransactionreportCustom producttransactionreportCustom = new ProducttransactionreportCustom();
		producttransactionreportCustom.setEmployeeid(1);
		Date date1 = new Date();
		Date date2 = new Date();
		date1.setDate(1);
		date2.setDate(20);
		producttransactionreportCustom.setStartingTime(date1);
		producttransactionreportCustom.setEndTime(date2);
		
		
		
 		producttransactionreportCustoms = producttransactionreportMapper.selectBranchByCondition(producttransactionreportCustom);
 		System.out.println(producttransactionreportCustoms);
	}
	
	@org.junit.Test
	public void demo4(){
		TransactionCustom custom = new TransactionCustom();
		//custom.setTransactionid(4);
		custom.setUserid(1);
		/*custom.setCycle((float) 223);
		custom.setUserid(26);
		custom.setFrequency((float) 1);
		custom.setCountbuy(1);
		BigDecimal bigDecimal = new BigDecimal(8);
		custom.setTotalprice(bigDecimal);*/
		//System.out.println(transactionMapper.updateByPrimaryKey(custom));
		//System.out.println(transactionMapper.updateByPrimaryKeySelective(custom));
		System.out.println(transactionMapper.insertSelective(custom));
	}
	
	
}
