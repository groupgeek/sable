package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.ProducttasteCustom;

@Transactional
public interface ProducttasteService {
/*	*//**
	 * 
	 * @return 商品库存量
	 * @throws Exception
	 *//*
	public  List<Integer>  countTasteStock() throws Exception;

	*//**
	 * 增加口味
	 * @throws Exception
	 *//*
	public void insertTaste(Producttype producttype) throws Exception;*/
	
	
	/**
	 * 
	 * @param produdctid
	 * @return 商品口味
	 * @throws Exception
	 */
	public List<ProducttasteCustom>   quertyProductByid(Integer produdctid) throws  Exception;
}
