package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.xiaohe.bean.CeoActivityreport;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.EmployeeVo;
import com.xiaohe.bean.IntegralCustom;
import com.xiaohe.bean.LevelCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.Positional;
import com.xiaohe.bean.PositionalCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductVo;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.bean.ReturnvisitCustom;
import com.xiaohe.bean.ReturnvisitVo;
import com.xiaohe.bean.ShowMessage;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.TransactionVo;
import com.xiaohe.bean.UpdateActivityVo;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.ActivityService;
import com.xiaohe.service.ActivitytypeService;
import com.xiaohe.service.AreaService;
import com.xiaohe.service.AuthorityService;
import com.xiaohe.service.BranchService;
import com.xiaohe.service.CeoService;
import com.xiaohe.service.EmployeeService;
import com.xiaohe.service.IntegralService;
import com.xiaohe.service.LevelSevice;
import com.xiaohe.service.MessageService;
import com.xiaohe.service.PositionalSerice;
import com.xiaohe.service.ProductService;
import com.xiaohe.service.ProductTypeService;
import com.xiaohe.service.ReportService;
import com.xiaohe.service.ReturnvisitService;
import com.xiaohe.service.TransactionService;
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
	
	@Autowired
	@Qualifier("transactionService")
	private TransactionService transactionService;
	
	@Autowired
	@Qualifier("returnvisitService")
	private ReturnvisitService returnvisitService;
	
	@Autowired
	@Qualifier("reportService")
	private ReportService reportService;
	
	@Autowired
	@Qualifier("ceoService")
	private CeoService ceoService;
	
	@Autowired
	@Qualifier("integralService")
	private IntegralService integralService;
	
	@RequestMapping("/test")
	public @ResponseBody UserCustom queryEvaluation(@RequestBody UserCustom text){
		
		
		System.out.println("***************");
		return text;
	}

	public Employee getAdmin(HttpServletRequest request){
		return (Employee) request.getSession().getAttribute("admins");
	}
	
	/**
	 * 检查当前是否登录
	 * @param condition
	 * @return
	 */
	@RequestMapping("/getSuperAdmin")
	public @ResponseBody Employee getSuperAdmin(HttpServletRequest request){
		Employee admin = new EmployeeCustom();
		admin = getAdmin(request);
		return admin;
	}
	
	//退出
		@RequestMapping("/logout")
		public String logout(HttpSession session)throws Exception{
			
			//session过期
			session.invalidate();
			
			return "redirect:/jsp/AdminLogin/login/login.jsp";
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
	public String updateUserInfo(UserCustom userInfo,MultipartFile pictureUpload,Model model,HttpServletRequest request){
		
		String message = null;
		if(userService.UpdateUserInfoByUser(userInfo,pictureUpload)){
			message = "修改成功";
		}else{
			message = "修改失败";
		}
		model.addAttribute("message",message);
		return "redirect:updateUserInfoView?id="+userInfo.getUserid();
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
	 * 删除客户
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public @ResponseBody ShowMessage deleteUser(@RequestBody Integer userid){
		ShowMessage message = new ShowMessage();
		if(userService.deleteUser(userid)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
			message.setMessage("删除失败");
		}
		return message;
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
		model.addAttribute("message",message);
		return "redirect:updateEmployeeInfoView?id="+employeeInfo.getEmployeeid();
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
	 * 删除员工
	 * @return
	 */
	@RequestMapping("/deleteEmployee")
	public @ResponseBody ShowMessage deleteEmployee(@RequestBody Integer employeeid){
		ShowMessage message = new ShowMessage();
		if(employeeService.deleteEmployee(employeeid)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
			message.setMessage("删除失败");
		}
		return message;
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
	 * 查询活动负责人
	 * @param activityid
	 * @return
	 */
	@RequestMapping("/queryEmployeeByactivityId")
	public @ResponseBody Employee queryEmployeeByactivityId(@RequestBody Integer activityid){
		EmployeeCustom employee = new EmployeeCustom();
		
		employee = activityService.queryEmployeeByAId(activityid);
		
		return employee;
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
	 * 加载活动负责人（多人）
	 * @param activityid
	 * @return
	 */
	@RequestMapping("/queryAllEmployeeByactivityId")
	public @ResponseBody List<EmployeeCustom> queryAllEmployeeByactivityId(@RequestBody Integer activityid){
		List<EmployeeCustom> all = new ArrayList<EmployeeCustom>();
		
		all = activityService.queryAllEmployeeByAId(activityid);
		
		return all;
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
	 * 加载活动负责人（多人）根据分店
	 * @param branchid
	 * @return
	 */
	@RequestMapping("/queryAllEmployeeByBranchId")
	public @ResponseBody List<EmployeeCustom> queryAllEmployeeByBranchId(@RequestBody Integer branchid){
		List<EmployeeCustom> all = new ArrayList<EmployeeCustom>();
		
		all = activityService.queryAllEmployeeByBranchId(branchid);
		
		return all;
	}
	
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
	 * 删除活动
	 * @return
	 */
	@RequestMapping("/deleteActivity")
	public @ResponseBody ShowMessage deleteActivity(@RequestBody Integer activityid){
		ShowMessage message = new ShowMessage();
		if(activityService.deleteActivity(activityid)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
			message.setMessage("删除失败");
		}
		return message;
	}
	
	
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
	public @ResponseBody ShowMessage updateMessageInfo(@RequestBody MessageCustom messageInfo){
		ShowMessage message = new ShowMessage();
		if(messageService.updateMessage(messageInfo)){
			message.setMessage("更新成功");
			message.setFlag(true);
		}else{
			message.setMessage("更新失败");
			message.setFlag(false);
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
	 * 进入分店修改页面
	 * @param condition
	 * @return
	 */
	@RequestMapping("/updateBranchView")
	public @ResponseBody BranchVo updatBranchView(@RequestBody BranchCustom condition){
		BranchVo branchVo = new BranchVo();
		branchVo = branchService.updateBranchView(condition.getBranchid());
		return branchVo;
	}
	/**
	 * 修改分店信息
	 * @param branch
	 * @return
	 */
	@RequestMapping("/updateBranch")
	public @ResponseBody ShowMessage updatBranch(@RequestBody BranchCustom branch){
		ShowMessage showMessage = new ShowMessage();
		String message = null;
		if(branchService.updateBranch(branch)){
			message = "修改成功";
		}else{
			message = "修改失败";
		}
		
		showMessage.setMessage(message);
		return showMessage;
	}
	
	/**
	 * 加载添加分店页面数据
	 * @return
	 */
	@RequestMapping("/addBranchView")
	public @ResponseBody BranchVo addBranchView(){
		
		BranchVo branchVo = new BranchVo();
		branchVo = branchService.addBranchView();
		
		return branchVo;
	}
	
	/**
	 * 分店添加
	 * @return
	 */
	@RequestMapping("/addBranch")
	public @ResponseBody ShowMessage addBranch(@RequestBody BranchCustom branchInfo){
		
		ShowMessage showMessage = new ShowMessage();
		String message = null;
		if(branchService.addBranch(branchInfo)){
			message = "修改成功";
		}else{
			message = "修改失败";
		}
		
		showMessage.setMessage(message);
		return showMessage;
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
	 * 查询所有活动类型（小）
	 * @return
	 */
	@RequestMapping("/queryAllActivityType")
	public @ResponseBody List<ActivitytypeCustom> queryAllActivityType(){
		List<ActivitytypeCustom> allActivitytype = new ArrayList<ActivitytypeCustom>();
		allActivitytype = activitytypeService.querySimallactivitytype();
		return allActivitytype;
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
	
	/**
	 * 查询所有活动
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryAllActivitys")
	public @ResponseBody ActivityVo queryAllActivitys(@RequestBody ActivityCustom condition){
		ActivityVo activityVo = new ActivityVo();
		activityVo = activityService.queryActivityByCondition(condition);
		return activityVo;
	}
	
	/**
	 * 查询所有分店（制作报表）
	 * @param custom
	 * @return
	 */
	@RequestMapping("/queryAllbranchs")
	public @ResponseBody BranchVo queryAllbranchs(@RequestBody BranchCustom custom){
		BranchVo branchVo = new BranchVo();
		branchVo = branchService.queryBranchByCustom(custom);
		return branchVo;
	}
	
	@RequestMapping(value = "/oneproductReport")
	public String productchart(HttpServletRequest request,Model model,Integer id){
		Product productname = ceoService.findProductById(id);
		model.addAttribute("productname",productname);
		return "admin/page/oneproductReport";
	}
	@RequestMapping(value = "/oneactivityReport")
	public String activityString(Integer id,Model model){
		List<CeoActivityreport> oneList = ceoService.findActivityreportById(id);
		model.addAttribute("oneList",oneList);
		return "admin/page/oneactivityReport";
	}
	
	/**
	 * 查询产品详细信息
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryProductInfo")
	public @ResponseBody ProductCustom queryProductInfo(@RequestBody ProductCustom condition){
		if(condition == null) return null;
		if(condition.getProductid() == null) return null;
		ProductCustom productInfo = new ProductCustom();
		productInfo = productService.queryProductInfoByProductid(condition.getProductid());
		return productInfo;
	}
	
	/**
	 * 加载修改商品数据
	 * @param condition
	 * @return
	 */
	@RequestMapping("/updateProductView")
	public @ResponseBody ProductVo updateProductView(@RequestBody ProductCustom condition){
		if(condition == null) return null;
		if(condition.getProductid() == null) return null;
		ProductVo productVo = new ProductVo();
		productVo = productService.updateProductView(condition.getProductid());
		return productVo;
	}
	
	/**
	 * 加载商品类型 点击事件
	 * @param condition
	 * @return
	 */
	@RequestMapping("/updateProductType")
	public @ResponseBody List<ProducttypeCustom> updateProductType(@RequestBody ProducttypeCustom condition){
		List<ProducttypeCustom> list= new ArrayList<ProducttypeCustom>();
		if(condition == null) return null;
		if(condition.getProducttypeid() == null || condition.getProducttypeid() < 0) return null;
		list = productTypeService.queryProductTypeByFatherId(condition.getProducttypeid());
		return list;
	}
	
	/**
	 * 修改商品
	 * @param condition
	 * @return
	 */
	@RequestMapping("/updateProduct")
	public String updateProduct(Model model,ProductCustom info,MultipartFile pictureUpload){
		if(info == null) return null;
		if(info.getProductid() == null) return "admin/page/mallInfo";
		
		if(productService.updateProduct(info,pictureUpload)){
			model.addAttribute("message", "修改成功");
		}else{
			model.addAttribute("message", "修改失败");
		}
		return "redirect:/jsp/admin/page/productInfo.jsp?productidid="+info.getProductid();
	}
	
	/**
	 * 加载修改商品数据
	 * @param condition
	 * @return
	 */
	@RequestMapping("/addProductView")
	public @ResponseBody List<ProducttypeCustom> addProductView(){
		
		List<ProducttypeCustom> list = new ArrayList<ProducttypeCustom>();
		list = productTypeService.queryFatherType();
		
		return list;
	}
	
	/**
	 * 添加商品
	 * @param condition
	 * @return
	 */
	@RequestMapping("/addProduct")
	public String addProduct(Model model,ProductCustom productInfo,MultipartFile pictureUpload){
		if(productInfo == null) return "admin/page/addProduct";
		
		model.addAttribute("brnchid", productInfo.getBranchid());
		if(productService.addProduct(productInfo, pictureUpload)){
			//model.addAttribute("message", "修改成功");
		}else{
			//model.addAttribute("message", "修改失败");
		}
		
		return "redirect:/jsp/admin/page/addProduct.jsp";
	}
	
	/**
	 * 删除商品
	 * @return
	 */
	@RequestMapping("/deleteProduct")
	public @ResponseBody ShowMessage deleteProduct(@RequestBody Integer productid){
		ShowMessage message = new ShowMessage();
		if(productService.deleteProduct(productid)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
			message.setMessage("删除失败");
		}
		return message;
	}
	
	/**
	 * 查询用户交易表
	 * @return
	 */
	@RequestMapping("/queryAllRecord")
	public @ResponseBody TransactionVo queryAllRecord(@RequestBody TransactionCustom condition){
		//检查管理员是否登录......
		//代码
		if(condition == null) return null;
		TransactionVo transactionVo = new TransactionVo();
		transactionVo = transactionService.queryAllRecordByCondition(condition);
		return transactionVo;
	}
	
	/**
	 * 进入修改用户交易表
	 * @return
	 */
	@RequestMapping("/updateTransationRecordView")
	public @ResponseBody TransactionCustom updateTransationRecordView(@RequestBody TransactionCustom condition){
		if(condition == null) return null;
		if(condition.getTransactionid() == null || condition.getTransactionid() < 0) return null;
		TransactionCustom info = transactionService.queryRecordInfoById(condition.getTransactionid());
		return info;
	}
	
	/**
	 * 修改用户交易表
	 * @return
	 */
	@RequestMapping("/updateTransationRecord")
	public @ResponseBody ShowMessage updateTransationRecord(@RequestBody TransactionCustom info){
		if(info == null) return null;
		if(info.getTransactionid() == null || info.getTransactionid() < 0) return null;
		ShowMessage showMessage = new ShowMessage();
		String message = null;
		if(transactionService.updateRecordInfoById(info)){
			message = "修改成功";
		}else{
			message = "修改失败";
		}
		
		showMessage.setMessage(message);
		return showMessage;
	}
	
	/**
	 * 删除用户交易表
	 * @return
	 */
	@RequestMapping("/deleteTransation")
	public @ResponseBody ShowMessage deleteTransation(@RequestBody Integer transactionid){
		ShowMessage message = new ShowMessage();
		if(transactionService.deleteRecord(transactionid)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
			message.setMessage("删除失败");
		}
		return message;
	}
	
	/**
	 * 查询所有回访记录
	 * @return
	 */
	@RequestMapping("/queryAllReturnRecord")
	public @ResponseBody ReturnvisitVo queryAllReturnRecord(@RequestBody ReturnvisitCustom condition){
		if(condition == null ) return null;
		ReturnvisitVo returnvisitVo = new ReturnvisitVo();
		returnvisitVo = returnvisitService.queryAllRecordByCondition(condition);
		return returnvisitVo;
	}
	
	/**
	 * 加载进入修改回访的数据
	 * @return
	 */
	@RequestMapping("/updateReturnRecordView")
	public @ResponseBody ReturnvisitCustom updateReturnRecordView(@RequestBody ReturnvisitCustom condition){
		if(condition == null ) return null;
		
		ReturnvisitCustom info = new ReturnvisitCustom();
		info = returnvisitService.queryRecordInfoById(condition.getReturnvisitid());
		
		return info;
	}
	
	/**
	 * 修改回访的数据
	 * @return
	 */
	@RequestMapping("/updateReturnRecord")
	public @ResponseBody ShowMessage updateReturnRecord(@RequestBody ReturnvisitCustom info){
		if(info == null ) return null;
		ShowMessage showMessage = new ShowMessage();
		String message = null;
		if(returnvisitService.updateRecordInfoById(info)){
			message = "修改成功";
		}else{
			message = "修改失败";
		}
		showMessage.setMessage(message);
		return showMessage;
	}
	
	/**
	 * 删除回访记录
	 * @return
	 */
	@RequestMapping("/deleteReturnRecord")
	public @ResponseBody ShowMessage deleteReturnRecord(@RequestBody Integer returnvisitid){
		ShowMessage message = new ShowMessage();
		if(returnvisitService.deleteRecord(returnvisitid)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
			message.setMessage("删除失败");
		}
		return message;
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 * 未启用
	 * 删除用户留言
	 * @return
	 */
	@RequestMapping("/deleteMessage")
	public @ResponseBody ShowMessage deleteMessage(@RequestBody Integer messageid){
		ShowMessage message = new ShowMessage();
		if(messageService.deleteMessage(messageid)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
			message.setMessage("删除失败");
		}
		return message;
	}
	
	
	/**
	 * 查询商品的报表
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryProductReport")
	public @ResponseBody Map<String, String[]> queryProductReport(@RequestBody ProducttransactionreportCustom condition){
		
		Map<String, String[]> map = new TreeMap<String, String[]>();
		
		map = reportService.queryProductReportByTimeInterval(condition);
		
		return map;
	}
	
	/**
	 * 添加商品大类型
	 * @param condition
	 * @return
	 */
	@RequestMapping("/addProductFather")
	public @ResponseBody ShowMessage addProductFather(@RequestBody String addfatherType){
		ShowMessage message = new ShowMessage();
		
		if(productTypeService.addProductFather(addfatherType)){
			message.setFlag(true);
			message.setMessage("添加成功");
		}else{
			message.setFlag(false);
			message.setMessage("添加失败");
		}
		
		return message;
	}
	
	/**
	 * 添加商品类型
	 * @param condition
	 * @return
	 */
	@RequestMapping("/addProductType")
	public @ResponseBody ShowMessage addProductType(@RequestBody ProducttypeCustom record){
		ShowMessage message = new ShowMessage();
		
		if(productTypeService.addProductType(record)){
			message.setFlag(true);
			message.setMessage("添加成功");
		}else{
			message.setFlag(false);
			message.setMessage("添加失败");
		}
		
		return message;
	}
	
	/**
	 * 查询某用户的可用积分
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryIntegral")
	public @ResponseBody IntegralCustom queryIntegral(@RequestBody Integer userid){
		if(userid == null) return null;
		
		IntegralCustom condition = new IntegralCustom();
		IntegralCustom info = new IntegralCustom();
		condition.setUserid(userid);
		info = integralService.queryUpToDateRecord(condition);
		
		return info;
	}
}
