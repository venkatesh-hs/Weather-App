package com.revival.weatherApp.controller;

import com.revival.weatherApp.constants.WeatherConstants;
import com.revival.weatherApp.impl.WeatherUtils;
import com.revival.weatherApp.model.WeatherModel;
import com.revival.weatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping("/getWeather")
    public String getWeatherData(Model model, @RequestParam(value = "city") String city, @RequestParam(value = "units", required = false) String unit) throws IOException {
        WeatherModel weatherModel = weatherService.getWeatherData(WeatherUtils.trimOffComma(city),
                unit == null || unit.isEmpty() ? WeatherConstants.CELSIUS : WeatherUtils.trimOffComma(unit));
        model.addAttribute("data", weatherModel);
        return "displayWeather";
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

}
