package edu.system.employment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
/**
 * Entity implementation class for Entity: Student
 *
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "Student.deleteAll", 
				query = "DELETE FROM Student s"),
		@NamedQuery(name = "Student.findByUserId", 
				query = "SELECT s FROM Student s WHERE s.user =:p"),
		@NamedQuery(name = "Student.getAll", 
		query = "SELECT s FROM Student s")
})
public class Student implements Serializable, Updatable {	
	
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
	
	@Email
	private String email;
	private String phone;
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL) @JoinColumn(name="GROUP_ID")
	private Group group;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="student", cascade=CascadeType.ALL)
	private Set<Education> educations;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="student", cascade=CascadeType.ALL)
	private Set<Employment> employments;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="student", cascade=CascadeType.ALL)
	private Set<Course> courses;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="student", cascade=CascadeType.ALL)
	private Set<Language> languages;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="student", cascade=CascadeType.ALL)
	private Set<Additional> additionals;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="STUDENTS_ADDRESS", 
				joinColumns=@JoinColumn(name="STUD_ID"),
				inverseJoinColumns=@JoinColumn(name="ADDR_ID"))
	private List<Address> addresses;
	
	@OneToOne(cascade=CascadeType.ALL)
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

	public Set<Education> getEducations() {
		if(educations==null)
			educations = new HashSet<>();
		return educations;
	}

	public void setEducations(Set<Education> educations) {
		this.educations = educations;
	}
	public Education addEducation(Education education) {
		getEducations().add(education);
		education.setStudent(this);
		return education;
	}

	public Education removeEducation(Education education) {
		getEducations().remove(education);
		return education;
	}

	public Set<Employment> getEmployments() {
		if(employments == null)
			employments = new HashSet<>();
		return employments;
	}

	public void setEmployments(Set<Employment> employments) {
		this.employments = employments;
	}
	
	public Employment addEmployment(Employment employment) {
		getEmployments().add(employment);
		employment.setStudent(this);
		return employment;
	}

	public Employment removeEmployment(Employment employment) {
		getEmployments().remove(employment);
		return employment;
	}

	public Set<Course> getCourses() {
		if(courses == null)
			courses = new HashSet<>();
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	public Course addCourse(Course course) {
		getCourses().add(course);
		course.setStudent(this);
		return course;
	}

	public Course removeCourse(Course course) {
		getCourses().remove(course);
		return course;
	}

	public Set<Language> getLanguages() {
		if (languages==null)
			languages = new HashSet<>();
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}
	
	public Language addLanguage(Language language) {
		getLanguages().add(language);
		language.setStudent(this);
		return language;
	}

	public Language removeLanguage(Language language) {
		getLanguages().remove(language);
		return language;
	}
	
	public Set<Additional> getAdditionals() {
		if (additionals==null)
			additionals = new HashSet<>();
		return additionals;
	}
	
	public Additional addAdditional(Additional additionals) {
		getAdditionals().add(additionals);
		additionals.setStudent(this);
		return additionals;
	}

	public Additional removeAdditonals(Additional additionals) {
		getAddresses().remove(additionals);
		return additionals;
	}

	public void setAdditionals(Set<Additional> additionals) {
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
		user.setStudent(this);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Student() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
   
}
