package ca.ontario.health.hsc.prs.shellapp.model;

import javax.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import io.quarkus.panache.common.Sort;

import ca.ontario.health.hsc.prs.shellapp.service.CompanyService;
import ca.ontario.health.hsc.prs.shellapp.entity.Company;


@ApplicationScoped
@Path("/company")
public class CompanyResource {

    @Inject
    CompanyService service;

    @GET
    @Path("healthcheck")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthcheck() {
        return "service is running";
    }  

    @GET
    //default context
    @Produces("application/json")
    public List<Company> getAll(){
        return Company.listAll(Sort.by("name"));
    }

    @GET
    @Path("{name}")
    @Produces("application/json")
    public Company getCompanyByName(@PathParam String name){
        return service.getCompanyByName(name);
    }    
}