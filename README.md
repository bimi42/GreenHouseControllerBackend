# GreenHouseControllerBackend
Backend for ESP8266 controlled greenhouse.

To use you need a docker-compose file, for the full infrastructure.

It has 3 component:

- RabbitMQ for messaging (post message, when the upload to the backend service is complete).

- MySQL database in a docker container, for the storage (you can dump the database).

- SpringBoot app for the backend service.

These are the components at the software side.

Hardware side:

- Wifi capable card with DHT11- DHT22 humidity/temperate sensor

I use the ESP8266 in the NodeMCU version (3.0). The card polling the temperature and the humidity, then write in a EEPROM storage (you can send the data immediately). 
In each week (at saturday) the card should send the data to the backend component, if this was successful the rabbitmq component send a message to the client (in my case an android application).

