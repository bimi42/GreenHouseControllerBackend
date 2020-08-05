package com.imi.home.GreenHouseControllerBackend.REST_API.Measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path="/api")
public class MeasurementController {
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    MeasurementModelAssembler measurementModelAssembler;


    @GetMapping("/measurements")
    CollectionModel<EntityModel<Measurement>> all(){
        List<EntityModel<Measurement>> measurements = measurementRepository.findAll().stream()
                .map(measurementModelAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(measurements,linkTo(methodOn(MeasurementController.class).all()).withSelfRel());
    }


    @GetMapping("/measurements/{id}")
    EntityModel<Measurement> one(@PathVariable Integer id) {

        Measurement measurement = measurementRepository.findById(id) //
                .orElseThrow(() -> new MeasurementNotFoundException(id));

        return measurementModelAssembler.toModel(measurement);
    }


    @PostMapping("/measurements")
    ResponseEntity<?> newMeasurement(@RequestBody Measurement newMeasurement) {

        EntityModel<Measurement> entityModel = measurementModelAssembler.toModel(measurementRepository.save(newMeasurement));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @PutMapping("/employees/{id}")
    ResponseEntity<?> replaceMeasurement(@RequestBody Measurement newMeasurement, @PathVariable Integer id) {

        Measurement updatedMeasurement = measurementRepository.findById(id) //
                .map(measurement -> {
                    measurement.setDay(newMeasurement.getDay());
                    measurement.setGreenHouseId(newMeasurement.getGreenHouseId());
                    measurement.setSensorId(newMeasurement.getSensorId());
                    measurement.setMinute(newMeasurement.getMinute());
                    measurement.setHour(newMeasurement.getHour());
                    measurement.setMillisecond(newMeasurement.getMillisecond());
                    measurement.setValueT(newMeasurement.getValueT());
                    measurement.setValueH(newMeasurement.getValueH());
                    return measurementRepository.save(measurement);
                }) //
                .orElseGet(() -> {
                    newMeasurement.setId(id);
                    return measurementRepository.save(newMeasurement);
                });

        EntityModel<Measurement> entityModel = measurementModelAssembler.toModel(updatedMeasurement);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }


    @DeleteMapping("/measurements/{id}")
    ResponseEntity<?> deleteMeasurement(@PathVariable Integer id) {

        measurementRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
