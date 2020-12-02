package ca.ontario.health.hsc.prs.shellapp.service;

import javax.enterprise.context.ApplicationScoped; 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.jboss.logging.Logger;
import ca.ontario.health.hsc.prs.shellapp.entity.Company;

@ApplicationScoped
public class CompanyService {

    private static final Logger LOGGER = Logger.getLogger(CompanyService.class.getName());

    @Inject
    EntityManager em; 

    /*
    * You could choose to roll this logic into the Resource classes, however separating UI related logic from data
    * access is advisable as it follows the 'separation of concerns' best practice.
    */

    public Company getCompanyByName(String name){
        LOGGER.info("getCompanyByName");
        return Company.findByName(name);
    }      
}