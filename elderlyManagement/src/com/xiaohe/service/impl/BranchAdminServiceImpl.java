package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.Activity;
import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.ActivityrecommendCustom;
import com.xiaohe.bean.Activityreport;
import com.xiaohe.bean.Activitytype;
import com.xiaohe.bean.ActivitytypeCustom;
import com.xiaohe.bean.Area;
import com.xiaohe.bean.Authority;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Level;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.MessageVo;
import com.xiaohe.bean.OrdersCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Productrecommend;
import com.xiaohe.bean.ProductrecommendCustom;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.Returnvisit;
import com.xiaohe.bean.TransactionCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.ActivityMapper;
import com.xiaohe.mapper.ActivityrecommendMapper;
import com.xiaohe.mapper.ActivityreportMapper;
import com.xiaohe.mapper.ActivitytypeMapper;
import com.xiaohe.mapper.AreaMapper;
import com.xiaohe.mapper.AuthorityMapper;
import com.xiaohe.mapper.BranchMapper;
import com.xiaohe.mapper.EmployeeMapper;
import com.xiaohe.mapper.LevelMapper;
import com.xiaohe.mapper.MedicalrecordsMapper;
import com.xiaohe.mapper.MessageMapper;
import com.xiaohe.mapper.OrdersMapper;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ProductrecommendMapper;
import com.xiaohe.mapper.ProducttransactionreportMapper;
import com.xiaohe.mapper.ReturnvisitMapper;
import com.xiaohe.mapper.TransactionMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.BranchAdminService;

@Repository("branchAdminService")
public class BranchAdminServiceImpl implements BranchAdminService{
	
	@Autowired
	private ProductrecommendMapper productrecommendMapper;
	@Autowired
	private ActivityreportMapper activityreportMapper;
	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private AuthorityMapper authorityMapper;
	@Autowired
	private ProducttransactionreportMapper producttransactionreportMapper;
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
		return userMapper.selectOneUser(id);
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
	public void inertActs(Activity activity,MultipartFile file) {
		activityMapper.insertSelective(activity);
		
		Activityreport activityreport = new Activityreport();
		activityreport.setCountactivity(0);
		activityreport.setActivityid(activity.getActivityid());
		activityreport.setBranchid(activity.getBranchid());
		activityreport.setDuringtime(activity.getActivitydate());
		activityreport.setTotalprice(new BigDecimal(0));
		activityreport.setTotalexpenditure(activity.getActivityprice());
		activityreport.setAveragepeople(0);
		activityreport.setOnline(activity.getOnline());
		activityreportMapper.insert(activityreport);
		
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
	public int updateAct(Activity activity) {
		return activityMapper.updateByPrimaryKeyWithBLOBs(activity);
	}
	public Activity oneAct(Integer id) {
		return activityMapper.oneAct(id);
	}
	public List<ProductCustom> quertyAllProduct(Integer id) {
		return productMapper.quertyAllProduct(id);
	}
	public List<ProducttransactionreportCustom> selectByCondition(
			ProducttransactionreportCustom producttransactionreportCustom) {
		return producttransactionreportMapper.BranchProductTransation(producttransactionreportCustom);
	}
	public ProductCustom BranchProductCustom(ProductCustom productCustom) {
		return /*productMapper.branchProductCondition(productCustom);*/null;
	}
	public int insertMed(MedicalrecordsWithBLOBsCustom medicalrecordsWithBLOBsCustom) {
		return medicalrecordsMapper.insert(medicalrecordsWithBLOBsCustom);
	}
	public List<EmployeeCustom> allBranchEmployees(Integer id) {
		return employeeMapper.allBrancheEmployees(id);
	}
	public int delEmp(Integer id) {
		return employeeMapper.deleteByPrimaryKey(id);
	}
	public Employee oneEmpl(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	public List<Authority> authoritys() {
		return authorityMapper.allAuths();
	}
	public int updateEmpl(EmployeeCustom employeeCustom) {
		return employeeMapper.updateByCustom(employeeCustom);
	}
	public Activitytype oneActivitytype(Integer id) {
		return activitytypeMapper.selectByPrimaryKey(id);
	}
	public int insertEmpl(Employee employee) {
		employeeMapper.insertSelective(employee);
		return 0;
	}
	public int countEmpl() {
		return employeeMapper.countEmpl();
	}
	public Area oneArea(Integer id) {
		return areaMapper.oneAreaByEmpId(id);
	}
	public int delMed(Integer id) {
		medicalrecordsMapper.deleteByPrimaryKey(id);
		return 0;
	}
	public ProducttransactionreportCustom oneTransation(
			ProducttransactionreportCustom producttransactionreportCustom) {
		return producttransactionreportMapper.oneDayTransation(producttransactionreportCustom);
	}
	public ProducttransactionreportCustom BranchOneProductTransation(
			ProducttransactionreportCustom producttransactionreportCustom) {
		return producttransactionreportMapper.BranchOneProductTransation(producttransactionreportCustom);
	}
	public ActivityCustom branchActivityCondition(ActivityCustom activityCustom) {
		return activityreportMapper.activityCondition(activityCustom);
	}
	public ActivityCustom healthIncome(ActivityCustom activityCustom) {
		return activityMapper.branchHealIncomeReport(activityCustom);
	}
	public ActivityCustom eduIncome(ActivityCustom activityCustom) {
		return activityMapper.branchEduIncomeReport(activityCustom);
	}
	public OrdersCustom orderIncome(OrdersCustom ordersCustom) {
		return ordersMapper.orderReport(ordersCustom);
	}
	public List<ProductCustom> aueryAllBranchProductRec(Integer id) {
		return productrecommendMapper.quertyRecommendProdcut(id);
	}
	public int insertProductRec(Productrecommend product) {
		productrecommendMapper.insert(product);
		return 0;
	}
	public int delProductRec(Integer id) {
		productrecommendMapper.deleteByPrimaryKey(id);
		return 0;
	}
	public ProductrecommendCustom oneProductRec(ProductrecommendCustom productCustom) {
		return productrecommendMapper.oneProductRec(productCustom);
	}
	public int countBranchProductRec(Integer id) {
		return productrecommendMapper.countProductRec(id);
	}
	public ProducttransactionreportCustom onedaySail(
			ProducttransactionreportCustom producttransactionreportCustom) {
		return producttransactionreportMapper.oneDayAllSail(producttransactionreportCustom);
	}
	public ProducttransactionreportCustom onedayAct(
			ProducttransactionreportCustom producttransactionreportCustom) {
		return producttransactionreportMapper.onedayAllAct(producttransactionreportCustom);
	}
	public int insertRecAct(ActivityrecommendCustom avtActivityrecommendCustom) {
		activityrecommendMapper.insertRecAct(avtActivityrecommendCustom);
		return 0;
	}
	public int countActRec(Integer emid) {
		activityrecommendMapper.countActRec(emid);
		return 0;
	}
	public int countActHealthRec(Integer emid) {
		activityrecommendMapper.countActHealthRec(emid);
		return 0;
	}
	public int countActEduRec(Integer emid) {
		activityrecommendMapper.countActEduRec(emid);
		return 0;
	}
	public List<ActivityrecommendCustom> branchActHealthRec(Integer id) {
		return activityrecommendMapper.branchActHealthRec(id);
	}
	public List<ActivityrecommendCustom> branchActEduRec(Integer id) {
		return activityrecommendMapper.branchActEduRec(id);
	}
}
