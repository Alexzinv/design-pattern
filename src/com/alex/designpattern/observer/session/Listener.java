package com.alex.designpattern.observer.session;


import java.util.List;

public interface Listener {

	void update(List<Session> sessions);

	void onSetSessionAttribute(SessionSubjectImpl subject, Session session);

	void onRemoveSessionAttribute(SessionSubjectImpl subject, Session session);
}
