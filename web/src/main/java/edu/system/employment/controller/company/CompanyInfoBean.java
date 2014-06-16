package edu.system.employment.controller.company;

import edu.system.employment.data.BaseDaoBean;
import edu.system.employment.model.*;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Model
public class CompanyInfoBean{

    @Inject
    private BaseDaoBean baseDao;

    @Inject
    private Principal principal;

    private User user;
    private Company company;
   
    private ContactPerson contactPerson;

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload(){

        FileOutputStream out = null;
        String filePath = System.getProperty("user.dir") + File.separator +"images"+ File.separator+"company"+ File.separator;
        new File(filePath).mkdirs();
        try {

            File outputFile = new File(filePath+this.company.getTitle()+file.getFileName());
            outputFile.createNewFile();
            out = new FileOutputStream(outputFile);
            byte[] bytes = new byte[2048];
            InputStream in = file.getInputstream();
            while(in.read(bytes, 0, 2048)>0){
                out.write(bytes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        this.company.setLogo(filePath+this.company.getTitle()+file.getFileName());
        baseDao.update(this.company);
    }

    @PostConstruct
    public void init(){
        this.user = baseDao.find(User.class, principal.getName());
        this.company = user.getCompany();
       
        this.contactPerson = company.getContactPerson();
    }


    public void doSave(){
        baseDao.update(this.company);
    }


    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public List retrieveListAsSet( Set set) {
		return new ArrayList(set);
	}

    public void addAddress(){
        Address address = new Address();
        this.company.addAddress(address);
    }
}
