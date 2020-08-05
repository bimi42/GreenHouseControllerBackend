package com.imi.home.GreenHouseControllerBackend.REST_API.Sensor;

public class SensorNotFoundException extends RuntimeException{
    SensorNotFoundException(Integer id){
        super("Could not find sensor" + id);
    }
}
