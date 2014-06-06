package edu.system.employment.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Student implements Serializable {	
	
	@Id
	private long id;
	@Column(name="FNAME")
	private String firstName;
	@Column(name="MNAME")
	private String middleName;
	@Column(name="LNAME")
	private String lastName;
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;
	private String email;
	private String phone;
	private String status;
	
	@ManyToOne @JoinColumn(name="GROUP_ID")
	private Group group;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name="EDUCATION",joinColumns=@JoinColumn(name="STUD_ID"))
	private List<Education> educations;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name="EMPLOYMENT", joinColumns=@JoinColumn(name="STUD_ID"))
	private List<Employment> employments;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name = "COURSES", 
						joinColumns=@JoinColumn(name="STUD_ID"))
	private List<Course> courses;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name = "LANGUAGES", 
						joinColumns=@JoinColumn(name="STUD_ID"))
	private List<Language> languages;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name = "ADDITIONAL", 
						joinColumns=@JoinColumn(name="STUD_ID"))
	private List<Additional> additionals;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="STUDENTS_ADDRESS", 
				joinColumns=@JoinColumn(name="STUD_ID"),
				inverseJoinColumns=@JoinColumn(name="ADDR_ID"))
	private List<Address> addresses;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<Employment> getEmployments() {
		return employments;
	}

	public void setEmployments(List<Employment> employments) {
		this.employments = employments;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<Additional> getAdditionals() {
		return additionals;
	}

	public void setAdditionals(List<Additional> additionals) {
		this.additionals = additionals;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Student() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
   
}
