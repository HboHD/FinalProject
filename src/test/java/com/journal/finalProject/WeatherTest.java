package com.journal.finalProject;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import static org.junit.Assert.*;

public class WeatherTest {

    @Test
    public void getWeather() {
        Weather weather = new Weather();
        assertNotEquals("Default", weather.getWeather("Lodz,pl"));
    }
}