package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.IntegraltoarticleCuntom;
import com.xiaohe.bean.IntegraltoarticleVo;


@Transactional
public interface IntegraltoarticleService {
	
	/**
     * 查询某地区某一类商品信息
     * @param condition
     * @return
     */
	public IntegraltoarticleVo queryAllProductIntegralByProductTypeId(IntegraltoarticleCuntom condition);
	
	/*8
	 * 购买积分商品 增加订单
	 */
	public boolean addIntegralOrder(IntegraltoarticleCuntom info);

}
