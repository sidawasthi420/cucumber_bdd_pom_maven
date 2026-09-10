package driverFactory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}