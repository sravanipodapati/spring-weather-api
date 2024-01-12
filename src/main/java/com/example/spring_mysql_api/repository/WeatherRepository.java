package com.example.spring_mysql_api.repository;

import com.example.spring_mysql_api.model.Weather;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    //Creating query method
    Weather findById(String Id);
}
