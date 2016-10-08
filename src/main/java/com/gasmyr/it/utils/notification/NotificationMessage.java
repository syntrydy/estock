package com.gasmyr.it.utils.notification;

public class NotificationMessage {
	private NotificationMessageType messageType;
	private String message;

	public NotificationMessage(NotificationMessageType messageType, String message) {
		super();
		this.messageType = messageType;
		this.message = message;
	}

	public NotificationMessageType getMessageType() {
		return messageType;
	}

	public String getMessage() {
		return message;
	}

}
