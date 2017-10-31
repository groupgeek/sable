package com.xiaohe.bean;

import java.util.List;

public class AddEmployeeVo {
	private List<AuthorityCustom> allAuthority;
	private List<AreaCustom> allArea;
	private List<PositionalCustom> allPosittonal;
	public List<AuthorityCustom> getAllAuthority() {
		return allAuthority;
	}
	public void setAllAuthority(List<AuthorityCustom> allAuthority) {
		this.allAuthority = allAuthority;
	}
	public List<AreaCustom> getAllArea() {
		return allArea;
	}
	public void setAllArea(List<AreaCustom> allArea) {
		this.allArea = allArea;
	}
	public List<PositionalCustom> getAllPosittonal() {
		return allPosittonal;
	}
	public void setAllPosittonal(List<PositionalCustom> allPosittonal) {
		this.allPosittonal = allPosittonal;
	}
	

}
