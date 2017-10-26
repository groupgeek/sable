package com.xiaohe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.EvaluationVo;
import com.xiaohe.bean.UserCustom;

@Controller
@RequestMapping("/superAdmin")
public class superAdminController {
	
	@RequestMapping("/test")
	public @ResponseBody UserCustom queryEvaluation(@RequestBody UserCustom text){
		
		
		System.out.println("***************");
		return text;
	}

}
