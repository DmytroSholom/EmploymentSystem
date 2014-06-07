package edu.system.employment.model;

import java.util.Date;

import javax.persistence.*;

@Embeddable
public class Employment {
	
	//mlmlm
	private String company;
	private String position;
	@Temporal(TemporalType.DATE)
	@Column(name="START_YEAR")
	private Date startYear;
	@Temporal(TemporalType.DATE)
	@Column(name="END_YEAR")
	private Date endYear;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getStartYear() {
		return startYear;
	}
	public void setStartYear(Date startYear) {
		this.startYear = startYear;
	}
	public Date getEndYear() {
		return endYear;
	}
	public void setEndYear(Date endYear) {
		this.endYear = endYear;
	}
	
}
