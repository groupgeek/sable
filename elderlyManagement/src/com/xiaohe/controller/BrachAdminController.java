package com.xiaohe.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Repeat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.Employee;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Returnvisit;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.BranchAdminService;


@Controller
@RequestMapping("/brach")
public class BrachAdminController {

	@Autowired
	private BranchAdminService branchService;
	
	@RequestMapping(value="/log")
	public String log(HttpServletRequest request){
		Employee employee = new Employee();
		employee = branchService.onEmployee(2);
		request.getSession().setAttribute("employee", employee);
		return "brach/test";
	}
	
	/*@RequestMapping(value="/AllUsers")
	public String QueryUsers(Model model,Employee employee2){
		List<UserCustom> users = new ArrayList<UserCustom>();
		int a = employee.getEmployeeid();
		employee2 = branchService.onEmployee(2);
		users = branchService.branchUser(employee2.getAreaid());
		model.addAttribute("users", users);
		return "brach/table";
	}*/
	
	@RequestMapping(value="/users")
	public String Users(Model model,HttpServletRequest request){
		int a =((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		Employee admin = new Employee();
		admin = branchService.onEmployee(a);
		List<UserCustom> users = new ArrayList<UserCustom>();
		users = branchService.branchUser(admin.getEmployeeid());
		model.addAttribute("users", users);
		return "brach/table";
	}
	
	@RequestMapping(value="/delUser")
	public String delUser(Integer id){
		branchService.delUser(id);
		return "redirect:AllUsers";
	}
	
	@RequestMapping(value="/oneUser")
	public String oneUser(Model model,Integer id){
		return "brach/table";
	}
	
	/*@RequestMapping(value="/AllMessages")
	public String QueryMessages(Model model,Integer id){
		Employee user = new Employee();
		user = branchService.onEmployee(2);
		model.addAttribute("user", user);
		return "brach/message";
	}*/
	
	@RequestMapping(value="/jsonMessage")
	public @ResponseBody MessageCustom jsonMessageCustom(@RequestBody MessageCustom messageCustom){
		System.out.println("****000000000000000000000000000000000000000000000");
		MessageCustom messageCustom2 = branchService.oneMessage(messageCustom.getMessageid());
		//return branchService.oneMessage(messageCustom.getMessageid());
		return messageCustom2;
	}
	
	@RequestMapping(value="/fenyeMessage")
	public String oneMessage(Model model,MessageVo messageVo,HttpServletRequest request){
		int x =((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		int a = branchService.branchMessagesCount(x);
		if(messageVo.getNowPage()==null || messageVo.getNowPage()==0){
			messageVo.setNowPage(1);
		}
		List<MessageCustom> messages = new ArrayList<MessageCustom>();
		messageVo.setSize(13);
		messageVo.setStart((messageVo.getNowPage()-1)*messageVo.getSize());
		messageVo.setEmployeeid(x);
		messages = branchService.branchMessages(messageVo);
		int count = (a/messageVo.getSize());
		if (count%(messageVo.getSize())!=0){
			count+=1;
		}
		messageVo.setCount(count);
		model.addAttribute("messages", messages);
		model.addAttribute("messageVo", messageVo);
		return "brach/message";
	}
	
	@RequestMapping(value="/index")
	public String totalIncome(HttpServletRequest request,Model model){
		int a =((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		List<ProductCustom> products = new ArrayList<ProductCustom>();
		products = branchService.branchHotProduct(a);
		BigDecimal b = branchService.totalEduIncome(a);
		if(b == null){
			b = new BigDecimal("0.00");
		}
		BigDecimal c = branchService.totalHealIncome(a);
		if(c==null){
			c =new BigDecimal("0.00");
		}
		BigDecimal d = branchService.totalOderIncome(a);
		if(d==null){
			d =new BigDecimal("0.00");
		}
		BigDecimal e = b.add(d).add(c);
		BigDecimal []arr = new BigDecimal[]{b,c,d,e};
		int o=branchService.brachCountOrders(a);
		int m=branchService.branchMessagesCount(a);
		int ac=branchService.branchCountActivities(a);
		int p=branchService.branchCountProducts(a);
		int u=branchService.branchCountUsers(a);
		int []ar = new int[]{u,ac,o,p,m};
		model.addAttribute("products", products);
		model.addAttribute("ar", ar);
		model.addAttribute("arr", arr);
		return "brach/index";
	}
	
	@RequestMapping(value="/branchTran")
	public String BranchTransaction(HttpServletRequest request,Model model){
		int a =((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		List<TransactionCustom> trans = new ArrayList<TransactionCustom>();
		trans = branchService.branchAllTran(a);
		model.addAttribute("trans", trans);
		  return "brach/form";
	  } 
	
	@RequestMapping(value="/branchVist") 
	public String returnVist(Model model,HttpServletRequest request){
		int a =((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		List<Returnvisit> visits = new ArrayList<Returnvisit>();
		visits = branchService.branchReturnVist(a);
		model.addAttribute("visits", visits);
		return "brach/tasks";
	}
}
