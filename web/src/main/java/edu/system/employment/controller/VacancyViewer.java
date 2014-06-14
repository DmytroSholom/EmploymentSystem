package edu.system.employment.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.model.Vacancy;
import edu.system.employment.produsers.RequestParam;

@Model
public class VacancyViewer {
	
	@Inject
	private BaseDaoBean daoBean;
	
	@Inject
	@RequestParam
	private String vacancyId;
	
	
	
	private Vacancy vacancy;
	
	@PostConstruct
	public void init(){
		this.vacancy = daoBean.find(Vacancy.class, Long.parseLong(vacancyId));
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}
	
	
}
