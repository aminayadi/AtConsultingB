package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Log")
public class Log implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	private long idLog;
	private int idUser;
	private String OpDescription;
	private String Date;
	private String Deleted;
	public long getIdLog() {
		return idLog;
	}
	public void setIdLog(long idLog) {
		this.idLog = idLog;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	public void setDeleted(String deleted) {
		Deleted = deleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Log [idLog=" + idLog + ", idUser=" + idUser + ", OpDescription=" + OpDescription + ", Date=" + Date
				+ ", Deleted=" + Deleted + "]";
	}
	

	
	
	
	
}
