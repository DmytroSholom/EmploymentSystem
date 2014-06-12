package edu.system.employment.model;


import javax.persistence.*;

@Entity
@Table(name="COURSES")
public class Course {
	
	@SequenceGenerator(name="courseGen", sequenceName="COURSE_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="courseGen")
	private long id;
	private String title;
	private String place;
	@Column(name="DESCR")
	private String description;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
