package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.EvaluationVo;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductrecommendCustom;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.mapper.ProducttypeMapper;
import com.xiaohe.service.ProductService;
import com.xiaohe.service.ProductTypeService;
import com.xiaohe.service.ProducttransactionreportService;


@Controller
@RequestMapping("/product")
public class MallController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("producttypeMapper")
	private ProducttypeMapper producttypeMapper;
	
	@Autowired
	@Qualifier("producttransactionreportService")
	private ProducttransactionreportService producttransactionreportService;
	
	@Autowired
	@Qualifier("productTypeService")
	private ProductTypeService productTypeService;
	
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
		 * 分类的产品 allTypeProducts
		 */
		List<ProducttypeCustom> productTypes = new ArrayList<ProducttypeCustom>();
		List<ProductCustom> productrecommends = new ArrayList<ProductCustom>();
		List<ProductCustom> productDiscounts = new ArrayList<ProductCustom>();
		Map<ProducttypeCustom, List<ProductCustom>> allTypeProducts = new HashMap<ProducttypeCustom, List<ProductCustom>>();
		
		
		//查询所有商品类型
		productTypes = productTypeService.querySimallProducttype();
		
		//查询推荐商品
		productrecommends = productService.queryProductrecommend(3);
		
		//查询优惠商品
		productDiscounts = productService.queryDiscountProduct(4);
		
		//开始查询所有分类的产品
		ProductCustom condition = new ProductCustom();
		condition.setBegin(0);
		condition.setTotal(7);
		allTypeProducts = productService.queryProductByAllType(condition);
		
		
		model.addAttribute("productTypes", productTypes);
		model.addAttribute("productrecommends", productrecommends);
		model.addAttribute("productDiscounts", productDiscounts);
		model.addAttribute("allTypeProducts", allTypeProducts);
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
	 * value="/productInfo",method = RequestMethod.POST
	 * 加载商品详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/productInfo")
	public String productInfo(Model model,Integer id){
		
		/**
		 * productInfo 产品详细信息
		 * similarProducts 同类商品
		 * salesThisMonth 本月销量
		 * sales 总销量
		 */
		ProductCustom productInfo = new ProductCustom();
		
		List<ProductCustom> similarProducts = new ArrayList<ProductCustom>();
		
		/*if(productInfo == null){
			return 商品丢失页面
		}*/
		
		/**
		 * 开始查询商品详细信息
		 */
		productInfo = productService.queryProductInfoById(id);
		
		/**
		 * 开始查询商品同类产品
		 */
		ProductCustom condition = new ProductCustom();
		condition.setProductid(id);
		condition.setBegin(0);
		condition.setTotal(4);
		similarProducts = productService.querySimilarProductsByProductId(condition);
		
		/**
		 * 开始查询本月销量
		 */
		ProducttransactionreportCustom conditionSales = new ProducttransactionreportCustom();
		Date end = new Date();
		Date start = new Date();
		start.setYear(end.getYear());
		start.setMonth(end.getMonth());
		start.setDate(1);
		start.setHours(0);
		start.setMinutes(0);
		end.setDate(31);
		end.setHours(0);
		end.setMinutes(0);
		
		conditionSales.setStartingTime(start);
		conditionSales.setEndTime(end);
		
		conditionSales.setProductid(id);
		ProducttransactionreportCustom salesThisMonth = producttransactionreportService.statisticsProductSalesByIdAndTime(conditionSales);
		
		/**
		 * 开始查询总销量
		 */
		ProducttransactionreportCustom sales = producttransactionreportService.statisticsProductSalesByProductId(id);
		
		/**
		 * 查询总评价数
		 */
		EvaluationCustom allEvaluationCustom = productService.queryEvaluationLevalByProductId(id);
		Integer allEvaluation = allEvaluationCustom.getPraise()+allEvaluationCustom.getAverage()+allEvaluationCustom.getBadReview();
		
		
		model.addAttribute("productInfo", productInfo);
		model.addAttribute("similarProducts", similarProducts);
		model.addAttribute("salesThisMonth", salesThisMonth);
		model.addAttribute("sales", sales);
		model.addAttribute("allEvaluation", allEvaluation);
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
	
	/**
	 * 查询评价
	 * @param evaluationCustom
	 * @return
	 */
	@RequestMapping("/queryEvaluation")
	public @ResponseBody EvaluationVo queryEvaluation(@RequestBody EvaluationCustom evaluationCustom){
		EvaluationVo evaluationVo = new EvaluationVo();
		evaluationVo.setEvaluationsList(productService.queryEvaluationByProductId(evaluationCustom));
		evaluationVo.setPageSum(productService.queryEvaluationSum(evaluationCustom.getProductid()));
		evaluationVo.setEvaluation(productService.queryEvaluationLevalByProductId(evaluationCustom.getProductid()));
		return evaluationVo;
	}
	
	/**
	 * 商城首页的分类导航商品展示
	 * @param producttype
	 * @return
	 */
	@RequestMapping("/quereyProduct_json")
	public @ResponseBody List<ProductCustom> quereyProductByProductTypeId_json(@RequestBody ProducttypeCustom producttype){
		List<ProductCustom> pList = new ArrayList<ProductCustom>();
		ProductCustom condition = new ProductCustom();
		condition.setBegin(0);
		condition.setTotal(20);
		condition.setProducttypeid(producttype.getProducttypeid());
		pList = productService.queryProductByTypeId(condition);
		return pList;
	}
}
