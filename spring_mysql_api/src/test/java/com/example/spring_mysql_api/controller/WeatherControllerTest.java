package com.example.spring_mysql_api.controller;

import com.example.spring_mysql_api.model.Weather;
import com.example.spring_mysql_api.service.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)

public class WeatherControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WeatherService weatherService;
    Weather weatherOne;
    Weather weatherTwo;
    List<Weather> weatherList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        weatherOne = new Weather("1", "America", "Seattle", "0°c", "Snowy");
        weatherTwo = new Weather("2", "Russia", "Moscow", "-6°c","Cloudy");
        weatherList.add(weatherOne);
        weatherList.add(weatherTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetWeatherDetails() throws Exception {
        when(weatherService.getWeather("1"))
                .thenReturn(weatherOne);
        this.mockMvc.perform(get("/weather/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllWeatherDetails() throws Exception {
        when(weatherService.getAllWeathers())
                .thenReturn(weatherList);
        this.mockMvc.perform(get("/weather"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreateWeatherDetails() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson= ((ObjectWriter) ow).writeValueAsString(weatherOne);

        when(weatherService.createWeather(weatherOne))
                .thenReturn("Success");
        this.mockMvc.perform(post("/weather")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }
    @Test
    void testUpdateWeatherDetails() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(weatherOne);

        when(weatherService.updateWeather(weatherOne))
                .thenReturn("Success");
        this.mockMvc.perform(put("/weather")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testDeleteWeatherDetails() throws Exception{
        when(weatherService.deleteWeather("1"))
                .thenReturn("Success");
        this.mockMvc.perform(delete("/weather/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}

