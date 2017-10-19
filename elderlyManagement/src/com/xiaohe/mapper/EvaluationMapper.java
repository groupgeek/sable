package com.xiaohe.mapper;

import com.xiaohe.bean.Evaluation;

public interface EvaluationMapper {
    int deleteByPrimaryKey(Integer evaluationid);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Integer evaluationid);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKeyWithBLOBs(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}