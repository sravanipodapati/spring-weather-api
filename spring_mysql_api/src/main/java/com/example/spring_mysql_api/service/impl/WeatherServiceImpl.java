package com.example.spring_mysql_api.service.impl;

import com.example.spring_mysql_api.exception.WeatherNotFoundException;
import com.example.spring_mysql_api.model.Weather;
import com.example.spring_mysql_api.repository.WeatherRepository;
import com.example.spring_mysql_api.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WeatherServiceImpl implements WeatherService{
    private final WeatherRepository weatherRepository;
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
        weatherRepository.deleteById(weatherId);
        return "Success";
    }
    @Override
    public Weather getWeather(String weatherId) {
        if(weatherRepository.findById(weatherId).isEmpty())
            throw new WeatherNotFoundException("Requested weatherId does not exist");
        return weatherRepository.findById(weatherId).get();
    }
    @Override
    public List<Weather> getAllWeathers() {

        return weatherRepository.findAll();
    }
}
