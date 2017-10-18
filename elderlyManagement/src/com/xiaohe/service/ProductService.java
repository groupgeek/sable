package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;

@Transactional
public interface ProductService {
	/**
	 * 查询出商品（根据购买次数排序）
	 * @param productCustom 查询条件
	 * @return
	 */
	List<ProductCustom> queryPopularProductByCondition(ProductCustom productCustom);
	
	/**
	 * 查询商品类型
	 * @param producttypes 条件
	 * @return 集合
	 */
	List<ProducttypeCustom> queryProductTypeByCondition(ProducttypeCustom producttype);
	
	/**
	 * 查询推荐商品
	 * @param total 几条商品数据
	 * @return 商品集合
	 */
	List<ProductCustom> queryProductrecommend(Integer total);
	
	/**
	 * 查询推荐商品
	 * @param total 几条商品数据
	 * @return 商品集合
	 */
	List<ProductCustom> queryDiscountProduct(Integer total);

}
