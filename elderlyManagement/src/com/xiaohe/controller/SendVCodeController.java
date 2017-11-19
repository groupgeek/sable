package com.xiaohe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.ShowMessage;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.service.UserService;

@Controller
@RequestMapping("/send")
public class SendVCodeController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	/**
	 * 发送手机验证码
	 * @param phone
	 * @return
	 */
	@RequestMapping("/sendVCode")
	public @ResponseBody ShowMessage sendVCode(@RequestBody String phone){
		ShowMessage message = new ShowMessage();
		
		String vcode = userService.sendUserVCode(phone);
		if(vcode == null){
			message.setFlag(false);
		}else{
			message.setMessage(vcode);
			message.setFlag(true);
		}
		
		return message;
	}
	
	/**
	 * 更改短信验证码的状态
	 * @param phone
	 * @return
	 */
	@RequestMapping("/updateVcodeStasus")
	public @ResponseBody ShowMessage updateVcodeStasus(@RequestBody String phone){
		
		ShowMessage message = new ShowMessage();
		
		if(userService.updateVcodeStasus(phone)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
		}
		
		return message;
	}

	/**
	 * 重置密码
	 * @param info 里面有phone newPassword
	 * @return
	 */
	@RequestMapping("/retrieveThePassword")
	public @ResponseBody ShowMessage retrieveThePassword(@RequestBody UserCustom info){
		ShowMessage message = new ShowMessage();
		if(userService.retrieveThePassword(info)){
			message.setFlag(true);
		}else{
			message.setFlag(false);
		}
		
		return message;
	}
}
