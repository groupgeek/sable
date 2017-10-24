package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Evaluation;
import com.xiaohe.bean.EvaluationCustom;

public interface EvaluationMapper {
    int deleteByPrimaryKey(Integer evaluationid);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Integer evaluationid);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKeyWithBLOBs(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
    
    /**
     * 查询评价表
     * @param id 产品id
     * @return
     */
    List<EvaluationCustom> selectEvaluationsByProdutId(EvaluationCustom condition);
    
    /**
     * 查询评价星级的数量
     * @param id
     * @return
     */
    List<EvaluationCustom> selectEvaluationLevalSum(Integer id);
    
    /**
     * 查询商品的全部评价的总条数
     * @param id
     * @return
     */
    Integer selectEvaluationSum(Integer id);
}