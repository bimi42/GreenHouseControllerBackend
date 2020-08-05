package com.imi.home.GreenHouseControllerBackend.REST_API.Measurement;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MeasurementModelAssembler implements RepresentationModelAssembler<Measurement, EntityModel<Measurement>> {
    @Override
    public EntityModel<Measurement> toModel(Measurement entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(MeasurementController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(MeasurementController.class).all()).withRel("measurements"));
    }
}
