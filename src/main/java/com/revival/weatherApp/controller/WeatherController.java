package com.revival.weatherApp.controller;

import com.revival.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping("/getWeather")
    public String getWeatherData(@RequestParam(value = "city") String city, @RequestParam(value = "units", required = false) String unit) throws IOException {
        weatherService.getWeatherData(city, unit);
        return "displayWeather";
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

}
