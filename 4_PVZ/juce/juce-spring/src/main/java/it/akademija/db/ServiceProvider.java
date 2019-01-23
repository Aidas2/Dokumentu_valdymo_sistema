package it.akademija.db;

import it.akademija.configs.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String title;
    private String city;
    private long code;
    private double stars;
    @Enumerated(value = EnumType.ORDINAL)
    private Type type;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "services_providers",
            joinColumns = @JoinColumn(name = "provider_id"), inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> services;

    public ServiceProvider(String title, String city, long code, double stars, Type type) {
        this.title = title;
        this.city = city;
        this.code = code;
        this.stars = stars;
        this.type = type;
    }


    public ServiceProvider() {
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ServiceProvider{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", code=" + code +
                ", stars=" + stars +
                ", type=" + type +
                ", services=" + services +
                '}';
    }
}
