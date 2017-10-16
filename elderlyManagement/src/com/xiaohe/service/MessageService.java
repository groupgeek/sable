package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Message;


@Transactional
public interface MessageService {
	public void insertMessageByUserid(Message message);
	

}
