package com.imi.home.GreenHouseControllerBackend.REST_API.Measurement;

public class MeasurementNotFoundException extends  RuntimeException{
    MeasurementNotFoundException(Integer id){
        super("Could not find measurement" + id);
    }
}
