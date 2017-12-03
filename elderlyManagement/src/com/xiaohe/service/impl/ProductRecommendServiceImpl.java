package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Productrecommend;
import com.xiaohe.bean.UserCustom;
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

	public int sumProductRecommend(Integer branchid) {
		Integer p= productrecommendMapper.sumRecommendProduct(branchid);
		if (p==null) {
			return 0;
		}
		return p;
	}

	public UserCustom quertyCustoms(String phone) {
		
		return productrecommendMapper.quertyuserProduct(phone);
	}

	public Boolean quertyOneProduct(int productid) {
		Productrecommend productrecommend=productrecommendMapper.quertyOneProduct(productid);
		if (productrecommend.getProductid()!=(productid)) {
			
			return true;
		}
		
			return false;

	}

	
}
