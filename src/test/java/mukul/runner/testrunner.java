package mukul.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/mukul/login.feature",
    glue = {"mukul.stepDefinitions","mukul.hooks"},
    dryRun = false,        
    plugin = {"pretty",
              "html:target/cucumber-report/cucumber_html.html",
              "json:target/cucumber-report/cucumber_json.json",
              "junit:target/cucumber-report/cucumber_junit.junit"
    },
    monochrome = false     
)

public class testrunner extends AbstractTestNGCucumberTests {

}