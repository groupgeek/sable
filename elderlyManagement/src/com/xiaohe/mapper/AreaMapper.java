package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Area;
import com.xiaohe.bean.AreaCustom;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer areaid);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaid);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    
    /**
     * 查询地区
     * @param condition 条件
     * @return
     */
    List<AreaCustom> selectAreasByCondition(AreaCustom condition);
}