package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.CommonsenseCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.User;
import com.xiaohe.mapper.MessageMapper;
import com.xiaohe.service.ActivityService;
import com.xiaohe.service.CommonsenseService;
import com.xiaohe.service.ProductService;

@Controller
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("commonsenseService")
	private CommonsenseService commonsenseService;
	
	@Autowired
	@Qualifier("messageMapper")
	private MessageMapper messageMapper;
	
	
	public User getUser(HttpServletRequest request){
		
		return (User) request.getSession().getAttribute("user");
	}
	
	@RequestMapping("index")
	public String index(Model model,HttpServletRequest request){
		List<ActivityCustom> activities = new ArrayList<ActivityCustom>();
		List<ProductCustom> productCustoms = new ArrayList<ProductCustom>();
		List<CommonsenseCustom> commonsenseCustoms = new ArrayList<CommonsenseCustom>();//小常识
		List<CommonsenseCustom> heartCustoms = new ArrayList<CommonsenseCustom>();//心灵鸡汤
		
		/**
		 * 开始查询推荐活动
		 */
		activities = activityService.queryActivityrecommend("分店官网");
		
		/**
		 * 推荐的商品 根据商品的购买次数推荐
		 */
		ProductCustom productCustom = new ProductCustom();
		productCustom.setAreaid(getUser(request).getAreaid());
		//productCustom.setAreaid(1);
		productCustom.setBegin(0);
		productCustom.setTotal(3);
		productCustoms = productService.queryPopularProductByCondition(productCustom);
		
		/**
		 * 养生小常识 心灵鸡汤 
		 */
		CommonsenseCustom commonsenseCustom = new CommonsenseCustom();
		commonsenseCustom.setBegin(0);
		commonsenseCustom.setTotal(3);
		commonsenseCustom.setWebsitetype("分店官网");
		
		commonsenseCustom.setContexttype("养生小常识");
		commonsenseCustoms = commonsenseService.queryCommonsenseByCondition(commonsenseCustom);
		
		commonsenseCustom.setContexttype("心灵鸡汤");
		heartCustoms = commonsenseService.queryCommonsenseByCondition(commonsenseCustom);
		
		
		model.addAttribute("productCustoms", productCustoms);
		model.addAttribute("activities", activities);
		model.addAttribute("commonsenseCustoms", commonsenseCustoms);
		model.addAttribute("heartCustoms", heartCustoms);
		return "index/branchIndex";
	}
	
	@RequestMapping("sendMessage")
	public @ResponseBody MessageCustom sendMessage(@RequestBody MessageCustom message, 
			HttpServletRequest request){
		message.setMessagetime(new Date());
		message.setUserid(/*getUser(request).getUserid()*/1);
		message.setMessagecontext(message.getMessagecontext());
		messageMapper.insertSelective(message);
		return message;
	}

}
