package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.Integral;
import com.xiaohe.bean.Integraltoarticle;
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
	
	/*
	 *添加积分商品 
	 */
	public boolean addPointsProduct(Integraltoarticle integraltoarticle,MultipartFile pictureUpload);

}
