package com.alex.designpattern.observer.session1;

public class SessionListenerImpl2 implements SessionListener {

	private static int i = 0;

	public SessionListenerImpl2(){
		i++;
	}

	@Override
	public void onSetSessionAttribute(Session session, String key, Object value) {
		System.out.println("Listener_"+ i + "set session | sessionId:" + session.getSessionId());
		System.out.println("key:" + key + " value:" + value.toString());
	}

	@Override
	public void onRemoveSessionAttribute(Session session, String key, Object value) {
		System.out.println("Listener_"+ i + "remove session | sessionId:" + session.getSessionId());
		System.out.println("key:" + key + " value:" + value.toString());
	}
}
