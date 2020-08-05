package com.imi.home.GreenHouseControllerBackend;

import com.imi.home.GreenHouseControllerBackend.REST_API.GreenHouse.GreenHouse;
import com.imi.home.GreenHouseControllerBackend.REST_API.GreenHouse.GreenHouseRepository;
import com.imi.home.GreenHouseControllerBackend.REST_API.Measurement.Measurement;
import com.imi.home.GreenHouseControllerBackend.REST_API.Measurement.MeasurementRepository;
import com.imi.home.GreenHouseControllerBackend.REST_API.ReferenceValues.ReferenceValue;
import com.imi.home.GreenHouseControllerBackend.REST_API.ReferenceValues.ReferenceValueRepository;
import com.imi.home.GreenHouseControllerBackend.REST_API.Sensor.Sensor;
import com.imi.home.GreenHouseControllerBackend.REST_API.Sensor.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    @Autowired
    GreenHouseRepository ghrepo;

    @Autowired
    MeasurementRepository repository;

    @Autowired
    ReferenceValueRepository rvrepo;

    @Autowired
    SensorRepository srepo;

    @Bean
    CommandLineRunner initDatabase()
    {
        return args -> {
            System.out.println("Preloading" + rvrepo.save(new ReferenceValue(11.2,22.1)));
            System.out.println("Preloading" + ghrepo.save(new GreenHouse("Keltető", 23)));
            System.out.println("Preloading" + ghrepo.save(new GreenHouse("Terrárium",11.9)));
            System.out.println("Preloading" + srepo.save(new Sensor("DHT22","Hőmérséklet és Páratartalom")));
            System.out.println("Preloading" + repository.save(new Measurement(2,1,11.2,30,20,13,24,56)));
        };
    }
}
