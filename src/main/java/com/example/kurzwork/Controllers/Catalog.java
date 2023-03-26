package com.example.kurzwork.Controllers;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String image;
    private String type;
    private String price;
    protected Catalog() {}

    public Catalog(String name, String description, String image, String type, String price) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Catalog[id=%d, name='%s', description='%s', image='%s', type='%s', price='%s',]",
                id, name, description, image, type, price);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    public String getType() {
        return type;
    }
    public String getPrice() {
        return price;
    }
}