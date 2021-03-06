package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Message;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;


@Transactional
public interface MessageService {
	
	public void insertMessageByUserid(Message message);
	
	/**
	 * 查询所有的留言
	 * @param condition
	 * @return
	 */
	public  MessageVo queryAllMessageByCondition(MessageCustom condition);	
	
	/**
	 * 查询留言详情
	 * @param id
	 * @return
	 */
	public MessageCustom queryMessagInfoById(Integer id);
	
	/**
	 * 更新留言
	 * @param messageInfo
	 * @return
	 */
	public boolean updateMessage (MessageCustom messageInfo);
	
	/**
	 * 删除留言
	 * @param messgaeid
	 * @return
	 */
	public boolean deleteMessage(Integer messageid);

}
