package edu.system.employment.model;

import javax.persistence.*;

@Entity
public class Additional {
	
	@SequenceGenerator(name="additGen", sequenceName="ADDITIONAL_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="additGen")
	private long id;
	
	@Column(name="tittle")
	private String title;
	@Column(name="DESCR")
	private String description;
	
	@ManyToOne @JoinColumn(name="STUD_ID")
	private Student student;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
	
	
}
