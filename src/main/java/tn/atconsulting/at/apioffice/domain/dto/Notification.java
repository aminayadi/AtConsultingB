package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@OneToMany 
	private Set<Client> clients;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long idN;
	private String text;
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
	

	
	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Notification [clients=" + clients + ", idN=" + idN + ", text=" + text + ", subject=" + subject
				+ ", creationDate=" + creationDate + ", expirationDate=" + expirationDate + ", deleted=" + deleted
				+ "]";
	}
	
	
	
	
	
	
	

}
