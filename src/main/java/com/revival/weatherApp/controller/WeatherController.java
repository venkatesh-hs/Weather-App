package com.revival.weatherApp.controller;

import com.revival.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/getWeather")
    public void getWeatherData(@RequestParam(value = "city") String city, @RequestParam(value = "units") String unit) throws IOException {
        weatherService.getWeatherData(city, unit);
    }

}
