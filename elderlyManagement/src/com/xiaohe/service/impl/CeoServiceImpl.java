package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.Activityregistery;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.Ceo;
import com.xiaohe.bean.CeoActivity;
import com.xiaohe.bean.CeoEmployee;
import com.xiaohe.bean.CeoTotalreport;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Producttransactionreport;
import com.xiaohe.bean.Totalreport;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.ActivityMapper;
import com.xiaohe.mapper.ActivityregisteryMapper;
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
	@Qualifier("ceoMapper")
	private CeoMapper ceoMapper;
	
	@Autowired
	private ActivityregisteryMapper activityregisteryMapper;
	
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
	
	/**
	 * 实现公司总盈利额的查询
	 */
	public BigDecimal findSumTotalreportMoney() {
		BigDecimal bigDecimal = totalreportMapper.selectTotalreportSum();
		if (bigDecimal == null) {
			bigDecimal = new BigDecimal("0.00");
			return bigDecimal;
		}else {
			return bigDecimal;
		}
	}
	public List<BigDecimal> findSumTotalreportMoneyByTime() {
		return totalreportMapper.selectTotalreportSumByTime();
	}
	/**
	 * 查询各分店的总盈利
	 */
	public List<CeoTotalreport> findTotalreportAndBranch(){
		return totalreportMapper.selectTotalreportAndBranch();
	}
	/**
	 * 实现商城总盈利额的查询
	 */
	public BigDecimal findSumProductMoney() {
		BigDecimal bigDecimal = producttransactionreportMapper.selectSumproductAllMoney();
		if (bigDecimal == null) {
			bigDecimal = new BigDecimal("0.00");
			return bigDecimal;
		}else {
			return bigDecimal;
		}
	}
	public List<BigDecimal> findSumProductMoneyByTime() {
		return producttransactionreportMapper.selectSumproductMoney();
	}
	/**
	 * 实现活动收入、支出的查询
	 */
	public BigDecimal findSumActivityPrice(){
		BigDecimal bigDecimal = activityMapper.selectSumActivityPrice();
		if (bigDecimal == null) {
			bigDecimal = new BigDecimal("0.00");
			return bigDecimal;
		}else {
			return bigDecimal;
		}
	}
	public BigDecimal findSumregisteryFee(){
		BigDecimal bigDecimal = activityMapper.selectSumregisteryFee();
		if (bigDecimal == null) {
			bigDecimal = new BigDecimal("0.00");
			return bigDecimal;
		}else {
			return bigDecimal;
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
	 * 实现用户数量的查询
	 */
	public int findAllUser(){
		int sumuser = userMapper.selectAllUser();
		return sumuser;
	}
	public List<User> findAllUserByTime(){
		List<User> list = userMapper.selectAllUserByTime();
		return list;
	}
	public List<UserCustom> findUserCustoms(){
		return userMapper.selectCountUserByBranch();
	}
	/**
	 * 实现新注册用户的查询
	 */
	public List<User> findfourUserByTime(){
		return userMapper.selectfourUserByTime();
	}
	public User findUserById(Integer userid){
		return userMapper.selectUserById(userid);
	}
	/**
	 * 实现员工信息查询
	 */
	public List<Employee> findEmployees(Employee employee) {
		return employeeMapper.selectEmployee(employee);
	}	
	public Employee findEmployeeById(Integer employeeid){
		return employeeMapper.selectEmployeeAll(employeeid);
	}
	public List<CeoEmployee> findBranchEmployee() {
		return employeeMapper.selectBranchEmployee();
	}

	/**
	 * 实现活动信息的查询
	 */
	public List<Activity> findAllActivities(Activity activity) {
		return activityMapper.selectAllActivity(activity);
	}
	public CeoActivity findCeoActivity(Integer activityid){
		return activityMapper.selectCeoActivity(activityid);
	}
	public int findCountActivity(){
		return activityMapper.selectCountActivity();
	}
	/**
	 * 查询热销商品
	 */
	public List<Product> findHotProducts(){
		return productMapper.selectHotProduct();
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

	public List<MessageCustom> findAllUserMessageCustoms() {
		return messageMapper.QureyMessages();
	}
	public int findCountMessage(){
		return messageMapper.somecount();
	}
	public List<MessageCustom> findNewMessages(){
		return messageMapper.selectNewMessage();
	}
	public MessageCustom findMessage(Integer id){
		return messageMapper.oneMessage(id);
	}

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

	public List<Branch> findAllBranchName(Branch branch) {
		return branchMapper.selectAllBranchName(branch);
	}

	public Branch findBrachById(Integer branchid) {
		return branchMapper.selectByPrimaryKey(branchid);
	}

	public List<BranchCustom> findBranchCustoms(BranchCustom branchCustom) {
		return branchMapper.selectBranchs(branchCustom);
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
