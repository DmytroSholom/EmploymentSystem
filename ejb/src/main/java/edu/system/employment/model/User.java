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
	private Company company;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="user")
	private Role role;
	
	
	public User() {
		super();
	}
	
	public User(String login, String password){
		this.login = login;
		this.password = password;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
		role.setUser(this);
	}




	private static final long serialVersionUID = 1L;
}
