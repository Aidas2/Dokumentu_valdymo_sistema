package it.akademija.configs;

import it.akademija.db.Service;
import it.akademija.db.ServiceProvider;
import it.akademija.repositories.ServiceProviderRepo;
import it.akademija.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Set;

@Configuration
public class AppConfig {

    @PostConstruct
    public void init(){
        for (Service s : services){
            if(!serviceRepo.existsByTitle(s.getTitle())){
                serviceRepo.save(s);
            }
        }
        for (ServiceProvider sp: serviceProviders){
            if(!serviceProviderRepo.existsByTitle(sp.getTitle())){
                serviceProviderRepo.save(sp);
            }
        }
    }

    @Autowired
    private ServiceRepo serviceRepo;
    @Autowired
    private ServiceProviderRepo serviceProviderRepo;

    @Autowired
    private Set<Service> services;
    @Autowired
    private Set<ServiceProvider> serviceProviders;

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public void setServiceProviders(Set<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }

    public AppConfig(ServiceRepo serviceRepo, ServiceProviderRepo serviceProviderRepo) {
        this.serviceRepo = serviceRepo;
        this.serviceProviderRepo = serviceProviderRepo;
    }
}
