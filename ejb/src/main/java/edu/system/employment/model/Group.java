package edu.system.employment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Group
 *
 */
@Entity
@Table(name="AGROUP")
public class Group implements Serializable {

	@Id
	private long id;
	
	private String title;
	
	@OneToMany(mappedBy="group", fetch=FetchType.LAZY)
	private List<Student> students;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Group() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
   
}
