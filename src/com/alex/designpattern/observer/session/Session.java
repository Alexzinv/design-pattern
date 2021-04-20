package com.alex.designpattern.observer.session;

import java.util.HashMap;
import java.util.Map;

public class Session {

	private String sessionKey;
	private Map<String, String> sessionValue = new HashMap<>();

	public Session(){
	}

	public Session(String sessionKey, Map<String, String> sessionV) {
		this.sessionKey = sessionKey;
		this.sessionValue = sessionV;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public Map<String, String> getSessionValue() {
		return sessionValue;
	}

	public void setSessionValue(Map<String, String> sessionValue) {
		this.sessionValue = sessionValue;
	}

	@Override
	public String toString() {
		return "Session{" +
				"sessionKey='" + sessionKey + '\'' +
				", sessionValue=" + sessionValue +
				'}';
	}
}
