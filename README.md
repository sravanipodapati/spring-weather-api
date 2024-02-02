# Spring Weather API

## Introduction

This project is a Spring Boot application that provides weather
information for various countries. It uses MySQL for data storage and
follows a RESTful API architecture.

## Getting Started

### Prerequisites

    - Java 17
    - Maven
    - MySQL
    _ Docker

### Running the Application

1. Cloning the repository didn't worked well for me ,somehow it missed resources file which was important.
2. So, I tried by downloading zipfil it worked well and then added that to the existing repsoitory.


3. Build the application:
   ./mvnw clean install

Run the Application:
./mvnw spring-boot:run

Access the API:
 1.Package model: Weather class
 2.Package Controller:WeatherController class
 3.Package Repository:WeatherRepository class
 4.Package Service:WeatherService Interface
                   WeatherServiceImpl class
                   

## API Endpoints
Postman Tool: With this i have created weather details for 5 countries.
              It satisfies all put, post,get and delete attributes.
Uding Browser: http://localhost:8080/weather (Will give all waether details)    
                http://localhost:8080/api/weather/1(will give weather detail by ID).
                
# Exception handling
-Exception Package: with 3 sub classes
            1.WeatherException
            2.WeatherExceptionHandler
            3.WeatherNotFoundException
  so, when the requested weatherID was not found it gives the below response
   "message": "Requested weatherId does not exist",
    "throwable": null,
    "httpStatus": "NOT_FOUND".
# Custom response handling
-Exception Package: ResponseHandler
so, when the request was sent the response will be in generic way like below
"data":
{"countryId":"1",
 "countryName":"Sweden",
 "city":"Gothenburg",
 "temperature":"1°c",
 "weatherCondition":"Cold and Rainy"},
 "httpStatus":"OK",
 "message":"Requested weather details are given here".
## Data Storage

- The application uses MySQL for data storage.
  Updated application.properties with MySQL configuration.
- In MySQL workbench my schema name is "weather".
- Created a table with name Weather_List which showa all stored weather details

# Unit tests
- Used Junit and Mockito to create and run test driven unit tests.
# BDD
- Implemented BDD by creating feature file with one scenario
- wrote step definitions and run them using a runner class
- pass the scenario successfully.

## Docker Configuration

To run the application using Docker:

1. Make sure you have Docker installed on your machine.
2. Navigate to the project directory
3. docker-compose build
4. docker-compose up -d
5.  docker-compose down

    Access the API :

    - Weather Information:
      http://localhost:8080/weather
    
    - Weather by City ID
      http://localhost:8080/weather/1
## Continuous Integrations
 Did continuous integration with workflow and it was build successfully.

