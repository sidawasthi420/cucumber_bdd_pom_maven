package hooks.tariq;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class H02_hook {

    @Before
    public void launchBrowser() {

        String browserName = "chrome";
        WebDriver driver = null;

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        DriverFactory.setDriver(driver);
    }

    @After
    public void closeBrowser() {
        DriverFactory.quitDriver();
    }
}