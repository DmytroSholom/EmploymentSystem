package edu.system.employment.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="AUSER")
public class User implements Serializable {
	
	@Id
	@Column(name="U_LOGIN")
	private String login;
	
	@Column(name="U_PASSWORD")
	private String password;
	
	@OneToOne(mappedBy="user")
	private Student student;
	
	@OneToOne(mappedBy="user")
	private Student company;
	
	
	
	public User() {
		super();
	}
	
	
	
	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public Student getCompany() {
		return company;
	}



	public void setCompany(Student company) {
		this.company = company;
	}



	private static final long serialVersionUID = 1L;
}
