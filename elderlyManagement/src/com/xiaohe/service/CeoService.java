package com.xiaohe.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

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
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Producttransactionreport;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;

@Transactional
public interface CeoService {

	/* ----------------------首页查询------------------------------- */
	/**
	 * 查询公司总盈利额
	 * @param totalreport
	 * @return
	 */
	public List<String> findSumTotalreportMoney();
	/**
	 * 根据时间查询总盈利
	 * @return
	 */
	public List<BigDecimal> findSumTotalreportMoneyByTime();
	/**
	 * 查询商城总盈利额
	 * @param producttransactionreport
	 * @return
	 */
	public List<String> findSumProductMoney();
	/**
	 * 根据时间查询商城总盈利
	 * @return
	 */
	public List<BigDecimal> findSumProductMoneyByTime();
	/**
	 * 查询活动的总收入、总支出
	 * @param activity
	 * @return
	 */
	public List<String> findBigDecimalsfromActivity();
	/**
	 * 根据时间查询活动的支出
	 * @param activity
	 * @return
	 */
	public List<Activity> findSumActivityByTime();
	/**
	 * 根据时间查询活动的收入
	 * @return
	 */
	public List<CeoActivity> findSumActivitieregisteryFeeByTime();
	/**
	 * 查询用户的数量
	 * @param user
	 * @return
	 */
	public List<String> findAllUser();
	/**
	 * 根据注册时间查询用户
	 * @return
	 */
	public List<User> findAllUserByTime();
	/**
	 * 查询用户数量最多的前十分店
	 * @return
	 */
	public List<UserCustom> findUserCustoms();
	/**
	 * 根据分店id查询各分店的总盈利
	 * @param ceoTotalreport
	 * @return
	 */
	public List<CeoTotalreport> findTotalreportAndBranch();
	/**
	 * 查询新注册的4名用户
	 * @param user
	 * @return
	 */
	public List<UserCustom> findfourUserByTime();
	/**
	 * 查询热销商品
	 * @return
	 */
	public List<Product> findHotProducts();
	/**
	 * 查询最新消息
	 * @return
	 */
	public List<MessageCustom> findNewMessages();
	/**
	 * 做盈利额图表的方法
	 * @return
	 */
	public CeoSelectVo findBigDecimal();
	/**
	 * 查询活动的总数量
	 * @return
	 */
	public int findCountActivity();
	/**
	 * 查询商品数量
	 * @return
	 */
	public int findCountProduct();
	/**
	 * 查询订单数量
	 * @return
	 */
	public int findCountOrder();
	/**
	 * 查询留言数量
	 * @return
	 */
	public int findCountMessage();

	/*-------------------------首页结束----------------------------*/
	/*-------------------------用户信息查询--------------------------*/
	
	/**
	 * 查询用户的基本信息
	 * @return
	 */
	public List<UserCustom> findAllUserAndBranch();
	/**
	 * 查询用户的详细信息
	 * @param userid
	 * @return
	 */
	public UserCustom findUserById(Integer userid);
	/*-------------------------用户信息查询结束------------------------*/
	/*-------------------------商品信息---------------------------------*/
	/**
	 * 查询商品信息
	 * @return
	 */
	public List<ProductCustom> findProductCustoms();
	/**
	 * 查询商品的详细信息
	 * @param productid
	 * @return
	 */
	public Product findProductById(Integer productid);	
	/**
	 * 按id查询商品的月销售情况
	 * @param id
	 * @return
	 */
	public List<CeoProducttransactionreport> ceoProductList(CeoProducttransactionreport ceoProducttransactionreport);
	/**
	 * 按id查询商品的年销售情况
	 * @param ceoProducttransactionreport
	 * @return
	 */
	public List<CeoProducttransactionreport> ceoProducttransactionreports(CeoProducttransactionreport ceoProducttransactionreport);
	/**
	 * 按id查询商品的年销售占比
	 * @param ceoProducttransactionreport
	 * @return
	 */
	public List<CeoProducttransactionreport> cProducttransactionreports(CeoProducttransactionreport ceoProducttransactionreport);

	/*---------------------------商品信息结束-----------------------------*/
	
	/*----------------------------员工信息---------------------------------*/
	/**
	 * 查询员工信息
	 * @param employee
	 * @return
	 */
	public List<Employee> findEmployees(Employee employee);
	public List<CeoEmployee> findBranchEmployee();
	/**
	 * 查询员工的详细信息
	 * @param employeeid
	 * @return
	 */
	public CeoEmployee findEmployeeById(Integer employeeid);
	
	/*-------------------------------员工信息结束-------------------------*/
	/*--------------------------------活动信息---------------------------*/
	/**
	 * 查询活动信息
	 * @param activity
	 * @return
	 */
	public List<CeoActivity> findAllActivities();
	/**
	 * 查询活动消息信息
	 * @param activityid
	 * @return
	 */
	public CeoActivity findCeoActivity(Integer activityid);
	/**
	 * 查询活动报表
	 * @return
	 */
	public List<CeoActivityreport> ceoActivityreportschart();
	/**
	 * 查询所有活动报表
	 * @return
	 */
	public List<CeoActivityreport> allActivityreports();
	
	/*--------------------------------活动信息结束---------------------------*/
	/*--------------------------------留言信息--------------------------------*/
	/**
	 * 查询留言信息	
	 * @return
	 */
	public List<MessageCustom> findAllUserMessageCustoms();
	/**
	 * 查询留言的详细
	 * @param id
	 * @return
	 */
	public MessageCustom findMessage(Integer id);	
	
	/*---------------------------------留言信息结束----------------------------*/
	
	/*---------------------------------分店管理----------------------------------*/
	/**
	 * 查询分店并关联查询分店的管理员和地址
	 * @param ceoBranchCustom
	 * @return
	 */
	public List<BranchCustom> findBranchCustoms();	
	/**
	 * 通过id查询分店
	 * @param branchid
	 * @return
	 */
	public Branch findBrachById(Integer branchid);	
	/**
	 * 查询分店的热销商品
	 * @param id
	 * @return
	 */
	public List<ProductCustom> branchHotProduct(Integer id);	
	/**
	 * 查询分店的总收入、教务收入、健康收入、商城收入
	 * @param id
	 * @return
	 */
	public List<String> arr(Integer id);
	/**
	 * 查询分店总订单数、总信息数、总活动数、总商品数、总用户数
	 * @param id
	 * @return
	 */
	public List<Integer> intlList(Integer id);	
	/**
	 * 分店收入的报表
	 * @param ceoBranchChartVo
	 * @return
	 */
	public CeoBranchChartVo listchart(Integer id);
	/**
	 * 分店日用户注册量报表
	 * @param id
	 * @return
	 */
	public List<UserCustom> listusernumber(Integer id);
	
	/*------------------------------------分店结束-------------------------------------*/
	/*------------------------------------报表-----------------------------------------*/
	/**
	 * 按分店id查询商品的报表
	 * @param id
	 * @return
	 */
	public List<CeoProducttransactionreport> productchartofbranch(Integer id);
	/**
	 * 查询所有商品的报表
	 * @return
	 */
	public CeoProducttransactionreportVo productallchart(CeoProducttransactionreport condition);
	/**
	 * 根据分店查询活动报表
	 * @param id
	 * @return
	 */
	public CeoActivityreportVo activitychart(CeoActivityreport ceoActivityreport);
	/**
	 * 根据活动id查询活动的报表（做柱状图用）
	 * @param id
	 * @return
	 */
	public List<CeoActivityreport> findActivityreportById(Integer id);
	/**
	 * 根据活动id查询活动的盈利（做饼图用）
	 * @param id
	 * @return
	 */
	public CeoActivityreport findCeoActivityreportById(Integer id);
	/**
	 * 查询所有商品的报表（做图用）
	 * @return
	 */
	public List<CeoProducttransactionreport> findceoproductchart();
	/**
	 * 查询商品的报表（做饼图用）
	 * @return
	 */
	public List<CeoProducttransactionreport> findproductchartofyear();
	/**
	 * 查询分店所有商品的报表（做图用）
	 * @param id
	 * @return
	 */
	public List<CeoProducttransactionreport> findceoproductchatOfbranch(Integer id);
	/**
	 * 查询分店所有活动的报表（做图用）
	 * @param id
	 * @return
	 */
	public List<CeoActivityreport> findceoactivitychartOfbranch(Integer id);
	/**
	 * 查询活动报表（做图用）
	 * @return
	 */
	public List<CeoActivityreport> ceoactivitychartByYear();
	/*-------------------------------------报表结束-------------------------------------*/
	
	/**
	 * 测试方法
	 * @param id
	 * @return
	 */
	public List<UserCustom> findUserTest(Integer id);
	public List<CeoProducttransactionreport> findProducttransactionreportTest(Integer id);

	/**
	 *  ceo信息查询
	 * @param ceoid
	 * @return CEO信息
	 */
	public Ceo quertyCEO(Ceo ceo) ;
	
	public Ceo findCeoById(Integer ceoid);
}
