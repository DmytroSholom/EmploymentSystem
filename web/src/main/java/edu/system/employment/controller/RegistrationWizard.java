package edu.system.employment.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.model.*;

@Named("registration")
@ViewScoped
public class RegistrationWizard implements Serializable{
	
	
	@Inject
	private BaseDaoBean daoBean;
	private static final String stud = "Student";
	private static final String comp = "Company";
	
	private Group group;
	private User user;
	private Role role;
	private Student student;
	private Company company;
	private Education education;
    private Address address;
    private ContactPerson contactPerson;
	
	@PostConstruct
	public void init(){
		//create objects
		this.user = new User();
		this.role = new Role();
		this.student = new Student();
		this.company = new Company();
		this.group = new Group();
		this.education = new Education();
		this.education.setUniversity("NTUU KPI");
		this.education.setDepartment("FIOT");
		this.address = new Address();
        this.contactPerson = new ContactPerson();

	}
	
	public String doRegister(){
		this.role.setLogin(user.getLogin());
		this.user.setRole(role);
        if(comp.equals(role.getRole())){
            this.company.setUser(user);
            this.company.addAddress(address);
            this.company.setContactPerson(contactPerson);
            daoBean.create(company);
        }
        if(stud.equals(role.getRole())) {
            this.student.setUser(user);
            this.student.setGroup(group);
            this.student.addEducation(education);
            this.student.addAddress(address);
            daoBean.create(student);
        }
		return "index";
	}

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	public String getStud() {
		return stud;
	}

	public String getComp() {
		return comp;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	private static final long serialVersionUID = 1L;

}
