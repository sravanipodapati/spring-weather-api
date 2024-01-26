package com.example.spring_mysql_api.service.impl;

import com.example.spring_mysql_api.model.Weather;
import com.example.spring_mysql_api.repository.WeatherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherServiceImplTest {
    @Mock
    private WeatherRepository weatherRepository;
    private WeatherServiceImpl weatherService;
    @BeforeEach
    void setUp() {
        weatherRepository = mock(WeatherRepository.class);
        weatherService = new WeatherServiceImpl(weatherRepository);
    }
    @AfterEach
    void tearDown() throws Exception{

    }

    @Test
    void testCreateWeather() {
        weatherService = new WeatherServiceImpl(weatherRepository);
        Weather weather = new Weather("1", "America", "Seattle", "0°c","Snowy");

        when(weatherRepository.save(weather)).thenReturn(weather);
        assertThat(weatherService.createWeather(weather)).isEqualTo("Success");
    }

    @Test
    void testUpdateWeather() {
        weatherService = new WeatherServiceImpl(weatherRepository);
        Weather weather = new Weather("1", "America", "Seattle", "0°c","Snowy");

        when(weatherRepository.save(weather)).thenReturn(weather);
        assertThat(weatherService.updateWeather(weather)).isEqualTo("Success");
    }

    @Test
    void testDeleteWeather() {
        weatherService = new WeatherServiceImpl(weatherRepository);

        assertThat(weatherService.deleteWeather("1")).isEqualTo("Success");
        Mockito.verify(weatherRepository).deleteById("1");

    }

    @Test
    void testGetWeather() {
        weatherService = new WeatherServiceImpl(weatherRepository);
        Weather weather = new Weather("1", "America", "Seattle", "0°c", "Snowy");

        when(weatherRepository.findById("1")).thenReturn(Optional.of(weather));
        assertThat(weatherService.getWeather("1").getCountryName()).isEqualTo("America");

    }
    @Test
    void testGetAllWeathers() {
        weatherService = new WeatherServiceImpl(weatherRepository);
        Weather weather = new Weather("1", "America", "Seattle", "0°c","Snowy");
        when(weatherRepository.findAll()).thenReturn(List.of(weather));

        assertThat(weatherService.getAllWeathers()).hasSize(1);
        assertThat(weatherService.getAllWeathers().get(0).getWeatherCondition()).isEqualTo("Snowy");
    }

}