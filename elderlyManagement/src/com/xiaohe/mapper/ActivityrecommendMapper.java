package com.xiaohe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.xiaohe.bean.Activityrecommend;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.ActivityrecommendKey;

public interface ActivityrecommendMapper {
    int deleteByPrimaryKey(ActivityrecommendKey key);

    int insert(Activityrecommend record);

    int insertSelective(Activityrecommend record);

    Activityrecommend selectByPrimaryKey(ActivityrecommendKey key);

    int updateByPrimaryKeySelective(Activityrecommend record);

    int updateByPrimaryKey(Activityrecommend record);
    
    /**
     * 根据分店管理员id查询到分店推荐活动
     * @return
     */
    List<ActivityrecommendCustom> branchActRec(Integer id);
    
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
    
    
    int insertAct(ActivityrecommendCustom avtActivityrecommendCustom);
    
    /**
     * 查询总推荐活动条数
     * @param emid
     * @return
     */
    int countActRec(Integer emid);
    
    
}