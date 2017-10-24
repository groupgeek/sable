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

import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.EvaluationVo;
import com.xiaohe.bean.MessageCustom;
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
	
	/**
	 * 商城主页
	 * @param model
	 * @return
	 */
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
	
	
	/**
	 * 搜索框
	 * @param model
	 * @param searchCondition
	 * @return
	 */
	@RequestMapping("/search")
	public String search(Model model,String searchCondition){
		
		/**
		 * 变量
		 * 模糊查询商品 blurryProductCustoms
		 * 产品类型 producttypeCustoms
		 * 当前页 currentPage
		 */
		List<ProductCustom> blurryProductCustoms = new ArrayList<ProductCustom>();
		List<ProducttypeCustom> producttypeCustoms = new ArrayList<ProducttypeCustom>();
		Integer currentPage = 1;
		
		
		//开始模糊查询
		ProductCustom condition = new ProductCustom();
		condition.setSearch(searchCondition);
		condition.setTotal(1);
		condition.setCurrentPage(currentPage);
		int sum = productService.queryProductSumByCondition(condition)/condition.getTotal();
		
		if(productService.queryProductSumByCondition(condition)%condition.getTotal() != 0){
			sum += 1;
		}
		blurryProductCustoms = productService.queryProductByCondition(condition);
		
		
		
		//开始查询商品类型
		ProducttypeCustom producttype = new ProducttypeCustom();
		producttype.setFatherid(0);
		producttypeCustoms = productService.queryProductTypeByCondition(producttype);
		
		
		
		model.addAttribute("blurryProductCustoms", blurryProductCustoms);
		//传递模糊查询参数
		model.addAttribute("searchCondition", searchCondition);
		model.addAttribute("producttypeCustoms", producttypeCustoms);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("sum", sum);
		return "mall/home/search";
	}
	
	/**
	 * 局部更新商品类型
	 * @param producttype json数据
	 * @param request
	 * @return  List<ProducttypeCustom> json数据
	 */
	@RequestMapping("/queryProducttype_json.action")
	public @ResponseBody List<ProducttypeCustom> queryProducttype_json(@RequestBody ProducttypeCustom producttype,
			HttpServletRequest request){
		return producttypeMapper.selectProductTypeByFatherId(producttype);
	}
	
	/**
	 * 更新商品
	 * @param condition
	 * @return json数据 
	 */
	@RequestMapping("/queryProduct_json")
	public @ResponseBody List<ProductCustom> queryProduct_json(@RequestBody ProductCustom condition){
		condition.setTotal(1);
		System.out.println("sort:"+condition.getSort());
		System.out.println("name:"+condition.getProducttypename());
		List<ProductCustom> products = productService.queryProductByCondition(condition);
		return products;
	}
	
	/**
	 * 返回总页数
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryProductSum_json")
	public @ResponseBody int  queryProductSum(@RequestBody ProductCustom condition){
		condition.setTotal(1);
		int sum = productService.queryProductSumByCondition(condition)/condition.getTotal();
		
		if(productService.queryProductSumByCondition(condition)%condition.getTotal() != 0){
			sum += 1;
		}
		return sum;
	}
	
	/**
	 * 加载商品详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/productInfo")
	public String productInfo(Model model,Integer id){
		
		ProductCustom productInfo = productService.queryProductInfoById(id);
		model.addAttribute("productInfo", productInfo);
		return "mall/home/introduction";
	}
	
	/**
	 * 无用
	 * @param id
	 * @return
	 */
	@RequestMapping("/clickBuyBasket")
	public @ResponseBody int sendMessage(Integer id){
		System.out.println("**************************");
		System.out.println(id);
		return id;
	}
	
	@RequestMapping("/queryEvaluation")
	public @ResponseBody EvaluationVo queryEvaluation(@RequestBody EvaluationCustom evaluationCustom){
		EvaluationVo evaluationVo = new EvaluationVo();
		evaluationVo.setEvaluationsList(productService.queryEvaluationByProductId(evaluationCustom));
		evaluationVo.setPageSum(productService.queryEvaluationSum(evaluationCustom.getProductid()));
		evaluationVo.setEvaluation(productService.queryEvaluationLevalByProductId(evaluationCustom.getProductid()));
		return evaluationVo;
	}
	
	
}
