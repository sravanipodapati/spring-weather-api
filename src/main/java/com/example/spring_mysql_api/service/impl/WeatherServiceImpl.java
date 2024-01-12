package com.example.spring_mysql_api.service.impl;

import com.example.spring_mysql_api.model.Weather;
import com.example.spring_mysql_api.repository.WeatherRepository;
import com.example.spring_mysql_api.service.WeatherService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class WeatherServiceImpl implements WeatherService {

    WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public String createWeather(Weather weather) {
        weatherRepository.save(weather);
        return "Success";
    }
    @Override
    public String updateWeather(Weather weather) {
        weatherRepository.save(weather);
        return "Success";
    }
    @Override
    public String deleteWeather(String weatherId) {
        weatherRepository.deleteById(Long.valueOf(weatherId));
        return "Success";
    }
    @Override
    public Weather getWeather(String weatherId) {
        return weatherRepository.findById(Long.valueOf(weatherId)).get();
    }

    @Override
    public List<Weather> getAllWeathers() {
        return weatherRepository.findAll();
    }
}
