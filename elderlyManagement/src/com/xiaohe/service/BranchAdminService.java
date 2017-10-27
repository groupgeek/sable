package com.xiaohe.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Employee;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Returnvisit;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.UserCustom;

@Transactional
public interface BranchAdminService {
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<UserCustom> queryAllUser();
	
	/**
	 * 查询所有的信息
	 * @return
	 */
	public List<MessageCustom> QureyMessages();
	
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public void delUser(Integer id);
	
	/**
	 * 查询单个用户详情
	 * @param id
	 * @return
	 */
	public UserCustom oneUser(Integer id);
	
	/**
	 * 查询分页用的所有的留言信息
	 * @param messageVo
	 * @return
	 */
	public List<MessageCustom> allMessages(MessageVo messageVo);
	
	/**
	 * 分页用的信息总条数
	 * @return
	 */
	public int somecount();
	
	/**
	 * 查询留言的详细信息
	 * @param id
	 * @return
	 */
	public MessageCustom oneMessage(Integer id);
	
	/**
	 * 查询分店教育的总收入
	 * @return
	 */
	public BigDecimal totalEduIncome(Integer id);
	
	/**
	 * 查询分店活动的总收入
	 * @return
	 */
	public BigDecimal totalHealIncome(Integer id);
	
	/**
	 * 查询分店总收入
	 * @return
	 */
	public BigDecimal totalOderIncome(Integer id);
	
	/**
	 * 查询单个员工（分店管理员）
	 * @param id
	 * @return
	 */
	public Employee onEmployee(Integer id);
	
	/**
	 * 查询分店的用户
	 * @param areaid
	 * @return
	 */
	public List<UserCustom> branchUser(Integer areaid);
	
	/**
	 * 查询分店的所有信息
	 * @return
	 */
	public List<MessageCustom> branchMessages(MessageVo messageVo);
	
	/**
	 * 查询分店信息的总条数
	 * @return
	 */
	public int branchMessagesCount(Integer id);
	
	/**
	 * 查询分店总用户数
	 * @param id
	 * @return
	 */
	public int branchCountUsers(Integer id);
	
	/**
	 * 查询分店总活动数
	 * @param id
	 * @return
	 */
	public int branchCountActivities(Integer id);
	
	/**
	 * 查询分店总订单数
	 * @param id
	 * @return
	 */
	public int brachCountOrders(Integer id);
	
	/**
	 * 查询分店总商品数
	 * @param id
	 * @return
	 */
	public int branchCountProducts(Integer id);
	
	
	/**
	 * 查询分店的热销商品
	 * @param id
	 * @return
	 */
	public List<ProductCustom>branchHotProduct(Integer id);
	
	/**
	 * 查询分店的客户关系
	 * @param id
	 * @return
	 */
	public List<TransactionCustom> branchAllTran(Integer id);
	
	/**
	 * 查询分店的回访信息
	 * @param id
	 * @return
	 */
	public List<Returnvisit> branchReturnVist(Integer id);
}
