package hooks;


import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hook {

    private TestContext testContext;

    public hook(TestContext context){
        this.testContext = context;
    }
    
    @Before 
    public void launchBrowser() // browserName will hold the value of browser parameter i.e. chrome
    {
      testContext.getDriver().manage().window().maximize();
    }

    @After 
    public void closeBrowser()
    {
        testContext.quitDriver();
    }
}
