package com.example.spring_mysql_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="weather_information")
public class Weather
{
    @Id
    private String countryId;
    private String countryName;
    private String City;
    private String Temperature;
    private String WeatherCondition;
    public Weather() {
    }
    public Weather(String countryId, String countryName,String City, String Temperature, String WeatherCondition) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.City = City;
        this.Temperature = Temperature;
        this.WeatherCondition = WeatherCondition;
    }
    public String getCountryId() {
        return countryId;
    }
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
    public String getTemperature() {
        return Temperature;
    }
    public void setTemperature(String temperature) {
        Temperature = temperature;
    }
    public String getWeatherCondition() {
        return WeatherCondition;
    }
    public void setWeatherCondition(String weatherCondition) {
        WeatherCondition = weatherCondition;
    }
}
