package com.alex.designpattern.observer.session1;

/**
 * session的监听接口
 */
public interface SessionListener {

	void onSetSessionAttribute(Session session, String key, Object value);

	void onRemoveSessionAttribute(Session session, String key, Object value);
}
