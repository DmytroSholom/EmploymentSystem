package edu.system.employment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EmploymentLetter
 *
 */
@Entity
@Table(name="EmploymentLetters")
public class EmploymentLetter implements Serializable {
	
	@Id
	private long id;
	
	private String code;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	private String title;
	
	private String position;
	
	@ManyToOne @JoinColumn(name="COMP_ID")
	private Company company;

	@ManyToOne @JoinColumn(name="STUD_ID")
	private Student student;
	
	@ManyToOne @JoinColumn(name="ADDR_ID")
	private Address address;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EmploymentLetter() {
		super();
	}
	private static final long serialVersionUID = 1L;

}
