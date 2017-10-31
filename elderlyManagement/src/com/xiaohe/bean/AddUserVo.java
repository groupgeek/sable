package com.xiaohe.bean;

import java.util.List;

public class AddUserVo {

	private List<AuthorityCustom> allAuthority;
	private List<AreaCustom> allArea;
	private List<LevelCustom> allLevel;
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
	public List<LevelCustom> getAllLevel() {
		return allLevel;
	}
	public void setAllLevel(List<LevelCustom> allLevel) {
		this.allLevel = allLevel;
	}
	
}
