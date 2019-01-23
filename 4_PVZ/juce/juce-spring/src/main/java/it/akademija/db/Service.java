package it.akademija.db;

import it.akademija.configs.Category;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(unique = true)
    private String title;
    private double price;
    private String description;
    private String picture;
    @Enumerated(EnumType.ORDINAL)
    private Category category;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "services_providers",
            joinColumns = @JoinColumn(name = "service_id"), inverseJoinColumns = @JoinColumn(name = "provider_id")
    )
    private Set<ServiceProvider> serviceProviders;

    public Service(String title, double price, String description, String picture, Category category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.picture = picture;
        this.category = category;
    }

    public Service() {
    }

    public Set<ServiceProvider> getServiceProviders() {
        return serviceProviders;
    }

    public void setServiceProviders(Set<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
