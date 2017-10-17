package com.xiaohe.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Employee;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.UserCustom;

@Transactional
public interface BranchAdminService {
	
	public List<UserCustom> queryAllUser();
	
	public List<MessageCustom> QureyMessages();
	
	public void delUser(Integer id);
	
	public UserCustom oneUser(Integer id);
	
	public List<MessageCustom> allMessages(MessageVo messageVo);
	
	public int somecount();
	
	public MessageCustom oneMessage(Integer id);
	
	public BigDecimal totalEduIncome();
	
	public BigDecimal totalActIncome();
	
	public BigDecimal totalOderIncome();
	
	public Employee onEmployee(Integer id);
	
	public List<UserCustom> branchUser(Integer employeeid);
}
