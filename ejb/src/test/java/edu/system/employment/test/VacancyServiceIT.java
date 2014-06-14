package edu.system.employment.test;


import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

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
import edu.system.employment.model.Category;
import edu.system.employment.model.Company;
import edu.system.employment.model.Vacancy;


@RunWith(Arquillian.class)
public class VacancyServiceIT {
	
	@Deployment
	public static JavaArchive createTestableDeployment(){
		final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, 
				"example.jar").addPackage(Company.class.getPackage()).addClasses(BaseDaoBean.class, 
				QueryParameter.class).addAsManifestResource("META-INF/persistence.xml", 
				"persistence.xml").addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return jar;
	}
	
	@Inject
	BaseDaoBean baseDao;
	
	@Test
	public void addVacancyToDB(){
		Vacancy vacancy = new Vacancy();
		vacancy.setTitle("Java Junior Dev");
		vacancy.setContPersonName("Joe Dodson");
		vacancy.setEmail("Comp@comp.com");
		vacancy.setPhone("222-22-222");
		vacancy.setDescription("blabalbla");
		vacancy.setProposNumber(3);
		vacancy.setOccupTime("partime");
		
		Category category = new Category();
		category.setTitle("Java");
		vacancy.setCategory(category);
		
		Company comp = baseDao.find(Company.class, 2l);
		Assert.assertNotNull(comp);
		
		comp.addVacancy(vacancy);
		baseDao.update(comp);
		Assert.assertNotNull(vacancy.getId());
	}
}
