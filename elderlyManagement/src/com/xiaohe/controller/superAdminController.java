package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.EvaluationVo;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;
import com.xiaohe.service.UserService;

@Controller
@RequestMapping("/superAdmin")
public class superAdminController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping("/test")
	public @ResponseBody UserCustom queryEvaluation(@RequestBody UserCustom text){
		
		
		System.out.println("***************");
		return text;
	}

	
	
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

	
}
