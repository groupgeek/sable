package com.xiaohe.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.xiaohe.bean.EmployeeCustom;
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
	
	public Ceo getAdmin(HttpServletRequest request){
		return (Ceo) request.getSession().getAttribute("ceos");
	}
	/**
	 * 登录验证
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getCeoAdmin")
	public @ResponseBody Ceo getCeoAdmin(HttpServletRequest request){
		Ceo admin = new Ceo();
		admin = getAdmin(request);
		return admin;
	}
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{			
		//session过期
		session.invalidate();			
		return "redirect:/jsp/AdminLogin/login.jsp";
	}
	
	/**
	 * 首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String sumTotalreportMoney(HttpServletRequest request , Model model){		
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
	@RequestMapping(value = "/twoindexchart")
	public @ResponseBody List<CeoTotalreport> findTotalreportandBranch(){
		List<CeoTotalreport> findTotalreportandBranch = ceoService.findTotalreportAndBranch();
		return findTotalreportandBranch;
	}
	@RequestMapping(value = "/threeindexchart")
	public @ResponseBody List<UserCustom> findUserCustoms(){
		List<UserCustom> findUserCustoms = ceoService.findUserCustoms();
		return findUserCustoms;
	}
	/*-------------------------------------------------------------------------------------*/
	/**
	 * 所有用户
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/usertable")
	public String userandbranch(HttpServletRequest request ,Model model){
			
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
		
		UserCustom findUserById = ceoService.findUserById(userid);
		model.addAttribute("findUserById",findUserById);
		
		return "ceo/user";
	}
	@RequestMapping(value = "/oneuser")
	public @ResponseBody UserCustom oneuser(@RequestBody UserCustom userCustom){
		UserCustom oneuser = ceoService.findUserById(userCustom.getUserid());
		return oneuser;
	}
	/*-------------------------------------------------------------------------------------*/
	/**
	 * 全部商品
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/producttable")
	public String findproductCustom(HttpServletRequest request ,Model model){
		
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
		
		Product findProductById = ceoService.findProductById(productid);
		model.addAttribute("findProductById",findProductById);		
		return "ceo/product";
	}
	@RequestMapping(value = "/someproduct")
	public @ResponseBody Product oneproduct(@RequestBody Product product){
		Product oneproduct = ceoService.findProductById(product.getProductid());
		return oneproduct;
	}
	/*-------------------------------------------------------------------------------------*/
	
	/**
	 * 所有员工
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/table")
	public String findEmployee(HttpServletRequest request , Model model){
		
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
		
		CeoEmployee findEmployeeAllMessage = ceoService.findEmployeeById(employeeid);
		model.addAttribute("findEmployeeAllMessage",findEmployeeAllMessage);		
		return "ceo/employee";
	}
	@RequestMapping(value = "/oneemployee")
	public @ResponseBody CeoEmployee oneemployee(@RequestBody CeoEmployee ceoEmployee){
		CeoEmployee fEmployee = ceoService.findEmployeeById(ceoEmployee.getEmployeeid());
		return fEmployee;
	}
	/*-------------------------------------------------------------------------------------*/
	/**
	 * 所有活动
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/gallery")
	public String findAllActivity(HttpServletRequest request , Model model){	
		
		List<CeoActivity> findAllActivitie = ceoService.findAllActivities();
		model.addAttribute("findAllActivitie",findAllActivitie);		
		return "ceo/gallery";
	}
	
	/*-------------------------------------------------------------------------------------*/
	/**
	 * 活动的详细信息
	 * @param request
	 * @param model
	 * @param activityid
	 * @return
	 */
	@RequestMapping(value = "/activity")
	public String findCeoActivity(HttpServletRequest request ,Model model , Integer activityid){
		
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
		
		List<MessageCustom> findMessageCustoms = ceoService.findAllUserMessageCustoms();
		model.addAttribute("findMessageCustoms",findMessageCustoms);		
		return "ceo/messages";
	}
	@RequestMapping(value = "/newmessage")
	public @ResponseBody MessageCustom newmessage(@RequestBody MessageCustom messageCustom){
		messageCustom = ceoService.findMessage(messageCustom.getMessageid());
		return messageCustom;
	}
	@RequestMapping(value = "/readmessage")
	public @ResponseBody MessageCustom onemesage(@RequestBody MessageCustom messageCustom){
		messageCustom = ceoService.findMessage(messageCustom.getMessageid());
		return messageCustom;
	}
	/*-------------------------------------------------------------------------------------*/
	/**
	 * 所有分店
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/branch")
	public String findBranchCustom(HttpServletRequest request,Model model){
			
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
		
		Branch findBranch = ceoService.findBrachById(branchid);		
		List<String> arr = ceoService.arr(branchid);
		List<Integer> ar = ceoService.intlList(branchid);		
		model.addAttribute("ar", ar);
		model.addAttribute("arr", arr);
		model.addAttribute("findBranch",findBranch);		
		
		return "ceo/branchtask";
	}	
	@RequestMapping(value = "/branchchart")
	public @ResponseBody CeoBranchChartVo listchart(@RequestBody Integer id){
		CeoBranchChartVo ceoBranchChartVo = ceoService.listchart(id);
		return ceoBranchChartVo;
	}
	@RequestMapping(value = "/branchtwochart")
	public @ResponseBody List<ProductCustom> products(@RequestBody Integer id){
		List<ProductCustom> products = ceoService.branchHotProduct(id);
		return products;
	}
	@RequestMapping(value = "/branchthreechart")
	public @ResponseBody List<UserCustom> listuser(@RequestBody Integer id){
		List<UserCustom> usernumber = ceoService.listusernumber(id);
		return usernumber;
	}
	/*-------------------------------------------------------------------------------------*/
	/**
	 * 报表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/allchart")
	public String allchart(HttpServletRequest request, Model model){
		
		List<CeoActivityreport> ceoActivityreports = ceoService.allActivityreports();
		List<BranchCustom> branchCustoms = ceoService.findBranchCustoms();
		model.addAttribute("branchCustoms",branchCustoms);
		model.addAttribute("ceoActivityreports",ceoActivityreports);
		return "ceo/allchart";
	}
	@RequestMapping(value = "/allchartofproduct")
	public @ResponseBody CeoProducttransactionreportVo allproductchart(@RequestBody CeoProducttransactionreport condition){
		CeoProducttransactionreportVo ceoProducttransactionreportVo = ceoService.productallchart(condition);
		return ceoProducttransactionreportVo;
	}
	@RequestMapping(value = "/productchart")
	public @ResponseBody List<CeoProducttransactionreport> productchartofbranch(@RequestBody CeoProducttransactionreport ceoProducttransactionreport){
		List<CeoProducttransactionreport> productchart = ceoService.productchartofbranch(ceoProducttransactionreport.getBranchid());
		return productchart;
	}
	/**
	 * 商品报表
	 * @param ceoProducttransactionreport
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/oneproduct")
	public @ResponseBody List<CeoProducttransactionreport> oneProducttransactionreports(@RequestBody CeoProducttransactionreport ceoProducttransactionreport){
		System.out.println(ceoProducttransactionreport);
		List<CeoProducttransactionreport> list = ceoService.ceoProductList(ceoProducttransactionreport);
		return list;
	}
	@RequestMapping(value = "/threeproduct")
	public @ResponseBody List<CeoProducttransactionreport> threeProducttransactionreports(@RequestBody CeoProducttransactionreport ceoProducttransactionreport){
		List<CeoProducttransactionreport> list = ceoService.ceoProducttransactionreports(ceoProducttransactionreport);
		return list;
	}
	@RequestMapping(value = "/fourproduct")
	public @ResponseBody List<CeoProducttransactionreport> fourProducttransactionreports(@RequestBody CeoProducttransactionreport ceoProducttransactionreport){
		List<CeoProducttransactionreport> list = ceoService.cProducttransactionreports(ceoProducttransactionreport);
		return list;
	}
	@RequestMapping(value = "/chart")
	public String productchart(HttpServletRequest request,Model model,Integer id){
		Product productname = ceoService.findProductById(id);
		model.addAttribute("productname",productname);
		return "ceo/chart";
	}
	@RequestMapping(value = "/allproductcharts")
	public @ResponseBody List<CeoProducttransactionreport> productchart(){
		List<CeoProducttransactionreport> pCeoProducttransactionreports = ceoService.findceoproductchart();
		return pCeoProducttransactionreports;
	}
	@RequestMapping(value = "/productchartofyear")
	public @ResponseBody List<CeoProducttransactionreport> clist(){
		List<CeoProducttransactionreport> cList = ceoService.findproductchartofyear();
		System.out.println(cList.get(0).getSumgetprice());
		return cList;
	}
	@RequestMapping(value = "/allproductchartsOfbranch")
	public @ResponseBody List<CeoProducttransactionreport> productchartsofbranch(@RequestBody CeoProducttransactionreport ceoProducttransactionreport){
		List<CeoProducttransactionreport> productchartsofbranch = ceoService.findceoproductchatOfbranch(ceoProducttransactionreport.getBranchid());
		return productchartsofbranch;
	}
	/**
	 * 活动报表
	 * @param ceoActivityreport
	 * @return
	 */
	@RequestMapping(value = "/allactivitychart")
	public @ResponseBody List<CeoActivityreport> activitychart(){
		List<CeoActivityreport> ceoActivityreports = ceoService.ceoActivityreportschart();
		return ceoActivityreports;
	}
	@RequestMapping(value = "/actcharts")
	public @ResponseBody CeoActivityreportVo actchart(@RequestBody CeoActivityreport ceoActivityreport){
		CeoActivityreportVo actchart = ceoService.activitychart(ceoActivityreport);
		return actchart;
	}
	@RequestMapping(value = "/activitychart")
	public String activityString(Integer id,Model model){
		List<CeoActivityreport> oneList = ceoService.findActivityreportById(id);
		model.addAttribute("oneList",oneList);
		return "ceo/activitychart";
	}
	@RequestMapping(value = "/oneactivitychart")
	public @ResponseBody List<CeoActivityreport> oneactivityreport(@RequestBody CeoActivityreport ceoActivityreport){
		List<CeoActivityreport> oneactivityreport = ceoService.findActivityreportById(ceoActivityreport.getActivityid());
		return oneactivityreport;
	}
	@RequestMapping(value = "/twoactivitychart")
	public @ResponseBody CeoActivityreport twoactivityreport(@RequestBody CeoActivityreport ceoActivityreport){
		CeoActivityreport twoActivityreport = ceoService.findCeoActivityreportById(ceoActivityreport.getActivityid());
		return twoActivityreport;
	}
	@RequestMapping(value = "/allactivitychartsOfbranch")
	public @ResponseBody List<CeoActivityreport> activitychartsofbranch(@RequestBody CeoActivityreport ceoActivityreport){
		List<CeoActivityreport> findactivitychartsofbranch = ceoService.findceoactivitychartOfbranch(ceoActivityreport.getBranchid());
		return findactivitychartsofbranch;
	}
	@RequestMapping(value = "/activitychartByYear")
	public @ResponseBody List<CeoActivityreport> acList(){
		List<CeoActivityreport> caList = ceoService.ceoactivitychartByYear();
		return caList;
	}
	/*-------------------------------------------------------------------------------------*/
	//ceo信息查询
		public String quertyCEO() {
			return"";
		}
		

}
