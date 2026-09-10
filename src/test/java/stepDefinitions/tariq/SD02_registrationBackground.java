package stepDefinitions.tariq;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD02_registrationBackground {

    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(10));

    @Given("^user navigates to url \"([^\"]*)\"$")
    public void user_navigates_to_url(String url) {
        DriverFactory.getDriver().get(url);
        String expectedTitle = "Shivoham Automation Expert - Consultancy Services";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = DriverFactory.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page Not Opened");
        System.out.println("URL opened: " + url);
    }

    @And("^user clicks on Join Now button")
    public void user_clicks_on_join_now_button() {
        WebElement joinNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("join-now-btn")));
        joinNowButton.click();
        System.out.println("Join Now button clicked");
    }

    @When("^user successfully navigates to Registration page")
    public void user_successfully_navigates_to_registration_page() {
        String expectedTitle = "Shivoham Automation Expert - Consultancy Services - Course Registration";
        String actualTitle = DriverFactory.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page Not Opened");
        System.out.println("Registration page opened successfully");
    }

    @And("^user enters the full name as \"([^\"]*)\"$")
    public void user_enters_the_full_name_as(String fullName) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        nameField.sendKeys(fullName);
        System.out.println("Full Name: " + fullName);
    }

    @And("^user enters the email as \"([^\"]*)\"$")
    public void user_enters_the_email_as(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys(email);
        System.out.println("Email: " + email);
    }

    @And("^user enters the phone number as \"([^\"]*)\"$")
    public void user_enters_the_phone_number_as(String phone) {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
        phoneField.sendKeys(phone);
        System.out.println("Phone: " + phone);
    }

    @And("^user selects the course from dropdown as \"([^\"]*)\"$")
    public void user_selects_the_course_from_dropdown_as(String course) {
        WebElement courseDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("course")));
        Select select = new Select(courseDropdown);
        select.selectByVisibleText(course);
        System.out.println("Course: " + course);
    }

    @And("^user selects the date as \"([^\"]*)\"$")
    public void user_selects_the_date_as(String date) {
        WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date")));
        dateField.sendKeys(date);
        System.out.println("Date: " + date);
    }

    @And("^user prints the registration data given below")
    public void user_prints_the_registration_data_given_below(DataTable userData) {

        List<List<String>> userInfo = userData.asLists();
        for (int i = 0; i < userInfo.size(); i++) {
            for (int j = 0; j < userInfo.get(i).size(); j++) {
                System.out.print(userInfo.get(i).get(j) + "  ");
            }
        }
    }

    @And("^user clicks on Register Now button")
    public void user_clicks_on_register_now_button(){
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("registrationButton")));
        registerButton.click();
        System.out.println("Register Now button clicked");
    }

    @Then("^user should successfully submit the registration form")
    public void user_should_successfully_submit_the_registration_form() {
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = DriverFactory.getDriver().switchTo().alert();
        String actualAlertText = alert.getText();
        String expectedAlertText ="Thank you for registering! Our team will reach you for further process.";
        Assert.assertEquals(actualAlertText, expectedAlertText, "Registration form submission failed");
        alert.accept();
    }
}