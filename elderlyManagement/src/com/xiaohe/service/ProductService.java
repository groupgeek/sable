package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;

@Transactional
public interface ProductService {
	/**
	 * 查询出热门商品（根据购买次数排序）
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
	 * 查询推荐商品  商城主页
	 * @param total 几条商品数据
	 * @return 商品集合
	 */
	List<ProductCustom> queryProductrecommend(Integer total);
	
	/**
	 * 查询优惠商品 商城主页 
	 * @param total 几条商品数据
	 * @return 商品集合
	 */
	List<ProductCustom> queryDiscountProduct(Integer total);
	
	/**
	 * 商品模糊查询 名字 描述字段
	 * @param condition
	 * @return
	 */
	List<ProductCustom> queryProductByBlurry(String condition);
	
	 /**
     * 根据商品分类进行查询，可分页，模糊，根据购买次数，好评，价格排序
     * @param condition
     * @return 商品集合
     */
	List<ProductCustom> queryProductByCondition(ProductCustom condition);
	
	/**
	 * 查询产品总数
	 * @param condition
	 * @return
	 */
	Integer queryProductSumByCondition(ProductCustom condition);
	
	/**
	 * 查询商品详细信息
	 * @param id
	 * @return
	 */
	ProductCustom queryProductInfoById(Integer id);
	
	
	/**
	 * 查询商品评价
	 * @param condition
	 * @return 评价集合
	 */
	List<EvaluationCustom> queryEvaluationByProductId(EvaluationCustom condition);
	
	/**
	 * 查询评价等级并且计算出好评度以及好评，中评，差评的个数
	 * @param id
	 * @return
	 */
	EvaluationCustom queryEvaluationLevalByProductId(Integer id);
	
	/**
	 * 查询商品评价的总页数
	 * @param id
	 * @return
	 */
	Integer queryEvaluationSum(Integer id); 
	
	/**
	 * 根据产品id查询出同类的产品
	 * @param productid
	 * @return
	 */
	List<ProductCustom> querySimilarProductsByProductId(ProductCustom condition);
	/**
	 * 
	 * @return 商品颜色
	 */
	ProductCustom quertyProductColourById(Integer id);
	/**
	 * 
	 * @param id
	 * @return 商品口味
	 */
	ProductCustom quertyProductTasteById(Integer id);

}