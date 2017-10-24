package com.xiaohe.bean;

import java.util.List;

public class EvaluationVo {
	
	private  List<EvaluationCustom> evaluationsList;
	private EvaluationCustom evaluation;
	private Integer pageSum;
	
	
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}

	public List<EvaluationCustom> getEvaluationsList() {
		return evaluationsList;
	}
	public void setEvaluationsList(List<EvaluationCustom> evaluationsList) {
		this.evaluationsList = evaluationsList;
	}
	public EvaluationCustom getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(EvaluationCustom evaluation) {
		this.evaluation = evaluation;
	}
	

}
