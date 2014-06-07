package edu.system.employment.model;

import javax.persistence.*;

@Embeddable
public class Additional {
	@Column(name="tittle")
	private String title;
	@Column(name="DESCR")
	private String description;
	
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
	
}
