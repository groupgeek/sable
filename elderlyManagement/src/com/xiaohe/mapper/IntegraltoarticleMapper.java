package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Integraltoarticle;
import com.xiaohe.bean.IntegraltoarticleCuntom;
import com.xiaohe.bean.ProductCustom;

public interface IntegraltoarticleMapper {
    int deleteByPrimaryKey(Integer articleid);

    int insert(Integraltoarticle record);

    int insertSelective(Integraltoarticle record);

    Integraltoarticle selectByPrimaryKey(Integer articleid);

    int updateByPrimaryKeySelective(Integraltoarticle record);

    int updateByPrimaryKeyWithBLOBs(Integraltoarticle record);

    int updateByPrimaryKey(Integraltoarticle record);
    
    
    /**
     * 查询某地区积分商品信息
     * @param condition
     * @return
     */
    List<IntegraltoarticleCuntom> selectAllIntegralProductByCondition(IntegraltoarticleCuntom condition);
    
    /**
     * 查询某地区积分商品数量 同上
     * @param condition
     * @return
     */
    Integer selectAllIntegralProductSumByCondition(IntegraltoarticleCuntom condition);
}