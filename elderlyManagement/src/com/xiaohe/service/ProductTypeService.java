package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.ProducttypeCustom;

@Transactional
public interface ProductTypeService {
	
	/**
	 * 根据父类查询子类
	 * @return 商品类型集合
	 */
	public List<ProducttypeCustom> queryProductTypeByFather(ProducttypeCustom producttype);

}
