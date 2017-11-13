package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
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
import com.xiaohe.bean.CeoEmployee;
import com.xiaohe.bean.CeoProducttransactionreport;
import com.xiaohe.bean.CeoSelectVo;
import com.xiaohe.bean.CeoTotalreport;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Producttransactionreport;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.ActivityMapper;
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
		NumberFormat numberFormat = NumberFormat.getPercentInstance();
		numberFormat.setMaximumFractionDigits(2);
		List<CeoTotalreport> bigdecimalCeoTotalreports = totalreportMapper.selectTotalreportAndBranch();
		BigDecimal sum = new BigDecimal("0.00");
		for (int i = 0; i < bigdecimalCeoTotalreports.size(); i++) {
			BigDecimal sum1 = new BigDecimal(bigdecimalCeoTotalreports.get(i).getSumBigDecimal());
			sum = sum.add(sum1);
		}
		BigDecimal bigDecimal1 = sum;		
		BigDecimal a = bigDecimal1.setScale(4);
		for (CeoTotalreport totalreport : bigdecimalCeoTotalreports) {
			if (totalreport.getSumBigDecimal() != null) {
				BigDecimal bigDecimal2 = new BigDecimal(totalreport.getSumBigDecimal());
				BigDecimal b = bigDecimal2.setScale(4);
				BigDecimal result = null;
				result =  b.divide(a,4);
				double c = result.doubleValue();
				String bigDecimal = numberFormat.format(c);
				totalreport.setStringbigdecimal(bigDecimal);
			}else {
				totalreport.setStringbigdecimal(null);
			}
		}		
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

		List<CeoProducttransactionreport> pList = producttransactionreportMapper.CeoProductByTime();
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
	
	
	public List<UserCustom> findUserCustoms(){
		NumberFormat numberFormat = NumberFormat.getPercentInstance();
		numberFormat.setMaximumFractionDigits(2);
		Integer user1 = userMapper.selectAllUser();
		List<UserCustom> user2 = userMapper.selectCountUserByBranch();		
		for (UserCustom userCustom : user2) {
			if (user1 != null && user2 != null && user1 != 0) {
				Integer user = userCustom.getUsernumber();
				float user3 = (float)user/(float)user1;
				String unmber = numberFormat.format(user3);
				userCustom.setStringuser(unmber);
			}else {
				userCustom.setStringuser(null);
			}		
		}
		return user2;
	}
	/**
	 * 实现用户信息的查询
	 */
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
	public List<UserCustom> findAllUserAndBranch(){
		return userMapper.selectAlluserandbranch();
	}
	/**
	 * 实现员工信息查询
	 */
	public List<Employee> findEmployees(Employee employee) {
		return employeeMapper.selectEmployee(employee);
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
	public List<CeoEmployee> findBranchEmployee() {
		return employeeMapper.selectBranchEmployee();
	}

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
	public int findCountActivity(){
		return activityMapper.selectCountActivity();
	}
	/**
	 * 实现商品部分的查询
	 */
	public List<Product> findHotProducts(){
		return productMapper.selectHotProduct();
	}

	public List<ProductCustom> findProductCustoms(){
		return productMapper.selectAllProduct();
	}
	
	public Product findProductById(Integer productid){
		return productMapper.selectByPrimaryKey(productid);
	}
	public int findCountProduct(){
		return productMapper.selectCountProduct();
	}
	
	public int findCountOrder(){
		return ordersMapper.selectCountOrder();
	}
	/**
	 * 实现留言部分的查询
	 */
	public List<MessageCustom> findAllUserMessageCustoms() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<MessageCustom> messageCustoms = messageMapper.QureyMessages();
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
	public int findCountMessage(){
		return messageMapper.somecount();
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
	public MessageCustom findMessage(Integer id){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (id == null) {
			id = 1;
		}
		MessageCustom messageCustom = messageMapper.oneMessage(id);			
		if (messageCustom.getMessagetime() != null) {
			String format = dateFormat.format(messageCustom.getMessagetime());
			messageCustom.setStringDate(format);
		}else {
			messageCustom.setStringDate(null);
		}
		return messageCustom;
	}
	/**
	 * 实现分店信息的查询
	 */
	public List<ProductCustom> branchHotProduct(Integer id) {
		return productMapper.branchHotProduct(id);
	}
	public BigDecimal totalEduIncome(Integer id) {
		return activityMapper.branchEduIncome(id);
	}
	public BigDecimal totalHealIncome(Integer id) {
		return activityMapper.branchHealIncome(id);
	}
	public BigDecimal totalOderIncome(Integer id) {
		return ordersMapper.queryBranchOderIncome(id);
	}
	public int brachCountOrders(Integer id) {
		return ordersMapper.branchCountOrders(id);
	}
	public int branchMessagesCount(Integer id) {
		return messageMapper.branchMessagesCount(id);
	}
	public int branchCountActivities(Integer id) {
		return activityMapper.branchCountActivity(id);
	}
	public int branchCountProducts(Integer id) {
		return productMapper.branchCountProducts(id);
	}
	public int branchCountUsers(Integer id) {
		return userMapper.countBranchUser(id);
	}	
	public List<Branch> findAllBranchName() {
		return branchMapper.selectAllBranchName();
	}
	public Branch findBrachById(Integer branchid) {
		return branchMapper.selectByPrimaryKey(branchid);
	}
	public List<BranchCustom> findBranchCustoms() {
		return branchMapper.selectBranchs();
	}
	
	public List<CeoTotalreport> findBranchTotalreport(Integer branchid){
		return totalreportMapper.selectBranchTotalreport(branchid);
	}
	public List<CeoTotalreport> findCeoTotalreports(CeoTotalreport ceoTotalreport){
		return totalreportMapper.selectTotalreports(ceoTotalreport);
	}
	public CeoTotalreport findBranchMoney(CeoTotalreport ceoTotalreport){
		return totalreportMapper.selectBranchMoney(ceoTotalreport);
	}
	public Ceo findCeoById(Integer ceoid){
		return ceoMapper.selectByPrimaryKey(ceoid);
	}
	public Ceo quertyCEO(Ceo ceo) {
		
		
		if(ceo==null){
			return null;
		}else {
		Ceo ceos = ceoMapper.selectByPrimaryKey(ceo.getCeoid());
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
