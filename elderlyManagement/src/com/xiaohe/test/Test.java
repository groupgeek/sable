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

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xiaohe.bean.Area;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.mapper.AreaMapper;
import com.xiaohe.mapper.ProducttransactionreportMapper;
import com.xiaohe.mapper.TransactionMapper;
import com.xiaohe.service.BranchAdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class Test {
	
	@Autowired
	private TransactionMapper transactionMapper;
	
	@Autowired
	private BranchAdminService brancService;
	
	@Autowired
	private ProducttransactionreportMapper producttransactionreportMapper;
	
	@Autowired
	private AreaMapper areaMapper;
	
	
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
	
	@org.junit.Test
	public void demo5(){
		String name = "xiaohe";
		int a = 3;
		int sum = brancService.countEmpl();
		if(sum<10){
			name+=a+"00000"+sum;
		}if(sum<100&&sum>10){
			name+=a+"0000"+sum;
		}
		if(sum<1000&&sum>100){
			name+=a+"000"+sum;
		}
		if(sum<10000&&sum>1000){
			name+=a+"00"+sum;
		}
		if(sum<100000&&sum>10000){
			name+=a+"0"+sum;
		}
		System.out.println(name);
	}
	
	@org.junit.Test
	public void demo7(){
		Area area = new Area();
		area = areaMapper.oneAreaByEmpId(2);
		System.out.println(area.getAreaid());
	}
	
}
