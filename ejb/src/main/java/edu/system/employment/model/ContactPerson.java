package edu.system.employment.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ContactPerson
 *
 */
@Entity
public class ContactPerson implements Serializable {
	
	@Id
	private long id;

	private String fname;

	private String lname;

	private String phone;

	@Column(name="\"POSITION\"")
	private String position;
	
	@OneToOne(mappedBy="contactPerson")
	private Company company;
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ContactPerson() {
		super();
	}
	private static final long serialVersionUID = 1L;

}
