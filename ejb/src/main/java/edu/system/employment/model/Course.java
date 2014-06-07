package edu.system.employment.model;

import java.util.Date;

import javax.persistence.*;

@Embeddable
public class Course {
	
	private String title;
	private String place;
	@Column(name="DESCR")
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
