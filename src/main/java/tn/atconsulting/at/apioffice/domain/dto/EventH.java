package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class EventH implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull
	protected Event event;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
