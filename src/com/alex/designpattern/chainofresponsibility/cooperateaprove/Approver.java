package com.alex.designpattern.chainofresponsibility.cooperateaprove;

import cn.hutool.json.JSONObject;

public abstract class Approver {
	protected Approver successor;
	protected String name;

	public Approver(String name){
		this.name = name;
	}

	public Approver getSuccessor() {
		return successor;
	}

	public void setSuccessor(Approver successor) {
		this.successor = successor;
	}

	/**
	 * 审批提交的采购申请单
	 * @param request  申请单
	 * @return  审批结果 {
		 *                  approver:审批人,
		 *                  approverTitle:审批人角色,
		 *                  approveResult:审批结果,
		 *                  comment:审批意见,
		 *                  approveTime:审批时间
	 *                  }
	 */
	public abstract void processRequest(PuchaseRequest request);
}
