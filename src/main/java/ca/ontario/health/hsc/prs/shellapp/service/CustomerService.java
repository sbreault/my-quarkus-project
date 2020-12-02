package ca.ontario.health.hsc.prs.shellapp.service;

import javax.enterprise.context.ApplicationScoped; 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.ArrayList;

import ca.ontario.health.hsc.prs.shellapp.entity.Customer;

@ApplicationScoped
public class CustomerService {

    //bogus hard coding --------->
    private List<Customer> customers = new ArrayList<Customer>();

    {
        Customer c = new Customer();
        c.setCustomerid(100);
        c.setFirstname("Steve");
        c.setLastname("Breault");
        customers.add(c);
        c = new Customer();
        c.setCustomerid(101);
        c.setFirstname("Gary");
        c.setLastname("Booker");
        customers.add(c);        
    }
    //<----------- end hard coding; TODO replace with Hibernate query of customer_db.customer

    @Inject
    EntityManager em; 

    @Transactional 
    public void createCustomer(String firstname, String lastname) {
        //Customer c = new Customer();
        //let auto-increment value PK
        //c.setFirstname(firstname);
        //c.setLastname(lastname);

        //em.persist(c);
    }

    //hard coded return
    public List<Customer> getHardCodedCustomers(){
        return customers;        
    }

    //Hibernate uses HQL syntax; this method uses named query
    public List<Customer> getCustomers(){
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    //this method defines HQL
    public Customer getCustomerById(int id){
        return (Customer) em.createQuery("FROM Customer c WHERE c.customerid = " + id).getSingleResult();
    }

    //parameterized named query
    public List<Customer> getCustomersByLastName(String lastname){
        Query q = em.createNamedQuery("Customer.findByLastName", Customer.class);
        q.setParameter("lastname", lastname);
        return q.getResultList();
    }    
}