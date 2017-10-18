package com.xiaohe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.UserService;

@Controller
@RequestMapping("/logReg")
public class LogRegController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping("/register")
	public String registerUser(HttpServletRequest request,
			UserCustom userCustom, Model model) {
		if (userService.registerUser(userCustom)) {

			request.getSession().setAttribute("user", userCustom);

			return "redirect:/branch/index.action";
		} else {

			model.addAttribute("message", "注册失败,手机号码已经被注册0.0");

			return "logReg/sin-up";
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

			
			request.getSession().setAttribute("user", userCustom);
			return "redirect:/branch/index.action";
		}

	}
}
