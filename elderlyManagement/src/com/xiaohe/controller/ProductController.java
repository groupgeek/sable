package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.Product;
import com.xiaohe.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@RequestMapping("index")
	public String index(Model model){
		List<Product> products=new ArrayList<Product>();
		products = productService.queryPopularProductByRank(1);
		model.addAttribute("products", products);
		return "index";
	}

}
