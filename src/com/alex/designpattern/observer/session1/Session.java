package com.alex.designpattern.observer.session1;

import java.util.ArrayList;
import java.util.List;

public abstract class Session {

	/**
	 * session id
	 */
	protected String sessionId;

	/**
	 * session监听器列表
	 */
	protected List<SessionListener> sessionListeners = new ArrayList<>();

	public abstract void setAttribute(String key, Object value);

	public abstract void removeAttribute(String key);

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void addListener(SessionListener listener){
		this.sessionListeners.add(listener);
	}

	public void removeListener(SessionListener listener){
		this.sessionListeners.remove(listener);
	}

	/**
	 * Session变化时发送通知
	 */
	protected void notifyListeners(SessionEvent event, String key, Object value){
		for (SessionListener listener : sessionListeners) {
			if(event == SessionEvent.setAttribute){
				listener.onSetSessionAttribute(this, key, value);
			}else if(event == SessionEvent.removeAttribute){
				listener.onRemoveSessionAttribute(this, key, value);
			}
		}
	}
}
