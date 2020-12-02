package ca.ontario.health.hsc.prs.shellapp.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Entity;
import javax.persistence.Id;

/* simplified Hibernate ORM using Panache
*  requires pom.xml dependency: quarkus-hibernate-orm-panache
*
* Hibernate Active Record pattern is used.
*/

@Entity
public class Company extends PanacheEntityBase  {

    //public members
    @Id
    public int companyid;  //you must extend PanacheEntityBase to specify your own PK/ID field
    public String name;

    //no default constructor required

    //no getter/setter methods required

    //public static accessor method
    public static Company findByName(String name){
        return find("name", name).firstResult();
    }
}