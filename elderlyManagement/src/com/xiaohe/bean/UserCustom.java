package com.xiaohe.bean;

public class UserCustom extends User{
	private String statusMessage;
	
	private Integer begin;
	private Integer pageNum;//每一页的数量
	private Integer currentPage;
	private Integer total;//总条数
	private String search;
	private Integer onLineNum;//在线人数
	private String sort;

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	private Integer branchid;//分店id
	
	private AuthorityCustom authority;
	private LevelCustom level;
	private BranchCustom branch;
	private AreaCustom area;
	private MedicalrecordsWithBLOBsCustom med;
	private EmployeeCustom manager;
	
	private Integer usernumber;
    private String branchname;
    private String stringDate;
    private String stringregistrationdate;
    private String stringuser;
	
    private String dateStringRegistrationdate;//时间转换
    
    private String birthdayString;
    
    //密码修改
    private String oldPassword;
    private String newPassword;
    
    //签收
    private String orderid;
    
    
    
    
    
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getBirthdayString() {
		return birthdayString;
	}

	public void setBirthdayString(String birthdayString) {
		this.birthdayString = birthdayString;
	}

	public String getDateStringRegistrationdate() {
		return dateStringRegistrationdate;
	}

	public void setDateStringRegistrationdate(String dateStringRegistrationdate) {
		this.dateStringRegistrationdate = dateStringRegistrationdate;
	}

	public AreaCustom getArea() {
		return area;
	}

	public void setArea(AreaCustom area) {
		this.area = area;
	}

	public AuthorityCustom getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityCustom authority) {
		this.authority = authority;
	}

	public LevelCustom getLevel() {
		return level;
	}

	public void setLevel(LevelCustom level) {
		this.level = level;
	}

	public BranchCustom getBranch() {
		return branch;
	}

	public void setBranch(BranchCustom branch) {
		this.branch = branch;
	}

	public MedicalrecordsWithBLOBsCustom getMed() {
		return med;
	}

	public void setMed(MedicalrecordsWithBLOBsCustom med) {
		this.med = med;
	}

	public EmployeeCustom getManager() {
		return manager;
	}

	public void setManager(EmployeeCustom manager) {
		this.manager = manager;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Integer getOnLineNum() {
		return onLineNum;
	}

	public void setOnLineNum(Integer onLineNum) {
		this.onLineNum = onLineNum;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Integer getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(Integer usernumber) {
		this.usernumber = usernumber;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public String getStringregistrationdate() {
		return stringregistrationdate;
	}

	public void setStringregistrationdate(String stringregistrationdate) {
		this.stringregistrationdate = stringregistrationdate;
	}

	public String getStringuser() {
		return stringuser;
	}

	public void setStringuser(String stringuser) {
		this.stringuser = stringuser;
	}
	

}
