package com.xiaohe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.MessageMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.BranchAdminService;

@Repository("branchService")
public class BranchAdminServiceImpl implements BranchAdminService{

	@Autowired
	private  MessageMapper messageMapper;
	
	@Autowired
	private UserMapper userMapper;
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

	
}
