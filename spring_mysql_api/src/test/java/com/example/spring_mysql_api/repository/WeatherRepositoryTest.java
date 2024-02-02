package com.example.spring_mysql_api.repository;

import com.example.spring_mysql_api.model.Weather;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
public class WeatherRepositoryTest {
    @Autowired
    private WeatherRepository weatherRepository;
    Weather weather;

    @BeforeEach
    void setup(){
        weather = new Weather("1", "America", "Seattle",
                "0°c", "Snowy");
        weatherRepository.save(weather);
    }
    @AfterEach
    void tearDown(){
        weather = null;
        weatherRepository.deleteAll();

    }
    // Test case Success
    @Test
    void testFindByCountryName_Found()
    {
        List<Weather> weatherList = weatherRepository.findByCountryName("America");
        assertThat(weatherList.get(0).getCountryId()).isEqualTo(weather.getCountryId());
        assertThat(weatherList.get(0).getTemperature()).isEqualTo(weather.getTemperature());
    }
    // Test case Failure
    @Test
    void testFindByCountryName_NotFound()
    {
        List<Weather> weatherList = weatherRepository.findByCountryName("Russia");
        assertThat(weatherList).isEmpty();
    }
}
