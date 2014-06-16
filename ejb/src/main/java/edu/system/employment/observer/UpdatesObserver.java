package edu.system.employment.observer;

import java.util.Date;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.data.QueryParameter;
import edu.system.employment.model.Company;
import edu.system.employment.model.CompanyUpdates;
import edu.system.employment.model.Student;
import edu.system.employment.model.StudentUpdates;
import edu.system.employment.model.Vacancy;
import edu.system.employment.model.VacancyUpdates;

public class UpdatesObserver{
	
	@Inject 
	private BaseDaoBean daoBean;
	
	public void addStudentUpdate(@Observes Student student){
		StudentUpdates update = new StudentUpdates(student, new Date());
		daoBean.create(update);
	}
	
	public void addCompanyUpdate(@Observes Company company){
		CompanyUpdates update = new CompanyUpdates(company, new Date());
		daoBean.create(update);
	}
	
	public void addVacancyUpdate(@Observes Vacancy vacancy){
		Vacancy vac=daoBean.findObjectWithNamedQuery("Vacancy.selectByDate", QueryParameter.with("date", vacancy.getCreationDate()).parameters());
		daoBean.update(vac);
		VacancyUpdates update = new VacancyUpdates(vac, new Date());
		daoBean.create(update);
	}
}
