package com.journal.finalProject;

import javax.persistence.*;

/**
 * Created by Piotrek on 2018-07-04.
 */
@Entity
public class WeatherReport {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private String city;
    private Double temperature, humidity, windSpeed, windAngle;

    public Long getId() {
        return id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindAngle(Double windAngle) {
        this.windAngle = windAngle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Double getWindAngle() {
        return windAngle;
    }


    protected WeatherReport() {}

    public WeatherReport(String loc, Double temp,Double hum, Double speed,Double angle)
    {
    temperature = temp;
    city = loc;
    humidity = hum;
    windAngle = angle;
    windSpeed = speed;
    }


    @Override
    public String toString() {
        return String.format(
                "Weather[id=%d, location='%s' temp=%.02f, humidity=%.02f, windSpeed=%.02f, windAngle=%.02f]",
                id, city, temperature, humidity, windSpeed, windAngle);
    }
}
