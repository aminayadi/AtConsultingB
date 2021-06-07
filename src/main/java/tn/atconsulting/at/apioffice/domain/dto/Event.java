package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	private long idEvent;
	private String title;
	private String description;
	private String startDate;
	private String endDate;
	private String creationDate;
	private String deleted;
	public long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", title=" + title + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", creationDate=" + creationDate + ", deleted=" + deleted + "]";
	}
	
	//---------------------------------------
	
	
}
