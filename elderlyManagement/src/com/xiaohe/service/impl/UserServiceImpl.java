 package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Area;
import com.xiaohe.bean.Authority;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Level;
import com.xiaohe.bean.MedicalrecordsWithBLOBs;
import com.xiaohe.bean.Transaction;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.bean.UserVo;
import com.xiaohe.mapper.AreaMapper;
import com.xiaohe.mapper.AuthorityMapper;
import com.xiaohe.mapper.BranchMapper;
import com.xiaohe.mapper.EmployeeMapper;
import com.xiaohe.mapper.LevelMapper;
import com.xiaohe.mapper.MedicalrecordsMapper;
import com.xiaohe.mapper.TransactionMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.UserService;


@Repository("userService")//注册服务
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	@Autowired
	@Qualifier("transactionMapper")
	private TransactionMapper transactionMapper;
	
	@Autowired
	@Qualifier("medicalrecordsMapper")
	private MedicalrecordsMapper medicalrecordsMapper;
	
/*	@Autowired
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
	private EmployeeMapper employeeMapper;*/
	
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
		return userInfo;
	}


	
	public boolean UpdateUserInfoByUser(UserCustom userInfo) {
		if(userInfo == null) return false;
		if(userInfo.getUserid() == null) return false;
		
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
		if(medicalrecordsMapper.updateByPrimaryKeySelective(med) <= 0) return false;
		//if(employeeMapper.updateByPrimaryKeySelective(manager) < 0) return false;
		
		return true;
	}
	
	
}
