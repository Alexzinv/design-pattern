package com.alex.designpattern.chainofresponsibility.cooperateaprove;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.text.SimpleDateFormat;

public class Client {

	/**
	 * 构建审批链
	 * @return 链入口
	 */
	private static Approver constructor(){
		Approver director = new Director("张三");
		Approver vicePresident = new VicePresident("李四");
		Approver president = new President("王五");
		Approver congress = new Congress("xx公司");

		director.setSuccessor(vicePresident);
		vicePresident.setSuccessor(president);
		president.setSuccessor(congress);
		return director;
	}

	/**
	 * 打印结果
	 * @param results 审批结果
	 */
	public static void outputResult(JSONArray results){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for(int i=0; i<results.size(); i++){
			JSONObject result = results.getJSONObject(i);
			System.out.println("审批人：" + result.getStr("approver"));
			System.out.println("审批人角色：" + result.getStr("approverTitle"));
			System.out.println("审批结果：" + result.getStr("approveResult"));
			System.out.println("审批意见：" + result.getStr("comment"));
			System.out.println("审批时间：" + sdf.format(result.getDate("approveTime")));
			System.out.println("------------------------------");
		}
	}

	public static void main(String[] args) {
		int[] amounts = {4, 8, 20, 200};
		Approver director = constructor();

		for(int i=1; i<=12; i++){
			PuchaseRequest request = new PuchaseRequest(amounts[(i-1)%4], i, "库存扩充");
			director.processRequest(request);
			outputResult(request.getApproveResults());
			System.out.println();
		}
	}
}
