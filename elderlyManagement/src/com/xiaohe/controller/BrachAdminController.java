package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.BranchAdminService;


@Controller
@RequestMapping("/brach")
public class BrachAdminController {

	@Autowired
	private BranchAdminService branchService;
	
	@RequestMapping(value="/AllUsers")
	public String QueryUsers(Model model,Employee employee,HttpServletRequest request){
		List<UserCustom> users = new ArrayList<UserCustom>();
		employee = branchService.onEmployee(2);
		request.getSession().setAttribute("employee", employee);
		users = branchService.branchUser(employee.getAreaid());
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
		branchService.oneUser(id);
		return "String";
	}
	
	@RequestMapping(value="/AllMessages")
	public String QueryMessages(Model model,Integer id){
		Employee user = new Employee();
		user = branchService.onEmployee(2);
		model.addAttribute("user", user);
		return "brach/message";
	}
	
	@RequestMapping(value="/jsonMessage")
	public @ResponseBody MessageCustom jsonMessageCustom(@RequestBody MessageCustom messageCustom){
		System.out.println("****000000000000000000000000000000000000000000000");
		//return branchService.oneMessage(messageCustom.getMessageid());
		return messageCustom;
	}
	
	@RequestMapping(value="/fenyeMessage")
	public String oneMessage(Model model,MessageVo messageVo){
		int a = branchService.somecount();
		if(messageVo.getNowPage()==null || messageVo.getNowPage()==0){
			messageVo.setNowPage(1);
		}
		List<MessageCustom> messages = new ArrayList<MessageCustom>();
		messageVo.setSize(13);
		messageVo.setStart((messageVo.getNowPage()-1)*messageVo.getSize());
		messages = branchService.allMessages(messageVo);
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
	public String totalIncome(){
		
		return "";
	}
	
}
