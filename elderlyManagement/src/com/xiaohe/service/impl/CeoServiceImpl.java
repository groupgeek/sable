package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.Ceo;
import com.xiaohe.bean.CeoActivity;
import com.xiaohe.bean.CeoActivityreport;
import com.xiaohe.bean.CeoActivityreportVo;
import com.xiaohe.bean.CeoBranchChartVo;
import com.xiaohe.bean.CeoEmployee;
import com.xiaohe.bean.CeoProducttransactionreport;
import com.xiaohe.bean.CeoProducttransactionreportVo;
import com.xiaohe.bean.CeoSelectVo;
import com.xiaohe.bean.CeoTotalreport;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.OrdersCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.ActivityMapper;
import com.xiaohe.mapper.ActivityreportMapper;
import com.xiaohe.mapper.BranchMapper;
import com.xiaohe.mapper.CeoMapper;
import com.xiaohe.mapper.EmployeeMapper;
import com.xiaohe.mapper.MessageMapper;
import com.xiaohe.mapper.OrdersMapper;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ProducttransactionreportMapper;
import com.xiaohe.mapper.TotalreportMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.CeoService;

@Repository("ceoService")
public class CeoServiceImpl implements CeoService{

	@Autowired
	private TotalreportMapper totalreportMapper;
	
	@Autowired
	private ProducttransactionreportMapper producttransactionreportMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	@Qualifier("activityMapper")
	private ActivityMapper activityMapper;
	
	@Autowired
	private ActivityreportMapper activityreportMapper;

	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private BranchMapper branchMapper;
	
	@Autowired
	private CeoMapper ceoMapper;
	
	/*-------------------首页实现------------------------- */
	/**
	 * 实现公司总盈利额的查询
	 */
	public List<String> findSumTotalreportMoney() {
		BigDecimal bigdecimal = totalreportMapper.selectTotalreportSum();
		List<String> list = new ArrayList<String>();
		BigDecimal f = new BigDecimal("10000.00");
		BigDecimal c = new BigDecimal("100000.00");
		BigDecimal e = new BigDecimal("100000000.00");
		if (bigdecimal.compareTo(c) == -1) {
			list.add(bigdecimal.toString());
			list.add(null);
			return list;
		}else if(bigdecimal.compareTo(e) == -1) {
			BigDecimal d = bigdecimal.divide(f,2);
			list.add(d.toString());
			list.add("万");
			return list;
		}else {
			BigDecimal d = bigdecimal.divide(e,2);
			list.add(d.toString());
			list.add("亿");
			return list;
		}
	}
	public List<BigDecimal> findSumTotalreportMoneyByTime() {
			return totalreportMapper.selectTotalreportSumByTime();	
	}
	/**
	 * 查询各分店的总盈利
	 */
	public List<CeoTotalreport> findTotalreportAndBranch(){		
		List<CeoTotalreport> bigdecimalCeoTotalreports = totalreportMapper.selectTotalreportAndBranch();		
		return bigdecimalCeoTotalreports;
	}
	/**
	 * 实现商城总盈利额的查询
	 */
	public List<String> findSumProductMoney() {
		BigDecimal bigDecimal = producttransactionreportMapper.selectSumproductAllMoney();
		List<String> list = new ArrayList<String>();
		BigDecimal a = new BigDecimal("10000.00");
		BigDecimal b = new BigDecimal("100000.00");
		BigDecimal c = new BigDecimal("100000000.00");
		if (bigDecimal.compareTo(b) == -1) {
			list.add(bigDecimal.toString());
			list.add(null);
			return list;
		}else if(bigDecimal.compareTo(c) == -1) {
			BigDecimal d = bigDecimal.divide(a,2);
			list.add(d.toString());
			list.add("万");
			return list;
		}else {
			BigDecimal d = bigDecimal.divide(c,2);
			list.add(d.toString());
			list.add("亿");
			return list;
		}
	}
	public List<BigDecimal> findSumProductMoneyByTime() {
		return producttransactionreportMapper.selectSumproductMoney();
	}
	/**
	 * 实现活动收入、支出的查询
	 */
	public List<String> findBigDecimalsfromActivity(){
		BigDecimal bigDecimal1 = activityMapper.selectSumActivityPrice();
		BigDecimal bigDecimal2 = activityMapper.selectSumregisteryFee();
		BigDecimal bigDecimal = new BigDecimal("0.00");
		bigDecimal = bigDecimal2.subtract(bigDecimal1);
		List<String> list = new ArrayList<String>();
		BigDecimal a = new BigDecimal("10000.00");
		BigDecimal b = new BigDecimal("100000.00");
		BigDecimal c = new BigDecimal("100000000.00");
		if (bigDecimal.compareTo(b) == -1) {
			list.add(bigDecimal.toString());
			list.add(null);
			return list;
		}else if(bigDecimal.compareTo(c) == -1) {
			BigDecimal d = bigDecimal.divide(a,2);
			list.add(d.toString());
			list.add("万");
			return list;
		}else {
			BigDecimal d = bigDecimal.divide(c,2);
			list.add(d.toString());
			list.add("亿");
			return list;
		}
	}
	/**
	 * 实现根据时间查询活动的收入、支出
	 */
	public List<Activity> findSumActivityByTime(){
		return activityMapper.selectSumActivityByTime();
	}
	public List<CeoActivity> findSumActivitieregisteryFeeByTime(){
		return activityMapper.selectSumregisteryFeeByTime();
	}
	/**
	 * 实现盈利图表的方法
	 */
	public CeoSelectVo findBigDecimal(){
		CeoSelectVo ceoSelectVo = new CeoSelectVo();
		List<CeoTotalreport> tList = totalreportMapper.CeoTotalreportByTime();
		List<String> newtList = new ArrayList<String>();
		for(int t = 0;t<12;t++ ){
			newtList.add("0");
		}

		List<CeoProducttransactionreport> pList = producttransactionreportMapper.ceoProductByTime();
		List<String> newpList = new ArrayList<String>();
		for (int p = 0; p < 12; p++) {
			newpList.add("0");
		}
		List<CeoActivity> aList = activityMapper.CeoActivityByTime();
		List<String> newaList = new ArrayList<String>();
		for (int ar = 0; ar < 12; ar++) {
			newaList.add("0");
		}
		List<CeoActivity> actList = activityMapper.CeoRegisteryFeeByTime();
		List<String> newactList = new ArrayList<String>();
		for (int act = 0; act < 12; act++) {
			newactList.add("0");
		}
		List<String> list = new ArrayList<String>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Date now = new Date();
		String formact = dateFormat.format(now);
		list.add(formact);
		for (int i = 1; i <12; i++) {
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(now);
			rightNow.add(Calendar.MONTH, -i);
			Date date = rightNow.getTime();
			String dString = dateFormat.format(date);
			list.add(dString);			
		}
		Collections.reverse(list);
		if (tList != null) {
			for (CeoTotalreport cTotalreport : tList) {
				String dString = dateFormat.format(cTotalreport.getDuringtime());
				cTotalreport.setStringDate(dString);
			}
			for(int a=0;a<12;a++){
				for(int b=0;b<tList.size();b++){					
					if (list.get(a).equals(tList.get(b).getStringDate())) {							
						newtList.set(a, tList.get(b).getBigdecimals());
					}					
				}
			}
		}
		if (pList != null) {
			for (CeoProducttransactionreport pCustom : pList) {
				String dString = dateFormat.format(pCustom.getBuytime());
				pCustom.setStringTime(dString);				
			}
			for(int a=0;a<12;a++){
				for(int b=0;b<pList.size();b++){					
					if (list.get(a).equals(pList.get(b).getStringTime())) {							
						newpList.set(a, pList.get(b).getSummoney());
					}					
				}
			}
		}
		if (aList != null) {
			for (CeoActivity cActivity : aList) {
				String dString = dateFormat.format(cActivity.getActivitydate());
				cActivity.setStringDate(dString);
			}
			for(int a=0;a<12;a++){
				for(int b=0;b<aList.size();b++){					
					if (list.get(a).equals(aList.get(b).getStringDate())) {							
						newaList.set(a, aList.get(b).getSumactivityPrice());
					}					
				}
			}
		}
		if (actList != null) {
			for (CeoActivity ceoActivity : actList) {
				String dString = dateFormat.format(ceoActivity.getActivitydate());
				ceoActivity.setStringTime(dString);
			}
			for(int a=0;a<12;a++){
				for(int b=0;b<actList.size();b++){					
					if (list.get(a).equals(actList.get(b).getStringTime())) {							
						newactList.set(a, actList.get(b).getSumregisteryFee());
					}					
				}
			}
		}
		ceoSelectVo.setListCeoTotalreports(newtList);
		ceoSelectVo.setListPCustoms(newpList);
		ceoSelectVo.setListActivities(newaList);
		ceoSelectVo.setListregisery(newactList);
		ceoSelectVo.setListStrings(list);
		return ceoSelectVo;
	}
	/**
	 * 实现用户数量的查询
	 */
	public List<String> findAllUser(){
		int sumuser = userMapper.selectAllUser();
		List<String> list = new ArrayList<String>();
		int a = 10000;
		int b = 100000;
		int c = 100000000;
		if (sumuser < b) {
			list.add(String.valueOf(sumuser));
			list.add(null);
			return list;
		}else if (sumuser < c) {
			int d = sumuser/a;
			list.add(String.valueOf(d));
			list.add("万");
			return list;
		}else {
			int d = sumuser/c;
			list.add(String.valueOf(d));
			list.add("亿");
			return list;
		}
	}
	public List<User> findAllUserByTime(){
		List<User> list = userMapper.selectAllUserByTime();
		return list;
	}
	public List<UserCustom> findUserCustoms(){
		List<UserCustom> user2 = userMapper.selectCountUserByBranch();		
		return user2;
	}
	public List<UserCustom> findfourUserByTime(){
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<UserCustom> userCustom = userMapper.selectfourUserByTime();
		for (UserCustom uCustom : userCustom) {
			if (uCustom.getRegistrationdate() != null) {
				String format = dt.format(uCustom.getRegistrationdate());
				uCustom.setStringregistrationdate(format);
			}else {
				uCustom.setStringregistrationdate(null);
			}			
		}				
		return userCustom;
	}
	public List<MessageCustom> findNewMessages(){
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<MessageCustom> messageCustoms = messageMapper.selectNewMessage();
		for (MessageCustom mCustom : messageCustoms) {
			String format = dt.format(mCustom.getMessagetime());
			mCustom.setStringDate(format);
		}
		return messageCustoms;
	}
	public List<Product> findHotProducts(){
		return productMapper.selectHotProduct();
	}
	public int findCountActivity(){
		return activityMapper.selectCountActivity();
	}
	public int findCountProduct(){
		return productMapper.selectCountProduct();
	}
	public int findCountOrder(){
		return ordersMapper.selectCountOrder();
	}
	public int findCountMessage(){
		return messageMapper.somecount();
	}
	/*----------------------首页结束------------------------- */
	/*----------------------用户信息---------------------------*/
	public List<UserCustom> findAllUserAndBranch(){
		return userMapper.selectAlluserandbranch();
	}
	/**
	 * 实现用户信息的查询
	 */	
	public UserCustom findUserById(Integer userid){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		UserCustom userCustom = userMapper.selectUserById(userid);				
		if (userCustom.getBirthday() != null) {
			String format1 = dateFormat.format(userCustom.getBirthday());
			userCustom.setStringDate(format1);
		}else {
			userCustom.setStringDate(null);
		}
		if (userCustom.getRegistrationdate() != null) {
			String format2 = dateFormat.format(userCustom.getRegistrationdate());
			userCustom.setStringregistrationdate(format2);
		}else {
			userCustom.setStringregistrationdate(null);
		}
		if (userCustom.getStatus() != null) {
			if (userCustom.getStatus() == true) {
				userCustom.setStringuser("正常");
			}else {
				userCustom.setStringuser("限制登录");
			}
		}		
		return userCustom;
	}
	/*----------------------用户信息查询结束----------------------*/
	/*----------------------商品信息-------------------------------*/
	/**
	 * 实现商品部分的查询
	 */
	public List<ProductCustom> findProductCustoms(){
		return productMapper.selectAllProduct();
	}
	public Product findProductById(Integer productid){
		return productMapper.selectByPrimaryKey(productid);
	}
	public List<CeoProducttransactionreport> ceoProductList(CeoProducttransactionreport ceoProducttransactionreport){
		List<CeoProducttransactionreport> cList = producttransactionreportMapper.ceoProductByIdinmonth(ceoProducttransactionreport);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (CeoProducttransactionreport cProducttransactionreport : cList) {
			String string = dateFormat.format(cProducttransactionreport.getBuytime());
			cProducttransactionreport.setStringTime(string);
		}
		return cList;
	}
	public List<CeoProducttransactionreport> ceoProducttransactionreports(CeoProducttransactionreport ceoProducttransactionreport){
		List<CeoProducttransactionreport> cList = producttransactionreportMapper.ceoProductByIdinyear(ceoProducttransactionreport);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		for (CeoProducttransactionreport cProducttransactionreport : cList) {
			String string = dateFormat.format(cProducttransactionreport.getBuytime());
			cProducttransactionreport.setStringDate(string);
		}
		return cList;
	}
	public List<CeoProducttransactionreport> cProducttransactionreports(CeoProducttransactionreport ceoProducttransactionreport){
		List<CeoProducttransactionreport> cList = producttransactionreportMapper.ceoProductByIdAllyear(ceoProducttransactionreport);
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		for (CeoProducttransactionreport cProducttransactionreport : cList) {
			String string = dateFormat.format(cProducttransactionreport.getBuytime());
			cProducttransactionreport.setDateString(string);
		}
		return cList;
	}
	/*---------------------------商品信息结束---------------------------*/
	
	/*------------------------------员工信息----------------------------*/
	
	/**
	 * 实现员工信息查询
	 */
	public List<Employee> findEmployees(Employee employee) {
		return employeeMapper.selectEmployee(employee);
	}	
	public List<CeoEmployee> findBranchEmployee() {
		return employeeMapper.selectBranchEmployee();
	}
	public CeoEmployee findEmployeeById(Integer employeeid){
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		CeoEmployee employee = employeeMapper.selectEmployeeAll(employeeid);	
		if (employee.getBirthday() != null) {
			String format1 = dt.format(employee.getBirthday());
			employee.setStringUserDate(format1);
		}else {
			employee.setStringUserDate(null);
		}
		if (employee.getEntrytime() != null) {
			String format2 = dt.format(employee.getEntrytime());
			employee.setStringemloyeeDate(format2);
		}else {
			employee.setStringemloyeeDate(null);
		}
		return employee;
	}
	/*---------------------------------员工信息结束-----------------------*/
	/*---------------------------------活动信息---------------------------*/
	/**
	 * 实现活动信息的查询
	 */
	public List<CeoActivity> findAllActivities() {
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		List<CeoActivity> activitiesList = activityMapper.selectAllActivity();
		for (CeoActivity activity : activitiesList) {
			if (activity.getActivitydate() != null) {
				String format = dt.format(activity.getActivitydate());
				activity.setStringDate(format);
			}else {
				activity.setStringDate(null);
			}
		}
		return activitiesList;
	}
	public CeoActivity findCeoActivity(Integer activityid){
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		CeoActivity activity = activityMapper.selectCeoActivity(activityid);
		if (activity.getActivitydate() != null) {
			String format = dt.format(activity.getActivitydate());
			activity.setStringDate(format);
		}else {
			activity.setStringDate(null);
		}
		if (activity.getOnline() != null) {
			if (activity.getOnline()==false) {
				String line = "否";
				activity.setStringline(line);
				return activity;
			}else {
				String line = "是";
				activity.setStringline(line);
				return activity;
			}
		}else {
			return activity;
		}
		
	}
	public List<CeoActivityreport> ceoActivityreportschart(){
		List<CeoActivityreport> activityreports = activityreportMapper.ceoActivityChart();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (CeoActivityreport ceoActivityreport : activityreports) {
			if (ceoActivityreport.getDuringtime() != null) {
				String dString = dateFormat.format(ceoActivityreport.getDuringtime());
				ceoActivityreport.setStringDate(dString);
			}
		}
		return activityreports;
	}
	public List<CeoActivityreport> allActivityreports(){
		List<CeoActivityreport> allaActivityreports = activityreportMapper.ceoActivityreport();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (CeoActivityreport ceoActivityreport : allaActivityreports) {
			if (ceoActivityreport.getDuringtime() != null) {
				String dString = dateFormat.format(ceoActivityreport.getDuringtime());
				ceoActivityreport.setStringDate(dString);
			}
		}
		return allaActivityreports;
	}
	
	/*------------------------------------活动信息结束----------------------------*/
	
	/*-------------------------------------留言信息----------------------------------*/
	/**
	 * 实现留言部分的查询
	 */
	public List<MessageCustom> findAllUserMessageCustoms() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<MessageCustom> messageCustoms = messageMapper.selectAllMessageByCeo();
		for (MessageCustom mCustom : messageCustoms) {
			String format = dateFormat.format(mCustom.getMessagetime());
			if (format != null) {
				mCustom.setStringDate(format);
			}else {
				mCustom.setStringDate(null);
			}
		}
		return messageCustoms;
	}
	public MessageCustom findMessage(Integer id){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (id == 0) {
			MessageCustom messageCustom = messageMapper.selectOnemessage();
			return messageCustom;
		}else {
			MessageCustom messageCustom = messageMapper.oneMessage(id);			
			if (messageCustom.getMessagetime() != null) {
				String format = dateFormat.format(messageCustom.getMessagetime());
				messageCustom.setStringDate(format);
			}else {
				messageCustom.setStringDate(null);
			}
			return messageCustom;
		}				
	}
	
	
	/*--------------------------------------留言信息结束---------------------------------*/
	
	/*-------------------------------------分店管理---------------------------------------*/
	/**
	 * 实现分店信息的查询
	 */
	public List<BranchCustom> findBranchCustoms() {
		return branchMapper.selectBranchs();
	}
	public Branch findBrachById(Integer branchid) {
		return branchMapper.selectByPrimaryKey(branchid);
	}	
	public List<ProductCustom> branchHotProduct(Integer id) {
		return productMapper.branchHotProduct(id);
	}
	public List<String> arr(Integer id){
		BigDecimal b = activityMapper.branchEduIncome(id);
		if (b == null) {
			b = new BigDecimal("0.00");
		}
		BigDecimal c = activityMapper.branchHealIncome(id);
		if (c == null) {
			c = new BigDecimal("0.00");
		}
		BigDecimal d = ordersMapper.queryBranchOderIncome(id);
		if (d == null) {
			d = new BigDecimal("0.00");
		}
		BigDecimal e = b.add(d).add(c);
		BigDecimal number1 = new BigDecimal("10000");
		BigDecimal number2 = new BigDecimal("100000");
		BigDecimal number3 = new BigDecimal("100000000");		
 		List<String> list = new ArrayList<String>();
 		if (b.compareTo(number2) == -1) {
			list.add(b.toString());
			list.add(null);
		}else if (b.compareTo(number3) == -1) {
			BigDecimal a = b.divide(number1,2);
			list.add(a.toString());
			list.add("万");
		}else {
			BigDecimal a = b.divide(number3,2);
			list.add(a.toString());
			list.add("亿");
		}
 		if (c.compareTo(number2) == -1) {
			list.add(c.toString());
			list.add(null);
		}else if (c.compareTo(number3) == -1) {
			BigDecimal a = c.divide(number1,2);
			list.add(a.toString());
			list.add("万");
		}else {
			BigDecimal a = c.divide(number3,2);
			list.add(a.toString());
			list.add("亿");
		}
 		if (d.compareTo(number2) == -1) {
			list.add(d.toString());
			list.add(null);
		}else if (d.compareTo(number3) == -1) {
			BigDecimal a = d.divide(number1,2);
			list.add(a.toString());
			list.add("万");
		}else {
			BigDecimal a = d.divide(number3,2);
			list.add(a.toString());
			list.add("亿");
		}
 		if (e.compareTo(number2) == -1) {
			list.add(e.toString());
			list.add(null);
		}else if (e.compareTo(number3) == -1) {
			BigDecimal a = e.divide(number1,2);
			list.add(a.toString());
			list.add("万");
		}else {
			BigDecimal a = e.divide(number3,2);
			list.add(a.toString());
			list.add("亿");
		}
		return list;
	}
	public CeoBranchChartVo listchart(Integer id){
		CeoBranchChartVo ceoBranchChartVo = new CeoBranchChartVo();
		List<CeoActivity> eList = activityMapper.CeoBranchEduIncome(id);
		List<String> neweList = new ArrayList<String>();
		for (int e = 0; e < 12; e++) {
			neweList.add("0.00");
		}
		List<CeoActivity> hList = activityMapper.CeoBranchHealIncome(id);
		List<String> newhList = new ArrayList<String>();
		for (int h = 0; h < 12; h++) {
			newhList.add("0.00");
		}
		List<OrdersCustom> oList = ordersMapper.CeoBranchOrderIncome(id);
		List<String> newoList = new ArrayList<String>();
		for (int o = 0; o < 12; o++) {
			newoList.add("0.00");
		}
		List<String> newbList = new ArrayList<String>();
		for (int b = 0; b < 12; b++) {
			newbList.add("0.00");
		}
		List<String> list = new ArrayList<String>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Date now = new Date();
		String formact = dateFormat.format(now);
		list.add(formact);
		for (int i = 1; i <12; i++) {
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(now);
			rightNow.add(Calendar.MONTH, -i);
			Date date = rightNow.getTime();
			String dString = dateFormat.format(date);
			list.add(dString);			
		}
		Collections.reverse(list);
		if (eList != null) {
			for (CeoActivity ceoActivity : eList) {
				String dString = dateFormat.format(ceoActivity.getActivitydate());
				ceoActivity.setStringDate(dString);
			}
			for(int i=0;i<12;i++){
				for(int j=0;j<eList.size();j++){					
					if (list.get(i).equals(eList.get(j).getStringDate())) {							
						neweList.set(i, eList.get(j).getSumEduIncome());
						newbList.set(i, neweList.get(i));
					}					
				}
			}
		}
		if (hList != null) {
			for (CeoActivity ceoActivity : hList) {
				String dString = dateFormat.format(ceoActivity.getActivitydate());
				ceoActivity.setStringTime(dString);				
			}
			for(int i=0;i<12;i++){
				for(int j=0;j<hList.size();j++){					
					if (list.get(i).equals(hList.get(j).getStringTime())) {							
						newhList.set(i, hList.get(j).getSumHealIncome());
						BigDecimal a = new BigDecimal(newhList.get(i));
						BigDecimal b = new BigDecimal(newbList.get(i));
						BigDecimal c = a.add(b);
						newbList.set(i, c.toString());
					}					
				}
			}
		}
		if (oList != null) {
			for (OrdersCustom ordersCustom : oList) {
				String dString = dateFormat.format(ordersCustom.getOrdertime());
				ordersCustom.setStringDate(dString);
			}
			for(int i=0;i<12;i++){
				for(int j=0;j<oList.size();j++){					
					if (list.get(i).equals(oList.get(j).getStringDate())) {							
						newoList.set(i, oList.get(j).getSumorderIncome());
						BigDecimal a = new BigDecimal(newoList.get(i));
						BigDecimal b = new BigDecimal(newbList.get(i));
						BigDecimal c = a.add(b);
						newbList.set(i, c.toString());
					}					
				}
			}
		}		
		ceoBranchChartVo.setListEduIncome(neweList);
		ceoBranchChartVo.setListHealIncome(newhList);
		ceoBranchChartVo.setListproduct(newoList);
		ceoBranchChartVo.setListSumBigdecimal(newbList);
		ceoBranchChartVo.setListDate(list);
		return ceoBranchChartVo;
	}
	public List<Integer> intlList(Integer id){
		int o = ordersMapper.branchCountOrders(id);
		int m = messageMapper.branchMessagesCount(id);
		int ac = activityMapper.branchCountActivity(id);
		int p = productMapper.branchCountProducts(id);
		int u = userMapper.countBranchUser(id);
		List<Integer> ar = new ArrayList<Integer>();
		ar.add(u);
		ar.add(ac);
		ar.add(o);
		ar.add(p);
		ar.add(m);
		return ar;
	}
	public List<UserCustom> listusernumber(Integer id){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<UserCustom> list = userMapper.CeoUsernumberofmonth(id);
		if (list != null) {
			for (UserCustom userCustom : list) {
				String string = dateFormat.format(userCustom.getRegistrationdate());
				userCustom.setStringregistrationdate(string);
			}
		}
		return list;
	}
	/*-------------------------------------分店结束----------------------------------------*/
	/*------------------------------------报表-----------------------------------------*/
	/**
	 * 按分店id查询商品的报表
	 * @param id
	 * @return
	 */
	public List<CeoProducttransactionreport> productchartofbranch(Integer id){
		List<CeoProducttransactionreport> productchart = producttransactionreportMapper.ceoproductChartOfBranch(id);
		return productchart;
	}
	
	public CeoProducttransactionreportVo productallchart(CeoProducttransactionreport condition){
		CeoProducttransactionreportVo ceoProducttransactionreportVo = new CeoProducttransactionreportVo();
		List<CeoProducttransactionreport> cList = new ArrayList<CeoProducttransactionreport>();
		Integer pageSum = 0;
		Integer sum = 0;
		
		if(condition != null){
			if(condition.getBranchid() == -1){
				condition.setBranchid(null);
			}
			condition.setProductname(condition.getSearch());					
			if(condition.getCurrentPage() >= 1){
				Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
				condition.setBegin(tempBegin);
			}else{
				condition.setBegin(0);
			}			
		}
		
		cList = producttransactionreportMapper.ceoproductAllchart(condition);
		
		sum = producttransactionreportMapper.ceoproductchartByCondition(condition);
		pageSum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		
		ceoProducttransactionreportVo.setLisproductchart(cList);
		ceoProducttransactionreportVo.setProductSum(sum);
		ceoProducttransactionreportVo.setPageSum(pageSum);
		
		return ceoProducttransactionreportVo;
	}
	public CeoActivityreportVo activitychart(CeoActivityreport ceoActivityreport){
		CeoActivityreportVo ceoActivityreportVo = new CeoActivityreportVo();
		List<CeoActivityreport> cList = new ArrayList<CeoActivityreport>();
		Integer pageNumofact = 0;
		Integer sum = 0;
		
		if(ceoActivityreport != null){
			if(ceoActivityreport.getBranchid() == -1){
				ceoActivityreport.setBranchid(null);
			}
			ceoActivityreport.setActivityname(ceoActivityreport.getSearchofact());					
			if(ceoActivityreport.getCurrentPageofactivity() >= 1){
				Integer tempBegin = (ceoActivityreport.getCurrentPageofactivity()-1) * ceoActivityreport.getPageNumofact();
				ceoActivityreport.setBegin(tempBegin);
			}else{
				ceoActivityreport.setBegin(0);
			}			
		}
				
		cList = activityreportMapper.ceoActivityreportOfBranch(ceoActivityreport);
			
		sum = activityreportMapper.ceoActivitychartnumber(ceoActivityreport);
		pageNumofact = sum / ceoActivityreport.getPageNumofact();
		if(sum % ceoActivityreport.getPageNumofact() != 0){
			pageNumofact += 1;
		}
		
		ceoActivityreportVo.setListactivity(cList);
		ceoActivityreportVo.setActivitySum(sum);
		ceoActivityreportVo.setPageNumofact(pageNumofact);
		
		return ceoActivityreportVo;
	}
	public List<CeoActivityreport> findActivityreportById(Integer id){
		return activityreportMapper.ceoActivityreportById(id);
	}
	
	public CeoActivityreport findCeoActivityreportById(Integer id){
		CeoActivityreport cList = activityreportMapper.ceooneActivityreport(id);
		BigDecimal a = cList.getTotalprice().subtract(cList.getTotalexpenditure());
		cList.setOnlyget(a);
		return cList;
	}
	public List<CeoProducttransactionreport> findceoproductchart(){
		return producttransactionreportMapper.ceofindproductchart();
	}
	public List<CeoProducttransactionreport> findproductchartofyear(){
		CeoProducttransactionreport clist1 = producttransactionreportMapper.ceofindproductchartByYear();
		CeoProducttransactionreport clist2 = producttransactionreportMapper.ceofindproductchartAll();
		List<CeoProducttransactionreport> cList = new ArrayList<CeoProducttransactionreport>();
		cList.add(clist1);
		cList.add(clist2);
		
		return cList;
	}
	public List<CeoProducttransactionreport> findceoproductchatOfbranch(Integer id){
		return producttransactionreportMapper.ceodfindproductchartOfbranch(id);
	}
	public List<CeoActivityreport> findceoactivitychartOfbranch(Integer id){
		return activityreportMapper.ceoactivitychartOfbranch(id);
	}
	public List<CeoActivityreport> ceoactivitychartByYear(){
		CeoActivityreport clist1 = activityreportMapper.ceoactivitychartByYear();
		CeoActivityreport clist2 = activityreportMapper.ceoactivitychartByAll();
		List<CeoActivityreport> cList = new ArrayList<CeoActivityreport>();
		cList.add(clist1);
		cList.add(clist2);
		return cList;
	}
	
	/*-------------------------------------报表结束-------------------------------------*/
	/**
	 * 测试用的方法
	 */
	public List<UserCustom> findUserTest(Integer id){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<UserCustom> list = userMapper.selectUserTest(id);
		for (UserCustom userCustom : list) {
			String fString = dateFormat.format(userCustom.getRegistrationdate());
			userCustom.setStringregistrationdate(fString);
		}
		return list;
	}
	public List<CeoProducttransactionreport> findProducttransactionreportTest(Integer id){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		List<CeoProducttransactionreport> list = producttransactionreportMapper.selectProductTest(id);
		for (CeoProducttransactionreport pCustom : list) {
			String fString = dateFormat.format(pCustom.getBuytime());
			pCustom.setStringTime(fString);
		}
		return list;
	}

	public Ceo findCeoById(Integer ceoid){
		return ceoMapper.selectByPrimaryKey(ceoid);
	}
	public Ceo quertyCEO(Ceo ceo) {
		
		
		if(ceo==null){
			return null;
		}else {
		Ceo ceos = ceoMapper.quertyCEO(ceo.getCeoaccountNumber());
		if(ceos == null){
			
			return null;
			
		}else if(ceos.getPassword().equals(ceo.getPassword()) == false){
			
			return  null;
			
		}else{
			return ceos;
			}
		}	
	}
	
}
