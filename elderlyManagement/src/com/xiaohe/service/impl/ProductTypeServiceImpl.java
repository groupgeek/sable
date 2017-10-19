package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.mapper.ProducttypeMapper;
import com.xiaohe.service.ProductTypeService;

@Repository("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {
	
	
	@Autowired
	@Qualifier("producttypeMapper")
	private ProducttypeMapper producttypeMapper;

	public List<ProducttypeCustom> queryProductTypeByFather(ProducttypeCustom producttype) {
		
		return producttypeMapper.selectProductTypeByFatherId(producttype);
	}

}
