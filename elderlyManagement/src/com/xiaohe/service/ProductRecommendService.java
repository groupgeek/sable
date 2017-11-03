package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Productrecommend;

@Transactional
public interface ProductRecommendService {
	
	/**
	 * 	插入推荐商品
	 * @return 分店ID 商品ID productshow（是否显示默认为否）
	 */
	 void	insertProductRecommend(Productrecommend productrecommend);

}
