package edu.system.employment.controller;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.QueryParam;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.model.*;

@Named
@ViewScoped
public class ResumeConstructor implements Serializable {
	
	private Student student;
	
	@Inject
	private BaseDaoBean daoBean;
	@Inject
	private Principal principal;
	
	@PostConstruct
	public void init(){
		User u = daoBean.find(User.class, principal.getName());
		student = u.getStudent();
		System.out.println(student.getId());
		System.out.println(retrieveListAsSet(student.getEducations()).size());
		System.out.println(retrieveListAsSet(student.getEmployments()).size());
		
	}
	
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public BaseDaoBean getDaoBean() {
		return daoBean;
	}

	public void setDaoBean(BaseDaoBean daoBean) {
		this.daoBean = daoBean;
	}
	
	public void addEducation(){
		Education ed = new Education();
		this.student.addEducation(ed);
	}
	
	public List retrieveListAsSet( Set set) {
		return new ArrayList(set);
	}
	
}
