package p04_cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/p04_cucumber",
        glue = "p04_cucumber.steps",
        plugin = {"pretty"}
)
public class P04_CucumberRunner extends AbstractTestNGCucumberTests {

}