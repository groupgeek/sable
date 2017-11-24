package com.xiaohe.mapper;

import com.xiaohe.bean.Ceo;

public interface CeoMapper {
    int deleteByPrimaryKey(Integer ceoid);

    int insert(Ceo record);

    int insertSelective(Ceo record);

    Ceo selectByPrimaryKey(Integer ceoid);

    int updateByPrimaryKeySelective(Ceo record);

    int updateByPrimaryKey(Ceo record);
}