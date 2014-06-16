package edu.system.employment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: StudentUpdates
 *
 */
@Entity
@NamedQuery(name="StudentUpdates.findAll", query="SELECT updates FROM StudentUpdates updates")
@Table(name="STUDENT_UPDATES")
public class StudentUpdates implements Serializable, Updates {
	
	@SequenceGenerator(name="studUpdGen", sequenceName="S_UPD_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="studUpdGen")
	private long id;
	
	@OneToOne
	@JoinColumn(name="STUD_ID")
	private Student updatable;
	@Column(name="CREATE_DATE")
	private Date creationDate;
	public StudentUpdates() {
		super();
	}
	public StudentUpdates(Student student, Date date){
		this.updatable = student;
		this.creationDate = date;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Student getUpdatable() {
		return updatable;
	}
	public void setUpdatable(Student student) {
		this.updatable = student;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	private static final long serialVersionUID = 1L;

}
