package ca.ontario.health.hsc.prs.shellapp.healthcheck;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.enterprise.context.ApplicationScoped;

/*
* Readiness determines whether a service can handle requests (i.e. availability).
*/

@Readiness
@ApplicationScoped
public class DatabaseConnection implements HealthCheck {

    @Inject
    EntityManager em; 

    @Override
    public HealthCheckResponse call() {

        HealthCheckResponseBuilder respbuilder = HealthCheckResponse.named("Database connection health check");

        try{
            if(em.isOpen()) respbuilder.up();
        }catch(Exception e){
            respbuilder.down();
        }

        return respbuilder.build();
    }
}