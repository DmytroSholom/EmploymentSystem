package edu.system.employment.controller.department;

import java.io.*;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;


import edu.system.employment.business.documents.EmploymentDocumentConstructor;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Model
public class ReportController {
	@Inject
	EmploymentDocumentConstructor employmentDocumentConstructor;

    private StreamedContent file;
    
    public StreamedContent getFile() {
    	try {
            employmentDocumentConstructor.generateReport();
            InputStream stream = new FileInputStream((new File("")).getAbsolutePath() + File.separator + "report.xls");
            file = new DefaultStreamedContent(stream, "application/xls", "report.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
