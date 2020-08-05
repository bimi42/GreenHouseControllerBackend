package com.imi.home.GreenHouseControllerBackend.REST_API.Sensor;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SensorModelAssembler implements RepresentationModelAssembler<Sensor,EntityModel<Sensor>> {
    @Override
    public EntityModel<Sensor> toModel(Sensor entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(SensorController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(SensorController.class).all()).withRel("sensors"));
    }
}
