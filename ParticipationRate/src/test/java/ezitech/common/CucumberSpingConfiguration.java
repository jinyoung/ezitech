package ezitech.common;

import ezitech.ParticipationRateApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ParticipationRateApplication.class })
public class CucumberSpingConfiguration {}
