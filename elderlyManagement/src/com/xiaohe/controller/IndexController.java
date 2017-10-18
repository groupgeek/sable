package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.CommonsenseCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.User;
import com.xiaohe.service.ActivityService;
import com.xiaohe.service.CommonsenseService;
import com.xiaohe.service.ProductService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
	@Autowired
	@Qualifier("commonsenseService")
	private CommonsenseService commonsenseService;
	
	@RequestMapping("index")
	public String index(Model model,HttpServletRequest request){
		List<ProductCustom> productCustoms=new ArrayList<ProductCustom>();//热门产品
		List<ActivityCustom> activities=new ArrayList<ActivityCustom>();//活动推荐
		List<CommonsenseCustom> commonsenseCustoms = new ArrayList<CommonsenseCustom>();//小常识
		List<CommonsenseCustom> heartCustoms = new ArrayList<CommonsenseCustom>();//心灵鸡汤
		
		/**
		 * 开始查询推荐产品
		 */
		ProductCustom productCustom = new ProductCustom();
		productCustom.setBegin(0);
		productCustom.setTotal(3);
		productCustoms = productService.queryPopularProductByCondition(productCustom);
		
		//ActivityCustom aCustom=new ActivityCustom();
		//aCustom.setActivityid(2);
		//aCustom.setActivityname("跑");
		//aCustom.setActivitystatus("已开展");
		//aCustom.setOnline(false);
		//aCustom.setBranchid(1);
		//aCustom.setActivitytypeid(2);
		//aCustom.setBegin(0);
		//aCustom.setTotal(3);
		//activities=activityService.queryActivitiesByCondition(aCustom);
		/**
		 * 开始查询推荐的活动
		 */
		ActivityrecommendCustom custom = new ActivityrecommendCustom();
		custom.setWebsitetype("官网");
		activities = activityService.queryActivityrecommend(custom);
		
		CommonsenseCustom commonsenseCustom = new CommonsenseCustom();
		commonsenseCustom.setBegin(0);
		commonsenseCustom.setTotal(3);
		commonsenseCustom.setWebsitetype("官网");
		
		commonsenseCustom.setContexttype("养生小常识");
		commonsenseCustoms = commonsenseService.queryCommonsenseByCondition(commonsenseCustom);
		
		commonsenseCustom.setContexttype("心灵鸡汤");
		heartCustoms = commonsenseService.queryCommonsenseByCondition(commonsenseCustom);
		
		
		
		model.addAttribute("activities", activities);
		model.addAttribute("products", productCustoms);
		model.addAttribute("commonsenseCustoms", commonsenseCustoms);
		model.addAttribute("heartCustoms", heartCustoms);
		
		/**
		 * 模拟登陆
		 */
		User user=new User();
	    user.setUserid(1);
	    user.setUsername("bbz");
	    user.setAreaid(1);
	    request.getSession().setAttribute("user", user); 
		return "index/index";
	}

}
