package com.xiaohe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.Activityregistery;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.ActivityregisteryMapper;
import com.xiaohe.service.ActivityService;
import com.xiaohe.service.MedicalrecordsService;
import com.xiaohe.service.ProductManageService;
import com.xiaohe.service.ProductRecommendService;

@Controller
@RequestMapping("health")
public class HealthManageController {
	
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
	@Autowired
	@Qualifier("medicalrecordsService")
	private MedicalrecordsService medicalrecordsService;
	
	@Autowired
	@Qualifier("productManageService")
	private ProductManageService productManageService;
	
	@Autowired
	@Qualifier("productRecommendService")
	private ProductRecommendService productRecommendService;
	

	
	//用户进人健康管理手页信息
	@RequestMapping("activity")
	public String activityType(Model model,HttpServletRequest request) {
		UserCustom userCustom=new UserCustom();
		userCustom= (UserCustom) request.getSession().getAttribute("user");
	
	
	 List<ActivityCustom> activity=activityService.quertyActivityArea(userCustom.getPhone());
	
	 MedicalrecordsWithBLOBsCustom mm=medicalrecordsService.quertyMedicalRecords(userCustom.getUserid());
	 UserCustom userRecommend = productRecommendService.quertyCustoms(userCustom.getPhone());
	 List<ProductCustom>  recommendproduct =productManageService.quertyRecommendProduct(userRecommend.getBranchid());
	model.addAttribute("recommendproduct", recommendproduct);
	model.addAttribute("activity", activity);
	model.addAttribute("mm", mm);
	return "health/index";
	}
	//根据活动ID查询活动详情
	
	@RequestMapping("activityInfo")
	public String activityInfo(Integer activityid,Model model,HttpServletRequest request){
		Activity ac  = activityService.quertyUserActivity(activityid);
		request.getSession().setAttribute("ac", ac);
		model.addAttribute("ac",ac);
		return "health/blog"; 
	}
	@RequestMapping("insertacrivityreg")
	public String insertyActivityReg(Activityregistery activityregistery,HttpServletRequest request,Integer activityid,Model model){
		
		UserCustom userCustom= (UserCustom) request.getSession().getAttribute("user");
		
		Activity Acty=(Activity) request.getSession().getAttribute("ac");
		activityregistery.setUserid(userCustom.getUserid());
		activityregistery.setActivityid(Acty.getActivityid());
		activityregistery.setRegistery("报名");
		if (activityService.quertyIfUsetRegistery(activityregistery)==true) {
			activityService.insertUserRegistery(activityregistery);
		
			return "health/blog01";
			
		}
		model.addAttribute("Massage", "你已报名");
		return "health/blog";
	}
}
