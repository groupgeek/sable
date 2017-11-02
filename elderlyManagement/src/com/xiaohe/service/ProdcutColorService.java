package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.ProductcolourCustom;

@Transactional
public interface ProdcutColorService {
	public ProductcolourCustom selectProductColour() throws Exception;
	/*
	 * 查询商品的类型和颜色
	 **/
	  List<ProductcolourCustom> findProductColorAndSize(Integer productId)throws Exception;
}
