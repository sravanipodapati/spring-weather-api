package com.example.spring_mysql_api.cucumberGlue;
import com.example.spring_mysql_api.SpringMysqlApiApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        glue = "com.example.spring_mysql_api.cucumberGlue",
        plugin = {"pretty", "html:target/cucumber"})
@CucumberContextConfiguration
@SpringBootTest(classes = SpringMysqlApiApplication.class)
@AutoConfigureMockMvc
public class CucumberSpringIntegrationTest {
}
