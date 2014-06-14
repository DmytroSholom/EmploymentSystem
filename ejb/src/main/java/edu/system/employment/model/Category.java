package edu.system.employment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@NamedQueries({@NamedQuery(name="Category.getAll", query="Select c from Category c"),
	@NamedQuery(name="Category.findByTitle", query="SELECT c FROM Category c WHERE c.title=:title")})
public class Category implements Serializable {
	
	@SequenceGenerator(name="categGen", sequenceName="CATEG_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="categGen")
	private long id;

	private String title;
	
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY)
	private List<Vacancy> vacancies; 
	
	private static final long serialVersionUID = 1L;
	
	
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
	
	

	public List<Vacancy> getVacancies() {
		return vacancies;
	}


	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
	
	public Category(String title){
		this.title = title;
	}

	public Category() {
		super();
	}
   
}
