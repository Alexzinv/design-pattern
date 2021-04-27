package com.alex.designpattern.observer.session1;

import java.util.HashMap;
import java.util.Map;

public class HttpSession extends Session {
	private final Map<String, Object> attrMap = new HashMap<>();

	public HttpSession(){
	}

	@Override
	public void setAttribute(String key, Object value) {
		attrMap.put(key, value);
		notifyListeners(SessionEvent.setAttribute, key, value);
	}

	@Override
	public void removeAttribute(String key) {
		Object value = attrMap.remove(key);
		notifyListeners(SessionEvent.removeAttribute, key, value);
	}
}
