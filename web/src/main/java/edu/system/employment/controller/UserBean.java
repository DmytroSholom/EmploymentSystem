package edu.system.employment.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import edu.system.employment.data.BaseDao;
import edu.system.employment.model.Student;

@ManagedBean
@SessionScoped
public class UserBean {
	
	@Inject
	private BaseDao dao;
	
	@Inject 
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
