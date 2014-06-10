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

    private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

    public String getLoremIpsum() {
        return loremIpsum;
    }

    public void setLoremIpsum(String loremIpsum) {
        this.loremIpsum = loremIpsum;
    }

    public String register(){
		dao.create(student);
		return "index";
	}
}
