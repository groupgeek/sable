package com.xiaohe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.ShowMessage;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	/**
	 * 更新用户密码
	 * @param info
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateUserPassword")
	public @ResponseBody ShowMessage updateUserPassword(@RequestBody UserCustom info , HttpServletRequest request){
		ShowMessage message = new ShowMessage();
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		info.setUserid(user.getUserid());
		
		if(userService.updateUserPassword(info)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
		}
		return message;
	}
	
	/**
	 * 擦护心购物车里面是商品数量
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryCartNum")
	public @ResponseBody Integer queryCartNum(HttpServletRequest request){
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		
		Integer num = userService.queryCartNum(user.getUserid());
		
		return num;
	}
	
}
