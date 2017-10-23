package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.mapper.DiscountMapper;
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
			product.setTasteList(null);
		}
		
		return product;
	}

}
