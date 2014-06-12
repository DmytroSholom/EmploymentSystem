package edu.system.employment.model;

import javax.persistence.*;

@Entity
@Table(name="LANGUAGES")
public class Language {
	
	@SequenceGenerator(name="langGen", sequenceName="LANG_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="langGen")
	private long id;
	
	private String language;
	@Column(name = "DESCR")
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
