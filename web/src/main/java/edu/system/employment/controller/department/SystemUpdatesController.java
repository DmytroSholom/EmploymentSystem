package edu.system.employment.controller.department;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.model.CompanyUpdates;
import edu.system.employment.model.Student;
import edu.system.employment.model.StudentUpdates;
import edu.system.employment.model.Updatable;
import edu.system.employment.model.Updates;
import edu.system.employment.model.User;
import edu.system.employment.model.VacancyUpdates;

@Named("updates")
@ViewScoped
public class SystemUpdatesController implements Serializable{
	
	@Inject
	private BaseDaoBean daoBean;
	
	private List<StudentUpdates> students;
	private List<CompanyUpdates> companies;
	private List<VacancyUpdates> vacancies;
	public List<StudentUpdates> getStudents() {
		return students;
	}
	
	@PostConstruct
	public void init(){
		this.students = daoBean.findWithNamedQuery("StudentUpdates.findAll");
		this.companies = daoBean.findWithNamedQuery("CompanyUpdates.findAll");
		this.vacancies = daoBean.findWithNamedQuery("VacancyUpdates.findAll");

	}
	
	public void accept(Updates upd){
		daoBean.delete(upd.getClass(), upd.getId());
		addMessage("Оновлення внесено");
	}
	
	public void decline(Updates upd){
		Updatable data = upd.getUpdatable();
		if((data instanceof Student) || (data instanceof Student)) 
			daoBean.delete(User.class, data.getUser().getLogin());
		daoBean.delete(upd.getClass(), upd.getId());
		daoBean.delete(data.getClass(), data.getId());
		addMessage("Оновлення внесено");
	}

	public void setStudents(List<StudentUpdates> studentUpdates) {
		this.students = studentUpdates;
	}
	public List<CompanyUpdates> getCompanies() {
		return companies;
	}
	public void setCompanies(List<CompanyUpdates> companyUpdates) {
		this.companies = companyUpdates;
	}
	public List<VacancyUpdates> getVacancies() {
		return vacancies;
	}
	public void setVacancies(List<VacancyUpdates> vacancyUpdates) {
		this.vacancies = vacancyUpdates;
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
