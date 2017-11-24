package com.xiaohe.bean;

import java.util.List;
import java.util.Map;

public class AddActivityVo {
	private Map<String, List<ActivitytypeCustom>> allTypes;
	private List<BranchCustom> allBranchs;
	
	public List<BranchCustom> getAllBranchs() {
		return allBranchs;
	}
	public void setAllBranchs(List<BranchCustom> allBranchs) {
		this.allBranchs = allBranchs;
	}
	public Map<String, List<ActivitytypeCustom>> getAllTypes() {
		return allTypes;
	}
	public void setAllTypes(
			Map<String, List<ActivitytypeCustom>> allTypes) {
		this.allTypes = allTypes;
	}
	
}
