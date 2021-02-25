package ca.ontario.health.hsc.prs.shellapp.model;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@ApplicationScoped
@Path("/company")
public class CompanyResource {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }     

    @GET
    @Path("healthcheck")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthcheck() {
        return "service is running";
    }  

    @GET
    //default context
    @Produces("application/json")
    public String getAll(){
        return "{\"companies\": [{\"name\":\"HydroWest\"},{\"name\":\"SmithJohnsonPerry\"},{\"name\":\"Tandem Industries\"}]}";
    }

  
}