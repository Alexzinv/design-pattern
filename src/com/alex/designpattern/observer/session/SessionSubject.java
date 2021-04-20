package com.alex.designpattern.observer.session;

public interface SessionSubject {

	void addListener(Listener listener);

	void removeListener(Listener listener);

	//void sessionUpdate(Session session);

	void notifyAllListeners();
}
