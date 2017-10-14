package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Product;

@Transactional
public interface ProductService {
	/**
     * 查询出热门的商品（购买次数）
     * @param no  多少个商品数量
     * @return
     * @author 张彪
     */
	List<Product> queryPopularProductByRank(Integer no);
	

}
