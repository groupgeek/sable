package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.bean.User;
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
	
public EmployeeCustom getAdmins(HttpServletRequest request){
		
		return (EmployeeCustom) request.getSession().getAttribute("admins");
	}
	
	
	@RequestMapping(value="productAdminLogin")
public String  productManageAdminsLogin(EmployeeCustom employeeCustom,HttpServletRequest request,Model model) throws Exception {
		
		EmployeeCustom  admins = productManageService.productManageAdminsLogin(employeeCustom);
	if (admins == null) {

		model.addAttribute("message", "登录失败,手机号码或者密码错误0.0");
		return "productmanage/logReg/login";
	} else {
		
		request.getSession().setAttribute("admins", admins);
		return"redirect:/productmanage/quertyProduct.action";
	}
		}
	

	@RequestMapping(value="quertyProduct")
	public String quertyAllProduct(Model model,HttpServletRequest request) throws Exception {
	
		List<ProductCustom> product = productManageService.quertyAllProduct(( getAdmins(request)).getBranchId());
		model.addAttribute("product", product);
		return "productmanage/table";
		}
	
	@RequestMapping("deleteproduct")
	public String  deleteProduct(Integer productid,HttpServletRequest request) throws Exception{
			productManageService.deleteProduct(productid);
		return"redirect:/productmanage/quertyProduct.action";
	}
	
	@RequestMapping(value="insertproduct")
	public String  insertProduct(Product product,HttpServletRequest request,Model model) throws Exception{
		
		
		product.setBranchid(getAdmins(request).getBranchId());
			productManageService.insertProduct(product);
			return"redirect:/productmanage/quertyProduct.action";
		
		
		
	}
	
	@RequestMapping(value="producttype")
	public String  productType(Model model){
		List<ProducttypeCustom> productTypes = new ArrayList<ProducttypeCustom>();
		//查询所有商品类型
		productTypes = productService.queryProductTypeByCondition(null);
		model.addAttribute("productTypes", productTypes);
		return"productmanage/form-controls";
		
	}
	
	@RequestMapping(value="update")
	public String  updateProduct(Product product, HttpServletRequest request) throws Exception{
		productManageService.updateProductCustom(product);
		return"redirect:/productmanage/quertyProduct.action";
	}
	
	//查询单个商品
	@RequestMapping(value="selectProduct")
	public String selectProduct(Integer productid,Model model ,HttpServletRequest request) throws Exception{
		Product product= productManageService.quertyProduct(productid);
		model.addAttribute("product", product);
		return"productmanage/productlist";
		
	}
}
