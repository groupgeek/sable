package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.service.ProductManageService;
import com.xiaohe.service.ProductService;

@Controller
@RequestMapping("/productmanage")
public class ProductManageController {
	@Autowired
	@Qualifier("productManageService")
	private ProductManageService productManageService;
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	
	@RequestMapping(value="quertyProduct")
	public String quertyAllProduct(Integer branchid,Model model) throws Exception {
		
		List<ProductCustom> product = productManageService.quertyAllProduct(branchid);
		model.addAttribute("product", product);
		return "productmanage/table";
		}
	
	@RequestMapping(value="productAdminLogin")
public String  productManageAdminsLogin(EmployeeCustom employeeCustom,HttpServletRequest request,Model model) throws Exception {
	EmployeeCustom  admins = productManageService.productManageAdminsLogin(employeeCustom);

	if (admins == null) {

		model.addAttribute("message", "登录失败,手机号码或者密码错误0.0");

		return "logReg/login";
	} else {
		request.getSession().setAttribute("admins", admins);
		productManageService.quertyAllProduct(admins.getBranchId());
		return"redirect:/product/allProdcut.action";
	}
		}
	
	@RequestMapping("deleteproduct")
	public String  deleteProduct(Integer productid,HttpServletRequest request) throws Exception{
			productManageService.deleteProduct(productid);
		return"redirect:/productmanage/quertyProduct.action";
	}
	
	@RequestMapping("insertproduct")
	public String  insertProduct(ProductCustom productCustom,HttpServletRequest request,Model model) throws Exception{
		
		productManageService.insertProduct(productCustom);
		return"redirect:/product/allProdcut.action";
		
	}
	
	@RequestMapping(value="producttype")
	public String  productType(Model model){
		List<ProducttypeCustom> productTypes = new ArrayList<ProducttypeCustom>();
		//查询所有商品类型
		productTypes = productService.queryProductTypeByCondition(null);
		model.addAttribute("productTypes", productTypes);
		return"productmanage/form-controls";
		
	}
	
}
