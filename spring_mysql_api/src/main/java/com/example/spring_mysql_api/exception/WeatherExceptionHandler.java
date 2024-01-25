package com.example.spring_mysql_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class WeatherExceptionHandler {
@ExceptionHandler(value={WeatherNotFoundException.class})
    public ResponseEntity<Object> handleWeatherNotFoundException
            (WeatherNotFoundException weatherNotFoundException)
    {
        WeatherException weatherException = new WeatherException(
                weatherNotFoundException.getMessage(),
                weatherNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(weatherException, HttpStatus.NOT_FOUND);
    }
}
