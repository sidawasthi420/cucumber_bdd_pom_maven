package yashwin.java.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class login {

    // Create WebDriver object
   public static WebDriver driver = null;

    // Open the Chrome browser
    @Given("^Open the chrome browser$")
    public void openChromeBrowser() {

        driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();
    }

    // Navigate to the URL
    @And("^Navigate to the URL$")
    public void navigateToUrl() {

        driver.get("https://practicetestautomation.com/");
    }
//add waits in the code at all locations 
    // Go to the Practice Page
    @And("^Go to the Practice Page$")
    public void goToPracticePage() {

        // Click on Practice
        driver.findElement(By.xpath("//li[@id='menu-item-20']/a")).click();
    }

    // Go to the Test Login Page
    @And("^Go to the Test Login Page$")
    public void goToTestLoginPage() {

        // Click on Test Login Page
        driver.findElement(By.partialLinkText("Login Page")).click();
    }

    // Enter valid username and password
    @When("^User enters valid Username and Password$")
    public void enterUsernameAndPassword() {

        // Enter username
        driver.findElement(By.id("username")).sendKeys("student");

        // Enter password
        driver.findElement(By.name("password")).sendKeys("Password123");
    }

    // Click on login button
    @And("^Click on login button$")
    public void clickLoginButton() {

        // Click login button
        driver.findElement(By.id("submit")).click();
    }

    // Verify successful login
    @Then("^User should be logged in successfully$")
    public void verifyLogin() {

        // Get current URL
        String currentUrl = driver.getCurrentUrl();

        // Verify login was successful
        Assert.assertTrue(
                currentUrl.contains("logged-in-successfully"),
                "User was not logged in successfully"
        );

        System.out.println("User logged in successfully");
    }

    // Close the browser
    @And("^Close the browser$")
    public void closeBrowser() {

        driver.quit();
    }
}

/*
@Given("Open the chrome browser")
public void open_the_chrome_browser() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Given("Navigate to the URL")
public void navigate_to_the_url() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Given("Go to the Practice Page")
public void go_to_the_practice_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Given("Go to the Test Login Page")
public void go_to_the_test_login_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@When("User enters valid Username and Password")
public void user_enters_valid_username_and_password() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@When("Click on login button")
public void click_on_login_button() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Then("User should be logged in successfully")
public void user_should_be_logged_in_successfully() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Then("Close the browser")
public void close_the_browser() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
} */