package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.Activityreport;
import com.xiaohe.bean.CeoActivityreport;

public interface ActivityreportMapper {
    int deleteByPrimaryKey(Integer activityreporid);

    int insert(Activityreport record);

    int insertSelective(Activityreport record);

    Activityreport selectByPrimaryKey(Integer activityreporid);

    int updateByPrimaryKeySelective(Activityreport record);

    int updateByPrimaryKey(Activityreport record);
    
    
    /**
     * 查询活动的开展情况（总报名人数，总报名费）（报表）
     * @param activityCustom
     * @return
     */
    ActivityCustom activityCondition(ActivityCustom activityCustom);
    
    /**
     * 查询活动报表
     * @return
     */
    List<CeoActivityreport> ceoActivityChart();
    /**
     * 查询所有活动报表
     * @return
     */
    List<CeoActivityreport> ceoActivityreport();
    /**
     * 根据分店查询活动的报表
     * @param id
     * @return
     */
    List<CeoActivityreport> ceoActivityreportOfBranch(CeoActivityreport ceoActivityreport);
    /**
     * 查询活动报表的数目
     * @param ceoActivityreport
     * @return
     */
    Integer ceoActivitychartnumber(CeoActivityreport ceoActivityreport);
    /**
     * 根据活动id查询活动的报表
     * @param id
     * @return
     */
    List<CeoActivityreport> ceoActivityreportById(Integer id);
    /**
     * 根据活动id查询活动的报表（做饼图用）
     * @param id
     * @return
     */
    CeoActivityreport ceooneActivityreport(Integer id);
    /**
     * 根据分店查询活动的报表（做图用）
     * @param id
     * @return
     */
    List<CeoActivityreport> ceoactivitychartOfbranch(Integer id);
    /**
     * 按年份查询活动报表（做图用）
     * @return
     */
    CeoActivityreport ceoactivitychartByYear();
    /**
     * 查询所有的活动报表（做图用）
     * @return
     */
    CeoActivityreport ceoactivitychartByAll();
    
    /**
     * 根据活动id查询到活动报表
     * @param id
     * @return
     */
    Activityreport oneActivityreport(Integer id);
    /**
     * 查询所有活动的盈利（做图用）
     * @return
     */
    List<CeoActivityreport> selectSumBigDecimal();
    /**
     * 查询分店活动的盈利（做图用）
     * @param ceoActivityreport
     * @return
     */
    List<CeoActivityreport> selectSumBigDecimalByBranch(CeoActivityreport ceoActivityreport);
    /**
     * 查询活动年收入（做饼图用）
     * @param ceoActivityreport
     * @return
     */
    CeoActivityreport selectYearMoneyByBranch(CeoActivityreport ceoActivityreport);
    /**
     * 查询活动总收入（做饼图用）
     * @param ceoActivityreport
     * @return
     */
    CeoActivityreport selectAllMoneyByBranch(CeoActivityreport ceoActivityreport);
}