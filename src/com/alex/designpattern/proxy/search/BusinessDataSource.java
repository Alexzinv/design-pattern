package com.alex.designpattern.proxy.search;

import cn.hutool.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据源
 */
public class BusinessDataSource {

	/**
	 * 管理账户列表
	 */
	public static final Map<String, JSONObject> USERS = new HashMap<>();

	static {
		JSONObject user1 = new JSONObject().set("userId", "001").set("userName", "alex")
				.set("userPass", "111111").set("userRole", "admin");
		JSONObject user2 = new JSONObject().set("userId", "002").set("userName", "davie")
				.set("userPass", "222222").set("userRole", "normal");
		JSONObject user3 = new JSONObject().set("userId", "003").set("userName", "rick")
				.set("userPass", "333333").set("userRole", "guest");

		USERS.put("001", user1);
		USERS.put("002", user2);
		USERS.put("003", user3);
	}

	/**
	 * 用户列表
	 */
	public static final List<JSONObject> CUSTOMERS = new ArrayList<>();

	static {
		for(int i=0; i<10; i++){
			JSONObject cust = new JSONObject().set("custId", "00" + i).set("custName", "客户" + i).set("custLevel", 100 + i);
			CUSTOMERS.add(cust);
		}
	}

}
