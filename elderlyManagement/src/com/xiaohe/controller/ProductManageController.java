package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductcolourCustom;
import com.xiaohe.bean.Productrecommend;
import com.xiaohe.bean.ProducttasteCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.service.ProdcutColorService;
import com.xiaohe.service.ProductManageService;
import com.xiaohe.service.ProductRecommendService;
import com.xiaohe.service.ProductService;
import com.xiaohe.service.ProducttasteService;

@Controller
@RequestMapping("/productmanage")
public class ProductManageController {
	@Autowired
	@Qualifier("productManageService")
	private ProductManageService productManageService;
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("producttasteService")
	private ProducttasteService producttasteService;
	
	@Autowired
	@Qualifier("prodcutColorService")
	private ProdcutColorService prodcutColorService;
	

	@Autowired
	@Qualifier("productRecommendService")
	private ProductRecommendService productRecommendService;
	

public EmployeeCustom getAdmins(HttpServletRequest request){
		
		return (EmployeeCustom) request.getSession().getAttribute("admins");
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
	
	public String addProduct(Model model,MultipartFile pictureUpload,HttpServletRequest request, @Validated ProductCustom productInfo,BindingResult bindingResult ){
		
		if(productInfo == null) return "productmanage/page/insertproduct";
				productInfo.setBranchid(( getAdmins(request)).getBranchId());
				
			if(productService.addProduct(productInfo, pictureUpload)){
				
				model.addAttribute("message", "修改成功");
				
			}else{
				model.addAttribute("message", "修改失败");
			}
			
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
	public String  updateProduct( Product product, HttpServletRequest request) throws Exception{

	
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
	public String productInfo(Integer productid, Model model) throws Exception{
		Product product=productManageService.quertyProduct(productid);
		if (product.getProducttypeid()==7) {
			List<ProducttasteCustom> taste=producttasteService.quertyProductByid(productid);
			model.addAttribute("taste", taste);
			return"/productmanage/page/producttasteInfo";
		}else if (product.getProducttypeid()==10) {
			List<ProductcolourCustom> Color=prodcutColorService.findProductColorAndSize(productid);
			model.addAttribute("Color", Color);
			return"/productmanage/page/productcolorInfo";
		}
		Product list = productManageService.quertyProduct(productid);
		model.addAttribute("list", list);
		return null;
	}
	
	//热门商品
	@RequestMapping(value="quertyPopularProduct")
		public String quertyPopularProduct(ProductCustom productCustom,Model model){
		List<ProductCustom> popularProduct=new ArrayList<ProductCustom>();//热门产品
		popularProduct=productService.queryPopularProductByCondition(productCustom);
		model.addAttribute("popularProduct", popularProduct);
		return"/productmanage/page/popularproduct";
	}
	
	
	//缺货信息
	@RequestMapping(value="stockout")
	public String quertyStockout(Model model) {
		List<ProductCustom> stockout=productService.quertyStockout();
		model.addAttribute("stockout", stockout);
		return"/productmanage/page/productStockout";
	}
	
	
	//商品推荐
		@RequestMapping("productRecommend")
		public String productRecommed(Integer productid,HttpServletRequest request) throws Exception{
				//首次进入无任何推荐商品
			if (productRecommendService.sumProductRecommend((getAdmins(request)).getBranchId())==0) {
				Productrecommend productrecommend = new Productrecommend();
				productrecommend.setBranchid(( getAdmins(request)).getBranchId());
				productrecommend.setProductshow(true);
				productrecommend.setProductid(productid);
				productRecommendService.insertProductRecommend(productrecommend);
			}else if (productRecommendService.sumProductRecommend((getAdmins(request)).getBranchId())>=3){
		
			
			}
			return"redirect:/productmanage/NoproductRecommend.action";
			
			
		}
	
	//本店推荐查询
	
	@RequestMapping("recommendproduct")
	public String  quertyRecommendProduct(Model model ,HttpServletRequest request)
	{	List<ProductCustom>  recommendproduct =productManageService.quertyRecommendProduct(( getAdmins(request)).getBranchId());
			model.addAttribute("recommendproduct", recommendproduct);
		return"/productmanage/page/recommendproduct";
		
	}
	
@RequestMapping(value="/NoproductRecommend")
	
	public String noProductRecommdend(Model model,HttpServletRequest request) throws Exception{
		
		if (productRecommendService.sumProductRecommend((getAdmins(request)).getBranchId())==0) {
			List<ProductCustom> recommendproduct = productManageService.quertyAllProduct(( getAdmins(request)).getBranchId());
			model.addAttribute("recommendproduct", recommendproduct);
			return"/productmanage/page/recommendproduct";
		}else if (productRecommendService.sumProductRecommend((getAdmins(request)).getBranchId())>=3) {
			List<ProductCustom>  recommendproduct =productManageService.quertyRecommendProduct(( getAdmins(request)).getBranchId());
	/*	List<ProductCustom>  recommendproduct = productService.quertyNoBranchRecommendProduct(( getAdmins(request)).getBranchId());*/
		model.addAttribute("recommendproduct", recommendproduct);
		return"/productmanage/page/recommendproduct";
		}
		List<ProductCustom> recommendproduct = productManageService.quertyAllProduct(( getAdmins(request)).getBranchId());
		return "/productmanage/page/recommendproduct";
		
	}
	
	
	@RequestMapping("/loginout")
	public String logOut(HttpSession session){
		session.invalidate();
		return"/AdminLogin/login";
	}
	
	
	
	
	
	
	
	
}
