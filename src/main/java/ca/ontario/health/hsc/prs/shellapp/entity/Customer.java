package ca.ontario.health.hsc.prs.shellapp.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Id;
import java.util.List;

@Entity
@NamedQueries({
 @NamedQuery(name = "Customer.findAll",
            query = "SELECT c FROM Customer c ORDER BY c.customerid",
            hints = @QueryHint(name = "org.hibernate.cacheable", value = "true") ),
 @NamedQuery(name = "Customer.findByLastName",
            query = "SELECT c FROM Customer c WHERE c.lastname LIKE :lastname ORDER BY c.lastname")
})
public class Customer {

    @Id
    private int customerid;
    private String firstname;
    private String lastname;

    public Customer(){

    }

    public int getCustomerid(){
        return customerid;
    }

    public void setCustomerid(int id){
        customerid = id;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String s){
        firstname = s;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String s){
        lastname = s;
    }
 

}