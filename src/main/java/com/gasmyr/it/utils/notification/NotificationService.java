package com.gasmyr.it.utils.notification;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements NotificationInterface {

	private static final String NOTIFICATION_SESSION_KEY = "MyShop.NotificationService";

	@Autowired
	private HttpSession httpSession;

	@Override
	public void addNotificationSuccessMessage(String message) {
		addNotificationMessage(NotificationMessageType.INFO, message);
	}

	@Override
	public void addNotificationErrorMessage(String message) {
		addNotificationMessage(NotificationMessageType.ERROR, message);
	}

	@SuppressWarnings("unchecked")
	private void addNotificationMessage(NotificationMessageType messageType, String message) {
		List<NotificationMessage> notifyMessages = (List<NotificationMessage>) httpSession
				.getAttribute(NOTIFICATION_SESSION_KEY);
		if (notifyMessages == null) {
			notifyMessages = new ArrayList<NotificationMessage>();
		}
		notifyMessages.add(new NotificationMessage(messageType, message));
		httpSession.setAttribute(NOTIFICATION_SESSION_KEY, notifyMessages);
	}

}
