package com.alex.designpattern.observer.session;

import java.util.List;

public class HttpSessionListener implements Listener {

	/**
	 * Listener 编号
	 */
	private static Integer i = 1;

	@Override
	public void update(List<Session> sessions) {
		System.out.print("HttpSessionListener_" + i++ + " -> ");
		for (Session session : sessions) {
			System.out.print(session);
		}
		System.out.println();
	}

	public void onSetSessionAttribute(SessionSubjectImpl subject, Session session){
		List<Session> sessions = subject.getSessions();
		if(sessions.size() == 0){
			sessions.add(session);
			subject.notifyAllListeners();
			return;
		}

		for (Session subjectSession : sessions) {
			if(!subjectSession.getSessionKey().equals(session.getSessionKey())){
				sessions.add(session);
			}
		}
		subject.notifyAllListeners();
	}

	public void onRemoveSessionAttribute(SessionSubjectImpl subject, Session session){
		List<Session> sessions = subject.getSessions();
		for (Session session1 : sessions) {
			if(session1.getSessionKey().equals(session.getSessionKey())){
				sessions.remove(session);
			}
		}
		subject.notifyAllListeners();
	}

	public void onRemoveSessionAttribute(SessionSubjectImpl subject, String key){
		List<Session> sessions = subject.getSessions();
		sessions.removeIf(session1 -> session1.getSessionKey().equals(key));
		subject.notifyAllListeners();
	}
}
