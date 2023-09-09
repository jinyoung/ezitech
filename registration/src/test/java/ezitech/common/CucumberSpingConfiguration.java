package ezitech.common;

import ezitech.RegistrationApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RegistrationApplication.class })
public class CucumberSpingConfiguration {}
