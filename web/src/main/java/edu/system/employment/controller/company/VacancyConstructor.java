package edu.system.employment.controller.company;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
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
	@Transactional(Transactional.TxType.REQUIRED)
	public String doCreate(){
		Category ctg = daoBean.findObjectWithNamedQuery("Category.findByTitle", QueryParameter.with("title", category).parameters());
		if(ctg==null) ctg = new Category();
		vacancy.setCategory(ctg);
		company.addVacancy(vacancy);
		daoBean.update(company);
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
