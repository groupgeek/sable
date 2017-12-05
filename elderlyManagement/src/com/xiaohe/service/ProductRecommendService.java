package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Productrecommend;
import com.xiaohe.bean.UserCustom;

@Transactional
public interface ProductRecommendService {
	
	/**
	 * 	插入推荐商品
	 * @return 分店ID 商品ID productshow（是否显示默认为否）
	 */
	 void	insertProductRecommend(Productrecommend productrecommend);
	 

	 int  sumProductRecommend(Integer productrecommendid);
	 /**
	  * 
	  *  查询推荐商品用户登录账户	
	  * @return
	  */
	 UserCustom quertyCustoms(String phone);
	 
	 /**
	  * 查询单个商品信息
	  * @param productid
	  * @return
	  */
	 Boolean quertyOneProduct(int productid);
	 /**
	  * 更新商品推介信息
	  * @param productrecommend
	  */
	 void upProductRecomment(Productrecommend productrecommend);
}
