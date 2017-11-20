package com.xiaohe.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.events.EndDocument;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.omg.CORBA.PRIVATE_MEMBER;
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
import com.xiaohe.bean.Activitytype;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.bean.Area;
import com.xiaohe.bean.Authority;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Level;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.OrdersCustom;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.Returnvisit;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.productTranctionReportVo;
import com.xiaohe.mapper.ActivityMapper;
import com.xiaohe.service.ActivityService;
import com.xiaohe.service.ActivitytypeService;
import com.xiaohe.service.BranchAdminService;
import com.xiaohe.service.EmployeeService;
import com.xiaohe.service.UserService;
import com.xiaohe.util.FileUpload;
import com.xiaohe.util.GetStringByDate;


@Controller
@RequestMapping("/brach")
public class BrachAdminController {

	@Autowired
	private BranchAdminService branchService;
	
	@RequestMapping(value="/log")    //模拟登陆
	public String log(HttpServletRequest request){
		Employee employee = new Employee();
		employee = branchService.onEmployee(1);
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
		int x =((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		Employee admin = new Employee();
		admin = branchService.onEmployee(x);
		List<UserCustom> users = new ArrayList<UserCustom>();
		users = branchService.branchUser(admin.getEmployeeid());
		model.addAttribute("users", users);
		return "brach/table";
	}
	
	@RequestMapping(value="/delUser")
	public String delUser(Integer id){
		/*String path = "D:\\code\\web\\upload\\";
		UserCustom userCustom = new UserCustom();
		userCustom = branchService.oneUser(id);
		MedicalrecordsWithBLOBsCustom med = new MedicalrecordsWithBLOBsCustom();
		med = branchService.oneMedRed(id);
		if(userCustom.getAvatar()!=null){
			File picture = new File(path+userCustom.getAvatar());
			if(picture.exists()){
				if(picture.isFile()){
					picture.delete();
				}
			}
		}
		if(med!=null){
			
			branchService.delMed(med.getMedicalrecordsid());
		}*/
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
	
	
	//更新用户信息
	@RequestMapping(value="/updateUser")
	public String update(MedicalrecordsWithBLOBsCustom medicalrecordsWithBLOBsCustom,User user){
		MedicalrecordsWithBLOBsCustom med = new MedicalrecordsWithBLOBsCustom();
		med = branchService.oneMedRed(user.getUserid());
		if(med==null){
			medicalrecordsWithBLOBsCustom.setUserid(user.getUserid());
			branchService.insertMed(medicalrecordsWithBLOBsCustom);
		}else{
			medicalrecordsWithBLOBsCustom.setMedicalrecordsid(med.getMedicalrecordsid());
			branchService.updateMed(medicalrecordsWithBLOBsCustom);
		}
		return"redirect:users";
	}
	
	@RequestMapping(value="/fenyeMessage")
	public String oneMessage(Model model,MessageVo messageVo,HttpServletRequest request){
		int x =((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
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
		int a =((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		Branch branch = branchService.oneBranch(a);
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
		BigDecimal q1 = new BigDecimal(10000);
		BigDecimal q2 = new BigDecimal(100000000);
		BigDecimal bb = b.divide(q1);
		double b1 = bb.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal cc = c.divide(q1);
		double c1 = cc.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal dd = d.divide(q1);
		double d1 = dd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal ee = e.divide(q1);
		double e1 = ee.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal bbb = b.divide(q2);
		double b2 = bbb.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal ccc = c.divide(q2);
		double c2 = ccc.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal ddd = d.divide(q2);
		double d2 = ddd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal eee = e.divide(q2);
		double e2 = eee.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		BigDecimal []arr = new BigDecimal[]{b,c,d,e};
		double []db = new double[]{b1,c1,d1,e1,b2,c2,d2,e2};
		int o=branchService.brachCountOrders(a);
		int m=branchService.branchMessagesCount(a);
		int ac=branchService.branchCountActivities(a);
		int p=branchService.branchCountProducts(a);
		int u=branchService.branchCountUsers(a);
		int []ar = new int[]{u,ac,o,p,m};
		model.addAttribute("products", products);
		model.addAttribute("ar", ar);
		model.addAttribute("arr", arr);
		model.addAttribute("db", db);
		
		//查询分店的总收入，总教育收入，总健康收入，商城收入（bigdecimal）
		BigDecimal totalHealthIncome = branchService.totalHealIncome(a);
		BigDecimal totalEduIncome = branchService.totalEduIncome(a);
		BigDecimal totalOrderIncome = branchService.totalOderIncome(a);
		// BigDecimal totalIncome = totalEduIncome.add(totalHealthIncome).add(totalOrderIncome);
		BigDecimal []incomeArr = new BigDecimal[4];
		//分别把不同的收入数据传入incomeArr数组，给饼图做准备
		// incomeArr[0].add(totalIncome);
		// incomeArr[1].add(totalEduIncome);
		// incomeArr[2].add(totalHealthIncome);
		// incomeArr[3].add(totalOrderIncome);
		
		model.addAttribute("incomeArr", incomeArr);
		//查询分店的总支出，总活动支出，总健康支出，商城支出(bigdecimal)
		
		
		
		
		return "brach/index";
	}
	
	@RequestMapping(value="/branchTran")
	public String BranchTransaction(HttpServletRequest request,Model model){
		int a =((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		List<TransactionCustom> trans = new ArrayList<TransactionCustom>();
		trans = branchService.branchAllTran(a);
		model.addAttribute("trans", trans);
		return "brach/form";
	  } 
	
	@RequestMapping(value="/branchVist") 
	public String returnVist(Model model,HttpServletRequest request){
		int a =((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		List<Returnvisit> visits = new ArrayList<Returnvisit>();
		visits = branchService.branchReturnVist(a);
		model.addAttribute("visits", visits);
		return "brach/tasks";
	}
	
	/* 查询分店所有的活动 */
	@RequestMapping(value="/allActs")
	public String AllActivity(Model model,HttpServletRequest request){
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
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
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		Branch branch = new Branch();
		branch = branchService.oneBranchByEmployeeId(a);
		activityrecommendCustom.setBranchid(branch.getBranchid());
		System.out.println(activityrecommendCustom.getActivityid().toString()+activityrecommendCustom.getBranchid().toString());
		/*branchService.delActRec(activityrecommendCustom);*/
		return "";
		
	}
	
	@RequestMapping(value="/oneActCus")
	public String oneActCustom(Integer id,Model model){
		ActivityCustom act= new ActivityCustom();
		Activitytype actcus = new Activitytype(); 
		List<ActivitytypeCustom> actTypes = new ArrayList<ActivitytypeCustom>();
		actTypes = branchService.allActivityTypes();
		model.addAttribute("actTypes", actTypes);
		act = branchService.oneActCustom(id);
		actcus = branchService.oneActivitytype(act.getActivitytypeid());
		model.addAttribute("actcus", actcus);
		model.addAttribute("act", act);
		return"brach/ActDetail";
	}
	
	@RequestMapping(value="/updateAct")
	public String updateAct(Activity activity,Integer id,HttpServletRequest request,MultipartFile file,MultipartFile nice){
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
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
				filename = FileUpload.oneFileUpload(file,null,"picture");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			filename = act.getActivitypicture();
		}
		if(!nice.isEmpty()){
			try {
				File videoFile = new File(path+videoname);
				if(videoFile.exists()){
					if(videoFile.isFile()){
						videoFile.delete();
					}
				}
				filevideo = FileUpload.oneFileUpload(nice,null,"video");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			filevideo = act.getVideo();
		}
		
		if(filename!=null){
			activity.setActivitypicture(filename);
			}
		if(filevideo!=null){
			activity.setVideo(filevideo);
			}
		
		branchService.updateAct(activity);
		return "redirect:allActs";
		
	}
	
	@RequestMapping(value="/delAct")
	public String delActivity(Integer id){
		String path = "D:\\code\\web\\upload\\";
		ActivityCustom activityCustom = new ActivityCustom();
		activityCustom = branchService.oneActCustom(id);
		String picturename = activityCustom.getActivitypicture();
		String viodeString = activityCustom.getVideo();
		
		if (picturename!=null) {
			try {
				File pictureFile = new File(path+picturename);
				if(pictureFile.exists()){
					if(pictureFile.isFile()){
						pictureFile.delete();
					}
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
		}else{
			picturename = activityCustom.getActivitypicture();
		}
		
		if (viodeString!=null) {
			try {
				File videoFile = new File(path+viodeString);
				if(videoFile.exists()){
					if(videoFile.isFile()){
						videoFile.delete();
					}
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
		}else{
			viodeString = activityCustom.getVideo();
		}
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
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		branch = branchService.oneBranch(a);
		activity.setBranchid(branch.getBranchid());
		String filename = null;
		String fileVideo = null;
		if(!file.isEmpty()){
			try {
				filename = FileUpload.oneFileUpload(file,null, "picture");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!nice.isEmpty()) {
			try {
				fileVideo = FileUpload.oneFileUpload(nice,null, "video");
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
		activity.setVideo(fileVideo);
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
		System.out.println("1111111111111111");
		return branchService.oneUser(user.getUserid());
	}
	
	@RequestMapping(value="/RequestMessage")
	public @ResponseBody MessageCustom oneMessage(@RequestBody MessageCustom messageCustom){
		return branchService.oneMessage(messageCustom.getMessageid());
	}
	
	@RequestMapping(value="/RequestAct")
	public @ResponseBody ActivityrecommendCustom act(@RequestBody ActivityrecommendCustom activityrecommendCustom,HttpServletRequest request){
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
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
	
	@RequestMapping(value="/products")
	public String products(Model model,HttpServletRequest request){
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		Branch branch = new Branch();
		branch = branchService.oneBranch(a);
		List<ProductCustom> products = new ArrayList<ProductCustom>();
		products = branchService.quertyAllProduct(branch.getBranchid());
		model.addAttribute("products", products);
		return "brach/products";
	}
	
	/* ----------------分店管理员的员工管理功能 --------------*/
	@RequestMapping(value="/employees")
	public String employee(Model model,HttpServletRequest request){
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		List<EmployeeCustom> employees = new ArrayList<EmployeeCustom>();
		employees = branchService.allBranchEmployees(a);
		model.addAttribute("employees", employees);
		return "brach/employees";
	}
	
	@RequestMapping(value="/delEmpl")
	public String delEmployee(Integer id){
		String path = "D:\\code\\web\\upload\\";
		Employee emp = new Employee();
		emp = branchService.oneEmpl(id);
		String picturename = emp.getAvatar();
		if (picturename!=null) {
			try {
				File pictureFile = new File(path+picturename);
				if(pictureFile.exists()){
					if(pictureFile.isFile()){
						pictureFile.delete();
					}
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
		}else{
			picturename = emp.getAvatar();
		}
		branchService.delEmp(id);
		return "redirect:employees";
	}
	
	@RequestMapping(value="/oneEmp")
	public String oneEmployee(Integer id,Model model,HttpServletRequest request){
		List<Authority> auths = new ArrayList<Authority>();
		auths = branchService.authoritys();
		Employee employee = new Employee();
		employee = branchService.oneEmpl(id);
		model.addAttribute("auths", auths);
		model.addAttribute("employee", employee);
		return "brach/employeeDetail";
	}
	
	@RequestMapping(value="/updateEmpl")
	public String updateEmployee(EmployeeCustom employeeCustom,HttpServletRequest request){
		/*int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();*/
		branchService.updateEmpl(employeeCustom);
		return "redirect:employees";
	}
	
	@RequestMapping(value="/updateVip")
	public String updateEmpl(EmployeeCustom employeeCustom,HttpServletRequest request,MultipartFile file){
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		Employee empl = new Employee();
		empl = branchService.oneEmpl(a);
		String picture = null;
		String path = "D:\\code\\web\\upload\\";
		picture = empl.getAvatar();
		if (!file.isEmpty()) {
			try {
				File pictureFile = new File(path+picture);
				if(pictureFile.exists()){
					if(pictureFile.isFile()){
						pictureFile.delete();
					}
				}
				picture = FileUpload.oneFileUpload(file,null,"picture");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			picture = empl.getAvatar();
		}
		employeeCustom.setAvatar(picture);
		branchService.updateEmpl(employeeCustom);
		return "redirect:index";
	}
	
	@RequestMapping(value="/insert")
	public String insert(){
		return "brach/insertEmployee";
	}
	
	@RequestMapping(value="/insertEmpl")
	public String insertEmployee(EmployeeCustom employee,MultipartFile file,HttpServletRequest request){
		int x = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		
		Area area = new Area();
		area = branchService.oneArea(x);
		String name = "xiaohe";
		int sum = branchService.countEmpl();
		int a = employee.getPositionid();
		if(sum<10){
			name+=a+"00000"+sum;
		}if(sum<100&&sum>10){
			name+=a+"0000"+sum;
		}
		if(sum<1000&&sum>100){
			name+=a+"000"+sum;
		}
		if(sum<10000&&sum>1000){
			name+=a+"00"+sum;
		}
		if(sum<100000&&sum>10000){
			name+=a+"0"+sum;
		}
		String filename = null;
		if(!file.isEmpty()){
			try {
				filename = FileUpload.oneFileUpload(file,null, "picture");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(filename != null){
		employee.setAvatar(filename);
		}
		employee.setAreaid(area.getAreaid());
		employee.setAccountnumber(name);
		branchService.insertEmpl(employee);
		return"redirect:employees";
	}
	
	@RequestMapping(value="/vip")
	public String vip(HttpServletRequest request,Model model){
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		Employee employee = new Employee();
		employee = branchService.oneEmpl(a);
		model.addAttribute("employee", employee);
		return "brach/employeeVip";
	}
	
	@RequestMapping(value="/logout")
	public String logOut(HttpServletRequest request){
		request.getSession().invalidate();
		return "AdminLogin/login";
	}
	
	//--------------------------报表开始--------------------------
	
	@RequestMapping(value="/charts")
	public String charts(HttpServletRequest request,Model model){
		int a = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		Branch branch = new Branch();
		branch = branchService.oneBranch(a);  //根据管理员id查到对应的分店
		List<ProductCustom> products = new ArrayList<ProductCustom>();
		products = branchService.quertyAllProduct(branch.getBranchid());  //根据管理员查到的分店id查询到全部的（分店商品）
		ProductCustom productCustom = new ProductCustom();
		for(int i=0;i<products.size();i++){
			productCustom = branchService.BranchProductCustom(products.get(i));
			System.out.println(productCustom);
			if(productCustom/*.getCountBuy()*/==null/*||productCustom.getCountPrice()==null*/){
				products.get(i).setCountBuy(0);
				products.get(i).setCountPrice(new BigDecimal(0.00));
			}else {
				int c = (branchService.BranchProductCustom(products.get(i))).getCountBuy();
				BigDecimal d = (branchService.BranchProductCustom(products.get(i))).getCountPrice();
				products.get(i).setCountBuy(c);
				products.get(i).setCountPrice(d);
			}
		}
		
		List<ActivityCustom> acts = new ArrayList<ActivityCustom>(); 
		acts = branchService.branchActs(a);
		ActivityCustom act = new ActivityCustom();
		ActivityCustom act2 = new ActivityCustom();
		for(int i=0;i<acts.size();i++){
			act2.setActivityid(acts.get(i).getActivityid());
			act = branchService.branchActivityCondition(act2);
			if(act!=null){
				if(act.getCountReg()!=0){
					acts.get(i).setCountReg(act.getCountReg());//总报名人数
				}else{
					acts.get(i).setCountReg(0);
				}
				if(act.getTotalReg()!=null){
					acts.get(i).setTotalReg(act.getTotalReg());//总报名费
				}else{
					acts.get(i).setTotalReg(new BigDecimal(0));
				}if(act.getTotalExpend()!=null){
					acts.get(i).setTotalExpend(act.getTotalExpend());//总支出
				}else {
					acts.get(i).setTotalExpend(new BigDecimal(0));
				}
			}else {
				acts.get(i).setCountReg(0);
				acts.get(i).setTotalReg(new BigDecimal(0));
				acts.get(i).setTotalExpend(new BigDecimal(0));
			}
		}
		
		model.addAttribute("acts", acts);
		System.out.println(acts.get(0).getTotalReg());
		model.addAttribute("products",products);//这个是分店所有的商品
		/*ProductCustom productCustom1 = new ProductCustom();
		ProductCustom productCustom2 = new ProductCustom();
		productCustom1.setEmployeeid(a);
		productCustom1.setBranchid(branch.getBranchid());
		productCustom1.setProductid(products.get(0).getProductid());
		productCustom2 = branchService.BranchProductCustom(productCustom1);
		model.addAttribute("productCustom2", productCustom2);//这个是销售情况（包括，总销售量和总销售额）
*/		return "brach/chart";
	}
	
	/*public @ResponseBody */
	
	@RequestMapping(value="/requestProduct")
	public @ResponseBody productTranctionReportVo product(Model model,@RequestBody ProducttransactionreportCustom products,HttpServletRequest request){
		productTranctionReportVo allTranctions = new productTranctionReportVo();
		List<ProducttransactionreportCustom> pro = new ArrayList<ProducttransactionreportCustom>();
		Integer sum = 0;    //总条数
		Integer pageNum = 0;//总页数
		/*-----------分页条件-------------*/
		int x = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		int a = (products.getStartingTime()).compareTo(products.getEndTime());//比较时间，开始时间小于结束时间返回-1，商品的id不可为空
		if (a < 0 && products.getProductid() != null) {
			products.setEmployeeid(x);
			pro = branchService.selectByCondition(products);
			for(int i=0;i<pro.size();i++){
				String buy = GetStringByDate.getString(pro.get(i).getBuytime());
				pro.get(i).setBuy(buy);
			}
			/*---------分页-----------*/
			/*if(products.getCurrentPage() >= 1){
				Integer tempBegin = (products.getCurrentPage()-1) * products.getPageNum();
				products.setBegin(tempBegin);
			}else{
				products.setBegin(0);
			}
			sum = pro.size(); 
			pageNum = sum / products.getPageNum();
			if(sum % products.getPageNum() != 0){
				pageNum +=  1;
			}
			allTranctions.setSum(sum);
			allTranctions.setPageSum(pageNum);*/
			allTranctions.setList(pro);
			/*---------------------------*/
			return allTranctions;
		} else {
			return null;
		}
		
	}
	
	@RequestMapping(value="/productChart")
	public @ResponseBody ProducttransactionreportCustom productCharts(@RequestBody ProducttransactionreportCustom productTranctionReportCustom,HttpServletRequest request) throws ParseException{
		int x = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		productTranctionReportCustom.setEmployeeid(x);
		if(productTranctionReportCustom.getStartingTime()==null||productTranctionReportCustom.getEndTime()==null){
			Date date = new Date();
			Date start = new Date();
			Date end = new Date();
			GetStringByDate calTime = new GetStringByDate(); 
			start = calTime.addDate(date, -5);
			end = calTime.addDate(date, 5);
			productTranctionReportCustom.setStartingTime(start);
			productTranctionReportCustom.setEndTime(end);
		}
		int a = productTranctionReportCustom.getStartingTime().compareTo(productTranctionReportCustom.getEndTime());
		if(a<=0){ //判断传进来的时间，开始时间小于结束时间
			List<ProducttransactionreportCustom> pro = new ArrayList<ProducttransactionreportCustom>();
			Date date1 = new Date();
			GetStringByDate calTime = new GetStringByDate(); 
			/*date1 = calTime.addDate(productTranctionReportCustom.getStartingTime(), -1); //开始时间减1天
			productTranctionReportCustom.setStartingTime(date1);*/
			pro = branchService.selectByCondition(productTranctionReportCustom);    //这里可以得到单个商品时间段内的销售情况
			/*查询时间段内一天的商品销售情况*/
			//查询时间间隔天数
			int days = calTime.calculateDate(productTranctionReportCustom.getStartingTime(),productTranctionReportCustom.getEndTime());
			date1 = productTranctionReportCustom.getStartingTime();
			ProducttransactionreportCustom oneDayProduct = new ProducttransactionreportCustom();
			Integer countBuy[] = new Integer[days+1];
			String buyTime[] = new String[days+1];
			for(int i=0;i<=days;i++){ //循环查询每天的销售情况
				Date date = new Date();
				Date date2 = new Date();
				Date start = new Date();
				
				Date end = new Date(); 
				date1 = calTime.addDate(productTranctionReportCustom.getStartingTime(), i); //这个时间是从开始时间循环到结束时间
				date2 = calTime.addDate(productTranctionReportCustom.getStartingTime(), i);
				date1.setHours(0);date.setMinutes(0);date.setSeconds(0);
				start = date1;
				date2.setHours(23);date2.setMinutes(59);date2.setSeconds(59);
				end = date2;
				productTranctionReportCustom.setStart(start); //得到第一天的开始
				productTranctionReportCustom.setEnd(end);     //得到第一天的结束
				/*String buyTime = calTime.getTime(productTranctionReportCustom.getBuytime());
				SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd"); 
				productTranctionReportCustom.setBuytime(smp.parse(buyTime)); //处理购买时间为'2017-1-1'格式*/		
				oneDayProduct = branchService.oneTransation(productTranctionReportCustom);
				if(oneDayProduct!= null){
					countBuy[i] = oneDayProduct.getTotalCount();
				}else{
					countBuy[i] = 0;
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(start);
				String time = cal.get(Calendar.YEAR)+"年"+(cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DATE)+"日";
				buyTime[i] = time;
				productTranctionReportCustom.setBuyNo(countBuy);
				productTranctionReportCustom.setBuyTime(buyTime);
		}//查询一天的循环结束
		}
		
		return productTranctionReportCustom;
	}
	
	
	@RequestMapping(value="/oneProductChart")
	public String charts(Integer id){
		return "brach/oneProductChart";
	}
	
	@RequestMapping(value="/activityReport")
	public String activityReport(){
		return "brach/activityReport";
	}
	
	@RequestMapping(value="/actReportCondition")
	public @ResponseBody ActivityCustom activityCondition(@RequestBody ActivityCustom activityCustom){
		ActivityCustom oneact = new ActivityCustom();
		oneact = branchService.branchActivityCondition(activityCustom);
		return oneact;
	}
	
	@RequestMapping(value="/pie")
	public @ResponseBody ProducttransactionreportCustom productCondition(@RequestBody ProducttransactionreportCustom producttransactionreportCustom,HttpServletRequest request){
		int x = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		ProducttransactionreportCustom producttransaction = new ProducttransactionreportCustom();
		if(producttransactionreportCustom.getStartingTime()==null||producttransactionreportCustom.getEndTime()==null){
			Date date = new Date();
			Date start = new Date();
			Date end = new Date();
			GetStringByDate calTime = new GetStringByDate();
			start = calTime.addDate(date, -5);
			end = calTime.addDate(date, 5);
			producttransactionreportCustom.setStartingTime(start);
			producttransactionreportCustom.setEndTime(end);
		}
		Branch branch = new Branch();
		branch = branchService.oneBranch(x);
		
		producttransactionreportCustom.setProductid(producttransactionreportCustom.getProductid());
		producttransactionreportCustom.setBranchid(branch.getBranchid());
		ProducttransactionreportCustom pro = new ProducttransactionreportCustom(); 
		ProducttransactionreportCustom pro2 = new ProducttransactionreportCustom();
		ProducttransactionreportCustom pro3 = new ProducttransactionreportCustom();
		
		pro = branchService.BranchOneProductTransation(producttransactionreportCustom);  //单个商品
		if(pro!=null&&pro.getTotalSail()!=null){
		producttransaction.setOneSail(pro.getTotalSail());
		}else{
			producttransaction.setOneSail(new BigDecimal(0.00));
		}
		
		/*producttransactionreportCustom.setProductid(null); //总的商品*/
		ProducttransactionreportCustom p = new ProducttransactionreportCustom();
		p.setStartingTime(producttransactionreportCustom.getStartingTime());
		p.setEndTime(producttransactionreportCustom.getEndTime());
		pro2 = branchService.BranchOneProductTransation(p);
		if(pro2!=null&&pro2.getTotalSail()!=null){
		producttransaction.setTotalSail(pro2.getTotalSail());
		}else {
			producttransaction.setTotalSail(new BigDecimal(0.00));
		}
		
		ProducttransactionreportCustom pros = new ProducttransactionreportCustom();
		pros.setProductid(producttransactionreportCustom.getProductid());
		pro3 = branchService.BranchOneProductTransation(pros);
		if(pro3!=null&&pro3.getTotalSail()!=null){
			producttransaction.setTotalprice(pro3.getTotalSail());
			}else {
				producttransaction.setTotalprice(new BigDecimal(0.00));
			}
		return producttransaction;
	}
	
	/*@RequestMapping(value="/activityReport")
	public @ResponseBody ActivityCustom oneActConditionCustom(@RequestBody ActivityCustom activityCustom){
		ActivityCustom act = new ActivityCustom();
		act = branchService.branchActivityCondition(activityCustom);
		return act;
	} */
	
	@RequestMapping(value="/orderReportCondition")
	public @ResponseBody OrdersCustom orderIncomeReport(@RequestBody OrdersCustom ordersCustom,HttpServletRequest request){
		int x = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		OrdersCustom ords = new OrdersCustom();
		ordersCustom.setEmployeeid(x);
		ords = branchService.orderIncome(ordersCustom);
		if(ords==null){
			OrdersCustom ords2 = new OrdersCustom();
			ords2.setTotalIncome(new BigDecimal(0));
			ords2.setTotalexl(new BigDecimal(0));
			System.out.println(ords);
			return ords2;
		}else{
		return ords;
		}
	}
	
	@RequestMapping(value="/allActReport")
	public @ResponseBody ActivityCustom actIncomeReport(@RequestBody ActivityCustom activityCustom,HttpServletRequest request){
		int x = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		activityCustom.setEmployeeid(x);
		ActivityCustom act = new ActivityCustom(); 
		ActivityCustom act1 = new ActivityCustom();   //健康
		ActivityCustom act2 = new ActivityCustom();	  //教育
		act1 = branchService.healthIncome(activityCustom);
		act2 = branchService.eduIncome(activityCustom);
		if(act1!=null){
			act.setActivityprice(act1.getTotalIncome());  //健康的总收入
			act.setRegisteryfee(act1.getTotalexl());   //健康的总支出
		}else {
			act.setActivityprice(new BigDecimal(0));
			act.setRegisteryfee(new BigDecimal(0));
		}
		if(act2!=null){
			act.setTotalReg(act2.getTotalIncome());     //教育的总收入
			act.setTotalExpend(act2.getTotalexl());  //教育的总支出
		}else {
			act.setTotalReg(new BigDecimal(0));
			act.setTotalExpend(new BigDecimal(0));
		}if(act1!=null&&act2!=null){
			act.setTotalexl(act1.getTotalexl().add(act2.getTotalexl()));   //总支出 
			act.setTotalIncome(act1.getTotalIncome().add(act2.getTotalIncome()));  //总收入
		}else if(act1!=null&&act2==null){
			act.setTotalexl(act.getTotalexl().add(new BigDecimal(0)));
			act.setTotalIncome(act.getTotalIncome().add(new BigDecimal(0)));
		}else if(act1==null&&act2!=null){
			act.setTotalexl(act2.getTotalexl().add(new BigDecimal(0)));
			act.setTotalIncome(act2.getTotalIncome().add(new BigDecimal(0)));
		}else{
			act.setTotalexl(new BigDecimal(0));
			act.setTotalIncome(new BigDecimal(0));
		}
		return act;
	}
	
	@RequestMapping(value="/allChart")
	public @ResponseBody ActivityCustom allChart(@RequestBody ActivityCustom activityCustom,HttpServletRequest request){
		int x = ((Employee)request.getSession().getAttribute("admins")).getEmployeeid();
		activityCustom.setEmployeeid(x);
		ActivityCustom act = new ActivityCustom(); 
		ActivityCustom act1 = new ActivityCustom();   //健康
		ActivityCustom act2 = new ActivityCustom();	  //教育
		act1 = branchService.healthIncome(activityCustom);
		act2 = branchService.eduIncome(activityCustom);
		if(act1!=null){
			act.setActivityprice(act1.getTotalIncome());  //健康的总收入
			act.setRegisteryfee(act1.getTotalexl());   //健康的总支出
		}else {
			act.setActivityprice(new BigDecimal(0));
			act.setRegisteryfee(new BigDecimal(0));
		}
		if(act2!=null){
			act.setTotalReg(act2.getTotalIncome());     //教育的总收入
			act.setTotalExpend(act2.getTotalexl());  //教育的总支出
		}else {
			act.setTotalReg(new BigDecimal(0));
			act.setTotalExpend(new BigDecimal(0));
		}if(act1!=null&&act2!=null){
			act.setTotalexl(act1.getTotalexl().add(act2.getTotalexl()));   			//总支出 
			act.setTotalIncome(act1.getTotalIncome().add(act2.getTotalIncome()));  //总收入
		}else if(act1!=null&&act2==null){
			act.setTotalexl(act.getTotalexl().add(new BigDecimal(0)));
			act.setTotalIncome(act.getTotalIncome().add(new BigDecimal(0)));
		}else if(act1==null&&act2!=null){
			act.setTotalexl(act2.getTotalexl().add(new BigDecimal(0)));
			act.setTotalIncome(act2.getTotalIncome().add(new BigDecimal(0)));
		}else{
			act.setTotalexl(new BigDecimal(0));
			act.setTotalIncome(new BigDecimal(0));
		}
		
		OrdersCustom ordersCustom = new OrdersCustom();
		if(activityCustom!=null){
			ordersCustom.setStart(activityCustom.getStart());
			ordersCustom.setEnd(activityCustom.getEnd());
		}
		OrdersCustom ords = new OrdersCustom();
		ordersCustom.setEmployeeid(x);
		ords = branchService.orderIncome(ordersCustom);
		if(ords==null){
			act.setDemo1(new BigDecimal(0));
			act.setDemo2(new BigDecimal(0));
		}else {
			act.setDemo1(ords.getTotalexl());
			act.setDemo2(ords.getTotalIncome());
		}
		return act;
	}
	
}
