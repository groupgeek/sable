package com.xiaohe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.mapper.ProducttransactionreportMapper;
import com.xiaohe.service.ProducttransactionreportService;

@Repository("producttransactionreportService")
public class ProducttransactionreportServiceImpl implements
		ProducttransactionreportService {
	
	@Autowired
	@Qualifier("producttransactionreportMapper")
	private ProducttransactionreportMapper producttransactionreportMapper;

	public ProducttransactionreportCustom statisticsProductSalesByProductId(
			Integer productid) {
		ProducttransactionreportCustom condition = new ProducttransactionreportCustom();
		condition.setProductid(productid);
		ProducttransactionreportCustom custom = producttransactionreportMapper.selectSumByCondition(condition);
		return custom;
	}

	public ProducttransactionreportCustom statisticsProductSalesByIdAndTime(
			ProducttransactionreportCustom condition) {
		
		return producttransactionreportMapper.selectSumByCondition(condition);
	}

}
