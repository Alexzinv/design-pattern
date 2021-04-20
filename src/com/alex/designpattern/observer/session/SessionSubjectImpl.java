package com.alex.designpattern.observer.session;

import java.util.ArrayList;
import java.util.List;

public class SessionSubjectImpl implements SessionSubject {

	private final List<Listener> listeners;
	protected List<Session> sessions;

	public SessionSubjectImpl(){
		listeners = new ArrayList<>();
		sessions = new ArrayList<>();
	}

	public List<Session> getSessions() {
		return sessions;
	}

	@Override
	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeListener(Listener listener) {
		if(null != listener){
			listeners.remove(listener);
		}
	}

	@Override
	public void notifyAllListeners() {
		System.out.println("notify all listeners");
		for (Listener listener : listeners) {
			listener.update(sessions);
		}
	}
}
