package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.service.ProductManageService;
import com.xiaohe.service.ProductService;
/*import com.xiaohe.service.ProducttasteService;*/

@Controller
@RequestMapping("/productmanage")
public class ProductManageController {
	@Autowired
	@Qualifier("productManageService")
	private ProductManageService productManageService;
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	/*@Autowired
	@Qualifier("producttasteService")
	private ProducttasteService producttasteService;*/
	
public EmployeeCustom getAdmins(HttpServletRequest request){
		
		return (EmployeeCustom) request.getSession().getAttribute("admins");
	}
	
	
@RequestMapping(value="productAdminLogin")
public String  productManageAdminsLogin(EmployeeCustom employeeCustom,HttpServletRequest request) throws Exception {
		EmployeeCustom  admins = productManageService.productManageAdminsLogin(employeeCustom);
		request.getSession().setAttribute("admins", admins);
	if (admins == null) {
		return "productmanage/login/login";
} else if (admins
			.getAuthorityid()==2) {
		/*System.out.println(admins.getAuthority()+"------------------------");*/
		//编辑员跳转页面'
		
		return "null";
	}else if (admins.getAuthorityid()==3) {System.out.println(admins.getAuthorityid()+"dsds-----------------------");
		//送货员跳转
		return null;
	}else if (admins.getAuthorityid()==4) {System.out.println(admins.getAuthorityid()+"----adada--------------------");
		//商品管理跳转
		return"redirect:/productmanage/quertyProduct.action.action";
	}else if (admins.getAuthorityid()==5) {System.out.println(admins.getAuthorityid()+"-----adas-------------------");
		//分店管理跳转
		return"redirect:/brach/index.action";
	}else if (admins.getAuthorityid()==6) {System.out.println(admins.getAuthorityid()+"----adad--------------------");
		//ECO跳转
		return"null";
	}else if (admins.getAuthorityid()==7) {System.out.println(admins.getAuthorityid()+"----faefawef--------------------");
		//超级管理员跳转
		return"null";
	}
	System.out.println(admins.getEmployeeid());
	System.out.println(admins.getPassword());
	return null;
		}
	

	@RequestMapping(value="quertyProduct")
	public  String quertyAllProduct( Model model,HttpServletRequest request) throws Exception {
	
		List<ProductCustom> product = productManageService.quertyAllProduct(( getAdmins(request)).getBranchId());
		model.addAttribute("product", product);
		return "productmanage/page/productadmin";
		
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
		return"productmanage/page/insertproduct";
		
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
		request.setAttribute("product", product);
		return"productmanage/page/productinfo";
	}
	
	//产品详细信息包括产品分类信息 
	@RequestMapping(value="productInfo")
	public String productInfo(Integer productid ) throws Exception{
		Product product=productManageService.quertyProduct(productid);
		if (product.getProducttypeid()==7) {
			/*producttasteService.quertyProductByid(productid);*/
			
		}else if (product.getProducttypeid()==10) {
			/*producttasteService.quertyProductByid(productid);*/
		}
	return null;
	}
	
	
}
