package edu.system.employment.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.model.Vacancy;

@Model
public class AvaliableVacancyContoller {
	
	@Inject
	private BaseDaoBean daoBean;
	
	private List<Vacancy> vacancies;
	
	@PostConstruct
	public void init(){
		vacancies = daoBean.findWithNamedQuery("Vacancy.selectAll");
		System.out.println(vacancies.size());
	}


	public List<Vacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}
	
	
}
