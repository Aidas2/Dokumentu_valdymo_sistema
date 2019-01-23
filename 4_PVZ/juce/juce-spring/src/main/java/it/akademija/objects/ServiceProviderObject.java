package it.akademija.objects;

import it.akademija.configs.Type;

public class ServiceProviderObject {

    private long id;
    private String title;
    private String city;
    private long code;
    private double stars;
    private Type type;

    public ServiceProviderObject(long id, String title, String city, long code, double stars, Type type) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.code = code;
        this.stars = stars;
        this.type = type;
    }

    public ServiceProviderObject() {
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
        return "ServiceProviderObject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", code=" + code +
                ", stars=" + stars +
                ", type=" + type +
                '}';
    }
}
