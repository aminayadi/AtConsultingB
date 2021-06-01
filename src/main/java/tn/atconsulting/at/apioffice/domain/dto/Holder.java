package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Holder implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	protected Client client;
	protected ConnectionDTO connection;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ConnectionDTO getConnection() {
		return connection;
	}
	public void setConnection(ConnectionDTO connection) {
		this.connection = connection;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
