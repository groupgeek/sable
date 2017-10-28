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

import com.xiaohe.bean.AreaCustom;
import com.xiaohe.bean.AuthorityCustom;
import com.xiaohe.bean.BranchCustom;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.EmployeeVo;
import com.xiaohe.bean.LevelCustom;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;
import com.xiaohe.service.AreaService;
import com.xiaohe.service.AuthorityService;
import com.xiaohe.service.BranchService;
import com.xiaohe.service.EmployeeService;
import com.xiaohe.service.LevelSevice;
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
	 * 插叙所有员工
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
	
}
