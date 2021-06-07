package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class NewsH implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull
	protected News news;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
