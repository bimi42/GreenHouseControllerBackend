package com.imi.home.GreenHouseControllerBackend.REST_API.GreenHouse;

import javax.persistence.*;

@Entity
public class GreenHouse {
    public GreenHouse() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    private double size;
    public GreenHouse(String name, double size) {
        this.name = name;
        this.size = size;
    }
}
