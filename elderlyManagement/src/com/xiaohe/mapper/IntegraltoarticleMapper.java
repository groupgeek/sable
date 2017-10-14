package com.xiaohe.mapper;

import com.xiaohe.bean.Integraltoarticle;

public interface IntegraltoarticleMapper {
    int deleteByPrimaryKey(Integer articleid);

    int insert(Integraltoarticle record);

    int insertSelective(Integraltoarticle record);

    Integraltoarticle selectByPrimaryKey(Integer articleid);

    int updateByPrimaryKeySelective(Integraltoarticle record);

    int updateByPrimaryKeyWithBLOBs(Integraltoarticle record);

    int updateByPrimaryKey(Integraltoarticle record);
}