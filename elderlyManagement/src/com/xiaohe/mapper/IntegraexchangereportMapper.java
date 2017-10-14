package com.xiaohe.mapper;

import com.xiaohe.bean.Integraexchangereport;

public interface IntegraexchangereportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Integraexchangereport record);

    int insertSelective(Integraexchangereport record);

    Integraexchangereport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Integraexchangereport record);

    int updateByPrimaryKey(Integraexchangereport record);
}