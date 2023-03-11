package com.revival.weatherApp.impl;

import com.revival.weatherApp.model.WeatherModel;
import com.revival.weatherApp.service.WeatherService;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public WeatherModel getWeatherData(String city, String unit) {
        return null;
    }
}
