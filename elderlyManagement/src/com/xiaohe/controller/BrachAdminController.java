package com.xiaohe.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Repeat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.Activityrecommend;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Level;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Returnvisit;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.BranchAdminService;
import com.xiaohe.util.FileUpload;


@Controller
@RequestMapping("/brach")
public class BrachAdminController {

	@Autowired
	private BranchAdminService branchService;
	
	@RequestMapping(value="/log")
	public String log(HttpServletRequest request){
		Employee employee = new Employee();
		EmployeeCustom n=  (EmployeeCustom) request.getSession().getAttribute("admins");
		employee = branchService.onEmployee(n.getEmployeeid());
		request.getSession().setAttribute("employee", employee);
		return "redirect:/brach/index.action";
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
		int x =((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		Employee admin = new Employee();
		admin = branchService.onEmployee(x);
		List<UserCustom> users = new ArrayList<UserCustom>();
		users = branchService.branchUser(admin.getEmployeeid());
		model.addAttribute("users", users);
		return "brach/table";
	}
	
	@RequestMapping(value="/delUser")
	public String delUser(Integer id){
		branchService.delUser(id);
		return "redirect:users";
	}
	
	@RequestMapping(value="/oneUser")
	public String oneUser(Integer id,Model model){
		UserCustom user = new UserCustom();
		MedicalrecordsWithBLOBsCustom med = new MedicalrecordsWithBLOBsCustom();
		Level level = new Level();
		user = branchService.oneUser(id);
		med = branchService.oneMedRed(id);
		level = branchService.oneLev(id);
		model.addAttribute("user", user);
		model.addAttribute("med", med);
		model.addAttribute("level", level);
		return "brach/UserDetail";
	}
	
	@RequestMapping(value="/updateUser")
	public String update(MedicalrecordsWithBLOBsCustom medicalrecordsWithBLOBsCustom,User user){
		user = branchService.oneUserMed(medicalrecordsWithBLOBsCustom.getMedicalrecordsid());
		branchService.updateMed(medicalrecordsWithBLOBsCustom);
		medicalrecordsWithBLOBsCustom.setUserid(user.getUserid());
		branchService.updateMed(medicalrecordsWithBLOBsCustom);
		return"redirect:users";
	}
	/*@RequestMapping(value="/AllMessages")
	public String QueryMessages(Model model,Integer id){
		Employee user = new Employee();
		user = branchService.onEmployee(2);
		model.addAttribute("user", user);
		return "brach/message";
	}*/
	
	/*@RequestMapping(value="/jsonMessage")
	public @ResponseBody MessageCustom jsonMessageCustom(@RequestBody MessageCustom messageCustom){
		System.out.println("****000000000000000000000000000000000000000000000");
		MessageCustom messageCustom2 = branchService.oneMessage(messageCustom.getMessageid());
		//return branchService.oneMessage(messageCustom.getMessageid());
		return messageCustom2;
	}*/
	
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
	
	/* 查询分店所有的活动 */
	@RequestMapping(value="/allActs")
	public String AllActivity(Model model,HttpServletRequest request){
		int a = ((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		/*acts是全部分店活动*/
		List<ActivityCustom> acts = new ArrayList<ActivityCustom>();
		acts = branchService.branchActs(a);
		/*全部的活动*/
		List<ActivityCustom> allActs = new ArrayList<ActivityCustom>();
		allActs = branchService.acts();
		/*分店的推荐活动*/
		List<ActivityrecommendCustom> allBranchActRec = new ArrayList<ActivityrecommendCustom>();
		allBranchActRec = branchService.branchActRec(a);
	/*	Activityrecommend act = new Activityrecommend();*/
		System.out.println(allBranchActRec);
		model.addAttribute("allBranchActRec", allBranchActRec);
		model.addAttribute("allActs", allActs);
		model.addAttribute("acts", acts);
		return "brach/activity";
	}
	
	@RequestMapping(value="/delActRec")
	public String del(ActivityrecommendCustom activityrecommendCustom,HttpServletRequest request){
		int a = ((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		Branch branch = new Branch();
		branch = branchService.oneBranchByEmployeeId(a);
		activityrecommendCustom.setBranchid(branch.getBranchid());
		System.out.println(activityrecommendCustom.getActivityid().toString()+activityrecommendCustom.getBranchid().toString());
		/*branchService.delActRec(activityrecommendCustom);*/
		return "";
		
	}
	
	
	/*//插入分店推荐活动
	@RequestMapping(value="/insertRecAct")
	public String insertRecAct(ActivityCustom activityCustom,Activityrecommend activityrecommend,ActivityrecommendCustom activityrecommendCustom,HttpServletRequest request){
		int a = ((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		Branch branch = new Branch();
		branch = branchService.oneBranchByEmployeeId(a);
		Activityrecommend acts = new Activityrecommend();
		acts.setBranchid(branch.getBranchid());
		acts.setActivityid(activityrecommendCustom.getActivityid());
		acts = branchService.oneActRecById(activityrecommend);
		if(acts==null){
			ActivityrecommendCustom acts = new ActivityrecommendCustom();
			acts.setActivityid(activityrecommendCustom.getActivityid());
			acts.setBranchid(branch.getBranchid());
			activityrecommend.setBranchid(branch.getBranchid());
			activityrecommend.setWebsitetype("分店官网1");
			System.out.println(activityrecommendCustom.getActivityid());
			activityrecommend.setActivityid(activityrecommend.getActivityid());
			branchService.insertActRec(activityrecommend);
			return "brach/test";
		}
		else{
			activityrecommendCustom.setBranchid(branch.getBranchid());
			activityrecommendCustom.setActivityid(activityrecommendCustom.getActivityid());
			branchService.delActRec(activityrecommendCustom);
			activityrecommend.setBranchid(branch.getBranchid());
			activityrecommend.setWebsitetype("分店官网1");
			activityrecommend.setActivityid(activityrecommend.getActivityid());
			branchService.insertActRec(activityrecommend);
			return "brach/test";
		}
		activityrecommend.setBranchid(branch.getBranchid());
		activityrecommend.setWebsitetype("分店官网1");
		Activityrecommend act = new Activityrecommend();
		act = branchService.oneActRecById(activityrecommend);
		if(!(act.getActivityid()==activityrecommend.getActivityid()&&act.getBranchid()==activityrecommend.getBranchid())){
			ActivityrecommendCustom acts = new ActivityrecommendCustom();
			acts.setActivityid(activityrecommendCustom.getActivityid());
			acts.setBranchid(branch.getBranchid());
			branchService.delActRec(activityrecommendCustom);
			branchService.insertActRec(activityrecommend);
		
	}*/
	
	
	
	@RequestMapping(value="/oneActCus")
	public String oneActCustom(Integer id,Model model){
		ActivityCustom act= new ActivityCustom();
		List<ActivitytypeCustom> actTypes = new ArrayList<ActivitytypeCustom>();
		actTypes = branchService.allActivityTypes();
		model.addAttribute("actTypes", actTypes);
		act = branchService.oneActCustom(id);
		model.addAttribute("act", act);
		return"brach/ActDetail";
	}
	
	@RequestMapping(value="/updateAct")
	public String updateAct(Activity activity,Integer id,HttpServletRequest request,MultipartFile file,MultipartFile nice){
		int a = ((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		Branch branch = new Branch();
		branch = branchService.oneBranch(a);
		activity.setBranchid(branch.getBranchid());
		activity.setActivityid(id);
		Activity act = new Activity();
		act = branchService.oneAct(id);
		String picturename = act.getActivitypicture();
		String videoname = act.getVideo();
		String path = "D:\\code\\web\\upload\\";
		String filename = null;
		String filevideo = null;
		if (!file.isEmpty()) {
			try {
				File pictureFile = new File(path+picturename);
				if(pictureFile.exists()){
					if(pictureFile.isFile()){
						pictureFile.delete();
					}
				}
				filename = FileUpload.oneFileUpload(file, "picture");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!nice.isEmpty()){
			try {
				File videoFile = new File(path+videoname);
				if(videoFile.exists()){
					if(videoFile.isFile()){
						videoFile.delete();
					}
				}
				filevideo = FileUpload.oneFileUpload(nice, "video");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(filename!=null){
			activity.setActivitypicture(filename);
			}
			if(filevideo!=null){
			activity.setActivitypicture(filevideo);	
			}
		
		branchService.updateAct(activity);
		return "redirect:allActs";
	}
	
	@RequestMapping(value="/delAct")
	public String delActivity(Integer id){
		branchService.delAct(id);
		return "redirect:allActs";
	}
	
	/*开始添加活动*/
	@RequestMapping(value="/allActTypes")
	public String AllActTypes(Model model){
		List<ActivitytypeCustom> actTypes = new ArrayList<ActivitytypeCustom>();
		actTypes = branchService.allActivityTypes();
		model.addAttribute("actTypes", actTypes);
		return "brach/insertAct";
	}
	
	@RequestMapping(value="/insertActs")
	public String insertActs(Activity activity,HttpServletRequest request,MultipartFile file,MultipartFile nice,Model model){
		Branch branch = new Branch();
		int a = ((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		branch = branchService.oneBranch(a);
		activity.setBranchid(branch.getBranchid());
		String filename = null;
		String fileVideo = null;
		if(!file.isEmpty()){
			try {
				filename = FileUpload.oneFileUpload(file, "picture");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!nice.isEmpty()) {
			try {
				fileVideo = FileUpload.oneFileUpload(nice, "video");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("url", filename);
		if(filename!=null){
		activity.setActivitypicture(filename);
		}
		if(fileVideo!=null){
		activity.setActivitypicture(fileVideo);	
		}
		branchService.inertActs(activity,file);
		return "redirect:allActs";
	}
	
	/**
	 * 测试json数据请求
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/demo.action")
	public @ResponseBody User requestJson(@RequestBody User user){
	UserCustom u = branchService.oneUser(user.getUserid());
	System.out.println(u);
		return branchService.oneUser(user.getUserid());
	}
	
	@RequestMapping(value="/RequestMessage")
	public @ResponseBody MessageCustom oneMessage(@RequestBody MessageCustom messageCustom){
		return branchService.oneMessage(messageCustom.getMessageid());
	}
	
	@RequestMapping(value="/RequestAct")
	public @ResponseBody ActivityrecommendCustom act(@RequestBody ActivityrecommendCustom activityrecommendCustom,HttpServletRequest request){
		int a = ((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		Branch branch = new Branch();
		branch = branchService.oneBranchByEmployeeId(a);
		int b = branchService.countRecAct(a);
		/*这个是插入的对象*/
		ActivityrecommendCustom acts = new ActivityrecommendCustom();
		ActivityrecommendCustom act2 = new ActivityrecommendCustom();
		ActivityrecommendCustom act3 = new ActivityrecommendCustom();
		ActivityrecommendCustom act4 = new ActivityrecommendCustom();
		ActivityrecommendCustom act5 = new ActivityrecommendCustom();
		act3.setActivityid(activityrecommendCustom.getActivityid());
		act3.setBranchid(branch.getBranchid());
		act3.setWebsitetype("测试");
		act4.setActivityid(activityrecommendCustom.getActivityidRec());
		act4.setBranchid(branch.getBranchid());
		act4.setWebsitetype("测试数据");
		act2 = branchService.oneActRecById(act3);//这个活动推荐是通过选中的
		act5 = branchService.oneActRecById(act4);//这个是后台原本传过去的活动
		if(act2 == null&& act5 == null){
			acts.setBranchid(branch.getBranchid());
			acts.setActivityid(activityrecommendCustom.getActivityid());
			acts.setWebsitetype("分店官网");
			branchService.insertActRec(acts);
		}else if(act2 == null && act5!=null){
			if(b>=3){
				branchService.delActRec(act5);
				branchService.insertActRec(act3);
			}else{
				branchService.insertActRec(act3);
			}
			
		}else if(act2 != null && act5!=null){
			if(branchService.oneActRecById(act2)!=null){
				branchService.delActRec(act2);
				branchService.insertActRec(act2);
			}else{
				if(b>=3){
					branchService.delActRec(act5);
					branchService.insertActRec(act2);
				}else{
					branchService.insertActRec(act2);
				}
			}
		}else if(act5==null&&act2!=null){
			if(branchService.oneActRecById(act2)!=null){
				branchService.delActRec(act2);
				branchService.insertActRec(act2);
			}else{
				branchService.insertActRec(act2);
			}
		}
		return act2;
		/*acts = branchService.oneActRecById(acts);*/
	}
	
	/*@RequestMapping(value="/del")
	public String del(){
		ActivityrecommendCustom act1= new ActivityrecommendCustom();
		ActivityrecommendCustom act2= new ActivityrecommendCustom();
		act1.setActivityid(5);
		act1.setBranchid(2);
		branchService.delActRec(act1);
		System.out.println("***************");
		act2.setActivityid(7);
		act2.setBranchid(2);
		act2.setWebsitetype("测试数据1");
		branchService.insertActRec(act2);
		System.out.println("+++++++++++++++++++");
		return "brach/test";
	}*/
	
	@RequestMapping(value="/products")
	public String products(Model model,HttpServletRequest request){
		int a = ((Employee)request.getSession().getAttribute("employee")).getEmployeeid();
		Branch branch = new Branch();
		branch = branchService.oneBranch(a);
		List<ProductCustom> products = new ArrayList<ProductCustom>();
		products = branchService.quertyAllProduct(branch.getBranchid());
		model.addAttribute("products", products);
		return "brach/products";
	}
	
	
	
	
	//------------------------报表开始
	
	@RequestMapping(value="/charts")
	public String charts(){
		
		
		
		return "";
	}
}
