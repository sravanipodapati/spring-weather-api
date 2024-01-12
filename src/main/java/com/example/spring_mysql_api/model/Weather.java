package com.example.spring_mysql_api.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="weather_info")
public class Weather
{

    private String Id;
    private String Country;
    private String City;
    private String Temperature;
    private String WeatherCondition;

    public Weather() {
    }
    public Weather(String Id, String Country, String City, String Temperature, String WeatherCondition) {
       this.Id = Id;
       this.Country = Country;
       this.City = City;
       this.Temperature = Temperature;
       this.WeatherCondition = WeatherCondition;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
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
