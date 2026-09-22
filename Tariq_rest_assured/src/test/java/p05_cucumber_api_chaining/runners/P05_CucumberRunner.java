package p05_cucumber_api_chaining.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features/p05_cucumber_api_chaining",
        glue = "p05_cucumber_api_chaining.steps",
        plugin = {"pretty"}

)

public class P05_CucumberRunner extends AbstractTestNGCucumberTests {

}