package ezitech.common;

import ezitech.BudgetApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { BudgetApplication.class })
public class CucumberSpingConfiguration {}
