package com.example.spring_mysql_api.cucumberGlue;

import com.example.spring_mysql_api.model.Weather;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CucumberStepDefinitions {
    @Autowired
    private MockMvc mockMvc;
    private Weather requestWeather;
    private MvcResult response;

    @Given("the user requests weather information for country with ID {string}")
    public void theUserRequestsWeatherInformationForCountryWithID(String countryId) {
        requestWeather = new Weather("1", "Sweden", "Gothenburg", "1Â°c", "Cold and Rainy");
        requestWeather.setCountryId(countryId);
    }

    @When("the request is sent to the {string} endpoint")
    public void whenRequestSent(String endpoint) throws Exception {
        response = mockMvc.perform(MockMvcRequestBuilders.get("/weather/" + requestWeather.getCountryId()))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    @Then("the response status should be {int} OK")
    public void theResponseStatusShouldBeOK(int status) {
        assertThat(response.getResponse().getStatus()).isEqualTo(status);
        assertThat(response.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @And("the response should contain weather details for city {string}")
    public void theResponseShouldContainWeatherDetailsForCity(String cityName) throws Exception {
        String responseContent = response.getResponse().getContentAsString();
        assertThat(responseContent).contains(cityName);
        assertThat(responseContent).contains(requestWeather.getTemperature());
        assertThat(responseContent).contains(requestWeather.getWeatherCondition());
    }
}