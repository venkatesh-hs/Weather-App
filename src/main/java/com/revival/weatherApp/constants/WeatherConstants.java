package com.revival.weatherApp.constants;

public interface WeatherConstants {
    String LATITUDE = "latitude";
    String LONGITUDE = "longitude";
    String CITY = "city";
    String JSON_TAG_LATITUDE = "lat";
    String JSON_TAG_LONGITUDE = "lon";
    String API_KEY = "4f9ba7a5af6a3e9fde7f10757ff222d7";
    String CELSIUS = "celsius";

    interface WeatherModel {
        String MAIN = "main";
        String TEMPERATURE = "temp";
        String PRESSURE = "pressure";
        String HUMIDITY = "humidity";
        String FEELS_LIKE = "feels_like";
    }
}
