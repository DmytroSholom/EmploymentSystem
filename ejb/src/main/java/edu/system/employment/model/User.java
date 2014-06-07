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
	private long id;
	
	@Column(name="U_LOGIN")
	private String login;
	
	@Column(name="U_PASSWORD")
	private String password;
	
	@Column(name="U_TYPE")
	private String type;
	
	public User() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
}
