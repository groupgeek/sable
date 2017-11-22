package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityVo;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.bean.User;
import com.xiaohe.service.ActivityService;

@Controller
@RequestMapping("edu")
public class ActivityController {
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
	
	public User getUser(HttpServletRequest request){
		return (User) request.getSession().getAttribute("user");
	}
	
	/**
	 * 查询教育类型的活动
	 * @return
	 */
	@RequestMapping("/allEduType")
	public @ResponseBody List<ActivitytypeCustom> allEduType(){
		List<ActivitytypeCustom> allType = new ArrayList<ActivitytypeCustom>();
		allType = activityService.queryAllEduType();
		return allType;
	}
	
	/**
	 * 查询某分店的教育类型下小类型的活动(主页)
	 * @return
	 */
	@RequestMapping("/queryAllEduRecord")
	public @ResponseBody Map<String, List<ActivityCustom>> queryAllEduRecord(HttpServletRequest request){
		User user = getUser(request);
		
		Map<String, List<ActivityCustom>> all = new HashMap<String, List<ActivityCustom>>();
		
		all = activityService.queryEduRecordByUserid(user.getUserid());
		
		return all;
	}
	
	/**
	 * 查询某分店的教育类型下小类型的活动
	 * @return
	 */
	@RequestMapping("/queryAllEduActivity")
	public @ResponseBody ActivityVo queryAllEduActivity(@RequestBody ActivityCustom condition , HttpServletRequest request){
		ActivityVo vo = new ActivityVo();
		User user = getUser(request);
		condition.setUserid(user.getUserid());
		condition.setSort("activityDate");
		
		vo = activityService.queryEduAllTypeActByCondition(condition);
		
		return vo;
	}
	
	@RequestMapping(value="/actInfo")
	public String actInfo(Integer id,Model model){
		id = 1;
		ActivityCustom act = new ActivityCustom();
		act = activityService.oneAct(id);
		int a = activityService.countPeople(id);
		model.addAttribute("act", act);
		model.addAttribute("a", a);
		return "edu/actInfo";
	}
	
	@RequestMapping(value="/regAct")   //活动报名
	public String insertAct(){
		return "";
	}
}
