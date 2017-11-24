package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.Level;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
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
	
	
	@RequestMapping(value="/log")
	public String log(HttpServletRequest request){
		UserCustom user = new UserCustom();
		user = userService.userInfo("12345678910");
		request.getSession().setAttribute("user", user);
		return "user/test";
	}
	
	@RequestMapping(value="/oneUser")
	public String oneUser(Model model,HttpServletRequest request){
		String x =((UserCustom)request.getSession().getAttribute("user")).getPhone();
		UserCustom user = new UserCustom();
		user = userService.userInfo(x);
		Level level = new Level();
		level = userService.onelevel(user.getUserid());
		model.addAttribute("level", level);
		model.addAttribute("user", user);
		return "user/userInfo";
	}
	
	@RequestMapping(value="/updateUser")
	public String updateUser(UserCustom user,MultipartFile file){
		userService.updateUser(user, file);
		return "redirect:oneUser";
	}
	
	@RequestMapping(value="/userMed")
	public String userMed(Model model,HttpServletRequest request){
		Integer id =((UserCustom)request.getSession().getAttribute("user")).getUserid();
		MedicalrecordsWithBLOBsCustom med = new MedicalrecordsWithBLOBsCustom();
		med = userService.oneMed(id);
		model.addAttribute("med", med);
		return "user/medInfo";
	}
	
	@RequestMapping(value="/userAct")
	public String userAct(HttpServletRequest request,Model model){
		Integer id =((UserCustom)request.getSession().getAttribute("user")).getUserid();
		List<ActivityCustom> allActs = new ArrayList<ActivityCustom>();
		allActs = userService.userActs(id);
		model.addAttribute("allActs", allActs);
		return "user/actInfo";
	}
	
	@RequestMapping(value="/updateMed")
	public String updateMed(MedicalrecordsWithBLOBsCustom medicalrecordsWithBLOBsCustom){
		userService.updatemed(medicalrecordsWithBLOBsCustom);
		return "redirect:userMed";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "logReg/login";
	}
	
}
