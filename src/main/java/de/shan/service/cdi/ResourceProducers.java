package de.shan.service.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ApplicationScoped
public class ResourceProducers {
    
    @Produces
    public Logger produceLogger(InjectionPoint context) {
        return  LogManager.getLogger(context.getMember().getDeclaringClass().getName());
    }

}
