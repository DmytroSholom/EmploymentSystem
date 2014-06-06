package edu.system.employment.model;

import javax.persistence.*;

@Embeddable
public class Language {

	private String language;
	@Column(name = "DESCR")
	private String description;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
