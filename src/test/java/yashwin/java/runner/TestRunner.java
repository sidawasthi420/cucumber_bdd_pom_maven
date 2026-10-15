package yashwin.java.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/yashwin/resources/features/login.feature",
    glue = "yashwin.java.stepDefinitions",
    plugin = { "pretty" }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
