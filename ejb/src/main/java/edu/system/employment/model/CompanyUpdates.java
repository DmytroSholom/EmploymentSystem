package edu.system.employment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CompanyUpdates
 * 
 */
@Entity
@NamedQuery(name = "CompanyUpdates.findAll", query = "SELECT updates FROM CompanyUpdates updates")
@Table(name = "COMPANY_UPDATES")
public class CompanyUpdates implements Serializable, Updates {

	@SequenceGenerator(name = "compUpdGen", sequenceName = "C_UPD_SEQ", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compUpdGen")
	private long id;

	@OneToOne
	@JoinColumn(name = "COMP_ID")
	private Company updatable;
	@Column(name = "CREATE_DATE")
	private Date creationDate;

	public CompanyUpdates(Company company, Date date) {
		this.updatable = company;
		this.creationDate = date;
	}

	public CompanyUpdates() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Company getUpdatable() {
		return updatable;
	}

	public void setUpdatable(Company company) {
		this.updatable = company;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	private static final long serialVersionUID = 1L;

}
