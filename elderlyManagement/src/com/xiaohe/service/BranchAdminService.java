package com.xiaohe.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.Activityrecommend;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.bean.Authority;
import com.xiaohe.bean.AuthorityCustom;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Level;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.Returnvisit;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.User;
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
	
	
	/**
	 * 查询分店所有的活动
	 * @param id
	 * @return
	 */
	public List<ActivityCustom> branchActs(Integer id);
	
	/**
	 * 添加活动
	 * @param activity
	 */
	public void inertActs(Activity activity,MultipartFile file);
	
	/**
	 * 根据id查询分店
	 * @param id
	 * @return
	 */
	public Branch oneBranch(Integer id);
	
	/**
	 * 查询所有的活动类型
	 * @return
	 */
	public List<ActivitytypeCustom> allActivityTypes();
	
	/**
	 * 查询活动的报名人数
	 */
	public int countActUsers(Integer id);
	
	/**
	 * 查询活动详情包括报名人数
	 * @param id
	 * @return
	 */
	public ActivityCustom oneActCustom(Integer id);
	
	/**
	 * 删除活动信息
	 * @param id
	 */
	public void delAct(Integer id);
	
	/**
	 * 根据用户id查询单个病例
	 * @param id
	 * @return
	 */
	public MedicalrecordsWithBLOBsCustom oneMedRed(Integer id);
	
	/**
	 * 查询用户等级
	 * @param id
	 * @return
	 */
	public Level oneLev(Integer id);
	
	/**
	 * 根据id更新病例信息
	 * @param id
	 */
	public void updateMed(MedicalrecordsWithBLOBsCustom med);
	
	/**
	 * 根据病例查到用户
	 * @param id
	 * @return
	 */
	public User oneUserMed(Integer id);
	
	/**
	 * 查询所有的活动
	 * @return
	 */
	public List<ActivityCustom> acts();
	
	/**
	 * 查询分店所有活动推荐
	 * @return
	 */
	public List<ActivityrecommendCustom> branchActRec(Integer id);
	
	/**
	 * 删除分店的活动推荐
	 * @param id
	 */
	public void delActRec(ActivityrecommendCustom activityrecommendCustom);
	/*public Activity act(Integer id);*/
	
	/**
	 * 根据管理员id找到分店
	 * @param employeeid
	 * @return
	 */
	public Branch oneBranchByEmployeeId(Integer employeeid);
	
	/**
	 * 插入分店推荐活动
	 * @param activityrecommend
	 */
	public void insertActRec(ActivityrecommendCustom activityrecommendCustom);
	
	/**
	 * 根据id查询到对应的分店推荐活动
	 * @param activityrecommendCustom
	 * @return
	 */
	public ActivityrecommendCustom oneActRecById(ActivityrecommendCustom activityrecommendCustom);
	
	/**
	 * 查询推荐活动总条数
	 * @param id
	 * @return
	 */
	public int countRecAct(Integer id);
	
	/**
	 * 更新活動信息
	 * @param activityCustom
	 * @return
	 */
	public int updateAct(Activity activity);
	
	/**
	 * 根据活动id查询到一条活动信息
	 * @param id
	 * @return
	 */
	public Activity oneAct(Integer id);
	
	/**
	 * 根据管理员id查询所有的分店商品
	 * @param id
	 * @return
	 */
	public List<ProductCustom> quertyAllProduct(Integer id);
	
/*****************************报表开始****************************************/
	/**
	 * 查询商品的交易记录
	 * @param producttransactionreportCustom
	 * @return
	 */
	public List<ProducttransactionreportCustom> selectByCondition(ProducttransactionreportCustom producttransactionreportCustom);

	/**
	 * 根据商品的id，查询商品的销售情况（分店）
	 * @param productCustom
	 * @return
	 */
	public ProductCustom BranchProductCustom(ProductCustom productCustom);
	
	/**
	 * 插入病例
	 * @param medicalrecordsWithBLOBsCustom
	 * @return
	 */
	public int insertMed(MedicalrecordsWithBLOBsCustom medicalrecordsWithBLOBsCustom);
	
	
	/**
	 * 根据管理员的id查询到对应的分店下面的所有的员工
	 * @param id
	 * @return
	 */
	public List<EmployeeCustom> allBranchEmployees(Integer id);
	
	/**
	 * 根据员工id删除员工
	 * @param id
	 * @return
	 */
	public int delEmp(Integer id);
	
	/**
	 * 根据员工id查询员工详情
	 * @param id
	 * @return
	 */
	public Employee oneEmpl(Integer id);
	
	/**
	 * 查询到全部的权限
	 * @return
	 */
	public List<Authority> authoritys();
	
	public int updateEmpl(EmployeeCustom employeeCustom);

}
