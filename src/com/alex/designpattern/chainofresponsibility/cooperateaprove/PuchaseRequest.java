package com.alex.designpattern.chainofresponsibility.cooperateaprove;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

/**
 * 采购申请单
 */
public class PuchaseRequest {
	private int amount;         // 采购金额
	private int number;         // 申请单号
	private String purpose;     // 采购目的
	private JSONArray approveResult = new JSONArray();   // 存放各个节点的审批结果

	public PuchaseRequest(int amount, int number, String purpose){
		this.amount = amount;
		this.number = number;
		this.purpose = purpose;
	}

	public JSONArray getApproveResults() {
		return approveResult;
	}

	public void addResult(JSONObject result){
		approveResult.add(result);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public String toString() {
		return "采购申请单{" +
				"amount=" + amount +
				", number=" + number +
				", purpose='" + purpose + '\'' +
				'}';
	}
}
