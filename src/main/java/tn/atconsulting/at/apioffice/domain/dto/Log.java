package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Log")
public class Log implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	Client client;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	private long idLog;
	private int idClient;
	private String OpDescription;
	private String Date;
	private String Deleted;
	public long getIdLog() {
		return idLog;
	}
	public void setIdLog(long idLog) {
		this.idLog = idLog;
	}
	
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getOpDescription() {
		return OpDescription;
	}
	public void setOpDescription(String opDescription) {
		OpDescription = opDescription;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getDeleted() {
		return Deleted;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setDeleted(String deleted) {
		Deleted = deleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Log [client=" + client + ", idLog=" + idLog + ", idClient=" + idClient + ", OpDescription="
				+ OpDescription + ", Date=" + Date + ", Deleted=" + Deleted + "]";
	}
	

	
	
	
	
}
