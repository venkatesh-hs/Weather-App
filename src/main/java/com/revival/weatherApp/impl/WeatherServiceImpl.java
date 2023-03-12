package com.revival.weatherApp.impl;

import com.revival.weatherApp.constants.WeatherConstants;
import com.revival.weatherApp.model.WeatherModel;
import com.revival.weatherApp.service.WeatherService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    OkHttpClient client;
    Response response;

    @Override
    public WeatherModel getWeatherData(String city, String unit) {
        client = new OkHttpClient();
        Map<String, Double> coordinates = getGeoCoordinates(city);
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?lat=" + coordinates.get(WeatherConstants.LATITUDE) + "&lon=" + coordinates.get(WeatherConstants.LONGITUDE) + "&appid=" + WeatherConstants.API_KEY)
                .build();
        try {
            response = client.newCall(request).execute();
            return extractRequiredData(new JSONObject(response.body().toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private WeatherModel extractRequiredData(JSONObject jsonObject) {
        return null;
    }

    @Override
    public Map<String, Double> getGeoCoordinates(String city) {
        client = new OkHttpClient();
        Map<String, Double> coordinates;
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/geo/1.0/direct?q=" + WeatherConstants.CITY + "&limit=1&appid=" + WeatherConstants.API_KEY)
                .build();
        try {
            response = client.newCall(request).execute();
            coordinates = extractGeoCoordinates(new JSONArray(response.body().toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return coordinates;
    }

    private Map<String, Double> extractGeoCoordinates(JSONArray jsonArray) {
        Map<String, Double> coordinates = new HashMap<>();
        JSONObject location = jsonArray.getJSONObject(0);
        coordinates.put(WeatherConstants.LATITUDE, (Double) location.get(WeatherConstants.JSON_TAG_LATITUDE));
        coordinates.put(WeatherConstants.LONGITUDE, (Double) location.get(WeatherConstants.JSON_TAG_LONGITUDE));
        return coordinates;
    }
}
