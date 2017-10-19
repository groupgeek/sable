package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductrecommendCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.service.ProductService;


@Controller
@RequestMapping("/product")
public class MallController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@RequestMapping("mallIndex")
	public String mallIndex(Model model){
		/**
		 * 变量区
		 * 产品类型 productTypes
		 * 推荐商品 productrecommends
		 * 优惠商品 productDiscountCustoms
		 */
		List<ProducttypeCustom> productTypes = new ArrayList<ProducttypeCustom>();
		List<ProductCustom> productrecommends = new ArrayList<ProductCustom>();
		List<ProductCustom> productDiscounts = new ArrayList<ProductCustom>();
		
		
		//查询所有商品类型
		productTypes = productService.queryProductTypeByCondition(null);
		
		//查询推荐商品
		productrecommends = productService.queryProductrecommend(3);
		
		//查询优惠商品
		productDiscounts = productService.queryDiscountProduct(4);
		
		
		model.addAttribute("productTypes", productTypes);
		model.addAttribute("productrecommends", productrecommends);
		model.addAttribute("productDiscounts", productDiscounts);
		return "mall/home/home";
	}
	
	
	@RequestMapping("/search")
	public String search(Model model,String searchCondition){
		
		/**
		 * 变量
		 * 模糊查询商品 BlurryProductCustoms
		 */
		List<ProductCustom> BlurryProductCustoms = new ArrayList<ProductCustom>();
		
		
		//开始模糊查询
		BlurryProductCustoms = productService.queryProductByBlurry(searchCondition);
		
		model.addAttribute("BlurryProductCustoms", BlurryProductCustoms);
		return "mall/home/search";
	}
	
	
}
