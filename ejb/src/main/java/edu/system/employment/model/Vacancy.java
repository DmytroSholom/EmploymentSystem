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

	@Id
	private long id;

	@Column(name="CONT_PERSON_NAME")
	private String contPersonName;

	private String description;

	private String email;

	@Column(name="OCCUP_TIME")
	private String occupTime;

	private String phone;

	@Column(name="PROPOS_NUMBER")
	private BigDecimal proposNumber;

	private String title;
	
	@ManyToOne
	private Category category;

	public Vacancy() {
		super();
	}
	private static final long serialVersionUID = 1L;

}
