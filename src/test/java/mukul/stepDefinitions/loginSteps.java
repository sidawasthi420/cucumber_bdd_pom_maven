package mukul.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import mukul.context.TestContext;
import mukul.pages.loginPageObject;

public class loginSteps {

    private TestContext testContext;
    private loginPageObject loginPage;

    public loginSteps(TestContext context) {

        this.testContext = context;
        this.loginPage = new loginPageObject(context);
    }

    @Given("^I open the Chrome browser$")
    public void i_open_the_chrome_browser() {

        testContext.getDriver().manage().window().maximize();
    }

    @Given("^I navigate to the login page \"([^\"]*)\"$")
    public void i_navigate_to_the_login_page(String url) {

        loginPage.enterURL(url);
    }

    @When("^I enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_enter_username_and_password(String username, String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("^I click on the Submit button$")
    public void i_click_on_the_submit_button() {

        loginPage.clkLoginbtn();
    }

    @Then("^I should be logged in successfully$")
    public void i_should_be_logged_in_successfully() {

        String actualTitle = testContext.getDriver().getTitle();

        String expectedTitle = "Logged In Successfully | Practice Test Automation";

        if (actualTitle.equals(expectedTitle)) {

            System.out.println("Login Successfully");

        } else {

            System.out.println("Can't Login");
        }
    }
}