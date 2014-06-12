package edu.system.employment.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Employment {
	
	//mlmlm
	@SequenceGenerator(name="empGen", sequenceName="EMP_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="empGen")
	private long id;
	private String company;
	private String position;
	@Temporal(TemporalType.DATE)
	@Column(name="START_YEAR")
	private Date startYear;
	@Temporal(TemporalType.DATE)
	@Column(name="END_YEAR")
	private Date endYear;
	
	@ManyToOne @JoinColumn(name="STUD_ID")
	private Student student;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getStartYear() {
		return startYear;
	}
	public void setStartYear(Date startYear) {
		this.startYear = startYear;
	}
	public Date getEndYear() {
		return endYear;
	}
	public void setEndYear(Date endYear) {
		this.endYear = endYear;
	}
	
}
