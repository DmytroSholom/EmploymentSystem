package edu.system.employment.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.model.Student;

@ManagedBean
@RequestScoped
public class UserBean {
	
	public UserBean(){
		this.student = new Student();
	}
	
	@Inject
	private BaseDaoBean dao;
	 
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String register(){
		dao.create(student);
		return "index";
	}
}
