package edu.system.employment.controller.company;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.FinderException;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.data.QueryParameter;
import edu.system.employment.model.Category;
import edu.system.employment.model.Company;
import edu.system.employment.model.User;
import edu.system.employment.model.Vacancy;

@Model
public class VacancyConstructor {
	
	@Inject
	private BaseDaoBean daoBean;
	@Inject
	private Principal principal;
	@Inject
	private Event<Vacancy> vacancyAddedEvent;
	
	
	private Company company;
	private Vacancy vacancy;
	private String category;
	private List<Category> categories;
	
	@PostConstruct
	public void init(){
		this.vacancy = new Vacancy();
		User user = daoBean.find(User.class, principal.getName());
		this.company = user.getCompany();
		this.vacancy.setCategory(new Category());
		this.categories = daoBean.findWithNamedQuery("Category.getAll");
	}
	
	@Transactional(value=Transactional.TxType.REQUIRED, dontRollbackOn={NoResultException.class})
	public String doCreate(){
		Category ctg;
		try {
			ctg = daoBean.findObjectWithNamedQuery("Category.findByTitle", QueryParameter.with("title", category).parameters());
		} catch (Exception e) {
			ctg=null;
		}
		if(ctg==null) ctg = new Category(category);
		else ctg = daoBean.find(Category.class, ctg.getId());
		vacancy.setCategory(ctg);
		vacancy.setCreationDate(new Date());
		vacancy = company.addVacancy(vacancy);
		daoBean.update(company);
		vacancyAddedEvent.fire(vacancy);
		return "CompanyInfo";
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	
	
}
