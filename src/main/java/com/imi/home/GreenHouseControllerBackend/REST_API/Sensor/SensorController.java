package com.imi.home.GreenHouseControllerBackend.REST_API.Sensor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
@RestController
@RequestMapping(path="/api")
public class SensorController {
    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    SensorModelAssembler sensorModelAssembler;

    @GetMapping("/sensors")
    CollectionModel<EntityModel<Sensor>> all(){
        List<EntityModel<Sensor>> sensors = sensorRepository.findAll().stream()
                .map(sensorModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(sensors,linkTo(methodOn(SensorController.class).all()).withSelfRel());
    }
    @GetMapping("/sensors/{id}")
    EntityModel<Sensor> one(@PathVariable Integer id) {

        Sensor sensor = sensorRepository.findById(id) //
                .orElseThrow(() -> new SensorNotFoundException(id));

        return sensorModelAssembler.toModel(sensor);
    }
}
