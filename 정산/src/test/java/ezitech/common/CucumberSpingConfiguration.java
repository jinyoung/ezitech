package ezitech.common;

import ezitech.정산Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { 정산Application.class })
public class CucumberSpingConfiguration {}
