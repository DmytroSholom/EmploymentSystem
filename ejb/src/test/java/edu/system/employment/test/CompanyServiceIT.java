package edu.system.employment.test;

import javax.inject.Inject;



import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.data.QueryParameter;
import edu.system.employment.model.Company;
import edu.system.employment.model.ContactPerson;
import edu.system.employment.model.Student;

@RunWith(Arquillian.class)
public class CompanyServiceIT {
	
	@Deployment
	public static JavaArchive createTestableDeployment(){
		final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, 
				"example.jar").addPackage(Company.class.getPackage()).addClasses(BaseDaoBean.class, 
				QueryParameter.class).addAsManifestResource("META-INF/persistence.xml", 
				"persistence.xml").addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return jar;
	}
	
	@Inject
	private BaseDaoBean baseDao;
	
	@Test
	public void addCompanyToDB(){
		Company comp = new Company();
		comp.setTitle("IT Company");
		comp.setDescription("company it");
		comp.setEmail("comp@gmail.com");
		comp.setLogo("logo");
		ContactPerson cp = new ContactPerson();
		cp.setFname("Putin");
		cp.setLname("Huilo");
		cp.setPosition("pidar");
		comp.setContactPerson(cp);
		baseDao.create(comp);
		Assert.assertNotNull(comp.getId());
	}
}
