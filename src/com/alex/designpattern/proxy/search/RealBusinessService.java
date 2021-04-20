package com.alex.designpattern.proxy.search;

import cn.hutool.json.JSONObject;

import java.util.List;

/**
 * 服务实现类
 */
public class RealBusinessService implements BusinessService {

	private BusinessDao dao;

	@Override
	public void setDao(BusinessDao dao) {
		this.dao = dao;
	}

	@Override
	public BusinessDao getDao() {
		return dao;
	}

	@Override
	public JSONObject findCustomer(String userId, String userPass, String custId) {
		return dao.findCustomer(custId);
	}

	@Override
	public void addCustomer(String userId, String userPass, JSONObject jsonCustomer) {
		dao.addCustomer(jsonCustomer);
	}

	@Override
	public void addCustomers(String userId, String userPass, List<JSONObject> jsonCustomers) {
		for (JSONObject customer : jsonCustomers) {
			dao.addCustomer(customer);
		}
	}
}
