package edu.system.employment.controller;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.spi.WithAnnotations;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.data.QueryParameter;
import edu.system.employment.model.*;

@Model
public class ResumeConstructor {
	
	private Student student;
	
	@Inject
	private BaseDaoBean daoBean;
	@Inject
	private Principal principal;
	
	@PostConstruct
	public void init(){
		User user = daoBean.find(User.class, principal.getName());
//		student = user.getStudent();
		student = daoBean.findObjectWithNamedQuery("Student.findByUserId", QueryParameter.with("p", user).parameters());
		
		if(student != null) {
			System.out.println("true");
			student = new Student();
		}
		if (student.getAdditionals().isEmpty()){
			Additional additional = new Additional();
			student.addAdditional(additional);
		}
		System.out.println(user.getLogin());
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getEducations().size());
		System.out.println(student.getLanguages().size());

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
	
}
