package it.akademija.controllers;

import it.akademija.objects.ServiceObject;
import it.akademija.objects.ServiceProviderObject;
import it.akademija.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<ServiceObject> getAllService(){
        return serviceService.findAll();
    }

    @GetMapping("/{title}")
    public ServiceObject findOneByTitle(@PathVariable final String title){
        return serviceService.findOneByTitle(title);
    }

    @GetMapping("/filter/{title}")
    public List<ServiceObject> getByTitleContaining(@PathVariable final String title){
        return serviceService.getByTitleContaining(title);
    }

    @PostMapping("/filters")
    public List<ServiceObject> findBySeacrhTitleDescription(@RequestBody String[] filters){
        if(filters[0]==""){
            filters[0] = null;
        }
        if(filters[1] == ""){
            filters[1] = null;
        }
        return serviceService.findBySeacrhTitleDescription(filters[0], filters[1]);
    }

    @PostMapping("/add")
    public void saveService(@RequestBody final ServiceObject object){
        serviceService.saveService(object);
    }

    @PutMapping("/{title}")
    public void updateService(@PathVariable final String title, @RequestBody final ServiceObject object){
        serviceService.updateService(title, object);
    }

    @PutMapping("/{service_title}/{provider_title}")
    public void addProvider(@PathVariable final String service_title, @PathVariable final String provider_title){
        serviceService.addProvider(service_title, provider_title);
    }


    @GetMapping("/{service_title}/all-providers")
    public List<ServiceProviderObject> getAllProviders(@PathVariable final String service_title){
        return serviceService.getAllProviders(service_title);
    }

    @DeleteMapping("/{service_title}")
    public void deleteByTitle(@PathVariable final String service_title){
        serviceService.deleteByTitle(service_title);
    }

    @DeleteMapping("/{service_title}/{provider_title}")
    public void removeProvider(@PathVariable final String service_title, @PathVariable final String provider_title){
        serviceService.removeProvider(service_title, provider_title);
    }


}
