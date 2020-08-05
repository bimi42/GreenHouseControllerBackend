package com.imi.home.GreenHouseControllerBackend.REST_API.ReferenceValues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class ReferenceValueController {
    @Autowired
    ReferenceValueRepository referenceValueRepository;

    @GetMapping("/references")
    List<ReferenceValue> one() {
        return referenceValueRepository.findAll();
    }

    @PostMapping("/references")
    ReferenceValue newReferenceValue(@RequestBody ReferenceValue newReferenceValue) {
        referenceValueRepository.deleteAll();
        referenceValueRepository.flush();
        return referenceValueRepository.save(newReferenceValue);
    }
}
