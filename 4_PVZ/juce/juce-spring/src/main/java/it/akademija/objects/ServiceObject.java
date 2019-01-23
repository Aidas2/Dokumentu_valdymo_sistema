package it.akademija.objects;

import it.akademija.configs.Category;

public class ServiceObject {

    private long id;
    private String title;
    private double price;
    private String description;
    private String picture;
    private int category;

    public ServiceObject(long id, String title, double price, String description, String picture, int category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.picture = picture;
        this.category = category;
    }

    public ServiceObject() {
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
