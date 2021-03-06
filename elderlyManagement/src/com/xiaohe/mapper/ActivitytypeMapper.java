package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Activitytype;
import com.xiaohe.bean.ActivitytypeCustom;

public interface ActivitytypeMapper {
    int deleteByPrimaryKey(Integer activitytypeid);

    int insert(Activitytype record);

    int insertSelective(Activitytype record);

    Activitytype selectByPrimaryKey(Integer activitytypeid);

    int updateByPrimaryKeySelective(Activitytype record);

    int updateByPrimaryKey(Activitytype record);
    
    /**
     * 查询所以的活动类型
     * @return
     */
    List<ActivitytypeCustom> AllActTypes(); 
    
    /**
     * 查询所有的活动父类型除外
     * @return
     */
    List<ActivitytypeCustom> selectAllActTypes();
    
    /**
     * 查询父类类型
     * @return
     */
    List<ActivitytypeCustom> selectFatherTypes();
    
    /**
     * 根据父类查询子类
     * @param id
     * @return
     */
    List<ActivitytypeCustom> selectAllSonByFatherId(Integer id);
    
    /**
     * 查询教育下的所有小分类
     * @return
     */
    List<ActivitytypeCustom> selectAllEduType();
    
    /**
     * 查询小活动的类型
     * @param activitytype
     * @return
     */
    List<ActivitytypeCustom> selectSmallActivitytype(ActivitytypeCustom activitytype);
}