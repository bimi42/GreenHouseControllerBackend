package com.imi.home.GreenHouseControllerBackend.REST_API;

import com.imi.home.GreenHouseControllerBackend.RABBITMQ.Message;
import com.imi.home.GreenHouseControllerBackend.REST_API.Measurement.Measurement;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping(path="/api")
public class Success {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/success")
    HttpStatus succes(@RequestParam Integer count) {
        if(count > 0 )
        {
            rabbitTemplate.convertAndSend("greenhouse-exchange","toMobile",new Message("Simple Message", LocalDate.now().toString()));
            System.out.println("Message sent!");
            return HttpStatus.OK;
        }
        else
        {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
