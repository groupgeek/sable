package com.xiaohe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Productrecommend;
import com.xiaohe.mapper.ProductrecommendMapper;
import com.xiaohe.service.ProductRecommendService;
@Repository("productRecommendService")
public class ProductRecommendServiceImpl implements ProductRecommendService {
	
	@Autowired
	@Qualifier("productrecommendMapper")
	private ProductrecommendMapper productrecommendMapper;
	
	public void insertProductRecommend(Productrecommend productrecommend) {
		productrecommendMapper.insertSelective(productrecommend);
	}

	public int sumProductRecommend() {
		// TODO Auto-generated method stub
		return 0;
	}

}
