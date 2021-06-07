package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="News")
public class News implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	private long idNews;
	private int idTags;
	private String title;
	private String content;
	private String creationDate;
	private String modificationDate;
	private String deleted;
	public long getIdNews() {
		return idNews;
	}
	public void setIdNews(long idNews) {
		this.idNews = idNews;
	}
	public int getIdTags() {
		return idTags;
	}
	public void setIdTags(int idTags) {
		this.idTags = idTags;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
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
		return "News [idNews=" + idNews + ", idTags=" + idTags + ", title=" + title + ", content=" + content
				+ ", creationDate=" + creationDate + ", modificationDate=" + modificationDate + ", deleted=" + deleted
				+ "]";
	}
	
	
	
	

}
