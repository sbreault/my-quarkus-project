package ca.ontario.health.hsc.prs.shellapp.healthcheck;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

/*
* Liveness determines whether a service should be restarted (i.e. responsiveness).
*/

@Liveness
@ApplicationScoped  
//Note: If no scope is annotated and the class implements HealthCheck then the class is given @Singleton scope automatically.
public class Simple implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("Simple health check");
    }
}