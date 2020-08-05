package com.imi.home.GreenHouseControllerBackend.RABBITMQ;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    private static final String MY_QUEUE = "greenhouse";

    private static final String MY_EXCHANGE = "greenhouse-exchange";

    @Bean
    Queue myQueue()
    {
        return new Queue(MY_QUEUE,false);
    }

    @Bean
    Exchange myExchange(){
        return new DirectExchange(MY_EXCHANGE);
    }
    @Bean
    Binding binding(){
        return new Binding(MY_QUEUE, Binding.DestinationType.QUEUE,MY_EXCHANGE,"toMobile",null);
    }

}

