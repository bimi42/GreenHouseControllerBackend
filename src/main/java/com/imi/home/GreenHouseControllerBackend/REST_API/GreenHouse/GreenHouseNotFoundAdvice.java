package com.imi.home.GreenHouseControllerBackend.REST_API.GreenHouse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GreenHouseNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(GreenHouseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String greenhouseNotFoundHandler(GreenHouseNotFoundException ex){
        return ex.getMessage();
    }
}
