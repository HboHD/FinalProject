package com.journal.finalProject;

/**
 * Created by Piotrek on 2018-07-04.
 */
public class WeatherReport {

    private static String city;
    private static Double temperature, humidity, windSpeed, windAngle;


    public static String getCity() {
        return city;
    }

    public static Double getTemperature() {
        return temperature;
    }

    public static Double getHumidity() {
        return humidity;
    }

    public static Double getWindSpeed() {
        return windSpeed;
    }

    public static Double getWindAngle() {
        return windAngle;
    }


    public WeatherReport()
    {

    }

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
                "Weather[location='%s' temp=%d, humidity=%d, windSpeed=%d, windAngle=%d]",
                city, temperature, humidity, windSpeed, windAngle);
    }
}
