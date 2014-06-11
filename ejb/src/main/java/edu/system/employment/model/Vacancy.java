package edu.system.employment.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vacancy
 *
 */
@Entity

public class Vacancy implements Serializable {

	@SequenceGenerator(name="vacGen", sequenceName="VAC_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="vacGen")
	private long id;

	@Column(name="CONT_PERSON_NAME")
	private String contPersonName;

	private String description;

	private String email;

	@Column(name="OCCUP_TIME")
	private String occupTime;

	private String phone;

	@Column(name="PROPOS_NUMBER")
	private int proposNumber;

	private String title;
	
	@ManyToOne
	@JoinColumn(name="COMP_ID")
	private Company company;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CATEGORY_ID")
	private Category category;
	

	public Vacancy() {
		super();
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getContPersonName() {
		return contPersonName;
	}


	public void setContPersonName(String contPersonName) {
		this.contPersonName = contPersonName;
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


	public String getOccupTime() {
		return occupTime;
	}


	public void setOccupTime(String occupTime) {
		this.occupTime = occupTime;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getProposNumber() {
		return proposNumber;
	}


	public void setProposNumber(int i) {
		this.proposNumber = i;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	private static final long serialVersionUID = 1L;

}
