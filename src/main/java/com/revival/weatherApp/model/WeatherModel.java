package com.revival.weatherApp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherModel {
    String temperature;
    String pressure;
    String feelsLike;
    String humidity;
}
