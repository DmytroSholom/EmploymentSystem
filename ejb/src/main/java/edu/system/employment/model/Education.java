package edu.system.employment.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Education {
	
	@SequenceGenerator(name="eduGen", sequenceName="EDU_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="eduGen")
	private long id;
	
	private String university;
	private String speciality;
	private String department;
	private String degree;
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
	
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
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
