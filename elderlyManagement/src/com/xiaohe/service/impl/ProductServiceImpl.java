package com.xiaohe.service.impl;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.mapper.DiscountMapper;
import com.xiaohe.mapper.EvaluationMapper;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ProductrecommendMapper;
import com.xiaohe.mapper.ProducttypeMapper;
import com.xiaohe.service.ProductService;

@Repository("productService")
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	@Qualifier("productMapper")
	private ProductMapper productMapper;
	
	@Autowired
	@Qualifier("producttypeMapper")
	private ProducttypeMapper producttypeMapper;
	
	@Autowired
	@Qualifier("productrecommendMapper")
	private ProductrecommendMapper productrecommendMapper;
	
	@Autowired
	@Qualifier("discountMapper")
	private DiscountMapper discountMapper;
	
	@Autowired
	@Qualifier("evaluationMapper")
	private EvaluationMapper evaluationMapper;

	public List<ProductCustom> queryPopularProductByCondition(ProductCustom productCustom) {
		
		return productMapper.selectPopularProductByCondition(productCustom);
	}

	public List<ProducttypeCustom> queryProductTypeByCondition(
			ProducttypeCustom producttype) {
		return producttypeMapper.selectProductTypeBycondition(producttype);
	}

	public List<ProductCustom> queryProductrecommend(Integer total) {
		return productrecommendMapper.selectProductrecommend(total);
	}

	public List<ProductCustom> queryDiscountProduct(Integer total) {
		return discountMapper.selectDiscountProducts(total);
	}

	public List<ProductCustom> queryProductByBlurry(String condition) {
		return productMapper.selectProductByBlurryCondition(condition);
	}

	public List<ProductCustom> queryProductByCondition(ProductCustom condition) {
		if(condition.getCurrentPage() >= 1){
			 Integer tempBegin = (condition.getCurrentPage()-1) * condition.getTotal();
			condition.setBegin(tempBegin);
			/*condition.setSort(null);
			condition.setProducttypename(null);*/
		}
		if(condition.getProducttypename() == "" || "null".equals(condition.getProducttypename())  ){
			condition.setProducttypename(null);
		}
		if(condition.getSort() == "" || "null".equals(condition.getSort())){
			condition.setSort(null);
		}
		List<ProductCustom> listTemp = productMapper.selectProductByCondition(condition);
		return listTemp;
	}

	public Integer queryProductSumByCondition(ProductCustom condition) {

		if(condition.getProducttypename() == "" || "null".equals(condition.getProducttypename())  ){
			condition.setProducttypename(null);
		}
		if(condition.getSort() == "" || "null".equals(condition.getSort())){
			condition.setSort(null);
		}
		Integer sum = productMapper.selectProductSumByCondition(condition);
		return sum;
	}

	public ProductCustom queryProductInfoById(Integer id) {
		
		ProductCustom product= new ProductCustom();
		Product temp = productMapper.selectByPrimaryKey(id);
		if(temp.getEdiblemethod() != null){
			
			product = productMapper.selectProductTasteById(id);
			product.setColourList(null);
		}else{
			product = productMapper.selectProductColourById(id);
			if(product != null){
				product.setTasteList(null);
			}
		}
		
		return product;
	}

	public List<EvaluationCustom> queryEvaluationByProductId(EvaluationCustom condition) {
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		condition.setPageNum(3);
		if(condition.getCurrentPage() > 0){
			Integer beginTemp = (condition.getCurrentPage() - 1) * condition.getPageNum();
			condition.setBegin(beginTemp);
		}else{
			condition.setBegin(0);
		}
		
		List<EvaluationCustom> evaluationList = evaluationMapper.selectEvaluationsByProdutId(condition);
		for(EvaluationCustom evaluation : evaluationList){
			String fmt = dt.format(evaluation.getCommentdate());
			evaluation.setStringDate(fmt);
		}
		
		return evaluationList;
	}

	public EvaluationCustom queryEvaluationLevalByProductId(Integer id) {
		List<EvaluationCustom> evaluation = evaluationMapper.selectEvaluationLevalSum(id);
		Integer badReview = 0;
		Integer average = 0;
		Integer praise = 0;
		String praiseOf;
		EvaluationCustom evaluationCustom = new EvaluationCustom();
		for(EvaluationCustom temp : evaluation){
			if(temp.getEvaluationleval() == 1 || temp.getEvaluationleval() == 2){
				
				badReview +=  temp.getEvaluationLevalSum();
			}else if(temp.getEvaluationleval() == 3){
				
				average +=  temp.getEvaluationLevalSum();
			}else{
				praise += temp.getEvaluationLevalSum();
			}
			
		}
		double a = praise* 100;
		double b = (average + badReview + praise)* 100;
		double c = (a / b) * 100;
		DecimalFormat df = new DecimalFormat("#.00");
		praiseOf = df.format(c);
		
		evaluationCustom.setBadReview(badReview);
		evaluationCustom.setAverage(average);
		evaluationCustom.setPraise(praise);
		evaluationCustom.setPraiseOf(praiseOf);
		
		
		return evaluationCustom;
	}

	public Integer queryEvaluationSum(Integer id) {
		
		Integer sum = evaluationMapper.selectEvaluationSum(id);
		Integer pageSum = sum / 3;
		if(sum % 3 != 0){
			pageSum += 1;
		}
		return pageSum;
	}

	public List<ProductCustom> querySimilarProductsByProductId(ProductCustom condition) {
		
		Product product = productMapper.selectByPrimaryKey(condition.getProductid());
		condition.setProducttypeid(product.getProducttypeid());
		List<ProductCustom> products = productMapper.selectProductByProducttypeId(condition);
		return products;
	}

	public ProductCustom quertyProductColourById(Integer id) {
		
		return productMapper.selectProductColourById(id);
	}

	public ProductCustom quertyProductTasteById(Integer id) {
		
		return productMapper.selectProductTasteById(id);
	}




}
