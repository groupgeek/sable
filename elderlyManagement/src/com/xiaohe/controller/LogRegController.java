package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.AreaCustom;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.AreaService;
import com.xiaohe.service.UserService;

@Controller
@RequestMapping("/logReg")
public class LogRegController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("areaService")
	private AreaService areaService;
	
	
	@RequestMapping("/sinup")
	public String sinUp(Model model){
		AreaCustom condition = new AreaCustom();
		List<AreaCustom> allAreas = new ArrayList<AreaCustom>();
		allAreas = areaService.queryAreas(condition);
		model.addAttribute("allAreas", allAreas);
		return "logReg/sign-up";
	}

	@RequestMapping("/register")
	public String registerUser(HttpServletRequest request,
			UserCustom userCustom, Model model) {
		if (userService.registerUser(userCustom)) {

			request.getSession().setAttribute("user", userCustom);

			return "redirect:/branch/index.action";
		} else {

			model.addAttribute("message", "注册失败,手机号码已经被注册0.0");

			return "redirect:logReg/sinup.action";
		}

	}

	@RequestMapping("/login")
	public String loginUser(HttpServletRequest request, UserCustom userCustom,
			Model model) {
		UserCustom  user = userService.loginUser(userCustom);

		if (user == null) {

			model.addAttribute("message", "登录失败,手机号码或者密码错误0.0");

			return "logReg/login";
		} else {

			
			request.getSession().setAttribute("user", user);
			return "redirect:/branch/index.action";
		}

	}
}
