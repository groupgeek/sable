 package com.xiaohe.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.Area;
import com.xiaohe.bean.Authority;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.Integral;
import com.xiaohe.bean.IntegralCustom;
import com.xiaohe.bean.Level;
import com.xiaohe.bean.MedicalrecordsWithBLOBs;
import com.xiaohe.bean.MedicalrecordsWithBLOBsCustom;
import com.xiaohe.bean.OrdersCountVo;
import com.xiaohe.bean.OrdersCustom;
import com.xiaohe.bean.Returnvisit;
import com.xiaohe.bean.ShippingAddVo;
import com.xiaohe.bean.ShippingAddressCustom;
import com.xiaohe.bean.Transaction;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;
import com.xiaohe.bean.Verificationcode;
import com.xiaohe.mapper.ActivityMapper;
import com.xiaohe.mapper.AreaMapper;
import com.xiaohe.mapper.AuthorityMapper;
import com.xiaohe.mapper.BranchMapper;
import com.xiaohe.mapper.EmployeeMapper;
import com.xiaohe.mapper.EvaluationMapper;
import com.xiaohe.mapper.IntegralMapper;
import com.xiaohe.mapper.LevelMapper;
import com.xiaohe.mapper.MedicalrecordsMapper;
import com.xiaohe.mapper.OrdersMapper;
import com.xiaohe.mapper.ReturnvisitMapper;
import com.xiaohe.mapper.ShippingaddressMapper;
import com.xiaohe.mapper.ShoppingcarMapper;
import com.xiaohe.mapper.TransactionMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.mapper.VerificationcodeMapper;
import com.xiaohe.service.UserService;
import com.xiaohe.util.DeleteFile;
import com.xiaohe.util.FileUpload;
import com.xiaohe.util.GetStringByDate;
import com.xiaohe.util.VCode;
import com.xiaohe.util.sms.httpApiDemo.IndustrySMS;


@Repository("userService")//注册服务
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	@Autowired
	@Qualifier("transactionMapper")
	private TransactionMapper transactionMapper;
	
	@Autowired
	@Qualifier("medicalrecordsMapper")
	private MedicalrecordsMapper medicalrecordsMapper;
	
	@Autowired
	@Qualifier("returnvisitMapper")
	private ReturnvisitMapper returnvisitMapper;
	
	@Autowired
	@Qualifier("authorityMapper")
	private AuthorityMapper authorityMapper;
	
	@Autowired
	@Qualifier("levelMapper")
	private LevelMapper levelMapper;
	
	@Autowired
	@Qualifier("branchMapper")
	private BranchMapper branchMapper;
	
	@Autowired
	@Qualifier("areaMapper")
	private AreaMapper areaMapper;
	
	@Autowired
	@Qualifier("employeeMapper")
	private EmployeeMapper employeeMapper;
	
	@Autowired
	@Qualifier("shippingaddressMapper")
	private ShippingaddressMapper shippingaddressMapper;
	
	@Autowired
	@Qualifier("ordersMapper")
	private OrdersMapper ordersMapper;
	
	@Autowired
	@Qualifier("evaluationMapper")
	private EvaluationMapper evaluationMapper;
	
	@Autowired
	@Qualifier("integralMapper")
	private IntegralMapper integralMapper;
	
	@Autowired
	@Qualifier("shoppingcarMapper")
	private ShoppingcarMapper shoppingcarMapper;
	
	@Autowired
	@Qualifier("verificationcodeMapper")
	private VerificationcodeMapper verificationcodeMapper;
	
	public Boolean registerUser(UserCustom userCustom) {
		//如果手机号没有被注册 那么就注册该手机号
		if(userMapper.selectUserByPhone(userCustom.getPhone()) == null){
			userCustom.setAccountnumber(userCustom.getPhone());
			
			if(userCustom.getLevelid() == null){
				userCustom.setLevelid(1);
			}
			if(userCustom.getAuthorityid() == null){
				userCustom.setAuthorityid(1);
			}
			if(userCustom.getStatus() == null){
				userCustom.setStatus(true);
			}
			userCustom.setRegistrationdate(new Date());
			userCustom.setOnline(false);
			
			if(userMapper.insertSelective(userCustom)>0){
				UserCustom user = new UserCustom();
				user = userMapper.selectUserByPhone(userCustom.getPhone());
				//创建用户交易表
				BigDecimal totalprice = new BigDecimal(0);
				Transaction transaction = new Transaction();
				transaction.setUserid(user.getUserid());
				transaction.setTotalprice(totalprice);
				transaction.setCycle((float) 0);
				transaction.setCountbuy(0);
				transaction.setFrequency((float) 0);
				transactionMapper.insertSelective(transaction);
				
				//创建回访表
				Returnvisit returnvisit = new Returnvisit();
				returnvisit.setUserid(user.getUserid());
				returnvisit.setUsername(user.getUsername());
				returnvisitMapper.insertSelective(returnvisit);
				
				//赠送积分
				
				IntegralCustom condetion = new IntegralCustom();
				condetion.setCurrentPage(1);
				condetion.setPageNum(1);
				condetion.setUserid(user.getUserid());
				
				IntegralCustom integral = new IntegralCustom();
				integral.setUserid(user.getUserid());
				integral.setChangetime(new Date());
				IntegralCustom temp = integralMapper.selectUpToDateRecord(condetion);
				if(temp == null){
					integral.setChangeintegral(10);
					integral.setDetails("用户注册赠送");
					integral.setRemainingpoints(10);
					
				}else{
					integral.setChangeintegral(Integer.parseInt(userCustom.getIntegral()));
					integral.setDetails("管理员赠送");
					integral.setRemainingpoints(Integer.parseInt(userCustom.getIntegral()) + temp.getRemainingpoints());
				}
				integralMapper.insertSelective(integral);
				
				//创建用户病例表
				MedicalrecordsWithBLOBs userMed = new MedicalrecordsWithBLOBs();
				if(userCustom.getMed() != null){
					userMed = userCustom.getMed();
					userMed.setUserid(user.getUserid());
					userMed.setUsername(user.getUsername());
				}else{
					userMed.setUserid(user.getUserid());
					userMed.setUsername(user.getUsername());
				}
				medicalrecordsMapper.insertSelective(userMed);
				
				user.setOnline(true);
				userMapper.changeOnLine(user);
				return true;
			}
			return false;
			
		}else {
			return false;
		}
	}

	public UserCustom loginUser(UserCustom userCustom) {
		UserCustom custom = userMapper.selectUserByPhone(userCustom.getPhone());
		if(custom == null){
			
			return null;
			
		}else if(!custom.getStatus()){
			custom.setStatusMessage("账号被禁");
			return custom;
			
		}else if(custom.getPassword().equals(userCustom.getPassword()) == false){
			
			return  null;
			
		}else{
			custom.setOnline(true);
			userMapper.changeOnLine(custom);
			return custom;
		}
	}

	public boolean changeUserOnline(UserCustom userCustom) {
		
		if(userMapper.changeOnLine(userCustom)>1){
			return true;
		}else{
			
			return false;
		}
	}

	public UserVo queryAllUserByCondition(UserCustom condition) {
		UserVo allUserInfo = new UserVo();
		List<UserCustom> userList = new ArrayList<UserCustom>();
		Integer sum = 0;
		Integer pageNum = 0;//总页数
		
		
		if(condition != null){
			condition.setUsername(condition.getSearch());
			if(condition.getCurrentPage() >= 1){
				Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
				condition.setBegin(tempBegin);
			}else{
				condition.setBegin(0);
			}
			
		}
		
		userList = userMapper.selectAllUserByCondition(condition);
		for(UserCustom temp : userList){
			temp.setDateStringRegistrationdate(GetStringByDate.getString(temp.getRegistrationdate()));
		}
		
		sum = userMapper.selectAllUserSumByCondition(condition);
		pageNum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageNum +=  1;
		}
		allUserInfo.setUserSum(sum);
		allUserInfo.setUserList(userList);
		allUserInfo.setPageSum(pageNum);
		
		return allUserInfo;
	}

	public UserCustom queryUserInfoById(Integer id) {
		if(id == null || id < 0){
			return null;
		}
		UserCustom userInfo = userMapper.selectUserInfoById(id);
		if(userInfo == null) return null;
		userInfo.setDateStringRegistrationdate(GetStringByDate.getString(userInfo.getRegistrationdate()));
		if(userInfo.getBirthday() != null)
		userInfo.setBirthdayString(GetStringByDate.getString(userInfo.getBirthday()));
		return userInfo;
	}


	
	public boolean UpdateUserInfoByUser(UserCustom userInfo,MultipartFile pictureUpload) {
		if(userInfo == null) return false;
		if(userInfo.getUserid() == null) return false;
		
		if(pictureUpload != null){
			if(!pictureUpload.isEmpty()){
				try {
					userInfo.setAvatar(FileUpload.oneFileUpload(pictureUpload,userInfo.getAvatar(), "picture"));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(userInfo.getIntegral() != null){
			//更新积分
			IntegralCustom condetion = new IntegralCustom();
			condetion.setCurrentPage(1);
			condetion.setPageNum(1);
			condetion.setUserid(userInfo.getUserid());
			
			IntegralCustom integral = new IntegralCustom();
			integral.setUserid(userInfo.getUserid());
			integral.setChangetime(new Date());
			
			IntegralCustom temp = integralMapper.selectUpToDateRecord(condetion);
			
				integral.setChangeintegral(Integer.parseInt(userInfo.getIntegral()) - temp.getRemainingpoints());
				integral.setDetails("管理员更新");
				integral.setRemainingpoints(Integer.parseInt(userInfo.getIntegral()));
			
			integralMapper.insertSelective(integral);
		}
		
		
		
		
		
		//User user = new User();
		
		//Authority authority = userInfo.getAuthority();
		//Level level = userInfo.getLevel();
		//Branch branch = userInfo.getBranch(); 
		//Area area = userInfo.getArea();
		MedicalrecordsWithBLOBs med = userInfo.getMed();
		//Employee manager = userInfo.getManager();
		
		if(userMapper.updateByPrimaryKeySelective(userInfo) <= 0) return false;
		//if(authorityMapper.updateByPrimaryKeySelective(authority) < 0) return false;
		//if(levelMapper.updateByPrimaryKeySelective(level) < 0) return false;
		//if(branchMapper.updateByPrimaryKeySelective(branch) < 0) return false;
		//if(areaMapper.updateByPrimaryKeySelective(area) < 0) return false;
		if(med != null){
			if(medicalrecordsMapper.updateByPrimaryKeySelective(med) <= 0) return false;
		}
		//if(employeeMapper.updateByPrimaryKeySelective(manager) < 0) return false;
		
		return true;
	}

	public ShippingAddVo queryAllAddressByUserid(Integer userid) {
		if(userid == null) return null;
		ShippingAddVo vo = new ShippingAddVo();
		List<ShippingAddressCustom> addresssList = new ArrayList<ShippingAddressCustom>();
		UserCustom user = new UserCustom();
		addresssList = shippingaddressMapper.selectAllAddressByUserid(userid);
		user = userMapper.selectUserInfoById(userid);
		vo.setAddresssList(addresssList);
		vo.setUser(user);
		return vo;
	}

	public ShippingAddressCustom updateDefaultReturnOld(ShippingAddressCustom condition) {
		if(condition == null) return null;
		ShippingAddressCustom  record = new ShippingAddressCustom();
		ShippingAddressCustom old = shippingaddressMapper.selectDefaultAddressByByUserid(condition.getUserid());
		
		if(old == null) return null;
		
		//更新原来的默认地址
		record.setShippingaddressid(old.getShippingaddressid());
		record.setDefaultaddress(false);
		if(shippingaddressMapper.updateByPrimaryKeySelective(record) < 0) return null;
		
		//更新现在的默认地址
		record.setShippingaddressid(condition.getShippingaddressid());
		record.setDefaultaddress(true);
		if(shippingaddressMapper.updateByPrimaryKeySelective(record) < 0) return null;
		
		return old;
	}

	public ShippingAddressCustom addAddressReturnAddress(
			ShippingAddressCustom addressInfo) {
		
		//添加
		if(shippingaddressMapper.insertSelective(addressInfo) <= 0) return null;
		
		return addressInfo;
	}

	public List<OrdersCustom> queryOrdersByLogo(String logo, User user) {
		if(logo == null || user == null) return null;
		List<OrdersCustom> list = new ArrayList<OrdersCustom>();
		OrdersCustom condition = new OrdersCustom();
		condition.setUserid(user.getUserid());
		if("pendingPayment".equals(logo)){
			condition.setOrderstatus("未付款");
		}
		
		if("tobeDelivered".equals(logo)){
			condition.setProductstatus("未发货");
		}
		
		if("tobeReceived".equals(logo)){
			condition.setSignstatus("未签收");
		}
		
		if("beEvaluated".equals(logo)){
			condition.setEvaluationstatus(false);
		}
		
		list = ordersMapper.selectOrdersByLogo(condition);
		
		//时间处理
		
		for(OrdersCustom info : list){
			info.setOrdertimeString(GetStringByDate.getString(info.getOrdertime()));
			info.setPaymenttimeString(GetStringByDate.getString(info.getPaymenttime()));
			info.setTimeofarrivalString(GetStringByDate.getString(info.getTimeofarrival()));
			info.setSubmissiontimeString(GetStringByDate.getString(info.getSubmissiontime()));
		}
		
		return list;
	}

	public OrdersCountVo queryCountByLogo(User user) {
		OrdersCountVo sum = new OrdersCountVo();
		
		Integer pendingPayment = 0;
		Integer tobeDelivered = 0;
		Integer tobeReceived = 0;
		Integer beEvaluated = 0;
		Integer all = 0;
		if(user == null) return null;
		if(user.getUserid() == null) return null;
		OrdersCustom condition = new OrdersCustom();
		condition.setUserid(user.getUserid());
		//condition.setUserid(12);
			condition.setOrderstatus("未付款");
			pendingPayment = ordersMapper.selectCountByLogo(condition);
			condition.setOrderstatus(null);
			
			condition.setProductstatus("未发货");
			tobeDelivered = ordersMapper.selectCountByLogo(condition);
			condition.setProductstatus(null);
			
			condition.setSignstatus("未签收");
			tobeReceived = ordersMapper.selectCountByLogo(condition);
			condition.setSignstatus(null);
			
			condition.setEvaluationstatus(false);
			beEvaluated = ordersMapper.selectCountByLogo(condition);
			condition.setEvaluationstatus(null);
		
			sum.setPendingPayment(pendingPayment);
			sum.setTobeDelivered(tobeDelivered);
			sum.setTobeReceived(tobeReceived);
			sum.setBeEvaluated(beEvaluated);
			sum.setAll(pendingPayment + tobeDelivered + tobeReceived + beEvaluated);
			
		return sum;
	}

	public List<EvaluationCustom> queryAllEvaluationByUserid(Integer userid) {
		if(userid == null) return null;
		
		List<EvaluationCustom> all = new ArrayList<EvaluationCustom>();
		all = evaluationMapper.selectAllByUserId(userid);
		
		for(EvaluationCustom temp : all){
			temp.setStringDate(GetStringByDate.getString(temp.getCommentdate()));
		}
		
		return all;
	}

	public boolean deleteUser(Integer userid) {
		if(userid == null) return false;
		UserCustom user = new UserCustom();
		user = userMapper.selectUserById(userid);
		if(userMapper.deleteByPrimaryKey(userid) <= 0) return false;
		if(!DeleteFile.deleteFile(user.getAvatar())) return false;
		
		return true;
	}

	public boolean updateUserPassword(UserCustom info) {
		
		if(info == null) return false;
		if(info.getUserid() == null) return false;
		
		UserCustom user = new UserCustom();
		user = userMapper.selectUserById(info.getUserid());
		
		if(user == null) return false;
		if(user.getPassword() == null) return false;
		//判断密码
		if(!user.getPassword().equals(info.getOldPassword())) return false;
		
		//更新密码
		info.setPassword(info.getNewPassword());
		if(userMapper.updateByPrimaryKeySelective(info) <= 0) return false;
		
		
		
		return true;
	}

	public Integer queryCartNum(Integer userid) {
		
		if(userid == null) return null;
		
		Integer num = shoppingcarMapper.selectCartCount(userid);
		
		return num;
	}
	
	public UserCustom userInfo(String phone) {
		return userMapper.selectUserByPhone(phone);
	}

	public Level onelevel(Integer id) {
		return levelMapper.oneLev(id);
	}

	public int updateUser(UserCustom user,MultipartFile file){
		String avater = user.getAvatar();
		String path = "D:\\code\\web\\upload\\";
		String filename = null;
		
		if(!file.isEmpty()){
			File avaterFile = new File(path+avater);
			if(avaterFile.exists()){
				if(avaterFile.isFile()){
					avaterFile.delete();
				}
			}
			try {
				filename = FileUpload.oneFileUpload(file, null, "picture");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			filename = user.getAvatar();
		}
		
		if(filename!=null){
			user.setAvatar(filename);
			}
		userMapper.updateByPrimaryKeySelective(user);
		return 0;
	}

	public MedicalrecordsWithBLOBsCustom oneMed(Integer id) {
		return medicalrecordsMapper.oneMedicalrecordsWithBLOBsCustom(id);
	}

	public List<ActivityCustom> userActs(Integer id) {
		return activityMapper.allActs(id);
	}

	public int updatemed(
			MedicalrecordsWithBLOBsCustom medicalrecordsWithBLOBsCustom) {
		medicalrecordsMapper.updateByPrimaryKeySelective(medicalrecordsWithBLOBsCustom);
		return 0;
	}
	
public String sendUserVCode(String phone) {
		
		if(phone == null || phone == "") return null;
		phone = phone.substring(1,phone.length()-1);
		//验证手机号
		UserCustom user = new UserCustom();
		user = userMapper.selectUserByPhone(phone);
		if(user == null) return null;
		
		
		String to = phone;
		String vcode = VCode.getRandNum(6);
		String param = vcode+",5";
		
		
		String result = "";
		 try {
			result = IndustrySMS.execute(to,param);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		 if(result == null || result == "") return null;
		 
		 String flag = result.split(",")[0].split(":")[1];
		 flag = flag.substring(1,flag.length()-1);
		
		 /**
		  * result:{"respCode":"00141","respDesc":"一小时内发送给单个手机次数超过限制(验证类短信：同一签名同一手机号码1小时内发送次应小于等于4, 手机号=18584430401, 签名=孝和集团)"}
		  */
		 if(!"00000".equals(flag)) return null;
		 
		 Verificationcode record = new Verificationcode();
		 record.setPhone(phone);
		 record.setDate(new Date());
		 record.setVerificationcode(vcode);
		 record.setStatus(false);
		 
		 //查询是否有之前的记录 有就删掉
		 if(verificationcodeMapper.selectByPrimaryKey(phone) != null){
			 verificationcodeMapper.deleteByPrimaryKey(phone);
		 }
		//记录到数据库
		 if(verificationcodeMapper.insertSelective(record) <= 0) return null;
		 
		 
		return vcode;
	}
	
	
	public boolean updateVcodeStasus(String phone){
		
		if(phone == null) return false;
		phone = phone.substring(1,phone.length()-1);
		
		Verificationcode record = new Verificationcode();
		record.setPhone(phone);
		record.setStatus(true);
		
		if(verificationcodeMapper.updateByPrimaryKeySelective(record) <= 0) return false;
		
		return true;
	}

	public boolean retrieveThePassword(UserCustom info) {
		if(info == null) return false;
		if(info.getPhone() == null || info.getNewPassword() == null) return false;
		
		//判断号码是否通过短信验证
		Verificationcode record = new Verificationcode();
		
		record = verificationcodeMapper.selectByPrimaryKey(info.getPhone());
		if(record == null) return false;
		
		if(!record.getStatus()) return false;
		
		if(userMapper.retrieveThePassword(info) <= 0) return false;
		
		//删除短信记录
		verificationcodeMapper.deleteByPrimaryKey(info.getPhone());
		
		return true;
	}
	
}
