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

import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductrecommendCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.mapper.ProducttypeMapper;
import com.xiaohe.service.ProductService;


@Controller
@RequestMapping("/product")
public class MallController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("producttypeMapper")
	private ProducttypeMapper producttypeMapper;
	
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
		 * 模糊查询商品 blurryProductCustoms
		 * 产品类型 producttypeCustoms
		 */
		List<ProductCustom> blurryProductCustoms = new ArrayList<ProductCustom>();
		List<ProducttypeCustom> producttypeCustoms = new ArrayList<ProducttypeCustom>();
		
		
		
		//开始模糊查询
		blurryProductCustoms = productService.queryProductByBlurry(searchCondition);
		//开始查询商品类型
		ProducttypeCustom producttype = new ProducttypeCustom();
		producttype.setFatherid(0);
		producttypeCustoms = productService.queryProductTypeByCondition(producttype);
		
		model.addAttribute("blurryProductCustoms", blurryProductCustoms);
		//传递模糊查询参数
		model.addAttribute("searchCondition", searchCondition);
		model.addAttribute("producttypeCustoms", producttypeCustoms);
		return "mall/home/search";
	}
	
	@RequestMapping("/queryProducttype_json.action")
	public @ResponseBody List<ProducttypeCustom> queryProducttype_json(@RequestBody ProducttypeCustom producttype,
			HttpServletRequest request){
		return producttypeMapper.selectProductTypeByFatherId(producttype);
	}
	
	
}
