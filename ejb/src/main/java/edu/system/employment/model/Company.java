package edu.system.employment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Company
 *
 */
@Entity
public class Company implements Serializable {

	
	@SequenceGenerator(name="compGen", sequenceName="COMP_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="compGen")
	private long id;
	
	@Column(name="DESCR")
	private String description;

	private String email;

	private String logo;

	private String site;

	private String title;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CONT_PERS_ID")
	private ContactPerson contactPerson;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="COMPANY_ADDRESS", 
				joinColumns=@JoinColumn(name="COMP_ID"),
				inverseJoinColumns=@JoinColumn(name="ADDR_ID"))
	private List<Address> addresses;
	
	@OneToMany(cascade=CascadeType.ALL, 
			fetch=FetchType.LAZY, mappedBy = "company")
	private List<Vacancy> vacancies;
	
	@OneToOne @JoinColumn(name="USER_ID")
	private User user;
	
	
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
	

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
		contactPerson.setCompany(this);
	}
	
	public List<Address> getAddresses() {
		if (addresses == null) 
			addresses = new ArrayList<>();
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Address addAddress(Address address) {
		getAddresses().add(address);
		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		return address;
	}

	public List<Vacancy> getVacancies() {
		if(vacancies == null)
			return new ArrayList<>();
		return vacancies;
	}
	
	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}
	
	public Vacancy addVacancy(Vacancy vacancy){
		getVacancies().add(vacancy);
		return vacancy;
	}
	
	public Vacancy removeVacancy(Vacancy vacancy){
		getVacancies().remove(vacancy);
		return vacancy;
	}

	private static final long serialVersionUID = 1L;

}
