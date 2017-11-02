package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.ProductcolourCustom;
import com.xiaohe.mapper.ProductcolourMapper;
import com.xiaohe.service.ProdcutColorService;
@Repository("prodcutColorService")
public class ProductcolourServiceImpl implements ProdcutColorService{
	@Autowired
	@Qualifier("productcolourMapper")
	private ProductcolourMapper productcolourMapper;
	

	public ProductcolourCustom selectProductColour() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductcolourCustom> findProductColorAndSize(Integer productId)
			throws Exception {
		
		return productcolourMapper.findProductColorAndSize(productId);
	}

}
