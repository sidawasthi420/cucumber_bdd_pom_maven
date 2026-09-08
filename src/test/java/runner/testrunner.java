package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/login_common_step_scenario_outline.feature",
    glue = {"stepDefinitions","hooks"},
    dryRun = false,        //true :- Cucumber checks the mapping and reports missing snippets with launching tests
    plugin = {"pretty",
              "html:target/cucumber-report/cucumber_html.html",
              "json:target/cucumber-report/cucumber_json.json",
              "junit:target/cucumber-report/cucumber_junit.junit"
    },
    monochrome = false     //Converts console output to readable plain text   (Disables colors)
)

public class testrunner extends AbstractTestNGCucumberTests {

}