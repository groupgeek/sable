package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Message;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
    
    /**
     * 查询所有用户留言
     * @return
     */
    List<MessageCustom> QureyMessages();
    
    
    /**
     * 对留言信息的分页
     * @return
     */
    List<MessageCustom> allMessages(MessageVo messageVo);
    
    
    /**
     * 查询一个留言，包括用户的姓名和email
     * @param id
     * @return
     */
    MessageCustom oneMessage(Integer id);
    
    /**
     * 查询留言的总条数
     * @return
     */
    int somecount();
    
}