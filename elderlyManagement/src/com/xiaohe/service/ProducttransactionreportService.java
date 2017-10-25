package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.ProducttransactionreportCustom;

@Transactional
public interface ProducttransactionreportService {
	/**
	 * 统计某件商品的销量
	 * @param condition
	 * @return
	 */
	public ProducttransactionreportCustom statisticsProductSalesByProductId(Integer productid);
	
	/**
	 * 统计某一件商品在某一时间段的销量
	 * @param condition
	 * @return
	 */
	public ProducttransactionreportCustom statisticsProductSalesByIdAndTime(ProducttransactionreportCustom condition);

}
