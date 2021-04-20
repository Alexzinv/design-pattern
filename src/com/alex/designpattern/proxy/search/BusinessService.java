package com.alex.designpattern.proxy.search;

import cn.hutool.json.JSONObject;

import java.util.List;

/**
 * 服务接口
 */
public interface BusinessService {

	void setDao(BusinessDao dao);

	BusinessDao getDao();

	JSONObject findCustomer(String userId, String userPass, String custId);

	void addCustomer(String userId, String userPass, JSONObject jsonCustomer);

	void addCustomers(String userId, String userPass, List<JSONObject> jsonCustomers);
}
