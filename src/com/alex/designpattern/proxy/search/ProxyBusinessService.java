package com.alex.designpattern.proxy.search;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class ProxyBusinessService implements BusinessService {

	private RealBusinessService service = new RealBusinessService();

	@Override
	public void setDao(BusinessDao dao) {
		service.setDao(dao);
	}

	@Override
	public BusinessDao getDao() {
		return service.getDao();
	}

	@Override
	public JSONObject findCustomer(String userId, String userPass, String custId) {
		List<String> allowedRoles = Arrays.asList("admin", "normal");

		JSONObject user = authentic(userId, userPass, allowedRoles);
		JSONObject result = service.findCustomer(userId, userPass, custId);
		System.out.println("log:" + DateUtil.now() + " 用户" + user + "访问findCustomer方法，结果=" + result);
		return result;
	}

	/**
	 * 验证用户
	 * @param userId  用户id
	 * @param userPass  用户密码
	 * @param allowedRoles 用户权限角色
	 * @return user
	 */
	private JSONObject authentic(String userId, String userPass, List<String> allowedRoles){
		BusinessDao dao = getDao();
		JSONObject user = dao.getUser(userId);
		if(null == user){
			System.err.println("用户" + userId + "不存在");
			return null;
		}

		boolean b = dao.checkUserPass(userId, userPass);
		if(!b){
			System.err.println("用户" + userId + "密码不正确");
			return null;
		}

		String userRole = user.getStr("userRole");
		if(!allowedRoles.contains(userRole)){
			System.err.println("用户" + userId + "(角色:" + userRole + "无权访问该方法)");
			return null;
		}
		System.out.println("用户" + user + "验证通过, 开始调用本方法");
		return user;
	}

	@Override
	public void addCustomer(String userId, String userPass, JSONObject jsonCustomer) {
		List<String> allowedRoles = Arrays.asList("admin");
		JSONObject user = authentic(userId, userPass, allowedRoles);
		if(null == user){
			return;
		}
		service.addCustomer(userId, userPass, jsonCustomer);
		System.out.println("log:" + DateUtil.now() + " 用户" + user + "访问addCustomer方法，参数=" + jsonCustomer);
	}

	@Override
	public void addCustomers(String userId, String userPass, List<JSONObject> jsonCustomers) {
		List<String> allowedRoles = Arrays.asList("admin");
		JSONObject user = authentic(userId, userPass, allowedRoles);
		if(null == user){
			return;
		}
		service.addCustomers(userId, userPass, jsonCustomers);
		System.out.println("log:" + DateUtil.now() + " 用户" + user + "访问addCustomers方法，参数=" + jsonCustomers);
	}
}
