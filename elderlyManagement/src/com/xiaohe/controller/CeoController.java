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
	
	@RequestMapping(value="/index")
	public String sumTotalreportMoney(HttpServletRequest request , Model model){
		BigDecimal sumAllBigDecimal = ceoService.findSumTotalreportMoney();
		List<BigDecimal> sumBigDecimalByTim = ceoService.findSumTotalreportMoneyByTime();
		BigDecimal sumProductAllMoney = ceoService.findSumProductMoney();
		List<BigDecimal> sumProductMoneyByTime = ceoService.findSumProductMoneyByTime();		
		BigDecimal sumActivityPrice = ceoService.findSumActivityPrice();
		BigDecimal sumActivityregistery = ceoService.findSumregisteryFee();
		List<Activity> findSumActivities = ceoService.findSumActivityByTime();
		List<CeoActivity> findSumActivityregisteryFeeByTime = ceoService.findSumActivitieregisteryFeeByTime();
		int allActivity = ceoService.findCountActivity();
		int alluser = ceoService.findAllUser();
		List<User> alluserByTime = ceoService.findAllUserByTime();
		List<CeoTotalreport> findTotalreportandBranch = ceoService.findTotalreportAndBranch();
		List<UserCustom> findUserCustoms = ceoService.findUserCustoms();
		List<User> findFourUser = ceoService.findfourUserByTime();
		List<Product> findHotProduct = ceoService.findHotProducts();
		int findCountProduct = ceoService.findCountProduct();
		int allorders = ceoService.findCountOrder();
		int findCountMessage = ceoService.findCountMessage();
		List<MessageCustom> findNewMessage = ceoService.findNewMessages();
		
		model.addAttribute("sumAllBigDecimal",sumAllBigDecimal);
		model.addAttribute("sumBigDecimalByTim",sumBigDecimalByTim);
		model.addAttribute("sumProductAllMoney",sumProductAllMoney);
		model.addAttribute("sumProductMoneyByTime",sumProductMoneyByTime);
		model.addAttribute("sumActivityPrice",sumActivityPrice);
		model.addAttribute("sumActivityregistery",sumActivityregistery);
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
	@RequestMapping(value = "/user")
	public String findUser(Model model,Integer userid){
		UserCustom findUserById = ceoService.findUserById(userid);
		
		model.addAttribute("findUserById",findUserById);
		
		return "ceo/user";
	}
	@RequestMapping(value = "/product")
	public String findProduct(Model model , Integer productid){
		Product findProductById = ceoService.findProductById(productid);
		
		model.addAttribute("findProductById",findProductById);
		
		return "ceo/product";
	}
	
	@RequestMapping(value="/table")
	public String findEmployee(HttpServletRequest request , Model model){
		Employee employee = new Employee();
		
		List<Employee> findEmployees = ceoService.findEmployees(employee);
		List<CeoEmployee> findBranchEmployee = ceoService.findBranchEmployee();
		
		model.addAttribute("findEmployees",findEmployees);
		model.addAttribute("findBranchEmployee",findBranchEmployee);
		
		return "ceo/table";
	}
	@RequestMapping(value = "/employee")
	public String findEmployeeAllMessage(HttpServletRequest request , Model model ,Integer employeeid ){
		CeoEmployee findEmployeeAllMessage = ceoService.findEmployeeById(employeeid);
		
		model.addAttribute("findEmployeeAllMessage",findEmployeeAllMessage);
		
		return "ceo/employee";
	}
	
	@RequestMapping(value="/gallery")
	public String findAllActivity(HttpServletRequest request , Model model){	
		List<CeoActivity> findAllActivitie = ceoService.findAllActivities();
		
		model.addAttribute("findAllActivitie",findAllActivitie);
		
		return "ceo/gallery";
	}
	
	@RequestMapping(value = "/activity")
	public String findCeoActivity(Model model , Integer activityid){
		CeoActivity findCeoActivity = ceoService.findCeoActivity(activityid);
		
		model.addAttribute("findCeoActivity",findCeoActivity);
		
		return "ceo/activity";
	}
	
	@RequestMapping(value = "/messages")
	public String findAllUserMessage(HttpServletRequest request , Model model,Integer id){
		List<MessageCustom> findMessageCustoms = ceoService.findAllUserMessageCustoms();
		MessageCustom findMessage = ceoService.findMessage(id);
		
		model.addAttribute("findMessageCustoms",findMessageCustoms);
		model.addAttribute("findMessage",findMessage);
		
		return "ceo/messages";
	}
	
	@RequestMapping(value="/submenu1")
	public String totalIncome(HttpServletRequest request,Model model,Integer employeeid){
		//int a =((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		
		//Branch branch = ceoService.findBrachById(branchid);
		
		List<ProductCustom> products = new ArrayList<ProductCustom>();
		products = ceoService.branchHotProduct(employeeid);
		BigDecimal b = ceoService.totalEduIncome(employeeid);
		if(b == null){
			b = new BigDecimal("0.00");
		}
		BigDecimal c = ceoService.totalHealIncome(employeeid);
		if(c==null){
			c =new BigDecimal("0.00");
		}
		BigDecimal d = ceoService.totalOderIncome(employeeid);
		if(d==null){
			d =new BigDecimal("0.00");
		}
		BigDecimal e = b.add(d).add(c);
		BigDecimal []arr = new BigDecimal[]{b,c,d,e};
		int o=ceoService.brachCountOrders(employeeid);
		int m=ceoService.branchMessagesCount(employeeid);
		int ac=ceoService.branchCountActivities(employeeid);
		int p=ceoService.branchCountProducts(employeeid);
		int u=ceoService.branchCountUsers(employeeid);
		int []ar = new int[]{u,ac,o,p,m};
		model.addAttribute("products", products);
		model.addAttribute("ar", ar);
		model.addAttribute("arr", arr);
		
		//model.addAttribute("branch",branch);
		
		return "ceo/submenu1";
	}
	
	@RequestMapping(value = "/branch")
	public String findBranchCustom(Model model){
		BranchCustom branchCustom = new BranchCustom();	
		
		List<BranchCustom> findBranchCustoms = ceoService.findBranchCustoms(branchCustom);
		
		model.addAttribute("findBranchCustoms",findBranchCustoms);
		
		return "ceo/branch";
	}
	
	@RequestMapping(value = "/chart")
	public String dochart(HttpServletRequest request,Model model){
		List<Branch> findBranchs = ceoService.findAllBranchName();
		
		CeoTotalreport ceoTotalreport = new CeoTotalreport();
		CeoTotalreport ceoTotalreport2 = new CeoTotalreport();
		ceoTotalreport.setBranchid(findBranchs.get(0).getBranchid());
		ceoTotalreport2 = ceoService.findBranchMoney(ceoTotalreport);
		
		model.addAttribute("findBranchs",findBranchs);
		model.addAttribute("branchtTotalreport",ceoTotalreport2);
		
		return "ceo/chart";
	}
	
	@RequestMapping(value = "requestchart")
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
}
