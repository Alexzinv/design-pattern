package com.alex.designpattern.observer.session;

import java.util.HashMap;
import java.util.Map;

public class Client {
	public static void main(String[] args) {

		SessionSubjectImpl subject = new SessionSubjectImpl();
		HttpSessionListener listener = new HttpSessionListener();
		HttpSessionListener listener1 = new HttpSessionListener();

		// 注册listener
		subject.addListener(listener);
		subject.addListener(listener1);

		// session值
		Map<String, String> sessionVal = new HashMap<>();
		sessionVal.put("a", "fadAWagSsaga");
		sessionVal.put("b", "sfaDgagGewDf");

		listener.onSetSessionAttribute(subject, new Session("sKey", sessionVal));
		listener1.onRemoveSessionAttribute(subject, "sKey");

	}
}
