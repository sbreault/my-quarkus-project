package ca.ontario.health.hsc.prs.shellapp.model;

import javax.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import javax.ws.rs.core.Response;

import ca.ontario.health.hsc.prs.shellapp.service.CustomerService;
import ca.ontario.health.hsc.prs.shellapp.entity.Customer;

//For JDBC, the preferred datasource and connection pooling implementation is Agroal.

@ApplicationScoped
@Path("/customer")
public class CustomerResource {

    @Inject
    CustomerService service;    
    
    @GET
    @Path("/healthcheck")
    @Produces(MediaType.TEXT_PLAIN)
    public String healthcheck() {
        return "service is running";
    }  

    @GET
    @Path("hardcoded")
    @Produces("application/json")
    public List<Customer> hardCodedList(){
        return service.getHardCodedCustomers();
    }

    /* Response version following JAX-RS */
    @GET
    @Path("hardcoded_resp")
    @Produces("application/json")
    public Response hardCodedList_Response(){
        return Response.ok(service.getHardCodedCustomers()).build();    //can specify HTTP response code and body data, handle error conditions, etc.
    }    

    @GET
    //default context path
    @Produces("application/json")
    public List<Customer> list(){
        return service.getCustomers();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Customer getCustomerById(@PathParam int id){
        return service.getCustomerById(id);
    }

    @GET
    @Path("lastname/{lastname}")
    @Produces("application/json")
    public List<Customer> getCustomerByLastName(@PathParam String lastname){
        return service.getCustomersByLastName(lastname);
    }
  
}