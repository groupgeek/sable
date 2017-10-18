package com.xiaohe.mapper;

import com.xiaohe.bean.Activityrecommend;
import com.xiaohe.bean.ActivityrecommendKey;

public interface ActivityrecommendMapper {
    int deleteByPrimaryKey(ActivityrecommendKey key);

    int insert(Activityrecommend record);

    int insertSelective(Activityrecommend record);

    Activityrecommend selectByPrimaryKey(ActivityrecommendKey key);

    int updateByPrimaryKeySelective(Activityrecommend record);

    int updateByPrimaryKey(Activityrecommend record);
}