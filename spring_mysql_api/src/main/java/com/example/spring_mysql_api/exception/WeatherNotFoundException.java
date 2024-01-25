package com.example.spring_mysql_api.exception;

public class WeatherNotFoundException extends RuntimeException{

    public WeatherNotFoundException(String message) {
        super(message);
    }

    public WeatherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
