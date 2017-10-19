package com.xiaohe.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityrecommendCustom;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer activityid);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKeyWithBLOBs(Activity record);

    int updateByPrimaryKey(Activity record);
    
    /**
     * 根据activity里面的字段查询活动表
     * @param aCustom activity扩展类  继承了activity 里面有自己的属性
     * @return 活动类集合
     */
    List<ActivityCustom> selectActivitiesByCondition(ActivityCustom aCustom);
    
    /**
	 * 查询活动推荐表，根据官网类型区分
	 * @param type 官网类型
	 * @return ActivityrecommendCustom集合
	 */
    List<ActivityCustom> selectActivityrecommendByCondition(ActivityrecommendCustom custom);
    
    /**
     * 查询分店健康收入
     * @param id
     * @return
     */
    BigDecimal branchHealIncome(Integer id);
    
    /**
     * 查询分店教育收入
     * @param id
     * @return
     */
    BigDecimal branchEduIncome(Integer id);
    
    /**
     * 查询分店的全部活动数量
     * @param id
     * @return
     */
    int branchCountActivity(Integer id);
    
    /**
     * 查询分店所有的活动
     * @param id
     * @return
     */
    List<ActivityCustom> branchActs(Integer id);
    
    /**
     * 查询该活动的报名人数
     * @param id
     * @return
     */
    int countActUsers(Integer id);
    
    /**
     * 查询activitycustom（包括用户数）
     * @param id
     * @return
     */
    ActivityCustom oneActivityCustom(Integer id);
    
    /**
     * 查询所有的活动
     * @return
     */
    List<ActivityCustom> Acts();
   
}