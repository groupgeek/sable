package com.xiaohe.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.CeoActivity;
import com.xiaohe.bean.CeoEmployee;
import com.xiaohe.bean.CeoSelectVo;
import com.xiaohe.bean.CeoTotalreport;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.CeoService;

@Controller
@RequestMapping("/ceo")
public class CeoController {

	@Autowired
	@Qualifier("ceoService")
	private CeoService ceoService;
	/**
	 * 首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String sumTotalreportMoney(HttpServletRequest request , Model model){
		//如果没登录直接访问会返回一个错误页面
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		//盈利额的查询
		List<String> sumAllBigDecimal = ceoService.findSumTotalreportMoney();
		List<BigDecimal> sumBigDecimalByTim = ceoService.findSumTotalreportMoneyByTime();
		List<String> sumProductAllMoney = ceoService.findSumProductMoney();
		List<BigDecimal> sumProductMoneyByTime = ceoService.findSumProductMoneyByTime();		
		List<String> sumActivityBigdecimal = ceoService.findBigDecimalsfromActivity();
		List<Activity> findSumActivities = ceoService.findSumActivityByTime();
		List<CeoActivity> findSumActivityregisteryFeeByTime = ceoService.findSumActivitieregisteryFeeByTime();
		//用户数量查询
		List<String> alluser = ceoService.findAllUser();
		List<User> alluserByTime = ceoService.findAllUserByTime();
		//盈利和用户前十分店的查询
		List<CeoTotalreport> findTotalreportandBranch = ceoService.findTotalreportAndBranch();
		List<UserCustom> findUserCustoms = ceoService.findUserCustoms();
		//热销商品、新用户、新留言查询
		List<UserCustom> findFourUser = ceoService.findfourUserByTime();
		List<Product> findHotProduct = ceoService.findHotProducts();
		List<MessageCustom> findNewMessage = ceoService.findNewMessages();
		
		int allActivity = ceoService.findCountActivity();
		int findCountProduct = ceoService.findCountProduct();
		int allorders = ceoService.findCountOrder();
		int findCountMessage = ceoService.findCountMessage();		
		
		model.addAttribute("sumAllBigDecimal",sumAllBigDecimal);
		model.addAttribute("sumBigDecimalByTim",sumBigDecimalByTim);
		model.addAttribute("sumProductAllMoney",sumProductAllMoney);
		model.addAttribute("sumProductMoneyByTime",sumProductMoneyByTime);
		model.addAttribute("sumActivityBigdecimal",sumActivityBigdecimal);
		model.addAttribute("findSumActivities",findSumActivities);
		model.addAttribute("findSumActivityregisteryFeeByTime",findSumActivityregisteryFeeByTime);
		model.addAttribute("allActivity",allActivity);
		model.addAttribute("alluser",alluser);
		model.addAttribute("alluserByTime",alluserByTime);
		model.addAttribute("findTotalreportandBranch",findTotalreportandBranch);
		model.addAttribute("findUserCustoms",findUserCustoms);
		model.addAttribute("findFourUser",findFourUser);
		model.addAttribute("findHotProduct",findHotProduct);
		model.addAttribute("findCountProduct",findCountProduct);
		model.addAttribute("allorders",allorders);
		model.addAttribute("findCountMessage",findCountMessage);
		model.addAttribute("findNewMessage",findNewMessage);
		
		return "ceo/index";
	}
	@RequestMapping(value = "/readindex")
	public @ResponseBody CeoSelectVo findBigDecimal(@RequestBody CeoSelectVo ceoSelectVo,HttpServletRequest request){
		ceoSelectVo = ceoService.findBigDecimal();			
		return ceoSelectVo;
	}
	/**
	 * 所有用户
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/usertable")
	public String userandbranch(HttpServletRequest request ,Model model){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}		
		List<UserCustom> finduserandbranch = ceoService.findAllUserAndBranch();
		model.addAttribute("finduserandbranch",finduserandbranch);
		return "ceo/usertable";
	}
	/**
	 * 用户详细信息
	 * @param request
	 * @param model
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/user")
	public String findUser(HttpServletRequest request ,Model model,Integer userid){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		UserCustom findUserById = ceoService.findUserById(userid);
		model.addAttribute("findUserById",findUserById);
		
		return "ceo/user";
	}
	/**
	 * 全部商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/producttable")
	public String findproductCustom(HttpServletRequest request ,Model model){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		List<ProductCustom> findProductCustoms = ceoService.findProductCustoms();		
		model.addAttribute("findProductCustoms",findProductCustoms);
		return "ceo/producttable";
	}
	/**
	 * 商品详细信息
	 * @param request
	 * @param model
	 * @param productid
	 * @return
	 */
	@RequestMapping(value = "/product")
	public String findProduct(HttpServletRequest request ,Model model , Integer productid){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		Product findProductById = ceoService.findProductById(productid);
		model.addAttribute("findProductById",findProductById);		
		return "ceo/product";
	}
	/**
	 * 所有员工
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/table")
	public String findEmployee(HttpServletRequest request , Model model){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		Employee employee = new Employee();		
		List<Employee> findEmployees = ceoService.findEmployees(employee);
		List<CeoEmployee> findBranchEmployee = ceoService.findBranchEmployee();
		model.addAttribute("findEmployees",findEmployees);
		model.addAttribute("findBranchEmployee",findBranchEmployee);		
		return "ceo/table";
	}
	/**
	 * 员工详细信息
	 * @param request
	 * @param model
	 * @param employeeid
	 * @return
	 */
	@RequestMapping(value = "/employee")
	public String findEmployeeAllMessage(HttpServletRequest request , Model model ,Integer employeeid ){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		CeoEmployee findEmployeeAllMessage = ceoService.findEmployeeById(employeeid);
		model.addAttribute("findEmployeeAllMessage",findEmployeeAllMessage);		
		return "ceo/employee";
	}
	/**
	 * 所有活动
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/gallery")
	public String findAllActivity(HttpServletRequest request , Model model){	
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		List<CeoActivity> findAllActivitie = ceoService.findAllActivities();
		model.addAttribute("findAllActivitie",findAllActivitie);		
		return "ceo/gallery";
	}
	/**
	 * 活动的详细信息
	 * @param request
	 * @param model
	 * @param activityid
	 * @return
	 */
	@RequestMapping(value = "/activity")
	public String findCeoActivity(HttpServletRequest request ,Model model , Integer activityid){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		CeoActivity findCeoActivity = ceoService.findCeoActivity(activityid);
		model.addAttribute("findCeoActivity",findCeoActivity);		
		return "ceo/activity";
	}
	/**
	 * 所有留言
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/messages")
	public String findAllUserMessage(HttpServletRequest request , Model model,Integer id){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		List<MessageCustom> findMessageCustoms = ceoService.findAllUserMessageCustoms();
		MessageCustom findMessage = ceoService.findMessage(id);
		model.addAttribute("findMessageCustoms",findMessageCustoms);
		model.addAttribute("findMessage",findMessage);		
		return "ceo/messages";
	}
	/**
	 * 所有分店
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/branch")
	public String findBranchCustom(HttpServletRequest request,Model model){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}		
		List<BranchCustom> findBranchCustoms = ceoService.findBranchCustoms();
		model.addAttribute("findBranchCustoms",findBranchCustoms);
		
		return "ceo/branch";
	}
	/**
	 * 分店详情
	 * @param request
	 * @param model
	 * @param branchid
	 * @return
	 */
	@RequestMapping(value="/branchtask")
	public String totalIncome(HttpServletRequest request,Model model,Integer branchid){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		Branch findBranch = ceoService.findBrachById(branchid);
		List<ProductCustom> products = new ArrayList<ProductCustom>();
		products = ceoService.branchHotProduct(branchid);
		BigDecimal b = ceoService.totalEduIncome(branchid);
		if(b == null){
			b = new BigDecimal("0.00");
		}
		BigDecimal c = ceoService.totalHealIncome(branchid);
		if(c==null){
			c =new BigDecimal("0.00");
		}
		BigDecimal d = ceoService.totalOderIncome(branchid);
		if(d==null){
			d =new BigDecimal("0.00");
		}
		BigDecimal e = b.add(d).add(c);
		BigDecimal []arr = new BigDecimal[]{b,c,d,e};
		int o=ceoService.brachCountOrders(branchid);
		int m=ceoService.branchMessagesCount(branchid);
		int ac=ceoService.branchCountActivities(branchid);
		int p=ceoService.branchCountProducts(branchid);
		int u=ceoService.branchCountUsers(branchid);
		int []ar = new int[]{u,ac,o,p,m};
		model.addAttribute("products", products);
		model.addAttribute("ar", ar);
		model.addAttribute("arr", arr);
		model.addAttribute("findBranch",findBranch);
		
		//model.addAttribute("branch",branch);
		
		return "ceo/branchtask";
	}
		
	@RequestMapping(value = "/chart")
	public String dochart(HttpServletRequest request,Model model){
		if (request.getSession().getAttribute("ceos") == null) {
			return "ceo/error";
		}
		List<Branch> findBranchs = ceoService.findAllBranchName();
		
		CeoTotalreport ceoTotalreport = new CeoTotalreport();
		CeoTotalreport ceoTotalreport2 = new CeoTotalreport();
		ceoTotalreport.setBranchid(findBranchs.get(0).getBranchid());
		ceoTotalreport2 = ceoService.findBranchMoney(ceoTotalreport);
		model.addAttribute("findBranchs",findBranchs);
		model.addAttribute("branchtTotalreport",ceoTotalreport2);
		
		return "ceo/chart";
	}
	
	@RequestMapping(value = "/requestchart")
	public @ResponseBody List<CeoTotalreport> branch(Model model,@RequestBody CeoTotalreport totalreport,HttpServletRequest request){
		int a = (totalreport.getStartingTime()).compareTo(totalreport.getEndTime());
		if (a < 0 && totalreport.getBranchid() != null) {
			List<CeoTotalreport> resquesTotalreports = new ArrayList<CeoTotalreport>();
			resquesTotalreports = ceoService.findCeoTotalreports(totalreport);
			for(int i=0;i<resquesTotalreports.size();i++){
				CeoTotalreport ceoTotalreport = new CeoTotalreport();
				CeoTotalreport ceoTotalreport2 = new CeoTotalreport();
				ceoTotalreport.setBranchid(resquesTotalreports.get(i).getBranchid());
				ceoTotalreport2 = ceoService.findBranchMoney(ceoTotalreport);
				totalreport.setBranchname(ceoTotalreport2.getBranchname());
			}
			List<CeoTotalreport> pro = new ArrayList<CeoTotalreport>();
			totalreport.setPageNum(10);    											//每页显示的数据数量
			if(pro.size()>0 && (pro.size())%(totalreport.getPageNum())!=0){
				totalreport.setPagesum(((pro.size())/(totalreport.getPageNum()))+1);       //总页数
			}else if(pro.size()>0 && (pro.size())%(totalreport.getPageNum())==0){
				totalreport.setPagesum((pro.size())/(totalreport.getPageNum()));
			}else{
				totalreport.setPagesum(0);
			}
			
			totalreport.setBegin(0);													//起始数据
			pro = ceoService.findCeoTotalreports(totalreport);
			
			return pro;
		} else {
			return null;
		}
	}
	//ceo信息查询
		public String quertyCEO() {
			return"";
		}
		
		@RequestMapping(value = "/Test")
		public @ResponseBody List<CeoTotalreport> findTotalreportAndBranch(HttpServletRequest request){
			List<CeoTotalreport> ceoTotalreport = ceoService.findTotalreportAndBranch();			
			return ceoTotalreport;
		}
		
}
