package com.example.kurzwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Karysel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String img;
    protected Karysel() {}

    public Karysel(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return String.format(
                "Karysel[id=%d, img='%s']",
                id, img);
    }

    public Long getId() {
        return id;
    }

    public String getImg() {
        return img;
    }
}