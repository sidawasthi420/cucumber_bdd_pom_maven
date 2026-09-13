package yashwin.StructurePractice.java.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/yashwin/StructurePractice/resources/features/login.feature",
        glue = {
            "yashwin.StructurePractice.java.stepDefinitions",
            "yashwin.StructurePractice.java.hooks"
        },
        dryRun = false,
        plugin = {
            "pretty",
            "html:target/cucumber-report/cucumber_html.html",
            "json:target/cucumber-report/cucumber_json.json",
            "junit:target/cucumber-report/cucumber_junit.junit"
        },
        monochrome = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}