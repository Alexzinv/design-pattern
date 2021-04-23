package com.alex.designpattern.chainofresponsibility.cooperateaprove;

import cn.hutool.json.JSONObject;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 审批节点,副董事长
 */
public class Congress extends Approver {
	public Congress(String name) {
		super(name);
	}

	@Override
	public void processRequest(PuchaseRequest request) {
		System.out.println(name + "开始审批...");

		// 模拟思考
		try {
			TimeUnit.SECONDS.sleep((long)(new Random().nextInt(5)+1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JSONObject result = new JSONObject();
		request.addResult(result);
		result.set("number", request.getNumber()).set("approver", name).set("approverTitle", "董事会")
				.set("approveTime", Calendar.getInstance().getTime());
		if(Math.random() < 0.5){
			result.set("approveResult", false).set("comment", "供应商资质有问题");
		}else{
			result.set("approveResult", true).set("comment", "同意申请");
		}
	}
}
