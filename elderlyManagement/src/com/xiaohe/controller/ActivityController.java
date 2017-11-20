package com.xiaohe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.User;
import com.xiaohe.service.ActivityService;
import com.xiaohe.service.BranchAdminService;

@Controller
@RequestMapping("edu")
public class ActivityController {
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
	@RequestMapping(value="queryActivityByUserId")
	public String queryActivityByUserId(Model model,HttpServletRequest request){
		int id =((User)request.getSession().getAttribute("user")).getUserid();
		List<Activity> activitys=activityService.queryActivityByUserId(id);
		//model回显到页面
		
		System.out.println(activitys);
		model.addAttribute("activitys", activitys);
		return "edu/vip";
	}
	@RequestMapping(value="getpicture")
	public String  getpicture(Model model,HttpServletRequest request){
		
		List<Activity> onlines=activityService.getonline();
		List<Activity> lectures=activityService.getlecture();
		List<Activity> activitys=activityService.getactivity();
		List<Activity> Lives=activityService.getLive();
		
		//model回显到页面
		
		model.addAttribute("onlines", onlines);
		model.addAttribute("lectures", lectures);
		model.addAttribute("activitys", activitys);
		model.addAttribute("Lives", Lives);
	
		return "edu/edu";
	}
		
		
		@RequestMapping(value="getonline")
		public String  getonline(Model model,HttpServletRequest request){
			
			List<Activity> activitys=activityService.getonline();
			//model回显到页面
			
			System.out.println(activitys);
			model.addAttribute("activitys", activitys);
			return "edu/kecheng";
	}
		
		@RequestMapping(value="getlecture")
		public String  getlecture(Model model,HttpServletRequest request){
			
			List<Activity> activitys=activityService.getlecture();
			//model回显到页面
			
			System.out.println(activitys);
			model.addAttribute("activitys", activitys);
			return "edu/jiangzuo";
	}
		
		@RequestMapping(value="getactivity")
		public String  getactivity(Model model,HttpServletRequest request){
			
			List<Activity> activitys=activityService.getactivity();
			//model回显到页面
			
			System.out.println(activitys);
			model.addAttribute("activitys", activitys);
			return "edu/huodong";
		}
			
			@RequestMapping(value="getLive")
			public String  getLive(Model model,HttpServletRequest request){
				
				List<Activity> activitys=activityService.getLive();
				//model回显到页面
				
				System.out.println(activitys);
				model.addAttribute("activitys", activitys);
				return "edu/zhibo";
	     }
	
		@RequestMapping(value="getactivityid")
		public String  getactivityid(Model model,int id,HttpServletRequest request){
			
			Activity activity=activityService.getactivityid(id );
			//model回显到页面
			
			System.out.println(activity);
			model.addAttribute("activity", activity);
			return "edu/buyinfo";
		}
		
		@RequestMapping(value="InsertactivityId")
		public String  InsertactivityId(Model model,int activityid,HttpServletRequest request){
			int userid =((User)request.getSession().getAttribute("user")).getUserid();
			activityService.insertactivityid(activityid,userid);
			//model回显到页面
			
			return "edu/succ";
		}
		
		@RequestMapping(value="delectactivityid")
		public String  delectactivityid(Model model,int activityid,HttpServletRequest request){
			int userid =((User)request.getSession().getAttribute("user")).getUserid();
			activityService.delectactivityid(activityid,userid);
			//model回显到页面
			return "forward:/edu/queryActivityByUserId.action";
		}
		
		@RequestMapping(value="getvideo")
		public String  getvideo(Model model,int id,HttpServletRequest request){
			
			Activity activity=activityService.getactivityid(id );
			//model回显到页面
			
			System.out.println(activity);
			model.addAttribute("activity", activity);
			return "edu/video";
		}
}
