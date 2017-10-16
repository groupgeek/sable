package com.xiaohe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Message;
import com.xiaohe.mapper.MessageMapper;
import com.xiaohe.service.MessageService;

@Repository("messageService")
public class MessageServiceImpl implements MessageService {
	
	
	@Autowired
	@Qualifier("messageMapper")
	private MessageMapper messageMapper;

	public void insertMessageByUserid(Message message) {
		messageMapper.insertSelective(message);
	}

}
