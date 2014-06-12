package edu.system.employment.test;

import java.util.Date;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.data.QueryParameter;
import edu.system.employment.model.Address;
import edu.system.employment.model.Course;
import edu.system.employment.model.Education;
import edu.system.employment.model.Employment;
import edu.system.employment.model.Group;
import edu.system.employment.model.Language;
import edu.system.employment.model.Student;
import edu.system.employment.model.User;

@RunWith(Arquillian.class)
public class StudentServiceIT {
	
	@Deployment
	public static JavaArchive createTestableDeployment(){
		final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, 
				"example.jar").addPackage(Student.class.getPackage()).addClasses(BaseDaoBean.class, 
				QueryParameter.class).addAsManifestResource("META-INF/persistence.xml", 
				"persistence.xml").addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return jar;
	}
	
	@EJB
	BaseDaoBean baseDao;
	
	@Test
	public void addNewStudentToDB(){
		//Group
		Group group = new Group();
		group.setTitle("ip-01");
		//Student
		Student s = new Student();
		s.setBirthDate(new Date());
		s.setFirstName("Joe");
		s.setMiddleName("Legendary");
		s.setLastName("Raven");
		s.setEmail("fuckyou@gmail.com");
		s.setPhone("123321");
		s.setGroup(group);
		//employment
		Employment emp = new Employment();
		emp.setStartYear(new Date());
		emp.setCompany("Luxoft");
		emp.setPosition("intern");
		emp.setEndYear(new Date());
		s.addEmployment(emp);
		//education
		Education edu = new Education();
		edu.setStartYear(new Date());
		edu.setDegree("bachelor's degree");
		edu.setDepartment("fiot");
		edu.setSpeciality("software engіneering");
		edu.setUniversity("KPI");
		edu.setEndYear(new Date());
		s.addEducation(edu);
		//Course
		Course course = new Course();
		course.setTitle("java course");
		course.setPlace("Netcracker");
		course.setDescription("java se && ee course");
		s.addCourse(course);
		//Language
		Language lang1 = new Language();
		lang1.setLanguage("English");
		lang1.setDescription("intermediate");
		Language lang2 = new Language();
		lang2.setLanguage("Ukrainian");
		lang2.setDescription("native");
		s.addLanguage(lang1);
		s.addLanguage(lang2);
//		//Address
//		Address address = new Address();
//		address.setCountry("Ukraine");
//		address.setCity("Kyiv");
//		address.setRayon("Solomiansky");
//		address.setStreet("Lenina");
//		address.setHome("22");
//		address.setZip("37700");
//		s.addAddress(address);
		//save
//		baseDao = new BaseDaoBean();
		User u = baseDao.find(User.class, "stud2");
		s.setUser(u);
		baseDao.create(s);
		Assert.assertNotNull(s.getId());
	}
	
	@Ignore
	@Test
	public void deleteStudents(){
		baseDao.updateWithNamedQuery("Student.deleteAll");
	}

}
