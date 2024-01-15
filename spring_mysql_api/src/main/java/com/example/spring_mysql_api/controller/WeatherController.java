package com.example.spring_mysql_api.controller;

import com.example.spring_mysql_api.model.Weather;
import com.example.spring_mysql_api.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController
{
    WeatherService weatherService;
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    // Read specific weather detail ById from database
    @GetMapping("{countryId}")
     public Weather getWeatherDetails(@PathVariable("countryId") String countryId)
    {
        return weatherService.getWeather(countryId);
    }
    //Read all weather details from database
    @GetMapping()
    public List<Weather> getAllWeatherDetails()
    {
        return weatherService.getAllWeathers();
    }
    @PostMapping
    public String createWeatherDetails(@RequestBody Weather weather)
    {
        weatherService.createWeather(weather);
        return "Weather created successfully";
    }
    @PutMapping
    public String updateWeatherDetails(@RequestBody Weather weather)
    {
        weatherService.updateWeather(weather);
        return "Weather updated successfully";
    }
    @DeleteMapping("{countryId}")
    public String deleteWeatherDetails(@PathVariable("countryId")String countryId)
    {
        weatherService.deleteWeather(countryId);
        return "Weather deleted successfully";
    }
}
