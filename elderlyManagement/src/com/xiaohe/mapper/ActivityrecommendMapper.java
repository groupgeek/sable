package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Activityrecommend;
import com.xiaohe.bean.ActivityrecommendCustom;

public interface ActivityrecommendMapper {
    int deleteByPrimaryKey(Integer reid);

    int insert(Activityrecommend record);

    int insertSelective(Activityrecommend record);

    Activityrecommend selectByPrimaryKey(Integer reid);

    int updateByPrimaryKeySelective(Activityrecommend record);

    int updateByPrimaryKey(Activityrecommend record);
    
    /**
     * 根据分店管理员id查询到分店推荐活动
     * @return
     */
    List<ActivityrecommendCustom> branchActRec(Integer id);
    
    /**
     * 根据分店管理员id查询到分店健康推荐活动
     * @return
     */
    List<ActivityrecommendCustom> branchActHealthRec(Integer id);
    
    /**
     * 根据分店管理员id查询到分店教育推荐活动
     * @return
     */
    List<ActivityrecommendCustom> branchActEduRec(Integer id);
    
    /**
     * 根据推荐红的中的活动id更新活动推荐信息
     * @param id
     * @return
     */
    int updateByActivity(Integer id);
    
    /**
     * 删除单个活动
     * @param activityrecommend
     */
    void deleteByPrimary(ActivityrecommendCustom activityrecommendCustom);
    
    /**
     * 查询单个活动
     * @param activityrecommend
     * @return
     */
    ActivityrecommendCustom selectByPrimary(ActivityrecommendCustom activityrecommendCustom);
    
    /**
     * 插入关网推荐活动
     * @param avtActivityrecommendCustom
     * @return
     */
    int insertAct(ActivityrecommendCustom avtActivityrecommendCustom);
    
    /**
     * 插入教育和健康的活动推荐
     * @param activityrecommendCustom
     * @return
     */
    int insertRecAct(ActivityrecommendCustom activityrecommendCustom);
    /**
     * 查询总推荐活动条数
     * @param emid
     * @return
     */
    int countActRec(Integer emid);
    
    /**
     * 查询健康活动总条数
     * @param emid
     * @return
     */
    int countActHealthRec(Integer emid);
    
    /**
     * 查询教育活动总条数
     * @param emid
     * @return
     */
    int countActEduRec(Integer emid);
}