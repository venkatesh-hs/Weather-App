package com.revival.weatherApp.service;

import com.revival.weatherApp.model.WeatherModel;

import java.io.IOException;
import java.util.Map;

public interface WeatherService {
    WeatherModel getWeatherData(String city, String unit) throws IOException;
    Map<String, Double> getGeoCoordinates(String city);
}
