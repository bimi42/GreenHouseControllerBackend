package com.imi.home.GreenHouseControllerBackend.REST_API.GreenHouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@RestController
@RequestMapping(path="/api")
public class GreenHouseController {
    @Autowired
    GreenHouseRepository greenHouseRepository;

    @Autowired
    GreenHouseModelAssembler greenHouseModelAssembler;

    @GetMapping("/greenhouses")
    CollectionModel<EntityModel<GreenHouse>> all(){
        List<EntityModel<GreenHouse>> greenhouses = greenHouseRepository.findAll().stream()
                .map(greenHouseModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(greenhouses,linkTo(methodOn(GreenHouseController.class).all()).withSelfRel());
    }


    @GetMapping("/greenhouses/{id}")
    EntityModel<GreenHouse> one(@PathVariable Integer id) {

        GreenHouse greenHouse = greenHouseRepository.findById(id) //
                .orElseThrow(() -> new GreenHouseNotFoundException(id));

        return greenHouseModelAssembler.toModel(greenHouse);
    }
}
