package com.alex.designpattern.proxy.search;

import cn.hutool.json.JSONObject;

/**
 * Dao层
 */
public class BusinessDao {

	/**
	 * 使用userId获取user对象
	 * @param userId user id
	 * @return user
	 */
	public JSONObject getUser(String userId){
		return BusinessDataSource.USERS.get(userId);
	}

	/**
	 * 验证用户密码
	 * @param userId 用户名
	 * @param userPass 密码
	 * @return 是否存在
	 */
	public boolean checkUserPass(String userId, String userPass){
		JSONObject user = getUser(userId);
		if(null == user){
			return false;
		}
		return user.getStr("userPass").equals(userPass);
	}

	/**
	 * 查找customer
	 * @param custId customer id
	 * @return customer对象
	 */
	public JSONObject findCustomer(String custId){
		for (JSONObject customer : BusinessDataSource.CUSTOMERS) {
			if(customer.getStr("custId").equals(custId)){
				return customer;
			}
		}
		return null;
	}

	/**
	 * 添加一个customer
	 * @param jsonCustomer customer的json对象
	 */
	public void addCustomer(JSONObject jsonCustomer){
		BusinessDataSource.CUSTOMERS.add(jsonCustomer);
	}
}
