package com.imi.home.GreenHouseControllerBackend.RABBITMQ;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    public Message(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String name;
    private String date;

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
