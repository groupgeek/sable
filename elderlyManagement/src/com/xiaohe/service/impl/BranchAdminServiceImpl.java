package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.Activityrecommend;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Level;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Returnvisit;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.ActivityMapper;
import com.xiaohe.mapper.ActivityrecommendMapper;
import com.xiaohe.mapper.ActivitytypeMapper;
import com.xiaohe.mapper.BranchMapper;
import com.xiaohe.mapper.EmployeeMapper;
import com.xiaohe.mapper.LevelMapper;
import com.xiaohe.mapper.MedicalrecordsMapper;
import com.xiaohe.mapper.MessageMapper;
import com.xiaohe.mapper.OrdersMapper;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ReturnvisitMapper;
import com.xiaohe.mapper.TransactionMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.BranchAdminService;

@Repository("branchAdminService")
public class BranchAdminServiceImpl implements BranchAdminService{
	
	@Autowired
	private ActivityrecommendMapper activityrecommendMapper;
	@Autowired
	private LevelMapper levelMapper;
	@Autowired
	private MedicalrecordsMapper medicalrecordsMapper;
	@Autowired
	private ActivitytypeMapper activitytypeMapper;
	@Autowired
	private BranchMapper branchMapper;
	@Autowired
	private TransactionMapper transactionMapper;

	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private ActivityMapper activityMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ReturnvisitMapper returnvisitMapper;
	
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
	public BigDecimal totalEduIncome(Integer id) {
		return activityMapper.branchEduIncome(id);
	}
	public BigDecimal totalHealIncome(Integer id) {
		return activityMapper.branchHealIncome(id);
	}
	public BigDecimal totalOderIncome(Integer id) {
		return ordersMapper.queryBranchOderIncome(id);
	}
	public Employee onEmployee(Integer id){
		return employeeMapper.selectByPrimaryKey(id);
	}
	/*public List<UserCustom> branchUser(Integer employeeid) {
		return userMapper.branchUserCustoms(employeeid);
	}*/
	public List<UserCustom> branchUser(Integer areaid) {
		return userMapper.branchUserCustoms(areaid);
	}
	public List<MessageCustom> branchMessages(MessageVo messageVo) {
		return messageMapper.branchMessages(messageVo);
	}
	public int branchMessagesCount(Integer id) {
		return messageMapper.branchMessagesCount(id);
	}
	public int branchCountUsers(Integer id) {
		return userMapper.countBranchUser(id);
	}
	public int branchCountActivities(Integer id) {
		return activityMapper.branchCountActivity(id);
	}
	public int brachCountOrders(Integer id) {
		return ordersMapper.branchCountOrders(id);
	}
	public int branchCountProducts(Integer id) {
		return productMapper.branchCountProducts(id);
	}
	public List<ProductCustom> branchHotProduct(Integer id) {
		return productMapper.branchHotProduct(id);
	}
	public List<TransactionCustom> branchAllTran(Integer id) {
		return transactionMapper.branchAlltran(id);
	}
	public List<Returnvisit> branchReturnVist(Integer id) {
		return returnvisitMapper.branchReturnVist(id);
	}
	public List<ActivityCustom> branchActs(Integer id) {
		return activityMapper.branchActs(id);
	}
	public void inertActs(Activity activity) {
		activityMapper.insert(activity);
	}
	public Branch oneBranch(Integer id) {
		return branchMapper.selectByPrimaryKey(id);
	}
	public List<ActivitytypeCustom> allActivityTypes() {
		return activitytypeMapper.AllActTypes();
	}
	public int countActUsers(Integer id) {
		return activityMapper.countActUsers(id);
	}
	public ActivityCustom oneActCustom(Integer id) {
		return activityMapper.oneActivityCustom(id);
	}
	public void delAct(Integer id) {
		activityMapper.deleteByPrimaryKey(id);
	}
	public MedicalrecordsWithBLOBsCustom oneMedRed(Integer id) {
		return medicalrecordsMapper.oneMedicalrecordsWithBLOBsCustom(id);
	}
	public Level oneLev(Integer id) {
		return levelMapper.oneLev(id);
	}
	public void updateMed(MedicalrecordsWithBLOBsCustom med) {
		medicalrecordsMapper.updateMeds(med);
	}
	public User oneUserMed(Integer id) {
		return medicalrecordsMapper.oneUser(id);
	}
	public List<ActivityCustom> acts() {
		return activityMapper.Acts();
	}
	public List<ActivityrecommendCustom> branchActRec(Integer id) {
		return activityrecommendMapper.branchActRec(id);
	}
	/*public Activity act(Integer id){
		return activityMapper.selectByPrimaryKey(id); 
	}*/
	public void delActRec(ActivityrecommendCustom activityrecommendCustom) {
		activityrecommendMapper.deleteByPrimary(activityrecommendCustom);
	}
	public Branch oneBranchByEmployeeId(Integer employeeid) {
		return branchMapper.oneBranch(employeeid);
	}
	public void insertActRec(ActivityrecommendCustom activityrecommendCustom) {
		
		activityrecommendMapper.insert(activityrecommendCustom);
		
	}
	public ActivityrecommendCustom oneActRecById(
			ActivityrecommendCustom activityrecommendCustom) {
		return activityrecommendMapper.selectByPrimary(activityrecommendCustom);
	}
	public int countRecAct(Integer id) {
		return activityrecommendMapper.countActRec(id);
	}
}
