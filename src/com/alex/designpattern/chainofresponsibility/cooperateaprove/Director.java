package com.alex.designpattern.chainofresponsibility.cooperateaprove;

import cn.hutool.json.JSONObject;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 审批节点,主任
 */
public class Director extends Approver {

	public Director(String name) {
		super(name);
	}

	@Override
	public void processRequest(PuchaseRequest request) {
		System.out.println(name + "开始审批...");
		System.out.println(request);

		// 模拟思考
		try {
			TimeUnit.SECONDS.sleep((long)(new Random().nextInt(5)+1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JSONObject result = new JSONObject();
		request.addResult(result);
		result.set("number", request.getNumber()).set("approver", name).set("approverTitle", "主任")
				.set("approveTime", Calendar.getInstance().getTime());
		if(Math.random() < 0.4){
			result.set("approveResult", false).set("comment", "申请不通过，填写不符合标准");
		}else{
			result.set("approveResult", true).set("comment", "同意申请");
			if(request.getAmount() >= 5){
				result.set("comment", "同意申请，请副董事长签阅");
				successor.processRequest(request);
			}
		}
	}
}
