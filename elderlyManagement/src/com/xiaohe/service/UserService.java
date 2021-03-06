package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.Level;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.bean.OrdersCountVo;
import com.xiaohe.bean.OrdersCustom;
import com.xiaohe.bean.ShippingAddVo;
import com.xiaohe.bean.ShippingAddressCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;

@Transactional
public interface UserService {
	
	/**
	 * 用户注册
	 * @param userCustom 用户信息
	 */
	public Boolean registerUser(UserCustom userCustom);

	/**
	 * 用户登录
	 * @param userCustom 登录信息
	 * @return
	 */
	public UserCustom loginUser(UserCustom userCustom);
	
	/**
	 * 改变用户的在线情况
	 * @param userCustom
	 * @return
	 */
	public boolean changeUserOnline(UserCustom userCustom);
	
	/**
	 * 查询所有用户信息
	 * @param condition 条件
	 * @return 用户集合
	 */
	public UserVo queryAllUserByCondition(UserCustom condition);
	
	/**
	 * 查询用户信息所有信息
	 * @param id
	 * @return
	 */
	public UserCustom queryUserInfoById(Integer id);
	
	/**
	 * 更新用户详细信息
	 * @param userInfo
	 * @return
	 */
	public boolean UpdateUserInfoByUser(UserCustom userInfo,MultipartFile pictureUpload);
	
	/**
	 * 查询出某用户的所有收货地址
	 * @param userid
	 * @return
	 */
	public ShippingAddVo queryAllAddressByUserid(Integer userid);
	
	/**
	 * 更新默认地址并且返回原来的默认地址
	 * @return
	 */
	public ShippingAddressCustom updateDefaultReturnOld(ShippingAddressCustom condition);
	
	/**
	 * 添加地址并且返回地址
	 * @return
	 */
	public ShippingAddressCustom addAddressReturnAddress(ShippingAddressCustom addressInfo);
	
	/**
	 * 根据logo查询订单
	 * @param logo
	 * @param user
	 * @return
	 */
	public List<OrdersCustom> queryOrdersByLogo(String logo , User user);
	
	/**
	 * 计算某一状态或者其他条件 总数
	 * @param condition
	 * @return
	 */
	public OrdersCountVo queryCountByLogo(User user);
	
	/**
	 * 根据当前用户查询出评价
	 * @param userid
	 * @return
	 */
	public List<EvaluationCustom> queryAllEvaluationByUserid(Integer userid);
	
	/**
	 * 删除用户
	 * @param userid
	 * @return
	 */
	public boolean deleteUser(Integer userid);
	
	/**
	 * 修改用户密码
	 * @param info
	 * @return
	 */
	public boolean updateUserPassword(UserCustom info);
	
	/**
	 * 查询用户购物车里面的商品数量
	 * @param userid
	 * @return
	 */
	public Integer queryCartNum(Integer userid);
	
	/**
	 * 根据用户电话号码查询到用户
	 * @param phone
	 * @return
	 */
	public UserCustom userInfo(String phone);
	
	/**
	 * 根据等级id查询到等级信息
	 * @param id
	 * @return
	 */
	public Level onelevel(Integer id);
	
	/**
	 * 用户更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(UserCustom user,MultipartFile file);
	
	/**
	 * 根据用户id查询到对应的病历
	 * @param id
	 * @return
	 */
	public MedicalrecordsWithBLOBsCustom oneMed(Integer id);
	
	/**
	 * 根据用户id查询所有活动
	 * @param id
	 * @return
	 */
	public List<ActivityCustom> userActs(Integer id);
	
	/**
	 * 更新用户的病历信息
	 * @param medicalrecordsWithBLOBsCustom
	 * @return
	 */
	public int updatemed(MedicalrecordsWithBLOBsCustom medicalrecordsWithBLOBsCustom);
	
	
	/**
	 * 发送手机短信验证码
	 * @param phon
	 * @return
	 */
	public String sendUserVCode(String phone);
	
	/**
	 * 更改短信验证码状态
	 * @param phone
	 * @return
	 */
	public boolean updateVcodeStasus(String phone);
	
	/**
	 * 重置密码
	 * @param info
	 * @return
	 */
	public boolean retrieveThePassword(UserCustom info);
	
}
