package edu.system.employment.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
public class Category implements Serializable {
	
	@Id
	private long id;

	private String title;
	
	private static final long serialVersionUID = 1L;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Category() {
		super();
	}
   
}
