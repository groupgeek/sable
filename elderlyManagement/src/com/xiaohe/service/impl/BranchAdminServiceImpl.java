package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Employee;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.EmployeeMapper;
import com.xiaohe.mapper.MessageMapper;
import com.xiaohe.mapper.OrdersMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.BranchAdminService;

@Repository("branchService")
public class BranchAdminServiceImpl implements BranchAdminService{

	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	public List<MessageCustom> QureyMessages() {
		return messageMapper.QureyMessages();
	}
	public List<UserCustom> queryAllUser() {
		return userMapper.queryAllUser();
	}
	public void delUser(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	public UserCustom oneUser(Integer id) {
		return (UserCustom) userMapper.selectByPrimaryKey(id);
	}
	public List<MessageCustom> allMessages(MessageVo messageVo) {
		return messageMapper.allMessages(messageVo);
	}
	public int somecount() {
		return messageMapper.somecount();
	}
	public MessageCustom oneMessage(Integer id) {
		return messageMapper.oneMessage(id);
	}
	public BigDecimal totalEduIncome() {
		// TODO Auto-generated method stub
		return null;
	}
	public BigDecimal totalActIncome() {
		// TODO Auto-generated method stub
		return null;
	}
	public BigDecimal totalOderIncome() {
		return ordersMapper.queryOderIncome();
	}
	public Employee onEmployee(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	public List<UserCustom> branchUser(Integer employeeid) {
		return userMapper.branchUserCustoms(employeeid);
	}

	
}
