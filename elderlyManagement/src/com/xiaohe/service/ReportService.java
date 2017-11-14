package com.xiaohe.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.ProducttransactionreportCustom;

@Transactional
public interface ReportService {

	/**
	 * 查询某一时间段的某商品商品报表
	 * @param condition
	 * @return
	 */
	public Map<String, String[]> queryProductReportByTimeInterval(ProducttransactionreportCustom condition);
}
