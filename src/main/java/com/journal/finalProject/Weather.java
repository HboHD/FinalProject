package com.journal.finalProject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;


public class Weather {

    static String API_KEY = "7a9cbbef0205f377c465a38e5aaf6696";
    static String LOCATION = "Lodz,pl";
    static String myURL = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+API_KEY+"&units=metric";

    public static Map<String, Object> jsonToMap(String str){
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
    }

    public static String getWeather() {

        String resToFile = "Default";

        try {

            StringBuilder result = new StringBuilder();
            URL url = new URL(myURL);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;


            while ((line = rd.readLine()) != null){
                result.append(line);
            }

            rd.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());

            System.out.println("Current Temp: " + mainMap.get("temp"));
            System.out.print("Current Humidity: " + mainMap.get("humidity"));
            System.out.println("Wind Speed: " + windMap.get("speed"));
            System.out.println("Wind Angle: " + windMap.get("deg"));

            StringBuilder sb = new StringBuilder("");

            sb.append("Current Temp: " + mainMap.get("temp") +"\r\n");
            sb.append("Current Humidity: " + mainMap.get("humidity") + "\r\n");
            sb.append("Wind Speed: " + windMap.get("speed") +"\r\n");
            sb.append("Wind Angle: " + windMap.get("deg") +"\r\n");

            resToFile = sb.toString();

        } catch (IOException e) {
            System.out.print(e.getMessage());
        }

        return resToFile;

    }

}
