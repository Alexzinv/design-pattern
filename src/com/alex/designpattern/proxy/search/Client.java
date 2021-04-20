package com.alex.designpattern.proxy.search;

import cn.hutool.json.JSONObject;

import java.util.ArrayList;
import java.util.Set;

public class Client {
	public static void main(String[] args) {
		ArrayList<JSONObject> testUsers = new ArrayList<>();
		Set<String> userIds = BusinessDataSource.USERS.keySet();
		for (String userId : userIds) {
			JSONObject user = BusinessDataSource.USERS.get(userId);
			testUsers.add(user);
		}

		JSONObject errorUser1 = new JSONObject().set("userId", "99").set("userName", "testAccount1")
				.set("userPass", "111111").set("userRole", "admin");
		JSONObject errorUser2 = new JSONObject().set("userId", "02").set("userName", "rick")
				.set("userPass", "999999").set("userRole", "normal");

		testUsers.add(errorUser1);
		testUsers.add(errorUser2);

		BusinessDao dao = new BusinessDao();
		ProxyBusinessService service = new ProxyBusinessService();
		service.setDao(dao);

		int i = 1;
		for (JSONObject user : testUsers) {
			String userId = user.getStr("userId");
			String userPass = user.getStr("userPass");
			JSONObject customer = service.findCustomer(userId, userPass, "005");
			JSONObject newCustomer = new JSONObject().set("custId", "88" + i).set("custName", "新客户" + i)
					.set("custLevel", 200 + i++);
		}
	}
}
