package com.xiaohe.mapper;

import com.xiaohe.bean.Commonsense;

public interface CommonsenseMapper {
    int deleteByPrimaryKey(Integer editorid);

    int insert(Commonsense record);

    int insertSelective(Commonsense record);

    Commonsense selectByPrimaryKey(Integer editorid);

    int updateByPrimaryKeySelective(Commonsense record);

    int updateByPrimaryKeyWithBLOBs(Commonsense record);

    int updateByPrimaryKey(Commonsense record);
}