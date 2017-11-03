package com.xiaohe.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.Activityregistery;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.CeoActivity;
import com.xiaohe.bean.CeoEmployee;
import com.xiaohe.bean.CeoTotalreport;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Producttransactionreport;
import com.xiaohe.bean.Totalreport;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;

@Transactional
public interface CeoService {

	/**
	 * 查询公司总盈利额
	 * @param totalreport
	 * @return
	 */
	public BigDecimal findSumTotalreportMoney();
	public List<BigDecimal> findSumTotalreportMoneyByTime();
	/**
	 * 查询商城总盈利额
	 * @param producttransactionreport
	 * @return
	 */
	public BigDecimal findSumProductMoney();
	public List<BigDecimal> findSumProductMoneyByTime();
	/**
	 * 根据分店id查询各分店的总盈利
	 * @param ceoTotalreport
	 * @return
	 */
	public List<CeoTotalreport> findTotalreportAndBranch();
	/**
	 * 查询活动的总收入、总支出
	 * @param activity
	 * @return
	 */
	public BigDecimal findSumActivityPrice();
	public BigDecimal findSumregisteryFee();
	/**
	 * 根据时间查询活动的收入、支出
	 * @param activity
	 * @return
	 */
	public List<Activity> findSumActivityByTime();
	public List<CeoActivity> findSumActivitieregisteryFeeByTime();
	/**
	 * 查询活动的总数量
	 * @return
	 */
	public int findCountActivity();
	/**
	 * 查询用户的数量
	 * @param user
	 * @return
	 */
	public int findAllUser();
	public List<User> findAllUserByTime();
	public List<UserCustom> findUserCustoms();
	/**
	 * 查询新注册的4名用户
	 * @param user
	 * @return
	 */
	public List<User> findfourUserByTime();
	public User findUserById(Integer userid);
	/**
	 * 查询员工信息
	 * @param employee
	 * @return
	 */
	public List<Employee> findEmployees(Employee employee);
	public Employee findEmployeeById(Integer employeeid);
	public List<CeoEmployee> findBranchEmployee();
	
	/**
	 * 查询活动信息
	 * @param activity
	 * @return
	 */
	public List<Activity> findAllActivities(Activity activity);
	public CeoActivity findCeoActivity(Integer activityid);
	/**
	 * 查询热销商品
	 * @return
	 */
	public List<Product> findHotProducts();
	public Product findProductById(Integer productid);
	
	public int findCountProduct();
	
	public int findCountOrder();
		
	public List<MessageCustom> findAllUserMessageCustoms();
	public int findCountMessage();
	public List<MessageCustom> findNewMessages();
	public MessageCustom findMessage(Integer id);
	
	/**
	 * 查询分店的热销商品
	 * @param id
	 * @return
	 */
	public List<ProductCustom> branchHotProduct(Integer id);
	
	/**
	 * 查询分店教育的总收入
	 * @return
	 */
	public BigDecimal totalEduIncome(Integer id);
	
	/**
	 * 查询分店活动的总收入
	 * @return
	 */
	public BigDecimal totalHealIncome(Integer id);
	
	/**
	 * 查询分店总收入
	 * @return
	 */
	public BigDecimal totalOderIncome(Integer id);
	
	/**
	 * 查询分店总订单数
	 * @param id
	 * @return
	 */
	public int brachCountOrders(Integer id);
	
	/**
	 * 查询分店信息的总条数
	 * @return
	 */
	public int branchMessagesCount(Integer id);
	
	/**
	 * 查询分店总活动数
	 * @param id
	 * @return
	 */
	public int branchCountActivities(Integer id);
	
	/**
	 * 查询分店总商品数
	 * @param id
	 * @return
	 */
	public int branchCountProducts(Integer id);
	
	/**
	 * 查询分店总用户数
	 * @param id
	 * @return
	 */
	public int branchCountUsers(Integer id);
	
	/**
	 * 通过id查询分店
	 * @param branchid
	 * @return
	 */
	public Branch findBrachById(Integer branchid);
	
	/**
	 * 查询所有分店
	 * @param branch
	 * @return
	 */
	public List<Branch> findAllBranchName(Branch branch);
	
	/**
	 * 查询分店并关联查询分店的管理员和地址
	 * @param ceoBranchCustom
	 * @return
	 */
	public List<BranchCustom> findBranchCustoms(BranchCustom branchCustom);
	
}
