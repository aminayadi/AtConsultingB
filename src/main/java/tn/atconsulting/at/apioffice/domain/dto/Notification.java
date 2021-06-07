package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;







@Entity
@Table(name="Notification")
public class Notification implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	private long idN;
	private String text;
	private int idC;
	private String subject;

	private	String  creationDate;

	
	public String  expirationDate;
	public String deleted;
	
	
	
	
	//----------------------------Getter and setter-----------------------------------
	
	
	
	
	public String getText() {
		return text;
	}
	public long getIdN() {
		return idN;
	}
	public void setIdN(long idN) {
		this.idN = idN;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	@Override
	public String toString() {
		return "Notification [idN=" + idN + ", text=" + text + ", idC=" + idC + ", subject=" + subject
				+ ", creationDate=" + creationDate + ", expirationDate=" + expirationDate + ", deleted=" + deleted
				+ "]";
	}
	
	
	
	
	
	

}
