package ezitech.common;

import ezitech.RndNotesApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RndNotesApplication.class })
public class CucumberSpingConfiguration {}
