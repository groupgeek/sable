package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityVo;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.bean.AddActivityVo;
import com.xiaohe.bean.AddEmployeeVo;
import com.xiaohe.bean.AddUserVo;
import com.xiaohe.bean.AreaCustom;
import com.xiaohe.bean.AuthorityCustom;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.BranchVo;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.EmployeeVo;
import com.xiaohe.bean.LevelCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.Positional;
import com.xiaohe.bean.PositionalCustom;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductVo;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.bean.UpdateActivityVo;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;
import com.xiaohe.service.ActivityService;
import com.xiaohe.service.ActivitytypeService;
import com.xiaohe.service.AreaService;
import com.xiaohe.service.AuthorityService;
import com.xiaohe.service.BranchService;
import com.xiaohe.service.EmployeeService;
import com.xiaohe.service.LevelSevice;
import com.xiaohe.service.MessageService;
import com.xiaohe.service.PositionalSerice;
import com.xiaohe.service.ProductService;
import com.xiaohe.service.ProductTypeService;
import com.xiaohe.service.UserService;

@Controller
@RequestMapping("/superAdmin")
public class superAdminController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("areaService")
	private AreaService areaService;
	
	@Autowired
	@Qualifier("branchService")
	private BranchService branchService;
	
	@Autowired
	@Qualifier("authorityService")
	private AuthorityService authorityService;
	
	@Autowired
	@Qualifier("levelSevice")
	private LevelSevice levelSevice;
	
	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	
	@Autowired
	@Qualifier("positionalSerice")
	private PositionalSerice positionalSerice;
	
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
	@Autowired
	@Qualifier("activitytypeService")
	private ActivitytypeService activitytypeService;
	
	@Autowired
	@Qualifier("messageService")
	private MessageService messageService;
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("productTypeService")
	private ProductTypeService productTypeService;
	
	
	@RequestMapping("/test")
	public @ResponseBody UserCustom queryEvaluation(@RequestBody UserCustom text){
		
		
		System.out.println("***************");
		return text;
	}

	
	/**
	 * 查询所有用户
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryAllUser")
	public @ResponseBody UserVo queryAllUser(@RequestBody UserCustom condition){
		/**
		 * allUsers 查询的所有用户
		 */
		UserVo allUsers = new UserVo(); 
		//开始查询用户
		allUsers = userService.queryAllUserByCondition(condition);
		return allUsers;
	}

	
	/**
	 * 查询用户详细信息
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryuserInfo")
	public @ResponseBody UserCustom queryuserInfo(@RequestBody UserCustom condition){
		
		UserCustom userInfo = userService.queryUserInfoById(condition.getUserid());
		
		return userInfo;
	}
	
	/**
	 * 进入修改用户信息界面
	 * @param model
	 * @param id
	 * @param message
	 * @return
	 */
	@RequestMapping("/updateUserInfoView")
	public String updateUserInfoView(Model model,Integer id,String message){
		
		UserCustom userInfo = new UserCustom();
		List<AuthorityCustom> allAuthority = new ArrayList<AuthorityCustom>();
		List<AreaCustom> allArea = new ArrayList<AreaCustom>();
		List<BranchCustom> allBranch = new ArrayList<BranchCustom>();
		List<LevelCustom> allLevel= new ArrayList<LevelCustom>();
		
		//开始查询
		userInfo = userService.queryUserInfoById(id);
		
		allAuthority = authorityService.queryAll();
		
		allArea = areaService.queryAreas(null);
		
		allBranch = branchService.queryAll();
		
		allLevel = levelSevice.queryAll();
		
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("allAuthority", allAuthority);
		model.addAttribute("allArea", allArea);
		model.addAttribute("allBranch", allBranch);
		model.addAttribute("allLevel", allLevel);
		model.addAttribute("message", message);
		return "admin/page/updateUser";
	}
	
	/**
	 * 更新用户信息
	 * @param userInfo
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(UserCustom userInfo,MultipartFile pictureUpload,Model model){
		String message = null;
		if(userService.UpdateUserInfoByUser(userInfo,pictureUpload)){
			message = "修改成功";
		}else{
			message = "修改失败";
		}
		
		return "redirect:updateUserInfoView?id="+userInfo.getUserid()+"&message="+message;
	}
	
	/**
	 * 加载数据
	 * @return
	 */
	@RequestMapping("/addUserView")
	public @ResponseBody AddUserVo addUserView(){
		AddUserVo addUserVo = new AddUserVo();
		List<AuthorityCustom> allAuthority = new ArrayList<AuthorityCustom>();
		List<AreaCustom> allArea = new ArrayList<AreaCustom>();
		List<LevelCustom> allLevel= new ArrayList<LevelCustom>();
		
		allAuthority = authorityService.queryAll();
		
		allArea = areaService.queryAreas(null);
		
		allLevel = levelSevice.queryAll();
		
		addUserVo.setAllArea(allArea);
		addUserVo.setAllAuthority(allAuthority);
		addUserVo.setAllLevel(allLevel);
		return addUserVo;
	}
	
	/**
	 * 添加客户
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(UserCustom user,Model model){
		
		if(userService.registerUser(user)) {
			
			model.addAttribute("message", "添加成功");
			
		}else{
			model.addAttribute("message", "添加失败");
		}
		return "admin/page/addUser";
	}
	
	/**
	 * 查询所有员工
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryAllEmployee")
	public @ResponseBody EmployeeVo queryAllEmployee(@RequestBody EmployeeCustom condition){
		EmployeeVo allEmployee = new EmployeeVo();
		allEmployee = employeeService.queryAllEmployeeByCondition(condition);
		return allEmployee;
	}
	
	/**
	 * 查询员工所有信息
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryEmployeeInfo")
	public @ResponseBody EmployeeCustom queryEmployeeInfo(@RequestBody EmployeeCustom condition){
		
		EmployeeCustom employeeInfo = employeeService.queryEmployeeInfoById(condition.getEmployeeid());
		
		return employeeInfo;
	}
	
	/**
	 * 进入修改员工信息界面
	 * @param model
	 * @param id
	 * @param message
	 * @return
	 */
	@RequestMapping("/updateEmployeeInfoView")
	public String updateEmployeeInfoView(Model model,Integer id,String message){
		
		EmployeeCustom employeeInfo = new EmployeeCustom();
		List<AuthorityCustom> allAuthority = new ArrayList<AuthorityCustom>();
		List<AreaCustom> allArea = new ArrayList<AreaCustom>();
		List<BranchCustom> allBranch = new ArrayList<BranchCustom>();
		List<PositionalCustom> allPositional = new ArrayList<PositionalCustom>();
		
		//开始查询
		employeeInfo = employeeService.queryEmployeeInfoById(id);
		
		allAuthority = authorityService.queryAll();
		
		allArea = areaService.queryAreas(null);
		
		allBranch = branchService.queryAll();
		
		allPositional = positionalSerice.queryAll();
		
		
		model.addAttribute("employeeInfo", employeeInfo);
		model.addAttribute("allAuthority", allAuthority);
		model.addAttribute("allArea", allArea);
		model.addAttribute("allBranch", allBranch);
		model.addAttribute("allPositional", allPositional);
		if(message != null) model.addAttribute("message", message);
		return "admin/page/updateEmployee";
	}
	
	/**
	 * 更新员工信息
	 * @param userInfo
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateEmployeeInfo")
	public String updateEmployeeInfo(EmployeeCustom employeeInfo,MultipartFile pictureUpload,Model model){
		String message = null;
		if(employeeService.UpdateUserInfoByUser(employeeInfo,pictureUpload)){
			message = "修改成功";
		}else{
			message = "修改失败";
		}
		
		return "redirect:updateEmployeeInfoView?id="+employeeInfo.getEmployeeid()+"&message="+message;
	}
	
	/**
	 * 加载数据
	 * @param employee
	 * @return
	 */
	@RequestMapping("/addEmployeeView")
	public @ResponseBody AddEmployeeVo addEmployeeView(){
		
		AddEmployeeVo addEmployeeVo = new AddEmployeeVo();
		List<AuthorityCustom> allAuthority = new ArrayList<AuthorityCustom>();
		List<AreaCustom> allArea = new ArrayList<AreaCustom>();
		List<PositionalCustom> allPosittonal = new ArrayList<PositionalCustom>();
		
		allAuthority = authorityService.queryAll();
		
		allArea = areaService.queryAreas(null);
		
		allPosittonal = positionalSerice.queryAll();
		
		addEmployeeVo.setAllArea(allArea);
		addEmployeeVo.setAllAuthority(allAuthority);
		addEmployeeVo.setAllPosittonal(allPosittonal);
		return addEmployeeVo;
	}
	
	/**
	 * 添加员工
	 * @param employee
	 * @return
	 */
	@RequestMapping("/addEmployee")
	public String addEmployee(EmployeeCustom employee, Model model){
		String accountNumber = employeeService.addEmployee(employee);
		
		if( accountNumber != null ) {
			
			model.addAttribute("message", "添加成功,员工账号为" + accountNumber);
			
		}else{
			model.addAttribute("message", "添加失败");
		}
		return "admin/page/addEmployee";
	}
	
	/**
	 * 查询所有活动
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryAllActivity")
	public @ResponseBody ActivityVo queryAllActivity(@RequestBody ActivityCustom condition){
		
		ActivityVo activityVo = activityService.queryAllActivityByCondition(condition);
		return activityVo;
	}
	
	/**
	 * 查询活动所有信息
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryActivityInfo")
	public @ResponseBody ActivityCustom queryActivityInfo(@RequestBody ActivityCustom condition){
		
		ActivityCustom activityInfo = activityService.queryActivityInfoById(condition.getActivityid());
		
		return activityInfo;
	}
	
	/**
	 * 加载活动数据
	 * @param activityInfo
	 * @return
	 */
	@RequestMapping("/updateActivityInfoView")
	public @ResponseBody UpdateActivityVo updateActivityInfoView(@RequestBody ActivityCustom activityInfo){
		UpdateActivityVo updateActivityVo = new UpdateActivityVo();
		ActivityCustom activity = new ActivityCustom();
		List<ActivitytypeCustom> allactivitytype = new ArrayList<ActivitytypeCustom>();
		List<BranchCustom> allBranch = new ArrayList<BranchCustom>();
		
		activity = activityService.queryActivityInfoById(activityInfo.getActivityid());
		allactivitytype = activitytypeService.queryAllType();
		allBranch = branchService.queryAll();
		
		updateActivityVo.setActivityInfo(activity);
		updateActivityVo.setAllActivitytype(allactivitytype);
		updateActivityVo.setAllBranch(allBranch);
		
		return updateActivityVo;
	}
	
	/**
	 * 更新活动信息
	 * @param model
	 * @param activityInfo
	 * @param videoUpload
	 * @param pictureUpload
	 * @return
	 */
	@RequestMapping("/updateActivityInfo")
	public String updateActivityInfo(Model model,ActivityCustom activityInfo,MultipartFile videoUpload,MultipartFile pictureUpload){

		if(activityService.updateActivityInfo(activityInfo, videoUpload, pictureUpload)){
			model.addAttribute("message", "修改成功");
			model.addAttribute("activityid", activityInfo.getActivityid());
		}else{
			model.addAttribute("message", "修改失败");
		}
		return "admin/page/activityInfo";
	}
	
	/**
	 * 加载添加活动信息
	 * @return
	 */
	@RequestMapping("/addActivityView")
	public @ResponseBody AddActivityVo addActivityView(){
		AddActivityVo addActivityVo = new AddActivityVo();
		Map<String, List<ActivitytypeCustom>> allTypes = new HashMap<String, List<ActivitytypeCustom>>();
		List<BranchCustom> allBranch = new ArrayList<BranchCustom>();
		
		allTypes = activitytypeService.queryAllTypeOrderByFather();
		allBranch = branchService.queryAll();
		
		addActivityVo.setAllTypes(allTypes);
		addActivityVo.setAllBranchs(allBranch);
		
		return addActivityVo;
	};
	
	/**
	 * 添加活动
	 * @param activity
	 * @return
	 */
	@RequestMapping("/addActivity")
	public String addActivity(Model model,ActivityCustom activity,MultipartFile videoUpload,MultipartFile pictureUpload){
		
		if(activityService.addActivity(activity, videoUpload, pictureUpload)){
			model.addAttribute("message", "添加成功");
		}else{
			model.addAttribute("message", "添加失败");
		}
		return "admin/page/addActivity";
	};
	
	/**
	 * 查询所有分店
	 * @return
	 */
	@RequestMapping("/queryAllBranch")
	public @ResponseBody List<BranchCustom> queryAllBranch(){
		
		List<BranchCustom> allBranch = new ArrayList<BranchCustom>();
		allBranch = branchService.queryAll();
		return allBranch;
	}
	
	/**
	 * 查询所有留言
	 * @return
	 */
	@RequestMapping("/queryAllMessage")
	public @ResponseBody MessageVo queryAllMessage(@RequestBody MessageCustom condition){
		
		MessageVo messageVo = new MessageVo();
		messageVo = messageService.queryAllMessageByCondition(condition);
		
		return messageVo;
	}
	
	/**
	 * 查询留言详细信息
	 * @return
	 */
	@RequestMapping("/queryMessageInfo")
	public @ResponseBody MessageCustom queryMessageInfo(@RequestBody MessageCustom condition){
		MessageCustom message = new MessageCustom();
		message = messageService.queryMessagInfoById(condition.getMessageid());
		
		return message;
	}
	
	@RequestMapping("/updateMessageInfo")
	public @ResponseBody String updateMessageInfo(@RequestBody MessageCustom messageInfo){
		String message = null;
		if(messageService.updateMessage(messageInfo)){
			message = "更新成功";
		}else{
			message = "更新失败";
		}
		return message;
	}
	
	
	/**
	 * 查询所有活动的信息（进入分店管理页面）
	 * @return
	 */
	@RequestMapping("/queryAllBranchInfo")
	public @ResponseBody BranchVo queryAllBranchInfo(@RequestBody BranchCustom condition){
		BranchVo branchVo = new BranchVo();
		branchVo = branchService.queryAllBranchByCondition(condition);
		
		return branchVo;
	}
	
	/**
	 * 查询分店信息
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryBranchInfo")
	public @ResponseBody BranchCustom queryBranchInfo(@RequestBody BranchCustom condition){
		if(condition == null) return null;
		if(condition.getBranchid() == null) return null;
		BranchCustom branchInfo = new BranchCustom();
		branchInfo = branchService.queryBranchInfoById(condition.getBranchid());
		return branchInfo;
	}
	
	/**
	 * 查询所有商品类型（小）
	 * @return
	 */
	@RequestMapping("/queryAllProductType")
	public @ResponseBody List<ProducttypeCustom> queryAllProductType(){
		List<ProducttypeCustom> allProducttype = new ArrayList<ProducttypeCustom>();
		allProducttype = productTypeService.querySimallProducttype();
		return allProducttype;
	}
	
	/**
	 * 查询所有产品
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryAllProduct")
	public @ResponseBody ProductVo queryAllProduct(@RequestBody ProductCustom condition){
		ProductVo productVo = new ProductVo();
		productVo = productService.queryAllProductByCondition(condition);
		
		return productVo;
	}
	
	
}
