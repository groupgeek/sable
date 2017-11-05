package com.xiaohe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Message;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.mapper.MessageMapper;
import com.xiaohe.service.MessageService;
import com.xiaohe.util.GetStringByDate;

@Repository("messageService")
public class MessageServiceImpl implements MessageService {
	
	
	@Autowired
	@Qualifier("messageMapper")
	private MessageMapper messageMapper;

	public void insertMessageByUserid(Message message) {
		messageMapper.insertSelective(message);
	}

	public MessageVo queryAllMessageByCondition(MessageCustom condition) {
		MessageVo messageVo = new MessageVo();
		List<MessageCustom> allMessage = new ArrayList<MessageCustom>();
		Integer pageSum = 0;
		Integer messageSum = 0;
		
		if(condition != null){
			if(condition.getCurrentPage() >= 1){
				Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
				condition.setBegin(tempBegin);
			}else{
				condition.setBegin(0);
			}
			
		}
		if("全部".equals(condition.getBranchid())){
			condition.setBranchid(null);
		}
		allMessage = messageMapper.selectAllMessageByCondition(condition);
		
		for(MessageCustom custom : allMessage){
			custom.setMessagetimeString(GetStringByDate.getString(custom.getMessagetime()));
		}
		messageSum = messageMapper.selectAllMessageSumByCondition(condition);
		pageSum = messageSum / condition.getPageNum();
		if(messageSum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		messageVo.setAllMessage(allMessage);
		messageVo.setPageSum(pageSum);
		messageVo.setMessageSum(messageSum);
		
		return messageVo;
	}

	public MessageCustom queryMessagInfoById(Integer id) {
		if(id == null || id < 0){
			return null;
		}
		
		MessageCustom message = new MessageCustom();
		message = messageMapper.selectMessageInfoById(id);
		message.setMessagetimeString(GetStringByDate.getString(message.getMessagetime()));
		
		return message;
	}

	public boolean updateMessage(MessageCustom messageInfo) {
		if(messageInfo == null) return false;
		if(messageInfo.getMessageid() == null || messageInfo.getMessageid() < 0) return false;
		if(messageInfo.getUserid() == null || messageInfo.getUserid() < 0) return false;
		if(messageMapper.updateByPrimaryKeySelective(messageInfo) < 0) return false;
		return true;
	}

}
