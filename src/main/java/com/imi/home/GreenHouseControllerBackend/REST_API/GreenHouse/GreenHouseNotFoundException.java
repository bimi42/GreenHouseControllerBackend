package com.imi.home.GreenHouseControllerBackend.REST_API.GreenHouse;

public class GreenHouseNotFoundException extends RuntimeException{
    GreenHouseNotFoundException(Integer id){
        super("Could not find greenhouse" + id);
    }
}
