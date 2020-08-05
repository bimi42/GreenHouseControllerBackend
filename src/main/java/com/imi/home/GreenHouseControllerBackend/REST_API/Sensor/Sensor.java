package com.imi.home.GreenHouseControllerBackend.REST_API.Sensor;

import javax.persistence.*;

@Entity
public class Sensor {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name;
    private String type;

    public Sensor() {
    }

    public Sensor(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
