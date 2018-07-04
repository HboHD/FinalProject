package com.journal.finalProject;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 2018-07-04.
 */
public class MyDatabase {

    private Logger log;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public MyDatabase(Logger log) {
        this.log = log;
    }

    public void InsertWeatherReport(Weather weather) {
        List<Object[]> parameters = new ArrayList<>();

        for (WeatherReport weatherRep : weather.getWeatherReportList()) {
            parameters.add(new Object[] {weatherRep.getCity(), weatherRep.getTemperature(),
                    weatherRep.getHumidity(), weatherRep.getWindSpeed(), weatherRep.getWindAngle()}
            );
        }
        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO weatherReports(location VARCHAR(255), temperature DECIMAL, humidity DECIMAL, windspeed DECIMAL, windangle DECIMAL)" +
                "VALUES (?,?,?,?,?)", parameters);
    }

    public void CreateDatabase() {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE weatherReports IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE weatherReports(" +
                "location VARCHAR(255), temperature DECIMAL, humidity DECIMAL, windspeed DECIMAL, windangle DECIMAL)");
    }
//
//        // Use a Java 8 stream to print out each tuple of the list
//        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//
//        // Uses JdbcTemplate's batchUpdate operation to bulk load data
//        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
//
//        log.info("Querying for customer records where first_name = 'Josh':");
//        jdbcTemplate.query(
//                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
//                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
//        ).forEach(customer -> log.info(customer.toString()));
    }
