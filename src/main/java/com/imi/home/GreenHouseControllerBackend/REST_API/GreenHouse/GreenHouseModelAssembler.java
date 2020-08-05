package com.imi.home.GreenHouseControllerBackend.REST_API.GreenHouse;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class GreenHouseModelAssembler implements RepresentationModelAssembler<GreenHouse,EntityModel<GreenHouse>> {
    @Override
    public EntityModel<GreenHouse> toModel(GreenHouse entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(GreenHouseController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(GreenHouseController.class).all()).withRel("measurements"));
    }
}
