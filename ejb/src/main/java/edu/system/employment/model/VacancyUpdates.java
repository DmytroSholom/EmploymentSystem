package edu.system.employment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: VacancyUpdates
 * 
 */
@Entity
@NamedQuery(name = "VacancyUpdates.findAll", query = "SELECT updates FROM VacancyUpdates updates")
@Table(name = "VACANCY_UPDATES")
public class VacancyUpdates implements Serializable, Updates {

	@SequenceGenerator(name = "vacUpdGen", sequenceName = "V_UPD_SEQ", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacUpdGen")
	private long id;

	@OneToOne
	@JoinColumn(name = "VAC_ID")
	private Vacancy updatable;
	@Column(name = "CREATE_TIME")
	private Date creationDate;

	public VacancyUpdates(Vacancy vacancy, Date date) {
		this.updatable = vacancy;
		this.creationDate = date;
	}

	public VacancyUpdates() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vacancy getUpdatable() {
		return updatable;
	}

	public void setUpdatable(Vacancy vacancy) {
		this.updatable = vacancy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	private static final long serialVersionUID = 1L;

}
