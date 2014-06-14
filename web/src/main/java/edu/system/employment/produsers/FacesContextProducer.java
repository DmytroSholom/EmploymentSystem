package edu.system.employment.produsers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProducer {
	
	@Produces
	@RequestScoped
	FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}
