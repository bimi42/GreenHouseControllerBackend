package com.imi.home.GreenHouseControllerBackend.REST_API.Measurement;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Measurement {
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    public Measurement(){
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(int millisecond) {
        this.millisecond = millisecond;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int day;
    private int hour;
    private int minute;
    private int millisecond;
    public Measurement(Integer greenHouseId, Integer sensorId, double valueT, double valueH,int day,  int hour, int minute, int millisecond) {
        this.day = day;
        this.greenHouseId = greenHouseId;
        this.sensorId = sensorId;
        this.valueT = valueT;
        this.valueH = valueH;
        this.hour = hour;
        this.minute = minute;
        this.millisecond = millisecond;
    }
    public double getValueT() {
        return valueT;
    }

    public void setValueT(double valueT) {
        this.valueT = valueT;
    }
    public double getValueH() {
        return valueH;
    }

    public void setValueH(double valueH) {
        this.valueH = valueH;
    }

    public Integer getGreenHouseId() {
        return greenHouseId;
    }

    public void setGreenHouseId(Integer greenHouseId) {
        this.greenHouseId = greenHouseId;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    private Integer greenHouseId;

    private Integer sensorId;

    private double valueT;
    private double valueH;
}
