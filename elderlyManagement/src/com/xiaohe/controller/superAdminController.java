package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityVo;
import com.xiaohe.bean.AddEmployeeVo;
import com.xiaohe.bean.AddUserVo;
import com.xiaohe.bean.AreaCustom;
import com.xiaohe.bean.AuthorityCustom;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.EmployeeVo;
import com.xiaohe.bean.LevelCustom;
import com.xiaohe.bean.Positional;
import com.xiaohe.bean.PositionalCustom;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;
import com.xiaohe.service.ActivityService;
import com.xiaohe.service.AreaService;
import com.xiaohe.service.AuthorityService;
import com.xiaohe.service.BranchService;
import com.xiaohe.service.EmployeeService;
import com.xiaohe.service.LevelSevice;
import com.xiaohe.service.PositionalSerice;
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
	public String updateUserInfo(UserCustom userInfo,Model model){
		String message = null;
		if(userService.UpdateUserInfoByUser(userInfo)){
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
	public String updateEmployeeInfo(EmployeeCustom employeeInfo,Model model){
		String message = null;
		if(employeeService.UpdateUserInfoByUser(employeeInfo)){
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
	 * @paramcondition
	 * @return
	 */
	@RequestMapping("/queryAllActivity")
	public @ResponseBody ActivityVo queryAllActivity(@RequestBody ActivityCustom condition){
		
		ActivityVo activityVo = activityService.queryAllActivityByCondition(condition);
		return activityVo;
	}
}
