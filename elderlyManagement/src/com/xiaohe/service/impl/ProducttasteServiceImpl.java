package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.ProducttasteCustom;
import com.xiaohe.mapper.ProducttasteMapper;
import com.xiaohe.service.ProducttasteService;

@Repository("producttasteService")
public class ProducttasteServiceImpl implements ProducttasteService {
	@Autowired
	@Qualifier("producttasteMapper")
	private ProducttasteMapper producttasteMapper;
	
	public List<ProducttasteCustom> quertyProductByid(Integer productid)
			throws Exception {
		
		return producttasteMapper.quertyProducttasteByid(productid);
	}


	



}
