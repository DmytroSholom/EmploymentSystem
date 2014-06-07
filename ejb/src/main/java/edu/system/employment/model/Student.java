package edu.system.employment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Student implements Serializable {	
	
	@SequenceGenerator(name="studGen", sequenceName="STUD_SEQ", allocationSize=1)
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="studGen")
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
	
	@ManyToOne(cascade=CascadeType.ALL) @JoinColumn(name="GROUP_ID")
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
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
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
		if(educations == null)
			educations = new ArrayList<>();
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}
	public Education addEducation(Education education) {
		getEducations().add(education);
		return education;
	}

	public Education removeEducation(Education education) {
		getEducations().remove(education);
		return education;
	}

	public List<Employment> getEmployments() {
		if(employments == null)
			employments = new ArrayList<>();
		return employments;
	}

	public void setEmployments(List<Employment> employments) {
		this.employments = employments;
	}
	
	public Employment addEmployment(Employment employment) {
		getEmployments().add(employment);
		return employment;
	}

	public Employment removeEmployment(Employment employment) {
		getEmployments().remove(employment);
		return employment;
	}

	public List<Course> getCourses() {
		if(courses == null)
			courses = new ArrayList<>();
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public Course addCourse(Course course) {
		getCourses().add(course);
		return course;
	}

	public Course removeCourse(Course course) {
		getCourses().remove(course);
		return course;
	}

	public List<Language> getLanguages() {
		if (languages==null)
			languages = new ArrayList<>();
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	
	public Language addLanguage(Language language) {
		getLanguages().add(language);
		return language;
	}

	public Language removeLanguage(Language language) {
		getLanguages().remove(language);
		return language;
	}
	
	public List<Additional> getAdditionals() {
		if (additionals==null)
			additionals = new ArrayList<>();
		return additionals;
	}

	public void setAdditionals(List<Additional> additionals) {
		this.additionals = additionals;
	}

	public List<Address> getAddresses() {
		if (addresses == null) 
			addresses = new ArrayList<>();
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Address addAddress(Address address) {
		getAddresses().add(address);
		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		return address;
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
