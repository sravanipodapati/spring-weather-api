package com.example.spring_mysql_api.controller;

import com.example.spring_mysql_api.model.Weather;
import com.example.spring_mysql_api.repository.WeatherRepository;
import com.example.spring_mysql_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")

public class WeatherController
{
    @Autowired
    private WeatherRepository repository;
    @Autowired
    WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    //Read Specific Weather Details from DataBase
    @GetMapping("{Id}")
    public Weather getWeatherDetails(@PathVariable("Id") String Id)
    {
        Weather weather=repository.findById(Id);
        return  weatherService.getWeather(Id);
    }
    //Read All Weather Details from dataBase
    @GetMapping()
    public List<Weather> getAllWeatherDetails()
    {
        return  weatherService.getAllWeathers();
    }
    @PostMapping
    public String createWeatherDetails(@RequestBody Weather weather)
    {
        weatherService.createWeather(weather);
        return "Weather created Successfully";
    }
    @PutMapping
    public String updateWeatherDetails(@RequestBody Weather weather)
    {
        weatherService.updateWeather(weather);
        return "Weather updated Successfully";
    }
    @DeleteMapping("{Id}")
    public String deleteWeatherDetails(@PathVariable("Id") String Id)
    {
        weatherService.deleteWeather(Id);
        return "Weather deleted Successfully";
    }

}
