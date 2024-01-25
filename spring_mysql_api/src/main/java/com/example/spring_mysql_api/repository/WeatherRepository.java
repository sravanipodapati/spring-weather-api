package com.example.spring_mysql_api.repository;

import com.example.spring_mysql_api.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, String>{
    List<Weather> findByCountryName(String countryName);
}
