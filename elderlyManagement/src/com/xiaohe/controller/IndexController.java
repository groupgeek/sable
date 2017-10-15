package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.CommonsenseCustom;
import com.xiaohe.bean.Product;
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
	public String index(Model model){
		List<Product> products=new ArrayList<Product>();//热门产品
		List<ActivityCustom> activities=new ArrayList<ActivityCustom>();//活动推荐
		List<CommonsenseCustom> commonsenseCustoms = new ArrayList<CommonsenseCustom>();//小常识
		List<CommonsenseCustom> heartCustoms = new ArrayList<CommonsenseCustom>();//心灵鸡汤
		
		
		products = productService.queryPopularProductByRank(2);
		
		ActivityCustom aCustom=new ActivityCustom();
		//aCustom.setActivityid(2);
		//aCustom.setActivityname("跑");
		//aCustom.setActivitystatus("已开展");
		aCustom.setOnline(false);
		aCustom.setBranchid(1);
		aCustom.setActivitytypeid(2);
		aCustom.setBegin(0);
		aCustom.setTotal(2);
		activities=activityService.queryActivitiesByCondition(aCustom);
		
		CommonsenseCustom commonsenseCustom = new CommonsenseCustom();
		commonsenseCustom.setBegin(0);
		commonsenseCustom.setTotal(3);
		
		commonsenseCustom.setContexttype("养生小常识");
		commonsenseCustoms = commonsenseService.queryCommonsenseByCondition(commonsenseCustom);
		
		commonsenseCustom.setContexttype("心灵鸡汤");
		heartCustoms = commonsenseService.queryCommonsenseByCondition(commonsenseCustom);
		
		
		
		model.addAttribute("activities", activities);
		model.addAttribute("products", products);
		model.addAttribute("commonsenseCustoms", commonsenseCustoms);
		model.addAttribute("heartCustoms", heartCustoms);
		return "index/index";
	}

}
