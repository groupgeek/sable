package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.IntegralCustom;
import com.xiaohe.bean.Orders;
import com.xiaohe.bean.OrdersCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.Producttransactionreport;
import com.xiaohe.bean.Transaction;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.User;
import com.xiaohe.mapper.IntegralMapper;
import com.xiaohe.mapper.OrdersMapper;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ProducttransactionreportMapper;
import com.xiaohe.mapper.TransactionMapper;
import com.xiaohe.service.OrdersService;

@Repository("ordersService")
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	@Qualifier("ordersMapper")
	private OrdersMapper ordersMapper;
	
	@Autowired
	@Qualifier("transactionMapper")
	private TransactionMapper transactionMapper;
	
	@Autowired
	@Qualifier("productMapper")
	private ProductMapper productMapper;
	
	@Autowired
	@Qualifier("producttransactionreportMapper")
	private ProducttransactionreportMapper producttransactionreportMapper;
	
	@Autowired
	@Qualifier("integralMapper")
	private IntegralMapper integralMapper;
	
	public Orders selectByPrimaryKey(String orderid) throws Exception {
		
		return ordersMapper.selectByPrimaryKey(orderid);
	}

	public List<Orders> selectAllOrdersByBranchId(Integer branchid) throws Exception {
		
		List<Orders>  allOrders = ordersMapper.selectAllOrdersByBranchId(branchid);
		
		return allOrders;
	}

	public void deleteByPrimaryKey(String orderid) throws Exception {
		
		 ordersMapper.deleteByPrimaryKey(orderid);
	}

	public void updateByPrimaryKey(Orders record) {
		
		ordersMapper.updateByPrimaryKey(record);
	}

	/*public int deleteByBranchId(Integer branchid) throws Exception {
		
		return ordersMapper.deleteByBranchId(branchid);
	}*/

	public Orders selectByPrimaryKey2(String orderid) throws Exception {
		
		return ordersMapper.selectByPrimaryKey2(orderid);
	}

	public boolean submitOrder(OrdersCustom info,User user) {
		
		if(user == null) return false;
		if(info == null) return false;
		if(info.getPaymentMethod() == null) return false;
		
		//数据
		OrdersCustom ordersData = new OrdersCustom();//单条订单
		List<OrdersCustom> all = new ArrayList<OrdersCustom>();//订单集合
		//总价
		BigDecimal total = new BigDecimal(0);
		
		
		//更新数据库
		
		
		info.setOrderstatus("已付款");
		info.setProductstatus("未发货");
		info.setPaymenttime(new Date());
		for(String oid : info.getOrdersid()){
			if("".equals(oid) || oid == null) continue;
			info.setOrderid(oid);
			//更新订单表
			if(ordersMapper.updateByPrimaryKeySelective(info) <= 0) return false;
			
			
		}
		
		
		
				
				
		//查询数据库得到订单信息
		for(String oid : info.getOrdersid()){
			if("".equals(oid) || oid == null) continue;
			ordersData = ordersMapper.selectOrdersByOrdersId(oid);
			if(ordersData == null) return false;
			total = total.add(ordersData.getTotalprice());
			all.add(ordersData);
			
			//查询产品
			Product product = new Product();
			product = productMapper.selectByPrimaryKey(ordersData.getProductid());
			
			//更新产品交易表
			
			Producttransactionreport productTT = new Producttransactionreport();
			productTT.setUserid(user.getUserid());
			productTT.setProductid(ordersData.getProductid());
			productTT.setCountbuy(ordersData.getProductnumber());
			productTT.setBuytime(ordersData.getPaymenttime());
			productTT.setTotalprice(ordersData.getTotalprice());
			productTT.setTotalexpenditure(product.getPurchaseprice().multiply(new BigDecimal(ordersData.getProductnumber())));
			productTT.setBranchid(product.getBranchid());
			if(producttransactionreportMapper.insertSelective(productTT) <= 0) return false;
			
		}
		
		//查询用户交易表
		Transaction transactionInfo = new Transaction();
		transactionInfo = transactionMapper.selectTransactionByUserId(user.getUserid());
		//更新用户交易表
		
		
		TransactionCustom transaction = new TransactionCustom();
		transaction.setUserid(user.getUserid());
		transaction.setTotalprice(total.add(transactionInfo.getTotalprice()));
		transaction.setCountbuy(transactionInfo.getCountbuy() + 1);
		//计算频率 周期
		/*Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		
		Calendar Reg = Calendar.getInstance();
		Reg.setTime(user.getRegistrationdate());
		
		Integer yearNow = now.get(Calendar.YEAR);
		Integer monthNow = now .get(Calendar.MONTH) + 1;
		
		Integer yearReg = Reg.get(Calendar.YEAR);
		Integer monthReg = Reg.get(Calendar.MONTH) +1;
		
		Integer year = yearNow - yearReg;
		Integer monthTemp = monthNow - monthReg;*/
		Long date = (new Date()).getTime() - user.getRegistrationdate().getTime();
		Long monthTemp = date / (1000);
		Integer month = (int) (monthTemp / (3600 * 24 * 30));
		
		if(month < 0) return false;
		if(date % (1000 * 3600 * 24 * 30) != 0){
			month += 1;
		}
		
		//if(monthTemp < 0) monthTemp = 0;
		/*if(year < 0) year = 0;
		Integer month = year * 12 + monthTemp;*/
		Float temp;
		if(month > 0){
			temp = ((transactionInfo.getCountbuy() + 1) / (float)month);
			transaction.setFrequency(temp);
			transaction.setCycle((float)1 / temp);
		}
		
		//更新交易
		if(transactionMapper.updateRecordByUserId(transaction) <= 0) return false;
		
		
		//更新用户积分
		//赠送积分
		
		IntegralCustom condetion = new IntegralCustom();
		condetion.setCurrentPage(1);
		condetion.setPageNum(1);
		condetion.setUserid(user.getUserid());
		
		IntegralCustom integral = new IntegralCustom();
		integral.setUserid(user.getUserid());
		integral.setChangetime(ordersData.getPaymenttime());
		IntegralCustom nowRec = integralMapper.selectUpToDateRecord(condetion);
		if(nowRec == null){
			nowRec = new IntegralCustom();
			nowRec.setRemainingpoints(0);
		}
		
		integral.setChangeintegral(Integer.parseInt(total.divide(new BigDecimal(10)).toBigInteger().toString()));
		integral.setDetails("购买产品赠送，单号：" + info.getOrdersid()[0] + "....");
		integral.setRemainingpoints(Integer.parseInt(total.divide(new BigDecimal(10)).toBigInteger().toString()) + nowRec.getRemainingpoints());
		
		integralMapper.insertSelective(integral);
		
		System.out.println("一共："+total);		
		
		//接口处理
		
		
		
		
		
		
		
		return true;
	}
	
}