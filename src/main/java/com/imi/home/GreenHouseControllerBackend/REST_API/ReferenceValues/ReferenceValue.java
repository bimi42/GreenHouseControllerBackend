package com.imi.home.GreenHouseControllerBackend.REST_API.ReferenceValues;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class ReferenceValue {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    public double getTemperature() {
        return Temperature;
    }

    public void setTemperature(double temperature) {
        Temperature = temperature;
    }

    public double getHumidity() {
        return Humidity;
    }

    public void setHumidity(double humidity) {
        Humidity = humidity;
    }

    private double Temperature;
    private double Humidity;

    public ReferenceValue(double temperature, double humidity) {
        Temperature = temperature;
        Humidity = humidity;
    }

    public ReferenceValue() {
    }
}
