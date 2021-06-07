package tn.atconsulting.at.apioffice.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TagsH implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull
	protected Tags tags;

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
