package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LogH implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull
	protected Log log;

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
