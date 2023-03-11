package com.revival.weatherApp.service;

import com.revival.weatherApp.model.WeatherModel;

public interface WeatherService {
    WeatherModel getWeatherData(String city, String unit);
}
