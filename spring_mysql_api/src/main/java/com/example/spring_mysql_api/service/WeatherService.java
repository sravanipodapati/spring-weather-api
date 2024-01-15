package com.example.spring_mysql_api.service;

import com.example.spring_mysql_api.model.Weather;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WeatherService {
    public String createWeather(Weather weather);
    public String updateWeather(Weather weather);
    public String deleteWeather(String weatherId);
    public Weather getWeather(String weatherId);
    public List<Weather>getAllWeathers();
}
