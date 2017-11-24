package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Commonsense;
import com.xiaohe.bean.CommonsenseCustom;
import com.xiaohe.mapper.CommonsenseMapper;
import com.xiaohe.service.CommonsenseService;

@Repository("commonsenseService")
public class CommonsenseServiceImpl implements CommonsenseService {
	
	@Autowired
	@Qualifier("commonsenseMapper")
	private CommonsenseMapper commonsenseMapper;
    //模糊查询
	public List<CommonsenseCustom> queryCommonsenseByCondition(
			CommonsenseCustom commonsenseCustom) {
		return commonsenseMapper.selectCommonsenseByCondition(commonsenseCustom);
	}
     //通过id删除数据
	public int deleteCommonsense(Integer commonsenseid) {
		
		return commonsenseMapper.deleteByPrimaryKey(commonsenseid);
	}
	  //插入数据
	public int insertCommonsense(Commonsense record) {
		
		return commonsenseMapper.insert(record);
	}
	//修改数据
	public int updateCommonsense(Commonsense record) {
		
		return commonsenseMapper.updateByPrimaryKey(record);
	}
	public Commonsense selectByPrimaryKey(Integer commonsenseid) {
		
		return commonsenseMapper.selectByPrimaryKey(commonsenseid);
		
	}
	

}
