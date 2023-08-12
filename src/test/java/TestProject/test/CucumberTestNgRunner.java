package TestProject.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources",
        glue = "TestProject.test")

public class CucumberTestNgRunner extends AbstractTestNGCucumberTests {





}
