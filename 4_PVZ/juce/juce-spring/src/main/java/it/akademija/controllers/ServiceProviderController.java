package it.akademija.controllers;

import it.akademija.objects.ServiceObject;
import it.akademija.objects.ServiceProviderObject;
import it.akademija.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-providers")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @GetMapping
    public List<ServiceProviderObject> getAllServiceProviders(){
        return serviceProviderService.findAll();
    }

    @GetMapping("/titles")
    public List<String> getAllProvidersTitle(){
        return serviceProviderService.getAllTitle();
    }

    @PostMapping("/add")
    public void saveServiceProvider(@RequestBody final ServiceProviderObject object){
        serviceProviderService.saveServiceProvider(object);
    }

    @GetMapping("/{id}")
    public ServiceProviderObject getOneById(@PathVariable final long id){
        return serviceProviderService.getOneById(id);
    }

    @PutMapping("/{title}")
    public void updateServiceProvider(@PathVariable final String title, @RequestBody final ServiceProviderObject object){
        serviceProviderService.updateServiceProvider(title, object);
    }

    @GetMapping("/{title}/all-services")
    public List<ServiceObject> getAllServices(@PathVariable final String title){
        return serviceProviderService.getAllServices(title);
    }

    @PutMapping("/{provider_title}/{service_title}")
    public void addService(@PathVariable final String provider_title, @PathVariable final String service_title){
        serviceProviderService.addService(provider_title, service_title);
    }


    @DeleteMapping("/{provider_title}")
    public void deleteByTitle(@PathVariable final String provider_title){
        serviceProviderService.deleteByTitle(provider_title);
    }

    @DeleteMapping("/{provider_title}/{service_title}")
    public void removeProvider(@PathVariable final String provider_title, @PathVariable final String service_title){
        serviceProviderService.removeService(provider_title, service_title);
    }
}
