package edu.system.employment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Company
 *
 */
@Entity
public class Company implements Serializable {

	
	@Id
	private long id;
	
	@Column(name="DESCR")
	private String description;

	private String email;

	private String logo;

	private String site;

	private String title;
	
	@OneToOne
	@JoinColumn(name="CONT_PERS_ID")
	private ContactPerson contactPerson;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="COMPANY_ADDRESS", 
				joinColumns=@JoinColumn(name="COMP_ID"),
				inverseJoinColumns=@JoinColumn(name="ADDR_ID"))
	private List<Address> addresses;
	
	
	public Company() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
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

	private static final long serialVersionUID = 1L;

}
