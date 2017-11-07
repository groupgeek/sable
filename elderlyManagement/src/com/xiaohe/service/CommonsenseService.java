package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Commonsense;
import com.xiaohe.bean.CommonsenseCustom;
import com.xiaohe.mapper.CommonsenseMapper;


/**
 * 小常识处理
 * @author
 *
 */
@Transactional
public interface CommonsenseService {
	/**
	 * 根据CommonsenseCustom里面的字段查询活动
	 * @param commonsenseCustom 条件
	 * @return CommonsenseCustom集合
	 */
	public List<CommonsenseCustom> queryCommonsenseByCondition(CommonsenseCustom commonsenseCustom);

    public int deleteCommonsense(Integer commonsenseid);

    public int insertCommonsense(Commonsense record);	
    
    public int updateCommonsense(Commonsense record); 
    
    public Commonsense selectByPrimaryKey(Integer commonsenseid);
}
