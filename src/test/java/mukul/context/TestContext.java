package mukul.context;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestContext {

    private WebDriver driver;

    public TestContext(){
        if(driver == null){
            String browserName = "chrome";
            if (browserName.equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("ie")) {
                driver = new InternetExplorerDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}