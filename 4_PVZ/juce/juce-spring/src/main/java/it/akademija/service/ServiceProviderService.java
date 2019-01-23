package it.akademija.service;

import it.akademija.db.Service;
import it.akademija.db.ServiceProvider;
import it.akademija.objects.ServiceObject;
import it.akademija.objects.ServiceProviderObject;
import it.akademija.repositories.ServiceProviderRepo;
import it.akademija.repositories.ServiceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@Transactional
public class ServiceProviderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServiceProviderRepo serviceProviderRepo;

    @Autowired
    private ServiceRepo serviceRepo;

    public ServiceProviderService(ServiceProviderRepo serviceProviderRepo, ServiceRepo serviceRepo) {
        this.serviceProviderRepo = serviceProviderRepo;
        this.serviceRepo = serviceRepo;
    }

    public ServiceProviderObject getOneById(long id) {
        ServiceProvider serviceProvider = serviceProviderRepo.findById(id).orElse(null);
        if (serviceProvider == null) {
            return null;
        }
        logger.info("Service provider with id:" + id +" -> {} ", serviceProvider);
        ServiceProviderObject serviceProviderObject = new ServiceProviderObject(
                serviceProvider.getId(),
                serviceProvider.getTitle(),
                serviceProvider.getCity(),
                serviceProvider.getCode(),
                serviceProvider.getStars(),
                serviceProvider.getType()
        );
        return serviceProviderObject;
    }

    public void saveServiceProvider(ServiceProviderObject object) {
        ServiceProvider serviceProvider =
                new ServiceProvider(
                        object.getTitle(),
                        object.getCity(),
                        object.getCode(),
                        object.getStars(),
                        object.getType()
                );
        serviceProviderRepo.save(serviceProvider);
    }

    public void deleteById(long id) {
        serviceProviderRepo.deleteById(id);
    }

    public void deleteByTitle(String title) {
        serviceProviderRepo.deleteOneByTitle(title);
    }

    public List<ServiceProviderObject> findAll() {
        return serviceProviderRepo.findAll().stream().map(serviceProvider ->
                new ServiceProviderObject(
                        serviceProvider.getId(),
                        serviceProvider.getTitle(),
                        serviceProvider.getCity(),
                        serviceProvider.getCode(),
                        serviceProvider.getStars(),
                        serviceProvider.getType()
                )).collect(Collectors.toList());
    }

    public void updateServiceProvider(String title, ServiceProviderObject object) {
        ServiceProvider serviceProvider = serviceProviderRepo.findOneByTitle(title);
        if (serviceProvider != null) {
            serviceProvider.setCity(object.getCity());
            serviceProvider.setCode(object.getCode());
            serviceProvider.setStars(object.getStars());
            serviceProvider.setTitle(object.getTitle());
            serviceProvider.setType(object.getType());
        }
    }

    public List<ServiceObject> getAllServices(String title) {
        ServiceProvider serviceProvider = serviceProviderRepo.findOneByTitle(title);
        if (serviceProvider != null) {
            return serviceProvider.getServices().stream().map(service ->
                    new ServiceObject(
                            service.getId(),
                            service.getTitle(),
                            service.getPrice(),
                            service.getDescription(),
                            service.getPicture(),
                            service.getCategory().ordinal())
            ).collect(Collectors.toList());
        }
        return null;
    }

    public void addService(String provider_title, String service_title) {
        Service service = serviceRepo.findOneByTitle(service_title);
        ServiceProvider serviceProvider = serviceProviderRepo.findOneByTitle(provider_title);
        if (service != null && serviceProvider != null) {
            serviceProvider.getServices().add(service);
        }
    }

    public void removeService(String provider_title, String service_title) {
        ServiceProvider serviceProvider = serviceProviderRepo.findOneByTitle(provider_title);
        Service service = serviceRepo.findOneByTitle(service_title);
        if (serviceProvider != null) {
            serviceProvider.getServices().remove(service);
        }
    }

    public List<String> getAllTitle() {
        return serviceProviderRepo.findAll().stream().map(serviceProvider ->
                serviceProvider.getTitle()).collect(Collectors.toList());
    }
}
