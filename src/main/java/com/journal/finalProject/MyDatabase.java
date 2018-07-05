package com.journal.finalProject;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Piotrek on 2018-07-04.
 */
public class MyDatabase {

    @Autowired protected WeatherRepository repository;

    private Logger log;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public MyDatabase(Logger log, WeatherRepository repo) {
        this.log = log;
        repository = repo;
    }

    public void AddWeatherReports(Weather weather) {
        for(WeatherReport report : weather.getWeatherReportList())
        {
            repository.save(report);
        }
    }

    public void fetchAll() {
        log.info("Weather reports found with findAll():");
        log.info("-------------------------------");
        for (WeatherReport report : repository.findAll()) {
            log.info(report.toString());
        }
        log.info("-------------------------------");
        log.info("");
    }

    public void fetchByCity(String city) {
        log.info("Weather reports found with findByCity('" + city + "'):");
        log.info("-------------------------------");
        repository.findByCity(city).forEach(warsaw -> {
            log.info(warsaw.toString());
        });
        log.info("-------------------------------");
        log.info("");
    }
}
