package com.xiaohe.mapper;

import com.xiaohe.bean.Activityrecommend;

public interface ActivityrecommendMapper {
    int deleteByPrimaryKey(Integer activityid);

    int insert(Activityrecommend record);

    int insertSelective(Activityrecommend record);

    Activityrecommend selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(Activityrecommend record);

    int updateByPrimaryKey(Activityrecommend record);
}