package ezitech.common;

import ezitech.집행Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { 집행Application.class })
public class CucumberSpingConfiguration {}
