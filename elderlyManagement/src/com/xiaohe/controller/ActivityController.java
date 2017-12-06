package com.xiaohe.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omg.PortableInterceptor.TRANSPORT_RETRY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityVo;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.Activityregistery;
import com.xiaohe.bean.Activityreport;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.bean.Integral;
import com.xiaohe.bean.IntegralCustom;
import com.xiaohe.bean.LecturerCustom;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.ActivityService;
import com.xiaohe.service.BranchAdminService;
import com.xiaohe.service.IntegralService;
import com.xiaohe.service.TransactionService;
import com.xiaohe.util.GetStringByDate;

@Controller
@RequestMapping("edu")
public class ActivityController {
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
	@Autowired
	private BranchAdminService branchAdminService;
	
	@Autowired
	private IntegralService integralService;
	
	@Autowired
	private TransactionService transactionService;
	
	
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
	
	
	/**
	 * 查询教育模块下用户报名的活动
	 * @return
	 */
	@RequestMapping("/queryAllEduActivityReg")
	public @ResponseBody List<ActivityCustom> queryAllEduActivityReg(HttpServletRequest request){
		User user = getUser(request);
		
		List<ActivityCustom> list = new ArrayList<ActivityCustom>();
		
		list = activityService.queryActivityByUsserId(user.getUserid());
		
		return list;
	}
	
	
	
	
	
	
	@RequestMapping(value="/actInfo")
	public String actInfo(Integer id,Model model,HttpServletRequest request){
		User user = getUser(request);
		List<ActivityrecommendCustom> allActRec = new ArrayList<ActivityrecommendCustom>();
		ActivityCustom act = new ActivityCustom();
		act = activityService.oneAct(id);
		act.setUserid(user.getUserid());
		allActRec = branchAdminService.branchActRec(act.getBranchid());
		int a = activityService.countPeople(act.getActivityid());
		
		Activityregistery activityregistery = new Activityregistery();
		activityregistery.setActivityid(id);
		activityregistery.setUserid(user.getUserid());
		activityregistery = activityService.oneUserAct(activityregistery);
		
		model.addAttribute("activityregistery", activityregistery);
		model.addAttribute("allActRec", allActRec);
		model.addAttribute("act", act);
		model.addAttribute("a", a);
		return "edu/actInfo";
	}
	
	@RequestMapping(value="/regAct")   //活动报名
	public @ResponseBody Activityregistery insertAct(@RequestBody ActivityrecommendCustom activityrecommendCustom,HttpServletRequest request){
		User user = getUser(request);
		UserCustom oneUserCustom = new UserCustom();
		oneUserCustom = branchAdminService.oneUser(user.getUserid());
		Activityreport activityreport = new Activityreport();
		activityreport = activityService.oneActivityreport(activityrecommendCustom.getActivityid());
		TransactionCustom transactionCustom = new TransactionCustom();
		transactionCustom = transactionService.oneTransaction(user.getUserid());
		/*GetStringByDate caltimeByDate = new GetStringByDate();
		int days = caltimeByDate.calculateDate(user.getRegistrationdate(), new Date());
		int month = days/30;
		if(month%1!=0){
			month = month+1;
		}*/
		
		
		Activityregistery activityregistery = new Activityregistery();
		Activityregistery actreg = new Activityregistery();
		activityregistery.setUserid(user.getUserid());
		activityregistery.setActivityid(activityrecommendCustom.getActivityid());
		activityregistery.setRegistery("报名");
		actreg = activityService.oneActreg(activityregistery);
		Integral integral = new Integral();
		Integral integral2 = new Integral();
		IntegralCustom condetion = new IntegralCustom();
		condetion.setCurrentPage(1);
		condetion.setPageNum(1);
		condetion.setUserid(user.getUserid());
		integral = integralService.queryUpToDateRecord(condetion);
		
		/*if(activityreport == null){
			return null;
		}*/
		  
		if(actreg==null){
			//更新活动报表
			if(activityreport.getTotalprice()!=null){
			activityreport.setTotalprice(activityreport.getTotalprice().add(activityrecommendCustom.getRegisteryfee()));
			}else{
				activityreport.setTotalprice(new BigDecimal(0).add(activityrecommendCustom.getRegisteryfee()));
			}
			activityreport.setCountactivity(activityreport.getCountactivity()+1);
			activityService.updateActrep(activityreport);
			//赠送积分
			Integer a = (Integer.parseInt(activityrecommendCustom.getRegisteryfee().divide(new BigDecimal(10)).toBigInteger().toString()));
			integral2.setChangeintegral(a);
			Integer b = integral.getRemainingpoints(); 
			integral2.setRemainingpoints(a+b);
			integral2.setChangetime(new Date());
			integral2.setDetails("报名："+activityrecommendCustom.getActivityname()+"获得");
			integral2.setUserid(user.getUserid());
			integralService.insertIntel(integral2);
			//更新客户信息表
			transactionCustom.setCountbuy(transactionCustom.getCountbuy()+1);
			transactionCustom.setTotalprice(transactionCustom.getTotalprice().add(activityrecommendCustom.getRegisteryfee()));
			Long date = (new Date()).getTime() - user.getRegistrationdate().getTime();
			Long monthTemp = date / (1000);
			Integer month = (int) (monthTemp / (3600 * 24 * 30));
			
			if(date % (1000 * 3600 * 24 * 30) != 0){
				month += 1;
			}
			Float temp;
			if(month > 0){
				temp = ((transactionCustom.getCountbuy() + 1) / (float)month);
				transactionCustom.setFrequency(temp);
				transactionCustom.setCycle((float)1 / temp);
			}
			
			transactionService.updateRecordInfoById(transactionCustom);
			//插入报名信息
			activityService.insertActRec(activityregistery);
			return activityregistery;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据用户所在区域查询出该地区的讲师
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryAllByBranch")
	public @ResponseBody List<LecturerCustom> queryAllByBranch(HttpServletRequest request){
		User user = getUser(request);
		List<LecturerCustom> all = new ArrayList<LecturerCustom>();
		all = activityService.queryAllLecturerByUser(user.getUserid());
		return all;
	}
}
