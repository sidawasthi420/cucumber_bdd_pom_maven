package stepDefinitions.tariq;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import hooks.tariq.H01_hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD01_registration {

    public static WebDriver driver = H01_hook.driver;

    @Given("^user navigates to url \"([^\"]*)\"$")
    public void user_navigates_to_url(String url) {
        driver.get(url);
    }

    @Given("^user clicks on Join Now button")
    public void user_clicks_on_join_now_button() {
        driver.findElement(By.className("join-now-btn")).click();
    }

    @When("^user successfully navigates to Registration page")
    public void user_successfully_navigates_to_registration_page() {

        String expectedTitle = "Shivoham Automation Expert - Consultancy Services - Course Registration";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Registration page opened successfully");
        }else{
            System.out.println("registration page not opened");
        }
    }

    @When("^user enters the full name as \"([^\"]*)\"$")
    public void user_enters_the_full_name_as(String fullName) {
        driver.findElement(By.id("name")).sendKeys(fullName);
    }

    @When("^user enters the email as \"([^\"]*)\"$")
    public void user_enters_the_email_as(String email) {
        driver.findElement(By.id("email")).sendKeys(email);

    }

    @When("^user enters the phone number as \"([^\"]*)\"$")
    public void user_enters_the_phone_number_as(String phoneNumber) {
        driver.findElement(By.id("phone")).sendKeys(phoneNumber);

    }

    @When("user selects the course from dropdown as \"([^\"]*)\"$")
    public void user_selects_the_course_from_dropdown_as(String dropdownValue) {

        WebElement dropdown = driver.findElement(By.id("course"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(dropdownValue);
    }

    @When("user selects the date as \"([^\"]*)\"$")
    public void user_selects_the_date_as(String date) {
        driver.findElement(By.id("date")).sendKeys(date);

    }

    @When("user clicks on Register Now button")
    public void user_clicks_on_register_now_button() throws InterruptedException {
        driver.findElement(By.id("registrationButton")).click();
        Thread.sleep(5000);
    }

    @Then("user should successfully submit the registration form")
    public void user_should_successfully_submit_the_registration_form() {

        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "Thank you for registering! Our team will reach you for further process.";
        String actualAlertText = alert.getText();
        if (expectedAlertText.equals(actualAlertText)) {
            System.out.println("Registration form Submitted Successfully");
            alert.accept();
        } else {
            System.out.println("Registration form not Submitted");
        }
    }
}