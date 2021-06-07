package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class NotificationH implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull
	protected Notification notification;
	
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
