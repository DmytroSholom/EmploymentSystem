package edu.system.employment.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@Table(name="ROLES")
public class Role implements Serializable {
	
	@Id @Column(name="U_LOGIN")
	private String login;
	
	@Column(name="U_ROLE")
	private String role;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	private static final long serialVersionUID = 1L;

	public Role() {
		super();
	}
	
	public Role(String login, String role){
		this.login = login;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

   
}
