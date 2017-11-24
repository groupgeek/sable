package com.xiaohe.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.bean.CeoActivity;
import com.xiaohe.bean.EmployeeCustom;

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
    
    /**
     * 根据活动id查询到一条活动信息
     * @param id
     * @return
     */
    Activity oneAct(Integer id);
    
    /**
     * 查询活动信息
     * @param condition
     * @return
     */
    List<ActivityCustom> selectAllActivityByCondition(ActivityCustom condition);
    
    /**
     * 查询活动数量
     * @param condition
     * @return
     */
    Integer selectAllActivitySumByCondition(ActivityCustom condition);
    
    /**
     * 查询活动的所有信息
     * @param id
     * @return
     */
    ActivityCustom selectActivityInfoById(Integer id);

    /**
     * 查询活动的总支出
     * @param activity
     * @return
     */
    BigDecimal selectSumActivityPrice();

    /**
     * 查询活动的总报名费
     * @param activity
     * @return
     */
    BigDecimal selectSumregisteryFee();

    /**
     * 根据时间查询活动的支出
     * @param activity
     * @return
     */
    List<Activity> selectSumActivityByTime();

    /**
     * 根据时间查询活动的收入
     * @param ceoActivity
     * @return
     */
    List<CeoActivity> selectSumregisteryFeeByTime();

    /**
     * 查询所有活动的基本信息
     * @param activity
     * @return
     */
    List<CeoActivity> selectAllActivity();

    /**
     * 通过id查询活动的详细信息(关联查询分店名等)
     * @param activityid
     * @return
     */
    CeoActivity selectCeoActivity(Integer activityid);

    /**
     * 查询活动总数
     * @return
     */
    int selectCountActivity();
    /**
     * 按月份查询一年内的活动支出
     * @return
     */
    List<CeoActivity> CeoActivityByTime();
    /**
     * 按月份查询一年内的活动收入
     * @return
     */
    List<CeoActivity> CeoRegisteryFeeByTime();
    
    /**
     * 根据用户id查询到所有的活动
     * @param id
     * @return
     */
    List<ActivityCustom> allActs(Integer id);
    
    /**
     * 查询健康的收支情况（分店总活动报表）
     * @param activityCustom
     * @return
     */
    ActivityCustom branchHealIncomeReport(ActivityCustom activityCustom);
    
    /**
     * 查询教育的收支情况（分店总活动报表）
     * @param activityCustom
     * @return
     */
    ActivityCustom branchEduIncomeReport(ActivityCustom activityCustom);
   
    /**
     * 通过用户id 查询对应课程
     * @param id
     * @return
     */
    List<Activity> queryActivityByUserId(int id);
    
    /**
     * 根据类型和分店查询活动，分店重userid里面查
     * @return
     */
    List<ActivityCustom> selectActivityByTypeAndUserid(ActivityCustom condition);
    
    
    /**
     * 查询教育下某一类活动信息
     * @param condition
     * @return
     */
    List<ActivityCustom> selectEduAllTypeActByCondition(ActivityCustom condition);
    
    
    /**
     *查询教育下某一类活动数量
     * @param condition
     * @return
     */
    Integer selectActivitySumByTypeAndUserid(ActivityCustom condition);
    /**
     * 		地区活动查询
     * @param phone
     * @return
     */
    List<ActivityCustom> quertyActivityArea(String phone);   
    /**
     * 按月份查询分店一年的教育收入
     * @param id
     * @return
     */
    List<CeoActivity> CeoBranchEduIncome(Integer id);
    /**
     * 按月份查询分店一年的健康收入
     * @param id
     * @return
     */
    List<CeoActivity> CeoBranchHealIncome(Integer id);
}