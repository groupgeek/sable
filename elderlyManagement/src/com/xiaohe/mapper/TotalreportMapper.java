package com.xiaohe.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.xiaohe.bean.CeoTotalreport;
import com.xiaohe.bean.Totalreport;

public interface TotalreportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Totalreport record);

    int insertSelective(Totalreport record);

    Totalreport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Totalreport record);

    int updateByPrimaryKey(Totalreport record);

    /**
     * 查询公司总盈利额
     * @param totalreport
     * @return
     */
    BigDecimal selectTotalreportSum();
    
    /**
     * 按时间查询总盈利额
     * @param totalreport
     * @return
     */
    List<BigDecimal> selectTotalreportSumByTime();
    /**
     * 根据分店id查询各分店的盈利总额
     * @param ceoTotalreport
     * @return
     */
    List<CeoTotalreport> selectTotalreportAndBranch();
}