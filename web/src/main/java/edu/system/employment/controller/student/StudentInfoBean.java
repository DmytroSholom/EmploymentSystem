package edu.system.employment.controller.student;

import java.io.Serializable;
import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.model.Address;
import edu.system.employment.model.Education;
import edu.system.employment.model.Student;
import edu.system.employment.model.User;

@Named
@ViewScoped
public class StudentInfoBean implements Serializable{
	@Inject
    private BaseDaoBean daoBean;

    @Inject
    private Principal principal;

    private User user;
    private Student student;
    private Education education;
    private Address addr;
    
    @PostConstruct
    public void init(){
    	this.user = daoBean.find(User.class, principal.getName());
		student = user.getStudent();
		System.out.println(student.getAddresses().size());
		addr=student.getAddresses().get(0);
		System.out.println(addr.getCity());
    }
    
    public Education getEducation(){
    	for(Education e:student.getEducations()){
    		if(e.getUniversity()=="NTUU KPI") 
    			return e;
    	}
    	return new Education();
    }
 
	public void setEducation(Education education) {
		this.education = education;
	}
	
	public Address getAddr(){
		return addr;
		
	}
	

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
    
    
}
