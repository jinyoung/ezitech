package ezitech.common;

import ezitech.연구노트Application;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { 연구노트Application.class })
public class CucumberSpingConfiguration {}
