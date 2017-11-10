package com.xiaohe.test;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javassist.expr.NewArray;

import org.apache.logging.log4j.core.config.Order;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.Area;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.mapper.AreaMapper;
import com.xiaohe.mapper.ProducttransactionreportMapper;
import com.xiaohe.mapper.TransactionMapper;
import com.xiaohe.service.BranchAdminService;
import com.xiaohe.util.GetStringByDate;

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
		String date1 = "2019-3-4 1:21:28";
		String date2 = "2018-3-3 1:21:28";
		/*int days = (int)((date2.getTime()-date1.getTime())/(1000*3600*24));*/
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date3 = format.parse(date1);
			Date date4 = format2.parse(date2);
			System.out.println(date3);
			
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(date3);
			rightNow.add(Calendar.DAY_OF_YEAR, 1);
			Date dt = rightNow.getTime();
			System.out.println(dt);
			
			System.out.println(date4);
			int days = (int)((date3.getTime()-date4.getTime())/(1000*3600*24));
			int days2 = (int)((dt.getTime()-date4.getTime())/(1000*3600*24));
			System.out.println(days);
			System.out.println(days2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
 		System.out.println(date1);
	}
	
	@org.junit.Test
	public void demo8() throws ParseException{
		ProducttransactionreportCustom producttransactionreportCustom = new ProducttransactionreportCustom();
		producttransactionreportCustom.setProductid(1);
		producttransactionreportCustom.setBuytime(new Date());
		producttransactionreportMapper.oneDayTransation(producttransactionreportCustom);
		ProducttransactionreportCustom p = new ProducttransactionreportCustom();
		System.out.println(p.getBuyTime());
		/*producttransactionreportMapper.oneDayTransation(producttransactionreportCustom);
		GetStringByDate bbb = new GetStringByDate();
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String nnDate = simpleDateFormat.format(new Date()); 
		java.util.Date date = simpleDateFormat.parse(nnDate); 
	    System.out.println(date);*/
	}
	
	@org.junit.Test
	public void hh(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int a = calendar.get(Calendar.YEAR);
		int b = calendar.get(Calendar.MONTH);
		int c = calendar.get(Calendar.DAY_OF_MONTH);
		Date date = new Date();
		date.setMonth(b);
		date.setYear(a);
		date.setDate(c);
		System.out.println(date);
		System.out.println(a);
		System.out.println(b+1);
		System.out.println(c);
		String dd = a+"-"+(b+1)+"-"+c;
		Date date2 = new Date();
		System.out.println(dd);
		System.out.println(date2);
	}
	
	@org.junit.Test
	public void ssss(){
		ProducttransactionreportCustom pro = new ProducttransactionreportCustom();
		ProducttransactionreportCustom pro2 = new ProducttransactionreportCustom();
		Date date = new Date();
		Date date2 = new Date();
		date.setMonth(10);
		date.setDate(1);
		date.setHours(0);
		date2.setMonth(10);
		date2.setDate(3);
		pro.setStart(date);
		pro.setEnd(date2);
		pro.setProductid(1);
		pro2 = producttransactionreportMapper.oneDayTransation(pro);
		System.out.println(date);
		System.out.println(date2);
		if(pro2!=null){
		System.out.println(pro2.getTotalprice());}
	}
	
}
