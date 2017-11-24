package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Commonsense;
import com.xiaohe.bean.CommonsenseCustom;

public interface CommonsenseMapper {
    int deleteByPrimaryKey(Integer commonsenseid);

    int insert(Commonsense record);

    int insertSelective(Commonsense record);

    Commonsense selectByPrimaryKey(Integer commonsenseid);

    int updateByPrimaryKeySelective(Commonsense record);

    int updateByPrimaryKeyWithBLOBs(Commonsense record);

    int updateByPrimaryKey(Commonsense record);
    
    /**
     * 查询小常识以及心灵鸡汤
     * @param custom 条件
     * @return集合
     */
    List<CommonsenseCustom> selectCommonsenseByCondition(CommonsenseCustom custom);
}