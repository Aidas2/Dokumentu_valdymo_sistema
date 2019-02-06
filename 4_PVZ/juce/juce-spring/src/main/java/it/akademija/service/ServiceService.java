package it.akademija.service;

import it.akademija.configs.Category;
import it.akademija.db.Service;
import it.akademija.db.ServiceProvider;
import it.akademija.objects.ServiceObject;
import it.akademija.objects.ServiceProviderObject;
import it.akademija.repositories.ServiceProviderRepo;
import it.akademija.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@Transactional
public class ServiceService {

    @Autowired
    private ServiceRepo serviceRepo;
    @Autowired
    private ServiceProviderRepo serviceProviderRepo;

    public ServiceService(ServiceRepo serviceRepo, ServiceProviderRepo serviceProviderRepo) {
        this.serviceRepo = serviceRepo;
        this.serviceProviderRepo = serviceProviderRepo;
    }

    public ServiceObject findOneById(long id) {
        Service service = serviceRepo.findById(id).orElse(null);
        if (service == null) {
            return null;
        }
        ServiceObject serviceObject =
                new ServiceObject(
                        service.getId(), service.getTitle(), service.getPrice(), service.getDescription(), service.getPicture(), service.getCategory().ordinal());

        return serviceObject;
    }

    public ServiceObject findOneByTitle(String title) {
        Service service = serviceRepo.findOneByTitle(title);
        if (service == null) {
            return null;
        }
        ServiceObject serviceObject =
                new ServiceObject(
                        service.getId(), service.getTitle(), service.getPrice(), service.getDescription(), service.getPicture(), service.getCategory().ordinal());

        return serviceObject;
    }

    public void saveService(ServiceObject serviceObject) {
        Service service =
                new Service(
                        serviceObject.getTitle(),
                        serviceObject.getPrice(),
                        serviceObject.getDescription(),
                        serviceObject.getPicture(),
                        Category.values()[serviceObject.getCategory()]);
        serviceRepo.save(service);
    }

    public void deleteById(long id) {
        serviceRepo.deleteById(id);
    }

    public void deleteByTitle(String title) {
        serviceRepo.deleteOneByTitle(title);
    }

    public List<ServiceObject> findAll() {
        return convert(serviceRepo.findAll());
    }

    public List<ServiceObject> getByTitleContaining(String title) {

        return convert(serviceRepo.getByTitleContaining(title));

//        return serviceRepo.getByTitleContaining(title).stream().map(service ->
//                new ServiceObject(service.getId(),
//                        service.getTitle(),
//                        service.getPrice(),
//                        service.getDescription(),
//                        service.getPicture(),
//                        service.getCategory().ordinal())).collect(Collectors.toList());
    }

    public List<ServiceObject> findBySeacrhTitleDescription(String title, String description) {
        return convert(serviceRepo.findBySeacrhTitleDescription(title, description));
    }

    public void updateService(String title, ServiceObject object) {
        Service service = serviceRepo.findOneByTitle(title);
        if (service != null) {
            service.setCategory(Category.values()[object.getCategory()]);
            service.setDescription(object.getDescription());
            service.setPicture(object.getPicture());
            service.setPrice(object.getPrice());
            service.setTitle(object.getTitle());
        }
    }

    public void addProvider(String service, String provider) {
        Service s = serviceRepo.findOneByTitle(service);
        ServiceProvider sp = serviceProviderRepo.findOneByTitle(provider);

        if (s != null && sp != null) {
            s.getServiceProviders().add(sp);
        }
    }

    public List<ServiceProviderObject> getAllProviders(String title) {
        Service service = serviceRepo.findOneByTitle(title);
        if (service != null) {
            return service.getServiceProviders().stream().map(serviceProvider ->
                    new ServiceProviderObject(
                            serviceProvider.getId(),
                            serviceProvider.getTitle(),
                            serviceProvider.getCity(),
                            serviceProvider.getCode(),
                            serviceProvider.getStars(),
                            serviceProvider.getType())
            ).collect(Collectors.toList());
        }
        return null;
    }

    public void removeProvider(String service_title, String provider_title) {
        Service service = serviceRepo.findOneByTitle(service_title);
        ServiceProvider serviceProvider = serviceProviderRepo.findOneByTitle(provider_title);
        if (service != null) {
            service.getServiceProviders().remove(serviceProvider);
        }
    }

    List<ServiceObject> convert(Collection<Service> services) {
        return services.stream().map(service ->
                new ServiceObject(
                        service.getId(),
                        service.getTitle(),
                        service.getPrice(),
                        service.getDescription(),
                        service.getPicture(),
                        service.getCategory().ordinal())).collect(Collectors.toList());
    }
}
