package com.xiaohe.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaohe.bean.Message;
import com.xiaohe.mapper.MessageMapper;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class MessageTest {
	@Autowired
	@Qualifier("messageMapper")
	private MessageMapper messageMapper;
	
	@Test
	public void haha(){
		Message message = new Message();
		message.setMessagetime(new Date());
		message.setUserid(1);
		message.setMessagecontext("留言2");
		messageMapper.insertSelective(message);
		
		
	}

}
